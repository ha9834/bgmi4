package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbhf {
    public static zzbbh<zzbgz> zza(final Context context, final zzbai zzbaiVar, final String str, final zzdh zzdhVar, final com.google.android.gms.ads.internal.zza zzaVar) {
        return zzbar.zza(zzbar.zzm(null), new zzbal(context, zzdhVar, zzbaiVar, zzaVar, str) { // from class: com.google.android.gms.internal.ads.lg

            /* renamed from: a, reason: collision with root package name */
            private final Context f2314a;
            private final zzdh b;
            private final zzbai c;
            private final com.google.android.gms.ads.internal.zza d;
            private final String e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2314a = context;
                this.b = zzdhVar;
                this.c = zzbaiVar;
                this.d = zzaVar;
                this.e = str;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                Context context2 = this.f2314a;
                zzdh zzdhVar2 = this.b;
                zzbai zzbaiVar2 = this.c;
                com.google.android.gms.ads.internal.zza zzaVar2 = this.d;
                String str2 = this.e;
                zzk.zzlh();
                zzbgz zza = zzbhf.zza(context2, zzbin.zzabu(), "", false, false, zzdhVar2, zzbaiVar2, null, null, zzaVar2, zzwj.zznl());
                final zzbbq zzn = zzbbq.zzn(zza);
                zza.zzaai().zza(new zzbij(zzn) { // from class: com.google.android.gms.internal.ads.li

                    /* renamed from: a, reason: collision with root package name */
                    private final zzbbq f2316a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2316a = zzn;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbij
                    public final void zzae(boolean z) {
                        this.f2316a.zzxe();
                    }
                });
                zza.loadUrl(str2);
                return zzn;
            }
        }, zzbbm.zzeae);
    }

    public static zzbgz zza(final Context context, final zzbin zzbinVar, final String str, final boolean z, final boolean z2, final zzdh zzdhVar, final zzbai zzbaiVar, zzadi zzadiVar, final zzj zzjVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzwj zzwjVar) throws zzbhj {
        zzacu.initialize(context);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoi)).booleanValue()) {
            return zzbit.zza(context, zzbinVar, str, z, z2, zzdhVar, zzbaiVar, null, zzjVar, zzaVar, zzwjVar);
        }
        try {
            final zzadi zzadiVar2 = null;
            return (zzbgz) zzazl.zzb(new Callable(context, zzbinVar, str, z, z2, zzdhVar, zzbaiVar, zzadiVar2, zzjVar, zzaVar, zzwjVar) { // from class: com.google.android.gms.internal.ads.lh

                /* renamed from: a, reason: collision with root package name */
                private final Context f2315a;
                private final zzbin b;
                private final String c;
                private final boolean d;
                private final boolean e;
                private final zzdh f;
                private final zzbai g;
                private final zzadi h = null;
                private final zzj i;
                private final com.google.android.gms.ads.internal.zza j;
                private final zzwj k;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2315a = context;
                    this.b = zzbinVar;
                    this.c = str;
                    this.d = z;
                    this.e = z2;
                    this.f = zzdhVar;
                    this.g = zzbaiVar;
                    this.i = zzjVar;
                    this.j = zzaVar;
                    this.k = zzwjVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f2315a;
                    zzbin zzbinVar2 = this.b;
                    String str2 = this.c;
                    boolean z3 = this.d;
                    boolean z4 = this.e;
                    zzdh zzdhVar2 = this.f;
                    zzbai zzbaiVar2 = this.g;
                    zzadi zzadiVar3 = this.h;
                    zzj zzjVar2 = this.i;
                    com.google.android.gms.ads.internal.zza zzaVar2 = this.j;
                    zzwj zzwjVar2 = this.k;
                    zzbhk zzbhkVar = new zzbhk(lk.a(context2, zzbinVar2, str2, z3, z4, zzdhVar2, zzbaiVar2, zzadiVar3, zzjVar2, zzaVar2, zzwjVar2));
                    zzbhkVar.setWebViewClient(zzk.zzli().zza(zzbhkVar, zzwjVar2, z4));
                    zzbhkVar.setWebChromeClient(new zzbgr(zzbhkVar));
                    return zzbhkVar;
                }
            });
        } catch (Throwable th) {
            throw new zzbhj("Webview initialization failed.", th);
        }
    }
}
