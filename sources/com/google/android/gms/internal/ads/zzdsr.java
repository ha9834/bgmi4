package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class zzdsr implements zzbd {
    private static zzdtc b = zzdtc.zzm(zzdsr.class);
    private String c;
    private zzbe d;
    private ByteBuffer f;
    private long g;
    private long h;
    private zzdsw j;
    private long i = -1;
    private ByteBuffer k = null;
    private boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    boolean f3612a = true;

    private final synchronized void a() {
        if (!this.e) {
            try {
                zzdtc zzdtcVar = b;
                String valueOf = String.valueOf(this.c);
                zzdtcVar.zzhc(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.f = this.j.zzi(this.g, this.i);
                this.e = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected abstract void zzg(ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdsr(String str) {
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final void zza(zzdsw zzdswVar, ByteBuffer byteBuffer, long j, zzba zzbaVar) throws IOException {
        this.g = zzdswVar.position();
        this.h = this.g - byteBuffer.remaining();
        this.i = j;
        this.j = zzdswVar;
        zzdswVar.zzff(zzdswVar.position() + j);
        this.e = false;
        this.f3612a = false;
        zzbbc();
    }

    public final synchronized void zzbbc() {
        a();
        zzdtc zzdtcVar = b;
        String valueOf = String.valueOf(this.c);
        zzdtcVar.zzhc(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.f != null) {
            ByteBuffer byteBuffer = this.f;
            this.f3612a = true;
            byteBuffer.rewind();
            zzg(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.k = byteBuffer.slice();
            }
            this.f = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final String getType() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final void zza(zzbe zzbeVar) {
        this.d = zzbeVar;
    }
}
