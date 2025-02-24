package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User addUser(User user, Long id);
    public void deleteUser(User user);
}
