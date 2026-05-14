package com.prototipo.facebook.Mappers;

import org.springframework.stereotype.Component;

import com.prototipo.facebook.DTO.UserDTO;
import com.prototipo.facebook.Models.User;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setNombres(user.getNombres());
        dto.setApellidos(user.getApellidos());
        dto.setCorreo(user.getCorreo());
        dto.setGenero(user.getGenero());
        dto.setImageUrl(user.getImageurl());
        dto.setF_nacimiento(user.getF_nacimiento());

        return dto;
    }
}
