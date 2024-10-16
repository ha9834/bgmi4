package com.subao.common.intf;

import com.subao.common.e;

/* loaded from: classes2.dex */
public class RequestBuyResult {
    private final String orderId;
    private final String productId;

    public RequestBuyResult(String str, String str2) {
        this.productId = str;
        this.orderId = str2;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof RequestBuyResult) {
            return isEquals((RequestBuyResult) obj);
        }
        return false;
    }

    public boolean isEquals(RequestBuyResult requestBuyResult) {
        return e.a(this.productId, requestBuyResult.productId) && e.a(this.orderId, requestBuyResult.orderId);
    }

    public String toString() {
        return String.format("[p=%s, o=%s]", this.productId, this.orderId);
    }
}
