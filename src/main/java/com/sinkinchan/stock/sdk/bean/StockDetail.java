package com.sinkinchan.stock.sdk.bean;

/**
 * 股票详情
 */
public class StockDetail {
    private String code;
    //涨幅
    private double percent;
    //最高
    private double high;
    //卖三数目
    private int askvol3;
    //卖二数目
    private int askvol2;
    //卖五数目
    private int askvol5;
    //卖四数目
    private int askvol4;
    //卖一数目
    private int askvol1;
    //当前价格
    private double price;
    //开盘价
    private double open;
    //买5价格
    private double bid5;
    //买4价格
    private double bid4;
    //买3价格
    private double bid3;
    //买2价格
    private double bid2;
    //买1价格
    private double bid1;
    //最低价格
    private double low;
    //上涨或下跌的价格
    private double updown;
    //类别 上证或深证
    private String type;
    //买1数目
    private int bidvol1;
    private int status;
    //买3数目
    private int bidvol3;
    //买2数目
    private int bidvol2;
    private String symbol;
    private String update;
    //买5数目
    private int bidvol5;
    //买4数目
    private int bidvol4;
    //成交量
    private int volume;
    //买5价格
    private double ask5;
    //买4价格
    private double ask4;
    //买1价格
    private double ask1;
    //股票名称
    private String name;
    //买3价格
    private double ask3;
    //买2价格
    private double ask2;
    //箭头
    private String arrow;
    //时间
    private String time;
    //昨收
    private double yestclose;
    //成交额
    private double turnover;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public int getAskvol3() {
        return askvol3;
    }

    public void setAskvol3(int askvol3) {
        this.askvol3 = askvol3;
    }

    public int getAskvol2() {
        return askvol2;
    }

    public void setAskvol2(int askvol2) {
        this.askvol2 = askvol2;
    }

    public int getAskvol5() {
        return askvol5;
    }

    public void setAskvol5(int askvol5) {
        this.askvol5 = askvol5;
    }

    public int getAskvol4() {
        return askvol4;
    }

    public void setAskvol4(int askvol4) {
        this.askvol4 = askvol4;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getBid5() {
        return bid5;
    }

    public void setBid5(double bid5) {
        this.bid5 = bid5;
    }

    public double getBid4() {
        return bid4;
    }

    public void setBid4(double bid4) {
        this.bid4 = bid4;
    }

    public double getBid3() {
        return bid3;
    }

    public void setBid3(double bid3) {
        this.bid3 = bid3;
    }

    public double getBid2() {
        return bid2;
    }

    public void setBid2(double bid2) {
        this.bid2 = bid2;
    }

    public double getBid1() {
        return bid1;
    }

    public void setBid1(double bid1) {
        this.bid1 = bid1;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getUpdown() {
        return updown;
    }

    public void setUpdown(double updown) {
        this.updown = updown;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBidvol1() {
        return bidvol1;
    }

    public void setBidvol1(int bidvol1) {
        this.bidvol1 = bidvol1;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBidvol3() {
        return bidvol3;
    }

    public void setBidvol3(int bidvol3) {
        this.bidvol3 = bidvol3;
    }

    public int getBidvol2() {
        return bidvol2;
    }

    public void setBidvol2(int bidvol2) {
        this.bidvol2 = bidvol2;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public int getBidvol5() {
        return bidvol5;
    }

    public void setBidvol5(int bidvol5) {
        this.bidvol5 = bidvol5;
    }

    public int getBidvol4() {
        return bidvol4;
    }

    public void setBidvol4(int bidvol4) {
        this.bidvol4 = bidvol4;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getAskvol1() {
        return askvol1;
    }

    public void setAskvol1(int askvol1) {
        this.askvol1 = askvol1;
    }

    public double getAsk5() {
        return ask5;
    }

    public void setAsk5(double ask5) {
        this.ask5 = ask5;
    }

    public double getAsk4() {
        return ask4;
    }

    public void setAsk4(double ask4) {
        this.ask4 = ask4;
    }

    public double getAsk1() {
        return ask1;
    }

    public void setAsk1(double ask1) {
        this.ask1 = ask1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAsk3() {
        return ask3;
    }

    public void setAsk3(double ask3) {
        this.ask3 = ask3;
    }

    public double getAsk2() {
        return ask2;
    }

    public void setAsk2(double ask2) {
        this.ask2 = ask2;
    }

    public String getArrow() {
        return arrow;
    }

    public void setArrow(String arrow) {
        this.arrow = arrow;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getYestclose() {
        return yestclose;
    }

    public void setYestclose(double yestclose) {
        this.yestclose = yestclose;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return "StockDetail{" +
                "code='" + code + '\'' +
                ", percent=" + percent +
                ", high=" + high +
                ", askvol3=" + askvol3 +
                ", askvol2=" + askvol2 +
                ", askvol5=" + askvol5 +
                ", askvol4=" + askvol4 +
                ", askvol1=" + askvol1 +
                ", price=" + price +
                ", open=" + open +
                ", bid5=" + bid5 +
                ", bid4=" + bid4 +
                ", bid3=" + bid3 +
                ", bid2=" + bid2 +
                ", bid1=" + bid1 +
                ", low=" + low +
                ", updown=" + updown +
                ", type='" + type + '\'' +
                ", bidvol1=" + bidvol1 +
                ", status=" + status +
                ", bidvol3=" + bidvol3 +
                ", bidvol2=" + bidvol2 +
                ", symbol='" + symbol + '\'' +
                ", update='" + update + '\'' +
                ", bidvol5=" + bidvol5 +
                ", bidvol4=" + bidvol4 +
                ", volume=" + volume +
                ", ask5=" + ask5 +
                ", ask4=" + ask4 +
                ", ask1=" + ask1 +
                ", name='" + name + '\'' +
                ", ask3=" + ask3 +
                ", ask2=" + ask2 +
                ", arrow='" + arrow + '\'' +
                ", time='" + time + '\'' +
                ", yestclose=" + yestclose +
                ", turnover=" + turnover +
                '}';
    }
}
