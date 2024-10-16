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
public final class zzms extends zzpe implements zzso {
    private final zzma b;
    private final zzmh c;
    private boolean d;
    private boolean e;
    private MediaFormat f;
    private int g;
    private int h;
    private long i;
    private boolean j;

    public zzms(zzpg zzpgVar) {
        this(zzpgVar, null, true);
    }

    public static void a(int i) {
    }

    public static void a(int i, long j, long j2) {
    }

    public static void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzks, com.google.android.gms.internal.ads.zzlo
    public final zzso zzgj() {
        return this;
    }

    private zzms(zzpg zzpgVar, zznj<Object> zznjVar, boolean z) {
        this(zzpgVar, null, true, null, null);
    }

    private zzms(zzpg zzpgVar, zznj<Object> zznjVar, boolean z, Handler handler, zzlz zzlzVar) {
        this(zzpgVar, null, true, null, null, null, new zzlx[0]);
    }

    private zzms(zzpg zzpgVar, zznj<Object> zznjVar, boolean z, Handler handler, zzlz zzlzVar, zzlw zzlwVar, zzlx... zzlxVarArr) {
        super(1, zzpgVar, zznjVar, z);
        this.c = new zzmh(null, zzlxVarArr, new aln(this));
        this.b = new zzma(null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final int a(zzpg zzpgVar, zzlh zzlhVar) throws zzpk {
        String str = zzlhVar.zzatq;
        if (!zzsp.zzav(str)) {
            return 0;
        }
        int i = zzsy.SDK_INT >= 21 ? 16 : 0;
        if (a(str) && zzpgVar.zziv() != null) {
            return i | 4 | 3;
        }
        zzpd zze = zzpgVar.zze(str, false);
        boolean z = true;
        if (zze == null) {
            return 1;
        }
        if (zzsy.SDK_INT >= 21 && ((zzlhVar.zzafv != -1 && !zze.zzba(zzlhVar.zzafv)) || (zzlhVar.zzafu != -1 && !zze.zzbb(zzlhVar.zzafu)))) {
            z = false;
        }
        return i | 4 | (z ? 3 : 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe
    public final zzpd a(zzpg zzpgVar, zzlh zzlhVar, boolean z) throws zzpk {
        zzpd zziv;
        if (a(zzlhVar.zzatq) && (zziv = zzpgVar.zziv()) != null) {
            this.d = true;
            return zziv;
        }
        this.d = false;
        return super.a(zzpgVar, zzlhVar, z);
    }

    private final boolean a(String str) {
        return this.c.zzaz(str);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void a(zzpd zzpdVar, MediaCodec mediaCodec, zzlh zzlhVar, MediaCrypto mediaCrypto) {
        this.e = zzsy.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzpdVar.name) && "samsung".equals(zzsy.MANUFACTURER) && (zzsy.DEVICE.startsWith("zeroflte") || zzsy.DEVICE.startsWith("herolte") || zzsy.DEVICE.startsWith("heroqlte"));
        if (this.d) {
            this.f = zzlhVar.zzen();
            this.f.setString("mime", "audio/raw");
            mediaCodec.configure(this.f, (Surface) null, (MediaCrypto) null, 0);
            this.f.setString("mime", zzlhVar.zzatq);
            return;
        }
        mediaCodec.configure(zzlhVar.zzen(), (Surface) null, (MediaCrypto) null, 0);
        this.f = null;
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void a(String str, long j, long j2) {
        this.b.zzc(str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe
    public final void a(zzlh zzlhVar) throws zzku {
        super.a(zzlhVar);
        this.b.zzc(zzlhVar);
        this.g = "audio/raw".equals(zzlhVar.zzatq) ? zzlhVar.zzatx : 2;
        this.h = zzlhVar.zzafu;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzku {
        int[] iArr;
        int i;
        boolean z = this.f != null;
        String string = z ? this.f.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.f;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.e && integer == 6 && (i = this.h) < 6) {
            int[] iArr2 = new int[i];
            for (int i2 = 0; i2 < this.h; i2++) {
                iArr2[i2] = i2;
            }
            iArr = iArr2;
        } else {
            iArr = null;
        }
        try {
            this.c.zza(string, integer, integer2, this.g, 0, iArr);
        } catch (zzml e) {
            throw zzku.zza(e, e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void a(boolean z) throws zzku {
        super.a(z);
        this.b.zzc(this.f3703a);
        int i = d().zzaul;
        if (i != 0) {
            this.c.zzai(i);
        } else {
            this.c.zzhr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void a(long j, boolean z) throws zzku {
        super.a(j, z);
        this.c.reset();
        this.i = j;
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void a() {
        super.a();
        this.c.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void b() {
        this.c.pause();
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void c() {
        try {
            this.c.release();
            try {
                super.c();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.c();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzlo
    public final boolean zzdx() {
        return super.zzdx() && this.c.zzdx();
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzlo
    public final boolean isReady() {
        return this.c.zzer() || super.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final long zzdv() {
        long zzf = this.c.zzf(zzdx());
        if (zzf != Long.MIN_VALUE) {
            if (!this.j) {
                zzf = Math.max(this.i, zzf);
            }
            this.i = zzf;
            this.j = false;
        }
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzln zzb(zzln zzlnVar) {
        return this.c.zzb(zzlnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzln zzhq() {
        return this.c.zzhq();
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzku {
        if (this.d && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.f3703a.zzabl++;
            this.c.zzeq();
            return true;
        }
        try {
            if (!this.c.zza(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.f3703a.zzabk++;
            return true;
        } catch (zzmm | zzmp e) {
            throw zzku.zza(e, e());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void h() throws zzku {
        try {
            this.c.zzho();
        } catch (zzmp e) {
            throw zzku.zza(e, e());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzks, com.google.android.gms.internal.ads.zzkx
    public final void zza(int i, Object obj) throws zzku {
        switch (i) {
            case 2:
                this.c.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.c.setStreamType(((Integer) obj).intValue());
                return;
            default:
                super.zza(i, obj);
                return;
        }
    }

    public static /* synthetic */ boolean a(zzms zzmsVar, boolean z) {
        zzmsVar.j = true;
        return true;
    }
}
