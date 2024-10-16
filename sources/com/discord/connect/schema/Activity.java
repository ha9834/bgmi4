package com.discord.connect.schema;

import com.discord.connect.a.e;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import lombok.NonNull;

/* loaded from: classes.dex */
public final class Activity {
    public static int n = 1;
    public static int o = 2;
    public static int p = 4;
    public static int q = 16;
    public static int r = 32;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final Type f1081a;

    @JsonAdapter(e.class)
    public final long b;

    @NonNull
    public final String c;

    @NonNull
    public final Platform d;

    @NonNull
    public final List<Platform> e;
    public final String f;
    public final String g;
    public final String h;
    public final d i;
    public final a j;
    public final b k;
    public final c l;
    public final int m;

    /* loaded from: classes.dex */
    public enum Platform {
        ANDROID,
        DESKTOP,
        IOS
    }

    public Activity(@NonNull Type type, long j, @NonNull String str, @NonNull Platform platform, @NonNull List<Platform> list, String str2, String str3, String str4, d dVar, a aVar, b bVar, c cVar, int i) {
        if (type == null) {
            throw new NullPointerException("type is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (platform == null) {
            throw new NullPointerException("platform is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("supportedPlatforms is marked non-null but is null");
        }
        this.f1081a = type;
        this.b = j;
        this.c = str;
        this.d = platform;
        this.e = list;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = dVar;
        this.j = aVar;
        this.k = bVar;
        this.l = cVar;
        this.m = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) obj;
        if (b() != activity.b() || m() != activity.m()) {
            return false;
        }
        Type a2 = a();
        Type a3 = activity.a();
        if (a2 != null ? !a2.equals(a3) : a3 != null) {
            return false;
        }
        String c2 = c();
        String c3 = activity.c();
        if (c2 != null ? !c2.equals(c3) : c3 != null) {
            return false;
        }
        Platform d2 = d();
        Platform d3 = activity.d();
        if (d2 != null ? !d2.equals(d3) : d3 != null) {
            return false;
        }
        List<Platform> e = e();
        List<Platform> e2 = activity.e();
        if (e != null ? !e.equals(e2) : e2 != null) {
            return false;
        }
        String f = f();
        String f2 = activity.f();
        if (f != null ? !f.equals(f2) : f2 != null) {
            return false;
        }
        String g = g();
        String g2 = activity.g();
        if (g != null ? !g.equals(g2) : g2 != null) {
            return false;
        }
        String h = h();
        String h2 = activity.h();
        if (h != null ? !h.equals(h2) : h2 != null) {
            return false;
        }
        d i = i();
        d i2 = activity.i();
        if (i != null ? !i.equals(i2) : i2 != null) {
            return false;
        }
        a j = j();
        a j2 = activity.j();
        if (j != null ? !j.equals(j2) : j2 != null) {
            return false;
        }
        b k = k();
        b k2 = activity.k();
        if (k != null ? !k.equals(k2) : k2 != null) {
            return false;
        }
        c l = l();
        c l2 = activity.l();
        return l != null ? l.equals(l2) : l2 == null;
    }

    public int hashCode() {
        long b2 = b();
        int m = ((((int) (b2 ^ (b2 >>> 32))) + 59) * 59) + m();
        Type a2 = a();
        int hashCode = (m * 59) + (a2 == null ? 43 : a2.hashCode());
        String c2 = c();
        int hashCode2 = (hashCode * 59) + (c2 == null ? 43 : c2.hashCode());
        Platform d2 = d();
        int hashCode3 = (hashCode2 * 59) + (d2 == null ? 43 : d2.hashCode());
        List<Platform> e = e();
        int hashCode4 = (hashCode3 * 59) + (e == null ? 43 : e.hashCode());
        String f = f();
        int hashCode5 = (hashCode4 * 59) + (f == null ? 43 : f.hashCode());
        String g = g();
        int hashCode6 = (hashCode5 * 59) + (g == null ? 43 : g.hashCode());
        String h = h();
        int hashCode7 = (hashCode6 * 59) + (h == null ? 43 : h.hashCode());
        d i = i();
        int hashCode8 = (hashCode7 * 59) + (i == null ? 43 : i.hashCode());
        a j = j();
        int hashCode9 = (hashCode8 * 59) + (j == null ? 43 : j.hashCode());
        b k = k();
        int hashCode10 = (hashCode9 * 59) + (k == null ? 43 : k.hashCode());
        c l = l();
        return (hashCode10 * 59) + (l != null ? l.hashCode() : 43);
    }

    public String toString() {
        return "Activity(type=" + a() + ", applicationId=" + b() + ", name=" + c() + ", platform=" + d() + ", supportedPlatforms=" + e() + ", sessionId=" + f() + ", state=" + g() + ", details=" + h() + ", timestamps=" + i() + ", assets=" + j() + ", party=" + k() + ", secrets=" + l() + ", flags=" + m() + ")";
    }

    @NonNull
    public Type a() {
        return this.f1081a;
    }

    public long b() {
        return this.b;
    }

    @NonNull
    public String c() {
        return this.c;
    }

    @NonNull
    public Platform d() {
        return this.d;
    }

    @NonNull
    public List<Platform> e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public d i() {
        return this.i;
    }

    public a j() {
        return this.j;
    }

    public b k() {
        return this.k;
    }

    public c l() {
        return this.l;
    }

    public int m() {
        return this.m;
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Long f1088a;
        public final Long b;

        public d(Long l, Long l2) {
            this.f1088a = l;
            this.b = l2;
        }

        protected boolean a(Object obj) {
            return obj instanceof d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!dVar.a(this)) {
                return false;
            }
            Long a2 = a();
            Long a3 = dVar.a();
            if (a2 != null ? !a2.equals(a3) : a3 != null) {
                return false;
            }
            Long b = b();
            Long b2 = dVar.b();
            return b != null ? b.equals(b2) : b2 == null;
        }

        public int hashCode() {
            Long a2 = a();
            int hashCode = a2 == null ? 43 : a2.hashCode();
            Long b = b();
            return ((hashCode + 59) * 59) + (b != null ? b.hashCode() : 43);
        }

        public String toString() {
            return "Activity.Timestamp(start=" + a() + ", end=" + b() + ")";
        }

        public Long a() {
            return this.f1088a;
        }

        public Long b() {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f1084a;
        public final String b;
        public final String c;
        public final String d;

        public a(String str, String str2, String str3, String str4) {
            this.f1084a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String a2 = a();
            String a3 = aVar.a();
            if (a2 != null ? !a2.equals(a3) : a3 != null) {
                return false;
            }
            String b = b();
            String b2 = aVar.b();
            if (b != null ? !b.equals(b2) : b2 != null) {
                return false;
            }
            String c = c();
            String c2 = aVar.c();
            if (c != null ? !c.equals(c2) : c2 != null) {
                return false;
            }
            String d = d();
            String d2 = aVar.d();
            return d != null ? d.equals(d2) : d2 == null;
        }

        public int hashCode() {
            String a2 = a();
            int hashCode = a2 == null ? 43 : a2.hashCode();
            String b = b();
            int hashCode2 = ((hashCode + 59) * 59) + (b == null ? 43 : b.hashCode());
            String c = c();
            int hashCode3 = (hashCode2 * 59) + (c == null ? 43 : c.hashCode());
            String d = d();
            return (hashCode3 * 59) + (d != null ? d.hashCode() : 43);
        }

        public String toString() {
            return "Activity.Assets(largeImage=" + a() + ", largeText=" + b() + ", smallImage=" + c() + ", smallText=" + d() + ")";
        }

        public String a() {
            return this.f1084a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public final String f1085a;

        @NonNull
        public final a b;

        public b(@NonNull String str, @NonNull a aVar) {
            if (str == null) {
                throw new NullPointerException("id is marked non-null but is null");
            }
            if (aVar == null) {
                throw new NullPointerException("size is marked non-null but is null");
            }
            this.f1085a = str;
            this.b = aVar;
        }

        protected boolean a(Object obj) {
            return obj instanceof b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.a(this)) {
                return false;
            }
            String a2 = a();
            String a3 = bVar.a();
            if (a2 != null ? !a2.equals(a3) : a3 != null) {
                return false;
            }
            a b = b();
            a b2 = bVar.b();
            return b != null ? b.equals(b2) : b2 == null;
        }

        public int hashCode() {
            String a2 = a();
            int hashCode = a2 == null ? 43 : a2.hashCode();
            a b = b();
            return ((hashCode + 59) * 59) + (b != null ? b.hashCode() : 43);
        }

        public String toString() {
            return "Activity.Party(id=" + a() + ", size=" + b() + ")";
        }

        @NonNull
        public String a() {
            return this.f1085a;
        }

        @NonNull
        public a b() {
            return this.b;
        }

        @JsonAdapter(com.discord.connect.a.c.class)
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final int f1086a;
            public final int b;

            public a(int i, int i2) {
                this.f1086a = i;
                this.b = i2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f1087a;
        public final String b;

        public c(String str, String str2) {
            this.f1087a = str;
            this.b = str2;
        }

        protected boolean a(Object obj) {
            return obj instanceof c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.a(this)) {
                return false;
            }
            String a2 = a();
            String a3 = cVar.a();
            if (a2 != null ? !a2.equals(a3) : a3 != null) {
                return false;
            }
            String b = b();
            String b2 = cVar.b();
            return b != null ? b.equals(b2) : b2 == null;
        }

        public int hashCode() {
            String a2 = a();
            int hashCode = a2 == null ? 43 : a2.hashCode();
            String b = b();
            return ((hashCode + 59) * 59) + (b != null ? b.hashCode() : 43);
        }

        public String toString() {
            return "Activity.Secrets(join=" + a() + ", spectate=" + b() + ")";
        }

        public String a() {
            return this.f1087a;
        }

        public String b() {
            return this.b;
        }
    }

    @JsonAdapter(com.discord.connect.schema.b.class)
    /* loaded from: classes.dex */
    public enum Type implements com.discord.connect.a.b {
        Playing(0),
        Streaming(1),
        Listening(2),
        Watching(3),
        CustomStatus(4),
        Unknown(-1);

        private final int raw;

        Type(int i) {
            this.raw = i;
        }

        @Override // com.discord.connect.a.b
        public int a() {
            return this.raw;
        }
    }
}
