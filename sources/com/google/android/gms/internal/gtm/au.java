package com.google.android.gms.internal.gtm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class au extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f4306a;

    public au(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f4306a = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.f4306a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        au auVar = (au) obj;
        return this.f4306a == auVar.f4306a && get() == auVar.get();
    }
}
