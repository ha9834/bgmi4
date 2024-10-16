package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class zzjm implements zzkf {

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f3662a;
    private final zzke b;
    private String c;
    private InputStream d;
    private long e;
    private boolean f;

    public zzjm(Context context, zzke zzkeVar) {
        this.f3662a = context.getAssets();
        this.b = zzkeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long zza(zzjq zzjqVar) throws zzjn {
        try {
            this.c = zzjqVar.uri.toString();
            String path = zzjqVar.uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.d = this.f3662a.open(path, 1);
            zzkh.checkState(this.d.skip(zzjqVar.zzahv) == zzjqVar.zzahv);
            this.e = zzjqVar.zzcd == -1 ? this.d.available() : zzjqVar.zzcd;
            if (this.e < 0) {
                throw new EOFException();
            }
            this.f = true;
            zzke zzkeVar = this.b;
            if (zzkeVar != null) {
                zzkeVar.zzgc();
            }
            return this.e;
        } catch (IOException e) {
            throw new zzjn(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i, int i2) throws zzjn {
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.d.read(bArr, i, (int) Math.min(j, i2));
            if (read > 0) {
                this.e -= read;
                zzke zzkeVar = this.b;
                if (zzkeVar != null) {
                    zzkeVar.zzab(read);
                }
            }
            return read;
        } catch (IOException e) {
            throw new zzjn(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws zzjn {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            try {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new zzjn(e);
                }
            } finally {
                this.d = null;
                if (this.f) {
                    this.f = false;
                    zzke zzkeVar = this.b;
                    if (zzkeVar != null) {
                        zzkeVar.zzgd();
                    }
                }
            }
        }
    }
}
