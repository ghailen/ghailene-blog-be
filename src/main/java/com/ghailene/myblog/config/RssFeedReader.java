package com.ghailene.myblog.config;

import com.ghailene.myblog.dto.rssfeed.MediaContentDto;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RssFeedReader {

    @Bean
    public void getRss() {
        try {
            String url = "https://api.foxsports.com/v1/rss?partnerKey=zBaFxRyGKCfxBagJG9b8pqLyndmvo7UU";
            String url2 = "https://feeds.fireside.fm/bibleinayear/rss";


            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                System.out.println(feed.getTitle() + "xxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("***********************************");
                for (SyndEntry entry : feed.getEntries()) {
                    System.out.println("-------------FFFFFFFFFFFFFF -title : " + entry.getTitle());
                    System.out.println("----------------getPublishedDate : " + entry.getPublishedDate());
                    System.out.println("--------------getLink : " + entry.getLink());
                    System.out.println("---------------getAuthor : " + entry.getAuthor());
                    System.out.println("----------------------getDescription : " + entry.getDescription().getValue());
                    System.out.println("--------------getEnclosures : " + entry.getEnclosures());

                    List<MediaContentDto> mediaList = new ArrayList<>();


                    entry.getEnclosures().stream().map(
                            elem -> {
                                MediaContentDto mediaContent = new MediaContentDto();
                                mediaContent.setType(elem.getType());
                                mediaContent.setUrl(elem.getUrl());
                                mediaList.add(mediaContent);
                                return mediaList;
                            }
                    ).collect(Collectors.toList());

                    System.out.println("***********************************");
                }
                System.out.println("Done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
