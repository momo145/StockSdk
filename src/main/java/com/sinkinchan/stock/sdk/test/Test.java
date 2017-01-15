package com.sinkinchan.stock.sdk.test;

import com.google.gson.reflect.TypeToken;
import com.sinkinchan.stock.sdk.SourceManager;
import com.sinkinchan.stock.sdk.bean.*;
import com.sinkinchan.stock.sdk.config.SdkConfig;
import com.sinkinchan.stock.sdk.source.impls.HandicapSource;
import com.sinkinchan.stock.sdk.source.impls.StockClassifySource;
import com.sinkinchan.stock.sdk.source.impls.StockHistoryPriceSource;
import com.sinkinchan.stock.sdk.source.impls.StockNoticeSource;
import com.sinkinchan.stock.sdk.utils.GsonUtil;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.sinkinchan.stock.sdk.SourceManager.onSourceCallBack.DataType.json;

/**
 * Created by apple on 16/9/3.
 */
public class Test {
    public static void main(String[] args) {
        SdkConfig.getInstance()
                .setStockDetailThreadPoolSize(10).init();
        /*testActiveStocksPage();
        testStockDetail();
        testStockPrice();
        testQuotaStockType1();
        testQuotaStockType2();
        testQuotaStockType3();
        testQuotaStockType4();
        testResearchStock(ResearchStockPage.Type.today);
        testResearchStock(ResearchStockPage.Type.five);
        testResearchStock(ResearchStockPage.Type.thirty);*/
//        testDeathSquadStockPage();
//        getStockNotice();
//        getStockNews();
//        testQuotaStockType4();
//        String year = DateUtil.currentTime(DateUtil.DEFAULT_DATE_FORMAT_YEAR);
//        System.out.println(year);
//        getStockQuota();
//        getDFCFHandicap();
//        System.out.println(formatValue("40000000"));
        getStockClassify();
    }

    static java.text.DecimalFormat df1 = new java.text.DecimalFormat("#.##");

    /**
     * 格式化大数目
     *
     * @param value
     * @return
     */
    public static String formatValue(String value) {
        double val = Double.valueOf(value);
        String unit = "亿";
        if (val >= 1e4) {
            val = Double.valueOf(val);
            if (val >= 1e8) {
                val = val / 1e8;
                int valInt = (int) val;
                if (valInt >= 1e3) {
                    val = valInt;
                } else if (valInt >= 100) {
                    value = df1.format(val);
                } else {
                    value = df1.format(val);
                }

            } else {
                val = val / 1e4;
                int valInt = (int) val;
                if (valInt >= 1e3) {
                    value = df1.format(valInt);
                } else if (valInt >= 100) {
                    value = df1.format(val);
                } else {
                    value = df1.format(val);
                }
                unit = "万";
            }
            return value + unit;
        } else {
            return value;
        }
    }

    //测试获取活跃股
    private static void testActiveStocksPage() {
        ActiveStocksPage.Param param = new ActiveStocksPage.Param(ActiveStocksPage.Param.Type.CHANGE_5, ActiveStocksPage.Param.Type.LB_1, ActiveStocksPage.Param.Type.UP_3, 1, 20);
        SourceManager.getInstance().getActiveStocksPage(param.getParams(), new SourceManager.onSourceCallBack<ActiveStocksPage>() {

            public void onSuccess(String data) {
            }

            public void onFailed(String errorMsg) {
                System.out.println(errorMsg);
            }

            public DataType getType() {
                return DataType.bean;
            }

            public ActiveStocksPage getBean(Document document, String json) {
                ActiveStocksPage page = GsonUtil.getGson().fromJson(json, ActiveStocksPage.class);
                System.out.println(page.toString());
                return page;
            }
        });
    }

