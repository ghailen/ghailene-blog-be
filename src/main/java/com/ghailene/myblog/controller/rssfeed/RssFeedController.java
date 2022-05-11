package com.ghailene.myblog.controller.rssfeed;

import com.ghailene.myblog.service.rssfeed.RssFeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rss")
public class RssFeedController {

    private final RssFeedService rssFeedService;

    public RssFeedController(RssFeedService rssFeedService) {
        this.rssFeedService = rssFeedService;
    }

    @GetMapping("/sports")
    public ResponseEntity<Object> getSports() {
        return ResponseEntity.accepted().body(rssFeedService.getRssFeedSport());
    }


    @GetMapping("/cars")
    public ResponseEntity<Object> getCars() {
        return ResponseEntity.accepted().body(rssFeedService.getRssFeedCars());
    }

    @GetMapping("/games")
    public ResponseEntity<Object> getGames() {
        return ResponseEntity.accepted().body(rssFeedService.getRssFeedVideoGames());
    }

    @GetMapping("/animes")
    public ResponseEntity<Object> getAnimes() {
        return ResponseEntity.accepted().body(rssFeedService.getRssFeedAnime());
    }

    @GetMapping("/musics")
    public ResponseEntity<Object> getMusics() {
        return ResponseEntity.accepted().body(rssFeedService.getRssFeedMusic());
    }
}
