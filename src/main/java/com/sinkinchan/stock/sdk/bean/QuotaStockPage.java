package com.sinkinchan.stock.sdk.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 16/9/3.
 * 指标股
 * 技术指标的变化和发出的买卖信号，是行情反映到指标中的数值，也是行情的事先变化，我们根据不同市场趋势筛选了较为经典的五个指标选股模型。
 */
public class QuotaStockPage {

    public enum Type {
        type1("曙光初现", "1.MACD金叉：DIF与DEA金叉 2.成交量金叉：5日成交量均线与10日成交量均线金叉 3.均线金叉：5日移动均线与10日移动均线金叉", "hs_sgcx", "1"),
        type2("空中加油", "1.20日和60日均线多头排列 2.凯恩斯多空线金叉（上穿0轴）", "hs_kzjy", "1"),
        type3("超级短线", "1.20日和60日均线多头排列 2.20日均线导数大于0 3.超级短线中的K线上穿0轴", "hs_cjdx", "1"),
        type4("蓄势待发", "1.股价创60日新高 2.60日涨幅不得超过30%", "hs_xsdf", "0"),
        type5("海底捞月", "1.股价10日乖离小于-10 2.股价跌破薛斯通道下轨", "hs_hdly", "0");

        Type(String name, String desc, String index, String aDefault) {
            this.name = name;
            this.desc = desc;
            this.index = index;
            Default = aDefault;
        }

        private String name;
        private String desc;
        private String index;
        private String Default;

        public String getDesc() {
            return desc;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public String getDefault() {
            return Default;
        }
    }

    public static class QuotaStockType1 {

        /**
         * code : 0
         * date : 2016-09-02 15:10:33
         * page : 1
         * pagesize : 30
         * total : 17
         */

        private int code;
        private String date;
        private int page;
        private int pagesize;
        private int total;
        /**
         * vol : 2016-08-31
         * close : 2016-09-02
         * macd : 2016-09-01
         * code : sz300019
         * name : 硅宝科技
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
            return "QuotaStockType1{" +
                    "code=" + code +
                    ", date='" + date + '\'' +
                    ", page=" + page +
                    ", pagesize=" + pagesize +
                    ", total=" + total +
                    ", data=" + data +
                    '}';
        }

        public static class DataBean {
            private String vol;
            private String close;
            private String macd;
            private String code;
            private String name;
            private transient double price;
            private transient double updown;
            private transient double high;
            private transient double low;
            private transient double open;
            private transient double volume;
            private transient double turnover;
            private transient double percent;
            public String getVol() {
                return vol;
            }

            public void setVol(String vol) {
                this.vol = vol;
            }

            public String getClose() {
                return close;
            }

            public void setClose(String close) {
                this.close = close;
            }

            public String getMacd() {
                return macd;
            }

            public void setMacd(String macd) {
                this.macd = macd;
            }

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
                        "vol='" + vol + '\'' +
                        ", close='" + close + '\'' +
                        ", macd='" + macd + '\'' +
                        ", code='" + code + '\'' +
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


    }

    public static class QuotaStockType2 {

        /**
         * code : 0
         * date : 2016-09-02 15:10:33
         * page : 1
         * pagesize : 30
         * total : 20
         */

        private int code;
        private String date;
        private int page;
        private int pagesize;
        private int total;
        /**
         * kns : 2016-09-02
         * code : sh600011
         * name : 华能国际
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
            return "QuotaStockType2{" +
                    "code=" + code +
                    ", date='" + date + '\'' +
                    ", page=" + page +
                    ", pagesize=" + pagesize +
                    ", total=" + total +
                    ", data=" + data +
                    '}';
        }

        public static class DataBean {
            private String kns;
            private String code;
            private String name;
            private transient double price;
            private transient double updown;
            private transient double high;
            private transient double low;
            private transient double open;
            private transient double volume;
            private transient double turnover;
            private transient double percent;

            public String getKns() {
                return kns;
            }

            public void setKns(String kns) {
                this.kns = kns;
            }

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
                        "kns='" + kns + '\'' +
                        ", code='" + code + '\'' +
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
    }

    public static class QuotaStockType3 {

        /**
         * code : 0
         * date : 2016-09-02 15:10:33
         * page : 1
         * pagesize : 30
         * total : 33
         */

        private int code;
        private String date;
        private int page;
        private int pagesize;
        private int total;
        /**
         * cjdx : 2016-09-02
         * code : sh600783
         * name : 鲁信创投
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
            return "QuotaStockType3{" +
                    "code=" + code +
                    ", date='" + date + '\'' +
                    ", page=" + page +
                    ", pagesize=" + pagesize +
                    ", total=" + total +
                    ", data=" + data +
                    '}';
        }

        public static class DataBean {
            private String cjdx;
            private String code;
            private String name;
            private transient double price;
            private transient double updown;
            private transient double high;
            private transient double low;
            private transient double open;
            private transient double volume;
            private transient double turnover;
            private transient double percent;
            public String getCjdx() {
                return cjdx;
            }

            public void setCjdx(String cjdx) {
                this.cjdx = cjdx;
            }

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


            @Override
            public String toString() {
                return "DataBean{" +
                        "cjdx='" + cjdx + '\'' +
                        ", code='" + code + '\'' +
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
        }
    }

    public static class QuotaStockType4 {
        /**
         * code : 0
         * date : 2016-09-02 15:10:33
         * page : 1
         * pagesize : 30
         * total : 35
         */

        private int code;
        private String date;
        private int page;
        private int pagesize;
        private int total;
        /**
         * zf60 : 0.176136363636
         * code : sh600508
         * name : 上海能源
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
            return "QuotaStockType4{" +
                    "code=" + code +
                    ", date='" + date + '\'' +
                    ", page=" + page +
                    ", pagesize=" + pagesize +
                    ", total=" + total +
                    ", data=" + data +
                    '}';
        }

        public static class DataBean {
            private double zf60;
            private String code;
            private String name;
            private transient double price;
            private transient double updown;
            private transient double high;
            private transient double low;
            private transient double open;
            private transient double volume;
            private transient double turnover;
            private transient double percent;
            public double getZf60() {
                return zf60;
            }

            public void setZf60(double zf60) {
                this.zf60 = zf60;
            }

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
                        "zf60=" + zf60 +
                        ", code='" + code + '\'' +
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
//        _func=zhibiao&zf60=,0.3&_default=0&_page=1&_pagesize=30&zhibiao=hs_xsdf&_du_r_t=0.11444718838997336


    }

    public static class QuotaStockType5 {

    }

    public static class Param {
        //_func=zhibiao&_default=1&_page=1&_pagesize=30&zhibiao=hs_sgcx&_du_r_t=0.25723057998160015
        private int page = 1;
        private int pageSize = 30;
        //        private String zhiBiao = "hs_sgcx";
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

        public Map<String, String> getParams() {
            final Map<String, String> params = new HashMap<String, String>();
            params.put("_func", "zhibiao");
            params.put("_default", type.getDefault());
            params.put("_page", page + "");
            params.put("_pagesize", pageSize + "");
            params.put("zhibiao", type.getIndex());
            if (type == Type.type4) {
                params.put("zf60", ",0.3");
            }
            params.put("_du_r_t", System.currentTimeMillis() + "");
            return params;
        }
    }
}
