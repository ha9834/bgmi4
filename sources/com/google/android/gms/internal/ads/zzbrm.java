package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbrm extends zzbts<zzbro> implements zzbro {
    public zzbrm(Set<zzbuz<zzbro>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(final int i) {
        a(new zzbtu(i) { // from class: com.google.android.gms.internal.ads.oa

            /* renamed from: a, reason: collision with root package name */
            private final int f2384a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2384a = i;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((zzbro) obj).onAdFailedToLoad(this.f2384a);
            }
        });
    }
}
