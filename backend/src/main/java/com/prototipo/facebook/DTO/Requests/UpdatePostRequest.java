package com.prototipo.facebook.DTO.Requests;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UpdatePostRequest {
    private String descripcion;
    private String imageurl;
}
