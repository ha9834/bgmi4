package com.tencent.midas.oversea.newapi.params;

/* loaded from: classes.dex */
public class MallParams {
    private String country;
    private String currencyType;
    private boolean isAutoPay;
    private String payChannel;
    private byte[] resData;
    private int resId;

    private MallParams() {
        this.currencyType = "";
        this.country = "";
        this.isAutoPay = false;
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

    public int getResID() {
        return this.resId;
    }

    public byte[] getResData() {
        return this.resData;
    }

    public boolean isAutoPay() {
        return this.isAutoPay;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private MallParams params = new MallParams();

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

        public Builder setIsAutoPay(boolean z) {
            this.params.isAutoPay = z;
            return this;
        }

        public Builder setResID(int i) {
            this.params.resId = i;
            return this;
        }

        public Builder setResData(byte[] bArr) {
            this.params.resData = bArr;
            return this;
        }

        public MallParams build() {
            return this.params;
        }
    }
}
