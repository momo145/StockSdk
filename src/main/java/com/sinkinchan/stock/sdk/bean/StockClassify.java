package com.sinkinchan.stock.sdk.bean;

import org.jsoup.helper.StringUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 2016/11/25.
 */
public class StockClassify {


    /**
     * success : true
     * message :
     * data : {"show_type":"table","data":{"title":["股票代码","600662"],"result":[["股票简称","强生控股"],["所属行业","公交"],["城市","浦东新区"],["主营产品名称","旅游服务||汽车服务||汽车租赁||房产||汽车出租||汽车销售||上海强生便捷货运||汽车修理||强生汽车贸易||房地产开发||出租汽车营运||房地产业务||交通运输||出租车业务||出租汽车"],["所属概念","融资融券;智能交通;地方国资改革;公共交通;迪士尼;转融券标的;网约车;上海国资改革;沪港通概念;阿里巴巴概念"]],"fieldType":["STR","STR"],"titleProcess":[],"staticList":1,"normalCodes":["600662"],"block_title":"基本概况","widths":[300,300]},"pid":"8153","title":"基本概况"}
     */

    private boolean success;
    private String message;
    /**
     * show_type : table
     * data : {"title":["股票代码","600662"],"result":[["股票简称","强生控股"],["所属行业","公交"],["城市","浦东新区"],["主营产品名称","旅游服务||汽车服务||汽车租赁||房产||汽车出租||汽车销售||上海强生便捷货运||汽车修理||强生汽车贸易||房地产开发||出租汽车营运||房地产业务||交通运输||出租车业务||出租汽车"],["所属概念","融资融券;智能交通;地方国资改革;公共交通;迪士尼;转融券标的;网约车;上海国资改革;沪港通概念;阿里巴巴概念"]],"fieldType":["STR","STR"],"titleProcess":[],"staticList":1,"normalCodes":["600662"],"block_title":"基本概况","widths":[300,300]}
     * pid : 8153
     * title : 基本概况
     */

    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Bean getBean() {
        return new Bean(this);
    }

    @Override
    public String toString() {
        return "StockClassify{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        private String show_type;
        /**
         * title : ["股票代码","600662"]
         * result : [["股票简称","强生控股"],["所属行业","公交"],["城市","浦东新区"],["主营产品名称","旅游服务||汽车服务||汽车租赁||房产||汽车出租||汽车销售||上海强生便捷货运||汽车修理||强生汽车贸易||房地产开发||出租汽车营运||房地产业务||交通运输||出租车业务||出租汽车"],["所属概念","融资融券;智能交通;地方国资改革;公共交通;迪士尼;转融券标的;网约车;上海国资改革;沪港通概念;阿里巴巴概念"]]
         * fieldType : ["STR","STR"]
         * titleProcess : []
         * staticList : 1
         * normalCodes : ["600662"]
         * block_title : 基本概况
         * widths : [300,300]
         */

        private ResultBean data;
        private String pid;
        private String title;

        public String getShow_type() {
            return show_type;
        }

        public void setShow_type(String show_type) {
            this.show_type = show_type;
        }

        public ResultBean getData() {
            return data;
        }

        public void setData(ResultBean data) {
            this.data = data;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class ResultBean {
            private int staticList;
            private String block_title;
            private List<String> title;
            private List<List<String>> result;
            private List<String> fieldType;
            private List<?> titleProcess;
            private List<String> normalCodes;
            private List<Integer> widths;

            public int getStaticList() {
                return staticList;
            }

            public void setStaticList(int staticList) {
                this.staticList = staticList;
            }

            public String getBlock_title() {
                return block_title;
            }

            public void setBlock_title(String block_title) {
                this.block_title = block_title;
            }

            public List<String> getTitle() {
                return title;
            }

            public void setTitle(List<String> title) {
                this.title = title;
            }

            public List<List<String>> getResult() {
                return result;
            }

            public void setResult(List<List<String>> result) {
                this.result = result;
            }

            public List<String> getFieldType() {
                return fieldType;
            }

            public void setFieldType(List<String> fieldType) {
                this.fieldType = fieldType;
            }

            public List<?> getTitleProcess() {
                return titleProcess;
            }

            public void setTitleProcess(List<?> titleProcess) {
                this.titleProcess = titleProcess;
            }

            public List<String> getNormalCodes() {
                return normalCodes;
            }

            public void setNormalCodes(List<String> normalCodes) {
                this.normalCodes = normalCodes;
            }

            public List<Integer> getWidths() {
                return widths;
            }

            public void setWidths(List<Integer> widths) {
                this.widths = widths;
            }

            @Override
            public String toString() {
                return "ResultBean{" +
                        "staticList=" + staticList +
                        ", block_title='" + block_title + '\'' +
                        ", title=" + title +
                        ", result=" + result +
                        ", fieldType=" + fieldType +
                        ", titleProcess=" + titleProcess +
                        ", normalCodes=" + normalCodes +
                        ", widths=" + widths +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "show_type='" + show_type + '\'' +
                    ", data=" + data +
                    ", pid='" + pid + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    public static class Bean {
        private final static String PRODUCT_SPLIT_REG = "\\|\\|";
        private final static String CONCEPT_SPLIT_REG = ";";

        public Bean(StockClassify stockClassify) {
            if (stockClassify != null) {
                if (stockClassify.data != null && stockClassify.data.data != null
                        && (stockClassify.data.data.result != null && stockClassify.data.data.result.size() >= 5)) {
                    List<List<String>> myResult = stockClassify.data.data.result;
                    //所属行业
                    List<String> industryList = myResult.get(1);
                    if (industryList != null && industryList.size() >= 2) {
                        industry = industryList.get(1);
                    }
                    //所属城市
                    List<String> cityList = myResult.get(2);
                    if (cityList != null && cityList.size() >= 2) {
                        city = cityList.get(1);
                    }
                    //主营产品
                    List<String> productList = myResult.get(3);
                    if (productList != null && productList.size() >= 2) {
                        String productArray = productList.get(1);
                        if (!StringUtil.isBlank(productArray) && productArray.contains("||")) {
                            products = Arrays.asList(productArray.split(PRODUCT_SPLIT_REG));
                        }
                    }
                    //所属概念
                    List<String> conceptList = myResult.get(4);
                    if (conceptList != null && conceptList.size() >= 2) {
                        String conceptArray = conceptList.get(1);
                        if (!StringUtil.isBlank(conceptArray) && conceptArray.contains(CONCEPT_SPLIT_REG)) {
                            concepts = Arrays.asList(conceptArray.split(CONCEPT_SPLIT_REG));
                        }
                    }
                }
            }
        }

        /**
         * 所属行业
         */
        private String industry;
        /**
         * 所属城市
         */
        private String city;
        /**
         * 经营产品
         */
        private List<String> products;
        /**
         * 所属概念
         */
        private List<String> concepts;

        public String getIndustry() {
            return industry;
        }

        public String getCity() {
            return city;
        }

        public List<String> getProducts() {
            return products;
        }

        public List<String> getConcepts() {
            return concepts;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "industry='" + industry + '\'' +
                    ", city='" + city + '\'' +
                    ", products=" + products +
                    ", concepts=" + concepts +
                    '}';
        }
    }
}
