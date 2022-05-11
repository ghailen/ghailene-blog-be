package com.ghailene.myblog.service.rssfeed;

import com.ghailene.myblog.dto.rssfeed.RssFeedDto;

import java.util.List;

public interface RssFeedService {

    List<RssFeedDto> getRssFeedSport();

    List<RssFeedDto> getRssFeedCars();

    List<RssFeedDto> getRssFeedVideoGames();

    List<RssFeedDto> getRssFeedMusic();

    List<RssFeedDto> getRssFeedAnime();

}
