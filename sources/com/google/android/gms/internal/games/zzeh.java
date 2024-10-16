package com.google.android.gms.internal.games;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class zzeh {
    private Handler b;
    private boolean c;

    /* renamed from: a, reason: collision with root package name */
    private final Object f4285a = new Object();
    private HashMap<String, AtomicInteger> d = new HashMap<>();
    private int e = 1000;

    public zzeh(Looper looper, int i) {
        this.b = new zzen(looper);
    }

    protected abstract void a(String str, int i);

    public final void zzg(String str, int i) {
        synchronized (this.f4285a) {
            if (!this.c) {
                this.c = true;
                this.b.postDelayed(new cr(this), this.e);
            }
            AtomicInteger atomicInteger = this.d.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.d.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void flush() {
        synchronized (this.f4285a) {
            for (Map.Entry<String, AtomicInteger> entry : this.d.entrySet()) {
                a(entry.getKey(), entry.getValue().get());
            }
            this.d.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        synchronized (this.f4285a) {
            this.c = false;
            flush();
        }
    }
}
