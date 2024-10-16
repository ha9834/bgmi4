package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzox;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cx implements cz {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Map f5111a;
    private final /* synthetic */ Map b;
    private final /* synthetic */ Map c;
    private final /* synthetic */ Map d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cu cuVar, Map map, Map map2, Map map3, Map map4) {
        this.f5111a = map;
        this.b = map2;
        this.c = map3;
        this.d = map4;
    }

    @Override // com.google.android.gms.tagmanager.cz
    public final void a(zzox zzoxVar, Set<zzot> set, Set<zzot> set2, ci ciVar) {
        List list = (List) this.f5111a.get(zzoxVar);
        this.b.get(zzoxVar);
        if (list != null) {
            set.addAll(list);
            ciVar.c();
        }
        List list2 = (List) this.c.get(zzoxVar);
        this.d.get(zzoxVar);
        if (list2 != null) {
            set2.addAll(list2);
            ciVar.d();
        }
    }
}
