package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
/* loaded from: classes2.dex */
public final class zzadk implements CustomRenderedAd {

    /* renamed from: a, reason: collision with root package name */
    private final zzadl f2708a;

    public zzadk(zzadl zzadlVar) {
        this.f2708a = zzadlVar;
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final String getBaseUrl() {
        try {
            return this.f2708a.zzqz();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final String getContent() {
        try {
            return this.f2708a.getContent();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void onAdRendered(View view) {
        try {
            this.f2708a.zzo(view != null ? ObjectWrapper.wrap(view) : null);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void recordClick() {
        try {
            this.f2708a.recordClick();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void recordImpression() {
        try {
            this.f2708a.recordImpression();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
