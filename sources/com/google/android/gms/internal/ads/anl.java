package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
final class anl implements zzqw {

    /* renamed from: a, reason: collision with root package name */
    private final int f1987a;
    private final /* synthetic */ ane b;

    public anl(ane aneVar, int i) {
        this.b = aneVar;
        this.f1987a = i;
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final boolean isReady() {
        return this.b.a(this.f1987a);
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zzjb() throws IOException {
        this.b.b();
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final int zzb(zzlj zzljVar, zznd zzndVar, boolean z) {
        return this.b.a(this.f1987a, zzljVar, zzndVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zzeo(long j) {
        this.b.a(this.f1987a, j);
    }
}
