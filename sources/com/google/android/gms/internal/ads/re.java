package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final /* synthetic */ class re implements zzbam {

    /* renamed from: a, reason: collision with root package name */
    static final zzbam f2460a = new re();

    private re() {
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzcbg zzcbgVar : (List) obj) {
            if (zzcbgVar != null) {
                arrayList.add(zzcbgVar);
            }
        }
        return arrayList;
    }
}
