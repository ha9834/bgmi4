package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
final class kt {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<zzsa> f2301a = new ArrayList<>();
    private long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        Iterator<zzsa> it = this.f2301a.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.b = Math.max(this.b, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzsa zzsaVar) {
        this.f2301a.add(zzsaVar);
    }
}
