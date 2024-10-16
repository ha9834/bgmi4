package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class zzu implements zzcm {

    /* renamed from: a, reason: collision with root package name */
    private final zzcm f4195a;
    private final zzv b;

    public zzu(zzcm zzcmVar, zzv zzvVar) {
        this.f4195a = (zzcm) zzdt.checkNotNull(zzcmVar);
        this.b = (zzv) zzdt.checkNotNull(zzvVar);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzcm
    public final void writeTo(OutputStream outputStream) throws IOException {
        this.b.zza(this.f4195a, outputStream);
    }
}
