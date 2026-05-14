package com.prototipo.facebook.DTO;

import java.time.LocalDate;

import com.prototipo.facebook.Models.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String genero;
    private String imageUrl;
    private LocalDate f_nacimiento;

}

    
