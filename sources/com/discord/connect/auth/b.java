package com.discord.connect.auth;

import java.util.List;
import lombok.NonNull;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f1066a;

    @NonNull
    public final String b;

    @NonNull
    public final List<Scope> c;

    public b(long j, @NonNull String str, @NonNull List<Scope> list) {
        if (str == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("scopes is marked non-null but is null");
        }
        this.f1066a = j;
        this.b = str;
        this.c = list;
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
        if (!bVar.a(this) || b() != bVar.b()) {
            return false;
        }
        String c = c();
        String c2 = bVar.c();
        if (c != null ? !c.equals(c2) : c2 != null) {
            return false;
        }
        List<Scope> d = d();
        List<Scope> d2 = bVar.d();
        return d != null ? d.equals(d2) : d2 == null;
    }

    public int hashCode() {
        long b = b();
        String c = c();
        int hashCode = ((((int) (b ^ (b >>> 32))) + 59) * 59) + (c == null ? 43 : c.hashCode());
        List<Scope> d = d();
        return (hashCode * 59) + (d != null ? d.hashCode() : 43);
    }

    public String toString() {
        return "OAuth2Request(clientId=" + b() + ", redirectUri=" + c() + ", scopes=" + d() + ")";
    }

    public long b() {
        return this.f1066a;
    }

    @NonNull
    public String c() {
        return this.b;
    }

    @NonNull
    public List<Scope> d() {
        return this.c;
    }

    public String[] a() {
        String[] strArr = new String[this.c.size()];
        for (int i = 0; i < this.c.size(); i++) {
            strArr[i] = this.c.get(i).a();
        }
        return strArr;
    }
}
