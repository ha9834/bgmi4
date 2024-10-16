package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public interface zzlx {
    public static final ByteBuffer zzavh = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void flush();

    boolean isActive();

    void reset();

    boolean zzb(int i, int i2, int i3) throws zzly;

    boolean zzdx();

    int zzhj();

    int zzhk();

    void zzhl();

    ByteBuffer zzhm();

    void zzi(ByteBuffer byteBuffer);
}
