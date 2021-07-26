package com.ud.userservice.services;

import com.ud.userservice.entities.User;
import com.ud.userservice.repositories.UserRepository;
import com.ud.userservice.security.Jwt;
import com.ud.userservice.security.Password;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        user.setPassword(Password.hashPassword(user.getPassword()));
        return this.userRepository.save(user);
    }

    public String login(String username, String password) {
        User storedUser = this.userRepository.findUserByUsername(username);
        if (storedUser == null) {
            return null;
        }
        Boolean authenticated = Password.checkPassword(password, storedUser.getPassword());

        if (authenticated) {
            return Jwt.generateToken(storedUser);
        } else {
            return null;
        }
    }

    public String authenticate(String token) {
        Claims claims = Jwt.decodeToken(token);
        return (claims != null) ?  Jwt.validate(claims) : "invalidToken";
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return this.userRepository.findById(userId).get();
    }

    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
