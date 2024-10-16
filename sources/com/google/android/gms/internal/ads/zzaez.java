package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzaez extends NativeAppInstallAd {

    /* renamed from: a, reason: collision with root package name */
    private final zzaew f2716a;
    private final zzael c;
    private final NativeAd.AdChoicesInfo e;
    private final List<NativeAd.Image> b = new ArrayList();
    private final VideoController d = new VideoController();

    public zzaez(zzaew zzaewVar) {
        zzael zzaelVar;
        zzaei zzaeiVar;
        IBinder iBinder;
        this.f2716a = zzaewVar;
        zzaed zzaedVar = null;
        try {
            List images = this.f2716a.getImages();
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
            zzaei zzri = this.f2716a.zzri();
            zzaelVar = zzri != null ? new zzael(zzri) : null;
        } catch (RemoteException e2) {
            zzbad.zzc("", e2);
            zzaelVar = null;
        }
        this.c = zzaelVar;
        try {
            if (this.f2716a.zzrj() != null) {
                zzaedVar = new zzaed(this.f2716a.zzrj());
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
            return this.f2716a.zzrh();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.f2716a.performClick(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.f2716a.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.f2716a.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getHeadline() {
        try {
            return this.f2716a.getHeadline();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final List<NativeAd.Image> getImages() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getBody() {
        try {
            return this.f2716a.getBody();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.Image getIcon() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getCallToAction() {
        try {
            return this.f2716a.getCallToAction();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Double getStarRating() {
        try {
            double starRating = this.f2716a.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getStore() {
        try {
            return this.f2716a.getStore();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getPrice() {
        try {
            return this.f2716a.getPrice();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final VideoController getVideoController() {
        try {
            if (this.f2716a.getVideoController() != null) {
                this.d.zza(this.f2716a.getVideoController());
            }
        } catch (RemoteException e) {
            zzbad.zzc("Exception occurred while getting video controller", e);
        }
        return this.d;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.f2716a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Bundle getExtras() {
        try {
            return this.f2716a.getExtras();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final void destroy() {
        try {
            this.f2716a.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
