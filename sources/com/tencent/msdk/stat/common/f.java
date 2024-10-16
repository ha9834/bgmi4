package com.tencent.msdk.stat.common;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f6322a = !f.class.desiredAssertionStatus();

    private f() {
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        h hVar = new h(i3, new byte[(i2 * 3) / 4]);
        if (!hVar.a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (hVar.b == hVar.f6323a.length) {
            return hVar.f6323a;
        }
        byte[] bArr2 = new byte[hVar.b];
        System.arraycopy(hVar.f6323a, 0, bArr2, 0, hVar.b);
        return bArr2;
    }

    public static byte[] b(byte[] bArr, int i) {
        return b(bArr, 0, bArr.length, i);
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        i iVar = new i(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!iVar.d) {
            switch (i2 % 3) {
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (iVar.e && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (iVar.f ? 2 : 1);
        }
        iVar.f6323a = new byte[i4];
        iVar.a(bArr, i, i2, true);
        if (f6322a || iVar.b == i4) {
            return iVar.f6323a;
        }
        throw new AssertionError();
    }
}
