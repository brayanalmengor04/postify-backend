package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.entity.Role;
import com.brayanalmengor04.postifyv1.entity.User;
import com.brayanalmengor04.postifyv1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService; // Inyectar el servicio de Role

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public User addUser(User user, Long roleId) {

        Role role = roleService.getRoleById(roleId);
        if (role != null) {
            user.setRole(role); // Asignar el rol al usuario
            userRepository.save(user);
        } else {
            throw new RuntimeException("El rol con ID " + roleId + " no existe.");
        }
        return user;
    }

    @Override
    public void deleteUser(User user) {

    }
}