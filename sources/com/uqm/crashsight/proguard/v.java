package com.uqm.crashsight.proguard;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static v f6630a;
    private String b;

    @SuppressLint({"SdCardPath"})
    private v(Context context) {
        this.b = null;
        try {
            this.b = context.getDir("crashSight", 0).getAbsolutePath();
            com.uqm.crashsight.crashreport.common.info.a.a(context).M();
        } catch (Throwable unused) {
            this.b = "/data/data/" + com.uqm.crashsight.crashreport.common.info.a.a(context).c + "/app_crashSight";
        }
    }

    public static synchronized v a(Context context) {
        v vVar;
        synchronized (v.class) {
            if (f6630a == null) {
                f6630a = new v(context);
            }
            vVar = f6630a;
        }
        return vVar;
    }

    public static synchronized v a() {
        v vVar;
        synchronized (v.class) {
            vVar = f6630a;
        }
        return vVar;
    }

    public final byte[] b() {
        String a2 = a(this.b);
        FileInputStream fileInputStream = null;
        if (a2 == null) {
            return null;
        }
        File file = new File(a2);
        if (file.length() == 0) {
            return null;
        }
        byte[] bArr = new byte[(int) file.length()];
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    try {
                        fileInputStream2.read(bArr);
                        try {
                            fileInputStream2.close();
                        } catch (IOException e) {
                            m.b(e);
                        }
                        return bArr;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                m.b(e2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    m.b(e3);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        m.b(e4);
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e5) {
            m.b(e5);
            return null;
        }
    }

    private static String a(String str) {
        File[] listFiles;
        if (str == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getName().matches("mmkvlite_log_unwind_\\d+.mmkv")) {
                        arrayList.add(file2.getAbsolutePath());
                    }
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            Collections.sort(arrayList);
            return (String) arrayList.get(arrayList.size() - 1);
        } catch (Throwable th) {
            m.a(th);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void c() {
        File[] listFiles;
        if (this.b == null) {
            return;
        }
        try {
            File file = new File(this.b);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (file2.canRead() && file2.canWrite() && name.matches("mmkvlite_log_unwind_\\d+.mmkv") && file2.delete()) {
                        m.c("Delete mmkvlite record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            m.a(th);
        }
    }
}
