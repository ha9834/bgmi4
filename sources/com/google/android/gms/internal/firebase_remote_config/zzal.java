package com.google.android.gms.internal.firebase_remote_config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzal {

    /* renamed from: a, reason: collision with root package name */
    static final Map<Character, zzak> f4122a = new HashMap();

    private static Map<String, Object> a(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : zzbt.zzf(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !zzbt.isNull(value)) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    public static String zza(String str, String str2, Object obj, boolean z) {
        String str3;
        Object a2;
        String str4;
        String str5;
        if (str2.startsWith("/")) {
            zzt zztVar = new zzt(str);
            zztVar.zzl(null);
            String valueOf = String.valueOf(zztVar.zzp());
            String valueOf2 = String.valueOf(str2);
            str3 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else if (str2.startsWith("http://") || str2.startsWith("https://")) {
            str3 = str2;
        } else {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf(str2);
            str3 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
        Map<String, Object> a3 = a(obj);
        StringBuilder sb = new StringBuilder();
        int length = str3.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int indexOf = str3.indexOf(123, i);
            if (indexOf == -1) {
                sb.append(str3.substring(i));
                break;
            }
            sb.append(str3.substring(i, indexOf));
            int indexOf2 = str3.indexOf(125, indexOf + 2);
            int i2 = indexOf2 + 1;
            String substring = str3.substring(indexOf + 1, indexOf2);
            zzak zzakVar = f4122a.get(Character.valueOf(substring.charAt(0)));
            if (zzakVar == null) {
                zzakVar = zzak.SIMPLE;
            }
            ListIterator<String> listIterator = zzds.zza(zzdj.zza(',')).zza(substring).listIterator();
            boolean z2 = true;
            while (listIterator.hasNext()) {
                String next = listIterator.next();
                boolean endsWith = next.endsWith("*");
                int d = listIterator.nextIndex() == 1 ? zzakVar.d() : 0;
                int length2 = next.length();
                if (endsWith) {
                    length2--;
                }
                String substring2 = next.substring(d, length2);
                Object remove = a3.remove(substring2);
                if (remove != null) {
                    if (!z2) {
                        sb.append(zzakVar.b());
                    } else {
                        sb.append(zzakVar.a());
                        z2 = false;
                    }
                    if (remove instanceof Iterator) {
                        a2 = a(substring2, (Iterator) remove, endsWith, zzakVar);
                    } else if ((remove instanceof Iterable) || remove.getClass().isArray()) {
                        a2 = a(substring2, zzco.zzi(remove).iterator(), endsWith, zzakVar);
                    } else if (remove.getClass().isEnum()) {
                        if (zzbz.zza((Enum<?>) remove).getName() != null) {
                            if (zzakVar.c()) {
                                remove = String.format("%s=%s", substring2, remove);
                            }
                            a2 = zzcs.zzaj(remove.toString());
                        } else {
                            a2 = remove;
                        }
                    } else if (!zzbt.zzg(remove)) {
                        Map<String, Object> a4 = a(remove);
                        if (a4.isEmpty()) {
                            a2 = "";
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            if (endsWith) {
                                str4 = zzakVar.b();
                                str5 = "=";
                            } else {
                                if (zzakVar.c()) {
                                    sb2.append(zzcs.zzaj(substring2));
                                    sb2.append("=");
                                }
                                str4 = ",";
                                str5 = ",";
                            }
                            Iterator<Map.Entry<String, Object>> it = a4.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry<String, Object> next2 = it.next();
                                String a5 = zzakVar.a(next2.getKey());
                                String a6 = zzakVar.a(next2.getValue().toString());
                                sb2.append(a5);
                                sb2.append(str5);
                                sb2.append(a6);
                                if (it.hasNext()) {
                                    sb2.append(str4);
                                }
                            }
                            a2 = sb2.toString();
                        }
                    } else {
                        if (zzakVar.c()) {
                            remove = String.format("%s=%s", substring2, remove);
                        }
                        if (zzakVar.e()) {
                            a2 = zzcs.zzak(remove.toString());
                        } else {
                            a2 = zzcs.zzaj(remove.toString());
                        }
                    }
                    sb.append(a2);
                }
            }
            i = i2;
        }
        zzt.a(a3.entrySet(), sb);
        return sb.toString();
    }

    private static String a(String str, Iterator<?> it, boolean z, zzak zzakVar) {
        String str2;
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            str2 = zzakVar.b();
        } else {
            str2 = ",";
            if (zzakVar.c()) {
                sb.append(zzcs.zzaj(str));
                sb.append("=");
            }
        }
        while (it.hasNext()) {
            if (z && zzakVar.c()) {
                sb.append(zzcs.zzaj(str));
                sb.append("=");
            }
            sb.append(zzakVar.a(it.next().toString()));
            if (it.hasNext()) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    static {
        zzak.values();
    }
}
