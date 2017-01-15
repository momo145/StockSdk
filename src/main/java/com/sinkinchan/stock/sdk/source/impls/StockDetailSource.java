package com.sinkinchan.stock.sdk.source.impls;

import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.source.ISourceManager;

import java.util.List;

/**
 * Created by apple on 16/9/3.
 */
public class StockDetailSource extends ISourceManager {

    private static final String REG = "_ntes_quote_callback19912511";
    //http://api.money.126.net/data/feed/1002569,0600216,money.api?callback=_ntes_quote_callback19912511
    private static final String BASE_URL = "http://api.money.126.net/data/feed/%smoney.api?callback=" + REG + "&time=";
    private static StockDetailSource ourInstance = new StockDetailSource();

    public static StockDetailSource getInstance() {
        return ourInstance;
    }

    private StockDetailSource() {
    }

    public void getSource(List<String> codes, SourceManager.onSourceCallBack<?> callBack) {
        if (codes == null || codes.size() == 0) {
            return;
        }
        String url = "";
        for (String code : codes) {
            url += code + ",";
        }
        url = String.format(BASE_URL, url) + System.currentTimeMillis();
        getSource(url, callBack);
    }


}
