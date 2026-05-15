package com.prototipo.facebook.Services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prototipo.facebook.DTO.Requests.LoginRequest;
import com.prototipo.facebook.DTO.Requests.RegisterRequest;
import com.prototipo.facebook.Mappers.UserMapper;
import com.prototipo.facebook.Repositories.UserRepository;
import com.prototipo.facebook.Models.User;

@Service
public class AuthService {
    
    private final UserMapper mapper;
    private final PasswordEncoder encoder;
    private final UserRepository repo;
    private final JwtService jwt;

    public AuthService(PasswordEncoder encoder,
        UserRepository repo,
        JwtService jwt,
        UserMapper mapper
        ){
        this.encoder = encoder;
        this.repo = repo;
        this.jwt = jwt;
        this.mapper = mapper;
    }

    public String login(LoginRequest request){
        User user = repo.findByCorreo(request.getCorreo()).orElseThrow(() -> new BadCredentialsException("Credenciales Incorrectas"));
        if(!encoder.matches(request.getClave(), user.getClave())){
            throw new BadCredentialsException("Credenciales Incorrectas");
        }
        return jwt.generateToken(user.getCorreo());
    }

    public String register(RegisterRequest request){
        if(repo.existsByCorreo(request.getCorreo())){
            throw new RuntimeException();
        }
        User user = mapper.toEntity(request);
        repo.save(user);

        return jwt.generateToken(user.getCorreo());
    }
}
