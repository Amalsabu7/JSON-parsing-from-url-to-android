package com.amalsabu.json.HelperClass;

public class ExploreModel {
    private String explore_heading;
    private String explore_image;
    private String explore_desc;
    private Double rating_text;
    private Double rating;

    public ExploreModel(String explore_heading, String explore_image, String explore_desc, Double rating_text, Double rating) {
        this.explore_heading = explore_heading;
        this.explore_image = explore_image;
        this.explore_desc = explore_desc;
        this.rating_text = rating_text;
        this.rating = rating;
    }

    public String getExplore_heading() {
        return explore_heading;
    }

    public void setExplore_heading(String explore_heading) {
        this.explore_heading = explore_heading;
    }

    public String getExplore_image() {
        return explore_image;
    }

    public void setExplore_image(String explore_image) {
        this.explore_image = explore_image;
    }

    public String getExplore_desc() {
        return explore_desc;
    }

    public void setExplore_desc(String explore_desc) {
        this.explore_desc = explore_desc;
    }

    public Double getRating_text() {
        return rating_text;
    }

    public void setRating_text(Double rating_text) {
        this.rating_text = rating_text;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}

