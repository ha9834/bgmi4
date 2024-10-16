package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
/* loaded from: classes2.dex */
public final class zzbcw {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2856a;
    private final zzbdf b;
    private final ViewGroup c;
    private zzbcq d;

    public zzbcw(Context context, ViewGroup viewGroup, zzbgz zzbgzVar) {
        this(context, viewGroup, zzbgzVar, null);
    }

    @VisibleForTesting
    private zzbcw(Context context, ViewGroup viewGroup, zzbdf zzbdfVar, zzbcq zzbcqVar) {
        this.f2856a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.c = viewGroup;
        this.b = zzbdfVar;
        this.d = null;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbcq zzbcqVar = this.d;
        if (zzbcqVar != null) {
            zzbcqVar.zzd(i, i2, i3, i4);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbde zzbdeVar) {
        if (this.d != null) {
            return;
        }
        zzadb.zza(this.b.zzyg().zzqw(), this.b.zzyc(), "vpr2");
        Context context = this.f2856a;
        zzbdf zzbdfVar = this.b;
        this.d = new zzbcq(context, zzbdfVar, i5, z, zzbdfVar.zzyg().zzqw(), zzbdeVar);
        this.c.addView(this.d, 0, new ViewGroup.LayoutParams(-1, -1));
        this.d.zzd(i, i2, i3, i4);
        this.b.zzao(false);
    }

    public final zzbcq zzxw() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.d;
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbcq zzbcqVar = this.d;
        if (zzbcqVar != null) {
            zzbcqVar.pause();
        }
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbcq zzbcqVar = this.d;
        if (zzbcqVar != null) {
            zzbcqVar.destroy();
            this.c.removeView(this.d);
            this.d = null;
        }
    }
}
