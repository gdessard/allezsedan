package com.allezsedan.sedanfootball.bean.news;

import java.util.List;

/**
 * Data of Channel (RSS version 2)
 * Created by dessard on 26/05/15.
 */
public class Channel {

    private String title;

    private String link;

    private List<Item> itemList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
