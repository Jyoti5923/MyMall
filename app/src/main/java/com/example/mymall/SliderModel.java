package com.example.mymall;

public class SliderModel {
    private int banner;

    private String baackgroundColor;

    public SliderModel(int banner, String baackgroundColor) {
        this.banner = banner;
        this.baackgroundColor = baackgroundColor;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public String getBaackgroundColor() {
        return baackgroundColor;
    }

    public void setBaackgroundColor(String baackgroundColor) {
        this.baackgroundColor = baackgroundColor;
    }
}
