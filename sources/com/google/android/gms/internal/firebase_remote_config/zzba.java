package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzbc;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public abstract class zzba {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap<Class<?>, Field> f4128a = new WeakHashMap<>();
    private static final Lock b = new ReentrantLock();

    public abstract void close() throws IOException;

    public abstract int getIntValue() throws IOException;

    public abstract String getText() throws IOException;

    public abstract zzaw zzay();

    public abstract zzbg zzaz() throws IOException;

    public abstract zzbg zzba();

    public abstract String zzbb() throws IOException;

    public abstract zzba zzbc() throws IOException;

    public abstract byte zzbd() throws IOException;

    public abstract short zzbe() throws IOException;

    public abstract float zzbf() throws IOException;

    public abstract long zzbg() throws IOException;

    public abstract double zzbh() throws IOException;

    public abstract BigInteger zzbi() throws IOException;

    public abstract BigDecimal zzbj() throws IOException;

    public final <T> T zza(Class<T> cls, zzau zzauVar) throws IOException {
        try {
            return (T) zza(cls, false, null);
        } finally {
            close();
        }
    }

    public final String zza(Set<String> set) throws IOException {
        zzbg b2 = b();
        while (b2 == zzbg.FIELD_NAME) {
            String text = getText();
            zzaz();
            if (set.contains(text)) {
                return text;
            }
            zzbc();
            b2 = zzaz();
        }
        return null;
    }

    private final zzbg a() throws IOException {
        zzbg zzba = zzba();
        if (zzba == null) {
            zzba = zzaz();
        }
        if (zzba != null) {
            return zzba;
        }
        throw new IllegalArgumentException(String.valueOf("no JSON input found"));
    }

    private final zzbg b() throws IOException {
        zzbg a2 = a();
        switch (d.f4071a[a2.ordinal()]) {
            case 1:
                zzbg zzaz = zzaz();
                if (zzaz == zzbg.FIELD_NAME || zzaz == zzbg.END_OBJECT) {
                    return zzaz;
                }
                throw new IllegalArgumentException(String.valueOf(zzaz));
            case 2:
                return zzaz();
            default:
                return a2;
        }
    }

    public final Object zza(Type type, boolean z, zzau zzauVar) throws IOException {
        try {
            if (!Void.class.equals(type)) {
                a();
            }
            return a(null, type, new ArrayList<>(), null, null, true);
        } finally {
            if (z) {
                close();
            }
        }
    }

    private final void a(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, zzau zzauVar) throws IOException {
        zzbg b2 = b();
        while (b2 == zzbg.FIELD_NAME) {
            String text = getText();
            zzaz();
            if (zzauVar != null) {
                throw new NoSuchMethodError();
            }
            map.put(text, a(field, type, arrayList, map, zzauVar, true));
            b2 = zzaz();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:197:0x0295, code lost:
    
        if (com.google.android.gms.internal.firebase_remote_config.zzco.zza(r1, (java.lang.Class<?>) java.util.Map.class) == false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0297, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d9 A[Catch: IllegalArgumentException -> 0x046c, TryCatch #0 {IllegalArgumentException -> 0x046c, blocks: (B:14:0x002b, B:15:0x0039, B:16:0x003c, B:17:0x0449, B:18:0x046b, B:20:0x0042, B:25:0x004f, B:27:0x0057, B:29:0x005f, B:31:0x006c, B:33:0x0074, B:35:0x0081, B:37:0x008a, B:38:0x0093, B:40:0x0094, B:44:0x00aa, B:49:0x00cc, B:52:0x00d6, B:57:0x00ee, B:59:0x00e4, B:60:0x00ed, B:62:0x00b2, B:64:0x00ba, B:66:0x00c2, B:69:0x00f9, B:74:0x0108, B:79:0x0116, B:83:0x011f, B:88:0x0129, B:93:0x0133, B:98:0x013c, B:103:0x0145, B:108:0x014e, B:111:0x0153, B:112:0x0177, B:113:0x0178, B:115:0x0181, B:117:0x018a, B:119:0x0193, B:121:0x019c, B:123:0x01a5, B:125:0x01ae, B:127:0x01b3, B:128:0x01bc, B:131:0x01bf, B:134:0x01c5, B:138:0x01d1, B:140:0x01d9, B:142:0x01dd, B:144:0x01e0, B:146:0x01e3, B:147:0x01ec, B:149:0x01ed, B:153:0x01f7, B:157:0x0203, B:162:0x0210, B:163:0x0215, B:164:0x0216, B:166:0x021c, B:167:0x022f, B:168:0x0237, B:170:0x023b, B:173:0x0254, B:177:0x0223, B:179:0x022b, B:180:0x025e, B:181:0x0267, B:183:0x0268, B:186:0x0271, B:189:0x027b, B:193:0x0287, B:194:0x028c, B:196:0x028f, B:200:0x029c, B:201:0x02b3, B:203:0x02b9, B:205:0x02be, B:207:0x02c6, B:209:0x02ce, B:211:0x02d7, B:214:0x02e6, B:216:0x02ea, B:217:0x02f4, B:219:0x0308, B:221:0x0310, B:223:0x03b0, B:226:0x03b6, B:231:0x03ca, B:233:0x03de, B:237:0x03ea, B:240:0x03f8, B:242:0x0404, B:244:0x0410, B:246:0x042b, B:247:0x0434, B:248:0x0409, B:235:0x03f0, B:252:0x0435, B:253:0x043e, B:256:0x0325, B:258:0x0329, B:260:0x0332, B:262:0x0338, B:264:0x033e, B:268:0x0345, B:269:0x034c, B:270:0x034d, B:272:0x0399, B:275:0x037e, B:278:0x0396, B:281:0x03a2, B:282:0x03a7, B:284:0x03a8, B:285:0x03ad, B:290:0x02a8, B:291:0x02ae, B:294:0x043f, B:295:0x0448), top: B:13:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e3 A[Catch: IllegalArgumentException -> 0x046c, TryCatch #0 {IllegalArgumentException -> 0x046c, blocks: (B:14:0x002b, B:15:0x0039, B:16:0x003c, B:17:0x0449, B:18:0x046b, B:20:0x0042, B:25:0x004f, B:27:0x0057, B:29:0x005f, B:31:0x006c, B:33:0x0074, B:35:0x0081, B:37:0x008a, B:38:0x0093, B:40:0x0094, B:44:0x00aa, B:49:0x00cc, B:52:0x00d6, B:57:0x00ee, B:59:0x00e4, B:60:0x00ed, B:62:0x00b2, B:64:0x00ba, B:66:0x00c2, B:69:0x00f9, B:74:0x0108, B:79:0x0116, B:83:0x011f, B:88:0x0129, B:93:0x0133, B:98:0x013c, B:103:0x0145, B:108:0x014e, B:111:0x0153, B:112:0x0177, B:113:0x0178, B:115:0x0181, B:117:0x018a, B:119:0x0193, B:121:0x019c, B:123:0x01a5, B:125:0x01ae, B:127:0x01b3, B:128:0x01bc, B:131:0x01bf, B:134:0x01c5, B:138:0x01d1, B:140:0x01d9, B:142:0x01dd, B:144:0x01e0, B:146:0x01e3, B:147:0x01ec, B:149:0x01ed, B:153:0x01f7, B:157:0x0203, B:162:0x0210, B:163:0x0215, B:164:0x0216, B:166:0x021c, B:167:0x022f, B:168:0x0237, B:170:0x023b, B:173:0x0254, B:177:0x0223, B:179:0x022b, B:180:0x025e, B:181:0x0267, B:183:0x0268, B:186:0x0271, B:189:0x027b, B:193:0x0287, B:194:0x028c, B:196:0x028f, B:200:0x029c, B:201:0x02b3, B:203:0x02b9, B:205:0x02be, B:207:0x02c6, B:209:0x02ce, B:211:0x02d7, B:214:0x02e6, B:216:0x02ea, B:217:0x02f4, B:219:0x0308, B:221:0x0310, B:223:0x03b0, B:226:0x03b6, B:231:0x03ca, B:233:0x03de, B:237:0x03ea, B:240:0x03f8, B:242:0x0404, B:244:0x0410, B:246:0x042b, B:247:0x0434, B:248:0x0409, B:235:0x03f0, B:252:0x0435, B:253:0x043e, B:256:0x0325, B:258:0x0329, B:260:0x0332, B:262:0x0338, B:264:0x033e, B:268:0x0345, B:269:0x034c, B:270:0x034d, B:272:0x0399, B:275:0x037e, B:278:0x0396, B:281:0x03a2, B:282:0x03a7, B:284:0x03a8, B:285:0x03ad, B:290:0x02a8, B:291:0x02ae, B:294:0x043f, B:295:0x0448), top: B:13:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x025e A[Catch: IllegalArgumentException -> 0x046c, TryCatch #0 {IllegalArgumentException -> 0x046c, blocks: (B:14:0x002b, B:15:0x0039, B:16:0x003c, B:17:0x0449, B:18:0x046b, B:20:0x0042, B:25:0x004f, B:27:0x0057, B:29:0x005f, B:31:0x006c, B:33:0x0074, B:35:0x0081, B:37:0x008a, B:38:0x0093, B:40:0x0094, B:44:0x00aa, B:49:0x00cc, B:52:0x00d6, B:57:0x00ee, B:59:0x00e4, B:60:0x00ed, B:62:0x00b2, B:64:0x00ba, B:66:0x00c2, B:69:0x00f9, B:74:0x0108, B:79:0x0116, B:83:0x011f, B:88:0x0129, B:93:0x0133, B:98:0x013c, B:103:0x0145, B:108:0x014e, B:111:0x0153, B:112:0x0177, B:113:0x0178, B:115:0x0181, B:117:0x018a, B:119:0x0193, B:121:0x019c, B:123:0x01a5, B:125:0x01ae, B:127:0x01b3, B:128:0x01bc, B:131:0x01bf, B:134:0x01c5, B:138:0x01d1, B:140:0x01d9, B:142:0x01dd, B:144:0x01e0, B:146:0x01e3, B:147:0x01ec, B:149:0x01ed, B:153:0x01f7, B:157:0x0203, B:162:0x0210, B:163:0x0215, B:164:0x0216, B:166:0x021c, B:167:0x022f, B:168:0x0237, B:170:0x023b, B:173:0x0254, B:177:0x0223, B:179:0x022b, B:180:0x025e, B:181:0x0267, B:183:0x0268, B:186:0x0271, B:189:0x027b, B:193:0x0287, B:194:0x028c, B:196:0x028f, B:200:0x029c, B:201:0x02b3, B:203:0x02b9, B:205:0x02be, B:207:0x02c6, B:209:0x02ce, B:211:0x02d7, B:214:0x02e6, B:216:0x02ea, B:217:0x02f4, B:219:0x0308, B:221:0x0310, B:223:0x03b0, B:226:0x03b6, B:231:0x03ca, B:233:0x03de, B:237:0x03ea, B:240:0x03f8, B:242:0x0404, B:244:0x0410, B:246:0x042b, B:247:0x0434, B:248:0x0409, B:235:0x03f0, B:252:0x0435, B:253:0x043e, B:256:0x0325, B:258:0x0329, B:260:0x0332, B:262:0x0338, B:264:0x033e, B:268:0x0345, B:269:0x034c, B:270:0x034d, B:272:0x0399, B:275:0x037e, B:278:0x0396, B:281:0x03a2, B:282:0x03a7, B:284:0x03a8, B:285:0x03ad, B:290:0x02a8, B:291:0x02ae, B:294:0x043f, B:295:0x0448), top: B:13:0x002b }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object a(java.lang.reflect.Field r20, java.lang.reflect.Type r21, java.util.ArrayList<java.lang.reflect.Type> r22, java.lang.Object r23, com.google.android.gms.internal.firebase_remote_config.zzau r24, boolean r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzba.a(java.lang.reflect.Field, java.lang.reflect.Type, java.util.ArrayList, java.lang.Object, com.google.android.gms.internal.firebase_remote_config.zzau, boolean):java.lang.Object");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Field a(Class<?> cls) {
        Field field = null;
        if (cls == null) {
            return null;
        }
        b.lock();
        try {
            if (f4128a.containsKey(cls)) {
                return f4128a.get(cls);
            }
            Iterator<zzbz> it = zzbr.zzc(cls).zzbw().iterator();
            while (it.hasNext()) {
                Field zzbz = it.next().zzbz();
                zzbc zzbcVar = (zzbc) zzbz.getAnnotation(zzbc.class);
                if (zzbcVar != null) {
                    Object[] objArr = {cls};
                    if (!(field == null)) {
                        throw new IllegalArgumentException(zzdy.zza("Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", objArr));
                    }
                    boolean zza = zzbt.zza(zzbz.getType());
                    Object[] objArr2 = {cls, zzbz.getType()};
                    if (!zza) {
                        throw new IllegalArgumentException(zzdy.zza("Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", objArr2));
                    }
                    zzbc.zza[] zzbn = zzbcVar.zzbn();
                    HashSet hashSet = new HashSet();
                    if (!(zzbn.length > 0)) {
                        throw new IllegalArgumentException(String.valueOf("@JsonPolymorphicTypeMap must have at least one @TypeDef"));
                    }
                    for (zzbc.zza zzaVar : zzbn) {
                        boolean add = hashSet.add(zzaVar.zzbo());
                        Object[] objArr3 = {zzaVar.zzbo()};
                        if (!add) {
                            throw new IllegalArgumentException(zzdy.zza("Class contains two @TypeDef annotations with identical key: %s", objArr3));
                        }
                    }
                    field = zzbz;
                }
            }
            f4128a.put(cls, field);
            return field;
        } finally {
            b.unlock();
        }
    }
}
