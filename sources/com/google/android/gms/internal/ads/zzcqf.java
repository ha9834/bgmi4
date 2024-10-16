package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcqf extends zzatu {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    private zzbbh<zzcdb> f3377a;

    @GuardedBy("this")
    @Nullable
    private zzcdb b;
    private final zzbjm c;
    private final Context d;

    @Nullable
    private zzbss h;
    private final String i;

    @GuardedBy("this")
    private final zzcxx k;
    private final zzcqa e = new zzcqa();
    private final zzcqb f = new zzcqb();
    private final zzcpz g = new zzcpz();
    private boolean j = false;

    public zzcqf(zzbjm zzbjmVar, Context context, String str) {
        zzcxx zzcxxVar = new zzcxx();
        zzcxxVar.zzglj.add("new_rewarded");
        this.k = zzcxxVar;
        this.c = zzbjmVar;
        this.d = context;
        this.i = str;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized void zza(zzxz zzxzVar, zzaub zzaubVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.f.zza(zzaubVar);
        this.j = false;
        if (this.f3377a != null) {
            return;
        }
        if (this.b != null) {
            return;
        }
        zzcya.zze(this.d, zzxzVar.zzcgq);
        zzcdf zzaeh = this.c.zzacm().zzd(new zzbqy.zza().zzbt(this.d).zza(this.k.zzft(this.i).zzd(zzyd.zzou()).zzg(zzxzVar).zzamq()).zzagh()).zzd(new zzbtv.zza().zza((zzbrl) this.e, this.c.zzace()).zza(new xo(this, this.f), this.c.zzace()).zza((zzbro) this.f, this.c.zzace()).zza((zzbrs) this.e, this.c.zzace()).zza(this.g, this.c.zzace()).zza(new zzcpy(), this.c.zzace()).zzagt()).zzaeh();
        this.h = zzaeh.zzaei();
        this.f3377a = zzaeh.zzadu();
        zzbar.zza(this.f3377a, new xm(this, zzaeh), this.c.zzace());
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zza(iObjectWrapper, false);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.b == null) {
            zzawz.zzep("Rewarded can not be shown before loaded");
            this.e.zzcs(2);
        } else {
            this.b.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.b == null) {
            return null;
        }
        return this.b.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzatw zzatwVar) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.e.zzb(zzatwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzaue zzaueVar) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.e.zzb(zzaueVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzaao zzaaoVar) throws RemoteException {
        this.g.zzb(new xn(this, zzaaoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final Bundle getAdMetadata() throws RemoteException {
        zzbss zzbssVar;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.j && (zzbssVar = this.h) != null) {
            return zzbssVar.getAdMetadata();
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    @Nullable
    public final zzatq zzqh() {
        zzcdb zzcdbVar;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.j || (zzcdbVar = this.b) == null) {
            return null;
        }
        return zzcdbVar.zzqh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.g.onAdMetadataChanged();
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized void zza(zzaum zzaumVar) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.k.zzfu(zzaumVar.zzdqs);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcow)).booleanValue()) {
            this.k.zzfv(zzaumVar.zzdqt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzbbh a(zzcqf zzcqfVar, zzbbh zzbbhVar) {
        zzcqfVar.f3377a = null;
        return null;
    }
}
