package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private int f973a;
    private String b;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f974a;
        private String b = "";

        private a() {
        }

        /* synthetic */ a(ac acVar) {
        }

        public a a(int i) {
            this.f974a = i;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public h a() {
            h hVar = new h();
            hVar.f973a = this.f974a;
            hVar.b = this.b;
            return hVar;
        }
    }

    public static a c() {
        return new a(null);
    }

    public int a() {
        return this.f973a;
    }

    public String b() {
        return this.b;
    }
}
