package com.tsd.auth.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsd.auth.manager.entity.User;
import java.util.List;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByMobile(String mobile);
    User findByEmail(String email);
}