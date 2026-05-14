package com.prototipo.facebook.DTO.Responses;

import java.time.LocalDateTime;

import com.prototipo.facebook.Models.User;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class PostResponse {
    private String author;
    private String imageURL;
    private String descripcion;
    private Integer countLikes;
    private Integer countCommets;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
