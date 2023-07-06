package com.pfa.backendpfa.dao;

import com.pfa.backendpfa.model.ERole;
import com.pfa.backendpfa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoleDao extends JpaRepository<Role,Long> {
    Set<Role> findRolesByRole(ERole role);
    Role findRoleByRole(ERole role);
}
