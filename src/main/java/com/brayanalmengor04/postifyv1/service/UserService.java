package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.dto.UserDTO;
import com.brayanalmengor04.postifyv1.entity.Role;
import com.brayanalmengor04.postifyv1.entity.User;
import com.brayanalmengor04.postifyv1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Para encriptar contraseñas


    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User addUser(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setStreetAddress(userDTO.getStreetAddress());
        user.setEmail(userDTO.getEmail());

        // Encriptar la contraseña antes de guardarla
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        // Buscar el rol y asignarlo
        Role role = roleService.getRoleById(userDTO.getRoleId());
        if (role == null) {
            throw new RuntimeException("Role not found");
        }
        user.setRole(role);

        return userRepository.save(user);
    }


    @Override
    public User updateUser(User user) {
        // Asegurar que la contraseña se encripte si se actualiza
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }



}
