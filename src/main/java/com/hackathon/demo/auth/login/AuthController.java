package com.hackathon.demo.auth.login;


import com.hackathon.demo.auth.dto.AuthRequest;
import com.hackathon.demo.auth.dto.AuthResponse;
import com.hackathon.demo.config.ApiConfig;
import com.hackathon.demo.dto.RegisterRequest;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConfig.API_BASE_PATH + "/auth")
public class AuthController {

        private final AuthService authService;

        public AuthController(AuthService authService) {
            this.authService = authService;
        }

        @PermitAll
        @PostMapping("/login")
        public ResponseEntity<AuthResponse> login (@RequestBody AuthRequest authRequest){

                String token = authService.authenticate(authRequest.getUsername(), authRequest.getPassword());

                return ResponseEntity.ok(new AuthResponse(token));
        }

        @PermitAll
        @PostMapping("/register")
        public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
                try {
                        String token = authService.register(request);
                        return ResponseEntity.ok(new AuthResponse(token));
                } catch (RuntimeException e) {
                        return ResponseEntity.badRequest().body(new AuthResponse(e.getMessage()));
                }
        }


}
