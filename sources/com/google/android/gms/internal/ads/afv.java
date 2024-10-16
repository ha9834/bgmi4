package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
abstract class afv {

    /* renamed from: a, reason: collision with root package name */
    private static final afv f1856a;
    private static final afv b;

    private afv() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static afv a() {
        return f1856a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static afv b() {
        return b;
    }

    static {
        afw afwVar = null;
        f1856a = new afx();
        b = new afy();
    }
}
