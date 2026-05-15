package com.prototipo.facebook.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.facebook.Models.User;

public interface UserRepository extends JpaRepository<User, Long>{
        Optional<User> findByCorreo(String correo);
        Boolean existsByCorreo(String correo);

        List<User> findByNombresContaining(String nombres);
}
