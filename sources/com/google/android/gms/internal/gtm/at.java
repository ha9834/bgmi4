package com.google.android.gms.internal.gtm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class at {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<au, List<Throwable>> f4305a = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.b.poll();
        while (poll != null) {
            this.f4305a.remove(poll);
            poll = this.b.poll();
        }
        return this.f4305a.get(new au(th, null));
    }
}
