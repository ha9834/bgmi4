package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class as implements au {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zacp f1344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(zacp zacpVar) {
        this.f1344a = zacpVar;
    }

    @Override // com.google.android.gms.common.api.internal.au
    public final void a(BasePendingResult<?> basePendingResult) {
        this.f1344a.f1398a.remove(basePendingResult);
    }
}
