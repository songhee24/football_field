package com.football_field.football_field.Repositories;

import com.football_field.football_field.Entities.Roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getByRoleName(String roleName);
}
