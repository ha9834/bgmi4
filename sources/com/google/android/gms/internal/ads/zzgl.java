package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@TargetApi(16)
@Deprecated
/* loaded from: classes2.dex */
public final class zzgl implements zzhn {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3640a;
    private final Uri b;
    private final Map<String, String> c;
    private final FileDescriptor d;
    private final long e;
    private final long f;
    private MediaExtractor g;
    private zzho[] h;
    private boolean i;
    private int j;
    private int[] k;
    private boolean[] l;
    private long m;

    public zzgl(Context context, Uri uri, Map<String, String> map, int i) {
        zzkh.checkState(zzkq.SDK_INT >= 16);
        this.j = 2;
        this.f3640a = (Context) zzkh.checkNotNull(context);
        this.b = (Uri) zzkh.checkNotNull(uri);
        this.c = null;
        this.d = null;
        this.e = 0L;
        this.f = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final boolean zzdh(long j) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final boolean zzdg(long j) throws IOException {
        if (!this.i) {
            this.g = new MediaExtractor();
            Context context = this.f3640a;
            if (context != null) {
                this.g.setDataSource(context, this.b, (Map<String, String>) null);
            } else {
                this.g.setDataSource((FileDescriptor) null, 0L, 0L);
            }
            this.k = new int[this.g.getTrackCount()];
            int[] iArr = this.k;
            this.l = new boolean[iArr.length];
            this.h = new zzho[iArr.length];
            for (int i = 0; i < this.k.length; i++) {
                MediaFormat trackFormat = this.g.getTrackFormat(i);
                this.h[i] = new zzho(trackFormat.getString("mime"), trackFormat.containsKey("durationUs") ? trackFormat.getLong("durationUs") : -1L);
            }
            this.i = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final int getTrackCount() {
        zzkh.checkState(this.i);
        return this.k.length;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final zzho zzo(int i) {
        zzkh.checkState(this.i);
        return this.h[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void zza(int i, long j) {
        zzkh.checkState(this.i);
        zzkh.checkState(this.k[i] == 0);
        this.k[i] = 1;
        this.g.selectTrack(i);
        a(j, j != 0);
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final int zza(int i, long j, zzhk zzhkVar, zzhm zzhmVar, boolean z) {
        Map<UUID, byte[]> psshInfo;
        zzkh.checkState(this.i);
        zzkh.checkState(this.k[i] != 0);
        boolean[] zArr = this.l;
        if (zArr[i]) {
            zArr[i] = false;
            return -5;
        }
        if (z) {
            return -2;
        }
        if (this.k[i] != 2) {
            zzhkVar.zzado = zzhj.zza(this.g.getTrackFormat(i));
            zzhx zzhxVar = null;
            if (zzkq.SDK_INT >= 18 && (psshInfo = this.g.getPsshInfo()) != null && !psshInfo.isEmpty()) {
                zzhxVar = new zzhx("video/mp4");
                zzhxVar.putAll(psshInfo);
            }
            zzhkVar.zzadp = zzhxVar;
            this.k[i] = 2;
            return -4;
        }
        int sampleTrackIndex = this.g.getSampleTrackIndex();
        if (sampleTrackIndex != i) {
            return sampleTrackIndex < 0 ? -1 : -2;
        }
        if (zzhmVar.zzde != null) {
            int position = zzhmVar.zzde.position();
            zzhmVar.size = this.g.readSampleData(zzhmVar.zzde, position);
            zzhmVar.zzde.position(position + zzhmVar.size);
        } else {
            zzhmVar.size = 0;
        }
        zzhmVar.zzaga = this.g.getSampleTime();
        zzhmVar.flags = this.g.getSampleFlags() & 3;
        if (zzhmVar.zzeo()) {
            zzhmVar.zzafz.zza(this.g);
        }
        this.m = -1L;
        this.g.advance();
        return -3;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void zzp(int i) {
        zzkh.checkState(this.i);
        zzkh.checkState(this.k[i] != 0);
        this.g.unselectTrack(i);
        this.l[i] = false;
        this.k[i] = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void zzdi(long j) {
        zzkh.checkState(this.i);
        a(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final long zzdu() {
        zzkh.checkState(this.i);
        long cachedDuration = this.g.getCachedDuration();
        if (cachedDuration == -1) {
            return -1L;
        }
        long sampleTime = this.g.getSampleTime();
        if (sampleTime == -1) {
            return -3L;
        }
        return sampleTime + cachedDuration;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void release() {
        MediaExtractor mediaExtractor;
        zzkh.checkState(this.j > 0);
        int i = this.j - 1;
        this.j = i;
        if (i != 0 || (mediaExtractor = this.g) == null) {
            return;
        }
        mediaExtractor.release();
        this.g = null;
    }

    private final void a(long j, boolean z) {
        if (!z && this.m == j) {
            return;
        }
        this.m = j;
        int i = 0;
        this.g.seekTo(j, 0);
        while (true) {
            int[] iArr = this.k;
            if (i >= iArr.length) {
                return;
            }
            if (iArr[i] != 0) {
                this.l[i] = true;
            }
            i++;
        }
    }
}
