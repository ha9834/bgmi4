package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class gv implements zzban {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2201a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gv(String str) {
        this.f2201a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzk(@Nullable Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        zzk.zzlk().zza(th, this.f2201a);
    }
}
