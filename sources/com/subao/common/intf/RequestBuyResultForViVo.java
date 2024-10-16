package com.subao.common.intf;

import com.subao.common.e;

/* loaded from: classes2.dex */
public class RequestBuyResultForViVo extends RequestBuyResult {
    private final String accessKey;
    private final String transNo;

    public RequestBuyResultForViVo(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.accessKey = str3;
        this.transNo = str4;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getTransNo() {
        return this.transNo;
    }

    @Override // com.subao.common.intf.RequestBuyResult
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestBuyResultForViVo)) {
            return false;
        }
        RequestBuyResultForViVo requestBuyResultForViVo = (RequestBuyResultForViVo) obj;
        return isEquals(requestBuyResultForViVo) && e.a(this.accessKey, requestBuyResultForViVo.accessKey) && e.a(this.transNo, requestBuyResultForViVo.transNo);
    }

    @Override // com.subao.common.intf.RequestBuyResult
    public String toString() {
        return String.format("[ResultForViVo: %s]", super.toString());
    }
}
