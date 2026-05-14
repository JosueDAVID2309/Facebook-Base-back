package com.prototipo.facebook.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.facebook.DTO.ApiResponse;
import com.prototipo.facebook.DTO.LoginRequest;
import com.prototipo.facebook.DTO.RegisterRequest;
import com.prototipo.facebook.Services.AuthService;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody LoginRequest request) {
        try{
            return new ApiResponse<String>(true, service.login(request), "Inicio de Sesion Existoso");
        }catch(BadCredentialsException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }

    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody RegisterRequest request){
        try{
            return new ApiResponse<String>(true, service.register(request), "Registro exitoso");
        }catch(RuntimeException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }

    @GetMapping("/test")
    public String getMethodName() {
        return "Hola mundo";
    }
    

}
