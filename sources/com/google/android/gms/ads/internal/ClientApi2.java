package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaab;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzamp;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzaqq;
import com.google.android.gms.internal.ads.zzasw;
import com.google.android.gms.internal.ads.zzatt;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbzi;
import com.google.android.gms.internal.ads.zzbzj;
import com.google.android.gms.internal.ads.zzcpo;
import com.google.android.gms.internal.ads.zzcpt;
import com.google.android.gms.internal.ads.zzcqd;
import com.google.android.gms.internal.ads.zzcqf;
import com.google.android.gms.internal.ads.zzcqj;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzzf;
import com.google.android.gms.internal.ads.zzzk;
import com.google.android.gms.internal.ads.zzzw;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ClientApi2 extends zzzw {
    @KeepForSdk
    public ClientApi2() {
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaab zzg(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaqq zzh(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcpt(zzbjm.zza(context, zzampVar, i), context, zzydVar, str);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zzb(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcqd(zzbjm.zza(context, zzampVar, i), context, zzydVar, str);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzf zza(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcpo(zzbjm.zza(context, zzampVar, i), context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaem zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzbzj((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2));
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzasw zza(IObjectWrapper iObjectWrapper, zzamp zzampVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcqj(zzbjm.zza(context, zzampVar, i), context);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaqg zzf(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(activity.getIntent());
        if (zzc == null) {
            return new zzs(activity);
        }
        switch (zzc.zzdkr) {
            case 1:
                return new zzr(activity);
            case 2:
                return new zzy(activity);
            case 3:
                return new zzz(activity);
            case 4:
                return new zzt(activity, zzc);
            default:
                return new zzs(activity);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaab zza(IObjectWrapper iObjectWrapper, int i) {
        return zzbjm.zzd((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzaci();
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, int i) {
        return new zzabp();
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaer zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzbzi((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzatt zzb(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcqf(zzbjm.zza(context, zzampVar, i), context, str);
    }
}
