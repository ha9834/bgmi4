package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zzio;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzfd extends gq implements hc {

    @VisibleForTesting
    private static int b = 65535;

    @VisibleForTesting
    private static int c = 2;
    private final Map<String, Map<String, String>> d;
    private final Map<String, Map<String, Boolean>> e;
    private final Map<String, Map<String, Boolean>> f;
    private final Map<String, zzbw> g;
    private final Map<String, Map<String, Integer>> h;
    private final Map<String, String> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfd(zzjg zzjgVar) {
        super(zzjgVar);
        this.d = new androidx.b.a();
        this.e = new androidx.b.a();
        this.f = new androidx.b.a();
        this.g = new androidx.b.a();
        this.i = new androidx.b.a();
        this.h = new androidx.b.a();
    }

    @Override // com.google.android.gms.measurement.internal.gq
    protected final boolean a() {
        return false;
    }

    private final void i(String str) {
        c();
        zzo();
        Preconditions.checkNotEmpty(str);
        if (this.g.get(str) == null) {
            byte[] d = zzgy().d(str);
            if (d == null) {
                this.d.put(str, null);
                this.e.put(str, null);
                this.f.put(str, null);
                this.g.put(str, null);
                this.i.put(str, null);
                this.h.put(str, null);
                return;
            }
            zzbw a2 = a(str, d);
            this.d.put(str, a(a2));
            a(str, a2);
            this.g.put(str, a2);
            this.i.put(str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbw a(String str) {
        c();
        zzo();
        Preconditions.checkNotEmpty(str);
        i(str);
        return this.g.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b(String str) {
        zzo();
        return this.i.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(String str) {
        zzo();
        this.i.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str) {
        zzo();
        this.g.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e(String str) {
        Boolean bool;
        zzo();
        zzbw a2 = a(str);
        if (a2 == null || (bool = a2.zzzq) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.hc
    public final String zzb(String str, String str2) {
        zzo();
        i(str);
        Map<String, String> map = this.d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    private static Map<String, String> a(zzbw zzbwVar) {
        androidx.b.a aVar = new androidx.b.a();
        if (zzbwVar != null && zzbwVar.zzzm != null) {
            for (zzbq.zza zzaVar : zzbwVar.zzzm) {
                if (zzaVar != null) {
                    aVar.put(zzaVar.getKey(), zzaVar.getValue());
                }
            }
        }
        return aVar;
    }

    private final void a(String str, zzbw zzbwVar) {
        androidx.b.a aVar = new androidx.b.a();
        androidx.b.a aVar2 = new androidx.b.a();
        androidx.b.a aVar3 = new androidx.b.a();
        if (zzbwVar != null && zzbwVar.zzzn != null) {
            for (zzbx zzbxVar : zzbwVar.zzzn) {
                if (TextUtils.isEmpty(zzbxVar.name)) {
                    zzab().zzgn().zzao("EventConfig contained null event name");
                } else {
                    String zzbe = zzgj.zzbe(zzbxVar.name);
                    if (!TextUtils.isEmpty(zzbe)) {
                        zzbxVar.name = zzbe;
                    }
                    aVar.put(zzbxVar.name, zzbxVar.zzzs);
                    aVar2.put(zzbxVar.name, zzbxVar.zzzt);
                    if (zzbxVar.zzzu != null) {
                        if (zzbxVar.zzzu.intValue() < c || zzbxVar.zzzu.intValue() > b) {
                            zzab().zzgn().zza("Invalid sampling rate. Event name, sample rate", zzbxVar.name, zzbxVar.zzzu);
                        } else {
                            aVar3.put(zzbxVar.name, zzbxVar.zzzu);
                        }
                    }
                }
            }
        }
        this.e.put(str, aVar);
        this.f.put(str, aVar2);
        this.h.put(str, aVar3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        boolean z;
        c();
        zzo();
        Preconditions.checkNotEmpty(str);
        zzbw a2 = a(str, bArr);
        if (a2 == null) {
            return false;
        }
        a(str, a2);
        this.g.put(str, a2);
        this.i.put(str, str2);
        this.d.put(str, a(a2));
        hb zzgx = zzgx();
        zzbv[] zzbvVarArr = a2.zzzo;
        Preconditions.checkNotNull(zzbvVarArr);
        for (zzbv zzbvVar : zzbvVarArr) {
            if (zzbvVar.zzzh != null) {
                for (int i = 0; i < zzbvVar.zzzh.length; i++) {
                    zzbk.zza.C0109zza zzuj = zzbvVar.zzzh[i].zzuj();
                    zzbk.zza.C0109zza c0109zza = (zzbk.zza.C0109zza) ((zzey.zza) zzuj.clone());
                    String zzbe = zzgj.zzbe(zzuj.zzjz());
                    if (zzbe != null) {
                        c0109zza.zzbs(zzbe);
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z2 = z;
                    for (int i2 = 0; i2 < zzuj.zzka(); i2++) {
                        zzbk.zzb zze = zzuj.zze(i2);
                        String zzbe2 = zzgi.zzbe(zze.zzkr());
                        if (zzbe2 != null) {
                            c0109zza.zza(i2, (zzbk.zzb) ((zzey) zze.zzuj().zzbu(zzbe2).zzug()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zzbvVar.zzzh[i] = (zzbk.zza) ((zzey) c0109zza.zzug());
                    }
                }
            }
            if (zzbvVar.zzzg != null) {
                for (int i3 = 0; i3 < zzbvVar.zzzg.length; i3++) {
                    zzbk.zzd zzdVar = zzbvVar.zzzg[i3];
                    String zzbe3 = zzgl.zzbe(zzdVar.getPropertyName());
                    if (zzbe3 != null) {
                        zzbvVar.zzzg[i3] = (zzbk.zzd) ((zzey) zzdVar.zzuj().zzbw(zzbe3).zzug());
                    }
                }
            }
        }
        zzgx.zzgy().a(str, zzbvVarArr);
        try {
            a2.zzzo = null;
            bArr2 = new byte[a2.zzuk()];
            a2.zza(zzio.zzk(bArr2, 0, bArr2.length));
        } catch (IOException e) {
            zzab().zzgn().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzef.a(str), e);
            bArr2 = bArr;
        }
        he zzgy = zzgy();
        Preconditions.checkNotEmpty(str);
        zzgy.zzo();
        zzgy.c();
        new ContentValues().put("remote_config", bArr2);
        try {
            if (zzgy.g().update("apps", r0, "app_id = ?", new String[]{str}) == 0) {
                zzgy.zzab().zzgk().zza("Failed to update remote config (got 0). appId", zzef.a(str));
            }
        } catch (SQLiteException e2) {
            zzgy.zzab().zzgk().zza("Error storing remote config. appId", zzef.a(str), e2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(String str, String str2) {
        Boolean bool;
        zzo();
        i(str);
        if (g(str) && zzjs.e(str2)) {
            return true;
        }
        if (h(str) && zzjs.a(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.e.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(String str, String str2) {
        Boolean bool;
        zzo();
        i(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c(String str, String str2) {
        Integer num;
        zzo();
        i(str);
        Map<String, Integer> map = this.h.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long f(String str) {
        String zzb = zzb(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zzb)) {
            return 0L;
        }
        try {
            return Long.parseLong(zzb);
        } catch (NumberFormatException e) {
            zzab().zzgn().zza("Unable to parse timezone offset. appId", zzef.a(str), e);
            return 0L;
        }
    }

    private final zzbw a(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzbw();
        }
        zzil zzj = zzil.zzj(bArr, 0, bArr.length);
        zzbw zzbwVar = new zzbw();
        try {
            zzbwVar.zza(zzj);
            zzab().zzgs().zza("Parsed config. version, gmp_app_id", zzbwVar.zzzk, zzbwVar.zzcg);
            return zzbwVar;
        } catch (IOException e) {
            zzab().zzgn().zza("Unable to merge remote config. appId", zzef.a(str), e);
            return new zzbw();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g(String str) {
        return "1".equals(zzb(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h(String str) {
        return "1".equals(zzb(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ zzjo zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ hb zzgx() {
        return super.zzgx();
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ he zzgy() {
        return super.zzgy();
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ zzfd zzgz() {
        return super.zzgz();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
