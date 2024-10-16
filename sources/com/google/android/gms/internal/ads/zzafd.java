package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzafd extends NativeContentAd {

    /* renamed from: a, reason: collision with root package name */
    private final zzafa f2717a;
    private final zzael c;
    private final NativeAd.AdChoicesInfo e;
    private final List<NativeAd.Image> b = new ArrayList();
    private final VideoController d = new VideoController();

    public zzafd(zzafa zzafaVar) {
        zzael zzaelVar;
        zzaei zzaeiVar;
        IBinder iBinder;
        this.f2717a = zzafaVar;
        zzaed zzaedVar = null;
        try {
            List images = this.f2717a.getImages();
            if (images != null) {
                for (Object obj : images) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzaeiVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        if (queryLocalInterface instanceof zzaei) {
                            zzaeiVar = (zzaei) queryLocalInterface;
                        } else {
                            zzaeiVar = new zzaek(iBinder);
                        }
                    }
                    if (zzaeiVar != null) {
                        this.b.add(new zzael(zzaeiVar));
                    }
                }
            }
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        try {
            zzaei zzrl = this.f2717a.zzrl();
            zzaelVar = zzrl != null ? new zzael(zzrl) : null;
        } catch (RemoteException e2) {
            zzbad.zzc("", e2);
            zzaelVar = null;
        }
        this.c = zzaelVar;
        try {
            if (this.f2717a.zzrj() != null) {
                zzaedVar = new zzaed(this.f2717a.zzrj());
            }
        } catch (RemoteException e3) {
            zzbad.zzc("", e3);
        }
        this.e = zzaedVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.NativeAd
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper a() {
        try {
            return this.f2717a.zzrh();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.f2717a.performClick(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.f2717a.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.f2717a.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getHeadline() {
        try {
            return this.f2717a.getHeadline();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final List<NativeAd.Image> getImages() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getBody() {
        try {
            return this.f2717a.getBody();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.Image getLogo() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getCallToAction() {
        try {
            return this.f2717a.getCallToAction();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getAdvertiser() {
        try {
            return this.f2717a.getAdvertiser();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final VideoController getVideoController() {
        try {
            if (this.f2717a.getVideoController() != null) {
                this.d.zza(this.f2717a.getVideoController());
            }
        } catch (RemoteException e) {
            zzbad.zzc("Exception occurred while getting video controller", e);
        }
        return this.d;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final Bundle getExtras() {
        try {
            return this.f2717a.getExtras();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.f2717a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final void destroy() {
        try {
            this.f2717a.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
