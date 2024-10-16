package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzad;
import com.google.android.gms.internal.gtm.zzae;
import com.google.android.gms.internal.gtm.zzao;
import com.google.android.gms.internal.gtm.zzas;
import com.google.android.gms.internal.gtm.zzba;
import com.google.android.gms.internal.gtm.zzbu;
import com.google.android.gms.internal.gtm.zzcd;
import com.google.android.gms.internal.gtm.zzcg;
import com.google.android.gms.internal.gtm.zzci;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.internal.gtm.zzq;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Map f1200a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ String c;
    private final /* synthetic */ long d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ boolean f;
    private final /* synthetic */ String g;
    private final /* synthetic */ Tracker h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Tracker tracker, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.h = tracker;
        this.f1200a = map;
        this.b = z;
        this.c = str;
        this.d = j;
        this.e = z2;
        this.f = z3;
        this.g = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzad n;
        zzba o;
        zzbu p;
        zzbu p2;
        zzae i;
        zzae i2;
        zzci f;
        zzcg zzcgVar;
        zzci f2;
        if (this.h.e.b()) {
            this.f1200a.put("sc", "start");
        }
        Map map = this.f1200a;
        GoogleAnalytics zzcr = this.h.zzcr();
        Preconditions.checkNotMainThread("getClientId can not be called from the main thread");
        zzcz.zzc(map, "cid", zzcr.a().zzdh().zzeh());
        String str = (String) this.f1200a.get("sf");
        if (str != null) {
            double zza = zzcz.zza(str, 100.0d);
            if (zzcz.zza(zza, (String) this.f1200a.get("cid"))) {
                this.h.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza));
                return;
            }
        }
        n = this.h.n();
        if (this.b) {
            zzcz.zzb((Map<String, String>) this.f1200a, "ate", n.zzbw());
            zzcz.zzb((Map<String, String>) this.f1200a, "adid", n.zzcd());
        } else {
            this.f1200a.remove("ate");
            this.f1200a.remove("adid");
        }
        o = this.h.o();
        zzq zzdv = o.zzdv();
        zzcz.zzb((Map<String, String>) this.f1200a, "an", zzdv.zzaz());
        zzcz.zzb((Map<String, String>) this.f1200a, "av", zzdv.zzba());
        zzcz.zzb((Map<String, String>) this.f1200a, "aid", zzdv.zzbb());
        zzcz.zzb((Map<String, String>) this.f1200a, "aiid", zzdv.zzbc());
        this.f1200a.put("v", "1");
        this.f1200a.put("_v", zzao.zzwe);
        Map map2 = this.f1200a;
        p = this.h.p();
        zzcz.zzb((Map<String, String>) map2, "ul", p.zzfa().getLanguage());
        Map map3 = this.f1200a;
        p2 = this.h.p();
        zzcz.zzb((Map<String, String>) map3, "sr", p2.zzfb());
        if (!(this.c.equals("transaction") || this.c.equals("item"))) {
            zzcgVar = this.h.d;
            if (!zzcgVar.zzfm()) {
                f2 = this.h.f();
                f2.zza(this.f1200a, "Too many hits sent too quickly, rate limiting invoked");
                return;
            }
        }
        long zzag = zzcz.zzag((String) this.f1200a.get("ht"));
        long j = zzag == 0 ? this.d : zzag;
        if (this.e) {
            zzcd zzcdVar = new zzcd(this.h, this.f1200a, j, this.f);
            f = this.h.f();
            f.zzc("Dry run enabled. Would have sent hit", zzcdVar);
            return;
        }
        String str2 = (String) this.f1200a.get("cid");
        HashMap hashMap = new HashMap();
        zzcz.zza(hashMap, "uid", (Map<String, String>) this.f1200a);
        zzcz.zza(hashMap, "an", (Map<String, String>) this.f1200a);
        zzcz.zza(hashMap, "aid", (Map<String, String>) this.f1200a);
        zzcz.zza(hashMap, "av", (Map<String, String>) this.f1200a);
        zzcz.zza(hashMap, "aiid", (Map<String, String>) this.f1200a);
        zzas zzasVar = new zzas(0L, str2, this.g, !TextUtils.isEmpty((CharSequence) this.f1200a.get("adid")), 0L, hashMap);
        i = this.h.i();
        this.f1200a.put("_s", String.valueOf(i.zza(zzasVar)));
        zzcd zzcdVar2 = new zzcd(this.h, this.f1200a, j, this.f);
        i2 = this.h.i();
        i2.zza(zzcdVar2);
    }
}
