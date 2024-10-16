package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcbz extends zzaex {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f3171a;
    private final zzbyn b;
    private final zzbyt c;

    public zzcbz(@Nullable String str, zzbyn zzbynVar, zzbyt zzbytVar) {
        this.f3171a = str;
        this.b = zzbynVar;
        this.c = zzbytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzrh() throws RemoteException {
        return ObjectWrapper.wrap(this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getHeadline() throws RemoteException {
        return this.c.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final List getImages() throws RemoteException {
        return this.c.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getBody() throws RemoteException {
        return this.c.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzaei zzri() throws RemoteException {
        return this.c.zzri();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getCallToAction() throws RemoteException {
        return this.c.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final double getStarRating() throws RemoteException {
        return this.c.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getStore() throws RemoteException {
        return this.c.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getPrice() throws RemoteException {
        return this.c.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final Bundle getExtras() throws RemoteException {
        return this.c.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void destroy() throws RemoteException {
        this.b.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzaar getVideoController() throws RemoteException {
        return this.c.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void performClick(Bundle bundle) throws RemoteException {
        this.b.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.b.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.b.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzaea zzrj() throws RemoteException {
        return this.c.zzrj();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzrk() throws RemoteException {
        return this.c.zzrk();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f3171a;
    }
}
