package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzagj extends UnifiedNativeAd {

    /* renamed from: a, reason: collision with root package name */
    private final zzagg f2721a;
    private final zzael c;
    private final NativeAd.AdChoicesInfo e;
    private final UnifiedNativeAd.zza g;
    private final List<NativeAd.Image> b = new ArrayList();
    private final VideoController d = new VideoController();
    private final List<MuteThisAdReason> f = new ArrayList();

    public zzagj(zzagg zzaggVar) {
        zzael zzaelVar;
        zzaed zzaedVar;
        zzaei zzaeiVar;
        IBinder iBinder;
        this.f2721a = zzaggVar;
        zzaeh zzaehVar = null;
        try {
            List images = this.f2721a.getImages();
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
            List muteThisAdReasons = this.f2721a.getMuteThisAdReasons();
            if (muteThisAdReasons != null) {
                for (Object obj2 : muteThisAdReasons) {
                    zzaak zzf = obj2 instanceof IBinder ? zzaal.zzf((IBinder) obj2) : null;
                    if (zzf != null) {
                        this.f.add(new zzaan(zzf));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzbad.zzc("", e2);
        }
        try {
            zzaei zzri = this.f2721a.zzri();
            zzaelVar = zzri != null ? new zzael(zzri) : null;
        } catch (RemoteException e3) {
            zzbad.zzc("", e3);
            zzaelVar = null;
        }
        this.c = zzaelVar;
        try {
            zzaedVar = this.f2721a.zzrj() != null ? new zzaed(this.f2721a.zzrj()) : null;
        } catch (RemoteException e4) {
            zzbad.zzc("", e4);
            zzaedVar = null;
        }
        this.e = zzaedVar;
        try {
            if (this.f2721a.zzrp() != null) {
                zzaehVar = new zzaeh(this.f2721a.zzrp());
            }
        } catch (RemoteException e5) {
            zzbad.zzc("", e5);
        }
        this.g = zzaehVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper a() {
        try {
            return this.f2721a.zzrh();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzkv() {
        try {
            IObjectWrapper zzrk = this.f2721a.zzrk();
            if (zzrk != null) {
                return ObjectWrapper.unwrap(zzrk);
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.f2721a.performClick(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.f2721a.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.f2721a.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.f2721a.getHeadline();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.f2721a.getBody();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.f2721a.getCallToAction();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double getStarRating() {
        try {
            double starRating = this.f2721a.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.f2721a.getStore();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.f2721a.getPrice();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.f2721a.getVideoController() != null) {
                this.d.zza(this.f2721a.getVideoController());
            }
        } catch (RemoteException e) {
            zzbad.zzc("Exception occurred while getting video controller", e);
        }
        return this.d;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.f2721a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.f2721a.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.f2721a.zzro();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.f2721a.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.f;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.f2721a.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.f2721a.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.f2721a.zza(new zzagt(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzbad.zzc("Failed to setUnconfirmedClickListener", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbad.zzen("Ad is not custom mute enabled");
                return;
            }
            if (muteThisAdReason == null) {
                this.f2721a.zza((zzaak) null);
            } else if (muteThisAdReason instanceof zzaan) {
                this.f2721a.zza(((zzaan) muteThisAdReason).zzpu());
            } else {
                zzbad.zzen("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.f2721a.zza(new zzaaj(muteThisAdListener));
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.f2721a.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzbad.zzc("Failed to cancelUnconfirmedClick", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.f2721a.getAdvertiser();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }
}
