package com.hackathon.demo.auth.login;

import com.hackathon.demo.auth.jwt.JwtService;
import com.hackathon.demo.auth.model.mysql.CustomUserDetails;
import com.hackathon.demo.dto.RegisterRequest;
import com.hackathon.demo.entity.Role;
import com.hackathon.demo.entity.RoleType;
import com.hackathon.demo.entity.User;
import com.hackathon.demo.repository.RoleRepository;
import com.hackathon.demo.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository; // Añadir esto

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService,
                       UserRepository userRepository, PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository) { // Añadir parameter
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository; // Inicializar
    }

    public String authenticate(String username, String rawPassword) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, rawPassword));

        return jwtService.generateToken((org.springframework.security.core.userdetails.UserDetails) authentication.getPrincipal());
    }

    public String register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya está registrado");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Asignar rol por defecto
        Role userRole = roleRepository.findByRoleType(RoleType.USER)
                .orElseThrow(() -> new RuntimeException("Rol USER no encontrado"));
        user.addRole(userRole);

        userRepository.save(user);

        return jwtService.generateToken(new CustomUserDetails(user));
    }
}