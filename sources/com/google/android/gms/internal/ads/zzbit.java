package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbit {
    public static zzbgz zza(final Context context, final zzbin zzbinVar, final String str, final boolean z, final boolean z2, final zzdh zzdhVar, final zzbai zzbaiVar, zzadi zzadiVar, final zzj zzjVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzwj zzwjVar) throws zzbhj {
        try {
            final zzadi zzadiVar2 = null;
            return (zzbgz) zzazl.zzb(new Callable(context, zzbinVar, str, z, z2, zzdhVar, zzbaiVar, zzadiVar2, zzjVar, zzaVar, zzwjVar) { // from class: com.google.android.gms.internal.ads.lw

                /* renamed from: a, reason: collision with root package name */
                private final Context f2330a;
                private final zzbin b;
                private final String c;
                private final boolean d;
                private final boolean e;
                private final zzdh f;
                private final zzbai g;
                private final zzadi h;
                private final zzj i;
                private final com.google.android.gms.ads.internal.zza j;
                private final zzwj k;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2330a = context;
                    this.b = zzbinVar;
                    this.c = str;
                    this.d = z;
                    this.e = z2;
                    this.f = zzdhVar;
                    this.g = zzbaiVar;
                    this.h = zzadiVar2;
                    this.i = zzjVar;
                    this.j = zzaVar;
                    this.k = zzwjVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f2330a;
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
                    zzbio zzbioVar = new zzbio();
                    lx lxVar = new lx(new zzbim(context2), zzbioVar, zzbinVar2, str2, z3, z4, zzdhVar2, zzbaiVar2, zzadiVar3, zzjVar2, zzaVar2, zzwjVar2);
                    zzbhk zzbhkVar = new zzbhk(lxVar);
                    lxVar.setWebChromeClient(new zzbgr(zzbhkVar));
                    zzbioVar.a(zzbhkVar, z4);
                    return zzbhkVar;
                }
            });
        } catch (Throwable th) {
            zzk.zzlk().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbhj("Webview initialization failed.", th);
        }
    }
}
