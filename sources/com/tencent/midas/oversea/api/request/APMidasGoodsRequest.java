package com.tencent.midas.oversea.api.request;

/* loaded from: classes.dex */
public class APMidasGoodsRequest extends APMidasBaseRequest {
    private static final long serialVersionUID = -4326761659903564582L;
    public String goodsTokenUrl = "";

    public APMidasGoodsRequest() {
        this.mType = "bg";
        this.mOldType = 1;
    }

    public String getGoodsTokenUrl() {
        return this.goodsTokenUrl;
    }

    public void setGoodsTokenUrl(String str) {
        this.goodsTokenUrl = str;
    }
}
