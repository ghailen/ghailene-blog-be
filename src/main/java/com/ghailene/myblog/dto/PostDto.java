package com.ghailene.myblog.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {

    private Long id;
    private String content;
    private String title;
    private String userName;


}
