package com.sinkinchan.stock.sdk.bean;

import com.sinkinchan.stock.sdk.source.impls.HandicapSource;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Double.isNaN;

/**
 * 股票盘口
 * Created by apple on 26/10/29.
 */
public class StockHandicap implements Serializable {


    /**
     * 股票编号
     */
    public String code;
    /**
     * 股票名字
     */
    public String name;
    /**
     * 最新价格
     */
    public String latestPrice;
    /**
     * 涨幅
     */
    public String up;
    /**
     * 涨跌
     */
    public String upOrDown;
    /**
     * 换手率
     */
    public String change;
    /**
     * 最高
     */
    public String highest;
    /**
     * 最低
     */
    public String minimum;
    /**
     * 成交量
     */
    public String dealQuantity;
    /**
     * 成交金额
     */
    public String totalDealAmount;
    /**
     * 涨停价格
     */
    public String limitUp;
    /**
     * 跌停价格
     */
    public String limitDown;
    /**
     * 昨天收市价格
     */
    public String yesterdayPrice;
    /**
     * 现手
     */
    public String currentNumber;
    /**
     * 外盘
     */
    public String outerDisc;
    /**
     * 内盘
     */
    public String insideDish;
    /**
     * 量比
     */
    public String volumeRatioIndex;

    /**
     * 收益(季度)
     */
    public String income;
    /**
     * 市盈率 动
     */
    public String PERatiosDynamic;

    /**
     * 市盈率 静
     */
    public String PERatios;
    /**
     * 净资产
     */
    public String netAssets;
    /**
     * 市净率
     */
    public String PBRatio;
    /**
     * 总股本
     */
    public String generalCapital;
    /**
     * 总市值
     */
    public String capitalization;
    /**
     * 流通股本
     */
    public String circulationOfCapitalStock;
    /**
     * 流通市值
     */
    public String circulationOfCapitalization;
    /**
     * 时间
     */
    public String time;
    /**
     * 开盘价
     */
    public String open;
    /**
     * 主力流入
     */
    public String zllr;
    /**
     * 主力流出
     */
    public String zllc;
    /**
     * 主力净流入
     */
    public String zljlr;
    /**
     * 超大单
     */
    public String cdd;
    /**
     * 大单
     */
    public String dd;
    /**
     * 中单
     */
    public String zd;
    /**
     * 小单
     */
    public String xd;

    /**
     * 流入金额单位
     */
    public String unit;

    /**
     * 获取盘口实体
     *
     * @param type
     * @param object
     * @return
     */
    public static StockHandicap getInstance(HandicapSource.HandicapType type, Object object) {
        if (type == null) {
            return null;
        }

        StockHandicap stockHandicap = new StockHandicap();
        switch (type) {
            case DFCF:
                List<String> list = (List<String>) object;
                if (list != null && list.size() > 60) {
                    stockHandicap.setLatestPrice(list.get(5));
                    stockHandicap.setUp(list.get(7));
                    stockHandicap.setUpOrDown(list.get(6));
                    stockHandicap.setChange(list.get(8));
                    stockHandicap.setHighest(list.get(9));
                    stockHandicap.setMinimum(list.get(10));
                    stockHandicap.setDealQuantity(list.get(11));
                    stockHandicap.setTotalDealAmount(list.get(12));
                    stockHandicap.setLimitUp(list.get(13));
                    stockHandicap.setLimitDown(list.get(14));
                    stockHandicap.setYesterdayPrice(list.get(4));
                    stockHandicap.setCurrentNumber(list.get(30));
                    stockHandicap.setOuterDisc(list.get(15));
                    stockHandicap.setInsideDish(list.get(16));
                    stockHandicap.setVolumeRatioIndex(list.get(17));
                    stockHandicap.setIncome(list.get(25));
                    stockHandicap.setPERatiosDynamic(list.get(18));
                    stockHandicap.setPERatios(list.get(19));
                    stockHandicap.setNetAssets(list.get(31));
                    stockHandicap.setPBRatio(list.get(24));
                    stockHandicap.setGeneralCapital(list.get(20));
                    stockHandicap.setCapitalization(list.get(21));
                    stockHandicap.setCirculationOfCapitalization(list.get(23));
                    stockHandicap.setCirculationOfCapitalStock(list.get(22));
                    stockHandicap.setTime(list.get(27));
                    stockHandicap.setCode(list.get(1));
                    stockHandicap.setName(list.get(2));
                    calcMoney(list, stockHandicap);
                }
                break;
        }
        return stockHandicap;
    }

