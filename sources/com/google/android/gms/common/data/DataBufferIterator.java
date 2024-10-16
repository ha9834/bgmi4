package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferIterator<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final DataBuffer<T> f1415a;
    protected int b = -1;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        this.f1415a = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f1415a.getCount() - 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            int i = this.b;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Cannot advance the iterator beyond ");
            sb.append(i);
            throw new NoSuchElementException(sb.toString());
        }
        DataBuffer<T> dataBuffer = this.f1415a;
        int i2 = this.b + 1;
        this.b = i2;
        return dataBuffer.get(i2);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
