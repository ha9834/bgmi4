package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzccj {
    private final com.google.android.gms.ads.internal.zza b;
    private final zzbhf c;
    private final Context d;
    private final Executor e;
    private final zzdh f;
    private final zzbai g;
    private zzbbh<zzbgz> i;

    /* renamed from: a, reason: collision with root package name */
    private final ry f3181a = new ry(null);
    private final zzahu h = new zzahu();

    public zzccj(Context context, Executor executor, zzdh zzdhVar, zzbai zzbaiVar, com.google.android.gms.ads.internal.zza zzaVar, zzbhf zzbhfVar) {
        this.d = context;
        this.e = executor;
        this.f = zzdhVar;
        this.g = zzbaiVar;
        this.b = zzaVar;
        this.c = zzbhfVar;
    }

    public final synchronized void zzajj() {
        this.i = zzbar.zza(zzbhf.zza(this.d, this.g, (String) zzyt.zzpe().zzd(zzacu.zzcsa), this.f, this.b), new zzbam(this) { // from class: com.google.android.gms.internal.ads.rs

            /* renamed from: a, reason: collision with root package name */
            private final zzccj f2474a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2474a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj) {
                return this.f2474a.a((zzbgz) obj);
            }
        }, this.e);
        zzbao.zza(this.i, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void destroy() {
        if (this.i == null) {
            return;
        }
        zzbar.zza(this.i, new ru(this), this.e);
        this.i = null;
    }

    public final synchronized zzbbh<JSONObject> zzc(final String str, final JSONObject jSONObject) {
        if (this.i == null) {
            return zzbar.zzm(null);
        }
        return zzbar.zza(this.i, new zzbal(this, str, jSONObject) { // from class: com.google.android.gms.internal.ads.rt

            /* renamed from: a, reason: collision with root package name */
            private final zzccj f2475a;
            private final String b;
            private final JSONObject c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2475a = this;
                this.b = str;
                this.c = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2475a.a(this.b, this.c, (zzbgz) obj);
            }
        }, this.e);
    }

    public final synchronized void zza(String str, zzaho<Object> zzahoVar) {
        if (this.i == null) {
            return;
        }
        zzbar.zza(this.i, new rv(this, str, zzahoVar), this.e);
    }

    public final synchronized void zzb(String str, zzaho<Object> zzahoVar) {
        if (this.i == null) {
            return;
        }
        zzbar.zza(this.i, new rw(this, str, zzahoVar), this.e);
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.i == null) {
            return;
        }
        zzbar.zza(this.i, new rx(this, str, map), this.e);
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzaho<T> zzahoVar) {
        zza(str, new sa(this, weakReference, str, zzahoVar, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(String str, JSONObject jSONObject, zzbgz zzbgzVar) throws Exception {
        return this.h.zza(zzbgzVar, str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbgz a(zzbgz zzbgzVar) {
        zzbgzVar.zza("/result", this.h);
        zzbii zzaai = zzbgzVar.zzaai();
        ry ryVar = this.f3181a;
        zzaai.zza(null, ryVar, ryVar, ryVar, ryVar, false, null, new com.google.android.gms.ads.internal.zzb(this.d, null, null), null, null);
        return zzbgzVar;
    }
}
