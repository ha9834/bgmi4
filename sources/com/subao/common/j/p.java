package com.subao.common.j;

import com.subao.common.i.d;
import com.subao.common.j.b;

/* loaded from: classes2.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    private final d.b f6088a;
    protected final int d;
    protected final int e;

    public static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    protected abstract String a();

    protected abstract void a(int i, byte[] bArr);

    protected abstract void b(int i, byte[] bArr);

    public p(d.b bVar, int i, int i2) {
        this.f6088a = bVar;
        this.d = i;
        this.e = i2;
    }

    public final void a(b.c cVar) {
        if (cVar == null) {
            d(-3, null);
        } else {
            c(cVar.f6066a, cVar.b);
        }
    }

    public final void c(int i, byte[] bArr) {
        if (!a(i)) {
            d(i, bArr);
        } else if (bArr != null) {
            a(i, bArr);
        } else {
            d(-1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(int i, byte[] bArr) {
        d.b bVar = this.f6088a;
        if (bVar != null) {
            bVar.a(a(), Integer.toString(i));
        }
        b(i, bArr);
    }

    public final void b() {
        d.b bVar = this.f6088a;
        if (bVar != null) {
            bVar.a(a(), "io");
        }
        b(-2, null);
    }

    public final void c() {
        d.b bVar = this.f6088a;
        if (bVar != null) {
            bVar.a(a(), "net");
        }
        b(-1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        d.b bVar = this.f6088a;
        if (bVar != null) {
            bVar.a(a(), "ok");
        }
    }
}
