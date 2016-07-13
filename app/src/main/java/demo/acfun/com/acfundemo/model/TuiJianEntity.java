package demo.acfun.com.acfundemo.model;

import java.util.List;

/**
 * Created by chen on 16/6/15.
 */

public class TuiJianEntity extends BaseEntity {
    //数据类型
    public final static int LunBoTuPian = 5;
    public final static int ShiPing = 1;
    public final static int Hengfu = 6;
    public final static int XiangJiaoBang = 12;
    public final static int FanJu = 3;
    public final static int WenZhang = 2;

     /**
     * belong : 0
     * channelId : 0
     * contentCount : 3
     * contents : [{"channelId":86,"image":"http://imgs.aixifan.com/content/2016_07_11/1468239270.jpg","intro":"你经历过毕业吗？本期视频献给所有已经毕业&amp;amp;即将毕业的人。也算是送给自己的毕业礼物了：）微信订阅：dapapi","owner":{"avatar":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/26181522wk4rjc21.jpg","id":2526701,"name":"papi酱"},"regionId":183,"releaseDate":1468239598000,"status":2,"title":"papi酱\u2014\u2014本期视频献给所有已经毕业和即将毕业的人","url":"2885831","visit":{"comments":465,"danmakuSize":476,"goldBanana":3012,"score":0,"stows":1312,"ups":0,"views":177369}},{"channelId":170,"image":"http://imgs.aixifan.com/content/2016_07_11/1468246183.jpg","intro":"【守望逗比】第五期 学医救不了ZZ队友  感谢大家的投稿，部分素材没插进去，下一期有合适的BGM会怼进去，感谢大家伙的支持哈","owner":{"avatar":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201606/211116021uhlm357.jpg","id":4927815,"name":"守望逗比"},"regionId":183,"releaseDate":1468246199000,"status":2,"title":"【守望逗比】第五期 学医救不了ZZ队友","url":"2886136","visit":{"comments":80,"danmakuSize":379,"goldBanana":2274,"score":0,"stows":1129,"ups":0,"views":71744}},{"channelId":141,"image":"http://imgs.aixifan.com/content/2016_07_11/1468249246.jpg","intro":"《一屋老友记》【粤语合辑】：http://www.acfun.tv/a/aa4956607\r<br/>微信bdtvb8提供该视频高清资源免费下载。另外，求5蕉支援，求弹幕，你们懂的！┑(￣▽ ￣)┍","owner":{"avatar":"http://cdn.aixifan.com/dotnet/20120923/style/image/avatar.jpg","id":4038098,"name":"郭女王SAMA"},"regionId":183,"releaseDate":1468249290000,"status":2,"title":"【TVB】 一屋老友记 14 【粤语中字】","url":"2886260","visit":{"comments":82,"danmakuSize":2082,"goldBanana":1502,"score":0,"stows":672,"ups":0,"views":103197}}]
     * goText :
     * hide : 2
     * id : 183
     * image : http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201601/14190344l0kvp4fa.png
     * menuCount : 0
     * menus : [{"actionId":6,"channelId":63,"hide":0,"id":15,"image":"","name":"更多文章内容","regionId":21,"sort":0,"url":""}]
     * name : 香蕉排行榜
     * platformId : 1
     * showLine : 1
     * showMore : 0
     * showName : 1
     * sort : 101
     * subTitle : 1
     * type : {"id":12,"name":"视频_香蕉榜","value":"videos_banana_list"}
     * url :
     * version : 4.1.0
     */

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        private int belong;
        private int channelId;
        private int contentCount;
        private String goText;
        private int hide;
        private int id;
        private String image;
        private int menuCount;
        private String name;
        private int platformId;
        private int showLine;
        private int showMore;
        private int showName;
        private int sort;
        private String subTitle;
        /**
         * id : 12
         * name : 视频_香蕉榜
         * value : videos_banana_list
         */

        private Type type;
        private String url;
        private String version;
        /**
         * channelId : 86
         * image : http://imgs.aixifan.com/content/2016_07_11/1468239270.jpg
         * intro : 你经历过毕业吗？本期视频献给所有已经毕业&amp;amp;即将毕业的人。也算是送给自己的毕业礼物了：）微信订阅：dapapi
         * owner : {"avatar":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/26181522wk4rjc21.jpg","id":2526701,"name":"papi酱"}
         * regionId : 183
         * releaseDate : 1468239598000
         * status : 2
         * title : papi酱——本期视频献给所有已经毕业和即将毕业的人
         * url : 2885831
         * visit : {"comments":465,"danmakuSize":476,"goldBanana":3012,"score":0,"stows":1312,"ups":0,"views":177369}
         */

        private List<Contents> contents;
        /**
         * actionId : 6
         * channelId : 63
         * hide : 0
         * id : 15
         * image :
         * name : 更多文章内容
         * regionId : 21
         * sort : 0
         * url :
         */

        private List<Menus> menus;

        public int getBelong() {
            return belong;
        }

        public void setBelong(int belong) {
            this.belong = belong;
        }

        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

        public int getContentCount() {
            return contentCount;
        }

