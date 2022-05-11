package com.ghailene.myblog.service;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationResponse {

    private String authenticationToken;
    private String userName;
}
