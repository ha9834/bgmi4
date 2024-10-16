package okhttp3.internal;

import com.facebook.internal.security.CertificateUtil;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okio.ByteString;
import okio.e;
import okio.q;

/* loaded from: classes.dex */
public final class c {
    private static final Method r;
    private static final Pattern s;

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f7078a = new byte[0];
    public static final String[] b = new String[0];
    public static final ac c = ac.a(null, f7078a);
    public static final aa d = aa.a((v) null, f7078a);
    private static final ByteString i = ByteString.c("efbbbf");
    private static final ByteString j = ByteString.c("feff");
    private static final ByteString k = ByteString.c("fffe");
    private static final ByteString l = ByteString.c("0000ffff");
    private static final ByteString m = ByteString.c("ffff0000");
    public static final Charset e = Charset.forName("UTF-8");
    public static final Charset f = Charset.forName("ISO-8859-1");
    private static final Charset n = Charset.forName("UTF-16BE");
    private static final Charset o = Charset.forName("UTF-16LE");
    private static final Charset p = Charset.forName("UTF-32BE");
    private static final Charset q = Charset.forName("UTF-32LE");
    public static final TimeZone g = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> h = new Comparator<String>() { // from class: okhttp3.internal.c.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return (c2 - 'a') + 10;
        }
        if (c2 < 'A' || c2 > 'F') {
            return -1;
        }
        return (c2 - 'A') + 10;
    }

    static {
        Method method = null;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        r = method;
        s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = r;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                if (!"bio == null".equals(e3.getMessage())) {
                    throw e3;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(q qVar, int i2, TimeUnit timeUnit) {
        try {
            return b(qVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean b(q qVar, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long d2 = qVar.a().g_() ? qVar.a().d() - nanoTime : Long.MAX_VALUE;
        qVar.a().a(Math.min(d2, timeUnit.toNanos(i2)) + nanoTime);
        try {
            okio.c cVar = new okio.c();
            while (qVar.a(cVar, 8192L) != -1) {
                cVar.t();
            }
            if (d2 == Long.MAX_VALUE) {
                qVar.a().f();
            } else {
                qVar.a().a(nanoTime + d2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (d2 == Long.MAX_VALUE) {
                qVar.a().f();
            } else {
                qVar.a().a(nanoTime + d2);
            }
            return false;
        } catch (Throwable th) {
            if (d2 == Long.MAX_VALUE) {
                qVar.a().f();
            } else {
                qVar.a().a(nanoTime + d2);
            }
            throw th;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: okhttp3.internal.c.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(t tVar, boolean z) {
        String f2;
        if (tVar.f().contains(CertificateUtil.DELIMITER)) {
            f2 = "[" + tVar.f() + "]";
        } else {
            f2 = tVar.f();
        }
        if (!z && tVar.g() == t.a(tVar.b())) {
            return f2;
        }
        return f2 + CertificateUtil.DELIMITER + tVar.g();
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String[] a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int a(String str, int i2, int i3) {
        while (i2 < i3) {
            switch (str.charAt(i2)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i2++;
                default:
                    return i2;
            }
        }
        return i3;
    }

    public static int b(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            switch (str.charAt(i4)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                default:
                    return i4 + 1;
            }
        }
        return i2;
    }

    public static String c(String str, int i2, int i3) {
        int a2 = a(str, i2, i3);
        return str.substring(a2, b(str, a2, i3));
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(String str) {
        InetAddress d2;
        if (str.contains(CertificateUtil.DELIMITER)) {
            if (str.startsWith("[") && str.endsWith("]")) {
                d2 = d(str, 1, str.length() - 1);
            } else {
                d2 = d(str, 0, str.length());
            }
            if (d2 == null) {
                return null;
            }
            byte[] address = d2.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (d(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean d(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int b(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean c(String str) {
        return s.matcher(str).matches();
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset a(e eVar, Charset charset) throws IOException {
        if (eVar.a(0L, i)) {
            eVar.i(i.g());
            return e;
        }
        if (eVar.a(0L, j)) {
            eVar.i(j.g());
            return n;
        }
        if (eVar.a(0L, k)) {
            eVar.i(k.g());
            return o;
        }
        if (eVar.a(0L, l)) {
            eVar.i(l.g());
            return p;
        }
        if (!eVar.a(0L, m)) {
            return charset;
        }
        eVar.i(m.g());
        return q;
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j2);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j2 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007c, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.InetAddress d(java.lang.String r10, int r11, int r12) {
        /*
            r0 = 16
            byte[] r0 = new byte[r0]
            r1 = -1
            r2 = 0
            r3 = 0
            r4 = -1
            r5 = -1
        L9:
            r6 = 0
            if (r11 >= r12) goto L7d
            int r7 = r0.length
            if (r3 != r7) goto L10
            return r6
        L10:
            int r7 = r11 + 2
            if (r7 > r12) goto L29
            java.lang.String r8 = "::"
            r9 = 2
            boolean r8 = r10.regionMatches(r11, r8, r2, r9)
            if (r8 == 0) goto L29
            if (r4 == r1) goto L20
            return r6
        L20:
            int r3 = r3 + 2
            if (r7 != r12) goto L26
            r4 = r3
            goto L7d
        L26:
            r4 = r3
            r5 = r7
            goto L4e
        L29:
            if (r3 == 0) goto L4d
            java.lang.String r7 = ":"
            r8 = 1
            boolean r7 = r10.regionMatches(r11, r7, r2, r8)
            if (r7 == 0) goto L38
            int r11 = r11 + 1
            r5 = r11
            goto L4e
        L38:
            java.lang.String r7 = "."
            boolean r11 = r10.regionMatches(r11, r7, r2, r8)
            if (r11 == 0) goto L4c
            int r11 = r3 + (-2)
            boolean r10 = a(r10, r5, r12, r0, r11)
            if (r10 != 0) goto L49
            return r6
        L49:
            int r3 = r3 + 2
            goto L7d
        L4c:
            return r6
        L4d:
            r5 = r11
        L4e:
            r11 = r5
            r7 = 0
        L50:
            if (r11 >= r12) goto L63
            char r8 = r10.charAt(r11)
            int r8 = a(r8)
            if (r8 != r1) goto L5d
            goto L63
        L5d:
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L50
        L63:
            int r8 = r11 - r5
            if (r8 == 0) goto L7c
            r9 = 4
            if (r8 <= r9) goto L6b
            goto L7c
        L6b:
            int r6 = r3 + 1
            int r8 = r7 >>> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r0[r3] = r8
            int r3 = r6 + 1
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r0[r6] = r7
            goto L9
        L7c:
            return r6
        L7d:
            int r10 = r0.length
            if (r3 == r10) goto L90
            if (r4 != r1) goto L83
            return r6
        L83:
            int r10 = r0.length
            int r11 = r3 - r4
            int r10 = r10 - r11
            java.lang.System.arraycopy(r0, r4, r0, r10, r11)
            int r10 = r0.length
            int r10 = r10 - r3
            int r10 = r10 + r4
            java.util.Arrays.fill(r0, r4, r10, r2)
        L90:
            java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L95
            return r10
        L95:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.c.d(java.lang.String, int, int):java.net.InetAddress");
    }

    private static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    private static String a(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (i3 < bArr.length) {
            int i6 = i3;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i3;
            if (i7 > i5 && i7 >= 4) {
                i4 = i3;
                i5 = i7;
            }
            i3 = i6 + 2;
        }
        okio.c cVar = new okio.c();
        while (i2 < bArr.length) {
            if (i2 == i4) {
                cVar.i(58);
                i2 += i5;
                if (i2 == 16) {
                    cVar.i(58);
                }
            } else {
                if (i2 > 0) {
                    cVar.i(58);
                }
                cVar.l(((bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i2 + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
                i2 += 2;
            }
        }
        return cVar.p();
    }

    public static X509TrustManager a() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            return (X509TrustManager) trustManagers[0];
        } catch (GeneralSecurityException e2) {
            throw a("No System TLS", (Exception) e2);
        }
    }

    public static s b(List<okhttp3.internal.http2.a> list) {
        s.a aVar = new s.a();
        for (okhttp3.internal.http2.a aVar2 : list) {
            a.f7061a.a(aVar, aVar2.g.a(), aVar2.h.a());
        }
        return aVar.a();
    }
}
