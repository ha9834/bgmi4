package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@zzard
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbdd extends Thread implements SurfaceTexture.OnFrameAvailableListener, in {

    /* renamed from: a, reason: collision with root package name */
    private static final float[] f2858a = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean A;
    private volatile boolean B;
    private final il b;
    private final float[] c;
    private final float[] d;
    private final float[] e;
    private final float[] f;
    private final float[] g;
    private final float[] h;
    private final float[] i;
    private float j;
    private float k;
    private float l;
    private int m;
    private int n;
    private SurfaceTexture o;
    private SurfaceTexture p;
    private int q;
    private int r;
    private int s;
    private FloatBuffer t;
    private final CountDownLatch u;
    private final Object v;
    private EGL10 w;
    private EGLDisplay x;
    private EGLContext y;
    private EGLSurface z;

    public zzbdd(Context context) {
        super("SphericalVideoProcessor");
        this.t = ByteBuffer.allocateDirect(f2858a.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.t.put(f2858a).position(0);
        this.c = new float[9];
        this.d = new float[9];
        this.e = new float[9];
        this.f = new float[9];
        this.g = new float[9];
        this.h = new float[9];
        this.i = new float[9];
        this.j = Float.NaN;
        this.b = new il(context);
        this.b.a(this);
        this.u = new CountDownLatch(1);
        this.v = new Object();
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.n = i;
        this.m = i2;
        this.p = surfaceTexture;
    }

    public final void zzm(int i, int i2) {
        synchronized (this.v) {
            this.n = i;
            this.m = i2;
            this.A = true;
            this.v.notifyAll();
        }
    }

    public final void zzxx() {
        synchronized (this.v) {
            this.B = true;
            this.p = null;
            this.v.notifyAll();
        }
    }

    public final SurfaceTexture zzxy() {
        if (this.p == null) {
            return null;
        }
        try {
            this.u.await();
        } catch (InterruptedException unused) {
        }
        return this.o;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.s++;
        synchronized (this.v) {
            this.v.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.in
    public final void zztk() {
        synchronized (this.v) {
            this.v.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z;
        int glCreateProgram;
        if (this.p == null) {
            zzawz.zzen("SphericalVideoProcessor started with no output texture.");
            this.u.countDown();
            return;
        }
        this.w = (EGL10) EGLContext.getEGL();
        this.x = this.w.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.x == EGL10.EGL_NO_DISPLAY) {
            z = false;
        } else if (this.w.eglInitialize(this.x, new int[2])) {
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGLConfig eGLConfig = (!this.w.eglChooseConfig(this.x, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) || iArr[0] <= 0) ? null : eGLConfigArr[0];
            if (eGLConfig == null) {
                z = false;
            } else {
                this.y = this.w.eglCreateContext(this.x, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                EGLContext eGLContext = this.y;
                if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                    z = false;
                } else {
                    this.z = this.w.eglCreateWindowSurface(this.x, eGLConfig, this.p, null);
                    EGLSurface eGLSurface = this.z;
                    if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                        z = false;
                    } else {
                        EGL10 egl10 = this.w;
                        EGLDisplay eGLDisplay = this.x;
                        EGLSurface eGLSurface2 = this.z;
                        z = egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.y);
                    }
                }
            }
        } else {
            z = false;
        }
        zzacj<String> zzacjVar = zzacu.zzcqe;
        int a2 = a(35633, !((String) zzyt.zzpe().zzd(zzacjVar)).equals(zzacjVar.zzqm()) ? (String) zzyt.zzpe().zzd(zzacjVar) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
        if (a2 == 0) {
            glCreateProgram = 0;
        } else {
            zzacj<String> zzacjVar2 = zzacu.zzcqf;
            int a3 = a(35632, !((String) zzyt.zzpe().zzd(zzacjVar2)).equals(zzacjVar2.zzqm()) ? (String) zzyt.zzpe().zzd(zzacjVar2) : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}");
            if (a3 == 0) {
                glCreateProgram = 0;
            } else {
                glCreateProgram = GLES20.glCreateProgram();
                a("createProgram");
                if (glCreateProgram != 0) {
                    GLES20.glAttachShader(glCreateProgram, a2);
                    a("attachShader");
                    GLES20.glAttachShader(glCreateProgram, a3);
                    a("attachShader");
                    GLES20.glLinkProgram(glCreateProgram);
                    a("linkProgram");
                    int[] iArr2 = new int[1];
                    GLES20.glGetProgramiv(glCreateProgram, 35714, iArr2, 0);
                    a("getProgramiv");
                    if (iArr2[0] != 1) {
                        Log.e("SphericalVideoRenderer", "Could not link program: ");
                        Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(glCreateProgram));
                        GLES20.glDeleteProgram(glCreateProgram);
                        a("deleteProgram");
                        glCreateProgram = 0;
                    } else {
                        GLES20.glValidateProgram(glCreateProgram);
                        a("validateProgram");
                    }
                }
            }
        }
        this.q = glCreateProgram;
        GLES20.glUseProgram(this.q);
        a("useProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.q, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, (Buffer) this.t);
        a("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        a("enableVertexAttribArray");
        int[] iArr3 = new int[1];
        GLES20.glGenTextures(1, iArr3, 0);
        a("genTextures");
        int i = iArr3[0];
        GLES20.glBindTexture(36197, i);
        a("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        a("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        a("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        a("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        a("texParameteri");
        this.r = GLES20.glGetUniformLocation(this.q, "uVMat");
        GLES20.glUniformMatrix3fv(this.r, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        boolean z2 = this.q != 0;
        if (!z || !z2) {
            String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.w.eglGetError()));
            String concat = valueOf.length() != 0 ? "EGL initialization failed: ".concat(valueOf) : new String("EGL initialization failed: ");
            zzawz.zzen(concat);
            zzk.zzlk().zza(new Throwable(concat), "SphericalVideoProcessor.run.1");
            a();
            this.u.countDown();
            return;
        }
        this.o = new SurfaceTexture(i);
        this.o.setOnFrameAvailableListener(this);
        this.u.countDown();
        this.b.a();
        try {
            this.A = true;
            while (!this.B) {
                while (this.s > 0) {
                    this.o.updateTexImage();
                    this.s--;
                }
                if (this.b.a(this.c)) {
                    if (Float.isNaN(this.j)) {
                        float[] fArr = this.c;
                        float[] fArr2 = {0.0f, 1.0f, 0.0f};
                        float[] fArr3 = {(fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]), (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[5] * fArr2[2]), (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1]) + (fArr[8] * fArr2[2])};
                        this.j = -(((float) Math.atan2(fArr3[1], fArr3[0])) - 1.5707964f);
                    }
                    b(this.h, this.j + this.k);
                } else {
                    a(this.c, -1.5707964f);
                    b(this.h, this.k);
                }
                a(this.d, 1.5707964f);
                a(this.e, this.h, this.d);
                a(this.f, this.c, this.e);
                a(this.g, this.l);
                a(this.i, this.g, this.f);
                GLES20.glUniformMatrix3fv(this.r, 1, false, this.i, 0);
                GLES20.glDrawArrays(5, 0, 4);
                a("drawArrays");
                GLES20.glFinish();
                this.w.eglSwapBuffers(this.x, this.z);
                if (this.A) {
                    GLES20.glViewport(0, 0, this.n, this.m);
                    a("viewport");
                    int glGetUniformLocation = GLES20.glGetUniformLocation(this.q, "uFOVx");
                    int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.q, "uFOVy");
                    if (this.n > this.m) {
                        GLES20.glUniform1f(glGetUniformLocation, 0.87266463f);
                        GLES20.glUniform1f(glGetUniformLocation2, (this.m * 0.87266463f) / this.n);
                    } else {
                        GLES20.glUniform1f(glGetUniformLocation, (this.n * 0.87266463f) / this.m);
                        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
                    }
                    this.A = false;
                }
                try {
                    synchronized (this.v) {
                        if (!this.B && !this.A && this.s == 0) {
                            this.v.wait();
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
        } catch (IllegalStateException unused2) {
            zzawz.zzep("SphericalVideoProcessor halted unexpectedly.");
        } catch (Throwable th) {
            zzawz.zzc("SphericalVideoProcessor died.", th);
            zzk.zzlk().zza(th, "SphericalVideoProcessor.run.2");
        } finally {
            this.b.b();
            this.o.setOnFrameAvailableListener(null);
            this.o = null;
            a();
        }
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        int i = this.n;
        int i2 = this.m;
        if (i > i2) {
            f3 = (f * 1.7453293f) / i;
            f4 = (f2 * 1.7453293f) / i;
        } else {
            f3 = (f * 1.7453293f) / i2;
            f4 = (f2 * 1.7453293f) / i2;
        }
        this.k -= f3;
        this.l -= f4;
        if (this.l < -1.5707964f) {
            this.l = -1.5707964f;
        }
        if (this.l > 1.5707964f) {
            this.l = 1.5707964f;
        }
    }

    private static void a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static void b(float[] fArr, float f) {
        double d = f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        a("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        a("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        a("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        a("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(CertificateUtil.DELIMITER);
        Log.e("SphericalVideoRenderer", sb.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        a("deleteShader");
        return 0;
    }

    @VisibleForTesting
    private final boolean a() {
        EGLSurface eGLSurface = this.z;
        boolean z = false;
        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
            z = this.w.eglDestroySurface(this.x, this.z) | this.w.eglMakeCurrent(this.x, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false;
            this.z = null;
        }
        EGLContext eGLContext = this.y;
        if (eGLContext != null) {
            z |= this.w.eglDestroyContext(this.x, eGLContext);
            this.y = null;
        }
        EGLDisplay eGLDisplay = this.x;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.w.eglTerminate(eGLDisplay);
        this.x = null;
        return eglTerminate;
    }

    private static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }
}
