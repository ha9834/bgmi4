package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import com.google.android.gms.internal.ads.zzcqt;

/* loaded from: classes2.dex */
public final class zzcqq extends zzawb {

    /* renamed from: a, reason: collision with root package name */
    private zzbjm f3379a;

    public zzcqq(zzbjm zzbjmVar) {
        this.f3379a = zzbjmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawa
    public final void zza(IObjectWrapper iObjectWrapper, zzawc zzawcVar, zzavy zzavyVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        String str = zzawcVar.zzchk;
        String str2 = zzawcVar.zzbsu;
        zzcqp zza = this.f3379a.zzacn().zze(new zzbqy.zza().zzbt(context).zza(new zzcxx().zzft(str).zzg(new zzya().zzot()).zzd(zzawcVar.zzdsu).zzamq()).zzagh()).zza(new zzcqt(new zzcqt.zza().zzfs(str2)));
        new zzbtv.zza().zzagt();
        zzbar.zza(zza.zzaem().zzaen(), new xt(this, zzavyVar), this.f3379a.zzace());
    }
}
