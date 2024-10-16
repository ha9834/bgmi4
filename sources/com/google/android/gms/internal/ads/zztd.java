package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
/* loaded from: classes2.dex */
public final class zztd extends Surface {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3743a;
    private static boolean b;
    private final boolean c;
    private final any d;
    private boolean e;

    public static synchronized boolean zzc(Context context) {
        boolean z;
        synchronized (zztd.class) {
            if (!b) {
                if (zzsy.SDK_INT >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (!(zzsy.SDK_INT == 24 && (zzsy.MODEL.startsWith("SM-G950") || zzsy.MODEL.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    f3743a = z2;
                }
                b = true;
            }
            z = f3743a;
        }
        return z;
    }

    public static zztd zzc(Context context, boolean z) {
        if (zzsy.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
        zzsk.checkState(!z || zzc(context));
        return new any().a(z);
    }

    private zztd(any anyVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.d = anyVar;
        this.c = z;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.d) {
            if (!this.e) {
                this.d.a();
                this.e = true;
            }
        }
    }
}
