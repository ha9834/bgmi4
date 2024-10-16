package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcbi {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3165a;
    private final zzcxv b;
    private final Executor c;
    private final zzcdn d;

    public zzcbi(Context context, zzcxv zzcxvVar, Executor executor, zzcdn zzcdnVar) {
        this.f3165a = context;
        this.b = zzcxvVar;
        this.c = executor;
        this.d = zzcdnVar;
    }

    public final zzbbh<zzbgz> zzm(final JSONObject jSONObject) {
        return zzbar.zza(zzbar.zza(zzbar.zzm(null), new zzbal(this) { // from class: com.google.android.gms.internal.ads.ri

            /* renamed from: a, reason: collision with root package name */
            private final zzcbi f2464a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2464a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2464a.a(obj);
            }
        }, this.c), new zzbal(this, jSONObject) { // from class: com.google.android.gms.internal.ads.rg

            /* renamed from: a, reason: collision with root package name */
            private final zzcbi f2462a;
            private final JSONObject b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2462a = this;
                this.b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2462a.a(this.b, (zzbgz) obj);
            }
        }, this.c);
    }

    public final zzbbh<zzbgz> zzq(final String str, final String str2) {
        return zzbar.zza(zzbar.zzm(null), new zzbal(this, str, str2) { // from class: com.google.android.gms.internal.ads.rh

            /* renamed from: a, reason: collision with root package name */
            private final zzcbi f2463a;
            private final String b;
            private final String c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2463a = this;
                this.b = str;
                this.c = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2463a.a(this.b, this.c, obj);
            }
        }, this.c);
    }

    private final void a(zzbgz zzbgzVar) {
        zzbgzVar.zza("/video", zzagz.zzdab);
        zzbgzVar.zza("/videoMeta", zzagz.zzdac);
        zzbgzVar.zza("/precache", new zzbgc());
        zzbgzVar.zza("/delayPageLoaded", zzagz.zzdaf);
        zzbgzVar.zza("/instrument", zzagz.zzdad);
        zzbgzVar.zza("/log", zzagz.zzczw);
        zzbgzVar.zza("/videoClicked", zzagz.zzczx);
        zzbgzVar.zzaai().zzau(true);
        if (this.b.zzdne != null) {
            zzbgzVar.zza("/open", new zzahs(null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(Object obj) throws Exception {
        zzbgz zzc = this.d.zzc(zzyd.zzg(this.f3165a));
        final zzbbq zzn = zzbbq.zzn(zzc);
        a(zzc);
        zzc.zzaai().zza(new zzbik(zzn) { // from class: com.google.android.gms.internal.ads.rj

            /* renamed from: a, reason: collision with root package name */
            private final zzbbq f2465a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2465a = zzn;
            }

            @Override // com.google.android.gms.internal.ads.zzbik
            public final void zzrw() {
                this.f2465a.zzxe();
            }
        });
        zzc.loadUrl((String) zzyt.zzpe().zzd(zzacu.zzcsd));
        return zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(String str, String str2, Object obj) throws Exception {
        final zzbgz zzc = this.d.zzc(zzyd.zzg(this.f3165a));
        final zzbbq zzn = zzbbq.zzn(zzc);
        a(zzc);
        if (this.b.zzdne != null) {
            zzc.zza(zzbin.zzabw());
        } else {
            zzc.zza(zzbin.zzabv());
        }
        zzc.zzaai().zza(new zzbij(this, zzc, zzn) { // from class: com.google.android.gms.internal.ads.rk

            /* renamed from: a, reason: collision with root package name */
            private final zzcbi f2466a;
            private final zzbgz b;
            private final zzbbq c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2466a = this;
                this.b = zzc;
                this.c = zzn;
            }

            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zzae(boolean z) {
                this.f2466a.a(this.b, this.c, z);
            }
        });
        zzc.zzb(str, str2, null);
        return zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbgz zzbgzVar, zzbbq zzbbqVar, boolean z) {
        if (this.b.zzgla != null && zzbgzVar.zzyb() != null) {
            zzbgzVar.zzyb().zzb(this.b.zzgla);
        }
        zzbbqVar.zzxe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(JSONObject jSONObject, final zzbgz zzbgzVar) throws Exception {
        final zzbbq zzn = zzbbq.zzn(zzbgzVar);
        if (this.b.zzdne != null) {
            zzbgzVar.zza(zzbin.zzabw());
        } else {
            zzbgzVar.zza(zzbin.zzabv());
        }
        zzbgzVar.zzaai().zza(new zzbij(this, zzbgzVar, zzn) { // from class: com.google.android.gms.internal.ads.rl

            /* renamed from: a, reason: collision with root package name */
            private final zzcbi f2467a;
            private final zzbgz b;
            private final zzbbq c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2467a = this;
                this.b = zzbgzVar;
                this.c = zzn;
            }

            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zzae(boolean z) {
                this.f2467a.b(this.b, this.c, z);
            }
        });
        zzbgzVar.zzb("google.afma.nativeAds.renderVideo", jSONObject);
        return zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(zzbgz zzbgzVar, zzbbq zzbbqVar, boolean z) {
        if (this.b.zzgla != null && zzbgzVar.zzyb() != null) {
            zzbgzVar.zzyb().zzb(this.b.zzgla);
        }
        zzbbqVar.zzxe();
    }
}
