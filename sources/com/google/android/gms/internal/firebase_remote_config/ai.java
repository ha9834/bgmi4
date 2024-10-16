package com.google.android.gms.internal.firebase_remote_config;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class ai {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<al, List<Throwable>> f4026a = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.b.poll();
        while (poll != null) {
            this.f4026a.remove(poll);
            poll = this.b.poll();
        }
        List<Throwable> list = this.f4026a.get(new al(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f4026a.putIfAbsent(new al(th, this.b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
