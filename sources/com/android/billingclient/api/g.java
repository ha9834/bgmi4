package com.android.billingclient.api;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f971a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f = 0;
    private ArrayList<p> g;
    private boolean h;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f972a;
        private String b;
        private String c;
        private String d;
        private int e = 0;
        private ArrayList<p> f;
        private boolean g;

        private a() {
        }

        /* synthetic */ a(ab abVar) {
        }

        public a a(int i) {
            this.e = i;
            return this;
        }

        public a a(p pVar) {
            ArrayList<p> arrayList = new ArrayList<>();
            arrayList.add(pVar);
            this.f = arrayList;
            return this;
        }

        public a a(String str) {
            this.f972a = str;
            return this;
        }

        public a a(String str, String str2) {
            this.b = str;
            this.c = str2;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public g a() {
            ArrayList<p> arrayList = this.f;
            if (arrayList == null || arrayList.isEmpty()) {
                throw new IllegalArgumentException("SkuDetails must be provided.");
            }
            ArrayList<p> arrayList2 = this.f;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                if (arrayList2.get(i) == null) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                i = i2;
            }
            if (this.f.size() > 1) {
                p pVar = this.f.get(0);
                String c = pVar.c();
                ArrayList<p> arrayList3 = this.f;
                int size2 = arrayList3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    p pVar2 = arrayList3.get(i3);
                    if (!c.equals("play_pass_subs") && !pVar2.c().equals("play_pass_subs") && !c.equals(pVar2.c())) {
                        throw new IllegalArgumentException("SKUs should have the same type.");
                    }
                }
                String m = pVar.m();
                ArrayList<p> arrayList4 = this.f;
                int size3 = arrayList4.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    p pVar3 = arrayList4.get(i4);
                    if (!c.equals("play_pass_subs") && !pVar3.c().equals("play_pass_subs") && !m.equals(pVar3.m())) {
                        throw new IllegalArgumentException("All SKUs must have the same package name.");
                    }
                }
            }
            g gVar = new g(null);
            gVar.f971a = true ^ this.f.get(0).m().isEmpty();
            gVar.b = this.f972a;
            gVar.e = this.d;
            gVar.c = this.b;
            gVar.d = this.c;
            gVar.f = this.e;
            gVar.g = this.f;
            gVar.h = this.g;
            return gVar;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }
    }

    private g() {
    }

    /* synthetic */ g(ab abVar) {
    }

    public static a e() {
        return new a(null);
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public boolean c() {
        return this.h;
    }

    public int d() {
        return this.f;
    }

    public final ArrayList<p> f() {
        ArrayList<p> arrayList = new ArrayList<>();
        arrayList.addAll(this.g);
        return arrayList;
    }

    public final String g() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h() {
        return (!this.h && this.b == null && this.e == null && this.f == 0 && !this.f971a) ? false : true;
    }

    public final String i() {
        return this.e;
    }
}
