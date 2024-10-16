package com.shieldtunnel.svpn.common.f;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static C0151c f5805a = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5806a;

        static {
            int[] iArr = new int[d.values().length];
            f5806a = iArr;
            try {
                iArr[d.DRONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5806a[d.PORTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class b extends C0151c {
        b() {
            super("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.shieldtunnel.svpn.common.f.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0151c {

        /* renamed from: a, reason: collision with root package name */
        private final String f5807a;

        C0151c(String str) {
            this.f5807a = str;
        }

        String a() {
            return String.format("drone%s.%s", this.f5807a, "shield-tunnel.com");
        }

        String b() {
            return String.format("portal%s.%s", this.f5807a, "shield-tunnel.com");
        }
    }

    /* loaded from: classes2.dex */
    public enum d {
        DRONE,
        PORTAL
    }

    private static String a(d dVar) {
        int i = a.f5806a[dVar.ordinal()];
        if (i != 1) {
            return i != 2 ? "shield-tunnel.com" : f5805a.b();
        }
        return f5805a.a();
    }

    public static void a(String str) {
    }

    public static q b(d dVar) {
        return new q("https", a(dVar), dVar == d.DRONE ? 504 : -1);
    }
}
