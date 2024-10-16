package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public abstract class zzp implements zzs {

    /* renamed from: a, reason: collision with root package name */
    private zzy f4194a;
    private long b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzp(String str) {
        this(str == null ? null : new zzy(str));
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzs
    public final boolean zzn() {
        return true;
    }

    private zzp(zzy zzyVar) {
        this.b = -1L;
        this.f4194a = zzyVar;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzs
    public final long getLength() throws IOException {
        if (this.b == -1) {
            this.b = zzca.zzb(this);
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Charset a() {
        zzy zzyVar = this.f4194a;
        return (zzyVar == null || zzyVar.zzr() == null) ? zzbo.UTF_8 : this.f4194a.zzr();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzs
    public final String getType() {
        zzy zzyVar = this.f4194a;
        if (zzyVar == null) {
            return null;
        }
        return zzyVar.zzp();
    }
}
