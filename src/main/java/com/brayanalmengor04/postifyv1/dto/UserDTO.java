package com.brayanalmengor04.postifyv1.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UserDTO {
    private String name;
    private String lastName;
    private String streetAddress;
    private String email;
    private String password;
    private Long roleId; // Recibe el id del rol desde el frontend
}
