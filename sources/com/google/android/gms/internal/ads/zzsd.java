package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzsd {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f3729a = new HashMap();
    private Map<String, String> b;

    public final synchronized Map<String, String> zzjw() {
        if (this.b == null) {
            this.b = Collections.unmodifiableMap(new HashMap(this.f3729a));
        }
        return this.b;
    }
}
