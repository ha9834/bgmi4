package com.google.android.gms.internal.firebase_remote_config;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public abstract class zzaw {
    public abstract zzaz zza(OutputStream outputStream, Charset charset) throws IOException;

    public abstract zzba zza(InputStream inputStream) throws IOException;

    public abstract zzba zza(InputStream inputStream, Charset charset) throws IOException;

    public abstract zzba zzac(String str) throws IOException;

    public final String toString(Object obj) throws IOException {
        return a(obj, false);
    }

    public final String zzc(Object obj) throws IOException {
        return a(obj, true);
    }

    private final String a(Object obj, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzaz zza = zza(byteArrayOutputStream, zzbo.UTF_8);
        if (z) {
            zza.zzax();
        }
        zza.zzd(obj);
        zza.flush();
        return byteArrayOutputStream.toString("UTF-8");
    }
}
