package com.google.android.gms.internal.gtm;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ba extends bc {

    /* renamed from: a, reason: collision with root package name */
    private int f4312a = 0;
    private final int b;
    private final /* synthetic */ zzps c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(zzps zzpsVar) {
        this.c = zzpsVar;
        this.b = this.c.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4312a < this.b;
    }

    @Override // com.google.android.gms.internal.gtm.zzpz
    public final byte nextByte() {
        int i = this.f4312a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.f4312a = i + 1;
        return this.c.a(i);
    }
}
