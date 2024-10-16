package com.tencent.midas.oversea.newapi.params;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;

/* loaded from: classes.dex */
public class InitParams {
    public static final String IDC_CANADA = "canada";
    public static final String IDC_HONGKONG = "hongkong";
    public static final String IDC_LOCAL = "local";
    public static final String TAG = "InitParams";
    private String env;
    private InitParamsExtra extra;
    private String idc;
    private String offerID;
    private String openID;
    private String zoneID;

    private InitParams() {
        this.zoneID = "1";
        this.extra = null;
    }

    public InitParamsExtra getExtra() {
        if (this.extra == null) {
            this.extra = new InitParamsExtra();
        }
        return this.extra;
    }

    public String getIDC() {
        return this.idc;
    }

    public String getEnv() {
        return this.env;
    }

    public String getOfferID() {
        return this.offerID;
    }

    public String getOpenID() {
        return this.openID;
    }

    public String getZoneID() {
        return this.zoneID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkParams() {
        if (TextUtils.isEmpty(this.idc)) {
            APLog.e(TAG, "IDC is empty,please set it !!");
            return false;
        }
        if (TextUtils.isEmpty(this.offerID)) {
            APLog.e(TAG, "offerID is empty,please set it !!");
            return false;
        }
        if (TextUtils.isEmpty(this.openID)) {
            APLog.e(TAG, "openID is empty,please set it !!");
            return false;
        }
        if (!TextUtils.isEmpty(this.zoneID)) {
            return true;
        }
        APLog.e(TAG, "zoneID is empty,please set it !!");
        return false;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private InitParams mParams = new InitParams();

        public Builder setEnv(String str) {
            this.mParams.env = str;
            return this;
        }

        public Builder setIDC(String str) {
            this.mParams.idc = str;
            return this;
        }

        public Builder setOfferID(String str) {
            this.mParams.offerID = str;
            return this;
        }

        public Builder setOpenID(String str) {
            this.mParams.openID = str;
            return this;
        }

        public Builder setZoneID(String str) {
            this.mParams.zoneID = str;
            return this;
        }

        public Builder setExtra(InitParamsExtra initParamsExtra) {
            this.mParams.extra = initParamsExtra;
            return this;
        }

        public InitParams build() {
            if (!this.mParams.checkParams()) {
                throw new IllegalArgumentException("params are missed,please check init params.");
            }
            return this.mParams;
        }
    }

    /* loaded from: classes.dex */
    public static class InitParamsExtra {
        private String idcInfo;
        private String pf = "huyu_m-2001-android-2001";
        private String pfKey = "pfKey";
        private String sessionID = "hy_gameid";
        private String sessionType = "st_dummy";
        private String openKey = "openkey";
        private String goodsZoneID = "";

        public void setPF(String str) {
            this.pf = str;
        }

        public void setPFKey(String str) {
            this.pfKey = str;
        }

        public void setSessionID(String str) {
            this.sessionID = str;
        }

        public void setSessionType(String str) {
            this.sessionType = str;
        }

        public void setGoodsZoneID(String str) {
            this.goodsZoneID = str;
        }

        public void setIDCInfo(String str) {
            this.idcInfo = str;
        }

        public void setOpenKey(String str) {
            this.openKey = str;
        }

        public String getOpenKey() {
            return this.openKey;
        }

        public String getPf() {
            return this.pf;
        }

        public String getPfKey() {
            return this.pfKey;
        }

        public String getSessionID() {
            return this.sessionID;
        }

        public String getSessionType() {
            return this.sessionType;
        }

        public String getGoodsZoneID() {
            return this.goodsZoneID;
        }

        public String getIDCInfo() {
            return this.idcInfo;
        }
    }
}
