package com.a.a;

import android.webkit.JavascriptInterface;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final com.a.a.a.a f936a;

    public b(com.a.a.a.a aVar) {
        this.f936a = aVar;
    }

    @JavascriptInterface
    public void returnResultToJava(String str) {
        this.f936a.g(str);
    }
}
