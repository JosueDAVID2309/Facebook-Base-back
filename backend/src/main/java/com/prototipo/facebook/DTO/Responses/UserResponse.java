package com.prototipo.facebook.DTO.Responses;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String genero;
    private String imageUrl;
    private LocalDate f_nacimiento;

}

    
