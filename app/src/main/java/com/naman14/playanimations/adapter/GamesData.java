package com.naman14.playanimations.adapter;

/**
 * Created by naman on 27/05/15.
 */
public class GamesData {

    int cover, icon;
    String gameName, publisher;

    public String getGameName() {
        return gameName;
    }

    public void setgameName(String name) {
        this.gameName = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
