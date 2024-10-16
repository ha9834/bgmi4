package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
/* loaded from: classes2.dex */
public final class zzbym extends zzaef {

    /* renamed from: a, reason: collision with root package name */
    private final zzbyt f3126a;

    public zzbym(zzbyt zzbytVar) {
        this.f3126a = zzbytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final float getAspectRatio() {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcwx)).booleanValue()) {
            return 0.0f;
        }
        if (this.f3126a.zzsq() != 0.0f) {
            return this.f3126a.zzsq();
        }
        if (this.f3126a.getVideoController() != null) {
            return a();
        }
        return b();
    }

    private final float a() {
        try {
            return this.f3126a.getVideoController().getAspectRatio();
        } catch (RemoteException e) {
            zzawz.zzc("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    private final float b() {
        zzadw zzadwVar = this.f3126a.getImages().get(0);
        if (zzadwVar.getWidth() != -1 && zzadwVar.getHeight() != -1) {
            return zzadwVar.getWidth() / zzadwVar.getHeight();
        }
        try {
            Drawable drawable = (Drawable) ObjectWrapper.unwrap(zzadwVar.zzrf());
            if (drawable == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
                return 0.0f;
            }
            return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } catch (RemoteException e) {
            zzawz.zzc("RemoteException getting Drawable for aspect ratio calculation.", e);
            return 0.0f;
        }
    }
}
