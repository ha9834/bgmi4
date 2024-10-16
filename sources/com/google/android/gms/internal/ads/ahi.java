package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class ahi<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    private int f1878a;
    private boolean b;
    private Iterator<Map.Entry<K, V>> c;
    private final /* synthetic */ aha d;

    private ahi(aha ahaVar) {
        this.d = ahaVar;
        this.f1878a = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f1878a + 1;
        list = this.d.b;
        if (i >= list.size()) {
            map = this.d.c;
            if (map.isEmpty() || !a().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.b = false;
        this.d.f();
        int i = this.f1878a;
        list = this.d.b;
        if (i < list.size()) {
            aha ahaVar = this.d;
            int i2 = this.f1878a;
            this.f1878a = i2 - 1;
            ahaVar.c(i2);
            return;
        }
        a().remove();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        Map map;
        if (this.c == null) {
            map = this.d.c;
            this.c = map.entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.b = true;
        int i = this.f1878a + 1;
        this.f1878a = i;
        list = this.d.b;
        if (i >= list.size()) {
            return a().next();
        }
        list2 = this.d.b;
        return (Map.Entry) list2.get(this.f1878a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ahi(aha ahaVar, ahb ahbVar) {
        this(ahaVar);
    }
}
