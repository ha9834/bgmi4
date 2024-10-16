package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class zzbr {
    private static final Map<Class<?>, zzbr> b = new WeakHashMap();
    private static final Map<Class<?>, zzbr> c = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    final List<String> f4136a;
    private final Class<?> d;
    private final boolean e;
    private final IdentityHashMap<String, zzbz> f = new IdentityHashMap<>();

    public static zzbr zzc(Class<?> cls) {
        return zza(cls, false);
    }

    public static zzbr zza(Class<?> cls, boolean z) {
        zzbr zzbrVar;
        if (cls == null) {
            return null;
        }
        Map<Class<?>, zzbr> map = z ? c : b;
        synchronized (map) {
            zzbrVar = map.get(cls);
            if (zzbrVar == null) {
                zzbrVar = new zzbr(cls, z);
                map.put(cls, zzbrVar);
            }
        }
        return zzbrVar;
    }

    public final boolean zzbv() {
        return this.e;
    }

    public final zzbz zzae(String str) {
        if (str != null) {
            if (this.e) {
                str = str.toLowerCase(Locale.US);
            }
            str = str.intern();
        }
        return this.f.get(str);
    }

    public final boolean isEnum() {
        return this.d.isEnum();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzbr(Class<?> cls, boolean z) {
        this.d = cls;
        this.e = z;
        boolean z2 = (z && cls.isEnum()) ? false : true;
        String valueOf = String.valueOf(cls);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
        sb.append("cannot ignore case on an enum: ");
        sb.append(valueOf);
        String sb2 = sb.toString();
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(sb2));
        }
        TreeSet treeSet = new TreeSet(new k(this));
        for (Field field : cls.getDeclaredFields()) {
            zzbz zza = zzbz.zza(field);
            if (zza != null) {
                String name = zza.getName();
                name = z ? name.toLowerCase(Locale.US).intern() : name;
                zzbz zzbzVar = this.f.get(name);
                boolean z3 = zzbzVar == null;
                Object[] objArr = new Object[4];
                objArr[0] = z ? "case-insensitive " : "";
                objArr[1] = name;
                objArr[2] = field;
                objArr[3] = zzbzVar == null ? null : zzbzVar.zzbz();
                if (!z3) {
                    throw new IllegalArgumentException(zzdy.zza("two fields have the same %sname <%s>: %s and %s", objArr));
                }
                this.f.put(name, zza);
                treeSet.add(name);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            zzbr zza2 = zza(superclass, z);
            treeSet.addAll(zza2.f4136a);
            for (Map.Entry<String, zzbz> entry : zza2.f.entrySet()) {
                String key = entry.getKey();
                if (!this.f.containsKey(key)) {
                    this.f.put(key, entry.getValue());
                }
            }
        }
        this.f4136a = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
    }

    public final Collection<zzbz> zzbw() {
        return Collections.unmodifiableCollection(this.f.values());
    }
}
