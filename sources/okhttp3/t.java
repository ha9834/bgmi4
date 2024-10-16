package okhttp3;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class t {
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    final String f7157a;
    final String b;
    final int c;
    private final String e;
    private final String f;
    private final List<String> g;

    @Nullable
    private final List<String> h;

    @Nullable
    private final String i;
    private final String j;

    t(a aVar) {
        this.f7157a = aVar.f7158a;
        this.e = a(aVar.b, false);
        this.f = a(aVar.c, false);
        this.b = aVar.d;
        this.c = aVar.a();
        this.g = a(aVar.f, false);
        this.h = aVar.g != null ? a(aVar.g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : null;
        this.j = aVar.toString();
    }

    public URI a() {
        String aVar = p().b().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String b() {
        return this.f7157a;
    }

    public boolean c() {
        return this.f7157a.equals("https");
    }

    public String d() {
        if (this.e.isEmpty()) {
            return "";
        }
        int length = this.f7157a.length() + 3;
        String str = this.j;
        return this.j.substring(length, okhttp3.internal.c.a(str, length, str.length(), ":@"));
    }

    public String e() {
        if (this.f.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.f7157a.length() + 3) + 1, this.j.indexOf(64));
    }

    public String f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String h() {
        int indexOf = this.j.indexOf(47, this.f7157a.length() + 3);
        String str = this.j;
        return this.j.substring(indexOf, okhttp3.internal.c.a(str, indexOf, str.length(), "?#"));
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> i() {
        int indexOf = this.j.indexOf(47, this.f7157a.length() + 3);
        String str = this.j;
        int a2 = okhttp3.internal.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i = indexOf + 1;
            int a3 = okhttp3.internal.c.a(this.j, i, a2, '/');
            arrayList.add(this.j.substring(i, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public List<String> j() {
        return this.g;
    }

    @Nullable
    public String k() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, okhttp3.internal.c.a(str, indexOf, str.length(), '#'));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public String l() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    public int m() {
        List<String> list = this.h;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String a(int i) {
        List<String> list = this.h;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(i * 2);
    }

    public String b(int i) {
        List<String> list = this.h;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get((i * 2) + 1);
    }

    @Nullable
    public String n() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public String o() {
        return d("/...").b("").c("").c().toString();
    }

    @Nullable
    public t c(String str) {
        a d2 = d(str);
        if (d2 != null) {
            return d2.c();
        }
        return null;
    }

    public a p() {
        a aVar = new a();
        aVar.f7158a = this.f7157a;
        aVar.b = d();
        aVar.c = e();
        aVar.d = this.b;
        aVar.e = this.c != a(this.f7157a) ? this.c : -1;
        aVar.f.clear();
        aVar.f.addAll(i());
        aVar.f(k());
        aVar.h = n();
        return aVar;
    }

    @Nullable
    public a d(String str) {
        try {
            return new a().a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    public static t e(String str) {
        try {
            return f(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static t f(String str) {
        return new a().a((t) null, str).c();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof t) && ((t) obj).j.equals(this.j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        String f7158a;

        @Nullable
        String d;

        @Nullable
        List<String> g;

        @Nullable
        String h;
        String b = "";
        String c = "";
        int e = -1;
        final List<String> f = new ArrayList();

        public a() {
            this.f.add("");
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f7158a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f7158a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.b = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.c = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String e = e(str, 0, str.length());
            if (e == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.d = e;
            return this;
        }

        public a a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.e = i;
            return this;
        }

        int a() {
            int i = this.e;
            return i != -1 ? i : t.a(this.f7158a);
        }

        public a e(@Nullable String str) {
            this.g = str != null ? t.b(t.a(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public a f(@Nullable String str) {
            this.g = str != null ? t.b(t.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a a(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(t.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.g.add(str2 != null ? t.a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        public a b(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(t.a(str, " \"'<>#&=", true, false, true, true));
            this.g.add(str2 != null ? t.a(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        a b() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, t.a(this.f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, t.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = t.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public t c() {
            if (this.f7158a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d == null) {
                throw new IllegalStateException("host == null");
            }
            return new t(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f7158a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            String str2 = this.d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.d);
                    sb.append(']');
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.f7158a != null) {
                int a2 = a();
                String str3 = this.f7158a;
                if (str3 == null || a2 != t.a(str3)) {
                    sb.append(':');
                    sb.append(a2);
                }
            }
            t.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                t.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:37:0x00d6. Please report as an issue. */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        a a(@Nullable t tVar, String str) {
            int a2;
            int i;
            int a3 = okhttp3.internal.c.a(str, 0, str.length());
            int b = okhttp3.internal.c.b(str, a3, str.length());
            int b2 = b(str, a3, b);
            if (b2 != -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.f7158a = "https";
                    a3 += 6;
                } else if (str.regionMatches(true, a3, "http:", 0, 5)) {
                    this.f7158a = "http";
                    a3 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, b2) + "'");
                }
            } else if (tVar != null) {
                this.f7158a = tVar.f7157a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int c = c(str, a3, b);
            char c2 = '#';
            if (c >= 2 || tVar == null || !tVar.f7157a.equals(this.f7158a)) {
                int i2 = a3 + c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = okhttp3.internal.c.a(str, i2, b, "@/\\?#");
                    char charAt = a2 != b ? str.charAt(a2) : (char) 65535;
                    if (charAt != 65535 && charAt != c2 && charAt != '/' && charAt != '\\') {
                        switch (charAt) {
                            case '?':
                                break;
                            case '@':
                                if (!z) {
                                    int a4 = okhttp3.internal.c.a(str, i2, a2, ':');
                                    i = a2;
                                    String a5 = t.a(str, i2, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    if (z2) {
                                        a5 = this.b + "%40" + a5;
                                    }
                                    this.b = a5;
                                    if (a4 != i) {
                                        this.c = t.a(str, a4 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                        z = true;
                                    }
                                    z2 = true;
                                } else {
                                    i = a2;
                                    this.c += "%40" + t.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                }
                                i2 = i + 1;
                                c2 = '#';
                            default:
                                c2 = '#';
                        }
                    }
                }
                int d = d(str, i2, a2);
                int i3 = d + 1;
                if (i3 < a2) {
                    this.d = e(str, i2, d);
                    this.e = f(str, i3, a2);
                    if (this.e == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, a2) + '\"');
                    }
                } else {
                    this.d = e(str, i2, d);
                    this.e = t.a(this.f7158a);
                }
                if (this.d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, d) + '\"');
                }
                a3 = a2;
            } else {
                this.b = tVar.d();
                this.c = tVar.e();
                this.d = tVar.b;
                this.e = tVar.c;
                this.f.clear();
                this.f.addAll(tVar.i());
                if (a3 == b || str.charAt(a3) == '#') {
                    f(tVar.k());
                }
            }
            int a6 = okhttp3.internal.c.a(str, a3, b, "?#");
            a(str, a3, a6);
            if (a6 < b && str.charAt(a6) == '?') {
                int a7 = okhttp3.internal.c.a(str, a6, b, '#');
                this.g = t.b(t.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true, null));
                a6 = a7;
            }
            if (a6 < b && str.charAt(a6) == '#') {
                this.h = t.a(str, 1 + a6, b, "", true, false, false, false, null);
            }
            return this;
        }

        private void a(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f.clear();
                this.f.add("");
                i++;
            } else {
                List<String> list = this.f;
                list.set(list.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int a2 = okhttp3.internal.c.a(str, i3, i2, "/\\");
                boolean z = a2 < i2;
                a(str, i3, a2, z, true);
                if (z) {
                    a2++;
                }
                i3 = a2;
            }
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = t.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (g(a2)) {
                return;
            }
            if (h(a2)) {
                d();
                return;
            }
            if (this.f.get(r11.size() - 1).isEmpty()) {
                this.f.set(r11.size() - 1, a2);
            } else {
                this.f.add(a2);
            }
            if (z) {
                this.f.add("");
            }
        }

        private boolean g(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void d() {
            if (this.f.remove(r0.size() - 1).isEmpty() && !this.f.isEmpty()) {
                this.f.set(r0.size() - 1, "");
            } else {
                this.f.add("");
            }
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    return -1;
                }
                char charAt2 = str.charAt(i);
                if (charAt2 < 'a' || charAt2 > 'z') {
                    if (charAt2 < 'A' || charAt2 > 'Z') {
                        if (charAt2 < '0' || charAt2 > '9') {
                            if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                if (charAt2 == ':') {
                                    return i;
                                }
                                return -1;
                            }
                        }
                    }
                }
            }
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt != '[') {
                    i++;
                }
                do {
                    i++;
                    if (i < i2) {
                    }
                    i++;
                } while (str.charAt(i) != ']');
                i++;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            return okhttp3.internal.c.a(t.a(str, i, i2, false));
        }

        private static int f(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(t.a(str, i, i2, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                okio.c cVar = new okio.c();
                cVar.a(str, i, i3);
                a(cVar, str, i3, i2, z);
                return cVar.p();
            }
        }
        return str.substring(i, i2);
    }

    static void a(okio.c cVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int a2 = okhttp3.internal.c.a(str.charAt(i + 1));
                int a3 = okhttp3.internal.c.a(str.charAt(i3));
                if (a2 != -1 && a3 != -1) {
                    cVar.i((a2 << 4) + a3);
                    i = i3;
                }
                cVar.a(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    cVar.i(32);
                }
                cVar.a(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && okhttp3.internal.c.a(str.charAt(i + 1)) != -1 && okhttp3.internal.c.a(str.charAt(i3)) != -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            okio.c cVar = new okio.c();
            cVar.a(str, i, i3);
            a(cVar, str, i3, i2, str2, z, z2, z3, z4, charset);
            return cVar.p();
        }
        return str.substring(i, i2);
    }

    static void a(okio.c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        okio.c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.b(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i, i2)))))) {
                    if (cVar2 == null) {
                        cVar2 = new okio.c();
                    }
                    if (charset == null || charset.equals(okhttp3.internal.c.e)) {
                        cVar2.a(codePointAt);
                    } else {
                        cVar2.a(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!cVar2.f()) {
                        int i3 = cVar2.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                        cVar.i(37);
                        cVar.i((int) d[(i3 >> 4) & 15]);
                        cVar.i((int) d[i3 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
