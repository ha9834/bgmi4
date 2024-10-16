package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
abstract class bl implements zzdu {
    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }
}
