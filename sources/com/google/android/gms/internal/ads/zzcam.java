package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcam implements zzdti<zzbuz<VideoController.VideoLifecycleCallbacks>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcag f3156a;
    private final zzdtu<zzccw> b;
    private final zzdtu<Executor> c;

    public zzcam(zzcag zzcagVar, zzdtu<zzccw> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3156a = zzcagVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.b.get(), this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
