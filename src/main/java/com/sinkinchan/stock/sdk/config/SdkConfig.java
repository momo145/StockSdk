package com.sinkinchan.stock.sdk.config;

import com.sinkinchan.stock.sdk.thread.ActiveStocksThread;
import com.sinkinchan.stock.sdk.thread.StockDetailThreadPool;
import com.sinkinchan.stock.sdk.thread.base.BaseThread;

/**
 * Created by apple on 16/9/3.
 */
public class SdkConfig {
    public final static int ACTIVE_STOCKS_THREAD_POOL_SIZE_DEFAULT = 1;
    public final static int STOCKS_DETAIL_THREAD_POOL_SIZE_DEFAULT = 3;
    private int activeStocksThreadPoolSize = ACTIVE_STOCKS_THREAD_POOL_SIZE_DEFAULT;
    private int stockDetailThreadPoolSize = STOCKS_DETAIL_THREAD_POOL_SIZE_DEFAULT;
    private final static SdkConfig config = new SdkConfig();

    public static SdkConfig getInstance() {
        return config;
    }

    private SdkConfig() {
    }

    public int getStockDetailThreadPoolSize() {
        return stockDetailThreadPoolSize;
    }

    public SdkConfig setStockDetailThreadPoolSize(int stockDetailThreadPoolSize) {
        this.stockDetailThreadPoolSize = stockDetailThreadPoolSize;
        return this;
    }

    public int getActiveStocksThreadPoolSize() {
        return activeStocksThreadPoolSize;
    }

    public SdkConfig setActiveStocksThreadPoolSize(int activeStocksThreadPoolSize) {
        this.activeStocksThreadPoolSize = activeStocksThreadPoolSize;
        return this;
    }

    BaseThread activeStocksThread = null;
    BaseThread stockDetailThreadPool = null;

    public void init() {
        if (activeStocksThread != null && !activeStocksThread.getService().isShutdown()) {
            activeStocksThread.getService().shutdown();
        }
        if (stockDetailThreadPool != null && !stockDetailThreadPool.getService().isShutdown()) {
            stockDetailThreadPool.getService().shutdown();
        }

        activeStocksThread = new ActiveStocksThread();
        stockDetailThreadPool = new StockDetailThreadPool();
    }
}
