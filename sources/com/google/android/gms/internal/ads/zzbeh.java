package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzard
/* loaded from: classes2.dex */
public final class zzbeh implements zzjp {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f2862a;
    private boolean b;
    private final Context c;
    private final zzjp d;
    private final WeakReference<zzbei> e;

    public zzbeh(Context context, zzjp zzjpVar, zzbei zzbeiVar) {
        this.c = context;
        this.d = zzjpVar;
        this.e = new WeakReference<>(zzbeiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws IOException {
        if (!this.b) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.b = false;
        InputStream inputStream = this.f2862a;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.f2862a = null;
        } else {
            this.d.close();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long zza(zzjq zzjqVar) throws IOException {
        Long l;
        zzjq zzjqVar2 = zzjqVar;
        if (this.b) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.b = true;
        zzvv zze = zzvv.zze(zzjqVar2.uri);
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcts)).booleanValue()) {
            zzvs zzvsVar = null;
            if (zze != null) {
                zze.zzbwy = zzjqVar2.zzahv;
                zzvsVar = zzk.zzlm().zza(zze);
            }
            if (zzvsVar != null && zzvsVar.zznh()) {
                this.f2862a = zzvsVar.zzni();
                return -1L;
            }
        } else if (zze != null) {
            zze.zzbwy = zzjqVar2.zzahv;
            if (zze.zzbwx) {
                l = (Long) zzyt.zzpe().zzd(zzacu.zzctu);
            } else {
                l = (Long) zzyt.zzpe().zzd(zzacu.zzctt);
            }
            long longValue = l.longValue();
            long elapsedRealtime = zzk.zzln().elapsedRealtime();
            zzk.zzma();
            Future<InputStream> zza = zzwi.zza(this.c, zze);
            try {
                try {
                    this.f2862a = zza.get(longValue, TimeUnit.MILLISECONDS);
                    long elapsedRealtime2 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
                    zzbei zzbeiVar = this.e.get();
                    if (zzbeiVar != null) {
                        zzbeiVar.zzd(true, elapsedRealtime2);
                    }
                    StringBuilder sb = new StringBuilder(44);
                    sb.append("Cache connection took ");
                    sb.append(elapsedRealtime2);
                    sb.append("ms");
                    zzawz.zzds(sb.toString());
                    return -1L;
                } catch (InterruptedException unused) {
                    zza.cancel(true);
                    Thread.currentThread().interrupt();
                    long elapsedRealtime3 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
                    zzbei zzbeiVar2 = this.e.get();
                    if (zzbeiVar2 != null) {
                        zzbeiVar2.zzd(false, elapsedRealtime3);
                    }
                    StringBuilder sb2 = new StringBuilder(44);
                    sb2.append("Cache connection took ");
                    sb2.append(elapsedRealtime3);
                    sb2.append("ms");
                    zzawz.zzds(sb2.toString());
                } catch (ExecutionException | TimeoutException unused2) {
                    zza.cancel(true);
                    long elapsedRealtime4 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
                    zzbei zzbeiVar3 = this.e.get();
                    if (zzbeiVar3 != null) {
                        zzbeiVar3.zzd(false, elapsedRealtime4);
                    }
                    StringBuilder sb3 = new StringBuilder(44);
                    sb3.append("Cache connection took ");
                    sb3.append(elapsedRealtime4);
                    sb3.append("ms");
                    zzawz.zzds(sb3.toString());
                }
            } catch (Throwable th) {
                long elapsedRealtime5 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
                zzbei zzbeiVar4 = this.e.get();
                if (zzbeiVar4 != null) {
                    zzbeiVar4.zzd(false, elapsedRealtime5);
                }
                StringBuilder sb4 = new StringBuilder(44);
                sb4.append("Cache connection took ");
                sb4.append(elapsedRealtime5);
                sb4.append("ms");
                zzawz.zzds(sb4.toString());
                throw th;
            }
        }
        if (zze != null) {
            zzjqVar2 = new zzjq(Uri.parse(zze.url), zzjqVar2.zzapg, zzjqVar2.zzahv, zzjqVar2.zzcd, zzjqVar2.zzcc, zzjqVar2.flags);
        }
        return this.d.zza(zzjqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.b) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.f2862a;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i2);
        }
        return this.d.read(bArr, i, i2);
    }
}
