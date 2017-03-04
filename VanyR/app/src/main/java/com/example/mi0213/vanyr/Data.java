package com.example.mi0213.vanyr;

import android.net.Uri;

import java.net.URI;

/**
 * Created by mi0213 on 04/03/17.
 */

public class Data {
    private int imgRes;
    private String title = null;

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data(int imgRes, String title) {
        this.imgRes=imgRes;
        this.title = title;
    }
}
