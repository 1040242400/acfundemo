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
     * channelId : 1
     * contentCount : 4
     * contents : [{"actionId":1,"channelId":106,"hide":0,"id":47294,"image":"http://imgs.aixifan.com/content/2016_07_11/1468220722.jpg","intro":"十大畅销漫画，有你喜欢的不。","regionId":9,"releaseDate":1468221102000,"releasedAt":1468290037000,"shareTagShow":0,"status":2,"subTitle":"","title":"岛国十大畅销漫画评选","url":"2884956","visit":{"comments":20,"danmakuSize":17,"goldBanana":25,"score":0,"stows":257,"ups":0,"views":4628}},{"actionId":1,"channelId":106,"hide":0,"id":47292,"image":"http://imgs.aixifan.com/content/2016_07_09/1468096055.gif","intro":"谁告诉我这暴雨梨花针的功夫能练习几年啊！本周柯南已经超神，死神小学生已经忍不住开始亲自动手了。。【听说关注签名有红包拿，感觉关注一波吧】","regionId":9,"releaseDate":1468096167000,"releasedAt":1468289890000,"shareTagShow":0,"status":2,"subTitle":"","title":"柯南新技能已上线：小柯飞刀","url":"2881534","visit":{"comments":97,"danmakuSize":92,"goldBanana":15,"score":0,"stows":307,"ups":0,"views":34448}},{"actionId":1,"channelId":106,"hide":0,"id":47289,"image":"http://imgs.aixifan.com/cms/2016_07_12/1468289723724.png","intro":"无论甜党咸党，在这个问题上，我们只有一个立场","regionId":9,"releaseDate":1468237340000,"releasedAt":1468289726000,"shareTagShow":0,"status":2,"subTitle":"","title":"号外！猴子要南海，鹰酱当后台","url":"2885757","visit":{"comments":63,"danmakuSize":37,"goldBanana":259,"score":0,"stows":179,"ups":0,"views":18534}},{"actionId":1,"channelId":133,"hide":0,"id":47285,"image":"http://imgs.aixifan.com/cms/2016_07_12/1468289633822.png","intro":"链接：http://pan.baidu.com/s/1c2p119e 密码：k02n","regionId":9,"releaseDate":1468057224000,"releasedAt":1468289636000,"shareTagShow":0,"status":2,"subTitle":"","title":"佐仓大法好！内田大法好！","url":"2880540","visit":{"comments":20,"danmakuSize":47,"goldBanana":20,"score":0,"stows":656,"ups":0,"views":14584}}]
     * goText :
     * hide : 0
     * id : 9
     * image : http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201601/13165019vb13fuje.png
     * menuCount : 1
     * menus : [{"actionId":6,"channelId":1,"hide":0,"id":5,"image":"","name":"更多动画内容","regionId":9,"sort":0,"url":""}]
     * name : 动画
     * platformId : 1
     * showLine : 1
     * showMore : 1
     * showName : 1
     * sort : 98
     * type : {"id":1,"name":"视频","value":"videos"}
     * url :
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
        /**
         * id : 1
         * name : 视频
         * value : videos
         */

        private Type type;
        private String url;
        /**
         * actionId : 1
         * channelId : 106
         * hide : 0
         * id : 47294
         * image : http://imgs.aixifan.com/content/2016_07_11/1468220722.jpg
         * intro : 十大畅销漫画，有你喜欢的不。
         * regionId : 9
         * releaseDate : 1468221102000
         * releasedAt : 1468290037000
         * shareTagShow : 0
         * status : 2
         * subTitle :
         * title : 岛国十大畅销漫画评选
         * url : 2884956
         * visit : {"comments":20,"danmakuSize":17,"goldBanana":25,"score":0,"stows":257,"ups":0,"views":4628}
         */

        private List<Contents> contents;
        /**
         * actionId : 6
         * channelId : 1
         * hide : 0
         * id : 5
         * image :
         * name : 更多动画内容
         * regionId : 9
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
            private int actionId;
            private int channelId;
            private int hide;
            private int id;
            private String image;
            private String intro;
            private int regionId;
            private long releaseDate;
            private long releasedAt;
            private int shareTagShow;
            private int status;
            private String subTitle;
            private String title;
            private String url;
            /**
             * comments : 20
             * danmakuSize : 17
             * goldBanana : 25
             * score : 0
             * stows : 257
             * ups : 0
             * views : 4628
             */

            private Visit visit;

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

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
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

            public long getReleasedAt() {
                return releasedAt;
            }

            public void setReleasedAt(long releasedAt) {
                this.releasedAt = releasedAt;
            }

            public int getShareTagShow() {
                return shareTagShow;
            }

            public void setShareTagShow(int shareTagShow) {
                this.shareTagShow = shareTagShow;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
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
