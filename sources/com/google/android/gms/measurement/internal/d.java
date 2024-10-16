package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements Iterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<String> f4798a;
    private final /* synthetic */ zzah b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zzah zzahVar) {
        Bundle bundle;
        this.b = zzahVar;
        bundle = this.b.f4925a;
        this.f4798a = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4798a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f4798a.next();
    }
}
