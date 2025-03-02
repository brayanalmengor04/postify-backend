package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.entity.Role;
import com.brayanalmengor04.postifyv1.enums.Permission;
import com.brayanalmengor04.postifyv1.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    // Agregamos seeder para los permisos (DEFAULT )
    public void addRoleIfNotExists(String roleName, String description, String permissions) {
        Optional<Role> existingRole = roleRepository.findByRoleName(roleName);
        if (existingRole.isEmpty()) {
            Role role = new Role();
            role.setRoleName(roleName);
            role.setDescription(description);
            role.setPermission(permissions);
            roleRepository.save(role);
            System.out.println("✅ Rol " + roleName + " agregado correctamente.");
        }
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }


}
