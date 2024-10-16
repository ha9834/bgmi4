package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends p {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Api.Client> f1367a;
    private final /* synthetic */ zaak b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(zaak zaakVar, ArrayList<Api.Client> arrayList) {
        super(zaakVar, null);
        this.b = zaakVar;
        this.f1367a = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void a() {
        zabe zabeVar;
        Set<Scope> f;
        IAccountAccessor iAccountAccessor;
        zabe zabeVar2;
        zabeVar = this.b.f1386a;
        zaaw zaawVar = zabeVar.d;
        f = this.b.f();
        zaawVar.c = f;
        ArrayList<Api.Client> arrayList = this.f1367a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Api.Client client = arrayList.get(i);
            i++;
            iAccountAccessor = this.b.o;
            zabeVar2 = this.b.f1386a;
            client.getRemoteService(iAccountAccessor, zabeVar2.d.c);
        }
    }
}
