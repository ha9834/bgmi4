package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzil {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f4573a;
    private final int c;
    private int d;
    private int e;
    private int g;
    private int i;
    private zzeb l;
    private int h = Integer.MAX_VALUE;
    private int j = 64;
    private int k = 67108864;
    private final int b = 0;
    private int f = 0;

    public static zzil zzj(byte[] bArr, int i, int i2) {
        return new zzil(bArr, 0, i2);
    }

    public final int zzsg() throws IOException {
        if (this.f == this.d) {
            this.g = 0;
            return 0;
        }
        this.g = zzta();
        int i = this.g;
        if (i != 0) {
            return i;
        }
        throw new zzit("Protocol message contained an invalid tag (zero).");
    }

    private final void a(int i) throws zzit {
        if (this.g != i) {
            throw new zzit("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzau(int i) throws IOException {
        int zzsg;
        switch (i & 7) {
            case 0:
                zzta();
                return true;
            case 1:
                b();
                b();
                b();
                b();
                b();
                b();
                b();
                b();
                return true;
            case 2:
                b(zzta());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                b();
                b();
                b();
                b();
                return true;
            default:
                throw new zzit("Protocol message tag had invalid wire type.");
        }
        do {
            zzsg = zzsg();
            if (zzsg != 0) {
            }
            a(((i >>> 3) << 3) | 4);
            return true;
        } while (zzau(zzsg));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final boolean zzsm() throws IOException {
        return zzta() != 0;
    }

    public final String readString() throws IOException {
        int zzta = zzta();
        if (zzta < 0) {
            throw zzit.b();
        }
        int i = this.d;
        int i2 = this.f;
        if (zzta > i - i2) {
            throw zzit.a();
        }
        String str = new String(this.f4573a, i2, zzta, zziu.f4578a);
        this.f += zzta;
        return str;
    }

    public final void zza(zziw zziwVar) throws IOException {
        int zzta = zzta();
        if (this.i >= this.j) {
            throw new zzit("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        if (zzta < 0) {
            throw zzit.b();
        }
        int i = zzta + this.f;
        int i2 = this.h;
        if (i > i2) {
            throw zzit.a();
        }
        this.h = i;
        a();
        this.i++;
        zziwVar.zza(this);
        a(0);
        this.i--;
        this.h = i2;
        a();
    }

    public final int zzta() throws IOException {
        byte b = b();
        if (b >= 0) {
            return b;
        }
        int i = b & Byte.MAX_VALUE;
        byte b2 = b();
        if (b2 >= 0) {
            return i | (b2 << 7);
        }
        int i2 = i | ((b2 & Byte.MAX_VALUE) << 7);
        byte b3 = b();
        if (b3 >= 0) {
            return i2 | (b3 << 14);
        }
        int i3 = i2 | ((b3 & Byte.MAX_VALUE) << 14);
        byte b4 = b();
        if (b4 >= 0) {
            return i3 | (b4 << 21);
        }
        int i4 = i3 | ((b4 & Byte.MAX_VALUE) << 21);
        byte b5 = b();
        int i5 = i4 | (b5 << 28);
        if (b5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (b() >= 0) {
                return i5;
            }
        }
        throw zzit.c();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long zztb() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((b() & 128) == 0) {
                return j;
            }
        }
        throw zzit.c();
    }

    private zzil(byte[] bArr, int i, int i2) {
        this.f4573a = bArr;
        int i3 = i2 + 0;
        this.d = i3;
        this.c = i3;
    }

    public final <T extends zzey<T, ?>> T zza(zzgr<T> zzgrVar) throws IOException {
        try {
            if (this.l == null) {
                this.l = zzeb.zzd(this.f4573a, this.b, this.c);
            }
            int zzsx = this.l.zzsx();
            int i = this.f - this.b;
            if (zzsx > i) {
                throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(zzsx), Integer.valueOf(i)));
            }
            this.l.zzay(i - zzsx);
            this.l.zzav(this.j - this.i);
            T t = (T) this.l.zza(zzgrVar, zzel.zztq());
            zzau(this.g);
            return t;
        } catch (zzfi e) {
            throw new zzit("", e);
        }
    }

    private final void a() {
        this.d += this.e;
        int i = this.d;
        int i2 = this.h;
        if (i > i2) {
            this.e = i - i2;
            this.d = i - this.e;
        } else {
            this.e = 0;
        }
    }

    public final int getPosition() {
        return this.f - this.b;
    }

    public final byte[] zzt(int i, int i2) {
        if (i2 == 0) {
            return zzix.zzaph;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f4573a, this.b + i, bArr, 0, i2);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, int i2) {
        int i3 = this.f;
        int i4 = this.b;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i < 0) {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.f = i4 + i;
        this.g = i2;
    }

    private final byte b() throws IOException {
        int i = this.f;
        if (i == this.d) {
            throw zzit.a();
        }
        byte[] bArr = this.f4573a;
        this.f = i + 1;
        return bArr[i];
    }

    private final void b(int i) throws IOException {
        if (i < 0) {
            throw zzit.b();
        }
        int i2 = this.f;
        int i3 = i2 + i;
        int i4 = this.h;
        if (i3 > i4) {
            b(i4 - i2);
            throw zzit.a();
        }
        if (i <= this.d - i2) {
            this.f = i2 + i;
            return;
        }
        throw zzit.a();
    }
}
