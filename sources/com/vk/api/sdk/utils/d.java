package com.vk.api.sdk.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6920a = new a(null);
    private final long b;
    private final long c;
    private final float d;
    private final float e;
    private final float f;
    private final Random g;
    private volatile long h;
    private volatile int i;

    public d() {
        this(0L, 0L, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public d(long j, long j2, float f, float f2, float f3) {
        this.b = j;
        this.c = j2;
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = new Random(System.currentTimeMillis());
        this.h = this.b;
    }

    public /* synthetic */ d(long j, long j2, float f, float f2, float f3, int i, kotlin.jvm.internal.f fVar) {
        this((i & 1) != 0 ? TimeUnit.MILLISECONDS.toMillis(100L) : j, (i & 2) != 0 ? TimeUnit.MINUTES.toMillis(5L) : j2, (i & 4) != 0 ? 2.0f : f, (i & 8) != 0 ? 5.0f : f2, (i & 16) != 0 ? 0.1f : f3);
    }

    public final long a() {
        return this.h;
    }

    public final int b() {
        return this.i;
    }

    public final boolean c() {
        return this.i > 0;
    }

    public final void d() {
        if (c()) {
            Thread.sleep(this.h);
        }
    }

    public final void e() {
        this.h = this.b;
        this.i = 0;
    }

    public final void f() {
        a(this.d);
    }

    private final void a(float f) {
        this.h = Math.min(((float) this.h) * f, (float) this.c);
        this.h += b(((float) this.h) * this.f);
        this.i++;
    }

    private final long b(float f) {
        double nextGaussian = this.g.nextGaussian();
        double d = f;
        Double.isNaN(d);
        return (long) (nextGaussian * d);
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }
}
