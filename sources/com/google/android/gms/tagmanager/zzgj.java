package com.google.android.gms.tagmanager;

import com.amazonaws.services.s3.internal.Constants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.uqm.crashsight.CrashSight;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzgj {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f5172a = null;
    private static Long b = new Long(0);
    private static Double c = new Double(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static zzgi d = zzgi.a(0);
    private static String e = new String("");
    private static Boolean f = new Boolean(false);
    private static List<Object> g = new ArrayList(0);
    private static Map<Object, Object> h = new HashMap();
    private static zzl i = zzi(e);

    public static Object zzjw() {
        return null;
    }

    public static Long zzjx() {
        return b;
    }

    public static Double zzjy() {
        return c;
    }

    public static Boolean zzjz() {
        return f;
    }

    public static zzgi zzka() {
        return d;
    }

    public static String zzkb() {
        return e;
    }

    public static zzl zzkc() {
        return i;
    }

    private static String a(Object obj) {
        return obj == null ? e : obj.toString();
    }

    public static String zzc(zzl zzlVar) {
        return a(zzh(zzlVar));
    }

    public static zzgi zzd(zzl zzlVar) {
        Object zzh = zzh(zzlVar);
        if (zzh instanceof zzgi) {
            return (zzgi) zzh;
        }
        if (d(zzh)) {
            return zzgi.a(e(zzh));
        }
        if (b(zzh)) {
            return zzgi.a(Double.valueOf(c(zzh)));
        }
        return a(a(zzh));
    }

    public static Long zze(zzl zzlVar) {
        Object zzh = zzh(zzlVar);
        if (d(zzh)) {
            return Long.valueOf(e(zzh));
        }
        zzgi a2 = a(a(zzh));
        return a2 == d ? b : Long.valueOf(a2.longValue());
    }

    public static Double zzf(zzl zzlVar) {
        Object zzh = zzh(zzlVar);
        if (b(zzh)) {
            return Double.valueOf(c(zzh));
        }
        zzgi a2 = a(a(zzh));
        return a2 == d ? c : Double.valueOf(a2.doubleValue());
    }

    public static Boolean zzg(zzl zzlVar) {
        Object zzh = zzh(zzlVar);
        if (zzh instanceof Boolean) {
            return (Boolean) zzh;
        }
        String a2 = a(zzh);
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(a2)) {
            return Boolean.TRUE;
        }
        if (CrashSight.SDK_IS_DEV.equalsIgnoreCase(a2)) {
            return Boolean.FALSE;
        }
        return f;
    }

    public static zzl zzi(Object obj) {
        zzl zzlVar = new zzl();
        if (obj instanceof zzl) {
            return (zzl) obj;
        }
        boolean z = false;
        if (obj instanceof String) {
            zzlVar.type = 1;
            zzlVar.string = (String) obj;
        } else if (obj instanceof List) {
            zzlVar.type = 2;
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                zzl zzi = zzi(it.next());
                zzl zzlVar2 = i;
                if (zzi == zzlVar2) {
                    return zzlVar2;
                }
                z2 = z2 || zzi.zzqw;
                arrayList.add(zzi);
            }
            zzlVar.zzqn = (zzl[]) arrayList.toArray(new zzl[0]);
            z = z2;
        } else if (obj instanceof Map) {
            zzlVar.type = 3;
            Set<Map.Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z3 = false;
            for (Map.Entry entry : entrySet) {
                zzl zzi2 = zzi(entry.getKey());
                zzl zzi3 = zzi(entry.getValue());
                zzl zzlVar3 = i;
                if (zzi2 == zzlVar3 || zzi3 == zzlVar3) {
                    return i;
                }
                z3 = z3 || zzi2.zzqw || zzi3.zzqw;
                arrayList2.add(zzi2);
                arrayList3.add(zzi3);
            }
            zzlVar.zzqo = (zzl[]) arrayList2.toArray(new zzl[0]);
            zzlVar.zzqp = (zzl[]) arrayList3.toArray(new zzl[0]);
            z = z3;
        } else if (b(obj)) {
            zzlVar.type = 1;
            zzlVar.string = obj.toString();
        } else if (d(obj)) {
            zzlVar.type = 6;
            zzlVar.zzqs = e(obj);
        } else if (obj instanceof Boolean) {
            zzlVar.type = 8;
            zzlVar.zzqt = ((Boolean) obj).booleanValue();
        } else {
            String valueOf = String.valueOf(obj == null ? Constants.NULL_VERSION_ID : obj.getClass().toString());
            zzdi.zzav(valueOf.length() != 0 ? "Converting to Value from unknown object type: ".concat(valueOf) : new String("Converting to Value from unknown object type: "));
            return i;
        }
        zzlVar.zzqw = z;
        return zzlVar;
    }

    public static zzl zzbp(String str) {
        zzl zzlVar = new zzl();
        zzlVar.type = 5;
        zzlVar.zzqr = str;
        return zzlVar;
    }

    private static boolean b(Object obj) {
        if ((obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        return (obj instanceof zzgi) && ((zzgi) obj).a();
    }

    private static double c(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzdi.zzav("getDouble received non-Number");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    private static boolean d(Object obj) {
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
            return true;
        }
        return (obj instanceof zzgi) && ((zzgi) obj).b();
    }

    private static long e(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzdi.zzav("getInt64 received non-Number");
        return 0L;
    }

    private static zzgi a(String str) {
        try {
            return zzgi.a(str);
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
            sb.append("Failed to convert '");
            sb.append(str);
            sb.append("' to a number.");
            zzdi.zzav(sb.toString());
            return d;
        }
    }

    public static Object zzh(zzl zzlVar) {
        if (zzlVar == null) {
            return null;
        }
        int i2 = 0;
        switch (zzlVar.type) {
            case 1:
                return zzlVar.string;
            case 2:
                ArrayList arrayList = new ArrayList(zzlVar.zzqn.length);
                zzl[] zzlVarArr = zzlVar.zzqn;
                int length = zzlVarArr.length;
                while (i2 < length) {
                    Object zzh = zzh(zzlVarArr[i2]);
                    if (zzh == null) {
                        return null;
                    }
                    arrayList.add(zzh);
                    i2++;
                }
                return arrayList;
            case 3:
                if (zzlVar.zzqo.length != zzlVar.zzqp.length) {
                    String valueOf = String.valueOf(zzlVar.toString());
                    zzdi.zzav(valueOf.length() != 0 ? "Converting an invalid value to object: ".concat(valueOf) : new String("Converting an invalid value to object: "));
                    return null;
                }
                HashMap hashMap = new HashMap(zzlVar.zzqp.length);
                while (i2 < zzlVar.zzqo.length) {
                    Object zzh2 = zzh(zzlVar.zzqo[i2]);
                    Object zzh3 = zzh(zzlVar.zzqp[i2]);
                    if (zzh2 == null || zzh3 == null) {
                        return null;
                    }
                    hashMap.put(zzh2, zzh3);
                    i2++;
                }
                return hashMap;
            case 4:
                zzdi.zzav("Trying to convert a macro reference to object");
                return null;
            case 5:
                zzdi.zzav("Trying to convert a function id to object");
                return null;
            case 6:
                return Long.valueOf(zzlVar.zzqs);
            case 7:
                StringBuilder sb = new StringBuilder();
                zzl[] zzlVarArr2 = zzlVar.zzqu;
                int length2 = zzlVarArr2.length;
                while (i2 < length2) {
                    String a2 = a(zzh(zzlVarArr2[i2]));
                    if (a2 == e) {
                        return null;
                    }
                    sb.append(a2);
                    i2++;
                }
                return sb.toString();
            case 8:
                return Boolean.valueOf(zzlVar.zzqt);
            default:
                int i3 = zzlVar.type;
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed to convert a value of type: ");
                sb2.append(i3);
                zzdi.zzav(sb2.toString());
                return null;
        }
    }
}
