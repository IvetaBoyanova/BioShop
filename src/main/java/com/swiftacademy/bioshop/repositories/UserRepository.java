package com.swiftacademy.bioshop.repositories;

import com.swiftacademy.bioshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findByUserEmailAndPassword(String userEmail, String password);

    User findUserByUserEmail(String userEmail);

}



