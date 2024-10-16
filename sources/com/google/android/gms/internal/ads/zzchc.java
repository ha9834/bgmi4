package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzchc implements zzdti<zzbbh<String>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3254a;
    private final zzdtu<Context> b;

    private zzchc(zzdtu<zzczt> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        this.f3254a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzchc zzaa(zzdtu<zzczt> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        return new zzchc(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzczt zzcztVar = this.f3254a.get();
        final Context context = this.b.get();
        return (zzbbh) zzdto.zza(zzcztVar.zzv(zzczs.WEBVIEW_COOKIE).zzd(new Callable(context) { // from class: com.google.android.gms.internal.ads.tf

            /* renamed from: a, reason: collision with root package name */
            private final Context f2513a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2513a = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager zzaz = zzk.zzli().zzaz(this.f2513a);
                return zzaz != null ? zzaz.getCookie("googleads.g.doubleclick.net") : "";
            }
        }).zza(1L, TimeUnit.SECONDS).zza(Exception.class, tg.f2514a).zzane(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
