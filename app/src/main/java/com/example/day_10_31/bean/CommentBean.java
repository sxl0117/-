package com.example.day_10_31.bean;

public class CommentBean {
    @com.google.gson.annotations.SerializedName("swagger")
    private String _$Swagger290; // FIXME check this code
    private InfoBean info;
    private String host;
    private String basePath;
   // private PathsBean paths;
  //  private DefinitionsBean definitions;
   // private java.util.List<TagsBean> tags;

    public static class InfoBean {
        /**
         * version : 1.0
         * title : Jetpack项目Api文档
         */

        private String version;
        private String title;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
