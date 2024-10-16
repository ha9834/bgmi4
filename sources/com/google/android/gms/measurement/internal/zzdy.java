package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzdy extends dz {

    /* renamed from: a, reason: collision with root package name */
    private String f4928a;
    private String b;
    private int c;
    private String d;
    private String e;
    private long f;
    private long g;
    private long h;
    private List<String> i;
    private int j;
    private String k;
    private String l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdy(zzfj zzfjVar, long j) {
        super(zzfjVar);
        this.h = j;
    }

    @Override // com.google.android.gms.measurement.internal.dz
    protected final boolean a() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:1|(1:3)(6:85|86|(1:88)(2:98|(1:100))|89|90|(3:92|(1:94)|95))|4|(1:84)(1:8)|9|(1:83)(1:13)|14|(1:(1:17)(1:18))|(2:20|(2:22|(1:24))(1:(1:(13:35|36|(1:40)|41|42|(1:44)(1:79)|45|(1:47)|(1:49)|51|(3:53|(2:55|(1:57)(2:58|(2:59|(2:61|(2:63|64)(1:65))(1:66))))(0)|(1:68))|69|(1:(2:72|73)(2:75|76))(2:77|78))(1:34))(2:28|(1:30))))|82|36|(2:38|40)|41|42|(0)(0)|45|(0)|(0)|51|(0)|69|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01cd, code lost:
    
        zzab().zzgk().zza("getGoogleAppId or isMeasurementEnabled failed with exception. appId", com.google.android.gms.measurement.internal.zzef.a(r3), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a7 A[Catch: IllegalStateException -> 0x01cc, TryCatch #2 {IllegalStateException -> 0x01cc, blocks: (B:42:0x0191, B:45:0x019f, B:47:0x01a7, B:49:0x01ba), top: B:41:0x0191 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ba A[Catch: IllegalStateException -> 0x01cc, TRY_LEAVE, TryCatch #2 {IllegalStateException -> 0x01cc, blocks: (B:42:0x0191, B:45:0x019f, B:47:0x01a7, B:49:0x01ba), top: B:41:0x0191 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019e  */
    @Override // com.google.android.gms.measurement.internal.dz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void b() {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdy.b():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzn a(String str) {
        Boolean a2;
        zzo();
        zzm();
        String c = c();
        String d = d();
        j();
        String str2 = this.b;
        long f = f();
        j();
        String str3 = this.d;
        long zzao = zzad().zzao();
        j();
        zzo();
        if (this.f == 0) {
            this.f = this.v.zzz().a(getContext(), getContext().getPackageName());
        }
        long j = this.f;
        boolean isEnabled = this.v.isEnabled();
        boolean z = !zzac().s;
        zzo();
        zzm();
        String k = !this.v.isEnabled() ? null : k();
        j();
        long j2 = this.g;
        long c2 = this.v.c();
        int g = g();
        boolean booleanValue = zzad().zzbr().booleanValue();
        zzs zzad = zzad();
        zzad.zzm();
        Boolean a3 = zzad.a("google_analytics_ssaid_collection_enabled");
        return new zzn(c, d, str2, f, str3, zzao, j, str, isEnabled, z, k, j2, c2, g, booleanValue, Boolean.valueOf(a3 == null || a3.booleanValue()).booleanValue(), zzac().i(), e(), (!zzad().zze(c(), zzak.zzij) || (a2 = zzad().a("google_analytics_default_allow_ad_personalization_signals")) == null) ? null : Boolean.valueOf(!a2.booleanValue()), this.h, zzad().zze(c(), zzak.zzix) ? this.i : null);
    }

    @VisibleForTesting
    private final String k() {
        try {
            Class<?> loadClass = getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, getContext());
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    zzab().zzgp().zzao("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzab().zzgo().zzao("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        j();
        return this.f4928a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        j();
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String e() {
        j();
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int f() {
        j();
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int g() {
        j();
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> h() {
        return this.i;
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zza zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzgp zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzdy zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzhv zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzhq zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzeb zzu() {
        return super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zziw zzv() {
        return super.zzv();
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
