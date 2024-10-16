package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class zzav extends zzp {

    /* renamed from: a, reason: collision with root package name */
    private final Object f4125a;
    private final zzaw b;
    private String c;

    public zzav(zzaw zzawVar, Object obj) {
        super("application/json; charset=UTF-8");
        this.b = (zzaw) zzdt.checkNotNull(zzawVar);
        this.f4125a = zzdt.checkNotNull(obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzcm
    public final void writeTo(OutputStream outputStream) throws IOException {
        zzaz zza = this.b.zza(outputStream, a());
        if (this.c != null) {
            zza.zzau();
            zza.zzad(this.c);
        }
        zza.zzd(this.f4125a);
        if (this.c != null) {
            zza.zzav();
        }
        zza.flush();
    }

    public final zzav zzab(String str) {
        this.c = str;
        return this;
    }
}
