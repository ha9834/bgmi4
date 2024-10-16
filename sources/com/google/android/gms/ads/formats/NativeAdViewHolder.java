package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbql = new WeakHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private zzaer f1139a;
    private WeakReference<View> b;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzbad.zzen("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
            return;
        }
        if (zzbql.get(view) != null) {
            zzbad.zzen("The provided containerView is already in use with another NativeAdViewHolder.");
            return;
        }
        zzbql.put(view, this);
        this.b = new WeakReference<>(view);
        this.f1139a = zzyt.zzpb().zza(view, a(map), a(map2));
    }

    private static HashMap<String, View> a(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        a((IObjectWrapper) nativeAd.a());
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        a((IObjectWrapper) unifiedNativeAd.a());
    }

    private final void a(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.b;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            zzbad.zzep("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbql.containsKey(view)) {
            zzbql.put(view, this);
        }
        zzaer zzaerVar = this.f1139a;
        if (zzaerVar != null) {
            try {
                zzaerVar.zze(iObjectWrapper);
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void unregisterNativeAd() {
        zzaer zzaerVar = this.f1139a;
        if (zzaerVar != null) {
            try {
                zzaerVar.unregisterNativeAd();
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.b;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            zzbql.remove(view);
        }
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.f1139a.zzi(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }
}
