package demo.acfun.com.acfundemo.entity;

import java.io.Serializable;

/**
 * Created by chen on 16/6/23.
 */
public class WelComeEntity extends BaseEntity implements Serializable {
    /**
     * txt :
     * updateDate : 1466661734000
     * endDate : 1467253833000
     * openSource :
     * id : 315
     * pic : http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201606/201008352tq5if8k.jpg
     * type : 9
     * startDate : 1466661727000
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        private String txt;
        private long updateDate;
        private long endDate;
        private String openSource;
        private int id;
        private String pic;
        private String base64pic;
        private int type;
        private long startDate;

        public String getBase64pic() {
            return base64pic;
        }

        public void setBase64pic(String base64pic) {
            this.base64pic = base64pic;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public long getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(long updateDate) {
            this.updateDate = updateDate;
        }

        public long getEndDate() {
            return endDate;
        }

        public void setEndDate(long endDate) {
            this.endDate = endDate;
        }

        public String getOpenSource() {
            return openSource;
        }

        public void setOpenSource(String openSource) {
            this.openSource = openSource;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public long getStartDate() {
            return startDate;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }
    }
}
