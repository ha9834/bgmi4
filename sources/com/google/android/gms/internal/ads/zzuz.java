package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzuz {

    /* renamed from: a, reason: collision with root package name */
    private final float f3755a;
    private final float b;
    private final float c;
    private final float d;
    private final int e;

    @VisibleForTesting
    public zzuz(float f, float f2, float f3, float f4, int i) {
        this.f3755a = f;
        this.b = f2;
        this.c = f + f3;
        this.d = f2 + f4;
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float a() {
        return this.f3755a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float d() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e() {
        return this.e;
    }
}
