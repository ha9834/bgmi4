package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzaza extends zzr<zzp> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbr<zzp> f2834a;
    private final Map<String, String> b;
    private final zzazx c;

    public zzaza(String str, zzbbr<zzp> zzbbrVar) {
        this(str, null, zzbbrVar);
    }

    private zzaza(String str, Map<String, String> map, zzbbr<zzp> zzbbrVar) {
        super(0, str, new gj(zzbbrVar));
        this.b = null;
        this.f2834a = zzbbrVar;
        this.c = new zzazx();
        this.c.zza(str, "GET", null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzr
    public final zzy<zzp> a(zzp zzpVar) {
        return zzy.zza(zzpVar, zzaq.zzb(zzpVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzr
    public final /* synthetic */ void a(zzp zzpVar) {
        zzp zzpVar2 = zzpVar;
        this.c.zza(zzpVar2.zzab, zzpVar2.statusCode);
        zzazx zzazxVar = this.c;
        byte[] bArr = zzpVar2.data;
        if (zzazx.isEnabled() && bArr != null) {
            zzazxVar.zzj(bArr);
        }
        this.f2834a.set(zzpVar2);
    }
}
