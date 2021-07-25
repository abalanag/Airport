package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.airport.domain.User;

public interface RegisterRepository extends JpaRepository<User, Long> {
}
