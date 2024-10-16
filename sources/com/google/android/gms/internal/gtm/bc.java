package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
abstract class bc implements zzpz {
    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }
}
