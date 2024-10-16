package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gf implements zzz {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2190a;
    private final /* synthetic */ gh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gf(zzayu zzayuVar, String str, gh ghVar) {
        this.f2190a = str;
        this.b = ghVar;
    }

    @Override // com.google.android.gms.internal.ads.zzz
    public final void zzd(zzaf zzafVar) {
        String str = this.f2190a;
        String zzafVar2 = zzafVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzafVar2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(zzafVar2);
        zzawz.zzep(sb.toString());
        this.b.zzb(null);
    }
}
