package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class cv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final cw f4794a;
    private final int b;
    private final Throwable c;
    private final byte[] d;
    private final String e;
    private final Map<String, List<String>> f;

    private cv(String str, cw cwVar, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.checkNotNull(cwVar);
        this.f4794a = cwVar;
        this.b = i;
        this.c = th;
        this.d = bArr;
        this.e = str;
        this.f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4794a.a(this.e, this.b, this.c, this.d, this.f);
    }
}
