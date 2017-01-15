package com.sinkinchan.stock.sdk.source.impls;

import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.source.ISourceManager;

import java.util.Map;

/**
 * Created by apple on 16/9/4.
 */
public class StockNewsSource  extends ISourceManager {
    private static StockNewsSource ourInstance = new StockNewsSource();

    public static StockNewsSource getInstance() {
        return ourInstance;
    }

    private StockNewsSource() {
    }

    //    http://news.gtimg.cn/notice_more.php?q=sh601099&page=1
    private static final String BASE_URL = "http://m.quote.eastmoney.com/JsonWrapApi.aspx";

    public void getStockNews(Map<String, String> params, final SourceManager.onSourceCallBack<?> callBack) {
        super.getSource(BASE_URL, params, callBack);
    }
}
