package com.ghailene.myblog.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequest {
    private String userName;
    private String password;
    private String email;

}
