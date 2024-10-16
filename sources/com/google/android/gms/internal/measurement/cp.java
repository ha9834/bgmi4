package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class cp extends cn {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f4506a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private cp() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.cn
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.cn
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) eg.f(obj, j);
        if (list instanceof zzfp) {
            unmodifiableList = ((zzfp) list).zzvg();
        } else {
            if (f4506a.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof di) && (list instanceof zzff)) {
                zzff zzffVar = (zzff) list;
                if (zzffVar.zzrx()) {
                    zzffVar.zzry();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        eg.a(obj, j, unmodifiableList);
    }

    private static <L> List<L> a(Object obj, long j, int i) {
        List<L> arrayList;
        List<L> c = c(obj, j);
        if (c.isEmpty()) {
            if (c instanceof zzfp) {
                arrayList = new zzfq(i);
            } else if ((c instanceof di) && (c instanceof zzff)) {
                arrayList = ((zzff) c).zzap(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            eg.a(obj, j, arrayList);
            return arrayList;
        }
        if (f4506a.isAssignableFrom(c.getClass())) {
            ArrayList arrayList2 = new ArrayList(c.size() + i);
            arrayList2.addAll(c);
            eg.a(obj, j, arrayList2);
            return arrayList2;
        }
        if (c instanceof zzhu) {
            zzfq zzfqVar = new zzfq(c.size() + i);
            zzfqVar.addAll((zzhu) c);
            eg.a(obj, j, zzfqVar);
            return zzfqVar;
        }
        if (!(c instanceof di) || !(c instanceof zzff)) {
            return c;
        }
        zzff zzffVar = (zzff) c;
        if (zzffVar.zzrx()) {
            return c;
        }
        zzff zzap = zzffVar.zzap(c.size() + i);
        eg.a(obj, j, zzap);
        return zzap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.cn
    public final <E> void a(Object obj, Object obj2, long j) {
        List c = c(obj2, j);
        List a2 = a(obj, j, c.size());
        int size = a2.size();
        int size2 = c.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(c);
        }
        if (size > 0) {
            c = a2;
        }
        eg.a(obj, j, c);
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) eg.f(obj, j);
    }
}
