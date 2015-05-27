package com.allezsedan.sedanfootball.bean.news;

/**
 * Enclosure of itm an RSS
 * Created by dessard on 26/05/15.
 */
public class Enclosure {

    private String url;

    private Integer length;

    /**
     * TODO enum sur le type
     */
    private String type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
