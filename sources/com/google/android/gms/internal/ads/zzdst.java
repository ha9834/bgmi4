package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class zzdst extends zzdsr implements zzbd {
    private int b;
    private int c;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdst(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.f3612a) {
            zzbbc();
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long a(ByteBuffer byteBuffer) {
        this.b = zzbc.zza(byteBuffer.get());
        this.c = (zzbc.zzb(byteBuffer) << 8) + 0 + zzbc.zza(byteBuffer.get());
        return 4L;
    }
}
