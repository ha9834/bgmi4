package com.google.android.gms.tagmanager;

import java.util.List;

/* loaded from: classes2.dex */
final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ List f5150a;
    private final /* synthetic */ long b;
    private final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, List list, long j) {
        this.c = qVar;
        this.f5150a = list;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.b(this.f5150a, this.b);
    }
}
