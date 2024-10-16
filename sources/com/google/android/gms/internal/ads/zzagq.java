package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzagq extends zzafv {

    /* renamed from: a, reason: collision with root package name */
    private final OnPublisherAdViewLoadedListener f2726a;

    public zzagq(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.f2726a = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafu
    public final void zza(zzzk zzzkVar, IObjectWrapper iObjectWrapper) {
        if (zzzkVar == null || iObjectWrapper == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
        try {
            if (zzzkVar.zzpp() instanceof zzxv) {
                zzxv zzxvVar = (zzxv) zzzkVar.zzpp();
                publisherAdView.setAdListener(zzxvVar != null ? zzxvVar.getAdListener() : null);
            }
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        try {
            if (zzzkVar.zzpo() instanceof zzyf) {
                zzyf zzyfVar = (zzyf) zzzkVar.zzpo();
                publisherAdView.setAppEventListener(zzyfVar != null ? zzyfVar.getAppEventListener() : null);
            }
        } catch (RemoteException e2) {
            zzbad.zzc("", e2);
        }
        zzazt.zzyr.post(new x(this, publisherAdView, zzzkVar));
    }
}
