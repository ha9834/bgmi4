package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class aej extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f1831a;

    public aej(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f1831a = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.f1831a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        aej aejVar = (aej) obj;
        return this.f1831a == aejVar.f1831a && get() == aejVar.get();
    }
}
