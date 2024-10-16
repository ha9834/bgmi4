package com.google.zxing.a.a;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    static final f f5399a = new f(g.f5400a, 0, 0, 0);
    private final int b;
    private final g c;
    private final int d;
    private final int e;

    private f(g gVar, int i, int i2, int i3) {
        this.c = gVar;
        this.b = i;
        this.d = i2;
        this.e = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f a(int i, int i2) {
        int i3 = this.e;
        g gVar = this.c;
        if (i != this.b) {
            int i4 = d.b[this.b][i];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            gVar = gVar.a(i5, i6);
            i3 += i6;
        }
        int i7 = i == 2 ? 4 : 5;
        return new f(gVar.a(i2, i7), i, 0, i3 + i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f b(int i, int i2) {
        g gVar = this.c;
        int i3 = this.b == 2 ? 4 : 5;
        return new f(gVar.a(d.c[this.b][i], i3).a(i2, 5), this.b, 0, this.e + i3 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f a(int i) {
        g gVar = this.c;
        int i2 = this.b;
        int i3 = this.e;
        if (i2 == 4 || i2 == 2) {
            int i4 = d.b[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            gVar = gVar.a(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.d;
        f fVar = new f(gVar, i2, this.d + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return fVar.d == 2078 ? fVar.b(i + 1) : fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f b(int i) {
        int i2 = this.d;
        return i2 == 0 ? this : new f(this.c.b(i - i2, i2), this.b, 0, this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(f fVar) {
        int i;
        int i2 = this.e + (d.b[this.b][fVar.b] >> 16);
        int i3 = fVar.d;
        if (i3 > 0 && ((i = this.d) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= fVar.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.common.a a(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (g gVar = b(bArr.length).c; gVar != null; gVar = gVar.a()) {
            linkedList.addFirst(gVar);
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f5397a[this.b], Integer.valueOf(this.e), Integer.valueOf(this.d));
    }
}
