package com.google.android.gms.internal.firebase_remote_config;

import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zzes {
    private final zzeh c;
    private final zzeh d;
    public static final Charset zzlf = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    static final Pattern f4163a = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    static final Pattern b = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    public zzes(zzeh zzehVar, zzeh zzehVar2) {
        this.c = zzehVar;
        this.d = zzehVar2;
    }

    public final String getString(String str) {
        String a2 = a(this.c, str, "String");
        if (a2 != null) {
            return a2;
        }
        String a3 = a(this.d, str, "String");
        return a3 != null ? a3 : "";
    }

    public final boolean getBoolean(String str) {
        String a2 = a(this.c, str, "Boolean");
        if (a2 != null) {
            if (f4163a.matcher(a2).matches()) {
                return true;
            }
            if (b.matcher(a2).matches()) {
                return false;
            }
        }
        String a3 = a(this.d, str, "Boolean");
        if (a3 != null) {
            if (f4163a.matcher(a3).matches()) {
                return true;
            }
            if (b.matcher(a3).matches()) {
                return false;
            }
        }
        return false;
    }

    public final byte[] getByteArray(String str) {
        String a2 = a(this.c, str, "ByteArray");
        if (a2 != null) {
            return a2.getBytes(zzlf);
        }
        String a3 = a(this.d, str, "ByteArray");
        if (a3 != null) {
            return a3.getBytes(zzlf);
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
    }

    public final double getDouble(String str) {
        Double a2 = a(this.c, str);
        if (a2 != null) {
            return a2.doubleValue();
        }
        Double a3 = a(this.d, str);
        return a3 != null ? a3.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final long getLong(String str) {
        Long b2 = b(this.c, str);
        if (b2 != null) {
            return b2.longValue();
        }
        Long b3 = b(this.d, str);
        if (b3 != null) {
            return b3.longValue();
        }
        return 0L;
    }

    public final FirebaseRemoteConfigValue getValue(String str) {
        String a2 = a(this.c, str, "FirebaseRemoteConfigValue");
        if (a2 != null) {
            return new zzfa(a2, 2);
        }
        String a3 = a(this.d, str, "FirebaseRemoteConfigValue");
        if (a3 != null) {
            return new zzfa(a3, 1);
        }
        return new zzfa("", 0);
    }

    public final Set<String> getKeysByPrefix(String str) {
        if (str == null) {
            str = "";
        }
        TreeSet treeSet = new TreeSet();
        zzep a2 = this.c.a(5L);
        if (a2 != null) {
            treeSet.addAll(a(str, a2));
        }
        zzep a3 = this.d.a(5L);
        if (a3 != null) {
            treeSet.addAll(a(str, a3));
        }
        return treeSet;
    }

    private static TreeSet<String> a(String str, zzep zzepVar) {
        TreeSet<String> treeSet = new TreeSet<>();
        Iterator<String> keys = zzepVar.zzcq().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith(str)) {
                treeSet.add(next);
            }
        }
        return treeSet;
    }

    public final Map<String, FirebaseRemoteConfigValue> getAll() {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(a(this.c));
        hashSet.addAll(a(this.d));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            hashMap.put(str, getValue(str));
        }
        return hashMap;
    }

    private static String a(zzeh zzehVar, String str, String str2) {
        zzep a2 = zzehVar.a(5L);
        if (a2 == null) {
            return null;
        }
        try {
            return a2.zzcq().getString(str);
        } catch (JSONException unused) {
            a(str, str2);
            return null;
        }
    }

    private static Double a(zzeh zzehVar, String str) {
        zzep a2 = zzehVar.a(5L);
        if (a2 == null) {
            return null;
        }
        try {
            return Double.valueOf(a2.zzcq().getDouble(str));
        } catch (JSONException unused) {
            a(str, "Double");
            return null;
        }
    }

    private static Long b(zzeh zzehVar, String str) {
        zzep a2 = zzehVar.a(5L);
        if (a2 == null) {
            return null;
        }
        try {
            return Long.valueOf(a2.zzcq().getLong(str));
        } catch (JSONException unused) {
            a(str, "Long");
            return null;
        }
    }

    private static Set<String> a(zzeh zzehVar) {
        HashSet hashSet = new HashSet();
        zzep a2 = zzehVar.a(5L);
        if (a2 == null) {
            return hashSet;
        }
        Iterator<String> keys = a2.zzcq().keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    private static void a(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }
}
