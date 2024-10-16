package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fp implements zzazw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2177a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(zzaxi zzaxiVar, Context context, String str) {
        this.f2177a = context;
        this.b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zzed(String str) {
        zzk.zzlg();
        zzaxi.zzb(this.f2177a, this.b, str);
    }
}
