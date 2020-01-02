package com.swiftacademy.bioshop.controllers;

import com.swiftacademy.bioshop.DTO.UserRegistrationDto;
import com.swiftacademy.bioshop.model.Person;
import com.swiftacademy.bioshop.model.User;
import com.swiftacademy.bioshop.repositories.PersonRepository;
import com.swiftacademy.bioshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    private Person registration(@RequestBody UserRegistrationDto userRegistrationDto) {
        User existingUser = userRepository.findUserByUserEmail(userRegistrationDto.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException(String.format("User with email: %s is already existing", userRegistrationDto.getEmail()));
        }

        User user = new User();
        user.setUserEmail(userRegistrationDto.getEmail());
        user.setPassword(userRegistrationDto.getPassword());
        user = userRepository.save(user);

        Person person = new Person();
        person.setFirstName(userRegistrationDto.getFirstName());
        person.setLastName(userRegistrationDto.getLastName());
        person.setDateOfBirth(userRegistrationDto.getDateOfBirth());
        person.setGender(userRegistrationDto.getGender());
        person.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        person.setUser(user);

        return personRepository.save(person);
    }
}
