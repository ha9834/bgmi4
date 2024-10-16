package com.shieldtunnel.svpn.common.f;

import android.util.Log;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.s3.internal.Constants;
import com.shieldtunnel.svpn.common.LogTag;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.zip.CRC32;

/* loaded from: classes2.dex */
public class l {
    private static final byte[] f = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    final String f5824a;
    public final String b;
    private long c;
    public final byte[] d;
    final boolean e;

    public l(String str, long j, String str2, byte[] bArr, boolean z) {
        this.f5824a = str;
        this.c = j;
        this.b = str2;
        this.d = bArr;
        this.e = z;
    }

    private static void a(ByteBuffer byteBuffer, byte[] bArr) {
        if (bArr == null) {
            byteBuffer.putInt(-1);
        } else {
            byteBuffer.putInt(bArr.length);
            byteBuffer.put(bArr);
        }
    }

    private static long b(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 8) {
            return byteBuffer.getLong();
        }
        throw new EOFException();
    }

    private static String c(ByteBuffer byteBuffer) {
        byte[] a2 = a(byteBuffer);
        if (a2 != null) {
            return new String(a2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        return this.c;
    }

    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.e == lVar.e && this.c == lVar.c && com.shieldtunnel.svpn.common.c.a(this.f5824a, lVar.f5824a) && com.shieldtunnel.svpn.common.c.a(this.b, lVar.b) && Arrays.equals(this.d, lVar.d);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append('[');
        a(stringBuffer, "CacheTag", this.f5824a);
        stringBuffer.append(", Expire=");
        stringBuffer.append(this.c);
        stringBuffer.append(", ");
        a(stringBuffer, JsonDocumentFields.VERSION, this.b);
        stringBuffer.append(", ");
        stringBuffer.append("Data=");
        byte[] bArr = this.d;
        if (bArr == null) {
            stringBuffer.append(Constants.NULL_VERSION_ID);
        } else {
            stringBuffer.append(bArr.length);
        }
        stringBuffer.append(", new-download=");
        stringBuffer.append(this.e);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        byte[] bArr = this.d;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private static byte[] a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i == 0) {
                return f;
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

    public byte[] b() {
        return this.d;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l a(InputStream inputStream) {
        ByteBuffer a2 = a(4);
        if (inputStream.read(a2.array()) == 4) {
            int i = a2.getInt();
            if (i >= 24 && i <= 33554432) {
                CRC32 crc32 = new CRC32();
                crc32.update(a2.array(), 0, a2.position());
                ByteBuffer a3 = a(i - 4);
                if (inputStream.read(a3.array()) == a3.limit()) {
                    String c = c(a3);
                    long b = b(a3);
                    String c2 = c(a3);
                    byte[] a4 = a(a3);
                    if (a3.limit() - a3.position() >= 8) {
                        crc32.update(a3.array(), 0, a3.position());
                        if (crc32.getValue() != a3.getLong()) {
                            throw new IOException("CRC verify failed");
                        }
                    } else {
                        Log.d(LogTag.DATA, "PortalDataEx.deserialize from old version");
                    }
                    return new l(c, b, c2, a4, false);
                }
                throw new EOFException();
            }
            throw new IOException("Invalid total size");
        }
        throw new EOFException();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f5824a;
    }

    public void a(OutputStream outputStream) {
        byte[] a2 = a(this.f5824a);
        byte[] a3 = a(this.b);
        int a4 = a(a2) + 8 + 8 + 4 + a(a3) + 4 + a(this.d) + 8;
        ByteBuffer a5 = a(a4);
        a5.putInt(a4);
        a(a5, a2);
        a5.putLong(this.c);
        a(a5, a3);
        a(a5, this.d);
        byte[] array = a5.array();
        CRC32 crc32 = new CRC32();
        crc32.update(array, 0, a5.position());
        a5.putLong(crc32.getValue());
        outputStream.write(array, 0, a5.position());
        com.shieldtunnel.svpn.common.c.a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.c = j;
    }
}
