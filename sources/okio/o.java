package okio;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    static n f7191a;
    static long b;

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a() {
        synchronized (o.class) {
            if (f7191a != null) {
                n nVar = f7191a;
                f7191a = nVar.f;
                nVar.f = null;
                b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(n nVar) {
        if (nVar.f != null || nVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (nVar.d) {
            return;
        }
        synchronized (o.class) {
            if (b + 8192 > 65536) {
                return;
            }
            b += 8192;
            nVar.f = f7191a;
            nVar.c = 0;
            nVar.b = 0;
            f7191a = nVar;
        }
    }
}
