package com.google.android.gms.internal.firebase_remote_config;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzan extends zzp {

    /* renamed from: a, reason: collision with root package name */
    private Object f4123a;

    public zzan(Object obj) {
        super(zzam.MEDIA_TYPE);
        this.f4123a = zzdt.checkNotNull(obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzcm
    public final void writeTo(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, a()));
        boolean z = true;
        for (Map.Entry<String, Object> entry : zzbt.zzf(this.f4123a).entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String zzah = zzcs.zzah(entry.getKey());
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    Iterator it = zzco.zzi(value).iterator();
                    while (it.hasNext()) {
                        z = a(z, bufferedWriter, zzah, it.next());
                    }
                } else {
                    z = a(z, bufferedWriter, zzah, value);
                }
            }
        }
        bufferedWriter.flush();
    }

    private static boolean a(boolean z, Writer writer, String str, Object obj) throws IOException {
        if (obj == null || zzbt.isNull(obj)) {
            return z;
        }
        if (z) {
            z = false;
        } else {
            writer.write("&");
        }
        writer.write(str);
        String zzah = zzcs.zzah(obj instanceof Enum ? zzbz.zza((Enum<?>) obj).getName() : obj.toString());
        if (zzah.length() != 0) {
            writer.write("=");
            writer.write(zzah);
        }
        return z;
    }
}
