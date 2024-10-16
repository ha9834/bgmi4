package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* loaded from: classes.dex */
final class bf extends bm {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f3856a;
    private /* synthetic */ zzci b;
    private /* synthetic */ DiscoveryOptions c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(zzcqw zzcqwVar, GoogleApiClient googleApiClient, String str, zzci zzciVar, DiscoveryOptions discoveryOptions) {
        super(googleApiClient, null);
        this.f3856a = str;
        this.b = zzciVar;
        this.c = discoveryOptions;
    }
}
