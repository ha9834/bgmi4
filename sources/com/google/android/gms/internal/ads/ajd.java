package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ajd implements zzge {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f1908a;
    private final ajf b;
    private final CopyOnWriteArraySet<zzgh> c;
    private final boolean[] d;
    private boolean e;
    private int f;
    private int g;

    @SuppressLint({"HandlerLeak"})
    public ajd(int i, int i2, int i3) {
        Log.i("ExoPlayerImpl", "Init 1.3.1");
        int i4 = 0;
        this.e = false;
        this.f = 1;
        this.c = new CopyOnWriteArraySet<>();
        this.d = new boolean[2];
        while (true) {
            boolean[] zArr = this.d;
            if (i4 < zArr.length) {
                zArr[i4] = true;
                i4++;
            } else {
                this.f1908a = new aje(this);
                this.b = new ajf(this.f1908a, this.e, this.d, 2500, 5000);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zza(zzgh zzghVar) {
        this.c.add(zzghVar);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final int getPlaybackState() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zza(zzhp... zzhpVarArr) {
        this.b.a(zzhpVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzc(int i, boolean z) {
        boolean[] zArr = this.d;
        if (zArr[0] != z) {
            zArr[0] = z;
            this.b.a(0, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd(boolean z) {
        if (this.e != z) {
            this.e = z;
            this.g++;
            this.b.a(z);
            Iterator<zzgh> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.f);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final boolean zzdm() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void seekTo(long j) {
        this.b.a(j);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void stop() {
        this.b.d();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void release() {
        this.b.e();
        this.f1908a.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zza(zzgf zzgfVar, int i, Object obj) {
        this.b.a(zzgfVar, 1, obj);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzb(zzgf zzgfVar, int i, Object obj) {
        this.b.b(zzgfVar, 1, obj);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long getDuration() {
        return this.b.c();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzdn() {
        return this.b.a();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long getBufferedPosition() {
        return this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Message message) {
        switch (message.what) {
            case 1:
                this.f = message.arg1;
                Iterator<zzgh> it = this.c.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.e, this.f);
                }
                return;
            case 2:
                this.g--;
                if (this.g == 0) {
                    Iterator<zzgh> it2 = this.c.iterator();
                    while (it2.hasNext()) {
                        it2.next().zzdo();
                    }
                    return;
                }
                return;
            case 3:
                zzgd zzgdVar = (zzgd) message.obj;
                Iterator<zzgh> it3 = this.c.iterator();
                while (it3.hasNext()) {
                    it3.next().zza(zzgdVar);
                }
                return;
            default:
                return;
        }
    }
}
