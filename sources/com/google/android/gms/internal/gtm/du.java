package com.google.android.gms.internal.gtm;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class du implements Iterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<String> f4353a;
    private final /* synthetic */ zztu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(zztu zztuVar) {
        zzrt zzrtVar;
        this.b = zztuVar;
        zzrtVar = this.b.f4451a;
        this.f4353a = zzrtVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4353a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f4353a.next();
    }
}
