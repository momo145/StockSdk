package com.sinkinchan.stock.sdk.source.impls;

import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.source.ISourceManager;

import java.util.Map;

/**
 * Created by 陈欣健 on 16/9/3.
 */
public class ActiveStocksSource extends ISourceManager {
    //http://smartstock.gtimg.cn/get.php?_func=filter&_page=1&_pagesize=30&hs_hsl=0.05&hs_zf=0.03&hs_lb=1&_default=1&_du_r_t=0.1294365757623337

    private final static ActiveStocksSource activeStocksSource = new ActiveStocksSource();

    private ActiveStocksSource() {
    }

    public static ActiveStocksSource getInstance() {
        return activeStocksSource;
    }

    private static final String BASE_URL = "http://smartstock.gtimg.cn/get.php";

    public void getSource(Map<String, String> params, final SourceManager.onSourceCallBack<?> callBack) {
        super.getSource(BASE_URL, params, callBack);
    }


}

