package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import java.util.WeakHashMap;

@zzard
/* loaded from: classes2.dex */
public final class zzafh implements NativeCustomTemplateAd {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap<IBinder, zzafh> f2718a = new WeakHashMap<>();
    private final zzafe b;
    private final MediaView c;
    private final VideoController d = new VideoController();

    @VisibleForTesting
    private zzafh(zzafe zzafeVar) {
        Context context;
        this.b = zzafeVar;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzafeVar.zzrm());
        } catch (RemoteException | NullPointerException e) {
            zzbad.zzc("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.b.zzp(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzbad.zzc("", e2);
            }
        }
        this.c = mediaView;
    }

    public static zzafh zza(zzafe zzafeVar) {
        synchronized (f2718a) {
            zzafh zzafhVar = f2718a.get(zzafeVar.asBinder());
            if (zzafhVar != null) {
                return zzafhVar;
            }
            zzafh zzafhVar2 = new zzafh(zzafeVar);
            f2718a.put(zzafeVar.asBinder(), zzafhVar2);
            return zzafhVar2;
        }
    }

    public final zzafe zzrn() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final CharSequence getText(String str) {
        try {
            return this.b.zzcj(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeAd.Image getImage(String str) {
        try {
            zzaei zzck = this.b.zzck(str);
            if (zzck != null) {
                return new zzael(zzck);
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final VideoController getVideoController() {
        try {
            zzaar videoController = this.b.getVideoController();
            if (videoController != null) {
                this.d.zza(videoController);
            }
        } catch (RemoteException e) {
            zzbad.zzc("Exception occurred while getting video controller", e);
        }
        return this.d;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final MediaView getVideoMediaView() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final List<String> getAvailableAssetNames() {
        try {
            return this.b.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final String getCustomTemplateId() {
        try {
            return this.b.getCustomTemplateId();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void performClick(String str) {
        try {
            this.b.performClick(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void recordImpression() {
        try {
            this.b.recordImpression();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void destroy() {
        try {
            this.b.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
