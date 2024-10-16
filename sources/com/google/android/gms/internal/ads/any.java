package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class any extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f1995a;
    private Handler b;
    private SurfaceTexture c;
    private Error d;
    private RuntimeException e;
    private zztd f;

    public any() {
        super("dummySurface");
        this.f1995a = new int[1];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zztd a(boolean z) {
        boolean z2;
        start();
        this.b = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.b.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.f == null && this.e == null && this.d == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.e;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.d;
        if (error != null) {
            throw error;
        }
        return this.f;
    }

    public final void a() {
        this.b.sendEmptyMessage(3);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.b.sendEmptyMessage(2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0009. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int[] iArr;
        int[] iArr2;
        try {
            try {
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            Log.e("DummySurface", "Failed to release dummy surface", th2);
        } finally {
            quit();
        }
        switch (message.what) {
            case 1:
                try {
                    boolean z = message.arg1 != 0;
                    EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                    zzsk.checkState(eglGetDisplay != null, "eglGetDisplay failed");
                    int[] iArr3 = new int[2];
                    zzsk.checkState(EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1), "eglInitialize failed");
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    int[] iArr4 = new int[1];
                    zzsk.checkState(EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    if (z) {
                        iArr = new int[]{12440, 2, 12992, 1, 12344};
                    } else {
                        iArr = new int[]{12440, 2, 12344};
                    }
                    EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                    zzsk.checkState(eglCreateContext != null, "eglCreateContext failed");
                    if (z) {
                        iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                    } else {
                        iArr2 = new int[]{12375, 1, 12374, 1, 12344};
                    }
                    EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, iArr2, 0);
                    zzsk.checkState(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                    zzsk.checkState(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
                    GLES20.glGenTextures(1, this.f1995a, 0);
                    this.c = new SurfaceTexture(this.f1995a[0]);
                    this.c.setOnFrameAvailableListener(this);
                    this.f = new zztd(this, this.c, z);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e);
                    this.d = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                    this.e = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            case 2:
                this.c.updateTexImage();
                return true;
            case 3:
                try {
                    this.c.release();
                    return true;
                } finally {
                    this.f = null;
                    this.c = null;
                    GLES20.glDeleteTextures(1, this.f1995a, 0);
                }
            default:
                return true;
        }
    }
}
