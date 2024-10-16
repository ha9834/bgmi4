package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcgb {
    private final Context e;
    private final zzclc f;
    private final Executor g;
    private final Executor h;
    private final ScheduledExecutorService i;

    /* renamed from: a, reason: collision with root package name */
    private boolean f3246a = false;
    private boolean b = false;
    private final zzbbr<Boolean> d = new zzbbr<>();
    private Map<String, zzaio> j = new ConcurrentHashMap();
    private final long c = zzk.zzln().elapsedRealtime();

    public zzcgb(Executor executor, Context context, Executor executor2, zzclc zzclcVar, ScheduledExecutorService scheduledExecutorService) {
        this.f = zzclcVar;
        this.e = context;
        this.g = executor2;
        this.i = scheduledExecutorService;
        this.h = executor;
        a("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public final void zzb(final zzait zzaitVar) {
        this.d.zza(new Runnable(this, zzaitVar) { // from class: com.google.android.gms.internal.ads.ss

            /* renamed from: a, reason: collision with root package name */
            private final zzcgb f2499a;
            private final zzait b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2499a = this;
                this.b = zzaitVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2499a.a(this.b);
            }
        }, this.h);
    }

    /* renamed from: zzajx, reason: merged with bridge method [inline-methods] */
    public final void d() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqy)).booleanValue() && !this.f3246a) {
            synchronized (this) {
                if (this.f3246a) {
                    return;
                }
                final String zzus = zzk.zzlk().zzvc().zzvr().zzus();
                if (TextUtils.isEmpty(zzus)) {
                    e();
                    return;
                }
                this.f3246a = true;
                a("com.google.android.gms.ads.MobileAds", true, "", (int) (zzk.zzln().elapsedRealtime() - this.c));
                this.g.execute(new Runnable(this, zzus) { // from class: com.google.android.gms.internal.ads.st

                    /* renamed from: a, reason: collision with root package name */
                    private final zzcgb f2500a;
                    private final String b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2500a = this;
                        this.b = zzus;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2500a.a(this.b);
                    }
                });
            }
        }
    }

    public final List<zzaio> zzajy() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.j.keySet()) {
            zzaio zzaioVar = this.j.get(str);
            arrayList.add(new zzaio(str, zzaioVar.zzdbb, zzaioVar.zzdbc, zzaioVar.description));
        }
        return arrayList;
    }

    private final synchronized void e() {
        if (!this.b) {
            zzk.zzlk().zzvc().zzb(new Runnable(this) { // from class: com.google.android.gms.internal.ads.su

                /* renamed from: a, reason: collision with root package name */
                private final zzcgb f2501a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2501a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2501a.c();
                }
            });
            this.b = true;
            this.i.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.sv

                /* renamed from: a, reason: collision with root package name */
                private final zzcgb f2502a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2502a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2502a.b();
                }
            }, ((Long) zzyt.zzpe().zzd(zzacu.zzcra)).longValue(), TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, boolean z, String str2, int i) {
        this.j.put(str, new zzaio(str, z, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzams zzamsVar, zzaiq zzaiqVar, List list) {
        try {
            try {
                zzamsVar.zza(ObjectWrapper.wrap(this.e), zzaiqVar, (List<zzaiw>) list);
            } catch (RemoteException e) {
                zzbad.zzc("", e);
            }
        } catch (RemoteException unused) {
            zzaiqVar.onInitializationFailed("Failed to create Adapter.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object a() throws Exception {
        this.d.set(true);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, zzbbr zzbbrVar, String str, long j) {
        synchronized (obj) {
            if (!zzbbrVar.isDone()) {
                a(str, false, "timeout", (int) (zzk.zzln().elapsedRealtime() - j));
                zzbbrVar.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        synchronized (this) {
            if (this.f3246a) {
                return;
            }
            a("com.google.android.gms.ads.MobileAds", false, "timeout", (int) (zzk.zzln().elapsedRealtime() - this.c));
            this.d.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.g.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.sz

            /* renamed from: a, reason: collision with root package name */
            private final zzcgb f2506a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2506a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2506a.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject(ConfigDBHelper.TABLE_NAME_CONFIG);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                final String next = keys.next();
                final Object obj = new Object();
                final zzbbr zzbbrVar = new zzbbr();
                zzbbh zza = zzbar.zza(zzbbrVar, ((Long) zzyt.zzpe().zzd(zzacu.zzcqz)).longValue(), TimeUnit.SECONDS, this.i);
                final long elapsedRealtime = zzk.zzln().elapsedRealtime();
                Iterator<String> it = keys;
                zza.zza(new Runnable(this, obj, zzbbrVar, next, elapsedRealtime) { // from class: com.google.android.gms.internal.ads.sw

                    /* renamed from: a, reason: collision with root package name */
                    private final zzcgb f2503a;
                    private final Object b;
                    private final zzbbr c;
                    private final String d;
                    private final long e;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2503a = this;
                        this.b = obj;
                        this.c = zzbbrVar;
                        this.d = next;
                        this.e = elapsedRealtime;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2503a.a(this.b, this.c, this.d, this.e);
                    }
                }, this.g);
                arrayList.add(zza);
                final ta taVar = new ta(this, obj, next, elapsedRealtime, zzbbrVar);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzaiw(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                a(next, false, "", 0);
                try {
                    try {
                        final zzams zze = this.f.zze(next, new JSONObject());
                        this.h.execute(new Runnable(this, zze, taVar, arrayList2) { // from class: com.google.android.gms.internal.ads.sy

                            /* renamed from: a, reason: collision with root package name */
                            private final zzcgb f2505a;
                            private final zzams b;
                            private final zzaiq c;
                            private final List d;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f2505a = this;
                                this.b = zze;
                                this.c = taVar;
                                this.d = arrayList2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f2505a.a(this.b, this.c, this.d);
                            }
                        });
                        keys = it;
                    } catch (RemoteException unused2) {
                        taVar.onInitializationFailed("Failed to create Adapter.");
                        keys = it;
                    }
                } catch (RemoteException e) {
                    zzbad.zzc("", e);
                    keys = it;
                }
            }
            zzbar.zzf(arrayList).zza(new Callable(this) { // from class: com.google.android.gms.internal.ads.sx

                /* renamed from: a, reason: collision with root package name */
                private final zzcgb f2504a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2504a = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f2504a.a();
                }
            }, this.g);
        } catch (JSONException e2) {
            zzawz.zza("Malformed CLD response", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzait zzaitVar) {
        try {
            zzaitVar.zzc(zzajy());
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
