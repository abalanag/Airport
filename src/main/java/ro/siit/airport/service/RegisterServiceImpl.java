package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.User;
import ro.siit.airport.domain.UserRole;
import ro.siit.airport.model.RegisterDto;
import ro.siit.airport.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

}
