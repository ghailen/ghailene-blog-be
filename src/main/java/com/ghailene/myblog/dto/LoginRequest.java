package com.ghailene.myblog.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class LoginRequest {

    private String userName;
    private String password;
}
