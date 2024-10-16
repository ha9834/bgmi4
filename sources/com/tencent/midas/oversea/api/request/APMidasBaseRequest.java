package com.tencent.midas.oversea.api.request;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class APMidasBaseRequest implements Serializable {
    public static final String DEFAULTPRODUCTID = "FFFFFFFF";
    public static final int MALL_TYPE_DEFAULT = 0;
    public static final int MALL_TYPE_GROUPBUY = 1;
    public static final int MALL_TYPE_VMALL = 2;
    public static final String OFFER_TYPE_BG = "bg";
    public static final String OFFER_TYPE_GAME = "save";
    public static final String OFFER_TYPE_UNIONMONTH = "unimonth";
    private static final long serialVersionUID = -9123623786877679280L;
    public String goodsZoneId;
    public String h5Url;
    public int mOldType;
    public String mType;
    public int mallType;
    public byte[] resData;
    public String reserv;
    public String currency_type = "";
    public String country = "";
    public String extras = "";
    public String offerId = "";
    public String openId = "";
    public String openKey = "";
    public String sessionId = "";
    public String sessionType = "";
    public String zoneId = "";
    public String pf = "";
    public String pfKey = "";
    public int resId = 0;
    public String acctType = "common";
    public String saveValue = "";
    public boolean isCanChange = true;
    public APMidasMPInfo mpInfo = new APMidasMPInfo();
    public APMidasExtendInfo extendInfo = new APMidasExtendInfo();

    /* loaded from: classes.dex */
    public class APMidasExtendInfo implements Serializable {
        private static final long serialVersionUID = -5387967973327966068L;
        public String iChannel;
        public String userExtend;
        public String unit = "";
        public boolean isShowNum = true;
        public boolean isShowListOtherNum = true;

        public APMidasExtendInfo() {
            this.userExtend = "";
            this.iChannel = "";
            this.userExtend = "";
            this.iChannel = "";
        }
    }

    /* loaded from: classes.dex */
    public class APMidasMPInfo implements Serializable {
        private static final long serialVersionUID = 631101753621041424L;
        public String discoutId;
        public String drmInfo;
        public String extras;
        public String productid;
        public String payChannel = "";
        public String discountType = "";
        public String discountUrl = "";

        public APMidasMPInfo() {
            this.drmInfo = "";
            this.discoutId = "";
            this.extras = "";
            this.drmInfo = "";
            this.discoutId = "";
            this.extras = "";
        }
    }

    public APMidasBaseRequest() {
        this.mallType = 0;
        this.h5Url = "";
        this.mallType = 0;
        this.h5Url = "";
    }

    public String getOfferId() {
        return this.offerId;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getOpenKey() {
        return this.openKey;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSessionType() {
        return this.sessionType;
    }

    public String getZoneId() {
        return this.zoneId;
    }

    public String getPf() {
        return this.pf;
    }

    public String getPfKey() {
        return this.pfKey;
    }

    public String getSaveValue() {
        return this.saveValue;
    }

    public boolean getIsCanChange() {
        return this.isCanChange;
    }

    public int getResId() {
        return this.resId;
    }

    public byte[] getResData() {
        return this.resData;
    }

    public String getAcctType() {
        return this.acctType;
    }

    public String getReserv() {
        return this.reserv;
    }

    public int getMallType() {
        return this.mallType;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public String getPayChannel() {
        return this.mpInfo.payChannel;
    }

    public String getAssignProductid() {
        return this.mpInfo.productid;
    }

    public String getDiscountType() {
        return this.mpInfo.discountType;
    }

    public String getDiscountUrl() {
        return this.mpInfo.discountUrl;
    }

    public String getDrmInfo() {
        return this.mpInfo.drmInfo;
    }

    public String getDiscoutId() {
        return this.mpInfo.discoutId;
    }

    public String getExtras() {
        return this.mpInfo.extras;
    }

    public String getUnit() {
        return this.extendInfo.unit;
    }

    public boolean getShowNum() {
        return this.extendInfo.isShowNum;
    }

    public boolean getShowListOtherNum() {
        return this.extendInfo.isShowListOtherNum;
    }

    public void setOfferId(String str) {
        this.offerId = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public void setOpenKey(String str) {
        this.openKey = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSessionType(String str) {
        this.sessionType = str;
    }

    public void setZoneId(String str) {
        this.zoneId = str;
    }

    public void setPf(String str) {
        this.pf = str;
    }

    public void setPfKey(String str) {
        this.pfKey = str;
    }

    public void setSaveValue(String str) {
        this.saveValue = str;
    }

    public void setIsCanChange(boolean z) {
        this.isCanChange = z;
    }

    public void setResId(int i) {
        this.resId = i;
    }

    public void setResData(byte[] bArr) {
        this.resData = bArr;
    }

    public void setAcctType(String str) {
        this.acctType = str;
    }

    public void setReserv(String str) {
        this.reserv = str;
    }

    public void setMallType(int i) {
        this.mallType = i;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public void setPayChannel(String str) {
        this.mpInfo.payChannel = str;
    }

    public void setDiscountType(String str) {
        this.mpInfo.discountType = str;
    }

    public void setDiscountUrl(String str) {
        this.mpInfo.discountUrl = str;
    }

    public void setDrmInfo(String str) {
        this.mpInfo.drmInfo = str;
    }

    public void setDiscoutId(String str) {
        this.mpInfo.discoutId = str;
    }

    public void setExtras(String str) {
        this.mpInfo.extras = str;
    }

    public void setUnit(String str) {
        this.extendInfo.unit = str;
    }

    public void setShowNum(boolean z) {
        this.extendInfo.isShowNum = z;
    }

    public void setShowListOtherNum(boolean z) {
        this.extendInfo.isShowListOtherNum = z;
    }
}
