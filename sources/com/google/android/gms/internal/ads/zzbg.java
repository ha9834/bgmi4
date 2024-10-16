package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: classes2.dex */
public final class zzbg extends zzdst {
    private Date b;
    private Date c;
    private long d;
    private long e;
    private double f;
    private float g;
    private zzdtd h;
    private long i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;

    public zzbg() {
        super("mvhd");
        this.f = 1.0d;
        this.g = 1.0f;
        this.h = zzdtd.zzhuc;
    }

    public final long zzr() {
        return this.d;
    }

    public final long getDuration() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final void zzg(ByteBuffer byteBuffer) {
        a(byteBuffer);
        if (getVersion() == 1) {
            this.b = zzdsy.zzfx(zzbc.zzc(byteBuffer));
            this.c = zzdsy.zzfx(zzbc.zzc(byteBuffer));
            this.d = zzbc.zza(byteBuffer);
            this.e = zzbc.zzc(byteBuffer);
        } else {
            this.b = zzdsy.zzfx(zzbc.zza(byteBuffer));
            this.c = zzdsy.zzfx(zzbc.zza(byteBuffer));
            this.d = zzbc.zza(byteBuffer);
            this.e = zzbc.zza(byteBuffer);
        }
        this.f = zzbc.zzd(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.g = ((short) ((r0[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((short) (0 | ((r0[0] << 8) & 65280))))) / 256.0f;
        zzbc.zzb(byteBuffer);
        zzbc.zza(byteBuffer);
        zzbc.zza(byteBuffer);
        this.h = zzdtd.zzp(byteBuffer);
        this.j = byteBuffer.getInt();
        this.k = byteBuffer.getInt();
        this.l = byteBuffer.getInt();
        this.m = byteBuffer.getInt();
        this.n = byteBuffer.getInt();
        this.o = byteBuffer.getInt();
        this.i = zzbc.zza(byteBuffer);
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.b + ";modificationTime=" + this.c + ";timescale=" + this.d + ";duration=" + this.e + ";rate=" + this.f + ";volume=" + this.g + ";matrix=" + this.h + ";nextTrackId=" + this.i + "]";
    }
}
