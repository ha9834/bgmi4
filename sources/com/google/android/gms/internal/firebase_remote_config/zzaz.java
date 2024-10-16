package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class zzaz {
    public abstract void flush() throws IOException;

    public abstract void writeBoolean(boolean z) throws IOException;

    public abstract void writeString(String str) throws IOException;

    public abstract void zza(double d) throws IOException;

    public abstract void zza(float f) throws IOException;

    public abstract void zza(long j) throws IOException;

    public abstract void zza(BigDecimal bigDecimal) throws IOException;

    public abstract void zza(BigInteger bigInteger) throws IOException;

    public abstract void zzad(String str) throws IOException;

    public abstract void zzas() throws IOException;

    public abstract void zzat() throws IOException;

    public abstract void zzau() throws IOException;

    public abstract void zzav() throws IOException;

    public abstract void zzaw() throws IOException;

    public void zzax() throws IOException {
    }

    public abstract void zze(int i) throws IOException;

    public final void zzd(Object obj) throws IOException {
        a(false, obj);
    }

    private final void a(boolean z, Object obj) throws IOException {
        boolean z2;
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (zzbt.isNull(obj)) {
            zzaw();
            return;
        }
        if (obj instanceof String) {
            writeString((String) obj);
            return;
        }
        if (obj instanceof Number) {
            if (z) {
                writeString(obj.toString());
                return;
            }
            if (obj instanceof BigDecimal) {
                zza((BigDecimal) obj);
                return;
            }
            if (obj instanceof BigInteger) {
                zza((BigInteger) obj);
                return;
            }
            if (obj instanceof Long) {
                zza(((Long) obj).longValue());
                return;
            }
            if (obj instanceof Float) {
                float floatValue = ((Number) obj).floatValue();
                if (!((Float.isInfinite(floatValue) || Float.isNaN(floatValue)) ? false : true)) {
                    throw new IllegalArgumentException();
                }
                zza(floatValue);
                return;
            }
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                zze(((Number) obj).intValue());
                return;
            }
            double doubleValue = ((Number) obj).doubleValue();
            if (!((Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) ? false : true)) {
                throw new IllegalArgumentException();
            }
            zza(doubleValue);
            return;
        }
        if (obj instanceof Boolean) {
            writeBoolean(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof zzbw) {
            writeString(((zzbw) obj).zzbx());
            return;
        }
        if ((obj instanceof Iterable) || cls.isArray()) {
            zzas();
            Iterator it = zzco.zzi(obj).iterator();
            while (it.hasNext()) {
                a(z, it.next());
            }
            zzat();
            return;
        }
        if (cls.isEnum()) {
            String name = zzbz.zza((Enum<?>) obj).getName();
            if (name == null) {
                zzaw();
                return;
            } else {
                writeString(name);
                return;
            }
        }
        zzau();
        boolean z3 = (obj instanceof Map) && !(obj instanceof zzby);
        zzbr zzc = z3 ? null : zzbr.zzc(cls);
        for (Map.Entry<String, Object> entry : zzbt.zzf(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String key = entry.getKey();
                if (z3) {
                    z2 = z;
                } else {
                    zzbz zzae = zzc.zzae(key);
                    Field zzbz = zzae == null ? null : zzae.zzbz();
                    z2 = (zzbz == null || zzbz.getAnnotation(zzbe.class) == null) ? false : true;
                }
                zzad(key);
                a(z2, value);
            }
        }
        zzav();
    }
}
