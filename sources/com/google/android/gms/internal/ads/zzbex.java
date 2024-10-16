package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzard
/* loaded from: classes2.dex */
public final class zzbex implements zzrv {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f2863a;
    private boolean b;
    private final Context c;
    private final zzrv d;
    private final zzsj<zzrv> e;
    private final zzbey f;
    private Uri g;

    public zzbex(Context context, zzrv zzrvVar, zzsj<zzrv> zzsjVar, zzbey zzbeyVar) {
        this.c = context;
        this.d = zzrvVar;
        this.e = zzsjVar;
        this.f = zzbeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final void close() throws IOException {
        if (!this.b) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.b = false;
        this.g = null;
        InputStream inputStream = this.f2863a;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.f2863a = null;
        } else {
            this.d.close();
        }
        zzsj<zzrv> zzsjVar = this.e;
        if (zzsjVar != null) {
            zzsjVar.zze(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final long zza(zzry zzryVar) throws IOException {
        Long l;
        zzry zzryVar2 = zzryVar;
        if (this.b) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.b = true;
        this.g = zzryVar2.uri;
        zzsj<zzrv> zzsjVar = this.e;
        if (zzsjVar != null) {
            zzsjVar.zza(this, zzryVar2);
        }
        zzvv zze = zzvv.zze(zzryVar2.uri);
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcts)).booleanValue()) {
            zzvs zzvsVar = null;
            if (zze != null) {
                zze.zzbwy = zzryVar2.zzahv;
                zzvsVar = zzk.zzlm().zza(zze);
            }
            if (zzvsVar != null && zzvsVar.zznh()) {
                this.f2863a = zzvsVar.zzni();
                return -1L;
            }
        } else if (zze != null) {
            zze.zzbwy = zzryVar2.zzahv;
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
                    this.f2863a = zza.get(longValue, TimeUnit.MILLISECONDS);
                    long elapsedRealtime2 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
                    this.f.zzd(true, elapsedRealtime2);
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
                    this.f.zzd(false, elapsedRealtime3);
                    StringBuilder sb2 = new StringBuilder(44);
                    sb2.append("Cache connection took ");
                    sb2.append(elapsedRealtime3);
                    sb2.append("ms");
                    zzawz.zzds(sb2.toString());
                } catch (ExecutionException | TimeoutException unused2) {
                    zza.cancel(true);
                    long elapsedRealtime4 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
                    this.f.zzd(false, elapsedRealtime4);
                    StringBuilder sb3 = new StringBuilder(44);
                    sb3.append("Cache connection took ");
                    sb3.append(elapsedRealtime4);
                    sb3.append("ms");
                    zzawz.zzds(sb3.toString());
                }
            } catch (Throwable th) {
                long elapsedRealtime5 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
                this.f.zzd(false, elapsedRealtime5);
                StringBuilder sb4 = new StringBuilder(44);
                sb4.append("Cache connection took ");
                sb4.append(elapsedRealtime5);
                sb4.append("ms");
                zzawz.zzds(sb4.toString());
                throw th;
            }
        }
        if (zze != null) {
            zzryVar2 = new zzry(Uri.parse(zze.url), zzryVar2.zzbmd, zzryVar2.zzapg, zzryVar2.zzahv, zzryVar2.zzcd, zzryVar2.zzcc, zzryVar2.flags);
        }
        return this.d.zza(zzryVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        if (!this.b) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.f2863a;
        if (inputStream != null) {
            read = inputStream.read(bArr, i, i2);
        } else {
            read = this.d.read(bArr, i, i2);
        }
        zzsj<zzrv> zzsjVar = this.e;
        if (zzsjVar != null) {
            zzsjVar.zzc(this, read);
        }
        return read;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri getUri() {
        return this.g;
    }
}
