package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zza implements zzad, zzx {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4113a;

    public zza() {
        this(false);
    }

    private zza(boolean z) {
        this.f4113a = false;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzad
    public final void zza(zzab zzabVar) {
        zzabVar.zza(this);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzx
    public final void zzb(zzab zzabVar) throws IOException {
        String requestMethod = zzabVar.getRequestMethod();
        boolean z = true;
        if (requestMethod.equals("POST") || ((!requestMethod.equals("GET") || zzabVar.zzt().zzp().length() <= 2048) && zzabVar.zzs().zzz(requestMethod))) {
            z = false;
        }
        if (z) {
            String requestMethod2 = zzabVar.getRequestMethod();
            zzabVar.zzw("POST");
            zzabVar.zzx().zzb("X-HTTP-Method-Override", requestMethod2);
            if (requestMethod2.equals("GET")) {
                zzabVar.zza(new zzan((zzt) zzabVar.zzt().clone()));
                zzabVar.zzt().clear();
            } else if (zzabVar.zzu() == null) {
                zzabVar.zza(new zzo());
            }
        }
    }
}
