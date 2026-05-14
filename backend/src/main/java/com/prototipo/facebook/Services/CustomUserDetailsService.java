package com.prototipo.facebook.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prototipo.facebook.Models.User;
import com.prototipo.facebook.Repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException{
        User user = repo.findByCorreo(correo).orElseThrow();

        return org.springframework.security.core.userdetails.User
            .builder()
            .username(user.getCorreo())
            .password(user.getClave())
            .build();
    }
}
