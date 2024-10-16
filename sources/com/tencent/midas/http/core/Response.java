package com.tencent.midas.http.core;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class Response {
    private Request request;
    public String responseBody;
    private Object tag;
    public int resultCode = -1;
    public Exception exception = null;
    public boolean needBreakOtherInterceptors = false;
    public boolean isStopped = false;

    public final void setRequest(Request request) {
        this.request = request;
    }

    public final Request request() {
        return this.request;
    }

    public final boolean isHttpsResponse() {
        Request request = this.request;
        return request != null && request.isHttpsRequest();
    }

    public final void setTag(Object obj) {
        if (obj != null) {
            this.tag = obj;
        }
    }

    public final Object getTag() {
        return this.tag;
    }

    public final boolean isSuccess() {
        return isResultCodeOK() && !TextUtils.isEmpty(this.responseBody) && this.exception == null;
    }

    public final boolean isResultCodeOK() {
        return this.resultCode == 200;
    }

    public final boolean hasNotEmptyBody() {
        return !TextUtils.isEmpty(this.responseBody);
    }

    public final boolean hasException() {
        return this.exception != null;
    }

    public final void resetNeedBreakOtherInterceptors() {
        this.needBreakOtherInterceptors = false;
    }
}
