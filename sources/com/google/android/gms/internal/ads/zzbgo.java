package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

@zzard
/* loaded from: classes2.dex */
public final class zzbgo extends zzbft implements zzsj<zzrv> {
    private String d;
    private final zzbde e;
    private boolean f;
    private final kt g;
    private final zzbfl h;
    private ByteBuffer i;
    private boolean j;
    private final Object k;
    private boolean l;

    public zzbgo(zzbdf zzbdfVar, zzbde zzbdeVar) {
        super(zzbdfVar);
        this.e = zzbdeVar;
        this.g = new kt();
        this.h = new zzbfl();
        this.k = new Object();
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* bridge */ /* synthetic */ void zzc(zzrv zzrvVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* bridge */ /* synthetic */ void zze(zzrv zzrvVar) {
    }

    public final String getUrl() {
        return this.d;
    }

    public final boolean zzzv() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final String a(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.a(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final void a() {
        int a2 = (int) this.g.a();
        int zzl = (int) this.h.zzl(this.i);
        int position = this.i.position();
        int round = Math.round(zzl * (position / a2));
        boolean z = round > 0;
        int zzyp = zzbfa.zzyp();
        int zzyq = zzbfa.zzyq();
        String str = this.d;
        zza(str, a(str), position, a2, round, zzl, z, zzyp, zzyq);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:? -> B:50:0x013a). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean zzex(String str) {
        String str2;
        this.d = str;
        String a2 = a(str);
        String str3 = "error";
        int i = 0;
        try {
            zzrv zzsaVar = new zzsa(this.b, null, this, this.e.zzeef, this.e.zzeeh, true, null);
            if (this.e.zzeel) {
                try {
                    zzsaVar = new zzbex(this.f2870a, zzsaVar, null, null);
                } catch (Exception e) {
                    e = e;
                    String canonicalName = e.getClass().getCanonicalName();
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 1 + String.valueOf(message).length());
                    sb.append(canonicalName);
                    sb.append(CertificateUtil.DELIMITER);
                    sb.append(message);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb2).length());
                    sb3.append("Failed to preload url ");
                    sb3.append(str);
                    sb3.append(" Exception: ");
                    sb3.append(sb2);
                    zzawz.zzep(sb3.toString());
                    zza(str, a2, str3, sb2);
                    return false;
                }
            }
            zzsaVar.zza(new zzry(Uri.parse(str)));
            zzbdf zzbdfVar = this.c.get();
            if (zzbdfVar != null) {
                zzbdfVar.zza(a2, this);
            }
            Clock zzln = zzk.zzln();
            long currentTimeMillis = zzln.currentTimeMillis();
            long longValue = ((Long) zzyt.zzpe().zzd(zzacu.zzcly)).longValue();
            long longValue2 = ((Long) zzyt.zzpe().zzd(zzacu.zzclx)).longValue();
            this.i = ByteBuffer.allocate(this.e.zzeee);
            int i2 = 8192;
            byte[] bArr = new byte[8192];
            long j = currentTimeMillis;
            while (true) {
                int read = zzsaVar.read(bArr, i, Math.min(this.i.remaining(), i2));
                if (read == -1) {
                    this.l = true;
                    zzb(str, a2, (int) this.h.zzl(this.i));
                    return true;
                }
                synchronized (this.k) {
                    try {
                        if (this.f) {
                            str2 = str3;
                        } else {
                            str2 = str3;
                            try {
                                this.i.put(bArr, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.i.remaining() <= 0) {
                                a();
                                return true;
                            }
                            if (this.f) {
                                int limit = this.i.limit();
                                StringBuilder sb4 = new StringBuilder(35);
                                sb4.append("Precache abort at ");
                                sb4.append(limit);
                                sb4.append(" bytes");
                                throw new IOException(sb4.toString());
                            }
                            long currentTimeMillis2 = zzln.currentTimeMillis();
                            if (currentTimeMillis2 - j >= longValue) {
                                a();
                                j = currentTimeMillis2;
                            }
                            if (currentTimeMillis2 - currentTimeMillis > 1000 * longValue2) {
                                StringBuilder sb5 = new StringBuilder(49);
                                sb5.append("Timeout exceeded. Limit: ");
                                sb5.append(longValue2);
                                sb5.append(" sec");
                                throw new IOException(sb5.toString());
                            }
                            str3 = str2;
                            i2 = 8192;
                            i = 0;
                        } catch (Exception e2) {
                            e = e2;
                            str3 = str2;
                            String canonicalName2 = e.getClass().getCanonicalName();
                            String message2 = e.getMessage();
                            StringBuilder sb6 = new StringBuilder(String.valueOf(canonicalName2).length() + 1 + String.valueOf(message2).length());
                            sb6.append(canonicalName2);
                            sb6.append(CertificateUtil.DELIMITER);
                            sb6.append(message2);
                            String sb22 = sb6.toString();
                            StringBuilder sb32 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb22).length());
                            sb32.append("Failed to preload url ");
                            sb32.append(str);
                            sb32.append(" Exception: ");
                            sb32.append(sb22);
                            zzawz.zzep(sb32.toString());
                            zza(str, a2, str3, sb22);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void abort() {
        this.f = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.k) {
            if (this.i != null && !this.j) {
                this.i.flip();
                this.j = true;
            }
            this.f = true;
        }
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* synthetic */ void zza(zzrv zzrvVar, zzry zzryVar) {
        zzrv zzrvVar2 = zzrvVar;
        if (zzrvVar2 instanceof zzsa) {
            this.g.a((zzsa) zzrvVar2);
        }
    }
}
