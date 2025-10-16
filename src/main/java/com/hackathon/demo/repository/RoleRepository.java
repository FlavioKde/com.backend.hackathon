package com.hackathon.demo.repository;

import com.hackathon.demo.entity.Role;
import com.hackathon.demo.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType); // MÉTODO NECESARIO
}