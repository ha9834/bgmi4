package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzfl<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, AtomicReference<T>> f3635a = new HashMap();

    public final AtomicReference<T> zzar(String str) {
        synchronized (this) {
            if (!this.f3635a.containsKey(str)) {
                this.f3635a.put(str, new AtomicReference<>());
            }
        }
        return this.f3635a.get(str);
    }
}
