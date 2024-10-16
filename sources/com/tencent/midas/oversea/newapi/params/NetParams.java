package com.tencent.midas.oversea.newapi.params;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class NetParams {
    public static final String GET_SHORT_OPENID = "get_short_openid";
    public static final String MP = "mp";
    private String mpReqType = "";

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    @interface MP {
    }

    public String getMpReqType() {
        return this.mpReqType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkParams() {
        return !TextUtils.isEmpty(this.mpReqType) && (MP.equals(this.mpReqType) || GET_SHORT_OPENID.equals(this.mpReqType));
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private NetParams params = new NetParams();

        public Builder setMpReqType(@MP String str) {
            this.params.mpReqType = str;
            return this;
        }

        public NetParams build() {
            if (!this.params.checkParams()) {
                throw new IllegalArgumentException("params are missed,please check init params.");
            }
            return this.params;
        }
    }
}
