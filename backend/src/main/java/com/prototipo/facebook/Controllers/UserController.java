package com.prototipo.facebook.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.facebook.DTO.Requests.UpdateUserRequest;
import com.prototipo.facebook.DTO.Responses.ApiResponse;
import com.prototipo.facebook.DTO.Responses.UserResponse;
import com.prototipo.facebook.Services.UserService;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    
    @GetMapping("/{correo}")
    public ApiResponse<UserResponse> findUser(@PathVariable String correo) {
        try{
            UserResponse user = service.getUserByCorreo(correo);
            return new ApiResponse<UserResponse>(true, user, "Usuario encontrado");
        }catch(RuntimeException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }

    @GetMapping("/{nombre}")
    public ApiResponse<List<UserResponse>> getMethodName(@PathVariable String nombre) {
        List<UserResponse> users = service.searchUsersByNombre(nombre);
        return new ApiResponse<List<UserResponse>>(true, users, "Usuarios encontrados");
    }

    @PutMapping("/updateProfile")
    public ApiResponse<?> updateProfile(@RequestBody UpdateUserRequest request) {
        try{
            service.updateUser(request);
            return new ApiResponse<>(true, null, "Perfil actualizado");
        }catch(UsernameNotFoundException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }

    @DeleteMapping("/destroyProfile")
    public ApiResponse<?> deleteProfile(){
        try{
            service.deleteAccount();
            return new ApiResponse<>(true, null, "Usuario Eliminado");
        }catch(RuntimeException e){
            return new ApiResponse<>(false, null, e.getMessage()); 
        }
    }
    
    
    
}
