package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private String f981a;
    private List<String> b;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f982a;
        private List<String> b;

        private a() {
        }

        /* synthetic */ a(ah ahVar) {
        }

        public a a(String str) {
            this.f982a = str;
            return this;
        }

        public a a(List<String> list) {
            this.b = new ArrayList(list);
            return this;
        }

        public q a() {
            if (this.f982a != null) {
                if (this.b != null) {
                    q qVar = new q();
                    qVar.f981a = this.f982a;
                    qVar.b = this.b;
                    return qVar;
                }
                throw new IllegalArgumentException("SKU list or SkuWithOffer list must be set");
            }
            throw new IllegalArgumentException("SKU type must be set");
        }
    }

    public static a c() {
        return new a(null);
    }

    public String a() {
        return this.f981a;
    }

    public List<String> b() {
        return this.b;
    }
}
