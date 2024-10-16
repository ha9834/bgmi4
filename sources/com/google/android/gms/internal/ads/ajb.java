package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class ajb implements anv {

    /* renamed from: a */
    private final Map<String, List<zzr<?>>> f1906a = new HashMap();
    private final zzd b;

    public ajb(zzd zzdVar) {
        this.b = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.anv
    public final void a(zzr<?> zzrVar, zzy<?> zzyVar) {
        List<zzr<?>> remove;
        zzab zzabVar;
        if (zzyVar.zzbh == null || zzyVar.zzbh.isExpired()) {
            a(zzrVar);
            return;
        }
        String zze = zzrVar.zze();
        synchronized (this) {
            remove = this.f1906a.remove(zze);
        }
        if (remove != null) {
            if (zzag.DEBUG) {
                zzag.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zze);
            }
            for (zzr<?> zzrVar2 : remove) {
                zzabVar = this.b.e;
                zzabVar.zzb(zzrVar2, zzyVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.anv
    public final synchronized void a(zzr<?> zzrVar) {
        BlockingQueue blockingQueue;
        String zze = zzrVar.zze();
        List<zzr<?>> remove = this.f1906a.remove(zze);
        if (remove != null && !remove.isEmpty()) {
            if (zzag.DEBUG) {
                zzag.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), zze);
            }
            zzr<?> remove2 = remove.remove(0);
            this.f1906a.put(zze, remove);
            remove2.a((anv) this);
            try {
                blockingQueue = this.b.c;
                blockingQueue.put(remove2);
            } catch (InterruptedException e) {
                zzag.e("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.b.quit();
            }
        }
    }

    public final synchronized boolean b(zzr<?> zzrVar) {
        String zze = zzrVar.zze();
        if (this.f1906a.containsKey(zze)) {
            List<zzr<?>> list = this.f1906a.get(zze);
            if (list == null) {
                list = new ArrayList<>();
            }
            zzrVar.zzb("waiting-for-response");
            list.add(zzrVar);
            this.f1906a.put(zze, list);
            if (zzag.DEBUG) {
                zzag.d("Request for cacheKey=%s is in flight, putting on hold.", zze);
            }
            return true;
        }
        this.f1906a.put(zze, null);
        zzrVar.a((anv) this);
        if (zzag.DEBUG) {
            zzag.d("new request, sending to network %s", zze);
        }
        return false;
    }
}
