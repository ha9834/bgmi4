package okio;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    final byte[] f7190a;
    int b;
    int c;
    boolean d;
    boolean e;
    n f;
    n g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n() {
        this.f7190a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f7190a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n a() {
        this.d = true;
        return new n(this.f7190a, this.b, this.c, true, false);
    }

    @Nullable
    public final n b() {
        n nVar = this.f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.g;
        nVar2.f = this.f;
        this.f.g = nVar2;
        this.f = null;
        this.g = null;
        return nVar;
    }

    public final n a(n nVar) {
        nVar.g = this;
        nVar.f = this.f;
        this.f.g = nVar;
        this.f = nVar;
        return nVar;
    }

    public final n a(int i) {
        n a2;
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            a2 = a();
        } else {
            a2 = o.a();
            System.arraycopy(this.f7190a, this.b, a2.f7190a, 0, i);
        }
        a2.c = a2.b + i;
        this.b += i;
        this.g.a(a2);
        return a2;
    }

    public final void c() {
        n nVar = this.g;
        if (nVar == this) {
            throw new IllegalStateException();
        }
        if (nVar.e) {
            int i = this.c - this.b;
            if (i > (8192 - nVar.c) + (nVar.d ? 0 : nVar.b)) {
                return;
            }
            a(this.g, i);
            b();
            o.a(this);
        }
    }

    public final void a(n nVar, int i) {
        if (!nVar.e) {
            throw new IllegalArgumentException();
        }
        int i2 = nVar.c;
        if (i2 + i > 8192) {
            if (nVar.d) {
                throw new IllegalArgumentException();
            }
            int i3 = nVar.b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = nVar.f7190a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            nVar.c -= nVar.b;
            nVar.b = 0;
        }
        System.arraycopy(this.f7190a, this.b, nVar.f7190a, nVar.c, i);
        nVar.c += i;
        this.b += i;
    }
}
