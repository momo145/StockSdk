package com.sinkinchan.stock.sdk.source.impls;

import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.source.ISourceManager;

import java.util.Map;

/**
 * Created by apple on 16/9/3.
 */
public class QuotaStockPageSource extends ISourceManager {
    private static QuotaStockPageSource ourInstance = new QuotaStockPageSource();

    public static QuotaStockPageSource getInstance() {
        return ourInstance;
    }

    private QuotaStockPageSource() {
    }

    //http://smartstock.gtimg.cn/get.php?_func=zhibiao&_default=1&_page=1&_pagesize=30&zhibiao=hs_sgcx&_du_r_t=0.25723057998160015
    public final static String QUOTA_STOCK_TYPE1_URL = "http://smartstock.gtimg.cn/get.php";

    public void getQuotaStock(Map<String, String> params, final SourceManager.onSourceCallBack<?> callBack) {
        super.getSource(QUOTA_STOCK_TYPE1_URL, params, callBack);
    }

}
