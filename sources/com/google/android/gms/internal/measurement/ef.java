package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class ef implements ListIterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private ListIterator<String> f4528a;
    private final /* synthetic */ int b;
    private final /* synthetic */ zzhu c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(zzhu zzhuVar, int i) {
        zzfp zzfpVar;
        this.c = zzhuVar;
        this.b = i;
        zzfpVar = this.c.f4569a;
        this.f4528a = zzfpVar.listIterator(this.b);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f4528a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f4528a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4528a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4528a.previousIndex();
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
        return this.f4528a.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f4528a.next();
    }
}
