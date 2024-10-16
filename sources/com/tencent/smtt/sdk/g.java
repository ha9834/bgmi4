package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6522a = CookieManager.LOGTAG;
    static File b;

    public static File a(Context context) {
        if (b == null && context != null) {
            b = new File(context.getDir("webview", 0), "Cookies");
        }
        if (b == null) {
            b = new File("/data/data/" + context.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
        }
        return b;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        com.tencent.smtt.utils.b.a(a(context), false);
        return true;
    }

    public static SQLiteDatabase c(Context context) {
        File a2;
        SQLiteDatabase sQLiteDatabase = null;
        if (context == null || (a2 = a(context)) == null) {
            return null;
        }
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(a2.getAbsolutePath(), null, 0);
        } catch (Exception unused) {
        }
        if (sQLiteDatabase == null) {
            TbsLog.i(f6522a, "dbPath is not exist!");
        }
        return sQLiteDatabase;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0061, code lost:
    
        if (r0.moveToNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
    
        if (r0 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
    
        if (r7 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
    
        if (r7.isOpen() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0091, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008f, code lost:
    
        if (r7.isOpen() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (r0.moveToFirst() != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        r2 = r0.getString(1);
        r3 = r0.getString(4);
        r1.add(r2);
        android.util.Log.w(com.tencent.smtt.sdk.g.f6522a, "tablename:" + r2 + "->" + r3);
        a(r7, r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<java.lang.String> a(android.database.sqlite.SQLiteDatabase r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "select * from sqlite_master where type='table'"
            android.database.Cursor r0 = r7.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            java.lang.String r2 = com.tencent.smtt.sdk.g.f6522a     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            r3.<init>()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            java.lang.String r4 = "db version:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            int r4 = r7.getVersion()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            r3.append(r4)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            android.util.Log.w(r2, r3)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            if (r2 == 0) goto L63
        L2f:
            r2 = 1
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            r3 = 4
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            r1.add(r2)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            java.lang.String r4 = com.tencent.smtt.sdk.g.f6522a     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            r5.<init>()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            java.lang.String r6 = "tablename:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            r5.append(r2)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            java.lang.String r6 = "->"
            r5.append(r6)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            r5.append(r3)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            android.util.Log.w(r4, r3)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            a(r7, r2)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L83
            if (r2 != 0) goto L2f
        L63:
            if (r0 == 0) goto L68
            r0.close()
        L68:
            if (r7 == 0) goto L94
            boolean r0 = r7.isOpen()
            if (r0 == 0) goto L94
            goto L91
        L71:
            r1 = move-exception
            if (r0 == 0) goto L77
            r0.close()
        L77:
            if (r7 == 0) goto L82
            boolean r0 = r7.isOpen()
            if (r0 == 0) goto L82
            r7.close()
        L82:
            throw r1
        L83:
            if (r0 == 0) goto L89
            r0.close()
        L89:
            if (r7 == 0) goto L94
            boolean r0 = r7.isOpen()
            if (r0 == 0) goto L94
        L91:
            r7.close()
        L94:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.g.a(android.database.sqlite.SQLiteDatabase):java.util.ArrayList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        r1.append("\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
    
        if (r4.moveToNext() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x004a, code lost:
    
        if (r4.moveToFirst() != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x004c, code lost:
    
        r1.append("\n");
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0052, code lost:
    
        if (r5 >= r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0058, code lost:
    
        r1.append(r4.getString(r5));
        r1.append(",");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(android.database.sqlite.SQLiteDatabase r4, java.lang.String r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "select * from "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r0 = 0
            android.database.Cursor r4 = r4.rawQuery(r5, r0)
            int r5 = r4.getCount()
            int r0 = r4.getColumnCount()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "raws:"
            r2.append(r3)
            r2.append(r5)
            java.lang.String r3 = ",columns:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = "\n"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            if (r5 <= 0) goto L6e
            boolean r5 = r4.moveToFirst()
            if (r5 == 0) goto L6e
        L4c:
            java.lang.String r5 = "\n"
            r1.append(r5)
            r5 = 0
        L52:
            if (r5 >= r0) goto L63
            java.lang.String r2 = r4.getString(r5)     // Catch: java.lang.Exception -> L60
            r1.append(r2)
            java.lang.String r2 = ","
            r1.append(r2)
        L60:
            int r5 = r5 + 1
            goto L52
        L63:
            java.lang.String r5 = "\n"
            r1.append(r5)
            boolean r5 = r4.moveToNext()
            if (r5 != 0) goto L4c
        L6e:
            java.lang.String r4 = com.tencent.smtt.sdk.g.f6522a
            java.lang.String r5 = r1.toString()
            android.util.Log.i(r4, r5)
            java.lang.String r4 = r1.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.g.a(android.database.sqlite.SQLiteDatabase, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r3.moveToFirst() != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r3.getString(0).equals("version") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r3.moveToNext() != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        r2 = java.lang.Integer.parseInt(r3.getString(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        if (r8.isOpen() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008e, code lost:
    
        if (r8.isOpen() != false) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r8) {
        /*
            java.lang.String r0 = com.tencent.smtt.sdk.g.f6522a
            java.lang.String r1 = "getCookieDBVersion"
            android.util.Log.i(r0, r1)
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            r3 = 0
            android.database.sqlite.SQLiteDatabase r8 = c(r8)     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L67
            if (r8 != 0) goto L20
            r0 = -1
            if (r8 == 0) goto L1f
            boolean r1 = r8.isOpen()
            if (r1 == 0) goto L1f
            r8.close()
        L1f:
            return r0
        L20:
            java.lang.String r4 = "select * from meta"
            android.database.Cursor r3 = r8.rawQuery(r4, r3)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> Lb5
            int r4 = r3.getCount()     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> Lb5
            r3.getColumnCount()     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> Lb5
            if (r4 <= 0) goto L51
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> Lb5
            if (r4 == 0) goto L51
        L35:
            java.lang.String r4 = r3.getString(r2)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> Lb5
            java.lang.String r5 = "version"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> Lb5
            if (r4 == 0) goto L4b
            r4 = 1
            java.lang.String r4 = r3.getString(r4)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> Lb5
            int r2 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> Lb5
            goto L51
        L4b:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> Lb5
            if (r4 != 0) goto L35
        L51:
            if (r3 == 0) goto L56
            r3.close()
        L56:
            if (r8 == 0) goto L91
            boolean r3 = r8.isOpen()
            if (r3 == 0) goto L91
        L5e:
            r8.close()
            goto L91
        L62:
            r4 = move-exception
            goto L69
        L64:
            r0 = move-exception
            r8 = r3
            goto Lb6
        L67:
            r4 = move-exception
            r8 = r3
        L69:
            java.lang.String r5 = com.tencent.smtt.sdk.g.f6522a     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            r6.<init>()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r7 = "getCookieDBVersion exception:"
            r6.append(r7)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lb5
            r6.append(r4)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> Lb5
            android.util.Log.i(r5, r4)     // Catch: java.lang.Throwable -> Lb5
            if (r3 == 0) goto L88
            r3.close()
        L88:
            if (r8 == 0) goto L91
            boolean r3 = r8.isOpen()
            if (r3 == 0) goto L91
            goto L5e
        L91:
            java.lang.String r8 = com.tencent.smtt.sdk.g.f6522a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getCookieDBVersion:"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = ",timeused:"
            r3.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r0
            r3.append(r4)
            java.lang.String r0 = r3.toString()
            android.util.Log.i(r8, r0)
            return r2
        Lb5:
            r0 = move-exception
        Lb6:
            if (r3 == 0) goto Lbb
            r3.close()
        Lbb:
            if (r8 == 0) goto Lc6
            boolean r1 = r8.isOpen()
            if (r1 == 0) goto Lc6
            r8.close()
        Lc6:
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.g.d(android.content.Context):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        if (r4.moveToFirst() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        r6 = r4.getString(r4.getColumnIndex("host_key"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
    
        if (r12 != com.tencent.smtt.sdk.CookieManager.a.b) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        r7 = r13.length;
        r8 = false;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r9 >= r7) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        if (r6.equals(r13[r9]) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        if (r8 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f5, code lost:
    
        if (r4.moveToNext() != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
    
        r7 = r4.getString(r4.getColumnIndex("value")) + ";" + r4.getString(r4.getColumnIndex("name")) + ";" + r4.getInt(r4.getColumnIndex("expires_utc")) + ";" + r4.getInt(r4.getColumnIndex("priority"));
        r3.put(r6, r7);
        android.util.Log.i(com.tencent.smtt.sdk.g.f6522a, "key : value -> " + r6 + com.facebook.internal.security.CertificateUtil.DELIMITER + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0124, code lost:
    
        if (r15.isOpen() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0152, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0150, code lost:
    
        if (r15.isOpen() != false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r11, com.tencent.smtt.sdk.CookieManager.a r12, java.lang.String r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.g.a(android.content.Context, com.tencent.smtt.sdk.CookieManager$a, java.lang.String, boolean, boolean):void");
    }
}