    /**
     * 计算资金流向
     */
    private static void calcMoney(List<String> list, StockHandicap stockHandicap) {
        //资金流
        List<String> zjl_data = new ArrayList<String>();
        for (int i = 32; i <= 39; i++) {
            zjl_data.add(list.get(i));
        }
        //主力
        double zllr = Double.valueOf(zjl_data.get(0)) + Double.valueOf(zjl_data.get(2));
        double zllc = Double.valueOf(zjl_data.get(1)) + Double.valueOf(zjl_data.get(3));
        double zljlr = zllr + zllc;
        //净流入
        double cddjlr = Double.valueOf(zjl_data.get(0)) + Double.valueOf(zjl_data.get(1));
        double ddjlr = Double.valueOf(zjl_data.get(2)) + Double.valueOf(zjl_data.get(3));
        double zdjlr = Double.valueOf(zjl_data.get(4)) + Double.valueOf(zjl_data.get(5));
        double xdjlr = Double.valueOf(zjl_data.get(6)) + Double.valueOf(zjl_data.get(7));
        //净流入
//        [zllr, zllc, zljlr, cddjlr, ddjlr, zdjlr, xdjlr];
        List<Double> jlrArray = new ArrayList<Double>();
        jlrArray.add(zllr);
        jlrArray.add(zllc);
        jlrArray.add(zljlr);
        jlrArray.add(cddjlr);
        jlrArray.add(ddjlr);
        jlrArray.add(zdjlr);
        jlrArray.add(xdjlr);

        double minValue = Collections.min(jlrArray);
        double maxValue = Collections.max(jlrArray);
        double maxCddlr = Math.max(Math.abs(minValue), Math.abs(maxValue));

        double unit = 1e4;
        stockHandicap.setUnit("万");
        if (!isNaN(maxCddlr) && maxCddlr >= 1e8) {
            unit = 1e8;
            stockHandicap.setUnit("亿");
        }
        //计算超大、大、中、小单净流入
        for (int i = 0; i < jlrArray.size(); i++) {
            double jlr = jlrArray.get(i);
            if (isNaN(jlr)) {
                jlrArray.set(i, 0d);
            } else {
                jlr = jlr / unit;
                if (Math.abs(jlr) > 100) {
                    jlr = new BigDecimal(jlr).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
                } else if (Math.abs(jlr) > 10) {
                    jlr = new BigDecimal(jlr).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                } else {
                    jlr = new BigDecimal(jlr).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                }
            }
            jlrArray.set(i, jlr);
        }
        stockHandicap.setZllr(jlrArray.get(0).toString());
        stockHandicap.setZllc(jlrArray.get(1).toString());
        stockHandicap.setZljlr(jlrArray.get(2).toString());
        stockHandicap.setCdd(jlrArray.get(3).toString());
        stockHandicap.setDd(jlrArray.get(4).toString());
        stockHandicap.setZd(jlrArray.get(5).toString());
        stockHandicap.setXd(jlrArray.get(6).toString());
//        System.out.println("stockHandicap=" + stockHandicap.toString());
    }

    public String getLatestPrice() {
        return latestPrice;
    }

    public StockHandicap setLatestPrice(String latestPrice) {
        this.latestPrice = latestPrice;
        return this;
    }

    public String getUp() {
        return up;
    }

    public StockHandicap setUp(String up) {
        this.up = up;
        return this;
    }

    public String getUpOrDown() {
        return upOrDown;
    }

    public StockHandicap setUpOrDown(String upOrDown) {
        this.upOrDown = upOrDown;
        return this;
    }

    public String getChange() {
        return change;
    }

    public StockHandicap setChange(String change) {
        this.change = change;
        return this;
    }

