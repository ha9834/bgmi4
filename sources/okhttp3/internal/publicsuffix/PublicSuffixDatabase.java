package okhttp3.internal.publicsuffix;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.c;
import okhttp3.internal.e.g;
import okio.e;
import okio.i;
import okio.k;

/* loaded from: classes3.dex */
public final class PublicSuffixDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f7139a = {42};
    private static final String[] b = new String[0];
    private static final String[] c = {"*"};
    private static final PublicSuffixDatabase d = new PublicSuffixDatabase();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final CountDownLatch f = new CountDownLatch(1);
    private byte[] g;
    private byte[] h;

    public static PublicSuffixDatabase a() {
        return d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String a(String str) {
        int length;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a2 = a(split);
        if (split.length == a2.length && a2[0].charAt(0) != '!') {
            return null;
        }
        if (a2[0].charAt(0) == '!') {
            length = split.length - a2.length;
        } else {
            length = split.length - (a2.length + 1);
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        while (length < split2.length) {
            sb.append(split2[length]);
            sb.append('.');
            length++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        if (!this.e.get() && this.e.compareAndSet(false, true)) {
            b();
        } else {
            try {
                this.f.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(c.e);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= bArr.length) {
                str = null;
                break;
            }
            str = a(this.g, bArr, i2);
            if (str != null) {
                break;
            }
            i2++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i3 = 0; i3 < bArr2.length - 1; i3++) {
                bArr2[i3] = f7139a;
                str2 = a(this.g, bArr2, i3);
                if (str2 != null) {
                    break;
                }
            }
        }
        str2 = null;
        if (str2 != null) {
            for (int i4 = 0; i4 < bArr.length - 1; i4++) {
                str3 = a(this.h, bArr, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            return ("!" + str3).split("\\.");
        }
        if (str == null && str2 == null) {
            return c;
        }
        if (str != null) {
            strArr2 = str.split("\\.");
        } else {
            strArr2 = b;
        }
        if (str2 != null) {
            strArr3 = str2.split("\\.");
        } else {
            strArr3 = b;
        }
        return strArr2.length > strArr3.length ? strArr2 : strArr3;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    i3 = 46;
                } else {
                    i3 = bArr2[i10][i11] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                }
                i4 = i3 - (bArr[i7 + i12] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length == i11) {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 < 0) {
                length = i7 - 1;
            } else if (i4 > 0) {
                i5 = i2 + 1;
            } else {
                int i13 = i9 - i12;
                int length2 = bArr2[i10].length - i11;
                while (true) {
                    i10++;
                    if (i10 >= bArr2.length) {
                        break;
                    }
                    length2 += bArr2[i10].length;
                }
                if (length2 < i13) {
                    length = i7 - 1;
                } else {
                    if (length2 <= i13) {
                        return new String(bArr, i7, i9, c.e);
                    }
                    i5 = i2 + 1;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void b() {
        boolean z = false;
        while (true) {
            try {
                try {
                    c();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    g.e().a(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void c() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        e a2 = k.a(new i(k.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[a2.k()];
            a2.a(bArr);
            byte[] bArr2 = new byte[a2.k()];
            a2.a(bArr2);
            synchronized (this) {
                this.g = bArr;
                this.h = bArr2;
            }
            this.f.countDown();
        } finally {
            c.a(a2);
        }
    }
}
