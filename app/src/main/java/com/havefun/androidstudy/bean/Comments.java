package com.havefun.androidstudy.bean;

import java.util.List;
public class Comments {

    private DataDTO data;
    private int errorCode;
    private String errorMsg;

    public static class DataDTO {
        private int curPage;
        private List<DatasDTO> datas;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;

        public static class DatasDTO {
            private int anonymous;
            private int appendForContent;
            private int articleId;
            private boolean canEdit;
            private String content;
            private String contentMd;
            private int id;
            private String niceDate;
            private long publishDate;
            private int replyCommentId;
            private List<ReplyCommentsDTO> replyComments;
            private int rootCommentId;
            private int status;
            private int toUserId;
            private String toUserName;
            private int userId;
            private String userName;
            private int zan;


            public static class ReplyCommentsDTO {
                private int anonymous;
                private int appendForContent;
                private int articleId;
                private boolean canEdit;
                private String content;
                private String contentMd;
                private int id;
                private String niceDate;
                private long publishDate;
                private int replyCommentId;
                private List<?> replyComments;
                private int rootCommentId;
                private int status;
                private int toUserId;
                private String toUserName;
                private int userId;
                private String userName;
                private int zan;
            }

            @Override
            public String toString() {
                return "DatasDTO{" +
                        "anonymous=" + anonymous +
                        ", appendForContent=" + appendForContent +
                        ", articleId=" + articleId +
                        ", canEdit=" + canEdit +
                        ", content='" + content + '\'' +
                        ", contentMd='" + contentMd + '\'' +
                        ", id=" + id +
                        ", niceDate='" + niceDate + '\'' +
                        ", publishDate=" + publishDate +
                        ", replyCommentId=" + replyCommentId +
                        ", replyComments=" + replyComments +
                        ", rootCommentId=" + rootCommentId +
                        ", status=" + status +
                        ", toUserId=" + toUserId +
                        ", toUserName='" + toUserName + '\'' +
                        ", userId=" + userId +
                        ", userName='" + userName + '\'' +
                        ", zan=" + zan +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataDTO{" +
                    "curPage=" + curPage +
                    ", datas=" + datas +
                    ", offset=" + offset +
                    ", over=" + over +
                    ", pageCount=" + pageCount +
                    ", size=" + size +
                    ", total=" + total +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Comments{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
