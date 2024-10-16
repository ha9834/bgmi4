package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class da {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(zzgi zzgiVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(zzgiVar, sb, 0);
        return sb.toString();
    }

    private static void a(zzgi zzgiVar, StringBuilder sb, int i) {
        boolean booleanValue;
        boolean z;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzgiVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals("List")) {
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb, i, a(concat), zzey.a(method2, zzgiVar, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                String valueOf3 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb, i, a(concat2), zzey.a(method3, zzgiVar, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (!hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(replaceFirst.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(replaceFirst);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(replaceFirst);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? "has".concat(valueOf10) : new String("has"));
                if (method4 != null) {
                    Object a2 = zzey.a(method4, zzgiVar, new Object[0]);
                    if (method5 == null) {
                        if (a2 instanceof Boolean) {
                            z = !((Boolean) a2).booleanValue();
                        } else if (a2 instanceof Integer) {
                            z = ((Integer) a2).intValue() == 0;
                        } else if (a2 instanceof Float) {
                            z = ((Float) a2).floatValue() == 0.0f;
                        } else if (a2 instanceof Double) {
                            z = ((Double) a2).doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        } else if (a2 instanceof String) {
                            z = a2.equals("");
                        } else if (a2 instanceof zzdp) {
                            z = a2.equals(zzdp.zzadh);
                        } else if (a2 instanceof zzgi) {
                            z = a2 == ((zzgi) a2).zzuh();
                        } else if (a2 instanceof Enum) {
                            z = ((Enum) a2).ordinal() == 0;
                        } else {
                            z = false;
                        }
                        booleanValue = !z;
                    } else {
                        booleanValue = ((Boolean) zzey.a(method5, zzgiVar, new Object[0])).booleanValue();
                    }
                    if (booleanValue) {
                        a(sb, i, a(concat3), a2);
                    }
                }
            }
        }
        if (zzgiVar instanceof zzey.zzb) {
            Iterator<Map.Entry<Object, Object>> d = ((zzey.zzb) zzgiVar).zzaic.d();
            if (d.hasNext()) {
                d.next().getKey();
                throw new NoSuchMethodError();
            }
        }
        zzey zzeyVar = (zzey) zzgiVar;
        if (zzeyVar.zzahz != null) {
            zzeyVar.zzahz.a(sb, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(dz.a(zzdp.zzdq((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdp) {
            sb.append(": \"");
            sb.append(dz.a((zzdp) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzey) {
            sb.append(" {");
            a((zzey) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i4 = i + 2;
            a(sb, i4, "key", entry.getKey());
            a(sb, i4, "value", entry.getValue());
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj.toString());
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
