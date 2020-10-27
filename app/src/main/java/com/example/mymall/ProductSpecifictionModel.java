package com.example.mymall;

public class ProductSpecifictionModel {
    public static final int SPECIFICATION_TITLE=0;
    public static final int SPECIFICATION_BODY=1;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    ///////specification title
    private String title;

    public ProductSpecifictionModel(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    ///////specification title

    ///////specification body

    private String featureName;
    private  String fratureValue;

    public ProductSpecifictionModel(int type, String featureName, String fratureValue) {
        this.type = type;
        this.featureName = featureName;
        this.fratureValue = fratureValue;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFratureValue() {
        return fratureValue;
    }

    public void setFratureValue(String fratureValue) {
        this.fratureValue = fratureValue;
    }
    ///////specification body

}
