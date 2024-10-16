package com.subao.common.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import android.util.JsonReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes2.dex */
public class b {
    private static final String c = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
    private static final String d = c + "wsds/";
    private static final String e = d + "wsds_logs/";

    /* renamed from: a, reason: collision with root package name */
    static RunnableC0168b f6018a = null;
    private static boolean f = false;
    static a b = null;
    private static String g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("cn.wsds.log.action.start_catch".equals(action)) {
                b.b(null);
            } else if ("cn.wsds.log.action.stop_catch".equals(action)) {
                b.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.subao.common.f.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0168b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        Process f6019a;
        private String b;
        private boolean c = true;
        private File d;

        RunnableC0168b(File file) {
            this.d = file;
            b();
        }

        private void b() {
            try {
                if (!this.d.exists()) {
                    this.c = this.d.mkdirs();
                }
                this.b = String.format("%s/%s_%s.log", this.d.getAbsolutePath(), this.d.getName(), new SimpleDateFormat("yyyyMMdd_HH_mm_ss").format(new Date()));
                b.a(this.d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("logcat");
                arrayList.add("-f");
                arrayList.add(this.b);
                arrayList.add("-v");
                arrayList.add("time");
                arrayList.add("*:D");
                try {
                    this.f6019a = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
                } catch (Exception unused) {
                }
            }
        }

        void a() {
            try {
                if (this.f6019a != null) {
                    this.f6019a.destroy();
                    this.f6019a = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void a(Context context, String str, com.subao.common.g.c cVar) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                a(context);
                if (a(cVar)) {
                    b(a(str));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.length() <= 12 ? str : str.substring(0, 12);
    }

    static synchronized void b(String str) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(g)) {
                return;
            }
            if (f6018a == null) {
                if (!TextUtils.isEmpty(str)) {
                    g = String.format("%s%s/", e, str);
                }
                f6018a = new RunnableC0168b(new File(g));
                com.subao.common.m.d.a().execute(f6018a);
            }
        }
    }

    static void a() {
        RunnableC0168b runnableC0168b;
        synchronized (b.class) {
            runnableC0168b = f6018a;
            f6018a = null;
        }
        if (runnableC0168b != null) {
            runnableC0168b.a();
        }
        f = false;
    }

    static void a(Context context) {
        if (b == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("cn.wsds.log.action.start_catch");
            intentFilter.addAction("cn.wsds.log.action.stop_catch");
            b = new a();
            context.registerReceiver(b, intentFilter);
        }
    }

    public static boolean a(com.subao.common.g.c cVar) {
        File a2 = a(new File(d), new File(d, "log.config"));
        f = a2 != null && a(a2, "log_action");
        if (f && cVar != null) {
            cVar.c();
        }
        return f;
    }

    public static boolean b() {
        return f;
    }

    public static File a(File file, File file2) {
        if (file.exists() && file.isDirectory() && file2.exists() && file2.isFile()) {
            return file2;
        }
        return null;
    }

    public static boolean a(File file, String str) {
        if (file == null || !file.exists() || !file.isFile() || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return a(new JsonReader(new BufferedReader(new FileReader(file), 1024)), str);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        r0 = r2.nextBoolean();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean a(android.util.JsonReader r2, java.lang.String r3) {
        /*
            r0 = 0
            if (r2 == 0) goto L3c
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto La
            goto L3c
        La:
            r2.beginObject()     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d java.io.IOException -> L32
        Ld:
            boolean r1 = r2.hasNext()     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d java.io.IOException -> L32
            if (r1 == 0) goto L27
            java.lang.String r1 = r2.nextName()     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d java.io.IOException -> L32
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d java.io.IOException -> L32
            if (r1 == 0) goto L23
            boolean r3 = r2.nextBoolean()     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d java.io.IOException -> L32
            r0 = r3
            goto L27
        L23:
            r2.skipValue()     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d java.io.IOException -> L32
            goto Ld
        L27:
            com.subao.common.e.a(r2)
            goto L37
        L2b:
            r3 = move-exception
            goto L38
        L2d:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L2b
            goto L27
        L32:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L2b
            goto L27
        L37:
            return r0
        L38:
            com.subao.common.e.a(r2)
            throw r3
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.subao.common.f.b.a(android.util.JsonReader, java.lang.String):boolean");
    }

    static void a(File file) {
        if (file != null && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
    }
}
