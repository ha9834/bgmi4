package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private String f975a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f976a;

        private a() {
        }

        /* synthetic */ a(ae aeVar) {
        }

        public a a(String str) {
            this.f976a = str;
            return this;
        }

        public i a() {
            if (this.f976a != null) {
                i iVar = new i(null);
                iVar.f975a = this.f976a;
                return iVar;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }
    }

    private i() {
    }

    /* synthetic */ i(ae aeVar) {
    }

    public static a b() {
        return new a(null);
    }

    public String a() {
        return this.f975a;
    }
}
