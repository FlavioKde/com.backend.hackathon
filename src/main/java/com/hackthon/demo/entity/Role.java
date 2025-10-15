package com.hackthon.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", unique = true, nullable = false)
    private RoleType roleType;

    public Role() {}

    public Role(RoleType roleType) {
        this.roleType = roleType;
    }

    // Getters y Setters (iguales)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public RoleType getRoleType() { return roleType; }
    public void setRoleType(RoleType roleType) { this.roleType = roleType; }
}