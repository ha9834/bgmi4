package com.google.android.gms.internal.firebase_remote_config;

import java.util.Collection;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class zzbb {

    /* renamed from: a, reason: collision with root package name */
    final zzaw f4129a;
    Collection<String> b = new HashSet();

    public zzbb(zzaw zzawVar) {
        this.f4129a = (zzaw) zzdt.checkNotNull(zzawVar);
    }

    public final zzay zzbm() {
        return new zzay(this);
    }

    public final zzbb zza(Collection<String> collection) {
        this.b = collection;
        return this;
    }
}
