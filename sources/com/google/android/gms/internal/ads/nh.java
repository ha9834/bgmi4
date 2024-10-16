package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class nh extends zzbnf {
    private final Context f;
    private final View g;
    private final zzbgz h;
    private final zzcxn i;
    private final zzbpb j;
    private final zzbzc k;
    private final zzbvd l;
    private final zzdte<zzcpm> m;
    private final Executor n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public nh(Context context, zzcxn zzcxnVar, View view, zzbgz zzbgzVar, zzbpb zzbpbVar, zzbzc zzbzcVar, zzbvd zzbvdVar, zzdte<zzcpm> zzdteVar, Executor executor) {
        this.f = context;
        this.g = view;
        this.h = zzbgzVar;
        this.i = zzcxnVar;
        this.j = zzbpbVar;
        this.k = zzbzcVar;
        this.l = zzbvdVar;
        this.m = zzdteVar;
        this.n = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final View zzafi() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void zza(ViewGroup viewGroup, zzyd zzydVar) {
        zzbgz zzbgzVar;
        if (viewGroup == null || (zzbgzVar = this.h) == null) {
            return;
        }
        zzbgzVar.zza(zzbin.zzb(zzydVar));
        viewGroup.setMinimumHeight(zzydVar.heightPixels);
        viewGroup.setMinimumWidth(zzydVar.widthPixels);
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final zzaar getVideoController() {
        try {
            return this.j.getVideoController();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final zzcxn zzafj() {
        return this.b.zzgkd.get(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final int zzafk() {
        return this.f2989a.zzgky.zzgku.zzgkr;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void zzpm() {
        this.l.zzagx();
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void zzafl() {
        this.n.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ni

            /* renamed from: a, reason: collision with root package name */
            private final nh f2368a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2368a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2368a.a();
            }
        });
        super.zzafl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        if (this.k.zzail() != null) {
            try {
                this.k.zzail().zza(this.m.get(), ObjectWrapper.wrap(this.f));
            } catch (RemoteException e) {
                zzawz.zzc("RemoteException when notifyAdLoad is called", e);
            }
        }
    }
}
