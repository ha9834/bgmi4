package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    final String f4775a;
    final String b;
    final long c;
    final long d;
    final long e;
    final long f;
    final long g;
    final Long h;
    final Long i;
    final Long j;
    final Boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(j2 >= 0);
        Preconditions.checkArgument(j3 >= 0);
        Preconditions.checkArgument(j5 >= 0);
        this.f4775a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = l;
        this.i = l2;
        this.j = l3;
        this.k = bool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        this(str, str2, j, j2, 0L, j3, 0L, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c a(long j) {
        return new c(this.f4775a, this.b, this.c, this.d, this.e, j, this.g, this.h, this.i, this.j, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c a(long j, long j2) {
        return new c(this.f4775a, this.b, this.c, this.d, this.e, this.f, j, Long.valueOf(j2), this.i, this.j, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c a(Long l, Long l2, Boolean bool) {
        return new c(this.f4775a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }
}
