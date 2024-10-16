package okhttp3;

import com.amazonaws.services.s3.Headers;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f7054a = new a().a().c();
    public static final d b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();

    @Nullable
    String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    private d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.d = z;
        this.e = z2;
        this.f = i;
        this.g = i2;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i3;
        this.l = i4;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.c = str;
    }

    d(a aVar) {
        this.d = aVar.f7055a;
        this.e = aVar.b;
        this.f = aVar.c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = aVar.d;
        this.l = aVar.e;
        this.m = aVar.f;
        this.n = aVar.g;
        this.o = aVar.h;
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public boolean i() {
        return this.m;
    }

    public static d a(s sVar) {
        int i;
        String str;
        s sVar2 = sVar;
        int a2 = sVar.a();
        int i2 = 0;
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i5 = -1;
        int i6 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i2 < a2) {
            String a3 = sVar2.a(i2);
            String b2 = sVar2.b(i2);
            if (a3.equalsIgnoreCase(Headers.CACHE_CONTROL)) {
                if (str2 != null) {
                    z = false;
                } else {
                    str2 = b2;
                }
            } else if (a3.equalsIgnoreCase("Pragma")) {
                z = false;
            } else {
                i2++;
                sVar2 = sVar;
            }
            for (int i7 = 0; i7 < b2.length(); i7 = i) {
                int a4 = okhttp3.internal.b.e.a(b2, i7, "=,;");
                String trim = b2.substring(i7, a4).trim();
                if (a4 == b2.length() || b2.charAt(a4) == ',' || b2.charAt(a4) == ';') {
                    i = a4 + 1;
                    str = null;
                } else {
                    int a5 = okhttp3.internal.b.e.a(b2, a4 + 1);
                    if (a5 < b2.length() && b2.charAt(a5) == '\"') {
                        int i8 = a5 + 1;
                        int a6 = okhttp3.internal.b.e.a(b2, i8, "\"");
                        str = b2.substring(i8, a6);
                        i = a6 + 1;
                    } else {
                        i = okhttp3.internal.b.e.a(b2, a5, ",;");
                        str = b2.substring(a5, i).trim();
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(trim)) {
                    i3 = okhttp3.internal.b.e.b(str, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i4 = okhttp3.internal.b.e.b(str, -1);
                } else if ("private".equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(trim)) {
                    i5 = okhttp3.internal.b.e.b(str, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(trim)) {
                    i6 = okhttp3.internal.b.e.b(str, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(trim)) {
                    z9 = true;
                }
            }
            i2++;
            sVar2 = sVar;
        }
        return new d(z2, z3, i3, i4, z4, z5, z6, i5, i6, z7, z8, z9, !z ? null : str2);
    }

    public String toString() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String j = j();
        this.c = j;
        return j;
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("no-cache, ");
        }
        if (this.e) {
            sb.append("no-store, ");
        }
        if (this.f != -1) {
            sb.append("max-age=");
            sb.append(this.f);
            sb.append(", ");
        }
        if (this.g != -1) {
            sb.append("s-maxage=");
            sb.append(this.g);
            sb.append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=");
            sb.append(this.k);
            sb.append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=");
            sb.append(this.l);
            sb.append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f7055a;
        boolean b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        public a a() {
            this.f7055a = true;
            return this;
        }

        public a a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public a b() {
            this.f = true;
            return this;
        }

        public d c() {
            return new d(this);
        }
    }
}
