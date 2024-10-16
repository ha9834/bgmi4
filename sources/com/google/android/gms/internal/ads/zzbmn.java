package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.helpshift.analytics.AnalyticsEventKey;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbmn implements com.google.android.gms.ads.internal.overlay.zzo, zzbrw, zzbrx, zzue {

    /* renamed from: a, reason: collision with root package name */
    private final zzbmg f2935a;
    private final zzbml b;
    private final zzamd<JSONObject, JSONObject> d;
    private final Executor e;
    private final Clock f;
    private final Set<zzbgz> c = new HashSet();
    private final AtomicBoolean g = new AtomicBoolean(false);

    @GuardedBy("this")
    private final zzbmp h = new zzbmp();
    private boolean i = false;
    private WeakReference<Object> j = new WeakReference<>(this);

    public zzbmn(zzaly zzalyVar, zzbml zzbmlVar, Executor executor, zzbmg zzbmgVar, Clock clock) {
        this.f2935a = zzbmgVar;
        this.d = zzalyVar.zzb("google.afma.activeView.handleUpdate", zzalo.zzddi, zzalo.zzddi);
        this.b = zzbmlVar;
        this.e = executor;
        this.f = clock;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zzafd() {
        if (!(this.j.get() != null)) {
            zzaff();
            return;
        }
        if (!this.i && this.g.get()) {
            try {
                this.h.timestamp = this.f.elapsedRealtime();
                final JSONObject zzj = this.b.zzj(this.h);
                for (final zzbgz zzbgzVar : this.c) {
                    this.e.execute(new Runnable(zzbgzVar, zzj) { // from class: com.google.android.gms.internal.ads.ne

                        /* renamed from: a, reason: collision with root package name */
                        private final zzbgz f2366a;
                        private final JSONObject b;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2366a = zzbgzVar;
                            this.b = zzj;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2366a.zzb("AFMA_updateActiveView", this.b);
                        }
                    });
                }
                zzbao.zzb(this.d.zzf(zzj), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzawz.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    private final void a() {
        Iterator<zzbgz> it = this.c.iterator();
        while (it.hasNext()) {
            this.f2935a.zze(it.next());
        }
        this.f2935a.zzafc();
    }

    public final synchronized void zzaff() {
        a();
        this.i = true;
    }

    public final synchronized void zzf(zzbgz zzbgzVar) {
        this.c.add(zzbgzVar);
        this.f2935a.zzd(zzbgzVar);
    }

    public final void zzq(Object obj) {
        this.j = new WeakReference<>(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final synchronized void zza(zzud zzudVar) {
        this.h.zzbtk = zzudVar.zzbtk;
        this.h.zzfge = zzudVar;
        zzafd();
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final synchronized void zzbp(Context context) {
        this.h.zzfgb = true;
        zzafd();
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final synchronized void zzbq(Context context) {
        this.h.zzfgb = false;
        zzafd();
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final synchronized void zzbr(Context context) {
        this.h.zzfgd = AnalyticsEventKey.URL;
        zzafd();
        a();
        this.i = true;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        this.h.zzfgb = true;
        zzafd();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        this.h.zzfgb = false;
        zzafd();
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final synchronized void onAdImpression() {
        if (this.g.compareAndSet(false, true)) {
            this.f2935a.zza(this);
            zzafd();
        }
    }
}
