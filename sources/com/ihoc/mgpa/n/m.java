package com.ihoc.mgpa.n;

import android.util.Log;
import com.ihoc.mgpa.n.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5676a;
    private static boolean b;
    private static boolean c;
    private static FileOutputStream d;
    private static a e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);
    }

    public static void a() {
        String f = com.ihoc.mgpa.n.a.f();
        String str = f + File.separator + "vmpdebug.log";
        for (int i = 5; i > 0; i--) {
            String str2 = i == 1 ? str : f + File.separator + String.format("vmpdebug-%d.log", Integer.valueOf(i - 1));
            if (i.a(str2)) {
                String str3 = f + File.separator + String.format("vmpdebug-%d.log", Integer.valueOf(i));
                if (i.a(str3)) {
                    i.c(str3);
                }
                if (!i.b(str2, str3)) {
                    b("TGPA", "rename log file failed! file: " + str2 + " , new file: " + str3);
                }
            }
        }
    }

    public static void a(a aVar) {
        e = aVar;
    }

    public static void a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            if (d != null) {
                d.write(str.getBytes());
                d.flush();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        if ((f5676a || b) && str2 != null) {
            Log.d(str, str2);
            if (c) {
                b(String.format("%s [DEBUG] %s: %s\n", d.a(d.a.PATTERN2.getFormat()), str, str2));
            }
        }
    }

    public static void a(String str, String str2, boolean z) {
        if ((z || f5676a || b) && str2 != null) {
            Log.d(str, str2);
            if (c) {
                b(String.format("%s [DEBUG] %s: %s\n", d.a(d.a.PATTERN2.getFormat()), str, str2));
            }
        }
    }

    public static void a(String str, Throwable th) {
        b("TGPA", str);
        b("TGPA", Log.getStackTraceString(th));
    }

    public static void a(String str, HashMap<String, String> hashMap) {
        if (f5676a || b) {
            a("%s: %s", str, hashMap.toString());
        }
    }

    public static void a(String str, Object... objArr) {
        if (f5676a || b) {
            a("TGPA", String.format(str, objArr));
        }
    }

    public static void a(boolean z) {
        f5676a = z;
    }

    public static void b() {
        String str = com.ihoc.mgpa.n.a.f() + File.separator + "vmpdebug.log";
        try {
            if (i.a(str)) {
                i.c(str);
            }
            File file = new File(str);
            if (file.createNewFile()) {
                d = new FileOutputStream(file, true);
                c = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void b(String str) {
        a aVar = e;
        if (aVar != null) {
            aVar.a(str);
        } else {
            a(str);
        }
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        Log.e(str, str2);
        if (c) {
            b(String.format("%s [ERROR] %s: %s\n", d.a(d.a.PATTERN2.getFormat()), str, str2));
        }
    }

    public static void b(String str, Object... objArr) {
        b("TGPA", String.format(str, objArr));
    }

    public static void b(boolean z) {
        b = z;
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        Log.i(str, str2);
        if (c) {
            b(String.format("%s [INFO] %s: %s\n", d.a(d.a.PATTERN2.getFormat()), str, str2));
        }
    }

    public static void c(String str, Object... objArr) {
        c("TGPA", String.format(str, objArr));
    }

    public static boolean c() {
        return f5676a || b;
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        Log.w(str, str2);
        if (c) {
            b(String.format("%s [WARN] %s: %s\n", d.a(d.a.PATTERN2.getFormat()), str, str2));
        }
    }

    public static void d(String str, Object... objArr) {
        d("TGPA", String.format(str, objArr));
    }
}
