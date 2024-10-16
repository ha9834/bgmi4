package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzdth<T> implements zzdte<T>, zzdtu<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3619a = new Object();
    private volatile zzdtu<T> b;
    private volatile Object c = f3619a;

    private zzdth(zzdtu<T> zzdtuVar) {
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdte, com.google.android.gms.internal.ads.zzdtu
    public final T get() {
        T t = (T) this.c;
        if (t == f3619a) {
            synchronized (this) {
                t = (T) this.c;
                if (t == f3619a) {
                    t = this.b.get();
                    Object obj = this.c;
                    if (((obj == f3619a || (obj instanceof zzdtn)) ? false : true) && obj != t) {
                        String valueOf = String.valueOf(obj);
                        String valueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(valueOf);
                        sb.append(" & ");
                        sb.append(valueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.c = t;
                    this.b = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzdtu<T>, T> zzdtu<T> zzao(P p) {
        zzdto.checkNotNull(p);
        return p instanceof zzdth ? p : new zzdth(p);
    }

    public static <P extends zzdtu<T>, T> zzdte<T> zzap(P p) {
        if (p instanceof zzdte) {
            return (zzdte) p;
        }
        return new zzdth((zzdtu) zzdto.checkNotNull(p));
    }
}
