package com.sinkinchan.stock.sdk.source;

import com.sinkinchan.stock.sdk.SourceManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 陈欣健 on 16/9/3.
 */
public abstract class ISourceManager {


    protected void getSource(String url, SourceManager.onSourceCallBack callBack) {
        try {
            Map<String, String> param = new HashMap<String, String>();
            getSource(url, param, callBack);
        } catch (Exception e) {
            callBack.onFailed(e.getMessage());
        }
    }

    protected void getSource(String url, Map<String, String> params, SourceManager.onSourceCallBack callBack) {
        try {
            Document doc = Jsoup.connect(url).ignoreContentType(true).data(params).timeout(TIME_OUT).get();
            String result = formatResult(doc.text());
            switch (callBack.getType()) {
                case json:
                    callBack.onSuccess(result);
                    break;
                case bean:
                    callBack.getBean(doc, result);
                    /*Class clazz = null;
                    Type type = null;
                    if (callBack.getClazz() instanceof Class) {
                        clazz = (Class) callBack.getClazz();
                        callBack.onSuccess(GsonUtil.getGson().fromJson(result, clazz));

                    } else if (callBack.getClazz() instanceof Type) {
                        type = (Type) callBack.getClazz();
                        callBack.onSuccess(GsonUtil.getGson().fromJson(result, type));
                    }*/
                    break;
            }

        } catch (Exception e) {
//            System.out.print(e.getMessage());
            callBack.onFailed(e.toString());
        }
    }


    protected static final int TIME_OUT = 15000;

    private String formatResult(String result) {
        //{.*}
        String r = "\\{.*\\}";
        Pattern pattern = Pattern.compile(r);
        Matcher matcher = pattern.matcher(result);
        String str = "";
        while (matcher.find()) {
            str += matcher.group();
        }
       /* String head = REG + "(";
        String last = ");";
        if (result.contains(head)) {
            result = result.replace(head, "");
        }
        if (result.contains(last)) {
            result = result.replace(last, "");
        }*/
        return str;
    }

}
