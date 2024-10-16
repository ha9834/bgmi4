package com.subao.common.e;

import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.s3.internal.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.zip.CRC32;

/* loaded from: classes2.dex */
public class ae {
    private static final byte[] e = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final String f5960a;
    public final String b;
    public final byte[] c;
    public final boolean d;
    private long f;

    public ae(String str, long j, String str2, byte[] bArr) {
        this(str, j, str2, bArr, false);
    }

    public ae(String str, long j, String str2, byte[] bArr, boolean z) {
        this.f5960a = str;
        this.f = j;
        this.b = str2;
        this.c = bArr;
        this.d = z;
    }

    private static void a(ByteBuffer byteBuffer, byte[] bArr) {
        if (bArr == null) {
            byteBuffer.putInt(-1);
        } else {
            byteBuffer.putInt(bArr.length);
            byteBuffer.put(bArr);
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] c = c(byteBuffer);
        if (c != null) {
            return new String(c);
        }
        return null;
    }

    private static long b(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 8) {
            return byteBuffer.getLong();
        }
        throw new EOFException();
    }

    private static byte[] c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i == 0) {
                return e;
            }
            if (i < 0) {
                return null;
            }
            if (byteBuffer.remaining() >= i) {
                byte[] bArr = new byte[i];
                System.arraycopy(byteBuffer.array(), byteBuffer.position(), bArr, 0, i);
                byteBuffer.position(byteBuffer.position() + i);
                return bArr;
            }
        }
        throw new EOFException();
    }

    private static int a(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes();
    }

    public static ae a(InputStream inputStream) {
        ByteBuffer a2 = a(4);
        if (inputStream.read(a2.array()) != 4) {
            throw new EOFException();
        }
        int i = a2.getInt();
        if (i < 24 || i > 33554432) {
            throw new IOException("Invalid total size");
        }
        CRC32 crc32 = new CRC32();
        crc32.update(a2.array(), 0, a2.position());
        ByteBuffer a3 = a(i - 4);
        if (inputStream.read(a3.array()) != a3.limit()) {
            throw new EOFException();
        }
        String a4 = a(a3);
        long b = b(a3);
        String a5 = a(a3);
        byte[] c = c(a3);
        if (a3.limit() - a3.position() >= 8) {
            crc32.update(a3.array(), 0, a3.position());
            if (crc32.getValue() != a3.getLong()) {
                throw new IOException("CRC verify failed");
            }
        } else {
            com.subao.common.d.a("SubaoData", "PortalDataEx.deserialize from old version");
        }
        return new ae(a4, b, a5, c);
    }

    private static ByteBuffer a(int i) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[i]);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return wrap;
    }

    private static StringBuffer a(StringBuffer stringBuffer, String str, String str2) {
        stringBuffer.append(str);
        stringBuffer.append('=');
        if (str2 == null) {
            stringBuffer.append(Constants.NULL_VERSION_ID);
        } else {
            stringBuffer.append('\"');
            stringBuffer.append(str2);
            stringBuffer.append('\"');
        }
        return stringBuffer;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ae)) {
            return false;
        }
        ae aeVar = (ae) obj;
        return this.d == aeVar.d && this.f == aeVar.f && com.subao.common.e.a(this.f5960a, aeVar.f5960a) && com.subao.common.e.a(this.b, aeVar.b) && Arrays.equals(this.c, aeVar.c);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append('[');
        a(stringBuffer, "CacheTag", this.f5960a);
        stringBuffer.append(", Expire=");
        stringBuffer.append(this.f);
        stringBuffer.append(", ");
        a(stringBuffer, JsonDocumentFields.VERSION, this.b);
        stringBuffer.append(", ");
        stringBuffer.append("Data=");
        byte[] bArr = this.c;
        if (bArr == null) {
            stringBuffer.append(Constants.NULL_VERSION_ID);
        } else {
            stringBuffer.append(bArr.length);
        }
        stringBuffer.append(", new-download=");
        stringBuffer.append(this.d);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public byte[] a() {
        return this.c;
    }

    public int b() {
        byte[] bArr = this.c;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public String c() {
        return this.f5960a;
    }

    public String d() {
        return this.b;
    }

    public void a(OutputStream outputStream) {
        byte[] a2 = a(this.f5960a);
        byte[] a3 = a(this.b);
        int a4 = a(a2) + 8 + 8 + 4 + a(a3) + 4 + a(this.c) + 8;
        ByteBuffer a5 = a(a4);
        a5.putInt(a4);
        a(a5, a2);
        a5.putLong(this.f);
        a(a5, a3);
        a(a5, this.c);
        byte[] array = a5.array();
        CRC32 crc32 = new CRC32();
        crc32.update(array, 0, a5.position());
        a5.putLong(crc32.getValue());
        outputStream.write(array, 0, a5.position());
        com.subao.common.e.a(outputStream);
    }

    public void a(long j) {
        this.f = j;
    }

    public long e() {
        return this.f;
    }
}
