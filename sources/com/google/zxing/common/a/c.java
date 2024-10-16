package com.google.zxing.common.a;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f5406a;
    private final List<b> b = new ArrayList();

    public c(a aVar) {
        this.f5406a = aVar;
        this.b.add(new b(aVar, new int[]{1}));
    }

    private b a(int i) {
        if (i >= this.b.size()) {
            List<b> list = this.b;
            b bVar = list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                a aVar = this.f5406a;
                bVar = bVar.b(new b(aVar, new int[]{1, aVar.a((size - 1) + aVar.b())}));
                this.b.add(bVar);
            }
        }
        return this.b.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b a2 = a(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] a3 = new b(this.f5406a, iArr2).a(i, 1).c(a2)[1].a();
        int length2 = i - a3.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(a3, 0, iArr, length + length2, a3.length);
    }
}
