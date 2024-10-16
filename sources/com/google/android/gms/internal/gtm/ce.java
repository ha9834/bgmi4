package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class ce extends cc {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f4331a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private ce() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cc
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cc
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) dv.f(obj, j);
        if (list instanceof zzrt) {
            unmodifiableList = ((zzrt) list).zzqb();
        } else {
            if (f4331a.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof cw) && (list instanceof zzrj)) {
                zzrj zzrjVar = (zzrj) list;
                if (zzrjVar.zzmy()) {
                    zzrjVar.zzmi();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        dv.a(obj, j, unmodifiableList);
    }

    private static <L> List<L> a(Object obj, long j, int i) {
        List<L> arrayList;
        List<L> c = c(obj, j);
        if (c.isEmpty()) {
            if (c instanceof zzrt) {
                arrayList = new zzrs(i);
            } else if ((c instanceof cw) && (c instanceof zzrj)) {
                arrayList = ((zzrj) c).zzaj(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            dv.a(obj, j, arrayList);
            return arrayList;
        }
        if (f4331a.isAssignableFrom(c.getClass())) {
            ArrayList arrayList2 = new ArrayList(c.size() + i);
            arrayList2.addAll(c);
            dv.a(obj, j, arrayList2);
            return arrayList2;
        }
        if (c instanceof zztu) {
            zzrs zzrsVar = new zzrs(c.size() + i);
            zzrsVar.addAll((zztu) c);
            dv.a(obj, j, zzrsVar);
            return zzrsVar;
        }
        if (!(c instanceof cw) || !(c instanceof zzrj)) {
            return c;
        }
        zzrj zzrjVar = (zzrj) c;
        if (zzrjVar.zzmy()) {
            return c;
        }
        zzrj zzaj = zzrjVar.zzaj(c.size() + i);
        dv.a(obj, j, zzaj);
        return zzaj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cc
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
        dv.a(obj, j, c);
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) dv.f(obj, j);
    }
}
