package ro.siit.airport.service;
import ro.siit.airport.model.RegisterDto;

public interface RegisterService {

    boolean saveUser(RegisterDto registerDto);

}
