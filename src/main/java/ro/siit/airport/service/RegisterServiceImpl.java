package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.User;
import ro.siit.airport.domain.UserRole;
import ro.siit.airport.model.RegisterDto;
import ro.siit.airport.repository.RegisterRepository;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RegisterRepository registerRepository;


    @Override
    public boolean saveUser(final RegisterDto registerDto) {
        final User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setRole(UserRole.USER);
        final User savedUser = registerRepository.save(user);
        return (savedUser.getId() != null);
    }

    @Override
    public Optional<RegisterDto> findByEmail(final String email) {
        return registerRepository.findByEmail(email)
                .map(m -> new RegisterDto(m.getEmail(), m.getPassword(), m.getFirstName(), m.getLastName()));
    }

}
