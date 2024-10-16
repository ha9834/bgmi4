package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzar {

    /* renamed from: a, reason: collision with root package name */
    private final int f2785a;
    private final List<zzl> b;
    private final int c;
    private final InputStream d;

    public zzar(int i, List<zzl> list) {
        this(i, list, -1, null);
    }

    public zzar(int i, List<zzl> list, int i2, InputStream inputStream) {
        this.f2785a = i;
        this.b = list;
        this.c = i2;
        this.d = inputStream;
    }

    public final int getStatusCode() {
        return this.f2785a;
    }

    public final List<zzl> zzq() {
        return Collections.unmodifiableList(this.b);
    }

    public final int getContentLength() {
        return this.c;
    }

    public final InputStream getContent() {
        return this.d;
    }
}
