package okhttp3.internal.http2;

import java.io.IOException;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    static final ByteString f7110a = ByteString.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] b = new String[64];
    static final String[] c = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = c;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = okhttp3.internal.c.a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 : iArr) {
            b[i3 | 8] = b[i3] + "|PADDED";
        }
        String[] strArr3 = b;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr) {
                int i6 = i5 | i4;
                b[i6] = b[i5] + '|' + b[i4];
                b[i6 | 8] = b[i5] + '|' + b[i4] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = b;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = c[i];
            }
            i++;
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(okhttp3.internal.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(okhttp3.internal.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = d;
        String a2 = b2 < strArr.length ? strArr[b2] : okhttp3.internal.c.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a2;
        objArr[4] = a3;
        return okhttp3.internal.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        switch (b2) {
            case 2:
            case 3:
            case 7:
            case 8:
                return c[b3];
            case 4:
            case 6:
                return b3 == 1 ? "ACK" : c[b3];
            case 5:
            default:
                String[] strArr = b;
                String str = b3 < strArr.length ? strArr[b3] : c[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
        }
    }
}
