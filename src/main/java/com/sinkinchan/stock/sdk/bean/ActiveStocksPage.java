package com.sinkinchan.stock.sdk.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 陈欣健
 * @describe :活跃股
 * @since :2016-07-16 下午8:32
 **/
public class ActiveStocksPage {

    /**
     * code : 0
     * date : 2016-07-15 15:09:14
     * page : 1
     * pagesize : 30
     * total : 63
     */

    private int code;
    private String date;
    private int page;
    private int pagesize;
    private int total;
    /**
     * 神州信息 换手率15.80 %涨幅7.91 %量比1.35
     * code : sz000555
     * name : 神州信息
     * hs_hsl : 0.158
     * hs_zf : 0.0791
     * hs_lb : 1.35348336842
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ActiveStocksPage{" +
                "code=" + code +
                ", date='" + date + '\'' +
                ", page=" + page +
                ", pagesize=" + pagesize +
                ", total=" + total +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        private String code;
        private String name;
        private double hs_hsl;
        private double hs_zf;
        private double hs_lb;
        private transient double price;
        private transient double updown;
        private transient double high;
        private transient double low;
        private transient double open;
        private transient double volume;
        private transient double turnover;
        private transient double percent;
        private transient double yestclose;

        public double getPercent() {
            return percent;
        }

        public DataBean setPercent(double percent) {
            this.percent = percent;
            return this;
        }

        public double getPrice() {
            return price;
        }

        public DataBean setPrice(double price) {
            this.price = price;
            return this;
        }

        public double getUpdown() {
            return updown;
        }

        public DataBean setUpdown(double updown) {
            this.updown = updown;
            return this;
        }

        public double getHigh() {
            return high;
        }

        public DataBean setHigh(double high) {
            this.high = high;
            return this;
        }

        public double getLow() {
            return low;
        }

        public DataBean setLow(double low) {
            this.low = low;
            return this;
        }

        public double getOpen() {
            return open;
        }

        public DataBean setOpen(double open) {
            this.open = open;
            return this;
        }

        public double getVolume() {
            return volume;
        }

        public DataBean setVolume(double volume) {
            this.volume = volume;
            return this;
        }

        public double getTurnover() {
            return turnover;
        }

        public DataBean setTurnover(double turnover) {
            this.turnover = turnover;
            return this;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name + "\n (" + code + ")";
        }

        public String getSimpleName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getHs_hsl() {
            return hs_hsl;
        }

        public void setHs_hsl(double hs_hsl) {
            this.hs_hsl = hs_hsl;
        }

        public double getHs_zf() {
            return hs_zf;
        }

        public void setHs_zf(double hs_zf) {
            this.hs_zf = hs_zf;
        }

        public double getHs_lb() {
            return hs_lb;
        }

        public void setHs_lb(double hs_lb) {
            this.hs_lb = hs_lb;
        }

        public double getYestclose() {
            return yestclose;
        }

        public DataBean setYestclose(double yestclose) {
            this.yestclose = yestclose;
            return this;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", hs_hsl=" + hs_hsl +
                    ", hs_zf=" + hs_zf +
                    ", hs_lb=" + hs_lb +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DataBean dataBean = (DataBean) o;

            return code != null ? code.equals(dataBean.code) : dataBean.code == null;

        }

        @Override
        public int hashCode() {
            return code != null ? code.hashCode() : 0;
        }
    }

    public static class Param {
        //换手率
//        private String hsl;
        private Type change;
        //量比
//        private String lb;
        private Type lb;
        //涨幅
//        private String zf;
        private Type up;
        //页码
        private int page = 1;
        private int pageSize;

        public enum Type {
            CHANGE_5(0, "0.05", "5%"),
            CHANGE_7(1, "0.07", "7%"),
            CHANGE_10(2, "0.1", "10%"),
            CHANGE_15(3, "0.15", "15%"),
            UP_3(0, "0.03", "3%"),
            UP_6(1, "0.06", "6%"),
            UP_8(2, "0.08", "8%"),
            UP_10(3, "0.1", "10%"),
            LB_1(0, "1", "1"),
            LB_3(1, "3", "3"),
            LB_5(2, "5", "5"),
            LB_7(3, "7", "7"),;

            Type(int index, String value, String text) {
                this.index = index;
                this.value = value;
                this.text = text;
            }

            public int index;
            public String value;
            public String text;

        }

        public Param(Type change, Type lb, Type up, int page, int pageSize) {
            this.change = change;
            this.lb = lb;
            this.up = up;
            this.page = page;
            this.pageSize = pageSize;
        }

        public Param() {
        }

        public int getPageSize() {
            return pageSize;
        }

        public Param setPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public int getPage() {
            return page;
        }

        public Param setPage(int page) {
            this.page = page;
            return this;
        }

        public Type getChange() {
            return change;
        }

        public Param setChange(Type change) {
            this.change = change;
            return this;
        }

        public Type getLb() {
            return lb;
        }

        public Param setLb(Type lb) {
            this.lb = lb;
            return this;
        }

        public Type getUp() {
            return up;
        }

        public Param setUp(Type up) {
            this.up = up;
            return this;
        }

        public Map<String, String> getParams() {
            final Map<String, String> params = new HashMap<String, String>();
            params.put("hs_hsl", change.value);
            params.put("hs_zf", up.value);
            params.put("hs_lb", lb.value);
            params.put("_func", "filter");
            params.put("_page", page + "");
            params.put("_pagesize", pageSize + "");
            params.put("_default", "1");
            params.put("_du_r_t", System.currentTimeMillis() + "");
            return params;
        }
    }
}
