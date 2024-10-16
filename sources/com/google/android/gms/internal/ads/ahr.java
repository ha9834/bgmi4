package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class ahr implements Iterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<String> f1882a;
    private final /* synthetic */ zzdqw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahr(zzdqw zzdqwVar) {
        zzdot zzdotVar;
        this.b = zzdqwVar;
        zzdotVar = this.b.f3599a;
        this.f1882a = zzdotVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1882a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f1882a.next();
    }
}
