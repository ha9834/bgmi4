package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends w {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaah f1360a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zaah zaahVar, zabd zabdVar) {
        super(zabdVar);
        this.f1360a = zaahVar;
    }

    @Override // com.google.android.gms.common.api.internal.w
    public final void a() {
        this.f1360a.onConnectionSuspended(1);
    }
}
