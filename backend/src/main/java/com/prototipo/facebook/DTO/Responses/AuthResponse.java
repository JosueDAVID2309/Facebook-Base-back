package com.prototipo.facebook.DTO.Responses;

import com.prototipo.facebook.DTO.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Data
@Setter
@Getter
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private UserDTO user;
}
