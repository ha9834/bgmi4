package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzauq implements zzavb {

    /* renamed from: a, reason: collision with root package name */
    private static List<Future<Void>> f2809a = Collections.synchronizedList(new ArrayList());
    private static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    @GuardedBy("lock")
    private final zzdsj c;

    @GuardedBy("lock")
    private final LinkedHashMap<String, zzdsp> d;
    private final Context g;
    private final zzavd h;
    private boolean i;
    private final zzauy j;
    private final el k;

    @GuardedBy("lock")
    private final List<String> e = new ArrayList();

    @GuardedBy("lock")
    private final List<String> f = new ArrayList();
    private final Object l = new Object();
    private HashSet<String> m = new HashSet<>();
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public zzauq(Context context, zzbai zzbaiVar, zzauy zzauyVar, String str, zzavd zzavdVar) {
        Preconditions.checkNotNull(zzauyVar, "SafeBrowsing config is not present.");
        this.g = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.d = new LinkedHashMap<>();
        this.h = zzavdVar;
        this.j = zzauyVar;
        Iterator<String> it = this.j.zzdrv.iterator();
        while (it.hasNext()) {
            this.m.add(it.next().toLowerCase(Locale.ENGLISH));
        }
        this.m.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzdsj zzdsjVar = new zzdsj();
        zzdsjVar.zzhrv = 8;
        zzdsjVar.url = str;
        zzdsjVar.zzhrx = str;
        zzdsjVar.zzhrz = new zzdsk();
        zzdsjVar.zzhrz.zzdrr = this.j.zzdrr;
        zzdsq zzdsqVar = new zzdsq();
        zzdsqVar.zzhte = zzbaiVar.zzbsx;
        zzdsqVar.zzhtg = Boolean.valueOf(Wrappers.packageManager(this.g).isCallerInstantApp());
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.g);
        if (apkVersion > 0) {
            zzdsqVar.zzhtf = Long.valueOf(apkVersion);
        }
        zzdsjVar.zzhsj = zzdsqVar;
        this.c = zzdsjVar;
        this.k = new el(this.g, this.j.zzdry, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Void c(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final zzauy zzuc() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void zzdk(String str) {
        synchronized (this.l) {
            this.c.zzhsb = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final boolean zzud() {
        return PlatformVersion.isAtLeastKitKat() && this.j.zzdrt && !this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void zzj(View view) {
        if (this.j.zzdrt && !this.o) {
            zzk.zzlg();
            Bitmap zzl = zzaxi.zzl(view);
            if (zzl == null) {
                zzava.zzdp("Failed to capture the webview bitmap.");
            } else {
                this.o = true;
                zzaxi.zzd(new ei(this, zzl));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzavb
    public final void zza(String str, Map<String, String> map, int i) {
        synchronized (this.l) {
            if (i == 3) {
                this.p = true;
            }
            if (this.d.containsKey(str)) {
                if (i == 3) {
                    this.d.get(str).zzhtc = Integer.valueOf(i);
                }
                return;
            }
            zzdsp zzdspVar = new zzdsp();
            zzdspVar.zzhtc = Integer.valueOf(i);
            zzdspVar.zzhsw = Integer.valueOf(this.d.size());
            zzdspVar.url = str;
            zzdspVar.zzhsx = new zzdsm();
            if (this.m.size() > 0 && map != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        String key = entry.getKey() != null ? entry.getKey() : "";
                        String value = entry.getValue() != null ? entry.getValue() : "";
                        if (this.m.contains(key.toLowerCase(Locale.ENGLISH))) {
                            zzdsl zzdslVar = new zzdsl();
                            zzdslVar.zzhsn = key.getBytes("UTF-8");
                            zzdslVar.zzhso = value.getBytes("UTF-8");
                            arrayList.add(zzdslVar);
                        }
                    } catch (UnsupportedEncodingException unused) {
                        zzava.zzdp("Cannot convert string to bytes, skip header.");
                    }
                }
                zzdsl[] zzdslVarArr = new zzdsl[arrayList.size()];
                arrayList.toArray(zzdslVarArr);
                zzdspVar.zzhsx.zzhsq = zzdslVarArr;
            }
            this.d.put(str, zzdspVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        synchronized (this.l) {
            this.e.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) {
        synchronized (this.l) {
            this.f.add(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final String[] zza(String[] strArr) {
        return (String[]) this.k.a(strArr).toArray(new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void zzue() {
        this.n = true;
    }

    private final zzdsp d(String str) {
        zzdsp zzdspVar;
        synchronized (this.l) {
            zzdspVar = this.d.get(str);
        }
        return zzdspVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void zzuf() {
        synchronized (this.l) {
            zzbbh zza = zzbar.zza(this.h.zza(this.g, this.d.keySet()), new zzbal(this) { // from class: com.google.android.gms.internal.ads.eg

                /* renamed from: a, reason: collision with root package name */
                private final zzauq f2145a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2145a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return this.f2145a.a((Map) obj);
                }
            }, zzbbm.zzeaf);
            zzbbh zza2 = zzbar.zza(zza, 10L, TimeUnit.SECONDS, b);
            zzbar.zza(zza, new ej(this, zza2), zzbbm.zzeaf);
            f2809a.add(zza2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzbbh<Void> b() {
        zzbbh<Void> zza;
        if (!((this.i && this.j.zzdrx) || (this.p && this.j.zzdrw) || (!this.i && this.j.zzdru))) {
            return zzbar.zzm(null);
        }
        synchronized (this.l) {
            this.c.zzhsa = new zzdsp[this.d.size()];
            this.d.values().toArray(this.c.zzhsa);
            this.c.zzhsk = (String[]) this.e.toArray(new String[0]);
            this.c.zzhsl = (String[]) this.f.toArray(new String[0]);
            if (zzava.isEnabled()) {
                String str = this.c.url;
                String str2 = this.c.zzhsb;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(str);
                sb.append("\n  clickUrl: ");
                sb.append(str2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzdsp zzdspVar : this.c.zzhsa) {
                    sb2.append("    [");
                    sb2.append(zzdspVar.zzhtd.length);
                    sb2.append("] ");
                    sb2.append(zzdspVar.url);
                }
                zzava.zzdp(sb2.toString());
            }
            zzbbh<String> zza2 = new zzayu(this.g).zza(1, this.j.zzdrs, null, zzdrw.zza(this.c));
            if (zzava.isEnabled()) {
                zza2.zza(new ek(this), zzaxg.zzdvp);
            }
            zza = zzbar.zza(zza2, eh.f2146a, zzbbm.zzeaf);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.l) {
                            int length = optJSONArray.length();
                            zzdsp d = d(str);
                            if (d == null) {
                                String valueOf = String.valueOf(str);
                                zzava.zzdp(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                d.zzhtd = new String[length];
                                for (int i = 0; i < length; i++) {
                                    d.zzhtd[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                                }
                                this.i = (length > 0) | this.i;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzctj)).booleanValue()) {
                    zzawz.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzbar.zzd(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.i) {
            synchronized (this.l) {
                this.c.zzhrv = 9;
            }
        }
        return b();
    }
}
