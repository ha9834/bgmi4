package com.google.android.gms.internal.gtm;

import java.util.List;

/* loaded from: classes2.dex */
abstract class cc {

    /* renamed from: a, reason: collision with root package name */
    private static final cc f4330a;
    private static final cc b;

    private cc() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cc a() {
        return f4330a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cc b() {
        return b;
    }

    static {
        cd cdVar = null;
        f4330a = new ce();
        b = new cf();
    }
}
