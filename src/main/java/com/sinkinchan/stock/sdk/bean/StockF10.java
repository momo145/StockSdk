package com.sinkinchan.stock.sdk.bean;

import org.jsoup.helper.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 2016/12/10.
 */
public class StockF10 {
    private static StockF10 ourInstance = new StockF10();

    public static StockF10 getInstance() {
        return ourInstance;
    }

    private StockF10() {
    }

    /*<string-array name="stock_handicap_more_array">
    <item>经营分析</item>
    <item>股东情况</item>
    <item>股本结构</item>
    <item>核心题材</item>
    <item>公司高管</item>
    <item>龙虎榜单</item>
    <item>大宗交易</item>
    </string-array>*/
    List<String> f10List = null;

    public List<String> getF10List() {
        if (f10List == null) {
            f10List = new ArrayList<String>();
            f10List.add("经营分析");
            f10List.add("股东情况");
            f10List.add("股本结构");
            f10List.add("核心题材");
            f10List.add("公司高管");
            f10List.add("龙虎榜单");
            f10List.add("大宗交易");
        }

        return f10List;
    }

    Map<String, String> urlMap = null;

    public String getUrl(String key, String code) {
        initUrlMap();
        String url = urlMap.get(key);
        if (StringUtil.isBlank(url)) {
            return null;
        }
        url = String.format(url, code);
        return url;
    }

    private void initUrlMap() {
        if (urlMap == null) {
            urlMap = new HashMap<String, String>();
            urlMap.put("经营分析", "http://softf9.eastmoney.com/v2/F10_jyfx.aspx?fc=%s&color=w&isShow=n#5");
            urlMap.put("股东情况", "http://softf9.eastmoney.com/v2/F10_gd.aspx?fc=%s&color=w&isShow=n#6");
            urlMap.put("股本结构", "http://softf9.eastmoney.com/v2/F10_gbjg.aspx?fc=%s&color=w&isShow=n#7");
            urlMap.put("核心题材", "http://softf9.eastmoney.com/v2/F10_hxtc.aspx?fc=%s&color=w&isShow=n#8");
            urlMap.put("公司高管", "http://softf9.eastmoney.com/v2/F10_gsgg.aspx?fc=%s&color=w&isShow=n#9");
            urlMap.put("龙虎榜单", "http://softf9.eastmoney.com/v2/F10_lhbd.aspx?fc=%s&color=w&isShow=n#10");
            urlMap.put("大宗交易", "http://softf9.eastmoney.com/v2/F10_dzjy.aspx?fc=%s&color=w&isShow=n#11");
        }
    }
}
