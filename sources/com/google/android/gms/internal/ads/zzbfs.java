package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzbfs implements Iterable<zzbfq> {

    /* renamed from: a, reason: collision with root package name */
    private final List<zzbfq> f2869a = new ArrayList();

    public static boolean zzc(zzbdf zzbdfVar) {
        zzbfq a2 = a(zzbdfVar);
        if (a2 == null) {
            return false;
        }
        a2.b.abort();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbfq a(zzbdf zzbdfVar) {
        Iterator<zzbfq> it = zzk.zzmc().iterator();
        while (it.hasNext()) {
            zzbfq next = it.next();
            if (next.f2868a == zzbdfVar) {
                return next;
            }
        }
        return null;
    }

    public final void zza(zzbfq zzbfqVar) {
        this.f2869a.add(zzbfqVar);
    }

    public final void zzb(zzbfq zzbfqVar) {
        this.f2869a.remove(zzbfqVar);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzbfq> iterator() {
        return this.f2869a.iterator();
    }
}
