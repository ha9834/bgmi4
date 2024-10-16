package com.google.android.gms.internal.firebase_remote_config;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class al extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f4029a;

    public al(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f4029a = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.f4029a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        al alVar = (al) obj;
        return this.f4029a == alVar.f4029a && get() == alVar.get();
    }
}
