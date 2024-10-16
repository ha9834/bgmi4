package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbse extends zzbts<zzbrl> {
    public zzbse(Set<zzbuz<zzbrl>> set) {
        super(set);
    }

    public final void onAdClosed() {
        a(oi.f2392a);
    }

    public final void onAdLeftApplication() {
        a(oj.f2393a);
    }

    public final void onAdOpened() {
        a(ok.f2394a);
    }

    public final void onRewardedVideoStarted() {
        a(ol.f2395a);
    }

    public final void zzb(final zzasr zzasrVar, final String str, final String str2) {
        a(new zzbtu(zzasrVar, str, str2) { // from class: com.google.android.gms.internal.ads.om

            /* renamed from: a, reason: collision with root package name */
            private final zzasr f2396a;
            private final String b;
            private final String c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2396a = zzasrVar;
                this.b = str;
                this.c = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((zzbrl) obj).zzb(this.f2396a, this.b, this.c);
            }
        });
    }

    public final void onRewardedVideoCompleted() {
        a(on.f2397a);
    }
}
