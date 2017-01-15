package com.sinkinchan.stock.sdk.bean;

import com.sinkinchan.stock.sdk.utils.DateUtil;
import com.sun.istack.internal.NotNull;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 16/9/3.
 */
public class StockHistoryPrice {

    private Date time;
    //    开盘价
    private double openPrice;
    //    最高价
    private double heightPrice;
    //    最低价
    private double lowPrice;
    //    收盘价
    private double closePrice;
    //    涨跌额
    private double upDownPrice;
    //    涨跌幅(%)
    private double upDownPercent;
    //    成交量(手)
    private String volumeOfBusiness;
    //    成交金额(万元)
    private String turnover;
    //振幅(%)
    private double amplitude;
    //换手率(%)
    private double change;

    public StockHistoryPrice(Elements element) {
        if (element != null && element.size() == 11) {
            try {
                time = DateUtil.parseDate(element.get(0).text(), DateUtil.DEFAULT_DATE_FORMAT);
                openPrice = Double.valueOf(element.get(1).text());
                heightPrice = Double.valueOf(element.get(2).text());
                lowPrice = Double.valueOf(element.get(3).text());
                closePrice = Double.valueOf(element.get(4).text());
                upDownPrice = Double.valueOf(element.get(5).text());
                upDownPercent = Double.valueOf(element.get(6).text());
                volumeOfBusiness = element.get(7).text();
                turnover = element.get(8).text();
                amplitude = Double.valueOf(element.get(9).text());
                change = Double.valueOf(element.get(10).text());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getTime() {
        return time;
    }

    public StockHistoryPrice setTime(Date time) {
        this.time = time;
        return this;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public StockHistoryPrice setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public double getHeightPrice() {
        return heightPrice;
    }

    public StockHistoryPrice setHeightPrice(double heightPrice) {
        this.heightPrice = heightPrice;
        return this;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public StockHistoryPrice setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
        return this;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public StockHistoryPrice setClosePrice(double closePrice) {
        this.closePrice = closePrice;
        return this;
    }

    public double getUpDownPrice() {
        return upDownPrice;
    }

    public StockHistoryPrice setUpDownPrice(double upDownPrice) {
        this.upDownPrice = upDownPrice;
        return this;
    }

    public double getUpDownPercent() {
        return upDownPercent;
    }

    public StockHistoryPrice setUpDownPercent(double upDownPercent) {
        this.upDownPercent = upDownPercent;
        return this;
    }

    public String getVolumeOfBusiness() {
        return volumeOfBusiness;
    }

    public StockHistoryPrice setVolumeOfBusiness(String volumeOfBusiness) {
        this.volumeOfBusiness = volumeOfBusiness;
        return this;
    }

    public String getTurnover() {
        return turnover;
    }

    public StockHistoryPrice setTurnover(String turnover) {
        this.turnover = turnover;
        return this;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public StockHistoryPrice setAmplitude(double amplitude) {
        this.amplitude = amplitude;
        return this;
    }

    public double getChange() {
        return change;
    }

    public StockHistoryPrice setChange(double change) {
        this.change = change;
        return this;
    }

    public static class Param {
        private String code;
        private Date startTime;
        private Date endTime;
        private String currentTime;
        private String year;
        private String quarterly;

        public Param(@NotNull String code, @NotNull Date startTime, @NotNull Date endTime) {
            this.code = code;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Param(@NotNull String code, @NotNull String year, @NotNull String quarterly) {
            this.code = code;
            this.year = year;
            this.quarterly = quarterly;
        }

        public String getCode() {
            return code;
        }

        public Param setCode(String code) {
            this.code = code;
            return this;
        }

        public Date getStartTime() {
            return startTime;
        }

        public Param setStartTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public Date getEndTime() {
            return endTime;
        }

        public Param setEndTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public String getCurrentTime() {
            return System.currentTimeMillis() + "";
        }

        public Param setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
            return this;
        }

        public String getStrStartTime() {
            if (startTime != null) {
                return DateUtil.toString(startTime, DateUtil.DEFAULT_DATE_FORMAT);
            }
            return null;
        }

        public String getStrEndTime() {
            if (endTime != null) {
                return DateUtil.toString(endTime, DateUtil.DEFAULT_DATE_FORMAT);
            }
            return null;
        }

        public Map<String, String> getParams() {
            Map<String, String> params = new HashMap<String, String>();
            params.put("year", year);
            params.put("season", quarterly);
            return params;
        }
    }

    @Override
    public String toString() {
        return "StockHistoryPrice{" +
                "time=" + time +
                ", openPrice=" + openPrice +
                ", heightPrice=" + heightPrice +
                ", lowPrice=" + lowPrice +
                ", closePrice=" + closePrice +
                ", upDownPrice=" + upDownPrice +
                ", upDownPercent=" + upDownPercent +
                ", volumeOfBusiness='" + volumeOfBusiness + '\'' +
                ", turnover='" + turnover + '\'' +
                ", amplitude=" + amplitude +
                ", change=" + change +
                '}';
    }
}
