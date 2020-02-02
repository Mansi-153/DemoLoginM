package com.example.demologin.Adapter;

public class example_item {
    private int mimageResource;
    private  String mtitle;
    public example_item(int imageResource,String s1)
    { this.mimageResource=imageResource;
        this.mtitle=s1;

    }

    public int getMimageResource() {
        return mimageResource;
    }

    public String getMtitle() {
        return mtitle;
    }
}
