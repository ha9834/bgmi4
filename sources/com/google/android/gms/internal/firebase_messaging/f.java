package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class f extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f4013a;

    public f(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f4013a = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.f4013a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        f fVar = (f) obj;
        return this.f4013a == fVar.f4013a && get() == fVar.get();
    }
}
