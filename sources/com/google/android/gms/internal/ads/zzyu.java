package com.google.android.gms.internal.ads;

import java.util.Random;

@zzard
/* loaded from: classes2.dex */
public final class zzyu extends zzzz {
    private long b;
    private final Object c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Random f3784a = new Random();

    public zzyu() {
        zzpi();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzpi() {
        synchronized (this.c) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = this.f3784a.nextInt() + 2147483648L;
                if (j != this.b && j != 0) {
                    break;
                }
            }
            this.b = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzy
    public final long getValue() {
        return this.b;
    }
}
