package com.tencent.midas.oversea.newapi.params;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BillingFlowParams {
    public static final String TYPE_GAME = "save";
    public static final String TYPE_GOODS = "bg";
    public static final String TYPE_MONTH = "month";
    public static final String TYPE_UNION_MONTH = "unimonth";
    private String country;
    private String currencyType;
    private BillingFlowParamsExtra extra;
    private boolean isAutoPay;
    private String mType;
    private String payChannel;
    private String productID;
    private String serviceCode;
    private String serviceName;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    @interface Type {
    }

    private BillingFlowParams() {
        this.mType = "save";
        this.currencyType = "";
        this.country = "";
        this.serviceCode = "";
        this.serviceName = "";
        this.isAutoPay = false;
        this.extra = null;
    }

    public String getType() {
        return this.mType;
    }

    public String getCurrencyType() {
        return this.currencyType;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPayChannel() {
        return this.payChannel;
    }

    public String getProductID() {
        return this.productID;
    }

    public String getServiceCode() {
        return this.serviceCode;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public boolean isAutoPay() {
        return this.isAutoPay;
    }

    public BillingFlowParamsExtra getExtra() {
        if (this.extra == null) {
            this.extra = new BillingFlowParamsExtra();
        }
        return this.extra;
    }

    public HashMap<String, String> toMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(this.mType)) {
            hashMap.put("type", this.mType);
        }
        if (!TextUtils.isEmpty(this.currencyType)) {
            hashMap.put("currencyType", this.currencyType);
        }
        if (!TextUtils.isEmpty(this.country)) {
            hashMap.put(UserDataStore.COUNTRY, this.country);
        }
        if (!TextUtils.isEmpty(this.payChannel)) {
            hashMap.put("payChannel", this.payChannel);
        }
        if (!TextUtils.isEmpty(this.productID)) {
            hashMap.put("productId", this.productID);
        }
        if (!TextUtils.isEmpty(this.serviceCode)) {
            hashMap.put("serviceCode", this.serviceCode);
        }
        if (!TextUtils.isEmpty(this.serviceName)) {
            hashMap.put("serviceName", this.serviceName);
        }
        if (!TextUtils.isEmpty(this.extra.channelExtras)) {
            hashMap.put("channelExtras", this.extra.channelExtras);
        }
        if (!TextUtils.isEmpty(this.extra.drmInfo)) {
            hashMap.put("drmInfo", this.extra.drmInfo);
        }
        if (!TextUtils.isEmpty(this.extra.goodsZoneId)) {
            hashMap.put("goodsZoneId", this.extra.goodsZoneId);
        }
        return hashMap;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private BillingFlowParams params = new BillingFlowParams();

        public Builder setType(@Type String str) {
            this.params.mType = str;
            return this;
        }

        public Builder setCurrencyType(String str) {
            this.params.currencyType = str;
            return this;
        }

        public Builder setCountry(String str) {
            this.params.country = str;
            return this;
        }

        public Builder setPayChannel(String str) {
            this.params.payChannel = str;
            return this;
        }

        public Builder setProductID(String str) {
            this.params.productID = str;
            return this;
        }

        public Builder setServiceCode(String str) {
            this.params.serviceCode = str;
            return this;
        }

        public Builder setServiceName(String str) {
            this.params.serviceName = str;
            return this;
        }

        public Builder setIsAutoPay(boolean z) {
            this.params.isAutoPay = z;
            return this;
        }

        public Builder setExtra(BillingFlowParamsExtra billingFlowParamsExtra) {
            this.params.extra = billingFlowParamsExtra;
            return this;
        }

        public BillingFlowParams build() {
            return this.params;
        }
    }

    /* loaded from: classes.dex */
    public static class BillingFlowParamsExtra {
        private String appExtends = "";
        private String channelExtras = "";
        private String drmInfo = "";
        private String goodsZoneId = "";

        public void setChannelExtras(String str) {
            this.channelExtras = str;
        }

        public void setAppExtends(String str) {
            this.appExtends = str;
        }

        public void setDrmInfo(String str) {
            this.drmInfo = str;
        }

        public void setGoodsZoneId(String str) {
            this.goodsZoneId = str;
        }

        public String getChannelExtras() {
            return this.channelExtras;
        }

        public String getAppExtends() {
            return this.appExtends;
        }

        public String getDrmInfo() {
            return this.drmInfo;
        }

        public String getGoodsZoneId() {
            return this.goodsZoneId;
        }
    }
}
