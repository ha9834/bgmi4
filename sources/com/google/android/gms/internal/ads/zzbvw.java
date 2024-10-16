package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbvw implements zzdti<zzbvq> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> f3074a;

    private zzbvw(zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> zzdtuVar) {
        this.f3074a = zzdtuVar;
    }

    public static zzbvw zzy(zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> zzdtuVar) {
        return new zzbvw(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbvq(this.f3074a.get());
    }
}
