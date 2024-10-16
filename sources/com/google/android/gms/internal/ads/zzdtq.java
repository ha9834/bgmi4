package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzdtq<T> implements zzdti<Set<T>> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzdti<Set<Object>> f3624a = zzdtj.zzar(Collections.emptySet());
    private final List<zzdtu<T>> b;
    private final List<zzdtu<Collection<T>>> c;

    public static <T> zzdts<T> zzao(int i, int i2) {
        return new zzdts<>(i, i2);
    }

    private zzdtq(List<zzdtu<T>> list, List<zzdtu<Collection<T>>> list2) {
        this.b = list;
        this.c = list2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        int size = this.b.size();
        ArrayList arrayList = new ArrayList(this.c.size());
        int size2 = this.c.size();
        int i = size;
        for (int i2 = 0; i2 < size2; i2++) {
            Collection<T> collection = this.c.get(i2).get();
            i += collection.size();
            arrayList.add(collection);
        }
        HashSet a2 = zzdtf.a(i);
        int size3 = this.b.size();
        for (int i3 = 0; i3 < size3; i3++) {
            a2.add(zzdto.checkNotNull(this.b.get(i3).get()));
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            Iterator it = ((Collection) arrayList.get(i4)).iterator();
            while (it.hasNext()) {
                a2.add(zzdto.checkNotNull(it.next()));
            }
        }
        return Collections.unmodifiableSet(a2);
    }
}
