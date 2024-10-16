package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final /* synthetic */ class qw implements zzbam {

    /* renamed from: a, reason: collision with root package name */
    static final zzbam f2451a = new qw();

    private qw() {
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzadw zzadwVar : (List) obj) {
            if (zzadwVar != null) {
                arrayList.add(zzadwVar);
            }
        }
        return arrayList;
    }
}
