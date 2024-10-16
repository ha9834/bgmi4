package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class eb implements Callable<zzase> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2140a;
    private final /* synthetic */ zzasg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(zzasg zzasgVar, Context context) {
        this.b = zzasgVar;
        this.f2140a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzase call() throws Exception {
        WeakHashMap weakHashMap;
        zzase zzty;
        WeakHashMap weakHashMap2;
        weakHashMap = this.b.f2793a;
        ec ecVar = (ec) weakHashMap.get(this.f2140a);
        if (ecVar != null) {
            if (!(ecVar.f2141a + ((Long) zzyt.zzpe().zzd(zzacu.zzcqm)).longValue() < zzk.zzln().currentTimeMillis())) {
                zzty = new zzasf(this.f2140a, ecVar.b).zzty();
                weakHashMap2 = this.b.f2793a;
                weakHashMap2.put(this.f2140a, new ec(this.b, zzty));
                return zzty;
            }
        }
        zzty = new zzasf(this.f2140a).zzty();
        weakHashMap2 = this.b.f2793a;
        weakHashMap2.put(this.f2140a, new ec(this.b, zzty));
        return zzty;
    }
}
