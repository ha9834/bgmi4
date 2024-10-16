package com.google.android.gms.nearby.messages.internal;

/* loaded from: classes2.dex */
final class k extends s {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.google.android.gms.common.api.internal.zzci f5011a;
    private /* synthetic */ zzak b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(zzak zzakVar, com.google.android.gms.common.api.internal.zzci zzciVar, com.google.android.gms.common.api.internal.zzci zzciVar2) {
        super(zzciVar);
        this.b = zzakVar;
        this.f5011a = zzciVar2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.s, com.google.android.gms.nearby.messages.internal.zzu
    public final void onExpired() {
        this.b.zza(this.f5011a.zzakx());
        super.onExpired();
    }
}
