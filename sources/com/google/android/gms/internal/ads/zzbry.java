package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbry extends zzbts<zzbrx> {
    public zzbry(Set<zzbuz<zzbrx>> set) {
        super(set);
    }

    public final void zzbp(final Context context) {
        a(new zzbtu(context) { // from class: com.google.android.gms.internal.ads.od

            /* renamed from: a, reason: collision with root package name */
            private final Context f2387a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2387a = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((zzbrx) obj).zzbp(this.f2387a);
            }
        });
    }

    public final void zzbq(final Context context) {
        a(new zzbtu(context) { // from class: com.google.android.gms.internal.ads.of

            /* renamed from: a, reason: collision with root package name */
            private final Context f2389a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2389a = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((zzbrx) obj).zzbq(this.f2389a);
            }
        });
    }

    public final void zzbr(final Context context) {
        a(new zzbtu(context) { // from class: com.google.android.gms.internal.ads.og

            /* renamed from: a, reason: collision with root package name */
            private final Context f2390a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2390a = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((zzbrx) obj).zzbr(this.f2390a);
            }
        });
    }

    public final void zza(zzbvp zzbvpVar, Executor executor) {
        zza(zzbuz.zzb(new oh(this, zzbvpVar), executor));
    }
}
