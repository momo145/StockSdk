package com.sinkinchan.stock.sdk.source.impls;

import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.bean.StockHistoryPrice;
import com.sinkinchan.stock.sdk.source.ISourceManager;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/9/3.
 */
public class StockHistoryPriceSource extends ISourceManager {
    private static StockHistoryPriceSource ourInstance = new StockHistoryPriceSource();

    public static StockHistoryPriceSource getInstance() {
        return ourInstance;
    }

    private StockHistoryPriceSource() {
    }

    //sh600620 股票编号 2016-08-30 开始日期 2016-09-2 结束时间  时间戳
//    private final static String BASE_URL = "http://web.ifzq.gtimg.cn/appstock/app/fqkline/get?_var=kline_dayqfq2016&param=%s,day,%s,%s,640,qfq&r=%s";
    //?year=2016&season=1
    private final static String BASE_URL = "http://quotes.money.163.com/trade/lsjysj_%s.html";

    public void getSource(StockHistoryPrice.Param param, SourceManager.onSourceCallBack<?> callBack) {
        String url = String.format(BASE_URL, param.getCode());
        getSource(url, param.getParams(), callBack);
    }

    public List<StockHistoryPrice> processData(Document document) {
        if (document == null) {
            return null;
        }
        List<StockHistoryPrice> stockHistoryPrices = new ArrayList<StockHistoryPrice>();
        Elements elements = document.getElementsByClass("table_bg001");
        Elements trs = elements.select("tr");
        Elements tds = null;
        int index = 0;
        for (Element element : trs) {
            //排除第一个
            if (index == 0) {
                index += 1;
            } else {
                tds = element.select("td");
                stockHistoryPrices.add(new StockHistoryPrice(tds));
            }
        }
        return stockHistoryPrices;
    }

}

