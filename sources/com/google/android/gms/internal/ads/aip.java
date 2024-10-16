package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes2.dex */
final class aip<E> implements Iterator<E> {

    /* renamed from: a, reason: collision with root package name */
    private int f1896a = 0;
    private final /* synthetic */ zzdta b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aip(zzdta zzdtaVar) {
        this.b = zzdtaVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1896a < this.b.f3616a.size() || this.b.b.hasNext();
    }

    @Override // java.util.Iterator
    public final E next() {
        while (this.f1896a >= this.b.f3616a.size()) {
            this.b.f3616a.add(this.b.b.next());
        }
        List<E> list = this.b.f3616a;
        int i = this.f1896a;
        this.f1896a = i + 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
