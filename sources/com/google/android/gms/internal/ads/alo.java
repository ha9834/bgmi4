package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
final class alo implements zzlx {

    /* renamed from: a, reason: collision with root package name */
    private int f1957a = -1;
    private int b = -1;
    private int c = 0;
    private ByteBuffer d = zzavh;
    private ByteBuffer e = zzavh;
    private boolean f;

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int zzhk() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean zzb(int i, int i2, int i3) throws zzly {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzly(i, i2, i3);
        }
        if (this.f1957a == i && this.b == i2 && this.c == i3) {
            return false;
        }
        this.f1957a = i;
        this.b = i2;
        this.c = i3;
        if (i3 != 2) {
            return true;
        }
        this.d = zzavh;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean isActive() {
        int i = this.c;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int zzhj() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void zzi(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.c;
        if (i3 == Integer.MIN_VALUE) {
            i = (i2 / 3) << 1;
        } else if (i3 == 3) {
            i = i2 << 1;
        } else if (i3 == 1073741824) {
            i = i2 / 2;
        } else {
            throw new IllegalStateException();
        }
        if (this.d.capacity() < i) {
            this.d = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.d.clear();
        }
        int i4 = this.c;
        if (i4 == Integer.MIN_VALUE) {
            while (position < limit) {
                this.d.put(byteBuffer.get(position + 1));
                this.d.put(byteBuffer.get(position + 2));
                position += 3;
            }
        } else if (i4 == 3) {
            while (position < limit) {
                this.d.put((byte) 0);
                this.d.put((byte) ((byteBuffer.get(position) & DeviceInfos.NETWORK_TYPE_UNCONNECTED) - 128));
                position++;
            }
        } else {
            if (i4 != 1073741824) {
                throw new IllegalStateException();
            }
            while (position < limit) {
                this.d.put(byteBuffer.get(position + 2));
                this.d.put(byteBuffer.get(position + 3));
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.d.flip();
        this.e = this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void zzhl() {
        this.f = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final ByteBuffer zzhm() {
        ByteBuffer byteBuffer = this.e;
        this.e = zzavh;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean zzdx() {
        return this.f && this.e == zzavh;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void flush() {
        this.e = zzavh;
        this.f = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void reset() {
        flush();
        this.d = zzavh;
        this.f1957a = -1;
        this.b = -1;
        this.c = 0;
    }
}
