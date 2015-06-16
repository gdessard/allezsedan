package com.allezsedan.sedanfootball.bean.news;

import java.util.Date;

/**
 * Reprensent un itm of RSS flux (version 2)
 * Created by dessard on 26/05/15.
 */
public class Item {

    private String title;

    private Date pubDate;

    private String description;

    private String link;

    private Enclosure enclosure;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public String getLink() {

        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
