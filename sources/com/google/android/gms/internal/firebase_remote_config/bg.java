package com.google.android.gms.internal.firebase_remote_config;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bg extends bh {

    /* renamed from: a, reason: collision with root package name */
    private int f4044a = 0;
    private final int b;
    private final /* synthetic */ zzfx c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(zzfx zzfxVar) {
        this.c = zzfxVar;
        this.b = this.c.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4044a < this.b;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgc
    public final byte nextByte() {
        int i = this.f4044a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.f4044a = i + 1;
        return this.c.a(i);
    }
}
