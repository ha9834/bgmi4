package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbvj extends zzbts<zzahy> implements zzahy {
    public zzbvj(Set<zzbuz<zzahy>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final synchronized void zzrq() {
        a(pl.f2417a);
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void zza(final zzato zzatoVar) {
        a(new zzbtu(zzatoVar) { // from class: com.google.android.gms.internal.ads.pm

            /* renamed from: a, reason: collision with root package name */
            private final zzato f2418a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2418a = zzatoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((zzahy) obj).zza(this.f2418a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void zzrr() {
        a(pn.f2419a);
    }
}
