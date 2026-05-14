package com.prototipo.facebook.DTO.Requests;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class LoginRequest {
    private String correo;

    private String clave;
}
