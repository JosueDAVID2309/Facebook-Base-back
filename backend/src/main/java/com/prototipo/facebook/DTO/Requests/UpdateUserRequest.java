package com.prototipo.facebook.DTO.Requests;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UpdateUserRequest {
    private String nombres;
    private String apellidos;
    private String genero;
    private LocalDate f_nacimiento;
    private String imageurl;
}
