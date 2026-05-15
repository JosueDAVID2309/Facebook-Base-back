package com.prototipo.facebook.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prototipo.facebook.DTO.Requests.UpdateUserRequest;
import com.prototipo.facebook.DTO.Responses.UserResponse;
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

    public UserResponse getUserByCorreo (String correo){
        User user = repo.findByCorreo(correo).orElseThrow();
        return mapper.toDTO(user);
    }

    public List<UserResponse> searchUsersByNombre (String nombres){
        List<User> users = repo.findByNombresContaining(nombres);
        List<UserResponse> usersDTO = new ArrayList<>();

        for(User user : users){
            usersDTO.add(mapper.toDTO(user));
        }
        return usersDTO;
    }

    public void updateUser(UpdateUserRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = repo.findByCorreo(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No se encontro al usuario autenticado"));
        mapper.toEntity(request, user);
        repo.save(user);
    }

    public void deleteAccount(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = repo.findByCorreo(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No se encontro al usuario autenticado"));
        if(!repo.existsById(user.getId())){
            throw new RuntimeException("No existe el usuario con este id");
        }
        repo.deleteById(user.getId());
    }

    

}
