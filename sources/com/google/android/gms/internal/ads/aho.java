package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
abstract class aho<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T a(B b);

    abstract void a(B b, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, zzdmr zzdmrVar);

    abstract void a(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, aib aibVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(agw agwVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T b(Object obj);

    abstract void b(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, aib aibVar) throws IOException;

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
    public final boolean a(B b, agw agwVar) throws IOException {
        int b2 = agwVar.b();
        int i = b2 >>> 3;
        switch (b2 & 7) {
            case 0:
                a((aho<T, B>) b, i, agwVar.g());
                return true;
            case 1:
                b(b, i, agwVar.i());
                return true;
            case 2:
                a((aho<T, B>) b, i, agwVar.n());
                return true;
            case 3:
                B a2 = a();
                int i2 = (i << 3) | 4;
                while (agwVar.a() != Integer.MAX_VALUE && a((aho<T, B>) a2, agwVar)) {
                }
                if (i2 != agwVar.b()) {
                    throw zzdok.e();
                }
                a((aho<T, B>) b, i, (int) a((aho<T, B>) a2));
                return true;
            case 4:
                return false;
            case 5:
                a((aho<T, B>) b, i, agwVar.j());
                return true;
            default:
                throw zzdok.f();
        }
    }
}
