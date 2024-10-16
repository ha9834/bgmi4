package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbn {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, i> f4135a = new zzbl();
    private final Map<Field, i> b = new zzbl();
    private final Object c;

    public zzbn(Object obj) {
        this.c = obj;
    }

    public final void zzbu() {
        for (Map.Entry<String, i> entry : this.f4135a.entrySet()) {
            ((Map) this.c).put(entry.getKey(), entry.getValue().a());
        }
        for (Map.Entry<Field, i> entry2 : this.b.entrySet()) {
            zzbz.zza(entry2.getKey(), this.c, entry2.getValue().a());
        }
    }

    public final void zza(Field field, Class<?> cls, Object obj) {
        i iVar = this.b.get(field);
        if (iVar == null) {
            iVar = new i(cls);
            this.b.put(field, iVar);
        }
        if (!(cls == iVar.f4099a)) {
            throw new IllegalArgumentException();
        }
        iVar.b.add(obj);
    }
}
