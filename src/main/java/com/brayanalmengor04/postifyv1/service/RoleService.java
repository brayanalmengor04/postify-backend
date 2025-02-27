package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.entity.Role;
import com.brayanalmengor04.postifyv1.enums.Permission;
import com.brayanalmengor04.postifyv1.repository.RoleRepository;
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
    public Role save(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }


}
