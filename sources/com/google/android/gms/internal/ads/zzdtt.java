package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzdtt<T> implements zzdtu<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3626a = new Object();
    private volatile zzdtu<T> b;
    private volatile Object c = f3626a;

    private zzdtt(zzdtu<T> zzdtuVar) {
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final T get() {
        T t = (T) this.c;
        if (t != f3626a) {
            return t;
        }
        zzdtu<T> zzdtuVar = this.b;
        if (zzdtuVar == null) {
            return (T) this.c;
        }
        T t2 = zzdtuVar.get();
        this.c = t2;
        this.b = null;
        return t2;
    }

    public static <P extends zzdtu<T>, T> zzdtu<T> zzao(P p) {
        return ((p instanceof zzdtt) || (p instanceof zzdth)) ? p : new zzdtt((zzdtu) zzdto.checkNotNull(p));
    }
}
