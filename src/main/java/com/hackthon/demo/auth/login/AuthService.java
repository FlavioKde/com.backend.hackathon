package com.hackthon.demo.auth.login;


import com.hackthon.demo.auth.jwt.JwtService;
import com.hackthon.demo.dto.RegisterRequest;
import com.hackthon.demo.entity.User;
import com.hackthon.demo.repository.UserRepository;
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




    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService,
                       UserRepository userRepository,  PasswordEncoder passwordEncoder) {

            this.authenticationManager = authenticationManager;
            this.jwtService = jwtService;
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;

        }

        public String authenticate(String username, String rawPassword) {



            Authentication authentication = authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(username, rawPassword));

            return jwtService.generateToken((org.springframework.security.core.userdetails.UserDetails) authentication.getPrincipal());
        }

        public String register(RegisterRequest request) {
            if (userRepository.existsByEmail(request.getEmail())) {
                throw new RuntimeException("El email ya está registrado");
            }

            User user = new User();
            user.setUserName(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));

            userRepository.save(user);

            return jwtService.generateToken(user);

        }




}
