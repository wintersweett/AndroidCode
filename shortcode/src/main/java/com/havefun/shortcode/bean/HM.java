package com.havefun.shortcode.bean;

import java.util.List;

public class HM {

    private int flag;
    private DataDTO data;

    public static class DataDTO {
        private List<TagListDTO> tagList;

        public static class TagListDTO {
            private boolean customTagFormatFlag;
            private String customTagName;
        }
    }
}
