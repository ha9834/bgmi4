package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes2.dex */
public final class aks extends Handler implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final zzkc f1939a;
    private final zzka b;
    private final int c;
    private volatile Thread d;
    private final /* synthetic */ zzjz e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aks(zzjz zzjzVar, Looper looper, zzkc zzkcVar, zzka zzkaVar, int i) {
        super(looper);
        this.e = zzjzVar;
        this.f1939a = zzkcVar;
        this.b = zzkaVar;
        this.c = 0;
    }

    public final void a() {
        this.f1939a.zzfp();
        if (this.d != null) {
            this.d.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.d = Thread.currentThread();
            if (this.c > 0) {
                Thread.sleep(this.c);
            }
            if (!this.f1939a.zzfq()) {
                this.f1939a.zzfr();
            }
            sendEmptyMessage(0);
        } catch (IOException e) {
            obtainMessage(1, e).sendToTarget();
        } catch (Error e2) {
            Log.e("LoadTask", "Unexpected error loading stream", e2);
            obtainMessage(2, e2).sendToTarget();
            throw e2;
        } catch (InterruptedException unused) {
            zzkh.checkState(this.f1939a.zzfq());
            sendEmptyMessage(0);
        } catch (Exception e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            obtainMessage(1, new zzkd(e3)).sendToTarget();
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            throw ((Error) message.obj);
        }
        zzjz.a(this.e, false);
        zzjz.a(this.e, (aks) null);
        if (this.f1939a.zzfq()) {
            this.b.zzb(this.f1939a);
            return;
        }
        switch (message.what) {
            case 0:
                this.b.zza(this.f1939a);
                return;
            case 1:
                this.b.zza(this.f1939a, (IOException) message.obj);
                return;
            default:
                return;
        }
    }
}
