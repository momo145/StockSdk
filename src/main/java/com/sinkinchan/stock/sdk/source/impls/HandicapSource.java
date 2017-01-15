package com.sinkinchan.stock.sdk.source.impls;

import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.bean.StockHandicap;
import com.sinkinchan.stock.sdk.source.ISourceManager;
import org.jsoup.helper.StringUtil;

/**
 * Created by apple on 2016/10/27.
 * 股票盘口数据
 */
public class HandicapSource extends ISourceManager {
    private static HandicapSource ourInstance = new HandicapSource();

    public static HandicapSource getInstance() {
        return ourInstance;
    }

    private HandicapSource() {
    }

    private static final String DFCF_BASE_URL = "http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx";
    private static final String DFCF_BASE_URL2 = "http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?type=CT&cmd=%s&sty=MPICT&st=z&sr=&p=&ps=&cb=callback&js={[[(x)]]}&token=7bc05d0d4c3c22ef9fca8c2a912d779c&_=%s";


    /**
     * 获取东方财富的盘口
     *
     * @param code     股票代码 不带地区
     * @param callBack
     */
    private void DFCFHandicapSource(String code, final SourceManager.onSourceCallBack<?> callBack) {
        String url = String.format(DFCF_BASE_URL2, code, System.currentTimeMillis() + "");
        super.getSource(url, callBack);
    }

    /**
     * 获取东方财富的盘口
     *
     * @param param    参数
     * @param callBack
     */
    private void DFCFHandicapSource(StockHandicap.Param param, final SourceManager.onSourceCallBack<?> callBack) {
        super.getSource(DFCF_BASE_URL, param.getParams(), callBack);
    }

    /**
     * 获取盘口
     *
     * @param param    参数
     * @param callBack
     * @param type
     */
    public void getHandicap(StockHandicap.Param param, final SourceManager.onSourceCallBack<?> callBack, HandicapType type) {
        if (param == null || callBack == null || type == null) {
            return;
        }
        switch (type) {
            case THS:
                break;
            case DFCF:
                DFCFHandicapSource(param, callBack);
                break;
        }
    }

    /**
     * 获取盘口
     *
     * @param code     参数
     * @param callBack
     * @param type
     */
    public void getHandicap(String code, final SourceManager.onSourceCallBack<?> callBack, HandicapType type) {
        if (StringUtil.isBlank(code) || callBack == null || type == null) {
            return;
        }
        switch (type) {
            case THS:
                break;
            case DFCF:
                DFCFHandicapSource(code, callBack);
                break;
        }
    }

    public enum HandicapType {
        THS("同花顺"), DFCF("东方财富");
        private String name;

        HandicapType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
