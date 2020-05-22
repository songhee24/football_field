package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Roles.Role;
import com.football_field.football_field.Entities.User;
import com.football_field.football_field.Repositories.RoleRepository;
import com.football_field.football_field.Servicies.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.get();
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role item) {
        return roleRepository.save(item);
    }
}
