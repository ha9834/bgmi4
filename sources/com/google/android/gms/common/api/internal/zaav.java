package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zaav implements zabd {

    /* renamed from: a, reason: collision with root package name */
    private final zabe f1387a;

    public zaav(zabe zabeVar) {
        this.f1387a = zabeVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean disconnect() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void begin() {
        Iterator<Api.Client> it = this.f1387a.f1390a.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect();
        }
        this.f1387a.d.c = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        this.f1387a.d.f1388a.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void connect() {
        this.f1387a.a();
    }
}
