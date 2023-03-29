package com.codeup.codeupSpringAdlister.repository;

import com.codeup.codeupSpringAdlister.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);

}