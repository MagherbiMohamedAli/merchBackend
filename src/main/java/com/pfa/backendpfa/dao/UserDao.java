package com.pfa.backendpfa.dao;

import com.pfa.backendpfa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<User, Long>{
     Optional<User> findByEmailOrUsernameAndPassword(String email, String username, String password);
     Optional<User> findByUsernameOrEmail(String username, String email);
    Boolean existsByEmail(String email);



}
