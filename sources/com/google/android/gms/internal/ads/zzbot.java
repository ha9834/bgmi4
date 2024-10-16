package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzbot implements zzbrw, zzbsr {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2978a;
    private final zzbgz b;
    private final zzcxm c;
    private final zzbai d;

    @GuardedBy("this")
    private IObjectWrapper e;

    @GuardedBy("this")
    private boolean f;

    public zzbot(Context context, zzbgz zzbgzVar, zzcxm zzcxmVar, zzbai zzbaiVar) {
        this.f2978a = context;
        this.b = zzbgzVar;
        this.c = zzcxmVar;
        this.d = zzbaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        if (this.f) {
            return;
        }
        a();
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final synchronized void onAdImpression() {
        if (!this.f) {
            a();
        }
        if (this.c.zzdoh && this.e != null && this.b != null) {
            this.b.zza("onSdkImpression", new androidx.b.a());
        }
    }

    private final synchronized void a() {
        if (this.c.zzdoh) {
            if (this.b == null) {
                return;
            }
            if (zzk.zzlv().zzl(this.f2978a)) {
                int i = this.d.zzdzc;
                int i2 = this.d.zzdzd;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i);
                sb.append(".");
                sb.append(i2);
                this.e = zzk.zzlv().zza(sb.toString(), this.b.getWebView(), "", "javascript", this.c.zzgko.optInt(MessengerShareContentUtility.MEDIA_TYPE, -1) == 0 ? null : "javascript");
                View view = this.b.getView();
                if (this.e != null && view != null) {
                    zzk.zzlv().zza(this.e, view);
                    this.b.zzam(this.e);
                    zzk.zzlv().zzaa(this.e);
                    this.f = true;
                }
            }
        }
    }
}
