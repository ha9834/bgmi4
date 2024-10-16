package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class afx extends afv {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f1857a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private afx() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afv
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afv
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) ahs.f(obj, j);
        if (list instanceof zzdot) {
            unmodifiableList = ((zzdot) list).zzayp();
        } else {
            if (f1857a.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof agr) && (list instanceof zzdoj)) {
                zzdoj zzdojVar = (zzdoj) list;
                if (zzdojVar.zzavi()) {
                    zzdojVar.zzavj();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        ahs.a(obj, j, unmodifiableList);
    }

    private static <L> List<L> a(Object obj, long j, int i) {
        List<L> arrayList;
        List<L> c = c(obj, j);
        if (c.isEmpty()) {
            if (c instanceof zzdot) {
                arrayList = new zzdos(i);
            } else if ((c instanceof agr) && (c instanceof zzdoj)) {
                arrayList = ((zzdoj) c).zzfl(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            ahs.a(obj, j, arrayList);
            return arrayList;
        }
        if (f1857a.isAssignableFrom(c.getClass())) {
            ArrayList arrayList2 = new ArrayList(c.size() + i);
            arrayList2.addAll(c);
            ahs.a(obj, j, arrayList2);
            return arrayList2;
        }
        if (c instanceof zzdqw) {
            zzdos zzdosVar = new zzdos(c.size() + i);
            zzdosVar.addAll((zzdqw) c);
            ahs.a(obj, j, zzdosVar);
            return zzdosVar;
        }
        if (!(c instanceof agr) || !(c instanceof zzdoj)) {
            return c;
        }
        zzdoj zzdojVar = (zzdoj) c;
        if (zzdojVar.zzavi()) {
            return c;
        }
        zzdoj zzfl = zzdojVar.zzfl(c.size() + i);
        ahs.a(obj, j, zzfl);
        return zzfl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afv
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
        ahs.a(obj, j, c);
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) ahs.f(obj, j);
    }
}
