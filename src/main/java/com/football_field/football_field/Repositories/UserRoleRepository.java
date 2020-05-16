package com.football_field.football_field.Repositories;

import com.football_field.football_field.Entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole getByRoleName(String roleName);
}
