package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
abstract class cn {

    /* renamed from: a, reason: collision with root package name */
    private static final cn f4505a;
    private static final cn b;

    private cn() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cn a() {
        return f4505a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cn b() {
        return b;
    }

    static {
        cm cmVar = null;
        f4505a = new cp();
        b = new co();
    }
}
