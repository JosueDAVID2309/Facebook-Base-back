package com.prototipo.facebook.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.facebook.DTO.Requests.LoginRequest;
import com.prototipo.facebook.DTO.Requests.RegisterRequest;
import com.prototipo.facebook.DTO.Responses.ApiResponse;
import com.prototipo.facebook.DTO.Responses.AuthResponse;
import com.prototipo.facebook.DTO.Responses.UserResponse;
import com.prototipo.facebook.Services.AuthService;
import com.prototipo.facebook.Services.UserService;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService service, UserService userService){
        this.authService = service;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@RequestBody LoginRequest request) {
        try{
            String token = authService.login(request);
            UserResponse user = userService.getUserByCorreo(request.getCorreo());
            return new ApiResponse<AuthResponse>(true, new AuthResponse(token, user) , "Inicio de Sesion Existoso");
        }catch(BadCredentialsException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }

    @PostMapping("/register")
    public ApiResponse<AuthResponse> register(@RequestBody RegisterRequest request){
        try{
            String token = authService.register(request);
            UserResponse user = userService.getUserByCorreo(request.getCorreo());
            return new ApiResponse<AuthResponse>(true, new AuthResponse(token, user), "Registro exitoso");
        }catch(RuntimeException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }

    @GetMapping("/test")
    public String getMethodName() {
        return "Hola mundo";
    }
    
}
