package com.tencent.msdk.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends DefaultConnectionKeepAliveStrategy {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f6331a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f6331a = kVar;
    }

    @Override // org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy, org.apache.http.conn.ConnectionKeepAliveStrategy
    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        if (keepAliveDuration == -1) {
            return 30000L;
        }
        return keepAliveDuration;
    }
}
