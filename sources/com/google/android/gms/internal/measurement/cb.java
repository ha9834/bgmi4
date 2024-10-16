package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzeq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cb<FieldDescriptorType extends zzeq<FieldDescriptorType>> {
    private static final cb d = new cb(true);
    private boolean b;
    private boolean c = false;

    /* renamed from: a, reason: collision with root package name */
    final dq<FieldDescriptorType, Object> f4495a = dq.a(16);

    private cb() {
    }

    private cb(boolean z) {
        b();
    }

    public static <T extends zzeq<T>> cb<T> a() {
        return d;
    }

    public final void b() {
        if (this.b) {
            return;
        }
        this.f4495a.a();
        this.b = true;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cb) {
            return this.f4495a.equals(((cb) obj).f4495a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4495a.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> d() {
        if (this.c) {
            return new cl(this.f4495a.entrySet().iterator());
        }
        return this.f4495a.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.c) {
            return new cl(this.f4495a.e().iterator());
        }
        return this.f4495a.e().iterator();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f4495a.get(fielddescriptortype);
        return obj instanceof zzfj ? zzfj.zzvc() : obj;
    }

    private final void b(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzty()) {
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
                a(fielddescriptortype.zztw(), obj2);
            }
            obj = arrayList;
        } else {
            a(fielddescriptortype.zztw(), obj);
        }
        if (obj instanceof zzfj) {
            this.c = true;
        }
        this.f4495a.a((dq<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    private static void a(zzig zzigVar, Object obj) {
        zzez.a(obj);
        boolean z = false;
        switch (cd.f4497a[zzigVar.zzwz().ordinal()]) {
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
                if ((obj instanceof zzdp) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzfc)) {
                    z = true;
                    break;
                }
                break;
            case 9:
                if ((obj instanceof zzgi) || (obj instanceof zzfj)) {
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
        for (int i = 0; i < this.f4495a.c(); i++) {
            if (!a((Map.Entry) this.f4495a.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f4495a.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zztx() == zzij.MESSAGE) {
            if (key.zzty()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzgi) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgi) {
                    if (!((zzgi) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzfj) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(cb<FieldDescriptorType> cbVar) {
        for (int i = 0; i < cbVar.f4495a.c(); i++) {
            b(cbVar.f4495a.b(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = cbVar.f4495a.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zzgn) {
            return ((zzgn) obj).zzvu();
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
        zzgi zzug;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfj) {
            value = zzfj.zzvc();
        }
        if (key.zzty()) {
            Object a2 = a((cb<FieldDescriptorType>) key);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) a2).add(a(it.next()));
            }
            this.f4495a.a((dq<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
            return;
        }
        if (key.zztx() == zzij.MESSAGE) {
            Object a3 = a((cb<FieldDescriptorType>) key);
            if (a3 == null) {
                this.f4495a.a((dq<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                return;
            }
            if (a3 instanceof zzgn) {
                zzug = key.zza((zzgn) a3, (zzgn) value);
            } else {
                zzug = key.zza(((zzgi) a3).zzuo(), (zzgi) value).zzug();
            }
            this.f4495a.a((dq<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzug);
            return;
        }
        this.f4495a.a((dq<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzee zzeeVar, zzig zzigVar, int i, Object obj) throws IOException {
        if (zzigVar == zzig.zzank) {
            zzgi zzgiVar = (zzgi) obj;
            zzez.a(zzgiVar);
            zzeeVar.zzb(i, 3);
            zzgiVar.zzb(zzeeVar);
            zzeeVar.zzb(i, 4);
            return;
        }
        zzeeVar.zzb(i, zzigVar.zzxa());
        switch (cd.b[zzigVar.ordinal()]) {
            case 1:
                zzeeVar.zzd(((Double) obj).doubleValue());
                return;
            case 2:
                zzeeVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzeeVar.zzbn(((Long) obj).longValue());
                return;
            case 4:
                zzeeVar.zzbn(((Long) obj).longValue());
                return;
            case 5:
                zzeeVar.zzbe(((Integer) obj).intValue());
                return;
            case 6:
                zzeeVar.zzbp(((Long) obj).longValue());
                return;
            case 7:
                zzeeVar.zzbh(((Integer) obj).intValue());
                return;
            case 8:
                zzeeVar.zzq(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgi) obj).zzb(zzeeVar);
                return;
            case 10:
                zzeeVar.zzb((zzgi) obj);
                return;
            case 11:
                if (obj instanceof zzdp) {
                    zzeeVar.zza((zzdp) obj);
                    return;
                } else {
                    zzeeVar.zzdr((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdp) {
                    zzeeVar.zza((zzdp) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzeeVar.a(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzeeVar.zzbf(((Integer) obj).intValue());
                return;
            case 14:
                zzeeVar.zzbh(((Integer) obj).intValue());
                return;
            case 15:
                zzeeVar.zzbp(((Long) obj).longValue());
                return;
            case 16:
                zzeeVar.zzbg(((Integer) obj).intValue());
                return;
            case 17:
                zzeeVar.zzbo(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfc) {
                    zzeeVar.zzbe(((zzfc) obj).zzlg());
                    return;
                } else {
                    zzeeVar.zzbe(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int g() {
        int i = 0;
        for (int i2 = 0; i2 < this.f4495a.c(); i2++) {
            i += c(this.f4495a.b(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f4495a.d().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zztx() == zzij.MESSAGE && !key.zzty() && !key.zztz()) {
            if (value instanceof zzfj) {
                return zzee.zzb(entry.getKey().zzlg(), (zzfj) value);
            }
            return zzee.zzd(entry.getKey().zzlg(), (zzgi) value);
        }
        return a((zzeq<?>) key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzig zzigVar, int i, Object obj) {
        int zzbi = zzee.zzbi(i);
        if (zzigVar == zzig.zzank) {
            zzez.a((zzgi) obj);
            zzbi <<= 1;
        }
        return zzbi + b(zzigVar, obj);
    }

    private static int b(zzig zzigVar, Object obj) {
        switch (cd.b[zzigVar.ordinal()]) {
            case 1:
                return zzee.zze(((Double) obj).doubleValue());
            case 2:
                return zzee.zzb(((Float) obj).floatValue());
            case 3:
                return zzee.zzbq(((Long) obj).longValue());
            case 4:
                return zzee.zzbr(((Long) obj).longValue());
            case 5:
                return zzee.zzbj(((Integer) obj).intValue());
            case 6:
                return zzee.zzbt(((Long) obj).longValue());
            case 7:
                return zzee.zzbm(((Integer) obj).intValue());
            case 8:
                return zzee.zzr(((Boolean) obj).booleanValue());
            case 9:
                return zzee.zzd((zzgi) obj);
            case 10:
                if (obj instanceof zzfj) {
                    return zzee.zza((zzfj) obj);
                }
                return zzee.zzc((zzgi) obj);
            case 11:
                if (obj instanceof zzdp) {
                    return zzee.zzb((zzdp) obj);
                }
                return zzee.zzds((String) obj);
            case 12:
                if (obj instanceof zzdp) {
                    return zzee.zzb((zzdp) obj);
                }
                return zzee.zzg((byte[]) obj);
            case 13:
                return zzee.zzbk(((Integer) obj).intValue());
            case 14:
                return zzee.zzbn(((Integer) obj).intValue());
            case 15:
                return zzee.zzbu(((Long) obj).longValue());
            case 16:
                return zzee.zzbl(((Integer) obj).intValue());
            case 17:
                return zzee.zzbs(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfc) {
                    return zzee.zzbo(((zzfc) obj).zzlg());
                }
                return zzee.zzbo(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int a(zzeq<?> zzeqVar, Object obj) {
        zzig zztw = zzeqVar.zztw();
        int zzlg = zzeqVar.zzlg();
        if (zzeqVar.zzty()) {
            int i = 0;
            if (zzeqVar.zztz()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += b(zztw, it.next());
                }
                return zzee.zzbi(zzlg) + i + zzee.zzbq(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(zztw, zzlg, it2.next());
            }
            return i;
        }
        return a(zztw, zzlg, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        cb cbVar = new cb();
        for (int i = 0; i < this.f4495a.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b = this.f4495a.b(i);
            cbVar.b((cb) b.getKey(), b.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f4495a.d()) {
            cbVar.b((cb) entry.getKey(), entry.getValue());
        }
        cbVar.c = this.c;
        return cbVar;
    }
}
