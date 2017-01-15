package com.sinkinchan.stock.sdk.utils;

import com.google.gson.Gson;

/**
 * Created by apple on 16/9/3.
 */
public class GsonUtil {
    private static final Gson gson = new Gson();

    private GsonUtil() {
    }

    public static Gson getGson() {
        return gson;
    }
}
