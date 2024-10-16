package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
final class e extends zzaz {

    /* renamed from: a, reason: collision with root package name */
    private final zzfk f4087a;
    private final zzbf b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzbf zzbfVar, zzfk zzfkVar) {
        this.b = zzbfVar;
        this.f4087a = zzfkVar;
        zzfkVar.setLenient(true);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void flush() throws IOException {
        this.f4087a.flush();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void writeBoolean(boolean z) throws IOException {
        this.f4087a.zzd(z);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zzat() throws IOException {
        this.f4087a.zzeg();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zzav() throws IOException {
        this.f4087a.zzei();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zzad(String str) throws IOException {
        this.f4087a.zzbf(str);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zzaw() throws IOException {
        this.f4087a.zzel();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zze(int i) throws IOException {
        this.f4087a.zzf(i);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zza(long j) throws IOException {
        this.f4087a.zzf(j);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zza(BigInteger bigInteger) throws IOException {
        this.f4087a.zza(bigInteger);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zza(double d) throws IOException {
        this.f4087a.zzb(d);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zza(float f) throws IOException {
        this.f4087a.zzb(f);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zza(BigDecimal bigDecimal) throws IOException {
        this.f4087a.zza(bigDecimal);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zzas() throws IOException {
        this.f4087a.zzef();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zzau() throws IOException {
        this.f4087a.zzeh();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void writeString(String str) throws IOException {
        this.f4087a.zzbg(str);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaz
    public final void zzax() throws IOException {
        this.f4087a.setIndent("  ");
    }
}
