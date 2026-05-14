package com.prototipo.facebook.DTO.Requests;

import com.prototipo.facebook.Models.User;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class AddPostRequest {

    private String imageUrl;

    private String descripcion;
}
