package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ks implements zzbdo {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbgl f2300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ks(zzbgl zzbglVar) {
        this.f2300a = zzbglVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdo
    public final void zzl(String str, String str2) {
        zzbgl zzbglVar = this.f2300a;
        String valueOf = String.valueOf(str);
        zzbglVar.f = valueOf.length() != 0 ? "ExoPlayer caching failed. Type: ".concat(valueOf) : new String("ExoPlayer caching failed. Type: ");
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(str2).length());
        sb.append("ExoPlayer failed during precache: ");
        sb.append(str);
        sb.append(" Exception: ");
        sb.append(str2);
        zzawz.zzep(sb.toString());
        this.f2300a.abort();
    }
}
