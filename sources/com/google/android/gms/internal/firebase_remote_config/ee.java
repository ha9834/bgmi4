package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class ee implements Iterator<String> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<String> f4088a;
    private final /* synthetic */ zzjy b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(zzjy zzjyVar) {
        zzhx zzhxVar;
        this.b = zzjyVar;
        zzhxVar = this.b.f4191a;
        this.f4088a = zzhxVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4088a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f4088a.next();
    }
}
