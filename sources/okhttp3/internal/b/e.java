package okhttp3.internal.b;

import java.util.List;
import okhttp3.ab;
import okhttp3.m;
import okhttp3.s;
import okhttp3.t;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final ByteString f7073a = ByteString.a("\"\\");
    private static final ByteString b = ByteString.a("\t ,=");

    public static long a(ab abVar) {
        return a(abVar.f());
    }

    public static long a(s sVar) {
        return a(sVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(m mVar, t tVar, s sVar) {
        if (mVar == m.f7147a) {
            return;
        }
        List<okhttp3.l> a2 = okhttp3.l.a(tVar, sVar);
        if (a2.isEmpty()) {
            return;
        }
        mVar.a(tVar, a2);
    }

    public static boolean b(ab abVar) {
        if (abVar.a().b().equals("HEAD")) {
            return false;
        }
        int b2 = abVar.b();
        return (((b2 >= 100 && b2 < 200) || b2 == 204 || b2 == 304) && a(abVar) == -1 && !"chunked".equalsIgnoreCase(abVar.a("Transfer-Encoding"))) ? false : true;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
