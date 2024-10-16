package com.tencent.imsdk.android.base.stat;

import androidx.annotation.Keep;
import java.util.List;
import java.util.Map;

@Keep
/* loaded from: classes.dex */
public class IMSDKStatEventParams {
    public String currencyCode;
    public long elapse;
    public String eventBody;
    public String eventName;
    public String expense;
    public List<String> extraList;
    public Map<String, String> extraParams;
    public boolean isActive;
    public boolean isRealTime;
    public boolean isSucceed;
    public String quantity;
    public long size;

    public IMSDKStatEventParams(Builder builder) {
        this.eventName = builder.eventName;
        this.eventBody = builder.eventBody;
        this.isActive = builder.isActive;
        this.isRealTime = builder.isRealTime;
        this.extraParams = builder.extraParams;
        this.currencyCode = builder.currencyCode;
        this.quantity = builder.quantity;
        this.expense = builder.expense;
        this.isSucceed = builder.isSucceed;
        this.elapse = builder.elapse;
        this.size = builder.size;
        this.extraList = builder.extraList;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public String currencyCode;
        public long elapse;
        public String eventBody;
        public String eventName;
        public String expense;
        public List<String> extraList;
        public Map<String, String> extraParams;
        public boolean isActive;
        public boolean isRealTime;
        public boolean isSucceed;
        public String quantity;
        public long size;

        public Builder setExtraList(List<String> list) {
            this.extraList = list;
            return this;
        }

        public Builder setElapse(long j) {
            this.elapse = j;
            return this;
        }

        public Builder setSize(long j) {
            this.size = j;
            return this;
        }

        public Builder setEventName(String str) {
            this.eventName = str;
            return this;
        }

        public Builder setEventBody(String str) {
            this.eventBody = str;
            return this;
        }

        public Builder setRealTime(boolean z) {
            this.isRealTime = z;
            return this;
        }

        public Builder setActive(boolean z) {
            this.isActive = z;
            return this;
        }

        public Builder setSucceed(boolean z) {
            this.isActive = z;
            return this;
        }

        public Builder setCurrencyCode(String str) {
            this.currencyCode = str;
            return this;
        }

        public Builder setQuantity(String str) {
            this.quantity = str;
            return this;
        }

        public Builder setExpense(String str) {
            this.expense = str;
            return this;
        }

        public Builder setExtraParams(Map<String, String> map) {
            this.extraParams = map;
            return this;
        }

        public IMSDKStatEventParams create() {
            return new IMSDKStatEventParams(this);
        }
    }
}
