package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzcq;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* loaded from: classes.dex */
final class ah extends zzcq<zzcov, EndpointDiscoveryCallback> {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f3791a;
    private /* synthetic */ zzci b;
    private /* synthetic */ DiscoveryOptions c;
    private /* synthetic */ zzcpz d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(zzcpz zzcpzVar, zzci zzciVar, String str, zzci zzciVar2, DiscoveryOptions discoveryOptions) {
        super(zzciVar);
        this.d = zzcpzVar;
        this.f3791a = str;
        this.b = zzciVar2;
        this.c = discoveryOptions;
    }
}
