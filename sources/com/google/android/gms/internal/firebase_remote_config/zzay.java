package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzay implements zzci {

    /* renamed from: a, reason: collision with root package name */
    private final zzaw f4126a;
    private final Set<String> b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzay(zzbb zzbbVar) {
        this.f4126a = zzbbVar.f4129a;
        this.b = new HashSet(zzbbVar.b);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzci
    public final <T> T zza(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        zzba zza = this.f4126a.zza(inputStream, charset);
        if (!this.b.isEmpty()) {
            try {
                boolean z = (zza.zza(this.b) == null || zza.zzba() == zzbg.END_OBJECT) ? false : true;
                Object[] objArr = {this.b};
                if (!z) {
                    throw new IllegalArgumentException(zzdy.zza("wrapper key(s) not found: %s", objArr));
                }
            } catch (Throwable th) {
                zza.close();
                throw th;
            }
        }
        return (T) zza.zza(cls, true, null);
    }

    public final zzaw zzl() {
        return this.f4126a;
    }

    public final Set<String> zzar() {
        return Collections.unmodifiableSet(this.b);
    }
}
