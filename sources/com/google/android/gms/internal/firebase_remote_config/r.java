package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
final class r<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f4106a;
    private int b = 0;
    private final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.c = qVar;
        this.f4106a = Array.getLength(this.c.f4105a);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f4106a;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.c.f4105a;
        int i = this.b;
        this.b = i + 1;
        return (T) Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
