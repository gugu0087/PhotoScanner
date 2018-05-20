package com.xyc.gugu.picturescanner;

import android.support.annotation.DrawableRes;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gugu on 2018/5/20.
 */

public class PicConfig {
    public static boolean mIsShowNumber = true;
    public static int position = 0;
    public static String path = "pictures";
    public static ArrayList<String> list;

    public PicConfig(PicConfig.Builder builder) {
        mIsShowNumber = builder.mIsShowNumber;
        path = builder.path;
        position = builder.position;
        list = builder.list;
    }

    public static class Builder implements Serializable {
        private boolean mIsShowNumber = true;
        private String path = "pictures";
        private int position = 0;
        private ArrayList<String> list;

        public Builder() {

        }

        public PicConfig.Builder setListData(ArrayList<String> list) {
            this.list = list;
            return this;
        }

        public PicConfig.Builder setPosition(int position) {
            this.position = position;
            return this;
        }

        public PicConfig.Builder setIsShowNumber(boolean mIsShowNumber) {
            this.mIsShowNumber = mIsShowNumber;
            return this;
        }


        public PicConfig.Builder setDownloadPath(String path) {
            this.path = path;
            return this;
        }

        public PicConfig build() {
            return new PicConfig(this);
        }
    }

}
