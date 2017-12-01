package com.fizz.spring.part2;

import java.util.List;

public class BlackDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public BlackDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        if (tracks != null && tracks.size() > 0) {
            for (String track : tracks) {
                System.out.println("-Track:" + track);
            }
        } else {
            System.out.println("该磁带未载入歌曲");
        }
    }

}
