package kz.diploma.auth.service;

import kz.diploma.auth.dto.AuthResponse;
import kz.diploma.auth.entity.UserCredential;
import kz.diploma.auth.repository.UserCredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserCredentialRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        return AuthResponse.builder()
                .token(jwtService.generateToken(credential.getEmail()))
                .build();
    }

    public AuthResponse generateToken(String username) {
        return AuthResponse.builder()
                .userId(Objects.requireNonNull(repository.findByEmail(username).orElse(null)).getId())
                .token(jwtService.generateToken(username))
                .build();
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
