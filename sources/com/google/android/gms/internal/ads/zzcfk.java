package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcfk implements zzczz {
    private final zzcfi b;
    private final Clock c;

    /* renamed from: a, reason: collision with root package name */
    private final Map<zzczs, Long> f3231a = new HashMap();
    private final Map<zzczs, sr> d = new HashMap();

    public zzcfk(zzcfi zzcfiVar, Set<sr> set, Clock clock) {
        zzczs zzczsVar;
        this.b = zzcfiVar;
        for (sr srVar : set) {
            Map<zzczs, sr> map = this.d;
            zzczsVar = srVar.c;
            map.put(zzczsVar, srVar);
        }
        this.c = clock;
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zza(zzczs zzczsVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zzb(zzczs zzczsVar, String str) {
        this.f3231a.put(zzczsVar, Long.valueOf(this.c.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zza(zzczs zzczsVar, String str, Throwable th) {
        if (this.f3231a.containsKey(zzczsVar)) {
            long elapsedRealtime = this.c.elapsedRealtime() - this.f3231a.get(zzczsVar).longValue();
            Map<String, String> zzqy = this.b.zzqy();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqy.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.d.containsKey(zzczsVar)) {
            a(zzczsVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zzc(zzczs zzczsVar, String str) {
        if (this.f3231a.containsKey(zzczsVar)) {
            long elapsedRealtime = this.c.elapsedRealtime() - this.f3231a.get(zzczsVar).longValue();
            Map<String, String> zzqy = this.b.zzqy();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqy.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.d.containsKey(zzczsVar)) {
            a(zzczsVar, true);
        }
    }

    private final void a(zzczs zzczsVar, boolean z) {
        zzczs zzczsVar2;
        String str;
        zzczsVar2 = this.d.get(zzczsVar).b;
        String str2 = z ? "s." : "f.";
        if (this.f3231a.containsKey(zzczsVar2)) {
            long elapsedRealtime = this.c.elapsedRealtime() - this.f3231a.get(zzczsVar2).longValue();
            Map<String, String> zzqy = this.b.zzqy();
            str = this.d.get(zzczsVar).f2498a;
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(str2);
            String valueOf3 = String.valueOf(Long.toString(elapsedRealtime));
            zzqy.put(concat, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
        }
    }
}
