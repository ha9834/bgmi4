package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzbfq extends zzawv {

    /* renamed from: a, reason: collision with root package name */
    final zzbdf f2868a;
    final zzbft b;
    private final String c;
    private final String[] d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfq(zzbdf zzbdfVar, zzbft zzbftVar, String str, String[] strArr) {
        this.f2868a = zzbdfVar;
        this.b = zzbftVar;
        this.c = str;
        this.d = strArr;
        zzk.zzmc().zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        try {
            this.b.zze(this.c, this.d);
        } finally {
            zzaxi.zzdvv.post(new kh(this));
        }
    }
}
