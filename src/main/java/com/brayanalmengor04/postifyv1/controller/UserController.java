package com.brayanalmengor04.postifyv1.controller;

import com.brayanalmengor04.postifyv1.dto.UserDTO;
import com.brayanalmengor04.postifyv1.entity.Role;
import com.brayanalmengor04.postifyv1.entity.User;
import com.brayanalmengor04.postifyv1.service.IRoleService;
import com.brayanalmengor04.postifyv1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("postify-app")
@CrossOrigin(value = "http://localhost:5173") // Permitir acceso desde el frontend
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping("/user-add")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User newUser = userService.addUser(userDTO);
        return ResponseEntity.ok(newUser);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        Role role = roleService.getRoleById(userDTO.getRoleId());
        if (role == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Actualizar datos del usuario
        existingUser.setName(userDTO.getName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setStreetAddress(userDTO.getStreetAddress());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setRole(role);

        // Guardar cambios usando un método updateUser en el servicio
        User updatedUser = userService.updateUser(existingUser);

        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(user);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
