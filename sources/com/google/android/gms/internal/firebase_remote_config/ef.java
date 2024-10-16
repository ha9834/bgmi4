package com.google.android.gms.internal.firebase_remote_config;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class ef implements ListIterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private ListIterator<String> f4089a;
    private final /* synthetic */ int b;
    private final /* synthetic */ zzjy c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(zzjy zzjyVar, int i) {
        zzhx zzhxVar;
        this.c = zzjyVar;
        this.b = i;
        zzhxVar = this.c.f4191a;
        this.f4089a = zzhxVar.listIterator(this.b);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f4089a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f4089a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4089a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4089a.previousIndex();
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
        return this.f4089a.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f4089a.next();
    }
}
