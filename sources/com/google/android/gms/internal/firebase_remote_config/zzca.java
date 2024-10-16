package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzca {
    public static long zzb(zzcm zzcmVar) throws IOException {
        j jVar = new j();
        try {
            zzcmVar.writeTo(jVar);
            jVar.close();
            return jVar.f4100a;
        } catch (Throwable th) {
            jVar.close();
            throw th;
        }
    }
}
