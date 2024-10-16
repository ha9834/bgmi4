package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzcg implements zzcm {

    /* renamed from: a, reason: collision with root package name */
    private final zzcm f4147a;
    private final int b;
    private final Level c;
    private final Logger d;

    public zzcg(zzcm zzcmVar, Logger logger, Level level, int i) {
        this.f4147a = zzcmVar;
        this.d = logger;
        this.c = level;
        this.b = i;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzcm
    public final void writeTo(OutputStream outputStream) throws IOException {
        zzcd zzcdVar = new zzcd(outputStream, this.d, this.c, this.b);
        try {
            this.f4147a.writeTo(zzcdVar);
            zzcdVar.zzcc().close();
            outputStream.flush();
        } catch (Throwable th) {
            zzcdVar.zzcc().close();
            throw th;
        }
    }
}
