package com.ud.userservice.services;

import com.ud.userservice.entities.User;
import com.ud.userservice.repositories.UserRepository;
import com.ud.userservice.security.Password;
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
//        System.out.println("yoyo");
        Boolean authenticated = Password.checkPassword(password, storedUser.getPassword());

        if (authenticated) {
            return "verified";
        } else {
            return null;
        }

    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
