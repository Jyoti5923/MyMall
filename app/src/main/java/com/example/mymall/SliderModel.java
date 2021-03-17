package com.example.mymall;

public class SliderModel {
    private String banner;

    private String baackgroundColor;

    public SliderModel(String banner, String baackgroundColor) {
        this.banner = banner;
        this.baackgroundColor = baackgroundColor;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBaackgroundColor() {
        return baackgroundColor;
    }

    public void setBaackgroundColor(String baackgroundColor) {
        this.baackgroundColor = baackgroundColor;
    }
}
