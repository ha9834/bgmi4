package com.google.android.gms.internal.ads;

import android.content.Context;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzjt implements zzkf {

    /* renamed from: a, reason: collision with root package name */
    private final zzkf f3666a;
    private final zzkf b;
    private final zzkf c;
    private zzkf d;

    public zzjt(Context context, String str) {
        this(context, null, str, false);
    }

    private zzjt(Context context, zzke zzkeVar, String str, boolean z) {
        this(context, null, new zzjs(str, null, null, 8000, 8000, false));
    }

    private zzjt(Context context, zzke zzkeVar, zzkf zzkfVar) {
        this.f3666a = (zzkf) zzkh.checkNotNull(zzkfVar);
        this.b = new zzjv(null);
        this.c = new zzjm(context, null);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long zza(zzjq zzjqVar) throws IOException {
        zzkh.checkState(this.d == null);
        String scheme = zzjqVar.uri.getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            this.d = this.f3666a;
        } else if (TransferTable.COLUMN_FILE.equals(scheme)) {
            if (zzjqVar.uri.getPath().startsWith("/android_asset/")) {
                this.d = this.c;
            } else {
                this.d = this.b;
            }
        } else if ("asset".equals(scheme)) {
            this.d = this.c;
        } else {
            throw new zzju(scheme);
        }
        return this.d.zza(zzjqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.d.read(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws IOException {
        zzkf zzkfVar = this.d;
        if (zzkfVar != null) {
            try {
                zzkfVar.close();
            } finally {
                this.d = null;
            }
        }
    }
}
