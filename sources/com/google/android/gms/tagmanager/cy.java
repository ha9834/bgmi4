package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzox;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cy implements cz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cu cuVar) {
    }

    @Override // com.google.android.gms.tagmanager.cz
    public final void a(zzox zzoxVar, Set<zzot> set, Set<zzot> set2, ci ciVar) {
        set.addAll(zzoxVar.zzly());
        set2.addAll(zzoxVar.zzlz());
        ciVar.e();
        ciVar.f();
    }
}
