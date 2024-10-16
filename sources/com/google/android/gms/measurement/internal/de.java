package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class de {
    private long A;
    private long B;
    private String C;
    private boolean D;
    private long E;
    private long F;

    /* renamed from: a, reason: collision with root package name */
    private final zzfj f4802a;
    private final String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;
    private long h;
    private long i;
    private String j;
    private long k;
    private String l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private boolean q;
    private boolean r;
    private String s;
    private Boolean t;
    private long u;
    private List<String> v;
    private long w;
    private long x;
    private long y;
    private long z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(zzfj zzfjVar, String str) {
        Preconditions.checkNotNull(zzfjVar);
        Preconditions.checkNotEmpty(str);
        this.f4802a = zzfjVar;
        this.b = str;
        this.f4802a.zzaa().zzo();
    }

    public final void a() {
        this.f4802a.zzaa().zzo();
        this.D = false;
    }

    public final String b() {
        this.f4802a.zzaa().zzo();
        return this.b;
    }

    public final String c() {
        this.f4802a.zzaa().zzo();
        return this.c;
    }

    public final void a(String str) {
        this.f4802a.zzaa().zzo();
        this.D |= !zzjs.d(this.c, str);
        this.c = str;
    }

    public final String d() {
        this.f4802a.zzaa().zzo();
        return this.d;
    }

    public final void b(String str) {
        this.f4802a.zzaa().zzo();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.D |= !zzjs.d(this.d, str);
        this.d = str;
    }

    public final String e() {
        this.f4802a.zzaa().zzo();
        return this.s;
    }

    public final void c(String str) {
        this.f4802a.zzaa().zzo();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.D |= !zzjs.d(this.s, str);
        this.s = str;
    }

    public final String f() {
        this.f4802a.zzaa().zzo();
        return this.e;
    }

    public final void d(String str) {
        this.f4802a.zzaa().zzo();
        this.D |= !zzjs.d(this.e, str);
        this.e = str;
    }

    public final String g() {
        this.f4802a.zzaa().zzo();
        return this.f;
    }

    public final void e(String str) {
        this.f4802a.zzaa().zzo();
        this.D |= !zzjs.d(this.f, str);
        this.f = str;
    }

    public final long h() {
        this.f4802a.zzaa().zzo();
        return this.h;
    }

    public final void a(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.h != j;
        this.h = j;
    }

    public final long i() {
        this.f4802a.zzaa().zzo();
        return this.i;
    }

    public final void b(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.i != j;
        this.i = j;
    }

    public final String j() {
        this.f4802a.zzaa().zzo();
        return this.j;
    }

    public final void f(String str) {
        this.f4802a.zzaa().zzo();
        this.D |= !zzjs.d(this.j, str);
        this.j = str;
    }

    public final long k() {
        this.f4802a.zzaa().zzo();
        return this.k;
    }

    public final void c(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.k != j;
        this.k = j;
    }

    public final String l() {
        this.f4802a.zzaa().zzo();
        return this.l;
    }

    public final void g(String str) {
        this.f4802a.zzaa().zzo();
        this.D |= !zzjs.d(this.l, str);
        this.l = str;
    }

    public final long m() {
        this.f4802a.zzaa().zzo();
        return this.m;
    }

    public final void d(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.m != j;
        this.m = j;
    }

    public final long n() {
        this.f4802a.zzaa().zzo();
        return this.n;
    }

    public final void e(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.n != j;
        this.n = j;
    }

    public final long o() {
        this.f4802a.zzaa().zzo();
        return this.u;
    }

    public final void f(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.u != j;
        this.u = j;
    }

    public final boolean p() {
        this.f4802a.zzaa().zzo();
        return this.o;
    }

    public final void a(boolean z) {
        this.f4802a.zzaa().zzo();
        this.D |= this.o != z;
        this.o = z;
    }

    public final void g(long j) {
        Preconditions.checkArgument(j >= 0);
        this.f4802a.zzaa().zzo();
        this.D = (this.g != j) | this.D;
        this.g = j;
    }

    public final long q() {
        this.f4802a.zzaa().zzo();
        return this.g;
    }

    public final long r() {
        this.f4802a.zzaa().zzo();
        return this.E;
    }

    public final void h(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.E != j;
        this.E = j;
    }

    public final long s() {
        this.f4802a.zzaa().zzo();
        return this.F;
    }

    public final void i(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.F != j;
        this.F = j;
    }

    public final void t() {
        this.f4802a.zzaa().zzo();
        long j = this.g + 1;
        if (j > 2147483647L) {
            this.f4802a.zzab().zzgn().zza("Bundle index overflow. appId", zzef.a(this.b));
            j = 0;
        }
        this.D = true;
        this.g = j;
    }

    public final long u() {
        this.f4802a.zzaa().zzo();
        return this.w;
    }

    public final void j(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.w != j;
        this.w = j;
    }

    public final long v() {
        this.f4802a.zzaa().zzo();
        return this.x;
    }

    public final void k(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.x != j;
        this.x = j;
    }

    public final long w() {
        this.f4802a.zzaa().zzo();
        return this.y;
    }

    public final void l(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.y != j;
        this.y = j;
    }

    public final long x() {
        this.f4802a.zzaa().zzo();
        return this.z;
    }

    public final void m(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.z != j;
        this.z = j;
    }

    public final long y() {
        this.f4802a.zzaa().zzo();
        return this.B;
    }

    public final void n(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.B != j;
        this.B = j;
    }

    public final long z() {
        this.f4802a.zzaa().zzo();
        return this.A;
    }

    public final void o(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.A != j;
        this.A = j;
    }

    public final String A() {
        this.f4802a.zzaa().zzo();
        return this.C;
    }

    public final String B() {
        this.f4802a.zzaa().zzo();
        String str = this.C;
        h((String) null);
        return str;
    }

    public final void h(String str) {
        this.f4802a.zzaa().zzo();
        this.D |= !zzjs.d(this.C, str);
        this.C = str;
    }

    public final long C() {
        this.f4802a.zzaa().zzo();
        return this.p;
    }

    public final void p(long j) {
        this.f4802a.zzaa().zzo();
        this.D |= this.p != j;
        this.p = j;
    }

    public final boolean D() {
        this.f4802a.zzaa().zzo();
        return this.q;
    }

    public final void b(boolean z) {
        this.f4802a.zzaa().zzo();
        this.D = this.q != z;
        this.q = z;
    }

    public final boolean E() {
        this.f4802a.zzaa().zzo();
        return this.r;
    }

    public final void c(boolean z) {
        this.f4802a.zzaa().zzo();
        this.D = this.r != z;
        this.r = z;
    }

    public final Boolean F() {
        this.f4802a.zzaa().zzo();
        return this.t;
    }

    public final void a(Boolean bool) {
        this.f4802a.zzaa().zzo();
        this.D = !zzjs.a(this.t, bool);
        this.t = bool;
    }

    public final List<String> G() {
        this.f4802a.zzaa().zzo();
        return this.v;
    }

    public final void a(List<String> list) {
        this.f4802a.zzaa().zzo();
        if (zzjs.a(this.v, list)) {
            return;
        }
        this.D = true;
        this.v = list != null ? new ArrayList(list) : null;
    }
}
