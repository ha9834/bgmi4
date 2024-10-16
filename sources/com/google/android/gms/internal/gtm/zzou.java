package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzou {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, zzl> f4423a;
    private zzl b;

    private zzou() {
        this.f4423a = new HashMap();
    }

    public final zzou zzb(String str, zzl zzlVar) {
        this.f4423a.put(str, zzlVar);
        return this;
    }

    public final zzou zzm(zzl zzlVar) {
        this.b = zzlVar;
        return this;
    }

    public final zzot zzmm() {
        return new zzot(this.f4423a, this.b);
    }
}
