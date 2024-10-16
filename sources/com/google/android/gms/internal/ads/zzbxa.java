package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzbxa implements com.google.android.gms.ads.internal.overlay.zzo, zzbsr {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3095a;
    private final zzbgz b;
    private final zzcxm c;
    private final zzbai d;
    private final int e;

    @VisibleForTesting
    private IObjectWrapper f;

    public zzbxa(Context context, zzbgz zzbgzVar, zzcxm zzcxmVar, zzbai zzbaiVar, int i) {
        this.f3095a = context;
        this.b = zzbgzVar;
        this.c = zzcxmVar;
        this.d = zzbaiVar;
        this.e = i;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        int i = this.e;
        if ((i == 7 || i == 3) && this.c.zzdoh && this.b != null && zzk.zzlv().zzl(this.f3095a)) {
            int i2 = this.d.zzdzc;
            int i3 = this.d.zzdzd;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i2);
            sb.append(".");
            sb.append(i3);
            this.f = zzk.zzlv().zza(sb.toString(), this.b.getWebView(), "", "javascript", this.c.zzgko.optInt(MessengerShareContentUtility.MEDIA_TYPE, -1) == 0 ? null : "javascript");
            if (this.f == null || this.b.getView() == null) {
                return;
            }
            zzk.zzlv().zza(this.f, this.b.getView());
            this.b.zzam(this.f);
            zzk.zzlv().zzaa(this.f);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.f = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        zzbgz zzbgzVar;
        if (this.f == null || (zzbgzVar = this.b) == null) {
            return;
        }
        zzbgzVar.zza("onSdkImpression", new HashMap());
    }
}
