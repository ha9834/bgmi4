package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzdtp<T> {

    /* renamed from: a, reason: collision with root package name */
    private final List<T> f3623a = new ArrayList(11);

    private zzdtp(int i) {
    }

    public static <T> zzdtp<T> zzhp(int i) {
        return new zzdtp<>(11);
    }

    public final zzdtp<T> zzas(T t) {
        this.f3623a.add(zzdto.zza(t, "Set contributions cannot be null"));
        return this;
    }

    public final zzdtp<T> zzb(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            zzdto.zza(it.next(), "Set contributions cannot be null");
        }
        this.f3623a.addAll(collection);
        return this;
    }

    public final Set<T> zzbbg() {
        switch (this.f3623a.size()) {
            case 0:
                return Collections.emptySet();
            case 1:
                return Collections.singleton(this.f3623a.get(0));
            default:
                return Collections.unmodifiableSet(new HashSet(this.f3623a));
        }
    }
}
