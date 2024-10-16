package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aer extends aet {

    /* renamed from: a, reason: collision with root package name */
    private int f1837a = 0;
    private final int b;
    private final /* synthetic */ zzdmr c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aer(zzdmr zzdmrVar) {
        this.c = zzdmrVar;
        this.b = this.c.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1837a < this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzdmy
    public final byte nextByte() {
        int i = this.f1837a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.f1837a = i + 1;
        return this.c.a(i);
    }
}
