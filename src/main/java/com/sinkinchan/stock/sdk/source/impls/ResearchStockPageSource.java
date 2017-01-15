package com.sinkinchan.stock.sdk.source.impls;

import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.source.ISourceManager;

import java.util.Map;

/**
 * Created by apple on 16/9/4.
 */
public class ResearchStockPageSource extends ISourceManager {
    private static ResearchStockPageSource ourInstance = new ResearchStockPageSource();

    public static ResearchStockPageSource getInstance() {
        return ourInstance;
    }

    private ResearchStockPageSource() {
    }
//    http://smartstock.gtimg.cn/get.php?_func=ybg&_page=1&_pagesize=30&type=hs_yb5&_du_r_t=0.22728902835368547

    private static final String BASE_URL = "http://smartstock.gtimg.cn/get.php";

    public void getResearchStock(Map<String, String> params, final SourceManager.onSourceCallBack<?> callBack) {
        super.getSource(BASE_URL, params, callBack);
    }
}
