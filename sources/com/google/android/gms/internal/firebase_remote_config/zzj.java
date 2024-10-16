package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzj implements zzi {

    /* renamed from: a, reason: collision with root package name */
    private final String f4189a;
    private final String b;

    public zzj() {
        this(null);
    }

    public zzj(String str) {
        this(str, null);
    }

    private zzj(String str, String str2) {
        this.f4189a = str;
        this.b = null;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzi
    public final void zza(zzf<?> zzfVar) throws IOException {
        String str = this.f4189a;
        if (str != null) {
            zzfVar.put("key", str);
        }
    }
}
