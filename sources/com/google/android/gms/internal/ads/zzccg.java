package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzccg extends zzagh {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f3178a;
    private final zzbyn b;
    private final zzbyt c;

    public zzccg(@Nullable String str, zzbyn zzbynVar, zzbyt zzbytVar) {
        this.f3178a = str;
        this.b = zzbynVar;
        this.c = zzbytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper zzrh() throws RemoteException {
        return ObjectWrapper.wrap(this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getHeadline() throws RemoteException {
        return this.c.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List getImages() throws RemoteException {
        return this.c.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List getMuteThisAdReasons() throws RemoteException {
        if (isCustomMuteThisAdEnabled()) {
            return this.c.getMuteThisAdReasons();
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        return (this.c.getMuteThisAdReasons().isEmpty() || this.c.zzahx() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getBody() throws RemoteException {
        return this.c.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaei zzri() throws RemoteException {
        return this.c.zzri();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getCallToAction() throws RemoteException {
        return this.c.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getAdvertiser() throws RemoteException {
        return this.c.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final double getStarRating() throws RemoteException {
        return this.c.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getStore() throws RemoteException {
        return this.c.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getPrice() throws RemoteException {
        return this.c.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void destroy() throws RemoteException {
        this.b.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaar getVideoController() throws RemoteException {
        return this.c.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void performClick(Bundle bundle) throws RemoteException {
        this.b.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.b.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.b.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaea zzrj() throws RemoteException {
        return this.c.zzrj();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper zzrk() throws RemoteException {
        return this.c.zzrk();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f3178a;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final Bundle getExtras() throws RemoteException {
        return this.c.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(zzagd zzagdVar) throws RemoteException {
        this.b.zza(zzagdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(@Nullable zzaak zzaakVar) throws RemoteException {
        this.b.zza(zzaakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(zzaag zzaagVar) throws RemoteException {
        this.b.zza(zzaagVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zzro() {
        this.b.zzro();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void recordCustomClickGesture() {
        this.b.recordCustomClickGesture();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void cancelUnconfirmedClick() throws RemoteException {
        this.b.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaee zzrp() throws RemoteException {
        return this.b.zzrp();
    }
}
