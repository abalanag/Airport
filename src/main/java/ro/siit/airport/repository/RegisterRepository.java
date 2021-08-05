package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.airport.domain.User;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
