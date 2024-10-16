package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class zzse {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f3730a;
    private ant<? extends zzsh> b;
    private IOException c;

    public zzse(String str) {
        this.f3730a = zzsy.zzax(str);
    }

    public final <T extends zzsh> long zza(T t, zzsf<T> zzsfVar, int i) {
        Looper myLooper = Looper.myLooper();
        zzsk.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new ant(this, myLooper, t, zzsfVar, i, elapsedRealtime).a(0L);
        return elapsedRealtime;
    }

    public final boolean isLoading() {
        return this.b != null;
    }

    public final void zzgb() {
        this.b.a(false);
    }

    public final void zza(Runnable runnable) {
        ant<? extends zzsh> antVar = this.b;
        if (antVar != null) {
            antVar.a(true);
        }
        this.f3730a.execute(runnable);
        this.f3730a.shutdown();
    }

    public final void zzbm(int i) throws IOException {
        IOException iOException = this.c;
        if (iOException != null) {
            throw iOException;
        }
        ant<? extends zzsh> antVar = this.b;
        if (antVar != null) {
            antVar.a(antVar.f1993a);
        }
    }
}
