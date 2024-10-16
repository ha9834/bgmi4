package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final DataHolder f1413a;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public AbstractDataBuffer(DataHolder dataHolder) {
        this.f1413a = dataHolder;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public abstract T get(int i);

    @Override // com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        DataHolder dataHolder = this.f1413a;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    @Deprecated
    public final void close() {
        release();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.f1413a;
        return dataHolder == null || dataHolder.isClosed();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Bundle getMetadata() {
        return this.f1413a.getMetadata();
    }

    @Override // com.google.android.gms.common.data.DataBuffer, java.lang.Iterable
    public Iterator<T> iterator() {
        return new DataBufferIterator(this);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Iterator<T> singleRefIterator() {
        return new SingleRefDataBufferIterator(this);
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        DataHolder dataHolder = this.f1413a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
