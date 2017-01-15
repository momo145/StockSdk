package com.sinkinchan.stock.sdk.source.impls;

import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.source.ISourceManager;

import java.util.Map;

/**
 * Created by apple on 16/9/4.
 */
public class DeathSquadStockPageSource extends ISourceManager {
    private static DeathSquadStockPageSource ourInstance = new DeathSquadStockPageSource();

    public static DeathSquadStockPageSource getInstance() {
        return ourInstance;
    }

    private DeathSquadStockPageSource() {
    }

    private static final String BASE_URL = "http://smartstock.gtimg.cn/get.php";

    public void getDeathSquadStockPage(Map<String, String> params, final SourceManager.onSourceCallBack<?> callBack) {
        super.getSource(BASE_URL, params, callBack);
    }
}
