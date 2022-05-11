package com.ghailene.myblog.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactDto {
    private String email;
    private String body;
    private String title;

}
