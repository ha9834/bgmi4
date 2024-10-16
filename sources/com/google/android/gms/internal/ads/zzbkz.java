package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbkz extends zzaac {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2903a;
    private final zzbai b;
    private final zzclc c;
    private final zzcjz<zzams, zzclb> d;
    private final zzcpf e;
    private final zzcgb f;

    @GuardedBy("this")
    private boolean g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkz(Context context, zzbai zzbaiVar, zzclc zzclcVar, zzcjz<zzams, zzclb> zzcjzVar, zzcpf zzcpfVar, zzcgb zzcgbVar) {
        this.f2903a = context;
        this.b = zzbaiVar;
        this.c = zzclcVar;
        this.d = zzcjzVar;
        this.e = zzcpfVar;
        this.f = zzcgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized void zza() {
        if (this.g) {
            zzawz.zzep("Mobile ads is initialized already.");
            return;
        }
        zzacu.initialize(this.f2903a);
        zzk.zzlk().zzd(this.f2903a, this.b);
        zzk.zzlm().initialize(this.f2903a);
        this.g = true;
        this.f.d();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqu)).booleanValue()) {
            this.e.zzakw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized void setAppVolume(float f) {
        zzk.zzll().setAppVolume(f);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized float zzpq() {
        return zzk.zzll().zzpq();
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized void setAppMuted(boolean z) {
        zzk.zzll().setAppMuted(z);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized boolean zzpr() {
        return zzk.zzll().zzpr();
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized void zzbu(String str) {
        zzacu.initialize(this.f2903a);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcsv)).booleanValue()) {
                zzk.zzlo().zza(this.f2903a, this.b, str, (Runnable) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzc(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzawz.zzen("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzawz.zzen("Context is null. Failed to open debug menu.");
            return;
        }
        zzayb zzaybVar = new zzayb(context);
        zzaybVar.setAdUnitId(str);
        zzaybVar.zzp(this.b.zzbsx);
        zzaybVar.showDialog();
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzb(@Nullable String str, IObjectWrapper iObjectWrapper) {
        String a2 = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcsx)).booleanValue() ? a() : "";
        if (!TextUtils.isEmpty(a2)) {
            str = a2;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzacu.initialize(this.f2903a);
        boolean booleanValue = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcsv)).booleanValue() | ((Boolean) zzyt.zzpe().zzd(zzacu.zzcot)).booleanValue();
        Runnable runnable = null;
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcot)).booleanValue()) {
            booleanValue = true;
            final Runnable runnable2 = (Runnable) ObjectWrapper.unwrap(iObjectWrapper);
            runnable = new Runnable(this, runnable2) { // from class: com.google.android.gms.internal.ads.my

                /* renamed from: a, reason: collision with root package name */
                private final zzbkz f2360a;
                private final Runnable b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2360a = this;
                    this.b = runnable2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    final zzbkz zzbkzVar = this.f2360a;
                    final Runnable runnable3 = this.b;
                    zzbbm.zzeae.execute(new Runnable(zzbkzVar, runnable3) { // from class: com.google.android.gms.internal.ads.mz

                        /* renamed from: a, reason: collision with root package name */
                        private final zzbkz f2361a;
                        private final Runnable b;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2361a = zzbkzVar;
                            this.b = runnable3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2361a.a(this.b);
                        }
                    });
                }
            };
        }
        if (booleanValue) {
            zzk.zzlo().zza(this.f2903a, this.b, str, runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final String getVersionString() {
        return this.b.zzbsx;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zzbv(String str) {
        this.e.zzfr(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zza(zzamp zzampVar) throws RemoteException {
        this.c.zzb(zzampVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void zza(zzait zzaitVar) throws RemoteException {
        this.f.zzb(zzaitVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final List<zzaio> zzps() throws RemoteException {
        return this.f.zzajy();
    }

    private final String a() {
        Context applicationContext = this.f2903a.getApplicationContext() == null ? this.f2903a : this.f2903a.getApplicationContext();
        try {
            return Wrappers.packageManager(applicationContext).getApplicationInfo(applicationContext.getPackageName(), 128).metaData.getString("com.google.android.gms.ads.APPLICATION_ID");
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zzawz.zza("Error getting metadata", e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzamm> zzuu = zzk.zzlk().zzvc().zzvr().zzuu();
        if (zzuu == null || zzuu.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzawz.zzd("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.c.zzakr()) {
            HashMap hashMap = new HashMap();
            IObjectWrapper wrap = ObjectWrapper.wrap(this.f2903a);
            Iterator<zzamm> it = zzuu.values().iterator();
            while (it.hasNext()) {
                for (zzaml zzamlVar : it.next().zzdfd) {
                    String str = zzamlVar.zzdeq;
                    for (String str2 : zzamlVar.zzdei) {
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) hashMap.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzcjy<zzams, zzclb> zzd = this.d.zzd(str3, jSONObject);
                    if (zzd != null) {
                        zzams zzamsVar = zzd.zzdgc;
                        if (!zzamsVar.isInitialized() && zzamsVar.zzsj()) {
                            zzamsVar.zza(wrap, zzd.zzfzn, (List<String>) entry.getValue());
                            String valueOf = String.valueOf(str3);
                            zzawz.zzdp(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (Throwable th2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    zzawz.zzd(sb.toString(), th2);
                }
            }
        }
    }
}
