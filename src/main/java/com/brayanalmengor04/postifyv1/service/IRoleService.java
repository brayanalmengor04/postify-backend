package com.brayanalmengor04.postifyv1.service;

import com.brayanalmengor04.postifyv1.entity.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> getAllRoles();
    public Role getRoleById(Long id);
    public Role save(Role role);
}
