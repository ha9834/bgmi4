package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public class Response<T extends Result> {

    /* renamed from: a, reason: collision with root package name */
    private T f1300a;

    public Response() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Response(T t) {
        this.f1300a = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T a() {
        return this.f1300a;
    }

    public void setResult(T t) {
        this.f1300a = t;
    }
}
