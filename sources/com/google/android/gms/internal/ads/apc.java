package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class apc implements zzut {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzvn f2025a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public apc(zzvn zzvnVar) {
        this.f2025a = zzvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void zzp(boolean z) {
        if (!z) {
            this.f2025a.b();
        } else {
            this.f2025a.a();
        }
    }
}
