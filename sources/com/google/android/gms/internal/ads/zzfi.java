package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class zzfi {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3633a = "zzfi";
    private final zzdy b;
    private final String c;
    private final String d;
    private final Class<?>[] g;
    private final int e = 2;
    private volatile Method f = null;
    private CountDownLatch h = new CountDownLatch(1);

    public zzfi(zzdy zzdyVar, String str, String str2, Class<?>... clsArr) {
        this.b = zzdyVar;
        this.c = str;
        this.d = str2;
        this.g = clsArr;
        this.b.zzch().submit(new ajc(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        try {
            Class loadClass = this.b.zzci().loadClass(a(this.b.zzck(), this.c));
            if (loadClass == null) {
                return;
            }
            this.f = loadClass.getMethod(a(this.b.zzck(), this.d), this.g);
            if (this.f == null) {
            }
        } catch (zzdk unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.h.countDown();
        }
    }

    private final String a(byte[] bArr, String str) throws zzdk, UnsupportedEncodingException {
        return new String(this.b.zzcj().zza(bArr, str), "UTF-8");
    }

    public final Method zzdc() {
        if (this.f != null) {
            return this.f;
        }
        try {
            if (this.h.await(2L, TimeUnit.SECONDS)) {
                return this.f;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
