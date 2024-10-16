package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aox implements ValueCallback<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ aow f2020a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aox(aow aowVar) {
        this.f2020a = aowVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        this.f2020a.d.a(this.f2020a.f2019a, this.f2020a.b, str, this.f2020a.c);
    }
}
