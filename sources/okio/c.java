package okio;

import com.amazonaws.event.ProgressEvent;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.tencent.smtt.sdk.TbsListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class c implements Cloneable, ByteChannel, d, e {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    n f7175a;
    long b;

    @Override // okio.d, okio.e
    public c c() {
        return this;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.p
    public void close() {
    }

    @Override // okio.d
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c w() {
        return this;
    }

    @Override // okio.d, okio.p, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final long b() {
        return this.b;
    }

    public OutputStream d() {
        return new OutputStream() { // from class: okio.c.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                c.this.i((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                c.this.c(bArr, i, i2);
            }

            public String toString() {
                return c.this + ".outputStream()";
            }
        };
    }

    @Override // okio.e
    public boolean f() {
        return this.b == 0;
    }

    @Override // okio.e
    public void a(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // okio.e
    public boolean b(long j) {
        return this.b >= j;
    }

    @Override // okio.e
    public InputStream g() {
        return new InputStream() { // from class: okio.c.2
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (c.this.b > 0) {
                    return c.this.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.b, 2147483647L);
            }

            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        s.a(this.b, j, j2);
        if (j2 == 0) {
            return this;
        }
        cVar.b += j2;
        n nVar = this.f7175a;
        while (j >= nVar.c - nVar.b) {
            j -= nVar.c - nVar.b;
            nVar = nVar.f;
        }
        while (j2 > 0) {
            n a2 = nVar.a();
            a2.b = (int) (a2.b + j);
            a2.c = Math.min(a2.b + ((int) j2), a2.c);
            n nVar2 = cVar.f7175a;
            if (nVar2 == null) {
                a2.g = a2;
                a2.f = a2;
                cVar.f7175a = a2;
            } else {
                nVar2.g.a(a2);
            }
            j2 -= a2.c - a2.b;
            nVar = nVar.f;
            j = 0;
        }
        return this;
    }

    public final long h() {
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        n nVar = this.f7175a.g;
        return (nVar.c >= 8192 || !nVar.e) ? j : j - (nVar.c - nVar.b);
    }

    @Override // okio.e
    public byte i() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        n nVar = this.f7175a;
        int i = nVar.b;
        int i2 = nVar.c;
        int i3 = i + 1;
        byte b = nVar.f7190a[i];
        this.b--;
        if (i3 == i2) {
            this.f7175a = nVar.b();
            o.a(nVar);
        } else {
            nVar.b = i3;
        }
        return b;
    }

    public final byte c(long j) {
        s.a(this.b, j, 1L);
        long j2 = this.b;
        if (j2 - j > j) {
            n nVar = this.f7175a;
            while (true) {
                long j3 = nVar.c - nVar.b;
                if (j >= j3) {
                    j -= j3;
                    nVar = nVar.f;
                } else {
                    return nVar.f7190a[nVar.b + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            n nVar2 = this.f7175a;
            do {
                nVar2 = nVar2.g;
                j4 += nVar2.c - nVar2.b;
            } while (j4 < 0);
            return nVar2.f7190a[nVar2.b + ((int) j4)];
        }
    }

    @Override // okio.e
    public short j() {
        if (this.b < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        n nVar = this.f7175a;
        int i = nVar.b;
        int i2 = nVar.c;
        if (i2 - i < 2) {
            return (short) (((i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
        }
        byte[] bArr = nVar.f7190a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        this.b -= 2;
        if (i4 == i2) {
            this.f7175a = nVar.b();
            o.a(nVar);
        } else {
            nVar.b = i4;
        }
        return (short) i5;
    }

    @Override // okio.e
    public int k() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        n nVar = this.f7175a;
        int i = nVar.b;
        int i2 = nVar.c;
        if (i2 - i < 4) {
            return ((i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        }
        byte[] bArr = nVar.f7190a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        this.b -= 4;
        if (i8 == i2) {
            this.f7175a = nVar.b();
            o.a(nVar);
        } else {
            nVar.b = i8;
        }
        return i9;
    }

    @Override // okio.e
    public short l() {
        return s.a(j());
    }

    @Override // okio.e
    public int m() {
        return s.a(k());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6 A[EDGE_INSN: B:40:0x00a6->B:37:0x00a6 BREAK  A[LOOP:0: B:4:0x000b->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long n() {
        /*
            r15 = this;
            long r0 = r15.b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lad
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.n r6 = r15.f7175a
            byte[] r7 = r6.f7190a
            int r8 = r6.b
            int r9 = r6.c
        L13:
            if (r8 >= r9) goto L92
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3b
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
            int r11 = r11 + 10
            goto L3b
        L2f:
            r11 = 65
            if (r10 < r11) goto L73
            r11 = 70
            if (r10 > r11) goto L73
            int r11 = r10 + (-65)
            int r11 = r11 + 10
        L3b:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4b
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L13
        L4b:
            okio.c r0 = new okio.c
            r0.<init>()
            okio.c r0 = r0.l(r4)
            okio.c r0 = r0.i(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.p()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L73:
            if (r1 == 0) goto L77
            r0 = 1
            goto L92
        L77:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L92:
            if (r8 != r9) goto L9e
            okio.n r7 = r6.b()
            r15.f7175a = r7
            okio.o.a(r6)
            goto La0
        L9e:
            r6.b = r8
        La0:
            if (r0 != 0) goto La6
            okio.n r6 = r15.f7175a
            if (r6 != 0) goto Lb
        La6:
            long r2 = r15.b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.b = r2
            return r4
        Lad:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.c.n():long");
    }

    public ByteString o() {
        return new ByteString(s());
    }

    @Override // okio.e
    public ByteString d(long j) throws EOFException {
        return new ByteString(h(j));
    }

    @Override // okio.e
    public long a(p pVar) throws IOException {
        long j = this.b;
        if (j > 0) {
            pVar.a_(this, j);
        }
        return j;
    }

    public String p() {
        try {
            return a(this.b, s.f7193a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String e(long j) throws EOFException {
        return a(j, s.f7193a);
    }

    @Override // okio.e
    public String a(Charset charset) {
        try {
            return a(this.b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        s.a(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        n nVar = this.f7175a;
        if (nVar.b + j > nVar.c) {
            return new String(h(j), charset);
        }
        String str = new String(nVar.f7190a, nVar.b, (int) j, charset);
        nVar.b = (int) (nVar.b + j);
        this.b -= j;
        if (nVar.b == nVar.c) {
            this.f7175a = nVar.b();
            o.a(nVar);
        }
        return str;
    }

    @Override // okio.e
    public String q() throws EOFException {
        return f(Long.MAX_VALUE);
    }

    @Override // okio.e
    public String f(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long a2 = a((byte) 10, 0L, j2);
        if (a2 != -1) {
            return g(a2);
        }
        if (j2 < b() && c(j2 - 1) == 13 && c(j2) == 10) {
            return g(j2);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, b()));
        throw new EOFException("\\n not found: limit=" + Math.min(b(), j) + " content=" + cVar.o().e() + (char) 8230);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (c(j2) == 13) {
                String e = e(j2);
                i(2L);
                return e;
            }
        }
        String e2 = e(j);
        i(1L);
        return e2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int r() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.b == 0) {
            throw new EOFException();
        }
        byte c2 = c(0L);
        if ((c2 & 128) == 0) {
            i = c2 & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((c2 & 224) == 192) {
            i = c2 & 31;
            i2 = 2;
            i3 = 128;
        } else if ((c2 & 240) == 224) {
            i = c2 & 15;
            i2 = 3;
            i3 = ProgressEvent.PART_COMPLETED_EVENT_CODE;
        } else {
            if ((c2 & 248) != 240) {
                i(1L);
                return 65533;
            }
            i = c2 & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.b < j) {
            throw new EOFException("size < " + i2 + ": " + this.b + " (to read code point prefixed 0x" + Integer.toHexString(c2) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte c3 = c(j2);
            if ((c3 & 192) != 128) {
                i(j2);
                return 65533;
            }
            i = (i << 6) | (c3 & 63);
        }
        i(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((i < 55296 || i > 57343) && i >= i3) {
            return i;
        }
        return 65533;
    }

    @Override // okio.e
    public byte[] s() {
        try {
            return h(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.e
    public byte[] h(long j) throws EOFException {
        s.a(this.b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    @Override // okio.e
    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 == -1) {
                throw new EOFException();
            }
            i += a2;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        s.a(bArr.length, i, i2);
        n nVar = this.f7175a;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(i2, nVar.c - nVar.b);
        System.arraycopy(nVar.f7190a, nVar.b, bArr, i, min);
        nVar.b += min;
        this.b -= min;
        if (nVar.b == nVar.c) {
            this.f7175a = nVar.b();
            o.a(nVar);
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        n nVar = this.f7175a;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), nVar.c - nVar.b);
        byteBuffer.put(nVar.f7190a, nVar.b, min);
        nVar.b += min;
        this.b -= min;
        if (nVar.b == nVar.c) {
            this.f7175a = nVar.b();
            o.a(nVar);
        }
        return min;
    }

    public final void t() {
        try {
            i(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.e
    public void i(long j) throws EOFException {
        while (j > 0) {
            if (this.f7175a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.c - this.f7175a.b);
            long j2 = min;
            this.b -= j2;
            j -= j2;
            this.f7175a.b += min;
            if (this.f7175a.b == this.f7175a.c) {
                n nVar = this.f7175a;
                this.f7175a = nVar.b();
                o.a(nVar);
            }
        }
    }

    @Override // okio.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c b(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.a(this);
        return this;
    }

    @Override // okio.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public c a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                n e = e(1);
                byte[] bArr = e.f7190a;
                int i3 = e.c - i;
                int min = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) charAt;
                while (i4 < min) {
                    char charAt2 = str.charAt(i4);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) charAt2;
                    i4++;
                }
                int i5 = (i3 + i4) - e.c;
                e.c += i5;
                this.b += i5;
                i = i4;
            } else if (charAt < 2048) {
                i((charAt >> 6) | 192);
                i((charAt & '?') | 128);
                i++;
            } else if (charAt < 55296 || charAt > 57343) {
                i((charAt >> '\f') | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                i(((charAt >> 6) & 63) | 128);
                i((charAt & '?') | 128);
                i++;
            } else {
                int i6 = i + 1;
                char charAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                    i(63);
                    i = i6;
                } else {
                    int i7 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                    i((i7 >> 18) | 240);
                    i(((i7 >> 12) & 63) | 128);
                    i(((i7 >> 6) & 63) | 128);
                    i((i7 & 63) | 128);
                    i += 2;
                }
            }
        }
        return this;
    }

    public c a(int i) {
        if (i < 128) {
            i(i);
        } else if (i < 2048) {
            i((i >> 6) | 192);
            i((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                i(63);
            } else {
                i((i >> 12) | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                i(((i >> 6) & 63) | 128);
                i((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            i((i >> 18) | 240);
            i(((i >> 12) & 63) | 128);
            i(((i >> 6) & 63) | 128);
            i((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(s.f7193a)) {
                return a(str, i, i2);
            }
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return c(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
    }

    @Override // okio.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return c(bArr, 0, bArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        s.a(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            n e = e(1);
            int min = Math.min(i3 - i, 8192 - e.c);
            System.arraycopy(bArr, i, e.f7190a, e.c, min);
            i += min;
            e.c += min;
        }
        this.b += j;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            n e = e(1);
            int min = Math.min(i, 8192 - e.c);
            byteBuffer.get(e.f7190a, e.c, min);
            i -= min;
            e.c += min;
        }
        this.b += remaining;
        return remaining;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long a(q qVar) throws IOException {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a2 = qVar.a(this, 8192L);
            if (a2 == -1) {
                return j;
            }
            j += a2;
        }
    }

    @Override // okio.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c i(int i) {
        n e = e(1);
        byte[] bArr = e.f7190a;
        int i2 = e.c;
        e.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    @Override // okio.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c h(int i) {
        n e = e(2);
        byte[] bArr = e.f7190a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        e.c = i3 + 1;
        this.b += 2;
        return this;
    }

    @Override // okio.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c g(int i) {
        n e = e(4);
        byte[] bArr = e.f7190a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        e.c = i5 + 1;
        this.b += 4;
        return this;
    }

    @Override // okio.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public c m(long j) {
        if (j == 0) {
            return i(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= LogUtils.LOG_FUSE_TIME) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        n e = e(i);
        byte[] bArr = e.f7190a;
        int i2 = e.c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        e.c += i;
        this.b += i;
        return this;
    }

    @Override // okio.d
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public c l(long j) {
        if (j == 0) {
            return i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        n e = e(numberOfTrailingZeros);
        byte[] bArr = e.f7190a;
        int i = e.c;
        for (int i2 = (e.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        e.c += numberOfTrailingZeros;
        this.b += numberOfTrailingZeros;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        n nVar = this.f7175a;
        if (nVar == null) {
            this.f7175a = o.a();
            n nVar2 = this.f7175a;
            nVar2.g = nVar2;
            nVar2.f = nVar2;
            return nVar2;
        }
        n nVar3 = nVar.g;
        return (nVar3.c + i > 8192 || !nVar3.e) ? nVar3.a(o.a()) : nVar3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.p
    public void a_(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        s.a(cVar.b, 0L, j);
        while (j > 0) {
            if (j < cVar.f7175a.c - cVar.f7175a.b) {
                n nVar = this.f7175a;
                n nVar2 = nVar != null ? nVar.g : null;
                if (nVar2 != null && nVar2.e) {
                    if ((nVar2.c + j) - (nVar2.d ? 0 : nVar2.b) <= 8192) {
                        cVar.f7175a.a(nVar2, (int) j);
                        cVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                cVar.f7175a = cVar.f7175a.a((int) j);
            }
            n nVar3 = cVar.f7175a;
            long j2 = nVar3.c - nVar3.b;
            cVar.f7175a = nVar3.b();
            n nVar4 = this.f7175a;
            if (nVar4 == null) {
                this.f7175a = nVar3;
                n nVar5 = this.f7175a;
                nVar5.g = nVar5;
                nVar5.f = nVar5;
            } else {
                nVar4.g.a(nVar3).c();
            }
            cVar.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    @Override // okio.q
    public long a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.b;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        cVar.a_(this, j);
        return j;
    }

    @Override // okio.e
    public long a(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long a(byte b, long j, long j2) {
        n nVar;
        long j3;
        long j4 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j5 = this.b;
        if (j2 <= j5) {
            j5 = j2;
        }
        if (j == j5 || (nVar = this.f7175a) == null) {
            return -1L;
        }
        long j6 = this.b;
        if (j6 - j < j) {
            while (j6 > j) {
                nVar = nVar.g;
                j6 -= nVar.c - nVar.b;
            }
            j3 = j;
        } else {
            while (true) {
                j6 = j4;
                j4 = (nVar.c - nVar.b) + j6;
                if (j4 >= j) {
                    break;
                }
                nVar = nVar.f;
            }
            j3 = j;
        }
        while (j6 < j5) {
            byte[] bArr = nVar.f7190a;
            int min = (int) Math.min(nVar.c, (nVar.b + j5) - j6);
            for (int i = (int) ((nVar.b + j3) - j6); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - nVar.b) + j6;
                }
            }
            j3 = (nVar.c - nVar.b) + j6;
            nVar = nVar.f;
            j6 = j3;
        }
        return -1L;
    }

    @Override // okio.e
    public boolean a(long j, ByteString byteString) {
        return a(j, byteString, 0, byteString.g());
    }

    public boolean a(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.b - j < i2 || byteString.g() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (c(i3 + j) != byteString.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.p
    public r a() {
        return r.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.b;
        if (j != cVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        n nVar = this.f7175a;
        n nVar2 = cVar.f7175a;
        int i = nVar.b;
        int i2 = nVar2.b;
        while (j2 < this.b) {
            long min = Math.min(nVar.c - i, nVar2.c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (i5 < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (nVar.f7190a[i4] != nVar2.f7190a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == nVar.c) {
                nVar = nVar.f;
                i = nVar.b;
            } else {
                i = i4;
            }
            if (i3 == nVar2.c) {
                nVar2 = nVar2.f;
                i2 = nVar2.b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        n nVar = this.f7175a;
        if (nVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = nVar.c;
            for (int i3 = nVar.b; i3 < i2; i3++) {
                i = (i * 31) + nVar.f7190a[i3];
            }
            nVar = nVar.f;
        } while (nVar != this.f7175a);
        return i;
    }

    public String toString() {
        return v().toString();
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.b == 0) {
            return cVar;
        }
        cVar.f7175a = this.f7175a.a();
        n nVar = cVar.f7175a;
        nVar.g = nVar;
        nVar.f = nVar;
        n nVar2 = this.f7175a;
        while (true) {
            nVar2 = nVar2.f;
            if (nVar2 != this.f7175a) {
                cVar.f7175a.g.a(nVar2.a());
            } else {
                cVar.b = this.b;
                return cVar;
            }
        }
    }

    public final ByteString v() {
        long j = this.b;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
        }
        return f((int) j);
    }

    public final ByteString f(int i) {
        if (i == 0) {
            return ByteString.b;
        }
        return new SegmentedByteString(this, i);
    }
}
