package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* loaded from: classes2.dex */
public final class zzccw extends VideoController.VideoLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final zzbyt f3185a;

    public zzccw(zzbyt zzbytVar) {
        this.f3185a = zzbytVar;
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        zzaau a2 = a(this.f3185a);
        if (a2 == null) {
            return;
        }
        try {
            a2.onVideoStart();
        } catch (RemoteException e) {
            zzawz.zzd("Unable to call onVideoEnd()", e);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        zzaau a2 = a(this.f3185a);
        if (a2 == null) {
            return;
        }
        try {
            a2.onVideoPause();
        } catch (RemoteException e) {
            zzawz.zzd("Unable to call onVideoEnd()", e);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        zzaau a2 = a(this.f3185a);
        if (a2 == null) {
            return;
        }
        try {
            a2.onVideoEnd();
        } catch (RemoteException e) {
            zzawz.zzd("Unable to call onVideoEnd()", e);
        }
    }

    private static zzaau a(zzbyt zzbytVar) {
        zzaar videoController = zzbytVar.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzpx();
        } catch (RemoteException unused) {
            return null;
        }
    }
}
