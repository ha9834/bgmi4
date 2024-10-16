package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class eh implements Iterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<String> f4531a;
    private final /* synthetic */ zzhu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(zzhu zzhuVar) {
        zzfp zzfpVar;
        this.b = zzhuVar;
        zzfpVar = this.b.f4569a;
        this.f4531a = zzfpVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4531a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f4531a.next();
    }
}
