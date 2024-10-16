package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

@zzard
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbgp extends zzbft implements zzbfi {
    private zzbfa d;
    private String e;
    private boolean f;
    private Exception g;
    private boolean h;

    public zzbgp(zzbdf zzbdfVar, zzbde zzbdeVar) {
        super(zzbdfVar);
        this.d = new zzbfa(zzbdfVar.getContext(), zzbdeVar);
        this.d.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzde(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzo(int i, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzd(final boolean z, final long j) {
        final zzbdf zzbdfVar = this.c.get();
        if (zzbdfVar != null) {
            zzbbm.zzeae.execute(new Runnable(zzbdfVar, z, j) { // from class: com.google.android.gms.internal.ads.ku

                /* renamed from: a, reason: collision with root package name */
                private final zzbdf f2302a;
                private final boolean b;
                private final long c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2302a = zzbdfVar;
                    this.b = z;
                    this.c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2302a.zza(this.b, this.c);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(String str, Exception exc) {
        this.g = exc;
        zzawz.zzd("Precache error", exc);
        b(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void zzcz(int i) {
        this.d.zzzu().zzdh(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void zzcy(int i) {
        this.d.zzzu().zzdg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void zzda(int i) {
        this.d.zzzu().zzda(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void zzdb(int i) {
        this.d.zzzu().zzdb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbft, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzbfa zzbfaVar = this.d;
        if (zzbfaVar != null) {
            zzbfaVar.zza((zzbfi) null);
            this.d.release();
        }
        super.release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final String a(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.a(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean zzex(String str) {
        return zze(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [long] */
    /* JADX WARN: Type inference failed for: r1v27 */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean zze(String str, String[] strArr) {
        String str2;
        long j;
        long j2;
        long j3;
        ?? r1;
        long j4;
        this.e = str;
        String a2 = a(str);
        String str3 = "error";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    uriArr[i] = Uri.parse(strArr[i]);
                } catch (Exception e) {
                    e = e;
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
                    sb.append("Failed to preload url ");
                    sb.append(str);
                    sb.append(" Exception: ");
                    sb.append(message);
                    zzawz.zzep(sb.toString());
                    release();
                    zza(str, a2, str3, a(str3, e));
                    return false;
                }
            }
            this.d.zza(uriArr, this.b);
            zzbdf zzbdfVar = this.c.get();
            if (zzbdfVar != null) {
                zzbdfVar.zza(a2, this);
            }
            Clock zzln = zzk.zzln();
            long currentTimeMillis = zzln.currentTimeMillis();
            long longValue = ((Long) zzyt.zzpe().zzd(zzacu.zzcly)).longValue();
            long longValue2 = ((Long) zzyt.zzpe().zzd(zzacu.zzclx)).longValue() * 1000;
            long intValue = ((Integer) zzyt.zzpe().zzd(zzacu.zzclw)).intValue();
            long j5 = -1;
            while (true) {
                try {
                    synchronized (this) {
                        try {
                            if (zzln.currentTimeMillis() - currentTimeMillis > longValue2) {
                                long j6 = longValue2;
                                StringBuilder sb2 = new StringBuilder(47);
                                sb2.append("Timeout reached. Limit: ");
                                sb2.append(j6);
                                sb2.append(" ms");
                                throw new IOException(sb2.toString());
                            }
                            if (this.f) {
                                if (this.g != null) {
                                    throw this.g;
                                }
                                throw new IOException("Abort requested before buffering finished. ");
                            }
                            if (!this.h) {
                                zzkv zzzt = this.d.zzzt();
                                if (zzzt == null) {
                                    throw new IOException("ExoPlayer was released during preloading.");
                                }
                                str2 = str3;
                                try {
                                    long duration = zzzt.getDuration();
                                    if (duration > 0) {
                                        long bufferedPosition = zzzt.getBufferedPosition();
                                        if (bufferedPosition != j5) {
                                            j = intValue;
                                            j2 = longValue2;
                                            j4 = longValue;
                                            zza(str, a2, bufferedPosition, duration, bufferedPosition > 0, zzbfa.zzyp(), zzbfa.zzyq());
                                            j5 = bufferedPosition;
                                        } else {
                                            j = intValue;
                                            j2 = longValue2;
                                            j4 = longValue;
                                        }
                                        if (bufferedPosition >= duration) {
                                            zzb(str, a2, duration);
                                        } else if (this.d.getBytesTransferred() < j || bufferedPosition <= 0) {
                                            j3 = j5;
                                            r1 = j4;
                                        }
                                    } else {
                                        j = intValue;
                                        j2 = longValue2;
                                        j3 = j5;
                                        r1 = longValue;
                                    }
                                    try {
                                        try {
                                            wait(r1);
                                        } catch (Throwable th) {
                                            th = th;
                                            str3 = r1;
                                            throw th;
                                        }
                                    } catch (InterruptedException unused) {
                                        throw new IOException("Wait interrupted.");
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    str3 = str2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    longValue = r1;
                    j5 = j3;
                    str3 = str2;
                    intValue = j;
                    longValue2 = j2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            return true;
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void abort() {
        b((String) null);
    }

    private final void b(String str) {
        synchronized (this) {
            this.f = true;
            notify();
            release();
        }
        String str2 = this.e;
        if (str2 != null) {
            String a2 = a(str2);
            Exception exc = this.g;
            if (exc != null) {
                zza(this.e, a2, "badUrl", a(str, exc));
            } else {
                zza(this.e, a2, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final zzbfa zzaaa() {
        synchronized (this) {
            this.h = true;
            notify();
        }
        this.d.zza((zzbfi) null);
        zzbfa zzbfaVar = this.d;
        this.d = null;
        return zzbfaVar;
    }

    private static String a(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(message);
        return sb.toString();
    }
}
