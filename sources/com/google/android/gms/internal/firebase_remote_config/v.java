package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
abstract class v<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    private int f4109a = w.b;

    @NullableDecl
    private T b;

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    @NullableDecl
    public final T b() {
        this.f4109a = w.c;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzdt.checkState(this.f4109a != w.d);
        switch (u.f4108a[this.f4109a - 1]) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                this.f4109a = w.d;
                this.b = a();
                if (this.f4109a == w.c) {
                    return false;
                }
                this.f4109a = w.f4110a;
                return true;
        }
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f4109a = w.b;
        T t = this.b;
        this.b = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
