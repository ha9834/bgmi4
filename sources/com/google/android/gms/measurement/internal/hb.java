package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzey;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class hb extends gq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public hb(zzjg zzjgVar) {
        super(zzjgVar);
    }

    @Override // com.google.android.gms.measurement.internal.gq
    protected final boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0d00, code lost:
    
        if (r6.get(r0.getId()) == false) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x0d06, code lost:
    
        if (r0.zzkf() == false) goto L397;
     */
    /* JADX WARN: Code restructure failed: missing block: B:506:0x0d08, code lost:
    
        r6.set(r0.getId(), r19.booleanValue());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x07b5  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0a31  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0a3a  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0806  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x04d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.measurement.zzbs.zza> a(java.lang.String r65, java.util.List<com.google.android.gms.internal.measurement.zzbs.zzc> r66, java.util.List<com.google.android.gms.internal.measurement.zzbs.zzk> r67) {
        /*
            Method dump skipped, instructions count: 4476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.hb.a(java.lang.String, java.util.List, java.util.List):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Boolean a(zzbk.zza zzaVar, String str, List<zzbs.zze> list, long j) {
        Boolean a2;
        if (zzaVar.zzkd()) {
            Boolean a3 = a(j, zzaVar.zzke());
            if (a3 == null) {
                return null;
            }
            if (!a3.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzbk.zzb zzbVar : zzaVar.zzkc()) {
            if (zzbVar.zzkr().isEmpty()) {
                zzab().zzgn().zza("null or empty param name in filter. event", zzy().a(str));
                return null;
            }
            hashSet.add(zzbVar.zzkr());
        }
        androidx.b.a aVar = new androidx.b.a();
        for (zzbs.zze zzeVar : list) {
            if (hashSet.contains(zzeVar.getName())) {
                if (zzeVar.zzna()) {
                    aVar.put(zzeVar.getName(), zzeVar.zzna() ? Long.valueOf(zzeVar.zznb()) : null);
                } else if (zzeVar.zznd()) {
                    aVar.put(zzeVar.getName(), zzeVar.zznd() ? Double.valueOf(zzeVar.zzne()) : null);
                } else if (zzeVar.zzmx()) {
                    aVar.put(zzeVar.getName(), zzeVar.zzmy());
                } else {
                    zzab().zzgn().zza("Unknown value for param. event, param", zzy().a(str), zzy().b(zzeVar.getName()));
                    return null;
                }
            }
        }
        Iterator<zzbk.zzb> it = zzaVar.zzkc().iterator();
        while (true) {
            if (it.hasNext()) {
                zzbk.zzb next = it.next();
                boolean z = next.zzkp() && next.zzkq();
                String zzkr = next.zzkr();
                if (zzkr.isEmpty()) {
                    zzab().zzgn().zza("Event has empty param name. event", zzy().a(str));
                    return null;
                }
                V v = aVar.get(zzkr);
                if (v instanceof Long) {
                    if (!next.zzkn()) {
                        zzab().zzgn().zza("No number filter for long param. event, param", zzy().a(str), zzy().b(zzkr));
                        return null;
                    }
                    Boolean a4 = a(((Long) v).longValue(), next.zzko());
                    if (a4 == null) {
                        return null;
                    }
                    if (a4.booleanValue() == z) {
                        return false;
                    }
                } else if (v instanceof Double) {
                    if (!next.zzkn()) {
                        zzab().zzgn().zza("No number filter for double param. event, param", zzy().a(str), zzy().b(zzkr));
                        return null;
                    }
                    Boolean a5 = a(((Double) v).doubleValue(), next.zzko());
                    if (a5 == null) {
                        return null;
                    }
                    if (a5.booleanValue() == z) {
                        return false;
                    }
                } else {
                    if (!(v instanceof String)) {
                        if (v == 0) {
                            zzab().zzgs().zza("Missing param for filter. event, param", zzy().a(str), zzy().b(zzkr));
                            return false;
                        }
                        zzab().zzgn().zza("Unknown param type. event, param", zzy().a(str), zzy().b(zzkr));
                        return null;
                    }
                    if (next.zzkl()) {
                        a2 = a((String) v, next.zzkm());
                    } else if (next.zzkn()) {
                        String str2 = (String) v;
                        if (zzjo.a(str2)) {
                            a2 = a(str2, next.zzko());
                        } else {
                            zzab().zzgn().zza("Invalid param value for number filter. event, param", zzy().a(str), zzy().b(zzkr));
                            return null;
                        }
                    } else {
                        zzab().zzgn().zza("No filter for String param. event, param", zzy().a(str), zzy().b(zzkr));
                        return null;
                    }
                    if (a2 == null) {
                        return null;
                    }
                    if (a2.booleanValue() == z) {
                        return false;
                    }
                }
            } else {
                return true;
            }
        }
    }

    private final Boolean a(zzbk.zzd zzdVar, zzbs.zzk zzkVar) {
        zzbk.zzb zzli = zzdVar.zzli();
        boolean zzkq = zzli.zzkq();
        if (zzkVar.zzna()) {
            if (!zzli.zzkn()) {
                zzab().zzgn().zza("No number filter for long property. property", zzy().c(zzkVar.getName()));
                return null;
            }
            return a(a(zzkVar.zznb(), zzli.zzko()), zzkq);
        }
        if (zzkVar.zznd()) {
            if (!zzli.zzkn()) {
                zzab().zzgn().zza("No number filter for double property. property", zzy().c(zzkVar.getName()));
                return null;
            }
            return a(a(zzkVar.zzne(), zzli.zzko()), zzkq);
        }
        if (zzkVar.zzmx()) {
            if (!zzli.zzkl()) {
                if (!zzli.zzkn()) {
                    zzab().zzgn().zza("No string or number filter defined. property", zzy().c(zzkVar.getName()));
                } else {
                    if (zzjo.a(zzkVar.zzmy())) {
                        return a(a(zzkVar.zzmy(), zzli.zzko()), zzkq);
                    }
                    zzab().zzgn().zza("Invalid user property value for Numeric number filter. property, value", zzy().c(zzkVar.getName()), zzkVar.zzmy());
                }
                return null;
            }
            return a(a(zzkVar.zzmy(), zzli.zzkm()), zzkq);
        }
        zzab().zzgn().zza("User property has no value, property", zzy().c(zzkVar.getName()));
        return null;
    }

    @VisibleForTesting
    private static Boolean a(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    @VisibleForTesting
    private final Boolean a(String str, zzbk.zze zzeVar) {
        String zzln;
        List<String> unmodifiableList;
        Preconditions.checkNotNull(zzeVar);
        if (str == null || !zzeVar.zzlk() || zzeVar.zzll() == zzbk.zze.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzeVar.zzll() == zzbk.zze.zza.IN_LIST) {
            if (zzeVar.zzlr() == 0) {
                return null;
            }
        } else if (!zzeVar.zzlm()) {
            return null;
        }
        zzbk.zze.zza zzll = zzeVar.zzll();
        boolean zzlp = zzeVar.zzlp();
        if (zzlp || zzll == zzbk.zze.zza.REGEXP || zzll == zzbk.zze.zza.IN_LIST) {
            zzln = zzeVar.zzln();
        } else {
            zzln = zzeVar.zzln().toUpperCase(Locale.ENGLISH);
        }
        if (zzeVar.zzlr() == 0) {
            unmodifiableList = null;
        } else {
            List<String> zzlq = zzeVar.zzlq();
            if (zzlp) {
                unmodifiableList = zzlq;
            } else {
                ArrayList arrayList = new ArrayList(zzlq.size());
                Iterator<String> it = zzlq.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            }
        }
        return a(str, zzll, zzlp, zzln, unmodifiableList, zzll == zzbk.zze.zza.REGEXP ? zzln : null);
    }

    private final Boolean a(String str, zzbk.zze.zza zzaVar, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (zzaVar == zzbk.zze.zza.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzaVar != zzbk.zze.zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (ha.f4901a[zzaVar.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzab().zzgn().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean a(long j, zzbk.zzc zzcVar) {
        try {
            return a(new BigDecimal(j), zzcVar, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean a(double d, zzbk.zzc zzcVar) {
        try {
            return a(new BigDecimal(d), zzcVar, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean a(String str, zzbk.zzc zzcVar) {
        if (!zzjo.a(str)) {
            return null;
        }
        try {
            return a(new BigDecimal(str), zzcVar, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0086, code lost:
    
        if (r2 != null) goto L39;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Boolean a(java.math.BigDecimal r7, com.google.android.gms.internal.measurement.zzbk.zzc r8, double r9) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.hb.a(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzbk$zzc, double):java.lang.Boolean");
    }

    private static List<zzbs.zzb> a(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            arrayList.add((zzbs.zzb) ((zzey) zzbs.zzb.zzmh().zzk(intValue).zzae(map.get(Integer.valueOf(intValue)).longValue()).zzug()));
        }
        return arrayList;
    }

    private static void a(Map<Integer, Long> map, int i, long j) {
        Long l = map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    private static void b(Map<Integer, List<Long>> map, int i, long j) {
        List<Long> list = map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
            map.put(Integer.valueOf(i), list);
        }
        list.add(Long.valueOf(j / 1000));
    }
}
