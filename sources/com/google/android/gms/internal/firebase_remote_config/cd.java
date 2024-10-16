package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cd<FieldDescriptorType extends zzhc<FieldDescriptorType>> {
    private static final cd d = new cd(true);
    private boolean b;
    private boolean c = false;

    /* renamed from: a, reason: collision with root package name */
    final dn<FieldDescriptorType, Object> f4056a = dn.a(16);

    private cd() {
    }

    private cd(boolean z) {
        b();
    }

    public static <T extends zzhc<T>> cd<T> a() {
        return d;
    }

    public final void b() {
        if (this.b) {
            return;
        }
        this.f4056a.a();
        this.b = true;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cd) {
            return this.f4056a.equals(((cd) obj).f4056a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4056a.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> d() {
        if (this.c) {
            return new cj(this.f4056a.entrySet().iterator());
        }
        return this.f4056a.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.c) {
            return new cj(this.f4056a.e().iterator());
        }
        return this.f4056a.e().iterator();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f4056a.get(fielddescriptortype);
        return obj instanceof zzhr ? zzhr.zzho() : obj;
    }

    private final void b(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzgq()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                a(fielddescriptortype.zzgo(), obj2);
            }
            obj = arrayList;
        } else {
            a(fielddescriptortype.zzgo(), obj);
        }
        if (obj instanceof zzhr) {
            this.c = true;
        }
        this.f4056a.a((dn<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    private static void a(zzkk zzkkVar, Object obj) {
        zzhi.a(obj);
        boolean z = false;
        switch (cb.f4054a[zzkkVar.zzjj().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzfx) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzhl)) {
                    z = true;
                    break;
                }
                break;
            case 9:
                if ((obj instanceof zzim) || (obj instanceof zzhr)) {
                    z = true;
                    break;
                }
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean f() {
        for (int i = 0; i < this.f4056a.c(); i++) {
            if (!a((Map.Entry) this.f4056a.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f4056a.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzgp() == zzkr.MESSAGE) {
            if (key.zzgq()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzim) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzim) {
                    if (!((zzim) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzhr) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(cd<FieldDescriptorType> cdVar) {
        for (int i = 0; i < cdVar.f4056a.c(); i++) {
            b(cdVar.f4056a.b(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = cdVar.f4056a.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zziv) {
            return ((zziv) obj).zzie();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void b(Map.Entry<FieldDescriptorType, Object> entry) {
        zzim zzgw;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzhr) {
            value = zzhr.zzho();
        }
        if (key.zzgq()) {
            Object a2 = a((cd<FieldDescriptorType>) key);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) a2).add(a(it.next()));
            }
            this.f4056a.a((dn<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
            return;
        }
        if (key.zzgp() == zzkr.MESSAGE) {
            Object a3 = a((cd<FieldDescriptorType>) key);
            if (a3 == null) {
                this.f4056a.a((dn<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                return;
            }
            if (a3 instanceof zziv) {
                zzgw = key.zza((zziv) a3, (zziv) value);
            } else {
                zzgw = key.zza(((zzim) a3).zzha(), (zzim) value).zzgw();
            }
            this.f4056a.a((dn<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzgw);
            return;
        }
        this.f4056a.a((dn<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzgo zzgoVar, zzkk zzkkVar, int i, Object obj) throws IOException {
        if (zzkkVar == zzkk.zzys) {
            zzim zzimVar = (zzim) obj;
            zzhi.a(zzimVar);
            zzgoVar.zzc(i, 3);
            zzimVar.zzb(zzgoVar);
            zzgoVar.zzc(i, 4);
            return;
        }
        zzgoVar.zzc(i, zzkkVar.zzjk());
        switch (cb.b[zzkkVar.ordinal()]) {
            case 1:
                zzgoVar.zzc(((Double) obj).doubleValue());
                return;
            case 2:
                zzgoVar.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzgoVar.zzh(((Long) obj).longValue());
                return;
            case 4:
                zzgoVar.zzh(((Long) obj).longValue());
                return;
            case 5:
                zzgoVar.zzam(((Integer) obj).intValue());
                return;
            case 6:
                zzgoVar.zzj(((Long) obj).longValue());
                return;
            case 7:
                zzgoVar.zzap(((Integer) obj).intValue());
                return;
            case 8:
                zzgoVar.zze(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzim) obj).zzb(zzgoVar);
                return;
            case 10:
                zzgoVar.zzb((zzim) obj);
                return;
            case 11:
                if (obj instanceof zzfx) {
                    zzgoVar.zzb((zzfx) obj);
                    return;
                } else {
                    zzgoVar.zzbk((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzfx) {
                    zzgoVar.zzb((zzfx) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzgoVar.a(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzgoVar.zzan(((Integer) obj).intValue());
                return;
            case 14:
                zzgoVar.zzap(((Integer) obj).intValue());
                return;
            case 15:
                zzgoVar.zzj(((Long) obj).longValue());
                return;
            case 16:
                zzgoVar.zzao(((Integer) obj).intValue());
                return;
            case 17:
                zzgoVar.zzi(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzhl) {
                    zzgoVar.zzam(((zzhl) obj).zzgn());
                    return;
                } else {
                    zzgoVar.zzam(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int g() {
        int i = 0;
        for (int i2 = 0; i2 < this.f4056a.c(); i2++) {
            i += c(this.f4056a.b(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f4056a.d().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzgp() == zzkr.MESSAGE && !key.zzgq() && !key.zzgr()) {
            if (value instanceof zzhr) {
                return zzgo.zzb(entry.getKey().zzgn(), (zzhr) value);
            }
            return zzgo.zzb(entry.getKey().zzgn(), (zzim) value);
        }
        return a((zzhc<?>) key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzkk zzkkVar, int i, Object obj) {
        int zzaq = zzgo.zzaq(i);
        if (zzkkVar == zzkk.zzys) {
            zzhi.a((zzim) obj);
            zzaq <<= 1;
        }
        return zzaq + b(zzkkVar, obj);
    }

    private static int b(zzkk zzkkVar, Object obj) {
        switch (cb.b[zzkkVar.ordinal()]) {
            case 1:
                return zzgo.zzd(((Double) obj).doubleValue());
            case 2:
                return zzgo.zzc(((Float) obj).floatValue());
            case 3:
                return zzgo.zzk(((Long) obj).longValue());
            case 4:
                return zzgo.zzl(((Long) obj).longValue());
            case 5:
                return zzgo.zzar(((Integer) obj).intValue());
            case 6:
                return zzgo.zzn(((Long) obj).longValue());
            case 7:
                return zzgo.zzau(((Integer) obj).intValue());
            case 8:
                return zzgo.zzf(((Boolean) obj).booleanValue());
            case 9:
                return zzgo.zzd((zzim) obj);
            case 10:
                if (obj instanceof zzhr) {
                    return zzgo.zza((zzhr) obj);
                }
                return zzgo.zzc((zzim) obj);
            case 11:
                if (obj instanceof zzfx) {
                    return zzgo.zzc((zzfx) obj);
                }
                return zzgo.zzbl((String) obj);
            case 12:
                if (obj instanceof zzfx) {
                    return zzgo.zzc((zzfx) obj);
                }
                return zzgo.zzd((byte[]) obj);
            case 13:
                return zzgo.zzas(((Integer) obj).intValue());
            case 14:
                return zzgo.zzav(((Integer) obj).intValue());
            case 15:
                return zzgo.zzo(((Long) obj).longValue());
            case 16:
                return zzgo.zzat(((Integer) obj).intValue());
            case 17:
                return zzgo.zzm(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzhl) {
                    return zzgo.zzaw(((zzhl) obj).zzgn());
                }
                return zzgo.zzaw(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int a(zzhc<?> zzhcVar, Object obj) {
        zzkk zzgo = zzhcVar.zzgo();
        int zzgn = zzhcVar.zzgn();
        if (zzhcVar.zzgq()) {
            int i = 0;
            if (zzhcVar.zzgr()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += b(zzgo, it.next());
                }
                return zzgo.zzaq(zzgn) + i + zzgo.zzay(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(zzgo, zzgn, it2.next());
            }
            return i;
        }
        return a(zzgo, zzgn, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        cd cdVar = new cd();
        for (int i = 0; i < this.f4056a.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b = this.f4056a.b(i);
            cdVar.b((cd) b.getKey(), b.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f4056a.d()) {
            cdVar.b((cd) entry.getKey(), entry.getValue());
        }
        cdVar.c = this.c;
        return cdVar;
    }
}
