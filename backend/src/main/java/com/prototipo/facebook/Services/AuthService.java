package com.prototipo.facebook.Services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prototipo.facebook.DTO.LoginRequest;
import com.prototipo.facebook.DTO.RegisterRequest;
import com.prototipo.facebook.Repositories.UserRepository;
import com.prototipo.facebook.Models.User;

@Service
public class AuthService {
    
    private final PasswordEncoder encoder;
    private final UserRepository repo;
    private final JwtService jwt;

    public AuthService(PasswordEncoder encoder, UserRepository repo, JwtService jwt){
        this.encoder = encoder;
        this.repo = repo;
        this.jwt = jwt;
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

        User user = new User();
        user.setNombres(request.getNombres());
        user.setApellidos(request.getApellidos());
        user.setGenero(request.getGenero());
        user.setF_nacimiento(request.getF_nacimiento());
        user.setCorreo(request.getCorreo());
        user.setClave(encoder.encode(request.getClave()));

        repo.save(user);

        return jwt.generateToken(user.getCorreo());
    }

    

}
