package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
abstract class ed<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T a(B b);

    abstract void a(B b, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, zzdp zzdpVar);

    abstract void a(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, ep epVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(dm dmVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T b(Object obj);

    abstract void b(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, ep epVar) throws IOException;

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
    public final boolean a(B b, dm dmVar) throws IOException {
        int b2 = dmVar.b();
        int i = b2 >>> 3;
        switch (b2 & 7) {
            case 0:
                a((ed<T, B>) b, i, dmVar.g());
                return true;
            case 1:
                b(b, i, dmVar.i());
                return true;
            case 2:
                a((ed<T, B>) b, i, dmVar.n());
                return true;
            case 3:
                B a2 = a();
                int i2 = (i << 3) | 4;
                while (dmVar.a() != Integer.MAX_VALUE && a((ed<T, B>) a2, dmVar)) {
                }
                if (i2 != dmVar.b()) {
                    throw zzfi.e();
                }
                a((ed<T, B>) b, i, (int) a((ed<T, B>) a2));
                return true;
            case 4:
                return false;
            case 5:
                a((ed<T, B>) b, i, dmVar.j());
                return true;
            default:
                throw zzfi.f();
        }
    }
}
