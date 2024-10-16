package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class zzczb implements zzdti<ThreadFactory> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzczb f3514a = new zzczb();

    public static zzczb zzana() {
        return f3514a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (ThreadFactory) zzdto.zza(new aak(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
