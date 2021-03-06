package ro.siit.airport.service;

import ro.siit.airport.model.RegisterDto;

import java.util.Optional;

public interface RegisterService {

    boolean saveUser(final RegisterDto registerDto);
    Optional<RegisterDto> findByEmail(final String email);
}
