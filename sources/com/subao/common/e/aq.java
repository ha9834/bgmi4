package com.subao.common.e;

import android.util.Log;
import com.subao.common.e.x;
import com.subao.common.intf.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class aq implements Iterable<ap> {

    /* renamed from: a, reason: collision with root package name */
    private final List<ap> f5974a;

    /* loaded from: classes2.dex */
    public interface a<T> {
        T a(ap apVar);
    }

    public aq(List<ap> list) {
        this.f5974a = list;
    }

    public static aq a(List<com.subao.common.e.b> list, List<x.a> list2) {
        if (list == null || list.isEmpty()) {
            Log.w("SubaoData", "List<AccelGame> is empty");
            return null;
        }
        if (list2 == null || list2.isEmpty()) {
            Log.w("SubaoData", "List<InstalledApp.Info> is empty");
            return null;
        }
        com.subao.common.e.c cVar = new com.subao.common.e.c(list);
        ArrayList arrayList = new ArrayList(16);
        for (x.a aVar : list2) {
            String c2 = aVar.c();
            String a2 = aVar.a();
            com.subao.common.e.b a3 = cVar.a(a2, c2);
            if (a3 != null) {
                arrayList.add(new ap(aVar.b(), a2, c2, a3.e(), a3.d(), a3.a(), a3.c(), a3.f(), a3.g(), a3.i(), a3.h()));
            }
        }
        if (!arrayList.isEmpty()) {
            return new aq(arrayList);
        }
        Log.w("SubaoData", String.format(r.f6001a, "SupportGameList.build(%d, %d) return empty", Integer.valueOf(list.size()), Integer.valueOf(list2.size())));
        return null;
    }

    public int a() {
        List<ap> list = this.f5974a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // java.lang.Iterable
    public Iterator<ap> iterator() {
        List<ap> list = this.f5974a;
        return new d(list == null ? null : list.iterator());
    }

    public <T> List<T> a(a<T> aVar, boolean z) {
        int a2 = a();
        if (a2 == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(a2);
        for (ap apVar : this.f5974a) {
            if (z || !apVar.a()) {
                arrayList.add(aVar.a(apVar));
            }
        }
        return arrayList;
    }

    /* loaded from: classes2.dex */
    private static class d implements Iterator<ap> {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<ap> f5975a;

        private d(Iterator<ap> it) {
            this.f5975a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Iterator<ap> it = this.f5975a;
            return it != null && it.hasNext();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ap next() {
            Iterator<ap> it = this.f5975a;
            if (it == null) {
                throw new NoSuchElementException();
            }
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements a<String> {
        @Override // com.subao.common.e.aq.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(ap apVar) {
            return apVar.b;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements a<AppInfo> {
        @Override // com.subao.common.e.aq.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppInfo a(ap apVar) {
            return new AppInfo(apVar.f5973a, apVar.b);
        }
    }
}
