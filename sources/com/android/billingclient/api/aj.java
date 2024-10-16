package com.android.billingclient.api;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name */
    private String f945a;

    private aj() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(ai aiVar) {
    }

    public final aj a(String str) {
        this.f945a = str;
        return this;
    }

    public final ak a() {
        if (TextUtils.isEmpty(this.f945a)) {
            throw new IllegalArgumentException("SKU must be set.");
        }
        return new ak(this.f945a, null, null);
    }
}
