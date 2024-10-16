package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public class zzbts<ListenerT> {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private final Map<ListenerT, Executor> f3043a = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbts(Set<zzbuz<ListenerT>> set) {
        a(set);
    }

    public final synchronized void zza(zzbuz<ListenerT> zzbuzVar) {
        zza(zzbuzVar.zzflc, zzbuzVar.zzffi);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.f3043a.put(listenert, executor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void a(Set<zzbuz<ListenerT>> set) {
        Iterator<zzbuz<ListenerT>> it = set.iterator();
        while (it.hasNext()) {
            zza(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a(final zzbtu<ListenerT> zzbtuVar) {
        for (Map.Entry<ListenerT, Executor> entry : this.f3043a.entrySet()) {
            final ListenerT key = entry.getKey();
            entry.getValue().execute(new Runnable(zzbtuVar, key) { // from class: com.google.android.gms.internal.ads.pc

                /* renamed from: a, reason: collision with root package name */
                private final zzbtu f2410a;
                private final Object b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2410a = zzbtuVar;
                    this.b = key;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.f2410a.zzr(this.b);
                    } catch (Throwable th) {
                        zzk.zzlk().zzb(th, "EventEmitter.notify");
                        zzawz.zza("Event emitter exception.", th);
                    }
                }
            });
        }
    }
}
