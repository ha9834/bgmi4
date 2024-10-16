package com.tencent.smtt.sdk;

import android.util.Log;
import android.util.Pair;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class UrlRequestBuilderImpl extends UrlRequest.Builder {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6480a = "UrlRequestBuilderImpl";
    private final String b;
    private final UrlRequest.Callback c;
    private final Executor d;
    private String e;
    private boolean g;
    private final ArrayList<Pair<String, String>> f = new ArrayList<>();
    private int h = 3;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor) {
        if (str == null) {
            throw new NullPointerException("URL is required.");
        }
        if (callback == null) {
            throw new NullPointerException("Callback is required.");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required.");
        }
        this.b = str;
        this.c = callback;
        this.d = executor;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setHttpMethod(String str) {
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.e = str;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        if (HttpStack.HEADER_ACCEPT_ENCODING.equalsIgnoreCase(str)) {
            Log.w(f6480a, "It's not necessary to set Accept-Encoding on requests - x5-request will do this automatically for you, and setting it yourself has no effect.", new Exception());
            return this;
        }
        this.f.add(Pair.create(str, str2));
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.g = true;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int i) {
        this.h = i;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest build() throws NullPointerException {
        r a2 = r.a();
        if (a2 == null || !r.b()) {
            return null;
        }
        Log.d("UrlRequest", "call UrlRequest build");
        UrlRequest urlRequest = (UrlRequest) a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class}, this.b, Integer.valueOf(this.h), this.c, this.d, Boolean.valueOf(this.g), this.e, this.f);
        if (urlRequest != null) {
            return urlRequest;
        }
        throw new NullPointerException("UrlRequest build fail");
    }
}
