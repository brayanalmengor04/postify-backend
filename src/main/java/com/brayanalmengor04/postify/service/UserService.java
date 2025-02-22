package com.brayanalmengor04.postify.service;

import com.brayanalmengor04.postify.entity.Role;
import com.brayanalmengor04.postify.entity.User;
import com.brayanalmengor04.postify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() { return userRepository.findAll();}

    @Override
    public User getUserById(Long id) { return userRepository.findById(id).orElse(null);}

    @Override
    public void addUser(User user) { this.userRepository.save(user);}

    @Override
    public void deleteUser(Long id) {this.userRepository.deleteById(id);}
}
