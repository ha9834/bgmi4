package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzal {
    private static final Comparator<byte[]> e = new ck();

    /* renamed from: a, reason: collision with root package name */
    private final List<byte[]> f2747a = new ArrayList();
    private final List<byte[]> b = new ArrayList(64);
    private int c = 0;
    private final int d = 4096;

    public zzal(int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized byte[] zzc(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            byte[] bArr = this.b.get(i2);
            if (bArr.length >= i) {
                this.c -= bArr.length;
                this.b.remove(i2);
                this.f2747a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public final synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.d) {
                this.f2747a.add(bArr);
                int binarySearch = Collections.binarySearch(this.b, bArr, e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.b.add(binarySearch, bArr);
                this.c += bArr.length;
                a();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void a() {
        while (this.c > this.d) {
            byte[] remove = this.f2747a.remove(0);
            this.b.remove(remove);
            this.c -= remove.length;
        }
    }
}
