package com.brayanalmengor04.postifyv1.controller;

import com.brayanalmengor04.postifyv1.entity.User;
import com.brayanalmengor04.postifyv1.service.IUserService;
import com.brayanalmengor04.postifyv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("postify-app")
@CrossOrigin(value ="http://localhost:5173" )
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

}
