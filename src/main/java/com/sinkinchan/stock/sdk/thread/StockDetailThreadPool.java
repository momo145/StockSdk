package com.sinkinchan.stock.sdk.thread;

import com.sinkinchan.stock.sdk.config.SdkConfig;
import com.sinkinchan.stock.sdk.thread.base.BaseThread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by apple on 16/9/3.
 */
public class StockDetailThreadPool extends BaseThread {

    public final static LinkedBlockingQueue<Runnable> STOCK_DETAIL_QUEUE = new LinkedBlockingQueue<Runnable>();

    @Override
    public void run() {
        while (true) {
            try {
                Runnable runnable = STOCK_DETAIL_QUEUE.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void initExecutorService() {
        int size = SdkConfig.getInstance().getStockDetailThreadPoolSize();
        service = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            System.out.println("生成线程数i=" + i);
            service.execute(this);
        }
    }
}
