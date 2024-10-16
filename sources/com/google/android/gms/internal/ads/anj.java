package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes2.dex */
final class anj implements zzsh {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f1985a;
    private final zzrv b;
    private final ank c;
    private final zzsm d;
    private volatile boolean f;
    private long h;
    private final /* synthetic */ ane j;
    private final zznt e = new zznt();
    private boolean g = true;
    private long i = -1;

    public anj(ane aneVar, Uri uri, zzrv zzrvVar, ank ankVar, zzsm zzsmVar) {
        this.j = aneVar;
        this.f1985a = (Uri) zzsk.checkNotNull(uri);
        this.b = (zzrv) zzsk.checkNotNull(zzrvVar);
        this.c = (ank) zzsk.checkNotNull(ankVar);
        this.d = zzsmVar;
    }

    public final void a(long j, long j2) {
        this.e.zzahv = j;
        this.h = j2;
        this.g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void zzfp() {
        this.f = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final boolean zzfq() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void zzfr() throws IOException, InterruptedException {
        zznm zznmVar;
        int i = 0;
        while (i == 0 && !this.f) {
            try {
                long j = this.e.zzahv;
                this.i = this.b.zza(new zzry(this.f1985a, j, -1L, ane.f(this.j)));
                if (this.i != -1) {
                    this.i += j;
                }
                zznmVar = new zznm(this.b, j, this.i);
                try {
                    zznn a2 = this.c.a(zznmVar, this.b.getUri());
                    if (this.g) {
                        a2.zzd(j, this.h);
                        this.g = false;
                    }
                    while (i == 0 && !this.f) {
                        this.d.block();
                        i = a2.zza(zznmVar, this.e);
                        if (zznmVar.getPosition() > ane.g(this.j) + j) {
                            j = zznmVar.getPosition();
                            this.d.zzjy();
                            ane.i(this.j).post(ane.h(this.j));
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.e.zzahv = zznmVar.getPosition();
                    }
                    zzsy.zza(this.b);
                } catch (Throwable th) {
                    th = th;
                    if (i != 1 && zznmVar != null) {
                        this.e.zzahv = zznmVar.getPosition();
                    }
                    zzsy.zza(this.b);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zznmVar = null;
            }
        }
    }
}
