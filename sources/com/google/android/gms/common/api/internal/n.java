package com.google.android.gms.common.api.internal;

/* loaded from: classes.dex */
final class n extends w {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaak f1369a;
    private final /* synthetic */ com.google.android.gms.signin.internal.zaj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, zabd zabdVar, zaak zaakVar, com.google.android.gms.signin.internal.zaj zajVar) {
        super(zabdVar);
        this.f1369a = zaakVar;
        this.b = zajVar;
    }

    @Override // com.google.android.gms.common.api.internal.w
    public final void a() {
        this.f1369a.a(this.b);
    }
}
