package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzaa {

    /* renamed from: a, reason: collision with root package name */
    private final zzag f4114a;
    private final zzad b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzag zzagVar, zzad zzadVar) {
        this.f4114a = zzagVar;
        this.b = zzadVar;
    }

    public final zzab zza(String str, zzt zztVar, zzs zzsVar) throws IOException {
        zzab zzabVar = new zzab(this.f4114a, null);
        zzad zzadVar = this.b;
        if (zzadVar != null) {
            zzadVar.zza(zzabVar);
        }
        zzabVar.zzw(str);
        zzabVar.zza(zztVar);
        if (zzsVar != null) {
            zzabVar.zza(zzsVar);
        }
        return zzabVar;
    }
}
