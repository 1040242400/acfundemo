package demo.acfun.com.acfundemo.entity;

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
     * contentCount : 5
     * contents : [{"actionId":1,"hide":0,"id":42736,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201606/151507477y3qsn5p.jpg","regionId":1,"releasedAt":1465974476000,"shareTagShow":0,"subTitle":"","title":"ACG一周大事件 银魂要出真人版？！","url":"2812284"},{"actionId":1,"hide":0,"id":42576,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201606/15095427q0oe9d7u.jpg","regionId":1,"releasedAt":1465955736000,"shareTagShow":0,"subTitle":"","title":"动漫放映室 心理测量者\u2014\u2014渐进乌托邦","url":"2812878"},{"actionId":1,"hide":0,"id":42464,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201606/14112004fuswgti2.jpg","regionId":1,"releasedAt":1465874416000,"shareTagShow":0,"subTitle":"","title":"守望先锋国服精彩集锦 第三期","url":"2810774"},{"actionId":1,"hide":0,"id":42463,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201606/14111919a1juuaou.jpg","regionId":1,"releasedAt":1465874378000,"shareTagShow":0,"subTitle":"","title":"橙心动漫 给你反派的妹子你要吗？","url":"2809645"},{"actionId":4,"hide":0,"id":42222,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201606/13105727vis8uamn.jpg","regionId":1,"releasedAt":1465786671000,"shareTagShow":0,"subTitle":"","title":"中国好网民\u2014\u2014论Acer的自我修养","url":"http://www.acfun.tv/v/ac2812600"}]
     * goText :
     * hide : 0
     * id : 1
     * image :
     * menuCount : 0
     * name : 轮播图
     * platformId : 1
     * showLine : 0
     * showMore : 0
     * showName : 0
     * sort : 200
     * type : {"id":5,"name":"轮播","value":"carousels"}
     * url :
     */

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
     * id : 5
     * name : 轮播
     * value : carousels
     */

    private TypeBean type;
    private String url;
    /**
     * actionId : 1
     * hide : 0
     * id : 42736
     * image : http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201606/151507477y3qsn5p.jpg
     * regionId : 1
     * releasedAt : 1465974476000
     * shareTagShow : 0
     * subTitle :
     * title : ACG一周大事件 银魂要出真人版？！
     * url : 2812284
     */

    private List<ContentsBean> contents;

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

    public TypeBean getType() {
        return type;
    }

    public void setType(TypeBean type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ContentsBean> getContents() {
        return contents;
    }

    public void setContents(List<ContentsBean> contents) {
        this.contents = contents;
    }

    public static class TypeBean {
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

    public static class ContentsBean {
        private int actionId;
        private int hide;
        private int id;
        private String image;
        private int regionId;
        private long releasedAt;
        private int shareTagShow;
        private String subTitle;
        private String title;
        private String url;

        public int getActionId() {
            return actionId;
        }

        public void setActionId(int actionId) {
            this.actionId = actionId;
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

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
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
    }
}
