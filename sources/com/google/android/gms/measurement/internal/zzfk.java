package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public final class zzfk extends zzdw {

    /* renamed from: a, reason: collision with root package name */
    private final zzjg f4942a;
    private Boolean b;
    private String c;

    public zzfk(zzjg zzjgVar) {
        this(zzjgVar, null);
    }

    private zzfk(zzjg zzjgVar, String str) {
        Preconditions.checkNotNull(zzjgVar);
        this.f4942a = zzjgVar;
        this.c = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzb(zzn zznVar) {
        a(zznVar, false);
        a(new dm(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzai zzaiVar, zzn zznVar) {
        Preconditions.checkNotNull(zzaiVar);
        a(zznVar, false);
        a(new dw(this, zzaiVar, zznVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzai a(zzai zzaiVar, zzn zznVar) {
        boolean z = false;
        if ("_cmp".equals(zzaiVar.name) && zzaiVar.zzfq != null && zzaiVar.zzfq.size() != 0) {
            String d = zzaiVar.zzfq.d("_cis");
            if (!TextUtils.isEmpty(d) && (("referrer broadcast".equals(d) || "referrer API".equals(d)) && this.f4942a.zzad().i(zznVar.packageName))) {
                z = true;
            }
        }
        if (!z) {
            return zzaiVar;
        }
        this.f4942a.zzab().zzgq().zza("Event has been filtered ", zzaiVar.toString());
        return new zzai("_cmpx", zzaiVar.zzfq, zzaiVar.origin, zzaiVar.zzfu);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzai zzaiVar, String str, String str2) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotEmpty(str);
        a(str, true);
        a(new dv(this, zzaiVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final byte[] zza(zzai zzaiVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaiVar);
        a(str, true);
        this.f4942a.zzab().zzgr().zza("Log and bundle. event", this.f4942a.zzy().a(zzaiVar.name));
        long nanoTime = this.f4942a.zzx().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f4942a.zzaa().zzb(new dy(this, zzaiVar, str)).get();
            if (bArr == null) {
                this.f4942a.zzab().zzgk().zza("Log and bundle returned null. appId", zzef.a(str));
                bArr = new byte[0];
            }
            this.f4942a.zzab().zzgr().zza("Log and bundle processed. event, size, time_ms", this.f4942a.zzy().a(zzaiVar.name), Integer.valueOf(bArr.length), Long.valueOf((this.f4942a.zzx().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.f4942a.zzab().zzgk().zza("Failed to log and bundle. appId, event, error", zzef.a(str), this.f4942a.zzy().a(zzaiVar.name), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzjn zzjnVar, zzn zznVar) {
        Preconditions.checkNotNull(zzjnVar);
        a(zznVar, false);
        if (zzjnVar.getValue() == null) {
            a(new dx(this, zzjnVar, zznVar));
        } else {
            a(new eb(this, zzjnVar, zznVar));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzjn> zza(zzn zznVar, boolean z) {
        a(zznVar, false);
        try {
            List<gv> list = (List) this.f4942a.zzaa().zza(new ea(this, zznVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (gv gvVar : list) {
                if (z || !zzjs.e(gvVar.c)) {
                    arrayList.add(new zzjn(gvVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f4942a.zzab().zzgk().zza("Failed to get user attributes. appId", zzef.a(zznVar.packageName), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzn zznVar) {
        a(zznVar, false);
        a(new ed(this, zznVar));
    }

    private final void a(zzn zznVar, boolean z) {
        Preconditions.checkNotNull(zznVar);
        a(zznVar.packageName, false);
        this.f4942a.zzz().c(zznVar.zzcg, zznVar.zzcu);
    }

    private final void a(String str, boolean z) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            this.f4942a.zzab().zzgk().zzao("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.b == null) {
                    if (!"com.google.android.gms".equals(this.c) && !UidVerifier.isGooglePlayServicesUid(this.f4942a.getContext(), Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(this.f4942a.getContext()).isUidGoogleSigned(Binder.getCallingUid())) {
                        z2 = false;
                        this.b = Boolean.valueOf(z2);
                    }
                    z2 = true;
                    this.b = Boolean.valueOf(z2);
                }
                if (this.b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.f4942a.zzab().zzgk().zza("Measurement Service called with invalid calling package. appId", zzef.a(str));
                throw e;
            }
        }
        if (this.c == null && GooglePlayServicesUtilLight.uidHasPackageName(this.f4942a.getContext(), Binder.getCallingUid(), str)) {
            this.c = str;
        }
        if (str.equals(this.c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(long j, String str, String str2, String str3) {
        a(new ec(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final String zzc(zzn zznVar) {
        a(zznVar, false);
        return this.f4942a.d(zznVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzq zzqVar, zzn zznVar) {
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotNull(zzqVar.zzdw);
        a(zznVar, false);
        zzq zzqVar2 = new zzq(zzqVar);
        zzqVar2.packageName = zznVar.packageName;
        if (zzqVar.zzdw.getValue() == null) {
            a(new dl(this, zzqVar2, zznVar));
        } else {
            a(new Cdo(this, zzqVar2, zznVar));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzb(zzq zzqVar) {
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotNull(zzqVar.zzdw);
        a(zzqVar.packageName, true);
        zzq zzqVar2 = new zzq(zzqVar);
        if (zzqVar.zzdw.getValue() == null) {
            a(new dn(this, zzqVar2));
        } else {
            a(new dq(this, zzqVar2));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzjn> zza(String str, String str2, boolean z, zzn zznVar) {
        a(zznVar, false);
        try {
            List<gv> list = (List) this.f4942a.zzaa().zza(new dp(this, zznVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (gv gvVar : list) {
                if (z || !zzjs.e(gvVar.c)) {
                    arrayList.add(new zzjn(gvVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f4942a.zzab().zzgk().zza("Failed to get user attributes. appId", zzef.a(zznVar.packageName), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzjn> zza(String str, String str2, String str3, boolean z) {
        a(str, true);
        try {
            List<gv> list = (List) this.f4942a.zzaa().zza(new ds(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (gv gvVar : list) {
                if (z || !zzjs.e(gvVar.c)) {
                    arrayList.add(new zzjn(gvVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f4942a.zzab().zzgk().zza("Failed to get user attributes. appId", zzef.a(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzq> zza(String str, String str2, zzn zznVar) {
        a(zznVar, false);
        try {
            return (List) this.f4942a.zzaa().zza(new dr(this, zznVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f4942a.zzab().zzgk().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzq> zzc(String str, String str2, String str3) {
        a(str, true);
        try {
            return (List) this.f4942a.zzaa().zza(new du(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f4942a.zzab().zzgk().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzd(zzn zznVar) {
        a(zznVar.packageName, false);
        a(new dt(this, zznVar));
    }

    @VisibleForTesting
    private final void a(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.f4942a.zzaa().zzhp()) {
            runnable.run();
        } else {
            this.f4942a.zzaa().zza(runnable);
        }
    }
}
