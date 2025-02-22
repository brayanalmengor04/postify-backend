package com.brayanalmengor04.postify.service;

import com.brayanalmengor04.postify.entity.Role;
import com.brayanalmengor04.postify.enums.Permission;
import com.brayanalmengor04.postify.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }
    @Override
    public Role getRoleById(Long id) {
       return this.roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return null;
    }

    @Override
    public void save(Role role, Boolean isAdmin) {
       if (isAdmin) getPermissionAdmin(role); else getPermissionUser(role);
       this.save(role,isAdmin);
    }

    public void getPermissionAdmin(Role permission) {
        permission.setPermissions(Set.of(
                Permission.FULL_ADMIN,
                Permission.CREATE_COMMENT,
                Permission.EDIT_OWN_POST,
                Permission.LIKE_POST,
                Permission.DELETE_OWN_POST,
                Permission.DELETE_ANY_POST,
                Permission.EDIT_ANY_POST
                ));

    }
    public void getPermissionUser(Role permission) {
        permission.setPermissions(Set.of(
                Permission.CREATE_COMMENT,
                Permission.LIKE_POST,
                Permission.EDIT_OWN_POST,
                Permission.DELETE_OWN_POST
        ));
    }
}