    public String getHighest() {
        return highest;
    }

    public StockHandicap setHighest(String highest) {
        this.highest = highest;
        return this;
    }

    public String getMinimum() {
        return minimum;
    }

    public StockHandicap setMinimum(String minimum) {
        this.minimum = minimum;
        return this;
    }

    public String getDealQuantity() {
        return dealQuantity;
    }

    public StockHandicap setDealQuantity(String dealQuantity) {
        this.dealQuantity = dealQuantity;
        return this;
    }

    public String getTotalDealAmount() {
        return totalDealAmount;
    }

    public StockHandicap setTotalDealAmount(String totalDealAmount) {
        this.totalDealAmount = totalDealAmount;
        return this;
    }

    public String getLimitUp() {
        return limitUp;
    }

    public StockHandicap setLimitUp(String limitUp) {
        this.limitUp = limitUp;
        return this;
    }

    public String getLimitDown() {
        return limitDown;
    }

    public StockHandicap setLimitDown(String limitDown) {
        this.limitDown = limitDown;
        return this;
    }

    public String getYesterdayPrice() {
        return yesterdayPrice;
    }

    public StockHandicap setYesterdayPrice(String yesterdayPrice) {
        this.yesterdayPrice = yesterdayPrice;
        return this;
    }

    public String getCurrentNumber() {
        return currentNumber;
    }

    public StockHandicap setCurrentNumber(String currentNumber) {
        this.currentNumber = currentNumber;
        return this;
    }

    public String getOuterDisc() {
        return outerDisc;
    }

    public StockHandicap setOuterDisc(String outerDisc) {
        this.outerDisc = outerDisc;
        return this;
    }

    public String getInsideDish() {
        return insideDish;
    }

    public StockHandicap setInsideDish(String insideDish) {
        this.insideDish = insideDish;
        return this;
    }

    public String getVolumeRatioIndex() {
        return volumeRatioIndex;
    }

    public StockHandicap setVolumeRatioIndex(String volumeRatioIndex) {
        this.volumeRatioIndex = volumeRatioIndex;
        return this;
    }

    public String getIncome() {
        return income;
    }

    public StockHandicap setIncome(String income) {
        this.income = income;
        return this;
    }

    public String getPERatiosDynamic() {
        return PERatiosDynamic;
    }

    public StockHandicap setPERatiosDynamic(String PERatiosDynamic) {
        this.PERatiosDynamic = PERatiosDynamic;
        return this;
    }

    public String getPERatios() {
        return PERatios;
    }

    public StockHandicap setPERatios(String PERatios) {
        this.PERatios = PERatios;
        return this;
    }

    public String getNetAssets() {
        return netAssets;
    }

    public StockHandicap setNetAssets(String netAssets) {
        this.netAssets = netAssets;
        return this;
    }

    public String getPBRatio() {
        return PBRatio;
    }

    public StockHandicap setPBRatio(String PBRatio) {
        this.PBRatio = PBRatio;
        return this;
    }

    public String getGeneralCapital() {
        return generalCapital;
    }

    public StockHandicap setGeneralCapital(String generalCapital) {
        this.generalCapital = generalCapital;
        return this;
    }

    public String getCapitalization() {
        return capitalization;
    }

    public StockHandicap setCapitalization(String capitalization) {
        this.capitalization = capitalization;
        return this;
    }

    public String getCirculationOfCapitalStock() {
        return circulationOfCapitalStock;
    }

    public StockHandicap setCirculationOfCapitalStock(String circulationOfCapitalStock) {
        this.circulationOfCapitalStock = circulationOfCapitalStock;
        return this;
    }

    public String getCirculationOfCapitalization() {
        return circulationOfCapitalization;
    }

    public StockHandicap setCirculationOfCapitalization(String circulationOfCapitalization) {
        this.circulationOfCapitalization = circulationOfCapitalization;
        return this;
    }

    public String getTime() {
        return time;
    }

    public StockHandicap setTime(String time) {
        this.time = time;
        return this;
    }

    public String getCode() {
        return code;
    }

    public StockHandicap setCode(String code) {
        this.code = code;
        return this;
    }

    public static class Param {
        private String code;

