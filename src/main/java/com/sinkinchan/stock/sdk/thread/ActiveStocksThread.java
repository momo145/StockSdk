package com.sinkinchan.stock.sdk.thread;

import com.sinkinchan.stock.sdk.config.SdkConfig;
import com.sinkinchan.stock.sdk.thread.base.BaseThread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by apple on 16/9/3.
 */
public class ActiveStocksThread extends BaseThread {
    public final static LinkedBlockingQueue<Runnable> ACTIVE_STOCKS_QUEUE = new LinkedBlockingQueue<Runnable>();

    @Override
    public void run() {

        while (true) {
            try {
                Runnable runnable = ACTIVE_STOCKS_QUEUE.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void initExecutorService() {
        int size = SdkConfig.getInstance().getActiveStocksThreadPoolSize();
        if (size == SdkConfig.ACTIVE_STOCKS_THREAD_POOL_SIZE_DEFAULT) {
            super.initExecutorService();
        } else {
            service = Executors.newFixedThreadPool(size);
            for (int i = 0; i < size; i++) {
                System.out.println("生成线程数i=" + i);
                service.execute(this);
            }
        }
    }
}
