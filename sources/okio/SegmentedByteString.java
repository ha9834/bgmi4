package okio;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SegmentedByteString extends ByteString {
    final transient byte[][] e;
    final transient int[] f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentedByteString(c cVar, int i) {
        super(null);
        s.a(cVar.b, 0L, i);
        int i2 = 0;
        n nVar = cVar.f7175a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (nVar.c == nVar.b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += nVar.c - nVar.b;
            i4++;
            nVar = nVar.f;
        }
        this.e = new byte[i4];
        this.f = new int[i4 * 2];
        n nVar2 = cVar.f7175a;
        int i5 = 0;
        while (i2 < i) {
            this.e[i5] = nVar2.f7190a;
            i2 += nVar2.c - nVar2.b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f;
            iArr[i5] = i2;
            iArr[this.e.length + i5] = nVar2.b;
            nVar2.d = true;
            i5++;
            nVar2 = nVar2.f;
        }
    }

    @Override // okio.ByteString
    public String a() {
        return i().a();
    }

    @Override // okio.ByteString
    public String b() {
        return i().b();
    }

    @Override // okio.ByteString
    public String e() {
        return i().e();
    }

    @Override // okio.ByteString
    public ByteString f() {
        return i().f();
    }

    @Override // okio.ByteString
    public ByteString c() {
        return i().c();
    }

    @Override // okio.ByteString
    public ByteString d() {
        return i().d();
    }

    @Override // okio.ByteString
    public ByteString a(int i, int i2) {
        return i().a(i, i2);
    }

    @Override // okio.ByteString
    public byte a(int i) {
        s.a(this.f[this.e.length - 1], i, 1L);
        int b = b(i);
        int i2 = b == 0 ? 0 : this.f[b - 1];
        int[] iArr = this.f;
        byte[][] bArr = this.e;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.f, 0, this.e.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // okio.ByteString
    public int g() {
        return this.f[this.e.length - 1];
    }

    @Override // okio.ByteString
    public byte[] h() {
        int[] iArr = this.f;
        byte[][] bArr = this.e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.e[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // okio.ByteString
    public void a(c cVar) {
        int length = this.e.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            n nVar = new n(this.e[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.f7175a == null) {
                nVar.g = nVar;
                nVar.f = nVar;
                cVar.f7175a = nVar;
            } else {
                cVar.f7175a.g.a(nVar);
            }
            i++;
            i2 = i4;
        }
        cVar.b += i2;
    }

    @Override // okio.ByteString
    public boolean a(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > g() - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.f[b - 1];
            int min = Math.min(i3, ((this.f[b] - i4) + i4) - i);
            int[] iArr = this.f;
            byte[][] bArr = this.e;
            if (!byteString.a(i2, bArr[b], (i - i4) + iArr[bArr.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.f[b - 1];
            int min = Math.min(i3, ((this.f[b] - i4) + i4) - i);
            int[] iArr = this.f;
            byte[][] bArr2 = this.e;
            if (!s.a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    private ByteString i() {
        return new ByteString(h());
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.g() == g() && a(0, byteString, 0, g())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int length = this.e.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.e[i2];
            int[] iArr = this.f;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.c = i3;
        return i3;
    }

    @Override // okio.ByteString
    public String toString() {
        return i().toString();
    }

    private Object writeReplace() {
        return i();
    }
}
