package com.prototipo.facebook.Services;

import org.springframework.stereotype.Service;

import com.prototipo.facebook.DTO.UserDTO;
import com.prototipo.facebook.Mappers.UserMapper;
import com.prototipo.facebook.Models.User;
import com.prototipo.facebook.Repositories.UserRepository;

@Service
public class UserService {
    private final UserMapper mapper;
    private final UserRepository repo;

    public UserService(UserRepository repo, UserMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    public UserDTO getUserByCorreo (String correo){
        User user = repo.findByCorreo(correo).orElseThrow();

        return mapper.toDTO(user);
    }
}
