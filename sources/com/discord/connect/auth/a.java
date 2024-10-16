package com.discord.connect.auth;

import lombok.NonNull;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f1065a;

    @NonNull
    public final String b;

    @NonNull
    public final String c;
    public final long d;

    @NonNull
    public final String e;

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, long j, @NonNull String str4) {
        if (str == null) {
            throw new NullPointerException("accessToken is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("scope is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("tokenType is marked non-null but is null");
        }
        if (str4 == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        this.f1065a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = str4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (d() != aVar.d()) {
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
        String e = e();
        String e2 = aVar.e();
        return e != null ? e.equals(e2) : e2 == null;
    }

    public int hashCode() {
        long d = d();
        String a2 = a();
        int hashCode = ((((int) (d ^ (d >>> 32))) + 59) * 59) + (a2 == null ? 43 : a2.hashCode());
        String b = b();
        int hashCode2 = (hashCode * 59) + (b == null ? 43 : b.hashCode());
        String c = c();
        int hashCode3 = (hashCode2 * 59) + (c == null ? 43 : c.hashCode());
        String e = e();
        return (hashCode3 * 59) + (e != null ? e.hashCode() : 43);
    }

    public String toString() {
        return "Authorization(accessToken=" + a() + ", scope=" + b() + ", tokenType=" + c() + ", expiresInSecs=" + d() + ", refreshToken=" + e() + ")";
    }

    @NonNull
    public String a() {
        return this.f1065a;
    }

    @NonNull
    public String b() {
        return this.b;
    }

    @NonNull
    public String c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    @NonNull
    public String e() {
        return this.e;
    }
}
