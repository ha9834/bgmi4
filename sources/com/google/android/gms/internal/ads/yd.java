package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes2.dex */
final /* synthetic */ class yd implements zzbam {

    /* renamed from: a, reason: collision with root package name */
    static final zzbam f2631a = new yd();

    private yd() {
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final Object apply(Object obj) {
        final ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzcuz(arrayList) { // from class: com.google.android.gms.internal.ads.ye

            /* renamed from: a, reason: collision with root package name */
            private final ArrayList f2632a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2632a = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void zzt(Object obj2) {
                ((Bundle) obj2).putStringArrayList("android_permissions", this.f2632a);
            }
        };
    }
}
