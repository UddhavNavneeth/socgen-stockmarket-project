package com.ud.userservice.controllers;

import com.ud.userservice.dto.LoginDto;
import com.ud.userservice.dto.ReturnMessage;
import com.ud.userservice.entities.User;
import com.ud.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/signup")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @PostMapping(value="/login")
    public ResponseEntity<ReturnMessage> login(@RequestBody LoginDto loginDto) {
        String token = this.userService.login(loginDto.getUsername(), loginDto.getPassword());
        ReturnMessage message = new ReturnMessage();
        if (null != token) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("token",token);
            message.setMessage("logged in");
            return ResponseEntity.ok().headers(responseHeaders).body(message);
        } else {
            message.setMessage("invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }

    @GetMapping(value="/authenticate")
    public ResponseEntity<String> authenticate(@RequestHeader("token") String token) {
        String output = this.userService.authenticate(token);
        if (output.equals("user") || output.equals("admin")) {
            return ResponseEntity.ok().body(output);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
    }




    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(Long userId) {
        this.userService.deleteUser(userId);
    }
}
