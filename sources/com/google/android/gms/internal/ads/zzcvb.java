package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcvb<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Set<zzcva<? extends zzcuz<T>>> f3454a;
    private final Executor b;

    public zzcvb(Executor executor, Set<zzcva<? extends zzcuz<T>>> set) {
        this.b = executor;
        this.f3454a = set;
    }

    public final zzbbh<T> zzu(final T t) {
        final ArrayList arrayList = new ArrayList(this.f3454a.size());
        for (final zzcva<? extends zzcuz<T>> zzcvaVar : this.f3454a) {
            zzbbh<? extends zzcuz<T>> zzalm = zzcvaVar.zzalm();
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqg)).booleanValue()) {
                final long elapsedRealtime = zzk.zzln().elapsedRealtime();
                zzalm.zza(new Runnable(zzcvaVar, elapsedRealtime) { // from class: com.google.android.gms.internal.ads.zj

                    /* renamed from: a, reason: collision with root package name */
                    private final zzcva f2663a;
                    private final long b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2663a = zzcvaVar;
                        this.b = elapsedRealtime;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcva zzcvaVar2 = this.f2663a;
                        long j = this.b;
                        String canonicalName = zzcvaVar2.getClass().getCanonicalName();
                        long elapsedRealtime2 = zzk.zzln().elapsedRealtime() - j;
                        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
                        sb.append("Signal runtime : ");
                        sb.append(canonicalName);
                        sb.append(" = ");
                        sb.append(elapsedRealtime2);
                        zzawz.zzds(sb.toString());
                    }
                }, zzbbm.zzeaf);
            }
            arrayList.add(zzalm);
        }
        return zzbar.zzf(arrayList).zza(new Callable(arrayList, t) { // from class: com.google.android.gms.internal.ads.zk

            /* renamed from: a, reason: collision with root package name */
            private final List f2664a;
            private final Object b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2664a = arrayList;
                this.b = t;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzcvb.a(this.f2664a, this.b);
            }
        }, this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Object a(List list, Object obj) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                zzcuz zzcuzVar = (zzcuz) ((zzbbh) it.next()).get();
                if (zzcuzVar != null) {
                    zzcuzVar.zzt(obj);
                }
            } catch (InterruptedException | ExecutionException e) {
                zzawz.zzc("Derive quality signals error.", e);
                throw new Exception(e);
            }
        }
        return obj;
    }
}
