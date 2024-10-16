package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bk extends bl {

    /* renamed from: a, reason: collision with root package name */
    private int f4488a = 0;
    private final int b;
    private final /* synthetic */ zzdp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(zzdp zzdpVar) {
        this.c = zzdpVar;
        this.b = this.c.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4488a < this.b;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final byte nextByte() {
        int i = this.f4488a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.f4488a = i + 1;
        return this.c.a(i);
    }
}
