package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzawm {
    private zztz b;
    private Context f;
    private zzbai g;
    private zzbbh<ArrayList<String>> m;

    /* renamed from: a, reason: collision with root package name */
    private final Object f2816a = new Object();
    private final zzaxc c = new zzaxc();
    private final zzawu d = new zzawu(zzyt.zzpf(), this.c);
    private boolean e = false;

    @Nullable
    private zzacy h = null;

    @Nullable
    private Boolean i = null;
    private final AtomicInteger j = new AtomicInteger(0);
    private final fg k = new fg(null);
    private final Object l = new Object();

    @Nullable
    public final zzacy zzuw() {
        zzacy zzacyVar;
        synchronized (this.f2816a) {
            zzacyVar = this.h;
        }
        return zzacyVar;
    }

    public final void zza(Boolean bool) {
        synchronized (this.f2816a) {
            this.i = bool;
        }
    }

    public final Boolean zzux() {
        Boolean bool;
        synchronized (this.f2816a) {
            bool = this.i;
        }
        return bool;
    }

    public final void zzuy() {
        this.k.a();
    }

    @TargetApi(23)
    public final void zzd(Context context, zzbai zzbaiVar) {
        synchronized (this.f2816a) {
            if (!this.e) {
                this.f = context.getApplicationContext();
                this.g = zzbaiVar;
                zzk.zzlj().zza(this.d);
                zzacy zzacyVar = null;
                this.c.zza(this.f, null, true);
                zzaqx.zzc(this.f, this.g);
                this.b = new zztz(context.getApplicationContext(), this.g);
                zzk.zzlp();
                if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcmx)).booleanValue()) {
                    zzawz.zzds("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzacyVar = new zzacy();
                }
                this.h = zzacyVar;
                if (this.h != null) {
                    zzbao.zza(new ff(this).zzvi(), "AppState.registerCsiReporter");
                }
                this.e = true;
                zzvd();
            }
        }
        zzk.zzlg().zzq(context, zzbaiVar.zzbsx);
    }

    @Nullable
    public final Resources getResources() {
        if (this.g.zzdze) {
            return this.f.getResources();
        }
        try {
            zzbae.zzbl(this.f).getResources();
            return null;
        } catch (zzbag e) {
            zzawz.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Throwable th, String str) {
        zzaqx.zzc(this.f, this.g).zza(th, str);
    }

    public final void zzb(Throwable th, String str) {
        zzaqx.zzc(this.f, this.g).zza(th, str, ((Float) zzyt.zzpe().zzd(zzacu.zzcli)).floatValue());
    }

    public final void zzuz() {
        this.j.incrementAndGet();
    }

    public final void zzva() {
        this.j.decrementAndGet();
    }

    public final int zzvb() {
        return this.j.get();
    }

    public final zzaxb zzvc() {
        zzaxc zzaxcVar;
        synchronized (this.f2816a) {
            zzaxcVar = this.c;
        }
        return zzaxcVar;
    }

    @Nullable
    public final Context getApplicationContext() {
        return this.f;
    }

    public final zzbbh<ArrayList<String>> zzvd() {
        if (PlatformVersion.isAtLeastJellyBean() && this.f != null) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcri)).booleanValue()) {
                synchronized (this.l) {
                    if (this.m != null) {
                        return this.m;
                    }
                    zzbbh<ArrayList<String>> zza = zzaxg.zza(new Callable(this) { // from class: com.google.android.gms.internal.ads.fe

                        /* renamed from: a, reason: collision with root package name */
                        private final zzawm f2167a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2167a = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.f2167a.a();
                        }
                    });
                    this.m = zza;
                    return zza;
                }
            }
        }
        return zzbar.zzm(new ArrayList());
    }

    @TargetApi(16)
    private static ArrayList<String> a(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null) {
                return arrayList;
            }
            for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                    arrayList.add(packageInfo.requestedPermissions[i]);
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException unused) {
            return arrayList;
        }
    }

    public final zzawu zzve() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList a() throws Exception {
        return a(zzasq.zzw(this.f));
    }
}
