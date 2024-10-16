package com.subao.common.e;

import com.subao.common.e.b;

/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    public final int f5973a;
    public final String b;
    public final String c;
    public final int d;
    public final com.subao.common.j.n e;
    public final boolean f;
    public final Iterable<b.a> g;
    public final Iterable<b.a> h;
    public final Iterable<String> i;
    public final Iterable<String> j;
    private final boolean k;

    public ap(int i, String str, String str2, int i2, com.subao.common.j.n nVar, boolean z, boolean z2, Iterable<b.a> iterable, Iterable<b.a> iterable2, Iterable<String> iterable3, Iterable<String> iterable4) {
        this.f5973a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = nVar;
        this.f = z;
        this.k = z2;
        this.g = iterable;
        this.h = iterable2;
        this.i = iterable3;
        this.j = iterable4;
    }

    public boolean a() {
        return this.k;
    }

    public String toString() {
        return String.format(r.f6001a, "[%s (uid=%d), protocol=%s, foreign=%b, fake=%b, white-ports='%s', black-ports='%s', white-ips='%s', black-ips='%s']", this.b, Integer.valueOf(this.f5973a), this.e.d, Boolean.valueOf(this.f), Boolean.valueOf(this.k), this.g, this.h, this.i, this.j);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ap)) {
            return false;
        }
        ap apVar = (ap) obj;
        return this.f5973a == apVar.f5973a && this.e == apVar.e && this.f == apVar.f && this.k == apVar.k && com.subao.common.e.a(this.b, apVar.b) && com.subao.common.e.a(this.c, apVar.c) && com.subao.common.e.a(this.g, apVar.g) && com.subao.common.e.a(this.h, apVar.h) && com.subao.common.e.a(this.i, apVar.i) && com.subao.common.e.a(this.j, apVar.j);
    }
}
