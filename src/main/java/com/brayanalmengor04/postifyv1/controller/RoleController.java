package com.brayanalmengor04.postifyv1.controller;

import com.brayanalmengor04.postifyv1.entity.Role;
import com.brayanalmengor04.postifyv1.repository.RoleRepository;
import com.brayanalmengor04.postifyv1.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("postify-app")
@CrossOrigin(value ="http://localhost:5173" )
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

}
