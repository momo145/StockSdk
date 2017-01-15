package com.sinkinchan.stock.sdk;

import com.sinkinchan.stock.sdk.bean.StockHandicap;
import com.sinkinchan.stock.sdk.bean.StockHistoryPrice;
import com.sinkinchan.stock.sdk.source.impls.*;
import com.sinkinchan.stock.sdk.thread.ActiveStocksThread;
import com.sinkinchan.stock.sdk.thread.StockDetailThreadPool;
import org.jsoup.nodes.Document;

import java.util.List;
import java.util.Map;

/**
 * Created by 陈欣健 on 16/9/3.
 */
public class SourceManager {
    private static final SourceManager sourceManager = new SourceManager();

    private SourceManager() {

    }

    public static SourceManager getInstance() {
        return sourceManager;
    }


    /**
     * 获取活跃股信息
     *
     * @param params
     * @param callBack
     */
    public void getActiveStocksPage(final Map<String, String> params, final onSourceCallBack<?> callBack) {
        try {
            ActiveStocksThread.ACTIVE_STOCKS_QUEUE.put(new Runnable() {
                public void run() {
                    ActiveStocksSource.getInstance().getSource(params, callBack);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取股票详情
     *
     * @param codes
     * @param callBack
     */
    public void getStockDetail(final List<String> codes, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    StockDetailSource.getInstance().getSource(codes, callBack);

                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取股票的价格
     *
     * @param param
     * @param callBack
     */
    public void getStockHistoryPrice(final StockHistoryPrice.Param param, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    StockHistoryPriceSource.getInstance().getSource(param, callBack);

                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指标股
     *
     * @param params
     * @param callBack
     */
    public void getQuotaStock(final Map<String, String> params, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    QuotaStockPageSource.getInstance().getQuotaStock(params, callBack);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取研报股
     *
     * @param params
     * @param callBack
     */
    public void getResearchStock(final Map<String, String> params, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    ResearchStockPageSource.getInstance().getResearchStock(params, callBack);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取敢死队
     *
     * @param params
     * @param callBack
     */
    public void getDeathSquadStockPage(final Map<String, String> params, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    DeathSquadStockPageSource.getInstance().getDeathSquadStockPage(params, callBack);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取股票公告
     *
     * @param params
     * @param callBack
     */
    public void getStockNoticeSource(final Map<String, String> params, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    StockNoticeSource.getInstance().getStockNotice(params, callBack);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取股票新闻
     *
     * @param params
     * @param callBack
     */
    public void getStockNews(final Map<String, String> params, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    StockNewsSource.getInstance().getStockNews(params, callBack);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取股票指标
     *
     * @param params
     * @param callBack
     */
    public void getStockQuota(final Map<String, String> params, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    StockQuotaSource.getInstance().getSource(params, callBack);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取东方财富的盘口
     *
     * @param param    参数
     * @param callBack
     */
    public void getDFCFHandicapSource(final StockHandicap.Param param, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    HandicapSource.getInstance().getHandicap(param, callBack, HandicapSource.HandicapType.DFCF);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取东方财富的盘口
     *
     * @param code     参数
     * @param callBack
     */
    public void getDFCFHandicapSource(final String code, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    HandicapSource.getInstance().getHandicap(code, callBack, HandicapSource.HandicapType.DFCF);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取股票概述
     *
     * @param code
     * @param callBack
     */
    public void getStockClassify(final String code, final onSourceCallBack<?> callBack) {
        try {
            StockDetailThreadPool.STOCK_DETAIL_QUEUE.put(new Runnable() {
                public void run() {
                    StockClassifySource.getInstance().setCode(code).getSource(callBack);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public interface onSourceCallBack<T> {
        enum DataType {
            json, bean;
        }


        void onSuccess(String data);

        void onFailed(String errorMsg);

        DataType getType();

        T getBean(Document document, String json);
    }

    public enum StockType {
        ActiveStock("活跃股", "股性相对活跃意味着有资金积极参与推动，据统计：在同样的市场中，股性活跃的品种往往可以为投资者带来更多更丰厚的收益。"),
        ResearchStock("研报股", "分析师的研究报告对机构资金的影响力极大，机构研究思路的变化往往是机构资金选股思路变化的主要信号。据统计，二级市场的机构资金消化研究报告“学以致用”，曾经在二级市场上掀起了一波又一波的冷门股上涨的现象。"),
        QuotaStock("指标股", "技术指标的变化和发出的买卖信号，是行情反映到指标中的数值，也是行情的事先变化，我们根据不同市场趋势筛选了较为经典的五个指标选股模型。"),
        QuotaStockType1("指标股-曙光初现", "1.MACD金叉：DIF与DEA金叉\n2.成交量金叉：5日成交量均线与10日成交量均线金叉\n3.均线金叉：5日移动均线与10日移动均线金叉"),
        QuotaStockType2("指标股-空中加油", "1.20日和60日均线多头排列\n2.凯恩斯多空线金叉（上穿0轴）"),
        QuotaStockType3("指标股-超级短线", "1.20日和60日均线多头排列\n2.20日均线导数大于0\n3.超级短线中的K线上穿0轴"),
        QuotaStockType4("指标股-蓄势待发", "1.股价创60日新高\n2.60日涨幅不得超过30%"),
        Stock_Quota("股票指标", "包含股票的市盈率,市净率等信息"),
        DeathSquadStock("敢死队股", "在投资者心中，敢死队往往是一群制造涨停“无极限”的好手，通过统计公开交易榜单出现频率不难扑捉到他们的身影，敢死队频繁出击的背后集结了A股市场最另类的操盘资金。");

        StockType(String title, String desc) {
            this.title = title;
            this.desc = desc;
        }

        public String title;
        public String desc;

    }
}
