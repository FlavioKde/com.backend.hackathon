package com.hackthon.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true) // Cambié el nombre
    private String username; // minúscula para coincidir con JPA

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // CORRECCIÓN CRÍTICA: Faltaba el mapeo de la relación
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>(); // Inicializar la lista

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = new ArrayList<>();
    }

    // Getters y Setters CORREGIDOS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; } // setter corregido

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }

    // Método helper útil
    public void addRole(Role role) {
        this.roles.add(role);
    }
}