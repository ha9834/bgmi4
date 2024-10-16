package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzdts<T> {

    /* renamed from: a, reason: collision with root package name */
    private final List<zzdtu<T>> f3625a;
    private final List<zzdtu<Collection<T>>> b;

    private zzdts(int i, int i2) {
        this.f3625a = zzdtf.zzhk(i);
        this.b = zzdtf.zzhk(i2);
    }

    public final zzdts<T> zzaq(zzdtu<? extends T> zzdtuVar) {
        this.f3625a.add(zzdtuVar);
        return this;
    }

    public final zzdts<T> zzar(zzdtu<? extends Collection<? extends T>> zzdtuVar) {
        this.b.add(zzdtuVar);
        return this;
    }

    public final zzdtq<T> zzbbh() {
        return new zzdtq<>(this.f3625a, this.b);
    }
}
