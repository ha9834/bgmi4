package com.google.android.gms.internal.firebase_remote_config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zzbf extends zzaw {
    public static zzbf zzbq() {
        return f.f4096a;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaw
    public final zzba zza(InputStream inputStream) {
        return a(new InputStreamReader(inputStream, zzbo.UTF_8));
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaw
    public final zzba zza(InputStream inputStream, Charset charset) {
        if (charset == null) {
            return zza(inputStream);
        }
        return a(new InputStreamReader(inputStream, charset));
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaw
    public final zzba zzac(String str) {
        return a(new StringReader(str));
    }

    private final zzba a(Reader reader) {
        return new h(this, new zzfj(reader));
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzaw
    public final zzaz zza(OutputStream outputStream, Charset charset) {
        return new e(this, new zzfk(new OutputStreamWriter(outputStream, charset)));
    }
}
