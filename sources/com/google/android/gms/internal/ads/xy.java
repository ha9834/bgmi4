package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
final /* synthetic */ class xy implements zzbal {

    /* renamed from: a, reason: collision with root package name */
    static final zzbal f2625a = new xy();

    private xy() {
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh zzf(Object obj) {
        final String str = (String) obj;
        return zzbar.zzm(new zzcuz(str) { // from class: com.google.android.gms.internal.ads.xz

            /* renamed from: a, reason: collision with root package name */
            private final String f2626a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2626a = str;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void zzt(Object obj2) {
                ((Bundle) obj2).putString("ms", this.f2626a);
            }
        });
    }
}
