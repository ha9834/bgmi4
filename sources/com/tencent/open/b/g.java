package com.tencent.open.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
public class g extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    protected static final String[] f6371a = {"key"};
    protected static g b;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (b == null) {
                b = new g(com.tencent.open.utils.g.a());
            }
            gVar = b;
        }
        return gVar;
    }

    public g(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0087, code lost:
    
        if (r1 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0089, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a1, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x009d, code lost:
    
        if (r1 != null) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073 A[Catch: all -> 0x007d, Exception -> 0x007f, TRY_ENTER, TryCatch #15 {Exception -> 0x007f, all -> 0x007d, blocks: (B:23:0x0030, B:25:0x0036, B:26:0x0039, B:32:0x0053, B:35:0x0056, B:39:0x0073, B:40:0x0076, B:67:0x0060, B:60:0x0063, B:61:0x0066, B:54:0x006a, B:49:0x006d), top: B:22:0x0030 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<java.io.Serializable> a(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lad
            r0.<init>()     // Catch: java.lang.Throwable -> Lad
            java.util.List r0 = java.util.Collections.synchronizedList(r0)     // Catch: java.lang.Throwable -> Lad
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto L12
            monitor-exit(r11)
            return r0
        L12:
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> Lad
            if (r1 != 0) goto L1a
            monitor-exit(r11)
            return r0
        L1a:
            r10 = 0
            java.lang.String r3 = "via_cgi_report"
            r4 = 0
            java.lang.String r5 = "type = ?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
            r2 = 0
            r6[r2] = r12     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r1
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
            if (r12 == 0) goto L82
            int r2 = r12.getCount()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            if (r2 <= 0) goto L82
            r12.moveToFirst()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
        L39:
            java.lang.String r2 = "blob"
            int r2 = r12.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            byte[] r2 = r12.getBlob(r2)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L67
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L67
            java.lang.Object r4 = r2.readObject()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L68
            java.io.Serializable r4 = (java.io.Serializable) r4     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L68
            r2.close()     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L7d java.lang.Exception -> L7f
        L56:
            r3.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L7d java.lang.Exception -> L7f
            goto L71
        L5a:
            r4 = move-exception
            goto L5e
        L5c:
            r4 = move-exception
            r2 = r10
        L5e:
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.io.IOException -> L63 java.lang.Throwable -> L7d java.lang.Exception -> L7f
        L63:
            r3.close()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L7d java.lang.Exception -> L7f
        L66:
            throw r4     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
        L67:
            r2 = r10
        L68:
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L7d java.lang.Exception -> L7f
        L6d:
            r3.close()     // Catch: java.io.IOException -> L70 java.lang.Throwable -> L7d java.lang.Exception -> L7f
        L70:
            r4 = r10
        L71:
            if (r4 == 0) goto L76
            r0.add(r4)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
        L76:
            boolean r2 = r12.moveToNext()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            if (r2 != 0) goto L39
            goto L82
        L7d:
            r0 = move-exception
            goto La2
        L7f:
            r2 = move-exception
            r10 = r12
            goto L91
        L82:
            if (r12 == 0) goto L87
            r12.close()     // Catch: java.lang.Throwable -> Lad
        L87:
            if (r1 == 0) goto La0
        L89:
            r1.close()     // Catch: java.lang.Throwable -> Lad
            goto La0
        L8d:
            r0 = move-exception
            r12 = r10
            goto La2
        L90:
            r2 = move-exception
        L91:
            java.lang.String r12 = "openSDK_LOG.ReportDatabaseHelper"
            java.lang.String r3 = "getReportItemFromDB has exception."
            com.tencent.open.log.SLog.e(r12, r3, r2)     // Catch: java.lang.Throwable -> L8d
            if (r10 == 0) goto L9d
            r10.close()     // Catch: java.lang.Throwable -> Lad
        L9d:
            if (r1 == 0) goto La0
            goto L89
        La0:
            monitor-exit(r11)
            return r0
        La2:
            if (r12 == 0) goto La7
            r12.close()     // Catch: java.lang.Throwable -> Lad
        La7:
            if (r1 == 0) goto Lac
            r1.close()     // Catch: java.lang.Throwable -> Lad
        Lac:
            throw r0     // Catch: java.lang.Throwable -> Lad
        Lad:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.a(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0096, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0092, code lost:
    
        if (r1 == null) goto L55;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(java.lang.String r9, java.util.List<java.io.Serializable> r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r10.size()     // Catch: java.lang.Throwable -> La0
            if (r0 != 0) goto L9
            monitor-exit(r8)
            return
        L9:
            r1 = 20
            if (r0 > r1) goto Le
            goto L10
        Le:
            r0 = 20
        L10:
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> La0
            if (r1 == 0) goto L18
            monitor-exit(r8)
            return
        L18:
            r8.b(r9)     // Catch: java.lang.Throwable -> La0
            android.database.sqlite.SQLiteDatabase r1 = r8.getWritableDatabase()     // Catch: java.lang.Throwable -> La0
            if (r1 != 0) goto L23
            monitor-exit(r8)
            return
        L23:
            r1.beginTransaction()     // Catch: java.lang.Throwable -> La0
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r2.<init>()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r3 = 0
        L2c:
            if (r3 >= r0) goto L7a
            java.lang.Object r4 = r10.get(r3)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            java.io.Serializable r4 = (java.io.Serializable) r4     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            if (r4 == 0) goto L74
            java.lang.String r5 = "type"
            r2.put(r5, r9)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r6 = 512(0x200, float:7.175E-43)
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r6 = 0
            java.io.ObjectOutputStream r7 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5f
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5f
            r7.writeObject(r4)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L60
            r7.close()     // Catch: java.io.IOException -> L4e java.lang.Throwable -> L86 java.lang.Exception -> L88
        L4e:
            r5.close()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L86 java.lang.Exception -> L88
            goto L66
        L52:
            r9 = move-exception
            r6 = r7
            goto L56
        L55:
            r9 = move-exception
        L56:
            if (r6 == 0) goto L5b
            r6.close()     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L86 java.lang.Exception -> L88
        L5b:
            r5.close()     // Catch: java.io.IOException -> L5e java.lang.Throwable -> L86 java.lang.Exception -> L88
        L5e:
            throw r9     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
        L5f:
            r7 = r6
        L60:
            if (r7 == 0) goto L4e
            r7.close()     // Catch: java.io.IOException -> L4e java.lang.Throwable -> L86 java.lang.Exception -> L88
            goto L4e
        L66:
            java.lang.String r4 = "blob"
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r2.put(r4, r5)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            java.lang.String r4 = "via_cgi_report"
            r1.insert(r4, r6, r2)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
        L74:
            r2.clear()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            int r3 = r3 + 1
            goto L2c
        L7a:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r1.endTransaction()     // Catch: java.lang.Throwable -> La0
            if (r1 == 0) goto L95
        L82:
            r1.close()     // Catch: java.lang.Throwable -> La0
            goto L95
        L86:
            r9 = move-exception
            goto L97
        L88:
            java.lang.String r9 = "openSDK_LOG.ReportDatabaseHelper"
            java.lang.String r10 = "saveReportItemToDB has exception."
            com.tencent.open.log.SLog.e(r9, r10)     // Catch: java.lang.Throwable -> L86
            r1.endTransaction()     // Catch: java.lang.Throwable -> La0
            if (r1 == 0) goto L95
            goto L82
        L95:
            monitor-exit(r8)
            return
        L97:
            r1.endTransaction()     // Catch: java.lang.Throwable -> La0
            if (r1 == 0) goto L9f
            r1.close()     // Catch: java.lang.Throwable -> La0
        L9f:
            throw r9     // Catch: java.lang.Throwable -> La0
        La0:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.a(java.lang.String, java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void b(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L9
            monitor-exit(r5)
            return
        L9:
            android.database.sqlite.SQLiteDatabase r0 = r5.getWritableDatabase()     // Catch: java.lang.Throwable -> L39
            if (r0 != 0) goto L11
            monitor-exit(r5)
            return
        L11:
            java.lang.String r1 = "via_cgi_report"
            java.lang.String r2 = "type = ?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r0.delete(r1, r2, r3)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            if (r0 == 0) goto L31
        L20:
            r0.close()     // Catch: java.lang.Throwable -> L39
            goto L31
        L24:
            r6 = move-exception
            goto L33
        L26:
            r6 = move-exception
            java.lang.String r1 = "openSDK_LOG.ReportDatabaseHelper"
            java.lang.String r2 = "clearReportItem has exception."
            com.tencent.open.log.SLog.e(r1, r2, r6)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L31
            goto L20
        L31:
            monitor-exit(r5)
            return
        L33:
            if (r0 == 0) goto L38
            r0.close()     // Catch: java.lang.Throwable -> L39
        L38:
            throw r6     // Catch: java.lang.Throwable -> L39
        L39:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.b(java.lang.String):void");
    }
}
