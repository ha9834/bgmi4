package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class zzbz {
    private static HashMap<String, String> c;
    private static Object h;
    private static boolean i;
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f4541a = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzzw = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzzx = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean b = new AtomicBoolean();
    private static final HashMap<String, Boolean> d = new HashMap<>();
    private static final HashMap<String, Integer> e = new HashMap<>();
    private static final HashMap<String, Long> f = new HashMap<>();
    private static final HashMap<String, Float> g = new HashMap<>();
    private static String[] j = new String[0];

    private static void a(ContentResolver contentResolver) {
        if (c == null) {
            b.set(false);
            c = new HashMap<>();
            h = new Object();
            i = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new as(null));
            return;
        }
        if (b.getAndSet(false)) {
            c.clear();
            d.clear();
            e.clear();
            f.clear();
            g.clear();
            h = new Object();
            i = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzbz.class) {
            a(contentResolver);
            Object obj = h;
            if (c.containsKey(str)) {
                String str3 = c.get(str);
                if (str3 == null) {
                    str3 = null;
                }
                return str3;
            }
            for (String str4 : j) {
                if (str.startsWith(str4)) {
                    if (!i || c.isEmpty()) {
                        c.putAll(a(contentResolver, j));
                        i = true;
                        if (c.containsKey(str)) {
                            String str5 = c.get(str);
                            if (str5 == null) {
                                str5 = null;
                            }
                            return str5;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
            if (query == null) {
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    a(obj, str, null);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                String string = query.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                a(obj, str, string);
                if (string == null) {
                    string = null;
                }
                if (query != null) {
                    query.close();
                }
                return string;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
    }

    private static void a(Object obj, String str, String str2) {
        synchronized (zzbz.class) {
            if (obj == h) {
                c.put(str, str2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Map<String, String> a(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f4541a, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}
