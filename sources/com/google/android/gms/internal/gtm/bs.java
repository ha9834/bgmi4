package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzqv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class bs<FieldDescriptorType extends zzqv<FieldDescriptorType>> {
    private static final bs d = new bs(true);
    private boolean b;
    private boolean c = false;

    /* renamed from: a, reason: collision with root package name */
    final dd<FieldDescriptorType, Object> f4320a = dd.a(16);

    private bs() {
    }

    private bs(boolean z) {
        b();
    }

    public static <T extends zzqv<T>> bs<T> a() {
        return d;
    }

    public final void b() {
        if (this.b) {
            return;
        }
        this.f4320a.a();
        this.b = true;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bs) {
            return this.f4320a.equals(((bs) obj).f4320a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4320a.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> d() {
        if (this.c) {
            return new cb(this.f4320a.entrySet().iterator());
        }
        return this.f4320a.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.c) {
            return new cb(this.f4320a.e().iterator());
        }
        return this.f4320a.e().iterator();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f4320a.get(fielddescriptortype);
        return obj instanceof zzrn ? zzrn.zzpy() : obj;
    }

    private final void b(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzoz()) {
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
                a(fielddescriptortype.zzox(), obj2);
            }
            obj = arrayList;
        } else {
            a(fielddescriptortype.zzox(), obj);
        }
        if (obj instanceof zzrn) {
            this.c = true;
        }
        this.f4320a.a((dd<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    private static void a(zzug zzugVar, Object obj) {
        zzre.a(obj);
        boolean z = false;
        switch (bt.f4321a[zzugVar.zzrs().ordinal()]) {
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
                if ((obj instanceof zzps) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzrf)) {
                    z = true;
                    break;
                }
                break;
            case 9:
                if ((obj instanceof zzsk) || (obj instanceof zzrn)) {
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
        for (int i = 0; i < this.f4320a.c(); i++) {
            if (!a((Map.Entry) this.f4320a.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f4320a.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzoy() == zzul.MESSAGE) {
            if (key.zzoz()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzsk) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzsk) {
                    if (!((zzsk) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzrn) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(bs<FieldDescriptorType> bsVar) {
        for (int i = 0; i < bsVar.f4320a.c(); i++) {
            b(bsVar.f4320a.b(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = bsVar.f4320a.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zzsq) {
            return ((zzsq) obj).zzqo();
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
        zzsk zzpm;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzrn) {
            value = zzrn.zzpy();
        }
        if (key.zzoz()) {
            Object a2 = a((bs<FieldDescriptorType>) key);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) a2).add(a(it.next()));
            }
            this.f4320a.a((dd<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
            return;
        }
        if (key.zzoy() == zzul.MESSAGE) {
            Object a3 = a((bs<FieldDescriptorType>) key);
            if (a3 == null) {
                this.f4320a.a((dd<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                return;
            }
            if (a3 instanceof zzsq) {
                zzpm = key.zza((zzsq) a3, (zzsq) value);
            } else {
                zzpm = key.zza(((zzsk) a3).zzpg(), (zzsk) value).zzpm();
            }
            this.f4320a.a((dd<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzpm);
            return;
        }
        this.f4320a.a((dd<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzqj zzqjVar, zzug zzugVar, int i, Object obj) throws IOException {
        if (zzugVar == zzug.zzbfy) {
            zzsk zzskVar = (zzsk) obj;
            zzre.a(zzskVar);
            zzqjVar.zzd(i, 3);
            zzskVar.zzb(zzqjVar);
            zzqjVar.zzd(i, 4);
            return;
        }
        zzqjVar.zzd(i, zzugVar.zzrt());
        switch (bt.b[zzugVar.ordinal()]) {
            case 1:
                zzqjVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzqjVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzqjVar.zzp(((Long) obj).longValue());
                return;
            case 4:
                zzqjVar.zzp(((Long) obj).longValue());
                return;
            case 5:
                zzqjVar.zzax(((Integer) obj).intValue());
                return;
            case 6:
                zzqjVar.zzr(((Long) obj).longValue());
                return;
            case 7:
                zzqjVar.zzba(((Integer) obj).intValue());
                return;
            case 8:
                zzqjVar.zzi(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzsk) obj).zzb(zzqjVar);
                return;
            case 10:
                zzqjVar.zzb((zzsk) obj);
                return;
            case 11:
                if (obj instanceof zzps) {
                    zzqjVar.zza((zzps) obj);
                    return;
                } else {
                    zzqjVar.zzcz((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzps) {
                    zzqjVar.zza((zzps) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzqjVar.a(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzqjVar.zzay(((Integer) obj).intValue());
                return;
            case 14:
                zzqjVar.zzba(((Integer) obj).intValue());
                return;
            case 15:
                zzqjVar.zzr(((Long) obj).longValue());
                return;
            case 16:
                zzqjVar.zzaz(((Integer) obj).intValue());
                return;
            case 17:
                zzqjVar.zzq(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzrf) {
                    zzqjVar.zzax(((zzrf) obj).zzc());
                    return;
                } else {
                    zzqjVar.zzax(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int g() {
        int i = 0;
        for (int i2 = 0; i2 < this.f4320a.c(); i2++) {
            i += c(this.f4320a.b(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f4320a.d().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzoy() == zzul.MESSAGE && !key.zzoz() && !key.zzpa()) {
            if (value instanceof zzrn) {
                return zzqj.zzb(entry.getKey().zzc(), (zzrn) value);
            }
            return zzqj.zzd(entry.getKey().zzc(), (zzsk) value);
        }
        return a((zzqv<?>) key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzug zzugVar, int i, Object obj) {
        int zzbb = zzqj.zzbb(i);
        if (zzugVar == zzug.zzbfy) {
            zzre.a((zzsk) obj);
            zzbb <<= 1;
        }
        return zzbb + b(zzugVar, obj);
    }

    private static int b(zzug zzugVar, Object obj) {
        switch (bt.b[zzugVar.ordinal()]) {
            case 1:
                return zzqj.zzc(((Double) obj).doubleValue());
            case 2:
                return zzqj.zzb(((Float) obj).floatValue());
            case 3:
                return zzqj.zzs(((Long) obj).longValue());
            case 4:
                return zzqj.zzt(((Long) obj).longValue());
            case 5:
                return zzqj.zzbc(((Integer) obj).intValue());
            case 6:
                return zzqj.zzv(((Long) obj).longValue());
            case 7:
                return zzqj.zzbf(((Integer) obj).intValue());
            case 8:
                return zzqj.zzj(((Boolean) obj).booleanValue());
            case 9:
                return zzqj.zzd((zzsk) obj);
            case 10:
                if (obj instanceof zzrn) {
                    return zzqj.zza((zzrn) obj);
                }
                return zzqj.zzc((zzsk) obj);
            case 11:
                if (obj instanceof zzps) {
                    return zzqj.zzb((zzps) obj);
                }
                return zzqj.zzda((String) obj);
            case 12:
                if (obj instanceof zzps) {
                    return zzqj.zzb((zzps) obj);
                }
                return zzqj.zzh((byte[]) obj);
            case 13:
                return zzqj.zzbd(((Integer) obj).intValue());
            case 14:
                return zzqj.zzbg(((Integer) obj).intValue());
            case 15:
                return zzqj.zzw(((Long) obj).longValue());
            case 16:
                return zzqj.zzbe(((Integer) obj).intValue());
            case 17:
                return zzqj.zzu(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzrf) {
                    return zzqj.zzbh(((zzrf) obj).zzc());
                }
                return zzqj.zzbh(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int a(zzqv<?> zzqvVar, Object obj) {
        zzug zzox = zzqvVar.zzox();
        int zzc = zzqvVar.zzc();
        if (zzqvVar.zzoz()) {
            int i = 0;
            if (zzqvVar.zzpa()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += b(zzox, it.next());
                }
                return zzqj.zzbb(zzc) + i + zzqj.zzbj(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(zzox, zzc, it2.next());
            }
            return i;
        }
        return a(zzox, zzc, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        bs bsVar = new bs();
        for (int i = 0; i < this.f4320a.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b = this.f4320a.b(i);
            bsVar.b((bs) b.getKey(), b.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f4320a.d()) {
            bsVar.b((bs) entry.getKey(), entry.getValue());
        }
        bsVar.c = this.c;
        return bsVar;
    }
}
