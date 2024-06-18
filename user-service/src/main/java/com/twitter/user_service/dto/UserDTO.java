package com.twitter.user_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private long id;
    private String username;
    private String password_hash;
    private String email;
}
