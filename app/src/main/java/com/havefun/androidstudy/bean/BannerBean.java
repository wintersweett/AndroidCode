package com.havefun.androidstudy.bean;

import java.io.Serializable;
import java.util.List;

public class BannerBean implements Serializable {


    public int errorCode;
    public String errorMsg;
    public List<DataDTO> data;

    public static class DataDTO implements Serializable {
        public String desc;
        public int id;
        public String imagePath;
        public int isVisible;
        public int order;
        public String title;
        public int type;
        public String url;

        @Override
        public String toString() {
            return "DataDTO{" +
                    "desc='" + desc + '\'' +
                    ", id=" + id +
                    ", imagePath='" + imagePath + '\'' +
                    ", isVisible=" + isVisible +
                    ", order=" + order +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
