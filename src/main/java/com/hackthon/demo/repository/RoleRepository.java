package com.hackthon.demo.repository;

import com.hackthon.demo.entity.Role;
import com.hackthon.demo.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType); // MÉTODO NECESARIO
}