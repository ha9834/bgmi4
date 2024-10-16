package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
abstract class ec<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T a(B b);

    abstract void a(B b, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, zzfx zzfxVar);

    abstract void a(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, eo eoVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(dj djVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T b(Object obj);

    abstract void b(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, eo eoVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B c(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(B b, dj djVar) throws IOException {
        int b2 = djVar.b();
        int i = b2 >>> 3;
        switch (b2 & 7) {
            case 0:
                a((ec<T, B>) b, i, djVar.g());
                return true;
            case 1:
                b(b, i, djVar.i());
                return true;
            case 2:
                a((ec<T, B>) b, i, djVar.n());
                return true;
            case 3:
                B a2 = a();
                int i2 = (i << 3) | 4;
                while (djVar.a() != Integer.MAX_VALUE && a((ec<T, B>) a2, djVar)) {
                }
                if (i2 != djVar.b()) {
                    throw zzhm.e();
                }
                a((ec<T, B>) b, i, (int) a((ec<T, B>) a2));
                return true;
            case 4:
                return false;
            case 5:
                a((ec<T, B>) b, i, djVar.j());
                return true;
            default:
                throw zzhm.f();
        }
    }
}