package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdnu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class afk<FieldDescriptorType extends zzdnu<FieldDescriptorType>> {
    private static final afk d = new afk(true);
    private boolean b;
    private boolean c = false;

    /* renamed from: a, reason: collision with root package name */
    private final aha<FieldDescriptorType, Object> f1846a = aha.a(16);

    private afk() {
    }

    private afk(boolean z) {
        c();
    }

    public static <T extends zzdnu<T>> afk<T> a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f1846a.isEmpty();
    }

    public final void c() {
        if (this.b) {
            return;
        }
        this.f1846a.a();
        this.b = true;
    }

    public final boolean d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof afk) {
            return this.f1846a.equals(((afk) obj).f1846a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1846a.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.c) {
            return new afu(this.f1846a.entrySet().iterator());
        }
        return this.f1846a.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> f() {
        if (this.c) {
            return new afu(this.f1846a.e().iterator());
        }
        return this.f1846a.e().iterator();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f1846a.get(fielddescriptortype);
        return obj instanceof zzdon ? zzdon.zzaym() : obj;
    }

    private final void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzaxn()) {
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
                a(fielddescriptortype.zzaxl(), obj2);
            }
            obj = arrayList;
        } else {
            a(fielddescriptortype.zzaxl(), obj);
        }
        if (obj instanceof zzdon) {
            this.c = true;
        }
        this.f1846a.a((aha<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    private static void a(zzdri zzdriVar, Object obj) {
        zzdod.a(obj);
        boolean z = false;
        switch (afl.f1847a[zzdriVar.zzbaj().ordinal()]) {
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
                if ((obj instanceof zzdmr) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzdoe)) {
                    z = true;
                    break;
                }
                break;
            case 9:
                if ((obj instanceof zzdpk) || (obj instanceof zzdon)) {
                    z = true;
                    break;
                }
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean g() {
        for (int i = 0; i < this.f1846a.c(); i++) {
            if (!a((Map.Entry) this.f1846a.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f1846a.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzaxm() == zzdrn.MESSAGE) {
            if (key.zzaxn()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzdpk) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzdpk) {
                    if (!((zzdpk) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzdon) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(afk<FieldDescriptorType> afkVar) {
        for (int i = 0; i < afkVar.f1846a.c(); i++) {
            b(afkVar.f1846a.b(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = afkVar.f1846a.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zzdpr) {
            return ((zzdpr) obj).zzazc();
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
        zzdpk zzaya;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdon) {
            value = zzdon.zzaym();
        }
        if (key.zzaxn()) {
            Object a2 = a((afk<FieldDescriptorType>) key);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) a2).add(a(it.next()));
            }
            this.f1846a.a((aha<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
            return;
        }
        if (key.zzaxm() == zzdrn.MESSAGE) {
            Object a3 = a((afk<FieldDescriptorType>) key);
            if (a3 == null) {
                this.f1846a.a((aha<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                return;
            }
            if (a3 instanceof zzdpr) {
                zzaya = key.zza((zzdpr) a3, (zzdpr) value);
            } else {
                zzaya = key.zza(((zzdpk) a3).zzaxt(), (zzdpk) value).zzaya();
            }
            this.f1846a.a((aha<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzaya);
            return;
        }
        this.f1846a.a((aha<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzdni zzdniVar, zzdri zzdriVar, int i, Object obj) throws IOException {
        if (zzdriVar == zzdri.zzhmq) {
            zzdpk zzdpkVar = (zzdpk) obj;
            zzdod.a(zzdpkVar);
            zzdniVar.zzw(i, 3);
            zzdpkVar.zzb(zzdniVar);
            zzdniVar.zzw(i, 4);
            return;
        }
        zzdniVar.zzw(i, zzdriVar.zzbak());
        switch (afl.b[zzdriVar.ordinal()]) {
            case 1:
                zzdniVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzdniVar.zzg(((Float) obj).floatValue());
                return;
            case 3:
                zzdniVar.zzfj(((Long) obj).longValue());
                return;
            case 4:
                zzdniVar.zzfj(((Long) obj).longValue());
                return;
            case 5:
                zzdniVar.zzfz(((Integer) obj).intValue());
                return;
            case 6:
                zzdniVar.zzfl(((Long) obj).longValue());
                return;
            case 7:
                zzdniVar.zzgc(((Integer) obj).intValue());
                return;
            case 8:
                zzdniVar.zzbf(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzdpk) obj).zzb(zzdniVar);
                return;
            case 10:
                zzdniVar.zzj((zzdpk) obj);
                return;
            case 11:
                if (obj instanceof zzdmr) {
                    zzdniVar.zzcz((zzdmr) obj);
                    return;
                } else {
                    zzdniVar.zzgw((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdmr) {
                    zzdniVar.zzcz((zzdmr) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzdniVar.a(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzdniVar.zzga(((Integer) obj).intValue());
                return;
            case 14:
                zzdniVar.zzgc(((Integer) obj).intValue());
                return;
            case 15:
                zzdniVar.zzfl(((Long) obj).longValue());
                return;
            case 16:
                zzdniVar.zzgb(((Integer) obj).intValue());
                return;
            case 17:
                zzdniVar.zzfk(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzdoe) {
                    zzdniVar.zzfz(((zzdoe) obj).zzac());
                    return;
                } else {
                    zzdniVar.zzfz(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int h() {
        int i = 0;
        for (int i2 = 0; i2 < this.f1846a.c(); i2++) {
            Map.Entry<FieldDescriptorType, Object> b = this.f1846a.b(i2);
            i += b((zzdnu<?>) b.getKey(), b.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f1846a.d()) {
            i += b((zzdnu<?>) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int i() {
        int i = 0;
        for (int i2 = 0; i2 < this.f1846a.c(); i2++) {
            i += c(this.f1846a.b(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f1846a.d().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzaxm() == zzdrn.MESSAGE && !key.zzaxn() && !key.zzaxo()) {
            if (value instanceof zzdon) {
                return zzdni.zzb(entry.getKey().zzac(), (zzdon) value);
            }
            return zzdni.zzd(entry.getKey().zzac(), (zzdpk) value);
        }
        return b((zzdnu<?>) key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzdri zzdriVar, int i, Object obj) {
        int zzgd = zzdni.zzgd(i);
        if (zzdriVar == zzdri.zzhmq) {
            zzdod.a((zzdpk) obj);
            zzgd <<= 1;
        }
        return zzgd + b(zzdriVar, obj);
    }

    private static int b(zzdri zzdriVar, Object obj) {
        switch (afl.b[zzdriVar.ordinal()]) {
            case 1:
                return zzdni.zzc(((Double) obj).doubleValue());
            case 2:
                return zzdni.zzh(((Float) obj).floatValue());
            case 3:
                return zzdni.zzfm(((Long) obj).longValue());
            case 4:
                return zzdni.zzfn(((Long) obj).longValue());
            case 5:
                return zzdni.zzge(((Integer) obj).intValue());
            case 6:
                return zzdni.zzfp(((Long) obj).longValue());
            case 7:
                return zzdni.zzgh(((Integer) obj).intValue());
            case 8:
                return zzdni.zzbg(((Boolean) obj).booleanValue());
            case 9:
                return zzdni.zzl((zzdpk) obj);
            case 10:
                if (obj instanceof zzdon) {
                    return zzdni.zza((zzdon) obj);
                }
                return zzdni.zzk((zzdpk) obj);
            case 11:
                if (obj instanceof zzdmr) {
                    return zzdni.zzda((zzdmr) obj);
                }
                return zzdni.zzgx((String) obj);
            case 12:
                if (obj instanceof zzdmr) {
                    return zzdni.zzda((zzdmr) obj);
                }
                return zzdni.zzac((byte[]) obj);
            case 13:
                return zzdni.zzgf(((Integer) obj).intValue());
            case 14:
                return zzdni.zzgi(((Integer) obj).intValue());
            case 15:
                return zzdni.zzfq(((Long) obj).longValue());
            case 16:
                return zzdni.zzgg(((Integer) obj).intValue());
            case 17:
                return zzdni.zzfo(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzdoe) {
                    return zzdni.zzgj(((zzdoe) obj).zzac());
                }
                return zzdni.zzgj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int b(zzdnu<?> zzdnuVar, Object obj) {
        zzdri zzaxl = zzdnuVar.zzaxl();
        int zzac = zzdnuVar.zzac();
        if (zzdnuVar.zzaxn()) {
            int i = 0;
            if (zzdnuVar.zzaxo()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += b(zzaxl, it.next());
                }
                return zzdni.zzgd(zzac) + i + zzdni.zzgl(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(zzaxl, zzac, it2.next());
            }
            return i;
        }
        return a(zzaxl, zzac, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        afk afkVar = new afk();
        for (int i = 0; i < this.f1846a.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b = this.f1846a.b(i);
            afkVar.a((afk) b.getKey(), b.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f1846a.d()) {
            afkVar.a((afk) entry.getKey(), entry.getValue());
        }
        afkVar.c = this.c;
        return afkVar;
    }
}
