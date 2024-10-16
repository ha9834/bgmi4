package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
final class aau extends zzbts<zzczz> implements zzczr<zzczs> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aau(Set<zzbuz<zzczz>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzczr
    public final void zza(final zzcze<zzczs, ?> zzczeVar) {
        a(new zzbtu(zzczeVar) { // from class: com.google.android.gms.internal.ads.aav

            /* renamed from: a, reason: collision with root package name */
            private final zzcze f1769a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1769a = zzczeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                zzcze zzczeVar2 = this.f1769a;
                ((zzczz) obj).zza((zzczs) zzczeVar2.zzanb(), zzczeVar2.zzanc());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzczr
    public final void zzb(final zzcze<zzczs, ?> zzczeVar) {
        a(new zzbtu(zzczeVar) { // from class: com.google.android.gms.internal.ads.aaw

            /* renamed from: a, reason: collision with root package name */
            private final zzcze f1770a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1770a = zzczeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                zzcze zzczeVar2 = this.f1770a;
                ((zzczz) obj).zzb((zzczs) zzczeVar2.zzanb(), zzczeVar2.zzanc());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzczr
    public final void zza(final zzcze<zzczs, ?> zzczeVar, final Throwable th) {
        a(new zzbtu(zzczeVar, th) { // from class: com.google.android.gms.internal.ads.aax

            /* renamed from: a, reason: collision with root package name */
            private final zzcze f1771a;
            private final Throwable b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1771a = zzczeVar;
                this.b = th;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                zzcze zzczeVar2 = this.f1771a;
                ((zzczz) obj).zza((zzczs) zzczeVar2.zzanb(), zzczeVar2.zzanc(), this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzczr
    public final void zzc(final zzcze<zzczs, ?> zzczeVar) {
        a(new zzbtu(zzczeVar) { // from class: com.google.android.gms.internal.ads.aay

            /* renamed from: a, reason: collision with root package name */
            private final zzcze f1772a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1772a = zzczeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                zzcze zzczeVar2 = this.f1772a;
                ((zzczz) obj).zzc((zzczs) zzczeVar2.zzanb(), zzczeVar2.zzanc());
            }
        });
    }
}
