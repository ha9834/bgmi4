package com.google.android.gms.tagmanager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a implements zzw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzy f5067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzy zzyVar) {
        this.f5067a = zzyVar;
    }

    @Override // com.google.android.gms.tagmanager.zzw
    public final void zzhe() {
        zzdi.zzac("Refresh ignored: container loaded as default only.");
    }

    @Override // com.google.android.gms.tagmanager.zzw
    public final void zzao(String str) {
        this.f5067a.a(str);
    }

    @Override // com.google.android.gms.tagmanager.zzw
    public final String zzhc() {
        return this.f5067a.a();
    }
}
