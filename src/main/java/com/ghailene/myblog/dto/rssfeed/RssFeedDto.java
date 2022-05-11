package com.ghailene.myblog.dto.rssfeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RssFeedDto {

    private String title;
    private Date publishedDate;
    private String link;
    private String author;
    private String description;
    private List<MediaContentDto> mediaContent;

}
