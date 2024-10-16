package com.google.android.gms.nearby.messages.internal;

/* loaded from: classes2.dex */
final class l extends u {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.google.android.gms.common.api.internal.zzci f5012a;
    private /* synthetic */ zzak b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(zzak zzakVar, com.google.android.gms.common.api.internal.zzci zzciVar, com.google.android.gms.common.api.internal.zzci zzciVar2) {
        super(zzciVar);
        this.b = zzakVar;
        this.f5012a = zzciVar2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.u, com.google.android.gms.nearby.messages.internal.zzaa
    public final void onExpired() {
        this.b.zza(this.f5012a.zzakx());
        super.onExpired();
    }
}
