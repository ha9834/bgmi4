package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbra implements zzdti<String> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqy f3022a;

    private zzbra(zzbqy zzbqyVar) {
        this.f3022a = zzbqyVar;
    }

    public static zzbra zzf(zzbqy zzbqyVar) {
        return new zzbra(zzbqyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    @Nullable
    public final /* synthetic */ Object get() {
        return this.f3022a.d();
    }
}
