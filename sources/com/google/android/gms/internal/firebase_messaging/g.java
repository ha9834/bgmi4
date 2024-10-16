package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<f, List<Throwable>> f4014a = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.b.poll();
        while (poll != null) {
            this.f4014a.remove(poll);
            poll = this.b.poll();
        }
        List<Throwable> list = this.f4014a.get(new f(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f4014a.putIfAbsent(new f(th, this.b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
