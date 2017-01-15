package com.sinkinchan.stock.sdk.thread.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by apple on 16/9/3.
 */
public abstract class BaseThread implements Runnable {
    protected String TAG = this.getClass().getName();
    protected ExecutorService service;
    public boolean flag = true;

    public BaseThread() {
        initExecutorService();
        System.out.println("实例化 " + TAG + " 线程池 done");
    }

    public void run() {
        // TODO Auto-generated method stub

    }

    protected void initExecutorService() {
        service = Executors.newSingleThreadExecutor();
        service.execute(this);
    }

    public ExecutorService getService() {
        return service;
    }
}
