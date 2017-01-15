package com.sinkinchan.stock.sdk.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 16/9/4.
 * 敢死队股
 * 在投资者心中，敢死队往往是一群制造涨停“无极限”的好手，通过统计公开交易榜单出现频率不难扑捉到他们的身影，敢死队频繁出击的背后集结了A股市场最另类的操盘资金。
 * 1.最近一日龙虎榜个股
 * 2.过去一年上榜频次达到10%的营业部操作个股
 */
public class DeathSquadStockPage {


    /**
     * code : 0
     * date : 2016-09-02
     * page : 1
     * pagesize : 30
     * total : 14
     */

    private int code;
    private String date;
    private int page;
    private int pagesize;
    private int total;
    /**
     * code : sz300381
     * name : 溢多利
     * yyb : {"华泰证券股份有限公司厦门厦禾路证券营业部":0.149221453287}
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
        return "DeathSquadStockPage{" +
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
        private Map<String, String> yyb;
        private transient double price;
        private transient double updown;
        private transient double high;
        private transient double low;
        private transient double open;
        private transient double volume;
        private transient double turnover;
        private transient double percent;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, String> getYyb() {
            return yyb;
        }

        public DataBean setYyb(Map<String, String> yyb) {
            this.yyb = yyb;
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
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", yyb=" + yyb +
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
        //        _func=lhb&_page=1&_pagesize=30&hs_lhb=0.1&_default=1&_du_r_t=0.07757729846174022
        private int page;
        private int pageSize;

        public Param(int page, int pageSize) {
            this.page = page;
            this.pageSize = pageSize;
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

        public Map<String, String> getParams() {
            final Map<String, String> params = new HashMap<String, String>();
            params.put("_func", "lhb");
            params.put("_page", "" + page);
            params.put("_pagesize", "" + pageSize);
            params.put("hs_lhb", "0.1");
            params.put("_default", "1");
            params.put("_du_r_t", System.currentTimeMillis() + "");
            return params;
        }
    }
}
