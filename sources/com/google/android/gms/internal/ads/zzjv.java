package com.google.android.gms.internal.ads;

import com.helpshift.analytics.AnalyticsEventKey;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes2.dex */
public final class zzjv implements zzkf {

    /* renamed from: a, reason: collision with root package name */
    private final zzke f3667a;
    private RandomAccessFile b;
    private String c;
    private long d;
    private boolean e;

    public zzjv() {
        this(null);
    }

    public zzjv(zzke zzkeVar) {
        this.f3667a = zzkeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long zza(zzjq zzjqVar) throws zzjw {
        try {
            this.c = zzjqVar.uri.toString();
            this.b = new RandomAccessFile(zzjqVar.uri.getPath(), AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            this.b.seek(zzjqVar.zzahv);
            this.d = zzjqVar.zzcd == -1 ? this.b.length() - zzjqVar.zzahv : zzjqVar.zzcd;
            if (this.d < 0) {
                throw new EOFException();
            }
            this.e = true;
            zzke zzkeVar = this.f3667a;
            if (zzkeVar != null) {
                zzkeVar.zzgc();
            }
            return this.d;
        } catch (IOException e) {
            throw new zzjw(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i, int i2) throws zzjw {
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.b.read(bArr, i, (int) Math.min(j, i2));
            if (read > 0) {
                this.d -= read;
                zzke zzkeVar = this.f3667a;
                if (zzkeVar != null) {
                    zzkeVar.zzab(read);
                }
            }
            return read;
        } catch (IOException e) {
            throw new zzjw(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws zzjw {
        RandomAccessFile randomAccessFile = this.b;
        if (randomAccessFile != null) {
            try {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    throw new zzjw(e);
                }
            } finally {
                this.b = null;
                this.c = null;
                if (this.e) {
                    this.e = false;
                    zzke zzkeVar = this.f3667a;
                    if (zzkeVar != null) {
                        zzkeVar.zzgd();
                    }
                }
            }
        }
    }
}