    //测试获取股票详情
    private static void testStockDetail() {
        List<String> codes = new ArrayList();
        codes.add("1002173");
        codes.add("0600662");
        SourceManager.getInstance().getStockDetail(codes, new SourceManager.onSourceCallBack<Map<String, StockDetail>>() {


            public void onFailed(String errorMsg) {
                System.out.println(errorMsg);
            }


            public DataType getType() {
                return DataType.bean;
            }

            public void onSuccess(String data) {

            }

            public Map<String, StockDetail> getBean(Document document, String json) {
                Map<String, StockDetail> stockDetail = GsonUtil.getGson().fromJson(json, new TypeToken<Map<String, StockDetail>>() {
                }.getType());
                System.out.println(stockDetail.toString());
                return stockDetail;
            }
        });

    }

    //测试历史价格
    private static void testStockPrice() {
        try {
            StockHistoryPrice.Param param = new StockHistoryPrice.Param("601919", "2016", "3");
            StockHistoryPriceSource.getInstance().getSource(param, new SourceManager.onSourceCallBack<List<StockHistoryPrice>>() {

                public void onFailed(String errorMsg) {
                    System.out.println(errorMsg);
                }

                public DataType getType() {
                    return DataType.bean;
                }

                public void onSuccess(String data) {

                }

                public List<StockHistoryPrice> getBean(Document document, String json) {
                    List<StockHistoryPrice> list = StockHistoryPriceSource.getInstance().processData(document);
                    System.out.println(list);
                    return list;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取指标股 曙光初现
    private static void testQuotaStockType1() {
        try {
            QuotaStockPage.Param param = new QuotaStockPage.Param(1, 30, QuotaStockPage.Type.type1);
            SourceManager.getInstance().getQuotaStock(param.getParams(), new SourceManager.onSourceCallBack<QuotaStockPage.QuotaStockType1>() {
                public void onSuccess(String data) {

                }

                public void onFailed(String errorMsg) {

                }

                public DataType getType() {
                    return DataType.bean;
                }

                public QuotaStockPage.QuotaStockType1 getBean(Document document, String json) {
                    QuotaStockPage.QuotaStockType1 type1 = GsonUtil.getGson().fromJson(json, QuotaStockPage.QuotaStockType1.class);
                    System.out.println(type1.toString());
                    return type1;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取指标股 蓄势待发
    private static void testQuotaStockType4() {
        try {
            QuotaStockPage.Param param = new QuotaStockPage.Param(1, 30, QuotaStockPage.Type.type4);
            SourceManager.getInstance().getQuotaStock(param.getParams(), new SourceManager.onSourceCallBack<QuotaStockPage.QuotaStockType4>() {
                public void onSuccess(String data) {

                }

                public void onFailed(String errorMsg) {

                }

                public DataType getType() {
                    return DataType.bean;
                }

                public QuotaStockPage.QuotaStockType4 getBean(Document document, String json) {
                    QuotaStockPage.QuotaStockType4 type = GsonUtil.getGson().fromJson(json, QuotaStockPage.QuotaStockType4.class);
                    System.out.println(type.toString());
                    return type;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取指标股 空中加油
    private static void testQuotaStockType2() {
        try {
            QuotaStockPage.Param param = new QuotaStockPage.Param(1, 30, QuotaStockPage.Type.type2);
            SourceManager.getInstance().getQuotaStock(param.getParams(), new SourceManager.onSourceCallBack<QuotaStockPage.QuotaStockType2>() {
                public void onSuccess(String data) {

                }

                public void onFailed(String errorMsg) {

                }

                public DataType getType() {
                    return DataType.bean;
                }

                public QuotaStockPage.QuotaStockType2 getBean(Document document, String json) {
                    QuotaStockPage.QuotaStockType2 type = GsonUtil.getGson().fromJson(json, QuotaStockPage.QuotaStockType2.class);
                    System.out.println(type.toString());
                    return type;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取指标股 超级短线
    private static void testQuotaStockType3() {
        try {
            QuotaStockPage.Param param = new QuotaStockPage.Param(1, 30, QuotaStockPage.Type.type3);
            SourceManager.getInstance().getQuotaStock(param.getParams(), new SourceManager.onSourceCallBack<QuotaStockPage.QuotaStockType3>() {
                public void onSuccess(String data) {

                }

                public void onFailed(String errorMsg) {

                }

                public DataType getType() {
                    return DataType.bean;
                }

                public QuotaStockPage.QuotaStockType3 getBean(Document document, String json) {
                    QuotaStockPage.QuotaStockType3 type = GsonUtil.getGson().fromJson(json, QuotaStockPage.QuotaStockType3.class);
                    System.out.println(type.toString());
                    return type;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取研报股
    private static void testResearchStock(ResearchStockPage.Type type) {
        try {
            ResearchStockPage.Param param = new ResearchStockPage.Param(1, 30, type);
            SourceManager.getInstance().getResearchStock(param.getParams(), new SourceManager.onSourceCallBack<ResearchStockPage>() {
                public void onSuccess(String data) {

                }

                public void onFailed(String errorMsg) {

                }

                public DataType getType() {
                    return DataType.bean;
                }

                public ResearchStockPage getBean(Document document, String json) {
                    ResearchStockPage researchStock = GsonUtil.getGson().fromJson(json, ResearchStockPage.class);
                    System.out.println(researchStock.toString());
                    return researchStock;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取敢死队
    private static void testDeathSquadStockPage() {
        try {
            DeathSquadStockPage.Param param = new DeathSquadStockPage.Param(1, 30);
            SourceManager.getInstance().getDeathSquadStockPage(param.getParams(), new SourceManager.onSourceCallBack<DeathSquadStockPage>() {
                public void onSuccess(String data) {

                }

                public void onFailed(String errorMsg) {
                    System.out.println(errorMsg);
                }

                public DataType getType() {
                    return DataType.bean;
                }

                public DeathSquadStockPage getBean(Document document, String json) {
                    DeathSquadStockPage deathSquadStockPage = GsonUtil.getGson().fromJson(json, DeathSquadStockPage.class);
                    System.out.println(deathSquadStockPage.toString());
                    return deathSquadStockPage;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取股票公告
    private static void getStockNotice() {
        StockNotice.Param param = new StockNotice.Param("601766", 30);
        StockNoticeSource.getInstance().getStockNotice(param.getParams(), new SourceManager.onSourceCallBack<StockNotice>() {
            public void onSuccess(String data) {

            }

            public void onFailed(String errorMsg) {
                System.out.println(errorMsg);
            }

            public DataType getType() {
                return DataType.bean;
            }

            public StockNotice getBean(Document document, String json) {
                StockNotice stockNotice = GsonUtil.getGson().fromJson(json, StockNotice.class);
                System.out.println(stockNotice.toString());
                return stockNotice;
            }
        });
    }

    //获取股票新闻
    private static void getStockNews() {
        StockNews.Param param = new StockNews.Param("601766", 30);
        StockNoticeSource.getInstance().getStockNotice(param.getParams(), new SourceManager.onSourceCallBack<StockNews>() {
            public void onSuccess(String data) {

            }

            public void onFailed(String errorMsg) {
                System.out.println(errorMsg);
            }

            public DataType getType() {
                return DataType.bean;
            }

            public StockNews getBean(Document document, String json) {
                StockNews stockNews = GsonUtil.getGson().fromJson(json, StockNews.class);
                System.out.println(stockNews.toString());
                return stockNews;
            }
        });
    }

    //获取股票新闻
    private static void getStockQuota() {
        StockQuota.Param param = new StockQuota.Param("601766");
        SourceManager.getInstance().getStockQuota(param.getParams(), new SourceManager.onSourceCallBack<StockQuota>() {
            public void onSuccess(String data) {

            }

            public void onFailed(String errorMsg) {
                System.out.println(errorMsg);
            }

            public DataType getType() {
                return DataType.bean;
            }

            public StockQuota getBean(Document document, String json) {
                StockQuota stockQuota = GsonUtil.getGson().fromJson(json, StockQuota.class);
                System.out.println(stockQuota.toString());
                return stockQuota;
            }
        });
    }

    static StockHandicap stockHandicap = null;

    //测试获取东方财富盘口
    private static void getDFCFHandicap() {
        SourceManager.getInstance().getDFCFHandicapSource("6033931", new SourceManager.onSourceCallBack<StockHandicap>() {
            public void onSuccess(String json) {
                if (json.indexOf("{") != -1) {
                    json = json.replace("{", "");
                }
                if (json.indexOf("}") != -1) {
                    json = json.replace("}", "");
                }
                List<List<String>> newList = GsonUtil.getGson().fromJson(json, new TypeToken<List<List<String>>>() {
                }.getType());
                String data = newList.get(0).get(0);
                System.out.println("data=" + data);
                String[] benData = data.split(",");
                System.out.println("benData=" + benData.length);
                List<String> baseData = Arrays.asList(benData);
                StockHandicap.getInstance(HandicapSource.HandicapType.DFCF, baseData);

            }

            public void onFailed(String errorMsg) {
                System.out.println(errorMsg);
            }

            public DataType getType() {
                return json;
            }

            public StockHandicap getBean(Document document, String json) {
                return null;
            }
        });
        /*String json = "[[\"2,000766,通化金马,19.51,19.60,19.55,-0.05,-0.26%,0.80%,19.66,19.36,35754,69823376,21.56,17.64,15838,19916,0.88,99.74,132.99,966494707,18894970784,449016256,8778267462,4.67,0.15,2016-09-30,2016-10-28 15:00:00,14:55:18~19.57~191~-1~~|14:55:21~19.57~2~-1~~|14:55:24~19.57~10~-1~~|14:55:27~19.57~6~-1~~|14:55:30~19.58~41~1~~|14:55:33~19.57~2~-1~~|14:55:39~19.58~53~1~~|14:55:42~19.58~6~-1~~|14:55:45~19.58~76~-1~~|14:55:48~19.57~300~-1~~|14:55:54~19.60~6~1~~|14:56:00~19.57~88~-1~~|14:56:06~19.56~16~-1~~|14:56:15~19.56~3~-1~~|14:56:18~19.56~5~-1~~|14:56:21~19.56~3~-1~~|14:56:24~19.56~2~1~~|14:56:27~19.56~2~1~~|14:56:30~19.55~3~-1~~|14:56:33~19.56~70~1~~|14:56:39~19.56~5~1~~|14:56:45~19.55~10~-1~~|14:56:48~19.55~5~-1~~|14:56:54~19.55~16~1~~|15:00:59~19.55~433~1~~,1,433,4.19,3577787,-4777618,22860677,-22973000,24878398,-27277835,17496115,-13784523,19.54,19.50,19.48,19.47,19.46,19.55,19.56,19.57,19.59,19.60,10,88,87,8,16,186,177,61,50,111,-,1.53%\"]]";
        List<List<String>> newList = GsonUtil.getGson().fromJson(json, new TypeToken<List<List<String>>>() {
        }.getType());
        String data = newList.get(0).get(0);
        System.out.println("data=" + data);
        String[] benData = data.split(",");
        System.out.println("benData=" + benData.length);
        List<String> baseData = new ArrayList<String>();
        for (int i = 0; i <= 31; i++) {
            if (i == 28) continue;
            String d = benData[i];
            System.out.println(i + "=" + d);
            baseData.add(d);
        }
        System.out.println("baseData=" + baseData);*/
    }

    public static void getStockClassify() {
        StockClassifySource.getInstance().setCode("002746").getSource(new SourceManager.onSourceCallBack<StockClassify>() {
            public void onSuccess(String data) {

            }

            public void onFailed(String errorMsg) {

            }

            public DataType getType() {
                return DataType.bean;
            }

            public StockClassify getBean(Document document, String json) {
                System.out.println(json);
                StockClassify stockClassify = GsonUtil.getGson().fromJson(json, StockClassify.class);
                System.out.println(stockClassify.getBean().toString());
                return stockClassify;
            }
        });

    }

}
