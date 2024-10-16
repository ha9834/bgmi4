package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class zzv {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f3756a;
    private final Set<zzr<?>> b;
    private final PriorityBlockingQueue<zzr<?>> c;
    private final PriorityBlockingQueue<zzr<?>> d;
    private final zzb e;
    private final zzm f;
    private final zzab g;
    private final zzn[] h;
    private zzd i;
    private final List<zzx> j;
    private final List<zzw> k;

    private zzv(zzb zzbVar, zzm zzmVar, int i, zzab zzabVar) {
        this.f3756a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue<>();
        this.d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.e = zzbVar;
        this.f = zzmVar;
        this.h = new zzn[4];
        this.g = zzabVar;
    }

    private zzv(zzb zzbVar, zzm zzmVar, int i) {
        this(zzbVar, zzmVar, 4, new zzi(new Handler(Looper.getMainLooper())));
    }

    public zzv(zzb zzbVar, zzm zzmVar) {
        this(zzbVar, zzmVar, 4);
    }

    public final void start() {
        zzd zzdVar = this.i;
        if (zzdVar != null) {
            zzdVar.quit();
        }
        for (zzn zznVar : this.h) {
            if (zznVar != null) {
                zznVar.quit();
            }
        }
        this.i = new zzd(this.c, this.d, this.e, this.g);
        this.i.start();
        for (int i = 0; i < this.h.length; i++) {
            zzn zznVar2 = new zzn(this.d, this.f, this.e, this.g);
            this.h[i] = zznVar2;
            zznVar2.start();
        }
    }

    public final <T> zzr<T> zze(zzr<T> zzrVar) {
        zzrVar.zza(this);
        synchronized (this.b) {
            this.b.add(zzrVar);
        }
        zzrVar.zzb(this.f3756a.incrementAndGet());
        zzrVar.zzb("add-to-queue");
        a(zzrVar, 0);
        if (!zzrVar.zzh()) {
            this.d.add(zzrVar);
            return zzrVar;
        }
        this.c.add(zzrVar);
        return zzrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> void a(zzr<T> zzrVar) {
        synchronized (this.b) {
            this.b.remove(zzrVar);
        }
        synchronized (this.j) {
            Iterator<zzx> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().zzg(zzrVar);
            }
        }
        a(zzrVar, 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(zzr<?> zzrVar, int i) {
        synchronized (this.k) {
            Iterator<zzw> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().zzb(zzrVar, i);
            }
        }
    }
}
