package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
final class gv {

    /* renamed from: a, reason: collision with root package name */
    final String f4895a;
    final String b;
    final String c;
    final long d;
    final Object e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gv(String str, String str2, String str3, long j, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(obj);
        this.f4895a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = obj;
    }
}
