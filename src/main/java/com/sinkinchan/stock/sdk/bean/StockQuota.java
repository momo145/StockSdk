package com.sinkinchan.stock.sdk.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 16/9/20.
 * 股票指标
 */
public class StockQuota {

    /**
     * bps : 8.82864
     * enddate : 2016-06-30 00:00:00.0
     * eps : 0.48476
     * fla : 9708107759
     * mktcap : 2.2930550526758E11
     * pb : 2.68
     * pe : 14.44
     * stockcode : 2
     * tcap : 2.6074477026362E11
     * total : 11039152001
     */

    private double bps;
    private String enddate;
    private double eps;
    private long fla;
    private double mktcap;
    private double pb;
    private double pe;
    private int stockcode;
    private double tcap;
    private long total;

    public double getBps() {
        return bps;
    }

    public void setBps(double bps) {
        this.bps = bps;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public long getFla() {
        return fla;
    }

    public void setFla(long fla) {
        this.fla = fla;
    }

    public double getMktcap() {
        return mktcap;
    }

    public void setMktcap(double mktcap) {
        this.mktcap = mktcap;
    }

    public double getPb() {
        return pb;
    }

    public void setPb(double pb) {
        this.pb = pb;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public int getStockcode() {
        return stockcode;
    }

    public void setStockcode(int stockcode) {
        this.stockcode = stockcode;
    }

    public double getTcap() {
        return tcap;
    }

    public void setTcap(double tcap) {
        this.tcap = tcap;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "StockQuota{" +
                "bps=" + bps +
                ", enddate='" + enddate + '\'' +
                ", eps=" + eps +
                ", fla=" + fla +
                ", mktcap=" + mktcap +
                ", pb=" + pb +
                ", pe=" + pe +
                ", stockcode=" + stockcode +
                ", tcap=" + tcap +
                ", total=" + total +
                '}';
    }

    public static class Param {
        //        http://m.jrj.com.cn/json/stock/share/getSimpleStockFinance?vname=financeData&code=000002&_dc=1474380957706
        private String code;

        public Param(String code) {
            this.code = code;
        }

        public Map<String, String> getParams() {
            Map<String, String> params = new HashMap<String, String>();
            params.put("vname", "financeData");
            params.put("code", code);
            params.put("_dc", System.currentTimeMillis() + "");
            return params;
        }
    }
}
