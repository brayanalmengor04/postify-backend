package com.brayanalmengor04.postifyv1.controller;

import com.brayanalmengor04.postifyv1.dto.UserDTO;
import com.brayanalmengor04.postifyv1.entity.Role;
import com.brayanalmengor04.postifyv1.entity.User;
import com.brayanalmengor04.postifyv1.service.ICommentService;
import com.brayanalmengor04.postifyv1.service.IRoleService;
import com.brayanalmengor04.postifyv1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("postify-app")
@CrossOrigin(value = "http://localhost:5173") // Permite peticiones desde el frontend
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ICommentService commentService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

    @PostMapping("user-add")
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

        User updatedUser = userService.updateUser(existingUser);

        return ResponseEntity.ok(updatedUser);
    }
//    @PutMapping("/user-perfil/{id}")
//    public ResponseEntity<User> updateUserProfile(
//            @PathVariable Long id,
//            @RequestPart("user") UserDTO userDTO,
//            @RequestPart(value = "avatar", required = false) MultipartFile avatarFile) {
//
//        User existingUser = userService.getUserById(id);
//        if (existingUser == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        // Actualizar datos del usuario
//        existingUser.setName(userDTO.getName());
//        existingUser.setLastName(userDTO.getLastName());
//        existingUser.setStreetAddress(userDTO.getStreetAddress());
//        existingUser.setEmail(userDTO.getEmail());
//
//        Role role = roleService.getRoleById(userDTO.getRoleId());
//        if (role == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        existingUser.setRole(role);
//
//        // Procesar imagen si se envió
//        if (avatarFile != null && !avatarFile.isEmpty()) {
//            try {
//                String fileName = "avatar_" + id + "_" + avatarFile.getOriginalFilename();
//                Path filePath = Paths.get("uploads/avatars/" + fileName);
//                Files.createDirectories(filePath.getParent());
//                Files.write(filePath, avatarFile.getBytes());
//
//                existingUser.setAvatarUrl("/uploads/avatars/" + fileName);
//            } catch (IOException e) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//            }
//        }
//
//        User updatedUser = userService.updateUser(existingUser);
//        return ResponseEntity.ok(updatedUser);
//    }
//
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String,Boolean>> deletedUser(@PathVariable Long id) {

        User user = userService.getUserById(id);
        if (user == null) throw new RuntimeException("User not found");

        userService.deleteUser(id);

        // Json {"eliminado":"true"}
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }




}
