package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
abstract class aet implements zzdmy {
    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }
}
