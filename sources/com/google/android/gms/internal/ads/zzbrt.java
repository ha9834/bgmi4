package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbrt extends zzbts<zzbrw> {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3031a;

    public zzbrt(Set<zzbuz<zzbrw>> set) {
        super(set);
        this.f3031a = false;
    }

    public final synchronized void onAdImpression() {
        if (!this.f3031a) {
            a(oc.f2386a);
            this.f3031a = true;
        }
    }
}
