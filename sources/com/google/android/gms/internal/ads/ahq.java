package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class ahq implements ListIterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private ListIterator<String> f1881a;
    private final /* synthetic */ int b;
    private final /* synthetic */ zzdqw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahq(zzdqw zzdqwVar, int i) {
        zzdot zzdotVar;
        this.c = zzdqwVar;
        this.b = i;
        zzdotVar = this.c.f3599a;
        this.f1881a = zzdotVar.listIterator(this.b);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f1881a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f1881a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f1881a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f1881a.previousIndex();
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
        return this.f1881a.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f1881a.next();
    }
}
