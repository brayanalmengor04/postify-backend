package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.dto.UserDTO;
import com.brayanalmengor04.postifyv1.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();

    public boolean checkPassword(String rawPassword, String encodedPassword);
    public User getUserById(Long id);
    User getUserByEmail(String email);
    public User addUser(UserDTO userDTO);
    public void deleteUser(User user);
}
