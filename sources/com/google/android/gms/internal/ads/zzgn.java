package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzgn extends zzgr {
    private final zzgq b;
    private final zzhq c;
    private int d;
    private long e;

    public zzgn(zzhn zzhnVar, Handler handler, zzgq zzgqVar) {
        this(zzhnVar, null, true, handler, zzgqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public final boolean a() {
        return true;
    }

    private zzgn(zzhn zzhnVar, zzhz zzhzVar, boolean z, Handler handler, zzgq zzgqVar) {
        super(zzhnVar, null, true, handler, zzgqVar);
        this.b = zzgqVar;
        this.d = 0;
        this.c = new zzhq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr
    public final zzgc a(String str, boolean z) throws zzgz {
        if (zzkl.zzaw(str)) {
            return new zzgc("OMX.google.raw.decoder", true);
        }
        return super.a(str, z);
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void a(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        if ("OMX.google.raw.decoder".equals(str)) {
            String string = mediaFormat.getString("mime");
            mediaFormat.setString("mime", "audio/raw");
            mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
            mediaFormat.setString("mime", string);
            return;
        }
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr
    public final boolean a(String str) {
        return zzkl.zzav(str) && super.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final void a(long j, boolean z) {
        super.a(j, z);
        this.e = Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void a(zzhj zzhjVar, MediaFormat mediaFormat) {
        if (zzkl.zzaw(zzhjVar.mimeType)) {
            this.c.zza(zzhjVar.zzen(), 0);
        } else {
            this.c.zza(mediaFormat, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final void b() {
        super.b();
        this.c.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final void c() {
        this.c.pause();
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final boolean d() {
        if (super.d()) {
            return (this.c.zzer() && this.c.zzes()) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final boolean e() {
        if (this.c.zzer()) {
            return true;
        }
        return super.e() && n() == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final long f() {
        long zzf = this.c.zzf(d());
        if (zzf == Long.MIN_VALUE) {
            this.e = Math.max(this.e, super.f());
        } else {
            this.e = Math.max(this.e, zzf);
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final void zzdz() {
        this.d = 0;
        try {
            this.c.reset();
        } finally {
            super.zzdz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final void a(long j) throws zzgd {
        super.a(j);
        this.c.reset();
        this.e = Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i, boolean z) throws zzgd {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzadf.zzabl++;
            this.c.zzeq();
            return true;
        }
        if (!this.c.isInitialized()) {
            try {
                if (this.d != 0) {
                    this.c.zzq(this.d);
                } else {
                    this.d = this.c.zzq(0);
                }
                if (o() == 3) {
                    this.c.play();
                }
            } catch (zzhu e) {
                if (this.f3641a != null && this.b != null) {
                    this.f3641a.post(new ajh(this, e));
                }
                throw new zzgd(e);
            }
        }
        try {
            int zza = this.c.zza(byteBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
            if ((zza & 1) != 0) {
                this.e = Long.MIN_VALUE;
            }
            if ((zza & 2) == 0) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzadf.zzabk++;
            return true;
        } catch (zzhv e2) {
            if (this.f3641a != null && this.b != null) {
                this.f3641a.post(new aji(this, e2));
            }
            throw new zzgd(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzgf
    public final void zza(int i, Object obj) throws zzgd {
        if (i == 1) {
            this.c.setVolume(((Float) obj).floatValue());
        } else {
            super.zza(i, obj);
        }
    }
}
