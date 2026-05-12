package com.prototipo.facebook.Services;

import org.springframework.stereotype.Service;

import com.prototipo.facebook.DTO.RegisterRequest;
import com.prototipo.facebook.Models.User;
import com.prototipo.facebook.Repositories.UserRepository;
@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo){
        this.repo = repo;
    }

    public User addUser(RegisterRequest request){
        User user = new User();
        user.setNombres(request.getNombres());
        user.setApellidos(request.getApellidos());
        user.setGenero(request.getGenero());
        user.setF_nacimiento(request.getF_nacimiento());
        user.setCorreo(request.getCorreo());
        user.setClave(request.getClave());

        return repo.save(user);
    }
}
