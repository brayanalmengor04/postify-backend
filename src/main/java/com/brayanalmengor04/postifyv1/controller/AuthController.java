package com.brayanalmengor04.postifyv1.controller;

import com.brayanalmengor04.postifyv1.dto.UserDTO;
import com.brayanalmengor04.postifyv1.entity.User;
import com.brayanalmengor04.postifyv1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("postify-app/auth")
@CrossOrigin(value = "http://localhost:5173")
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/signin")
    public ResponseEntity<User> loginUser(@RequestBody UserDTO userDTO) {
        User user = userService.getUserByEmail(userDTO.getEmail());
        if (user != null && userService.checkPassword(userDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
