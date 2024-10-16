package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes2.dex */
final class ajw implements zzkc {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f1923a;
    private final zzjp b;
    private final zzid c;
    private final zzjr d;
    private final int e;
    private final zzij f = new zzij();
    private volatile boolean g;
    private boolean h;

    public ajw(Uri uri, zzjp zzjpVar, zzid zzidVar, zzjr zzjrVar, int i, long j) {
        this.f1923a = (Uri) zzkh.checkNotNull(uri);
        this.b = (zzjp) zzkh.checkNotNull(zzjpVar);
        this.c = (zzid) zzkh.checkNotNull(zzidVar);
        this.d = (zzjr) zzkh.checkNotNull(zzjrVar);
        this.e = i;
        this.f.zzahv = j;
        this.h = true;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void zzfp() {
        this.g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final boolean zzfq() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void zzfr() throws IOException, InterruptedException {
        if (this.h) {
            this.c.zzfh();
            this.h = false;
        }
        int i = 0;
        while (i == 0 && !this.g) {
            zzib zzibVar = null;
            try {
                long j = this.f.zzahv;
                long zza = this.b.zza(new zzjq(this.f1923a, j, -1L, null));
                zzib zzibVar2 = new zzib(this.b, j, zza != -1 ? zza + j : zza);
                while (i == 0) {
                    try {
                        if (this.g) {
                            break;
                        }
                        this.d.zzaa(this.e);
                        i = this.c.zza(zzibVar2, this.f);
                    } catch (Throwable th) {
                        th = th;
                        zzibVar = zzibVar2;
                        if (i != 1 && zzibVar != null) {
                            this.f.zzahv = zzibVar.getPosition();
                        }
                        this.b.close();
                        throw th;
                    }
                }
                if (i == 1) {
                    i = 0;
                } else {
                    this.f.zzahv = zzibVar2.getPosition();
                }
                this.b.close();
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
