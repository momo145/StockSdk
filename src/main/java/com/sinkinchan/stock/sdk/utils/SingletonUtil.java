package com.sinkinchan.stock.sdk.utils;

/**
 * Created by 陈欣健 on 16/9/3.
 */
public abstract class SingletonUtil<T> {

    private T instance;

    protected abstract T newInstance();

    public final T getInstance() {
        if (instance == null) {
            synchronized (SingletonUtil.class) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }
}
