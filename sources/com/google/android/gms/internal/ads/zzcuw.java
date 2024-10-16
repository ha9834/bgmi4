package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcuw implements zzcva<zzcuv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3452a;
    private final Context b;
    private final zzbai c;

    public zzcuw(zzbbl zzbblVar, Context context, zzbai zzbaiVar) {
        this.f3452a = zzbblVar;
        this.b = context;
        this.c = zzbaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuv> zzalm() {
        return this.f3452a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zh

            /* renamed from: a, reason: collision with root package name */
            private final zzcuw f2661a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2661a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2661a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcuv a() throws Exception {
        boolean isCallerInstantApp = Wrappers.packageManager(this.b).isCallerInstantApp();
        zzk.zzlg();
        boolean zzau = zzaxi.zzau(this.b);
        String str = this.c.zzbsx;
        zzk.zzli();
        boolean zzwh = zzaxo.zzwh();
        zzk.zzlg();
        return new zzcuv(isCallerInstantApp, zzau, str, zzwh, zzaxi.zzar(this.b), DynamiteModule.getRemoteVersion(this.b, ModuleDescriptor.MODULE_ID));
    }
}
