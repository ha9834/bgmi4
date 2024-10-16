package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
final class yb implements zzcva<zzcuz<Bundle>> {

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f2629a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public yb(Set<String> set) {
        this.f2629a = set;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<Bundle>> zzalm() {
        final ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f2629a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return zzbar.zzm(new zzcuz(arrayList) { // from class: com.google.android.gms.internal.ads.yc

            /* renamed from: a, reason: collision with root package name */
            private final ArrayList f2630a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2630a = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void zzt(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", this.f2630a);
            }
        });
    }
}
