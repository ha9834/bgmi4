package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zznd extends zzmy {
    public long zzaga;
    public ByteBuffer zzde;
    public final zzmz zzaze = new zzmz();

    /* renamed from: a, reason: collision with root package name */
    private final int f3690a = 0;

    public zznd(int i) {
    }

    public final void zzan(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzde;
        if (byteBuffer == null) {
            this.zzde = b(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzde.position();
        int i2 = i + position;
        if (capacity >= i2) {
            return;
        }
        ByteBuffer b = b(i2);
        if (position > 0) {
            this.zzde.position(0);
            this.zzde.limit(position);
            b.put(this.zzde);
        }
        this.zzde = b;
    }

    public final boolean zzeo() {
        return a(1073741824);
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzde;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    private final ByteBuffer b(int i) {
        ByteBuffer byteBuffer = this.zzde;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
}