        public void setContentCount(int contentCount) {
            this.contentCount = contentCount;
        }

        public String getGoText() {
            return goText;
        }

        public void setGoText(String goText) {
            this.goText = goText;
        }

        public int getHide() {
            return hide;
        }

        public void setHide(int hide) {
            this.hide = hide;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getMenuCount() {
            return menuCount;
        }

        public void setMenuCount(int menuCount) {
            this.menuCount = menuCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPlatformId() {
            return platformId;
        }

        public void setPlatformId(int platformId) {
            this.platformId = platformId;
        }

        public int getShowLine() {
            return showLine;
        }

        public void setShowLine(int showLine) {
            this.showLine = showLine;
        }

        public int getShowMore() {
            return showMore;
        }

        public void setShowMore(int showMore) {
            this.showMore = showMore;
        }

        public int getShowName() {
            return showName;
        }

        public void setShowName(int showName) {
            this.showName = showName;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public List<Contents> getContents() {
            return contents;
        }

        public void setContents(List<Contents> contents) {
            this.contents = contents;
        }

        public List<Menus> getMenus() {
            return menus;
        }

        public void setMenus(List<Menus> menus) {
            this.menus = menus;
        }

        public static class Type {
            private int id;
            private String name;
            private String value;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class Contents {
            private int channelId;
            private String image;
            private String intro;
            /**
             * avatar : http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/26181522wk4rjc21.jpg
             * id : 2526701
             * name : papi酱
             */

            private Owner owner;
            private int regionId;
            private long releaseDate;
            private int status;
            private String title;
            private String url;
            /**
             * comments : 465
             * danmakuSize : 476
             * goldBanana : 3012
             * score : 0
             * stows : 1312
             * ups : 0
             * views : 177369
             */

            private Visit visit;
            /**
             * bangumiId : 1470402
             * sort : 310
             * title : 第31话
             * updateTime : 1468058753000
             * videoId : 3790027
             */

            private LatestBangumiVideo latestBangumiVideo;

            public int getChannelId() {
                return channelId;
            }

            public void setChannelId(int channelId) {
                this.channelId = channelId;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public Owner getOwner() {
                return owner;
            }

            public void setOwner(Owner owner) {
                this.owner = owner;
            }

            public int getRegionId() {
                return regionId;
            }

            public void setRegionId(int regionId) {
                this.regionId = regionId;
            }

            public long getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(long releaseDate) {
                this.releaseDate = releaseDate;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Visit getVisit() {
                return visit;
            }

            public void setVisit(Visit visit) {
                this.visit = visit;
            }

            public LatestBangumiVideo getLatestBangumiVideo() {
                return latestBangumiVideo;
            }

            public void setLatestBangumiVideo(LatestBangumiVideo latestBangumiVideo) {
                this.latestBangumiVideo = latestBangumiVideo;
            }

            public static class Owner {
                private String avatar;
                private int id;
                private String name;

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }



            public static class Visit {
                private int comments;
                private int danmakuSize;
                private int goldBanana;
                private int score;
                private int stows;
                private int ups;
                private int views;

                public int getComments() {
                    return comments;
                }

                public void setComments(int comments) {
                    this.comments = comments;
                }

                public int getDanmakuSize() {
                    return danmakuSize;
                }

                public void setDanmakuSize(int danmakuSize) {
                    this.danmakuSize = danmakuSize;
                }

                public int getGoldBanana() {
                    return goldBanana;
                }

                public void setGoldBanana(int goldBanana) {
                    this.goldBanana = goldBanana;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public int getStows() {
                    return stows;
                }

                public void setStows(int stows) {
                    this.stows = stows;
                }

                public int getUps() {
                    return ups;
                }

                public void setUps(int ups) {
                    this.ups = ups;
                }

                public int getViews() {
                    return views;
                }

                public void setViews(int views) {
                    this.views = views;
                }
            }

            public static class LatestBangumiVideo {
                private int bangumiId;
                private int sort;
                private String title;
                private long updateTime;
                private int videoId;

                public int getBangumiId() {
                    return bangumiId;
                }

                public void setBangumiId(int bangumiId) {
                    this.bangumiId = bangumiId;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public long getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(long updateTime) {
                    this.updateTime = updateTime;
                }

                public int getVideoId() {
                    return videoId;
                }

                public void setVideoId(int videoId) {
                    this.videoId = videoId;
                }
            }
        }

        public static class Menus {
            private int actionId;
            private int channelId;
            private int hide;
            private int id;
            private String image;
            private String name;
            private int regionId;
            private int sort;
            private String url;

            public int getActionId() {
                return actionId;
            }

            public void setActionId(int actionId) {
                this.actionId = actionId;
            }

            public int getChannelId() {
                return channelId;
            }

            public void setChannelId(int channelId) {
                this.channelId = channelId;
            }

            public int getHide() {
                return hide;
            }

            public void setHide(int hide) {
                this.hide = hide;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getRegionId() {
                return regionId;
            }

            public void setRegionId(int regionId) {
                this.regionId = regionId;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }


}
