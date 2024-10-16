package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class dy<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    private int f4526a;
    private boolean b;
    private Iterator<Map.Entry<K, V>> c;
    private final /* synthetic */ dq d;

    private dy(dq dqVar) {
        this.d = dqVar;
        this.f4526a = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f4526a + 1;
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
        int i = this.f4526a;
        list = this.d.b;
        if (i < list.size()) {
            dq dqVar = this.d;
            int i2 = this.f4526a;
            this.f4526a = i2 - 1;
            dqVar.c(i2);
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
        int i = this.f4526a + 1;
        this.f4526a = i;
        list = this.d.b;
        if (i >= list.size()) {
            return a().next();
        }
        list2 = this.d.b;
        return (Map.Entry) list2.get(this.f4526a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dy(dq dqVar, dp dpVar) {
        this(dqVar);
    }
}
