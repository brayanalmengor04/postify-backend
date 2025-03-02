package com.brayanalmengor04.postifyv1.controller;

import com.brayanalmengor04.postifyv1.entity.Role;
import com.brayanalmengor04.postifyv1.repository.RoleRepository;
import com.brayanalmengor04.postifyv1.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("postify-app")
@CrossOrigin(origins = "http://localhost:5174") // Permite peticiones desde el frontend
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("role")
    public List<Role> getFindAllRoles() {return roleService.getAllRoles();}

    @PostMapping("role-add")
    public Role addRole(@RequestBody Role role) {
        roleService.save(role);
        return role;
    }

    // Pasar valores form

    @GetMapping ("/role/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        if (roleService.getRoleById(id) == null) throw new RuntimeException("Role not found");
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    // Editar roles
    @PutMapping("/role/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id
            , @RequestBody Role role) {
        Role roleSearch = roleService.getRoleById(id);
        if (roleSearch == null) throw new RuntimeException("Role not found");

        roleSearch.setRoleName(role.getRoleName());
        roleSearch.setDescription(role.getDescription());
        roleSearch.setPermission(role.getPermission());
        roleService.save(roleSearch);
        return ResponseEntity.ok(roleSearch);
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }

        roleService.deleteRoleById(id);
        return ResponseEntity.ok(role.toString());
    }
}
