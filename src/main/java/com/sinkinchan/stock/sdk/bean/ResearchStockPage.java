package com.sinkinchan.stock.sdk.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 16/9/4.
 * 研报股
 * 分析师的研究报告对机构资金的影响力极大，机构研究思路的变化往往是机构资金选股思路变化的主要信号。据统计，二级市场的机构资金消化研究报告“学以致用”，曾经在二级市场上掀起了一波又一波的冷门股上涨的现象。
 */
public class ResearchStockPage {

    /**
     * code : 0
     * date : 2016-09-02
     * page : 1
     * pagesize : 30
     * total : 27
     */

    private int code;
    private String date;
    private int page;
    private int pagesize;
    private int total;
    /**
     * tzpj : 增持
     * mbjg :
     * code : sh600887
     * jgjc : 东北证券
     * fbrq : 2016-08-29
     * name : 伊利股份
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
        return "ResearchStockPage{" +
                "code=" + code +
                ", date='" + date + '\'' +
                ", page=" + page +
                ", pagesize=" + pagesize +
                ", total=" + total +
                ", data=" + data +
                '}';
    }

    public enum Type {
        today("当日研究报告评级调高个股", "hs_yb1"),
        five("5日内研究报告评级调高个股", "hs_yb5"),
        thirty("30日内研究报告评级调高个股", "hs_yb30");

        Type(String desc, String index) {
            this.desc = desc;
            this.index = index;
        }

        private String desc;
        private String index;

        public String getDesc() {
            return desc;
        }

        public Type setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public String getIndex() {
            return index;
        }

        public Type setIndex(String index) {
            this.index = index;
            return this;
        }
    }

    public static class DataBean {
        private String tzpj;
        private String mbjg;
        private String code;
        private String jgjc;
        private String fbrq;
        private String name;
        private transient double price;
        private transient double updown;
        private transient double high;
        private transient double low;
        private transient double open;
        private transient double volume;
        private transient double turnover;
        private transient double percent;

        public String getTzpj() {
            return tzpj;
        }

        public void setTzpj(String tzpj) {
            this.tzpj = tzpj;
        }

        public String getMbjg() {
            return mbjg;
        }

        public void setMbjg(String mbjg) {
            this.mbjg = mbjg;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getJgjc() {
            return jgjc;
        }

        public void setJgjc(String jgjc) {
            this.jgjc = jgjc;
        }

        public String getFbrq() {
            return fbrq;
        }

        public void setFbrq(String fbrq) {
            this.fbrq = fbrq;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public double getPercent() {
            return percent;
        }

        public DataBean setPercent(double percent) {
            this.percent = percent;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DataBean dataBean = (DataBean) o;

            return code.equals(dataBean.code);

        }

        @Override
        public int hashCode() {
            return code.hashCode();
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "tzpj='" + tzpj + '\'' +
                    ", mbjg='" + mbjg + '\'' +
                    ", code='" + code + '\'' +
                    ", jgjc='" + jgjc + '\'' +
                    ", fbrq='" + fbrq + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", updown=" + updown +
                    ", high=" + high +
                    ", low=" + low +
                    ", open=" + open +
                    ", volume=" + volume +
                    ", turnover=" + turnover +
                    ", percent=" + percent +
                    '}';
        }
    }

    public static class Param {
        private int page;
        private int pageSize;
        private Type type;

        public Param(int page, int pageSize, Type type) {
            this.page = page;
            this.pageSize = pageSize;
            this.type = type;
        }

        public int getPage() {
            return page;
        }

        public Param setPage(int page) {
            this.page = page;
            return this;
        }

        public int getPageSize() {
            return pageSize;
        }

        public Param setPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Type getType() {
            return type;
        }

        public Param setType(Type type) {
            this.type = type;
            return this;
        }

        public Map<String, String> getParams() {
            final Map<String, String> params = new HashMap<String, String>();
//            _func=ybg&_page=1&_pagesize=30&type=hs_yb5&_du_r_t=0.22728902835368547
            params.put("_func", "ybg");
            params.put("_page", page + "");
            params.put("_pagesize", pageSize + "");
            params.put("type", type.getIndex());
            params.put("_du_r_t", System.currentTimeMillis() + "");
            return params;
        }
    }
}
