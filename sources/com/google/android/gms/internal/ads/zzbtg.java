package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbtg extends zzbts<zzbtk> implements zzbtk {
    public zzbtg(Set<zzbuz<zzbtk>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzb(final zzarx zzarxVar) {
        a(new zzbtu(zzarxVar) { // from class: com.google.android.gms.internal.ads.oy

            /* renamed from: a, reason: collision with root package name */
            private final zzarx f2406a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2406a = zzarxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((zzbtk) obj).zzb(this.f2406a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zza(final zzcxu zzcxuVar) {
        a(new zzbtu(zzcxuVar) { // from class: com.google.android.gms.internal.ads.oz

            /* renamed from: a, reason: collision with root package name */
            private final zzcxu f2407a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2407a = zzcxuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((zzbtk) obj).zza(this.f2407a);
            }
        });
    }
}
