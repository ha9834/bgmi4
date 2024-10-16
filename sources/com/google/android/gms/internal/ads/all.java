package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class all implements zzlx {
    private int[] c;
    private boolean d;
    private int[] e;
    private boolean h;
    private ByteBuffer f = zzavh;
    private ByteBuffer g = zzavh;

    /* renamed from: a, reason: collision with root package name */
    private int f1955a = -1;
    private int b = -1;

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int zzhk() {
        return 2;
    }

    public final void a(int[] iArr) {
        this.c = iArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean zzb(int i, int i2, int i3) throws zzly {
        boolean z = !Arrays.equals(this.c, this.e);
        this.e = this.c;
        if (this.e == null) {
            this.d = false;
            return z;
        }
        if (i3 != 2) {
            throw new zzly(i, i2, i3);
        }
        if (!z && this.b == i && this.f1955a == i2) {
            return false;
        }
        this.b = i;
        this.f1955a = i2;
        this.d = i2 != this.e.length;
        int i4 = 0;
        while (true) {
            int[] iArr = this.e;
            if (i4 >= iArr.length) {
                return true;
            }
            int i5 = iArr[i4];
            if (i5 >= i2) {
                throw new zzly(i, i2, i3);
            }
            this.d = (i5 != i4) | this.d;
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean isActive() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int zzhj() {
        int[] iArr = this.e;
        return iArr == null ? this.f1955a : iArr.length;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void zzi(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.f1955a * 2)) * this.e.length) << 1;
        if (this.f.capacity() < length) {
            this.f = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        while (position < limit) {
            for (int i : this.e) {
                this.f.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.f1955a << 1;
        }
        byteBuffer.position(limit);
        this.f.flip();
        this.g = this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void zzhl() {
        this.h = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final ByteBuffer zzhm() {
        ByteBuffer byteBuffer = this.g;
        this.g = zzavh;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean zzdx() {
        return this.h && this.g == zzavh;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void flush() {
        this.g = zzavh;
        this.h = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void reset() {
        flush();
        this.f = zzavh;
        this.f1955a = -1;
        this.b = -1;
        this.e = null;
        this.d = false;
    }
}
