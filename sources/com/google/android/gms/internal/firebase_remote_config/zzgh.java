package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class zzgh extends zzge {
    protected final byte[] zzpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.zzpc = bArr;
    }

    protected int b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzfx
    public byte zzv(int i) {
        return this.zzpc[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.zzfx
    public byte a(int i) {
        return this.zzpc[i];
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzfx
    public int size() {
        return this.zzpc.length;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzfx
    public final zzfx zzb(int i, int i2) {
        int b = b(0, i2, size());
        if (b == 0) {
            return zzfx.zzow;
        }
        return new zzga(this.zzpc, b(), b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.zzfx
    public final void a(zzfu zzfuVar) throws IOException {
        zzfuVar.zza(this.zzpc, b(), size());
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzfx
    protected final String a(Charset charset) {
        return new String(this.zzpc, b(), size(), charset);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzfx
    public final boolean zzew() {
        int b = b();
        return ej.a(this.zzpc, b, size() + b);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzfx
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx) || size() != ((zzfx) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzgh) {
            zzgh zzghVar = (zzgh) obj;
            int a2 = a();
            int a3 = zzghVar.a();
            if (a2 == 0 || a3 == 0 || a2 == a3) {
                return a(zzghVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzge
    final boolean a(zzfx zzfxVar, int i, int i2) {
        if (i2 > zzfxVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzfxVar.size()) {
            int size2 = zzfxVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzfxVar instanceof zzgh) {
            zzgh zzghVar = (zzgh) zzfxVar;
            return eh.a(this.zzpc, b(), zzghVar.zzpc, zzghVar.b(), i2) == -1;
        }
        return zzfxVar.zzb(0, i2).equals(zzb(0, i2));
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzfx
    protected final int a(int i, int i2, int i3) {
        return zzhi.a(i, this.zzpc, b(), i3);
    }
}
