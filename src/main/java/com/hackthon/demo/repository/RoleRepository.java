package com.hackthon.demo.repository;

import com.hackthon.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
        /*
        Role save(Role role);
        Optional<Role> findById(Long id);
        List<Role> findAll();
        void deleteById(Long id);


         */
}
