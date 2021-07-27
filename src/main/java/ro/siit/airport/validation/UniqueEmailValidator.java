package ro.siit.airport.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ro.siit.airport.service.RegisterService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private RegisterService registerService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return registerService.findByEmail(value).isEmpty();
    }
}
