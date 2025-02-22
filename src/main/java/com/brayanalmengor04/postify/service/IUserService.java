package com.brayanalmengor04.postify.service;

import com.brayanalmengor04.postify.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public void addUser(User user);
    public void deleteUser(Long id);
}