        public Param(String code) {
            this.code = code;
        }
        //    ?type=CT&cmd=0007662&sty=MPICT&st=z&sr=&p=&ps=&cb=callback&js=([[(x)]])&token=7bc05d0d4c3c22ef9fca8c2a912d779c&_=1477707111463

        public Map<String, String> getParams() {
            final Map<String, String> params = new HashMap<String, String>();
            params.put("type", "CT");
            params.put("cmd", code);
            params.put("sty", "MPICT");
            params.put("st", "z");
            params.put("sr", "");
            params.put("p", "");
            params.put("ps", "");
            params.put("cb", "callback");
            params.put("js", "([[(x)]])");
           /* UUID uuid = UUID.randomUUID();
            String token = uuid.toString().replaceAll("-", "");*/
//            System.out.println("token=" + token);
            params.put("token", "7bc05d0d4c3c22ef9fca8c2a912d779c");
            params.put("_", System.currentTimeMillis() + "");


            return params;
        }
    }

    public String getName() {
        return name;
    }

    public StockHandicap setName(String name) {
        this.name = name;
        return this;
    }

    public String getOpen() {
        return open;
    }

    public StockHandicap setOpen(String open) {
        this.open = open;
        return this;
    }

    public String getZllr() {
        return zllr;
    }

    public StockHandicap setZllr(String zllr) {
        this.zllr = zllr;
        return this;
    }

    public String getZllc() {
        return zllc;
    }

    public StockHandicap setZllc(String zllc) {
        this.zllc = zllc;
        return this;
    }

    public String getZljlr() {
        return zljlr;
    }

    public StockHandicap setZljlr(String zljlr) {
        this.zljlr = zljlr;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public StockHandicap setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public String getCdd() {
        return cdd;
    }

    public StockHandicap setCdd(String cdd) {
        this.cdd = cdd;
        return this;
    }

    public String getDd() {
        return dd;
    }

    public StockHandicap setDd(String dd) {
        this.dd = dd;
        return this;
    }

    public String getZd() {
        return zd;
    }

    public StockHandicap setZd(String zd) {
        this.zd = zd;
        return this;
    }

    public String getXd() {
        return xd;
    }

    public StockHandicap setXd(String xd) {
        this.xd = xd;
        return this;
    }

    @Override
    public String toString() {
        return "StockHandicap{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", latestPrice='" + latestPrice + '\'' +
                ", up='" + up + '\'' +
                ", upOrDown='" + upOrDown + '\'' +
                ", change='" + change + '\'' +
                ", highest='" + highest + '\'' +
                ", minimum='" + minimum + '\'' +
                ", dealQuantity='" + dealQuantity + '\'' +
                ", totalDealAmount='" + totalDealAmount + '\'' +
                ", limitUp='" + limitUp + '\'' +
                ", limitDown='" + limitDown + '\'' +
                ", yesterdayPrice='" + yesterdayPrice + '\'' +
                ", currentNumber='" + currentNumber + '\'' +
                ", outerDisc='" + outerDisc + '\'' +
                ", insideDish='" + insideDish + '\'' +
                ", volumeRatioIndex='" + volumeRatioIndex + '\'' +
                ", income='" + income + '\'' +
                ", PERatiosDynamic='" + PERatiosDynamic + '\'' +
                ", PERatios='" + PERatios + '\'' +
                ", netAssets='" + netAssets + '\'' +
                ", PBRatio='" + PBRatio + '\'' +
                ", generalCapital='" + generalCapital + '\'' +
                ", capitalization='" + capitalization + '\'' +
                ", circulationOfCapitalStock='" + circulationOfCapitalStock + '\'' +
                ", circulationOfCapitalization='" + circulationOfCapitalization + '\'' +
                ", time='" + time + '\'' +
                ", open='" + open + '\'' +
                ", zllr='" + zllr + '\'' +
                ", zllc='" + zllc + '\'' +
                ", zljlr='" + zljlr + '\'' +
                ", cdd='" + cdd + '\'' +
                ", dd='" + dd + '\'' +
                ", zd='" + zd + '\'' +
                ", xd='" + xd + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
