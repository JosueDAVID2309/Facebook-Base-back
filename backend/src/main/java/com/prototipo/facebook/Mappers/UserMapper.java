package com.prototipo.facebook.Mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.prototipo.facebook.DTO.Requests.RegisterRequest;
import com.prototipo.facebook.DTO.Requests.UpdateUserRequest;
import com.prototipo.facebook.DTO.Responses.UserResponse;
import com.prototipo.facebook.Models.User;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder encoder;

    public UserResponse toDTO(User user) {
        UserResponse dto = new UserResponse();

        dto.setId(user.getId());
        dto.setNombres(user.getNombres());
        dto.setApellidos(user.getApellidos());
        dto.setCorreo(user.getCorreo());
        dto.setGenero(user.getGenero());
        dto.setImageUrl(user.getImageurl());
        dto.setF_nacimiento(user.getF_nacimiento());

        return dto;
    }

    public User toEntity(RegisterRequest request){
        User user = new User();
        user.setNombres(request.getNombres());
        user.setApellidos(request.getApellidos());
        user.setGenero(request.getGenero());
        user.setF_nacimiento(request.getF_nacimiento());
        user.setCorreo(request.getCorreo());
        user.setClave(encoder.encode(request.getClave()));

        return user;
    }

    public void toEntity(UpdateUserRequest request, User user){
        user.setNombres(request.getNombres());
        user.setApellidos(request.getApellidos());
        user.setGenero(request.getGenero());
        user.setF_nacimiento(request.getF_nacimiento());
        user.setImageurl(request.getImageurl());
    }
}
