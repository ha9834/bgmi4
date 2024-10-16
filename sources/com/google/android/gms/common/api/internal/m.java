package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class m extends com.google.android.gms.signin.internal.zac {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<zaak> f1368a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(zaak zaakVar) {
        this.f1368a = new WeakReference<>(zaakVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zad
    public final void zab(com.google.android.gms.signin.internal.zaj zajVar) {
        zabe zabeVar;
        zaak zaakVar = this.f1368a.get();
        if (zaakVar == null) {
            return;
        }
        zabeVar = zaakVar.f1386a;
        zabeVar.a(new n(this, zaakVar, zaakVar, zajVar));
    }
}
