package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
/* loaded from: classes2.dex */
public final class zzadw extends zzaej {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f2712a;
    private final Uri b;
    private final double c;
    private final int d;
    private final int e;

    public zzadw(Drawable drawable, Uri uri, double d, int i, int i2) {
        this.f2712a = drawable;
        this.b = uri;
        this.c = d;
        this.d = i;
        this.e = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final IObjectWrapper zzrf() throws RemoteException {
        return ObjectWrapper.wrap(this.f2712a);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final Uri getUri() throws RemoteException {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final double getScale() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getWidth() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getHeight() {
        return this.e;
    }
}
