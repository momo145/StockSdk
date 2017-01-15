package com.sinkinchan.stock.sdk.source.impls;

import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.source.ISourceManager;

import java.net.URLDecoder;

/**
 * Created by apple on 2016/11/25.
 */
public class StockClassifySource {
//    http://gp.3g.qq.com/g/stock/wap3/ajax_server/json.jsp?action=getCompanyDetails&sid=&securities_id=share_601006.xshg
//    ?action=getCompanyDetails&sid=&securities_id=share_601006.xshg

    private final static StockClassifySource stockClassifySource = new StockClassifySource();
    private static String code;

    private StockClassifySource() {
    }

    public Source setCode(String code) {
        this.code = code;
        return Source.getInstance();
    }

    public static StockClassifySource getInstance() {
        return stockClassifySource;
    }


    public static class Source extends ISourceManager {
        //        private static final String BASE_URL = "http://m.iwencai.com/diag/block-detail?pid=8153&codes=%s&codeType=stock&info=%7B%22view%22%3A%7B%22nolazy%22%3A1%2C%22parseArr%22%3A%7B%22_v%22%3A%22new%22%2C%22dateRange%22%3A%5B%5D%2C%22staying%22%3A%5B%5D%2C%22queryCompare%22%3A%5B%5D%2C%22comparesOfIndex%22%3A%5B%5D%7D%2C%22asyncParams%22%3A%7B%22tid%22%3A137%2C%22env%22%3A%22phone%22%7D%7D%7D&userid=&usertype=";
        private static final String BASE_URL = "http://m.iwencai.com/diag/block-detail?pid=8153&codes=%s&codeType=stock&info={\"view\":{\"nolazy\":1,\"parseArr\":{\"_v\":\"new\",\"dateRange\":[],\"staying\":[],\"queryCompare\":[],\"comparesOfIndex\":[]},\"asyncParams\":{\"tid\":137,\"env\":\"phone\"}}}&userid=&usertype=";

        private final static Source source = new Source();

        private Source() {
        }

        protected static Source getInstance() {
            return source;
        }


        public void getSource(final SourceManager.onSourceCallBack<?> callBack) {
            String url = String.format(BASE_URL, code);
            try {
                url = URLDecoder.decode(url, "utf-8");
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
            System.out.println("url=" + url);
            super.getSource(url, callBack);
        }

    }

}
