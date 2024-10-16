package com.subao.common.e;

import android.text.TextUtils;
import java.util.List;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5977a;
    public final int b;
    public final int c;
    public final boolean d;
    private final String e;
    private final List<a> f;
    private final List<a> g;
    private final List<String> h;
    private final List<String> i;

    private b(String str, int i, String str2, int i2, List<a> list, List<a> list2, List<String> list3, List<String> list4) {
        this.f5977a = str;
        this.b = i;
        this.e = str2;
        this.c = i2;
        if (this.f5977a.length() == 3) {
            this.d = a(this.f5977a);
        } else {
            this.d = false;
        }
        this.f = list;
        this.g = list2;
        this.i = list3;
        this.h = list4;
    }

    private static boolean a(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt < ' ' || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    public static b a(String str, int i, String str2, int i2, List<a> list, List<a> list2, List<String> list3, List<String> list4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new b(str, i, str2, i2, list, list2, list3, list4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(int i) {
        return new b(this.f5977a, this.b, this.e, i, this.f, this.g, this.i, this.h);
    }

    public boolean a() {
        return (this.c & 1) != 0;
    }

    public boolean b() {
        return (this.c & 2) != 0;
    }

    public boolean c() {
        return this.b == 2;
    }

    public com.subao.common.j.n d() {
        int i = this.c;
        if ((i & 16) != 0) {
            if ((i & 32) != 0) {
                return com.subao.common.j.n.BOTH;
            }
            return com.subao.common.j.n.UDP;
        }
        if ((i & 32) != 0) {
            return com.subao.common.j.n.TCP;
        }
        return com.subao.common.j.n.BOTH;
    }

    public int e() {
        return this.c;
    }

    public Iterable<a> f() {
        return this.f;
    }

    public Iterable<a> g() {
        return this.g;
    }

    public Iterable<String> h() {
        return this.h;
    }

    public Iterable<String> i() {
        return this.i;
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5978a;
        public final int b;

        public a(int i, int i2) {
            this.f5978a = i;
            this.b = i2;
        }

        public String toString() {
            return String.format(r.f6001a, "[startPort=%d, endPort=%d]", Integer.valueOf(this.f5978a), Integer.valueOf(this.b));
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5978a == aVar.f5978a && this.b == aVar.b;
        }
    }
}
