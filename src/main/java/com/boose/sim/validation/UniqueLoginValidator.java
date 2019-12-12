package com.boose.sim.validation;

import com.boose.sim.repository.UsersRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

    private UsersRepository usersRepository;

    public UniqueLoginValidator(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void initialize(UniqueLogin constraint) {
    }

    public boolean isValid(String username, ConstraintValidatorContext context) {
        return username != null && !usersRepository.findFirstByUsername(username).isPresent();
    }

}