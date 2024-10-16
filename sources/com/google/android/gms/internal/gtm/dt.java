package com.google.android.gms.internal.gtm;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class dt implements ListIterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private ListIterator<String> f4352a;
    private final /* synthetic */ int b;
    private final /* synthetic */ zztu c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(zztu zztuVar, int i) {
        zzrt zzrtVar;
        this.c = zztuVar;
        this.b = i;
        zzrtVar = this.c.f4451a;
        this.f4352a = zzrtVar.listIterator(this.b);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f4352a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f4352a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4352a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4352a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f4352a.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f4352a.next();
    }
}
