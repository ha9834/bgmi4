package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzbvq extends zzbts<VideoController.VideoLifecycleCallbacks> {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f3073a;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbvq(Set<zzbuz<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoPause() {
        a(po.f2420a);
    }

    public final void onVideoEnd() {
        a(pp.f2421a);
    }

    public final synchronized void onVideoStart() {
        a(pq.f2422a);
        this.f3073a = true;
    }

    public final synchronized void onVideoPlay() {
        if (!this.f3073a) {
            a(pr.f2423a);
            this.f3073a = true;
        }
        a(ps.f2424a);
    }
}
