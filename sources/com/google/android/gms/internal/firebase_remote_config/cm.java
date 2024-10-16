package com.google.android.gms.internal.firebase_remote_config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class cm extends cl {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f4064a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private cm() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.cl
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.cl
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) eh.f(obj, j);
        if (list instanceof zzhx) {
            unmodifiableList = ((zzhx) list).zzhr();
        } else {
            if (f4064a.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof dg) && (list instanceof zzhn)) {
                zzhn zzhnVar = (zzhn) list;
                if (zzhnVar.zzet()) {
                    zzhnVar.zzeu();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        eh.a(obj, j, unmodifiableList);
    }

    private static <L> List<L> a(Object obj, long j, int i) {
        List<L> arrayList;
        List<L> c = c(obj, j);
        if (c.isEmpty()) {
            if (c instanceof zzhx) {
                arrayList = new zzhu(i);
            } else if ((c instanceof dg) && (c instanceof zzhn)) {
                arrayList = ((zzhn) c).zzu(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            eh.a(obj, j, arrayList);
            return arrayList;
        }
        if (f4064a.isAssignableFrom(c.getClass())) {
            ArrayList arrayList2 = new ArrayList(c.size() + i);
            arrayList2.addAll(c);
            eh.a(obj, j, arrayList2);
            return arrayList2;
        }
        if (c instanceof zzjy) {
            zzhu zzhuVar = new zzhu(c.size() + i);
            zzhuVar.addAll((zzjy) c);
            eh.a(obj, j, zzhuVar);
            return zzhuVar;
        }
        if (!(c instanceof dg) || !(c instanceof zzhn)) {
            return c;
        }
        zzhn zzhnVar = (zzhn) c;
        if (zzhnVar.zzet()) {
            return c;
        }
        zzhn zzu = zzhnVar.zzu(c.size() + i);
        eh.a(obj, j, zzu);
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.cl
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
        eh.a(obj, j, c);
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) eh.f(obj, j);
    }
}
