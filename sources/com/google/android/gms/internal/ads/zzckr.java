package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzckr implements zzcjv<zzbvx> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3298a;
    private final zzbws b;
    private final Executor c;
    private final zzcxk d;

    public zzckr(Context context, Executor executor, zzbws zzbwsVar, zzcxk zzcxkVar) {
        this.f3298a = context;
        this.b = zzbwsVar;
        this.c = executor;
        this.d = zzcxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return (this.f3298a instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzads.zzj(this.f3298a) && !TextUtils.isEmpty(a(zzcxmVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbvx> zzb(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        String a2 = a(zzcxmVar);
        final Uri parse = a2 != null ? Uri.parse(a2) : null;
        return zzbar.zza(zzbar.zzm(null), new zzbal(this, parse, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.uy

            /* renamed from: a, reason: collision with root package name */
            private final zzckr f2554a;
            private final Uri b;
            private final zzcxu c;
            private final zzcxm d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2554a = this;
                this.b = parse;
                this.c = zzcxuVar;
                this.d = zzcxmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2554a.a(this.b, this.c, this.d, obj);
            }
        }, this.c);
    }

    private static String a(zzcxm zzcxmVar) {
        try {
            return zzcxmVar.zzgkh.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(Uri uri, zzcxu zzcxuVar, zzcxm zzcxmVar, Object obj) throws Exception {
        try {
            androidx.browser.customtabs.c a2 = new c.a().a();
            a2.f400a.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(a2.f400a);
            final zzbbr zzbbrVar = new zzbbr();
            zzbvy zza = this.b.zza(new zzbpr(zzcxuVar, zzcxmVar, null), new zzbvz(new zzbwz(zzbbrVar) { // from class: com.google.android.gms.internal.ads.uz

                /* renamed from: a, reason: collision with root package name */
                private final zzbbr f2555a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2555a = zzbbrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbwz
                public final void zza(boolean z, Context context) {
                    zzbbr zzbbrVar2 = this.f2555a;
                    try {
                        zzk.zzlf();
                        com.google.android.gms.ads.internal.overlay.zzm.zza(context, (AdOverlayInfoParcel) zzbbrVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }));
            zzbbrVar.set(new AdOverlayInfoParcel(zzcVar, null, zza.zzaef(), null, new zzbai(0, 0, false)));
            this.d.zzuy();
            return zzbar.zzm(zza.zzaee());
        } catch (Throwable th) {
            zzawz.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
