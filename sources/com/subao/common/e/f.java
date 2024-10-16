package com.subao.common.e;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static String f5983a = "cn";
    private static b b = new c();

    /* loaded from: classes2.dex */
    public enum g {
        DRONE,
        PORTAL,
        HR,
        ISP,
        VAULT
    }

    public static void a(String str) {
        char c2;
        f5983a = str;
        int hashCode = str.hashCode();
        if (hashCode == 3179) {
            if (str.equals("cn")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 3365) {
            if (hashCode == 3651 && str.equals("ru")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals("in")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        switch (c2) {
            case 0:
                b = new c();
                return;
            case 1:
                b = new C0167f();
                return;
            case 2:
                b = new d();
                return;
            default:
                b = new e();
                return;
        }
    }

    public static String a() {
        return f5983a;
    }

    public static an a(g gVar) {
        return new an("https", b(gVar), gVar == g.DRONE ? 504 : -1);
    }

    public static String b(g gVar) {
        switch (gVar) {
            case DRONE:
                return b.b();
            case PORTAL:
                return b.d();
            case ISP:
                return b.a();
            default:
                return b.c();
        }
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5985a;
        public final int b;

        public a(String str, int i) {
            this.f5985a = str;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && com.subao.common.e.a(this.f5985a, aVar.f5985a);
        }

        public String toString() {
            return String.format(r.f6001a, "[%s:%d]", this.f5985a, Integer.valueOf(this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class b {
        String a() {
            return "isp-map.xunyou.mobi";
        }

        abstract String e();

        private b() {
        }

        String b() {
            return String.format("drone%s.xunyou.mobi", e());
        }

        String c() {
            return String.format("api%s.xunyou.mobi", e());
        }

        String d() {
            return String.format("portal%s.xunyou.mobi", e());
        }
    }

    /* loaded from: classes2.dex */
    static class c extends b {
        @Override // com.subao.common.e.f.b
        String e() {
            return "";
        }

        c() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    static class d extends b {
        @Override // com.subao.common.e.f.b
        String e() {
            return "-in";
        }

        d() {
            super();
        }
    }

    /* renamed from: com.subao.common.e.f$f, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0167f extends b {
        @Override // com.subao.common.e.f.b
        String e() {
            return "-ru";
        }

        C0167f() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    static class e extends b {
        @Override // com.subao.common.e.f.b
        String e() {
            return "-sg";
        }

        e() {
            super();
        }
    }
}
