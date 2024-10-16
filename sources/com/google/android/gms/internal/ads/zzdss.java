package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class zzdss extends zzdsu implements zzbd {
    private zzbe f;
    private String g;
    private boolean h;
    private long i;

    public zzdss(String str) {
        this.g = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final void zza(zzbe zzbeVar) {
        this.f = zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final String getType() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final void zza(zzdsw zzdswVar, ByteBuffer byteBuffer, long j, zzba zzbaVar) throws IOException {
        this.i = zzdswVar.position() - byteBuffer.remaining();
        this.h = byteBuffer.remaining() == 16;
        zza(zzdswVar, j, zzbaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdsu
    public final void zza(zzdsw zzdswVar, long j, zzba zzbaVar) throws IOException {
        this.b = zzdswVar;
        this.c = zzdswVar.position();
        this.d = this.c - ((this.h || 8 + j >= 4294967296L) ? 16 : 8);
        zzdswVar.zzff(zzdswVar.position() + j);
        this.e = zzdswVar.position();
        this.f3613a = zzbaVar;
    }
}
