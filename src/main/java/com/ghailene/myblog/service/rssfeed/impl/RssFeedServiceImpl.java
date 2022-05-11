package com.ghailene.myblog.service.rssfeed.impl;

import com.ghailene.myblog.dto.rssfeed.MediaContentDto;
import com.ghailene.myblog.dto.rssfeed.RssFeedDto;
import com.ghailene.myblog.service.rssfeed.RssFeedService;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RssFeedServiceImpl implements RssFeedService {

    /***** sports Rss Feed **/
    private static final String FOX_SPORT_RSS_FEED_URL = "https://api.foxsports.com/v1/rss?partnerKey=zBaFxRyGKCfxBagJG9b8pqLyndmvo7UU";
    // private static final String FIRE_SIDE_RSS_FEED_URL = "https://feeds.fireside.fm/bibleinayear/rss";
    private static final String RMC_RSS_FEED_URL = "https://rmcsport.bfmtv.com/rss/fil-sport/";
    private static final String SKYSPORT_RSS_FEED_URL = " https://www.skysports.com/rss/12040";
    private static final String SPORTSKEEDA_RSS_FEED_URL = "https://www.sportskeeda.com/feed";
    private static final String DEADSPIN_RSS_FEED_URL = "https://deadspin.com/rss";
    private static final String YARDBARKER_RSS_FEED_URL = "https://www.yardbarker.com/rss/rumors";
    private static final String SPORTINQUIER_RSS_FEED_URL = "https://sports.inquirer.net/feed";
    private static final String NINE_RSS_FEED_URL = "https://wwos.nine.com.au/rss";
    private static final String SPORTNET_RSS_FEED_URL = "https://www.sportsnet.ca/feed/";

    /***** cars  Rss Feed **/
    private static final String AUTOBLOG_RSS_FEED_URL = "https://www.autoblog.com/rss.xml";
    private static final String JALOPNIK_RSS_FEED_URL = "https://jalopnik.com/rss?x=1";
    private static final String FEEDBURNER_RSS_FEED_URL = "http://feeds.feedburner.com/MotorAuthority2";
    private static final String HIGHGEARMEDIA_RSS_FEED_URL = "http://feeds.highgearmedia.com/?sites=GreenCarReports";
    private static final String CAREXPERT_RSS_FEED_URL = "https://www.carexpert.com.au/feed";
    private static final String CONSUMER_RSS_FEED_URL = "https://blog.consumerguide.com/feed/";
    private static final String CANRANDRIVER_RSS_FEED_URL = "https://www.caranddriver.com/rss/all.xml/";
    private static final String KBB_RSS_FEED_URL = "https://www.kbb.com/feed/";
    private static final String EDMUNDS_RSS_FEED_URL = "https://www.edmunds.com/feeds/rss/articles.xml";
    private static final String MOTOR_RSS_FEED_URL = "https://www.motor1.com/rss/news/all/";
    private static final String CARSCOOPS_RSS_FEED_URL = "https://www.carscoops.com/feed/";
    private static final String POPSCI_RSS_FEED_URL = "https://www.popsci.com/tags/cars/feed/";
    private static final String DUPONREGISTRY_RSS_FEED_URL = "https://blog.dupontregistry.com/feed/";

    /**
     * videos games Rss Feed
     **/

    private static final String KOTAKU_RSS_FEED_URL = "https://kotaku.com/rss";
    private static final String POLYGON_RSS_FEED_URL = "https://www.polygon.com/rss/index.xml";
    private static final String GAMESPOT_RSS_FEED_URL = "https://www.gamespot.com/feeds/mashup";
    private static final String VG247_RSS_FEED_URL = "https://www.vg247.com/feed";
    private static final String GAMEINFORMER_RSS_FEED_URL = "https://www.gameinformer.com/rss.xml";
    private static final String PLAYSTATION_RSS_FEED_URL = "https://blog.playstation.com/feed/";
    private static final String NINTENDOLIFE_RSS_FEED_URL = "https://www.nintendolife.com/feeds/latest";
    private static final String ROCKPAPER_RSS_FEED_URL = "https://www.rockpapershotgun.com/feed";
    private static final String ROBLOX_RSS_FEED_URL = "https://blog.roblox.com/feed/";
    private static final String NVIDIA_RSS_FEED_URL = "https://blogs.nvidia.com/feed/";
    private static final String XBOX_RSS_FEED_URL = "https://news.xbox.com/en-us/feed/";
    private static final String PCGGAMER_RSS_FEED_URL = "https://www.pcgamer.com/rss/";
    private static final String EUROGAMER_RSS_FEED_URL = "https://www.eurogamer.net/feed";
    private static final String PCGAMESN_RSS_FEED_URL = "https://www.pcgamesn.com/mainrss.xml";

    /**
     * Music Rss Feed
     **/

    private static final String PITCHFORK_RSS_FEED_URL = "http://pitchfork.com/rss/news/";
    private static final String YOUREDM_RSS_FEED_URL = "https://www.youredm.com/feed/";
    private static final String CONSEQUENCE_RSS_FEED_URL = "https://consequence.net/feed/";
    private static final String EDM_RSS_FEED_URL = "https://edm.com/.rss/full/";
    private static final String SONGEXPLODER_RSS_FEED_URL = "http://songexploder.net/feed";
    private static final String RAPUP_RSS_FEED_URL = "https://www.rap-up.com/feed/";
    private static final String FEEDS_RSS_FEED_URL = "https://feeds.npr.org/15709577/rss.xml";

    /**
     * Manga Rss Feed
     **/
    private static final String ANIMENEWSNETWORK_RSS_FEED_URL = "https://www.animenewsnetwork.com/all/rss.xml?ann-edition=us";
    private static final String HONEYSANIME_RSS_FEED_URL = "https://honeysanime.com/feed/";
    private static final String ALLTHEANIME_RSS_FEED_URL = "http://blog.alltheanime.com/feed/";
    private static final String OTAKUKART_RSS_FEED_URL = "https://otakukart.com/animeblog/feed";
    private static final String WRONGEVERYTIME_RSS_FEED_URL = "http://wrongeverytime.com/feed/";
    private static final String BENTHESAGE_RSS_FEED_URL = "http://benthesage.com/feed/";
    private static final String RANDOMC_RSS_FEED_URL = "https://randomc.net/feed/";
    private static final String THEANIMEDAILY_RSS_FEED_URL = "https://www.theanimedaily.com/feed/";
    private static final String QUOTETHEANIME_RSS_FEED_URL = "https://quotetheanime.com/feed/";
    private static final String ANIMENEWSAND_RSS_FEED_URL = "https://animenewsandfacts.com/feed/";


    @Scheduled(cron="0 0 12 * * ?")
    @Override
    public List<RssFeedDto> getRssFeedSport() {
        List<RssFeedDto> rssFeedList = new ArrayList<>();

        List<String> rssFeedSourcesList = Arrays.asList(FOX_SPORT_RSS_FEED_URL, RMC_RSS_FEED_URL,
                SKYSPORT_RSS_FEED_URL,
                SPORTSKEEDA_RSS_FEED_URL,
                DEADSPIN_RSS_FEED_URL,
                YARDBARKER_RSS_FEED_URL,
                SPORTINQUIER_RSS_FEED_URL,
                NINE_RSS_FEED_URL
        );

        rssFeedSourcesList.forEach(el -> {

            try {


                try (XmlReader reader = new XmlReader(new URL(el))) {
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


                        rssFeedList.add(new RssFeedDto(
                                entry.getTitle().trim(),
                                entry.getPublishedDate(),
                                entry.getLink().trim(),
                                entry.getAuthor().trim(),
                                entry.getDescription().getValue().trim(),
                                entry.getEnclosures().stream().map(
                                        elem -> {
                                            MediaContentDto mediaContent = new MediaContentDto();
                                            mediaContent.setType(elem.getType());
                                            mediaContent.setUrl(elem.getUrl());
                                            return mediaContent;
                                        }
                                ).collect(Collectors.toList())
                        ));
                    }
                    System.out.println("Done");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        return rssFeedList;
    }

    @Scheduled(cron="0 0 12 * * ?")
    @Override
    public List<RssFeedDto> getRssFeedCars() {
        List<RssFeedDto> rssFeedListCars = new ArrayList<>();

        List<String> rssFeedCarsSourcesList = Arrays.asList(AUTOBLOG_RSS_FEED_URL, JALOPNIK_RSS_FEED_URL,
                FEEDBURNER_RSS_FEED_URL,
                HIGHGEARMEDIA_RSS_FEED_URL,
                CAREXPERT_RSS_FEED_URL,
                CONSUMER_RSS_FEED_URL,
                CANRANDRIVER_RSS_FEED_URL,
                KBB_RSS_FEED_URL,
                EDMUNDS_RSS_FEED_URL,
                MOTOR_RSS_FEED_URL,
                CARSCOOPS_RSS_FEED_URL,
                POPSCI_RSS_FEED_URL,
                DUPONREGISTRY_RSS_FEED_URL
        );

        rssFeedCarsSourcesList.forEach(el -> {

            try {


                try (XmlReader reader = new XmlReader(new URL(el))) {
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


                        rssFeedListCars.add(new RssFeedDto(
                                entry.getTitle().trim(),
                                entry.getPublishedDate(),
                                entry.getLink().trim(),
                                entry.getAuthor().trim(),
                                entry.getDescription().getValue().trim(),
                                entry.getEnclosures().stream().map(
                                        elem -> {
                                            MediaContentDto mediaContent = new MediaContentDto();
                                            mediaContent.setType(elem.getType());
                                            mediaContent.setUrl(elem.getUrl());
                                            return mediaContent;
                                        }
                                ).collect(Collectors.toList())
                        ));
                    }
                    System.out.println("Done");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        return rssFeedListCars;
    }

    @Scheduled(cron="0 0 12 * * ?")
    @Override
    public List<RssFeedDto> getRssFeedVideoGames() {
        List<RssFeedDto> rssFeedListVideoGames = new ArrayList<>();


        List<String> rssFeedGamesSourcesList = Arrays.asList(KOTAKU_RSS_FEED_URL, POLYGON_RSS_FEED_URL,
                GAMESPOT_RSS_FEED_URL,
                VG247_RSS_FEED_URL,
                GAMEINFORMER_RSS_FEED_URL,
                PLAYSTATION_RSS_FEED_URL,
                NINTENDOLIFE_RSS_FEED_URL,
                ROBLOX_RSS_FEED_URL,
                NVIDIA_RSS_FEED_URL,
                XBOX_RSS_FEED_URL,
                PCGGAMER_RSS_FEED_URL,
                EUROGAMER_RSS_FEED_URL,
                PCGAMESN_RSS_FEED_URL
        );

        rssFeedGamesSourcesList.forEach(el -> {

            try {


                try (XmlReader reader = new XmlReader(new URL(el))) {
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


                        rssFeedListVideoGames.add(new RssFeedDto(
                                entry.getTitle().trim(),
                                entry.getPublishedDate(),
                                entry.getLink().trim(),
                                entry.getAuthor().trim(),
                                entry.getDescription().getValue().trim(),
                                entry.getEnclosures().stream().map(
                                        elem -> {
                                            MediaContentDto mediaContent = new MediaContentDto();
                                            mediaContent.setType(elem.getType());
                                            mediaContent.setUrl(elem.getUrl());
                                            return mediaContent;
                                        }
                                ).collect(Collectors.toList())
                        ));
                    }
                    System.out.println("Done");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        return rssFeedListVideoGames;
    }
    @Scheduled(cron="0 0 12 * * ?")
    @Override
    public List<RssFeedDto> getRssFeedMusic() {
        List<RssFeedDto> rssFeedListMusic = new ArrayList<>();

        List<String> rssFeedMusicSourcesList = Arrays.asList(PITCHFORK_RSS_FEED_URL, YOUREDM_RSS_FEED_URL,
                CONSEQUENCE_RSS_FEED_URL,
                EDM_RSS_FEED_URL,
                SONGEXPLODER_RSS_FEED_URL,
                RAPUP_RSS_FEED_URL,
                FEEDS_RSS_FEED_URL
        );

        rssFeedMusicSourcesList.forEach(el -> {

            try {


                try (XmlReader reader = new XmlReader(new URL(el))) {
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


                        rssFeedListMusic.add(new RssFeedDto(
                                entry.getTitle().trim(),
                                entry.getPublishedDate(),
                                entry.getLink().trim(),
                                entry.getAuthor().trim(),
                                entry.getDescription().getValue().trim(),
                                entry.getEnclosures().stream().map(
                                        elem -> {
                                            MediaContentDto mediaContent = new MediaContentDto();
                                            mediaContent.setType(elem.getType());
                                            mediaContent.setUrl(elem.getUrl());
                                            return mediaContent;
                                        }
                                ).collect(Collectors.toList())
                        ));
                    }
                    System.out.println("Done");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        return rssFeedListMusic;
    }

    @Scheduled(cron="0 0 12 * * ?")
    @Override
    public List<RssFeedDto> getRssFeedAnime() {
        List<RssFeedDto> rssFeedListAnimes = new ArrayList<>();

        List<String> rssFeedAnimeSourcesList = Arrays.asList(ANIMENEWSNETWORK_RSS_FEED_URL, HONEYSANIME_RSS_FEED_URL,
                ALLTHEANIME_RSS_FEED_URL,
                OTAKUKART_RSS_FEED_URL,
                WRONGEVERYTIME_RSS_FEED_URL,
                BENTHESAGE_RSS_FEED_URL,
                RANDOMC_RSS_FEED_URL,
                THEANIMEDAILY_RSS_FEED_URL,
                QUOTETHEANIME_RSS_FEED_URL,
                ANIMENEWSAND_RSS_FEED_URL
        );

        rssFeedAnimeSourcesList.forEach(el -> {

            try {


                try (XmlReader reader = new XmlReader(new URL(el))) {
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


                        rssFeedListAnimes.add(new RssFeedDto(
                                entry.getTitle().trim(),
                                entry.getPublishedDate(),
                                entry.getLink().trim(),
                                entry.getAuthor().trim(),
                                entry.getDescription().getValue().trim(),
                                entry.getEnclosures().stream().map(
                                        elem -> {
                                            MediaContentDto mediaContent = new MediaContentDto();
                                            mediaContent.setType(elem.getType());
                                            mediaContent.setUrl(elem.getUrl());
                                            return mediaContent;
                                        }
                                ).collect(Collectors.toList())
                        ));
                    }
                    System.out.println("Done");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        return rssFeedListAnimes;
    }
}
