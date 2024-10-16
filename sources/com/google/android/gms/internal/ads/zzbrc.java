package com.google.android.gms.internal.ads;

import android.os.Bundle;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbrc implements zzdti<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqy f3024a;

    private zzbrc(zzbqy zzbqyVar) {
        this.f3024a = zzbqyVar;
    }

    public static zzbrc zzg(zzbqy zzbqyVar) {
        return new zzbrc(zzbqyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    @Nullable
    public final /* synthetic */ Object get() {
        return this.f3024a.c();
    }
}
