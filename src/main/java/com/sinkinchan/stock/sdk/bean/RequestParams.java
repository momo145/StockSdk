package com.sinkinchan.stock.sdk.bean;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by apple on 16/9/3.
 */
public class RequestParams {
    private String baseUrl;
    private Map<String, String> params;
    StringBuilder builder = null;

    public RequestParams(String baseUrl) {
        this.baseUrl = baseUrl;
        builder = new StringBuilder(baseUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public RequestParams setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public RequestParams setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    String reg = "?";

    @Override
    public String toString() {
        if (params != null && params.size() > 0) {
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> v = iterator.next();
                String param = v.getKey() + "=" + v.getValue();
                if ("?".equals(reg)) {
                    builder.append(reg).append(param);
                    reg = "&";
                }
                builder.append(reg).append(param);
            }
        }
        return builder.toString();
    }
}
