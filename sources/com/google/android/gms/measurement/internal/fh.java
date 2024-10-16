package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4855a;
    private final /* synthetic */ zzhr b;
    private final /* synthetic */ zzhr c;
    private final /* synthetic */ zzhq d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(zzhq zzhqVar, boolean z, zzhr zzhrVar, zzhr zzhrVar2) {
        this.d = zzhqVar;
        this.f4855a = z;
        this.b = zzhrVar;
        this.c = zzhrVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        if (this.d.zzad().o(this.d.zzr().c())) {
            z = this.f4855a && this.d.f4946a != null;
            if (z) {
                zzhq zzhqVar = this.d;
                zzhqVar.a(zzhqVar.f4946a, true);
            }
        } else {
            if (this.f4855a && this.d.f4946a != null) {
                zzhq zzhqVar2 = this.d;
                zzhqVar2.a(zzhqVar2.f4946a, true);
            }
            z = false;
        }
        zzhr zzhrVar = this.b;
        if ((zzhrVar != null && zzhrVar.zzqw == this.c.zzqw && zzjs.d(this.b.zzqv, this.c.zzqv) && zzjs.d(this.b.zzqu, this.c.zzqu)) ? false : true) {
            Bundle bundle = new Bundle();
            zzhq.zza(this.c, bundle, true);
            zzhr zzhrVar2 = this.b;
            if (zzhrVar2 != null) {
                if (zzhrVar2.zzqu != null) {
                    bundle.putString("_pn", this.b.zzqu);
                }
                bundle.putString("_pc", this.b.zzqv);
                bundle.putLong("_pi", this.b.zzqw);
            }
            if (this.d.zzad().o(this.d.zzr().c()) && z) {
                long e = this.d.zzv().e();
                if (e > 0) {
                    this.d.zzz().a(bundle, e);
                }
            }
            this.d.zzq().a("auto", "_vs", bundle);
        }
        zzhq zzhqVar3 = this.d;
        zzhqVar3.f4946a = this.c;
        zzhqVar3.zzs().a(this.c);
    }
}
