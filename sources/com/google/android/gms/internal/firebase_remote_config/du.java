package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class du implements Iterator<Object> {
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
