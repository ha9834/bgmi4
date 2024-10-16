package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
/* loaded from: classes2.dex */
public final class zzael extends NativeAd.Image {

    /* renamed from: a, reason: collision with root package name */
    private final zzaei f2715a;
    private final Drawable b;
    private final Uri c;
    private final double d;
    private final int e;
    private final int f;

    public zzael(zzaei zzaeiVar) {
        Drawable drawable;
        int i;
        this.f2715a = zzaeiVar;
        Uri uri = null;
        try {
            IObjectWrapper zzrf = this.f2715a.zzrf();
            drawable = zzrf != null ? (Drawable) ObjectWrapper.unwrap(zzrf) : null;
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            drawable = null;
        }
        this.b = drawable;
        try {
            uri = this.f2715a.getUri();
        } catch (RemoteException e2) {
            zzbad.zzc("", e2);
        }
        this.c = uri;
        double d = 1.0d;
        try {
            d = this.f2715a.getScale();
        } catch (RemoteException e3) {
            zzbad.zzc("", e3);
        }
        this.d = d;
        int i2 = -1;
        try {
            i = this.f2715a.getWidth();
        } catch (RemoteException e4) {
            zzbad.zzc("", e4);
            i = -1;
        }
        this.e = i;
        try {
            i2 = this.f2715a.getHeight();
        } catch (RemoteException e5) {
            zzbad.zzc("", e5);
        }
        this.f = i2;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.d;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getWidth() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getHeight() {
        return this.f;
    }
}
