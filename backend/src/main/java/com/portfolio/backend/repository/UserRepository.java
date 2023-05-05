
package com.portfolio.backend.repository;

import com.portfolio.backend.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User>findByEmail(String email);
}
