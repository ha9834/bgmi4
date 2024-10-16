package com.google.android.gms.internal.firebase_remote_config;

import java.util.List;

/* loaded from: classes2.dex */
abstract class cl {

    /* renamed from: a, reason: collision with root package name */
    private static final cl f4063a;
    private static final cl b;

    private cl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cl a() {
        return f4063a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cl b() {
        return b;
    }

    static {
        cn cnVar = null;
        f4063a = new cm();
        b = new cp();
    }
}
