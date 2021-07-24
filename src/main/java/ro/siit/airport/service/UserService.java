package ro.siit.airport.service;

import ro.siit.airport.model.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> findById(Long id);

    Optional<UserDto> findByEmail(String email);
}
