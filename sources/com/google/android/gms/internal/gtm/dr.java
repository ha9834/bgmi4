package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
abstract class dr<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T a(B b);

    abstract void a(B b, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, zzps zzpsVar);

    abstract void a(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, ed edVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(cz czVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T b(Object obj);

    abstract void b(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, ed edVar) throws IOException;

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
    public final boolean a(B b, cz czVar) throws IOException {
        int b2 = czVar.b();
        int i = b2 >>> 3;
        switch (b2 & 7) {
            case 0:
                a((dr<T, B>) b, i, czVar.g());
                return true;
            case 1:
                b(b, i, czVar.i());
                return true;
            case 2:
                a((dr<T, B>) b, i, czVar.n());
                return true;
            case 3:
                B a2 = a();
                int i2 = (i << 3) | 4;
                while (czVar.a() != Integer.MAX_VALUE && a((dr<T, B>) a2, czVar)) {
                }
                if (i2 != czVar.b()) {
                    throw zzrk.d();
                }
                a((dr<T, B>) b, i, (int) a((dr<T, B>) a2));
                return true;
            case 4:
                return false;
            case 5:
                a((dr<T, B>) b, i, czVar.j());
                return true;
            default:
                throw zzrk.e();
        }
    }
}
