package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.siit.airport.validation.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    @NotBlank(message = "You must insert an Email!")
    @Email(message = "You must insert and valid Email!")
    @UniqueEmail
    private String email;

    @NotBlank(message = "You must insert your First Name!")
    private String firstName;

    @NotBlank(message = "You must insert your Last Name!")
    private String lastName;

    @NotBlank(message = "You must insert a Password!")
    private String password;

}
