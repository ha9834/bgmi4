package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.tencent.imsdk.android.tools.log.LogUtils;

/* loaded from: classes2.dex */
public final class zzcsm implements zzdti<zzcsk<zzcsg>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcsh> f3412a;
    private final zzdtu<Clock> b;

    public zzcsm(zzdtu<zzcsh> zzdtuVar, zzdtu<Clock> zzdtuVar2) {
        this.f3412a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcsk) zzdto.zza(new zzcsk(this.f3412a.get(), LogUtils.LOG_FUSE_TIME, this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
