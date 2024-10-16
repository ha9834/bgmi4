package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzsh;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes2.dex */
public final class ant<T extends zzsh> extends Handler implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final int f1993a;
    private final T b;
    private final zzsf<T> c;
    private final long d;
    private IOException e;
    private int f;
    private volatile Thread g;
    private volatile boolean h;
    private final /* synthetic */ zzse i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ant(zzse zzseVar, Looper looper, T t, zzsf<T> zzsfVar, int i, long j) {
        super(looper);
        this.i = zzseVar;
        this.b = t;
        this.c = zzsfVar;
        this.f1993a = i;
        this.d = j;
    }

    public final void a(int i) throws IOException {
        IOException iOException = this.e;
        if (iOException != null && this.f > i) {
            throw iOException;
        }
    }

    public final void a(long j) {
        ant antVar;
        antVar = this.i.b;
        zzsk.checkState(antVar == null);
        this.i.b = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            a();
        }
    }

    public final void a(boolean z) {
        this.h = z;
        this.e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.b.zzfp();
            if (this.g != null) {
                this.g.interrupt();
            }
        }
        if (z) {
            b();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.c.zza((zzsf<T>) this.b, elapsedRealtime, elapsedRealtime - this.d, true);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.g = Thread.currentThread();
            if (!this.b.zzfq()) {
                String valueOf = String.valueOf(this.b.getClass().getSimpleName());
                zzsx.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                try {
                    this.b.zzfr();
                    zzsx.endSection();
                } catch (Throwable th) {
                    zzsx.endSection();
                    throw th;
                }
            }
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.h) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (Error e2) {
            Log.e("LoadTask", "Unexpected error loading stream", e2);
            if (!this.h) {
                obtainMessage(4, e2).sendToTarget();
            }
            throw e2;
        } catch (InterruptedException unused) {
            zzsk.checkState(this.b.zzfq());
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (Exception e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            if (this.h) {
                return;
            }
            obtainMessage(3, new zzsi(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e4);
            if (this.h) {
                return;
            }
            obtainMessage(3, new zzsi(e4)).sendToTarget();
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.h) {
            return;
        }
        if (message.what == 0) {
            a();
            return;
        }
        if (message.what == 4) {
            throw ((Error) message.obj);
        }
        b();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.d;
        if (this.b.zzfq()) {
            this.c.zza((zzsf<T>) this.b, elapsedRealtime, j, false);
            return;
        }
        switch (message.what) {
            case 1:
                this.c.zza((zzsf<T>) this.b, elapsedRealtime, j, false);
                return;
            case 2:
                this.c.zza(this.b, elapsedRealtime, j);
                return;
            case 3:
                this.e = (IOException) message.obj;
                int zza = this.c.zza((zzsf<T>) this.b, elapsedRealtime, j, this.e);
                if (zza == 3) {
                    this.i.c = this.e;
                    return;
                } else {
                    if (zza != 2) {
                        this.f = zza == 1 ? 1 : this.f + 1;
                        a(Math.min((this.f - 1) * 1000, 5000));
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    private final void a() {
        ExecutorService executorService;
        ant antVar;
        this.e = null;
        executorService = this.i.f3730a;
        antVar = this.i.b;
        executorService.execute(antVar);
    }

    private final void b() {
        this.i.b = null;
    }
}
