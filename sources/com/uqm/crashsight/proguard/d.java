package com.uqm.crashsight.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f6611a;
    private static e b;
    private static boolean c;

    private d(Context context, List<com.uqm.crashsight.a> list) {
        b = new e(context, list);
    }

    public static synchronized d a(Context context, List<com.uqm.crashsight.a> list) {
        d dVar;
        synchronized (d.class) {
            if (f6611a == null) {
                f6611a = new d(context, list);
            }
            dVar = f6611a;
        }
        return dVar;
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            dVar = f6611a;
        }
        return dVar;
    }

    public final long a(String str, ContentValues contentValues, c cVar, boolean z) {
        return a(str, contentValues, (c) null);
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, c cVar, boolean z) {
        return a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    public final int a(String str, String str2, String[] strArr, c cVar, boolean z) {
        return a(str, str2, (String[]) null, (c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        if (r9 != null) goto L13;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized long a(java.lang.String r7, android.content.ContentValues r8, com.uqm.crashsight.proguard.c r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            com.uqm.crashsight.proguard.e r2 = com.uqm.crashsight.proguard.d.b     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35
            if (r2 == 0) goto L2d
            if (r8 == 0) goto L2d
            java.lang.String r3 = "_id"
            long r2 = r2.replace(r7, r3, r8)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35
            r8 = 0
            r4 = 1
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 < 0) goto L23
            java.lang.String r5 = "[Database] insert %s success."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35
            r4[r8] = r7     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35
            com.uqm.crashsight.proguard.m.c(r5, r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35
            goto L2c
        L23:
            java.lang.String r5 = "[Database] replace %s error."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35
            r4[r8] = r7     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35
            com.uqm.crashsight.proguard.m.d(r5, r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35
        L2c:
            r0 = r2
        L2d:
            if (r9 == 0) goto L42
        L2f:
            java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L4a
            goto L42
        L33:
            r7 = move-exception
            goto L44
        L35:
            r7 = move-exception
            boolean r8 = com.uqm.crashsight.proguard.m.a(r7)     // Catch: java.lang.Throwable -> L33
            if (r8 != 0) goto L3f
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L33
        L3f:
            if (r9 == 0) goto L42
            goto L2f
        L42:
            monitor-exit(r6)
            return r0
        L44:
            if (r9 == 0) goto L49
            java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L4a
        L49:
            throw r7     // Catch: java.lang.Throwable -> L4a
        L4a:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.d.a(java.lang.String, android.content.ContentValues, com.uqm.crashsight.proguard.c):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, c cVar) {
        Cursor cursor;
        cursor = null;
        try {
            try {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase != null) {
                    cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
                }
            } catch (Throwable th) {
                if (!m.a(th)) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0020, code lost:
    
        if (r6 != null) goto L8;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int a(java.lang.String r3, java.lang.String r4, java.lang.String[] r5, com.uqm.crashsight.proguard.c r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            com.uqm.crashsight.proguard.e r1 = com.uqm.crashsight.proguard.d.b     // Catch: java.lang.Throwable -> L14 java.lang.Throwable -> L16
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L14 java.lang.Throwable -> L16
            if (r1 == 0) goto Le
            int r0 = r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L14 java.lang.Throwable -> L16
        Le:
            if (r6 == 0) goto L23
        L10:
            java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L2b
            goto L23
        L14:
            r3 = move-exception
            goto L25
        L16:
            r3 = move-exception
            boolean r4 = com.uqm.crashsight.proguard.m.a(r3)     // Catch: java.lang.Throwable -> L14
            if (r4 != 0) goto L20
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L14
        L20:
            if (r6 == 0) goto L23
            goto L10
        L23:
            monitor-exit(r2)
            return r0
        L25:
            if (r6 == 0) goto L2a
            java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L2b
        L2a:
            throw r3     // Catch: java.lang.Throwable -> L2b
        L2b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.d.a(java.lang.String, java.lang.String, java.lang.String[], com.uqm.crashsight.proguard.c):int");
    }

    public final boolean a(int i, String str, byte[] bArr, c cVar, boolean z) {
        if (!z) {
            a aVar = new a(4, null);
            aVar.a(i, str, bArr);
            k.a().a(aVar);
            return true;
        }
        return a(i, str, bArr, (c) null);
    }

    public final Map<String, byte[]> a(int i, c cVar, boolean z) {
        return a(i, (c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r8 != null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002c, code lost:
    
        return r0;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r5, java.lang.String r6, byte[] r7, com.uqm.crashsight.proguard.c r8) {
        /*
            r4 = this;
            r0 = 0
            com.uqm.crashsight.proguard.f r1 = new com.uqm.crashsight.proguard.f     // Catch: java.lang.Throwable -> L1d java.lang.Throwable -> L1f
            r1.<init>()     // Catch: java.lang.Throwable -> L1d java.lang.Throwable -> L1f
            long r2 = (long) r5     // Catch: java.lang.Throwable -> L1d java.lang.Throwable -> L1f
            r1.f6614a = r2     // Catch: java.lang.Throwable -> L1d java.lang.Throwable -> L1f
            r1.f = r6     // Catch: java.lang.Throwable -> L1d java.lang.Throwable -> L1f
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1d java.lang.Throwable -> L1f
            r1.e = r5     // Catch: java.lang.Throwable -> L1d java.lang.Throwable -> L1f
            r1.g = r7     // Catch: java.lang.Throwable -> L1d java.lang.Throwable -> L1f
            boolean r0 = r4.b(r1)     // Catch: java.lang.Throwable -> L1d java.lang.Throwable -> L1f
            if (r8 == 0) goto L2c
        L19:
            java.lang.Boolean.valueOf(r0)
            goto L2c
        L1d:
            r5 = move-exception
            goto L2d
        L1f:
            r5 = move-exception
            boolean r6 = com.uqm.crashsight.proguard.m.a(r5)     // Catch: java.lang.Throwable -> L1d
            if (r6 != 0) goto L29
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L1d
        L29:
            if (r8 == 0) goto L2c
            goto L19
        L2c:
            return r0
        L2d:
            if (r8 == 0) goto L32
            java.lang.Boolean.valueOf(r0)
        L32:
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.d.a(int, java.lang.String, byte[], com.uqm.crashsight.proguard.c):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, byte[]> a(int i, c cVar) {
        HashMap hashMap = null;
        try {
            List<f> c2 = c(i);
            if (c2 == null) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            try {
                for (f fVar : c2) {
                    byte[] bArr = fVar.g;
                    if (bArr != null) {
                        hashMap2.put(fVar.f, bArr);
                    }
                }
                return hashMap2;
            } catch (Throwable th) {
                th = th;
                hashMap = hashMap2;
                if (m.a(th)) {
                    return hashMap;
                }
                th.printStackTrace();
                return hashMap;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized boolean a(f fVar) {
        ContentValues c2;
        try {
            if (fVar == null) {
                return false;
            }
            try {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase == null || (c2 = c(fVar)) == null) {
                    return false;
                }
                long replace = writableDatabase.replace("t_lr", "_id", c2);
                if (replace < 0) {
                    return false;
                }
                m.c("[Database] insert %s success.", "t_lr");
                fVar.f6614a = replace;
                return true;
            } catch (Throwable th) {
                if (!m.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized boolean b(f fVar) {
        ContentValues d;
        try {
            if (fVar == null) {
                return false;
            }
            try {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase == null || (d = d(fVar)) == null) {
                    return false;
                }
                long replace = writableDatabase.replace("t_pf", "_id", d);
                if (replace < 0) {
                    return false;
                }
                m.c("[Database] insert %s success.", "t_pf");
                fVar.f6614a = replace;
                return true;
            } catch (Throwable th) {
                if (!m.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #1 {all -> 0x00b6, blocks: (B:19:0x003c, B:20:0x0046, B:22:0x004d, B:32:0x0053, B:25:0x0057, B:29:0x006f, B:35:0x0077, B:37:0x0081, B:44:0x00a7, B:46:0x00ad), top: B:9:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2 A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #5 {, blocks: (B:3:0x0001, B:15:0x0037, B:40:0x00a1, B:48:0x00b2, B:55:0x00b9, B:56:0x00bc), top: B:2:0x0001 }] */
    /* JADX WARN: Type inference failed for: r11v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.List<com.uqm.crashsight.proguard.f> a(int r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            com.uqm.crashsight.proguard.e r0 = com.uqm.crashsight.proguard.d.b     // Catch: java.lang.Throwable -> Lbf
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> Lbf
            r9 = 0
            if (r0 == 0) goto Lbd
            if (r11 < 0) goto L26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> L21
            java.lang.String r2 = "_tp = "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> L21
            r1.append(r11)     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> L21
            java.lang.String r11 = r1.toString()     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> L21
            r4 = r11
            goto L27
        L1c:
            r11 = move-exception
            r0 = r11
            r11 = r9
            goto Lb7
        L21:
            r11 = move-exception
            r0 = r11
            r11 = r9
            goto La7
        L26:
            r4 = r9
        L27:
            java.lang.String r2 = "t_lr"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> L21
            if (r11 != 0) goto L3c
            if (r11 == 0) goto L3a
            r11.close()     // Catch: java.lang.Throwable -> Lbf
        L3a:
            monitor-exit(r10)
            return r9
        L3c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            r1.<init>()     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            r2.<init>()     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
        L46:
            boolean r3 = r11.moveToNext()     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            r4 = 0
            if (r3 == 0) goto L77
            com.uqm.crashsight.proguard.f r3 = a(r11)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            if (r3 == 0) goto L57
            r2.add(r3)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            goto L46
        L57:
            java.lang.String r3 = "_id"
            int r3 = r11.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L6f java.lang.Throwable -> Lb6
            long r5 = r11.getLong(r3)     // Catch: java.lang.Throwable -> L6f java.lang.Throwable -> Lb6
            java.lang.String r3 = " or _id"
            r1.append(r3)     // Catch: java.lang.Throwable -> L6f java.lang.Throwable -> Lb6
            java.lang.String r3 = " = "
            r1.append(r3)     // Catch: java.lang.Throwable -> L6f java.lang.Throwable -> Lb6
            r1.append(r5)     // Catch: java.lang.Throwable -> L6f java.lang.Throwable -> Lb6
            goto L46
        L6f:
            java.lang.String r3 = "[Database] unknown id."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            com.uqm.crashsight.proguard.m.d(r3, r4)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            goto L46
        L77:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            int r3 = r1.length()     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            if (r3 <= 0) goto L9f
            r3 = 4
            java.lang.String r1 = r1.substring(r3)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            java.lang.String r3 = "t_lr"
            int r0 = r0.delete(r3, r1, r9)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            java.lang.String r1 = "[Database] deleted %s illegal data %d"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            java.lang.String r5 = "t_lr"
            r3[r4] = r5     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            r4 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            r3[r4] = r0     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
            com.uqm.crashsight.proguard.m.d(r1, r3)     // Catch: java.lang.Throwable -> La6 java.lang.Throwable -> Lb6
        L9f:
            if (r11 == 0) goto La4
            r11.close()     // Catch: java.lang.Throwable -> Lbf
        La4:
            monitor-exit(r10)
            return r2
        La6:
            r0 = move-exception
        La7:
            boolean r1 = com.uqm.crashsight.proguard.m.a(r0)     // Catch: java.lang.Throwable -> Lb6
            if (r1 != 0) goto Lb0
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lb6
        Lb0:
            if (r11 == 0) goto Lbd
            r11.close()     // Catch: java.lang.Throwable -> Lbf
            goto Lbd
        Lb6:
            r0 = move-exception
        Lb7:
            if (r11 == 0) goto Lbc
            r11.close()     // Catch: java.lang.Throwable -> Lbf
        Lbc:
            throw r0     // Catch: java.lang.Throwable -> Lbf
        Lbd:
            monitor-exit(r10)
            return r9
        Lbf:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.d.a(int):java.util.List");
    }

    public final synchronized void a(List<f> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (f fVar : list) {
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(fVar.f6614a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        m.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                    } catch (Throwable th) {
                        if (m.a(th)) {
                            return;
                        }
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public final synchronized void b(int i) {
        String str;
        SQLiteDatabase writableDatabase = b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    try {
                        str = "_tp = " + i;
                    } catch (Throwable th) {
                        if (m.a(th)) {
                            return;
                        }
                        th.printStackTrace();
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                str = null;
            }
            m.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    private static ContentValues c(f fVar) {
        if (fVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (fVar.f6614a > 0) {
                contentValues.put("_id", Long.valueOf(fVar.f6614a));
            }
            contentValues.put("_tp", Integer.valueOf(fVar.b));
            contentValues.put("_pc", fVar.c);
            contentValues.put("_th", fVar.d);
            contentValues.put("_tm", Long.valueOf(fVar.e));
            if (fVar.g != null) {
                contentValues.put("_dt", fVar.g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static f a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            f fVar = new f();
            fVar.f6614a = cursor.getLong(cursor.getColumnIndex("_id"));
            fVar.b = cursor.getInt(cursor.getColumnIndex("_tp"));
            fVar.c = cursor.getString(cursor.getColumnIndex("_pc"));
            fVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            fVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            fVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return fVar;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00bb A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #5 {, blocks: (B:9:0x0029, B:35:0x009c, B:44:0x00b3, B:47:0x00bb, B:48:0x00be), top: B:3:0x0002 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.util.List<com.uqm.crashsight.proguard.f> c(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            com.uqm.crashsight.proguard.e r1 = com.uqm.crashsight.proguard.d.b     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La6
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La6
            if (r1 == 0) goto Lb6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La6
            java.lang.String r3 = "_id = "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La6
            r2.append(r12)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La6
            java.lang.String r10 = r2.toString()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La6
            java.lang.String r3 = "t_pf"
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r1
            r5 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> La6
            if (r2 != 0) goto L2e
            if (r2 == 0) goto L2c
            r2.close()     // Catch: java.lang.Throwable -> Lbf
        L2c:
            monitor-exit(r11)
            return r0
        L2e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            r3.<init>()     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            r4.<init>()     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
        L38:
            boolean r5 = r2.moveToNext()     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            r6 = 0
            if (r5 == 0) goto L69
            com.uqm.crashsight.proguard.f r5 = b(r2)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            if (r5 == 0) goto L49
            r4.add(r5)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            goto L38
        L49:
            java.lang.String r5 = "_tp"
            int r5 = r2.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Throwable -> Lb8
            java.lang.String r5 = r2.getString(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Throwable -> Lb8
            java.lang.String r7 = " or _tp"
            r3.append(r7)     // Catch: java.lang.Throwable -> L61 java.lang.Throwable -> Lb8
            java.lang.String r7 = " = "
            r3.append(r7)     // Catch: java.lang.Throwable -> L61 java.lang.Throwable -> Lb8
            r3.append(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Throwable -> Lb8
            goto L38
        L61:
            java.lang.String r5 = "[Database] unknown id."
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            com.uqm.crashsight.proguard.m.d(r5, r6)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            goto L38
        L69:
            int r5 = r3.length()     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            if (r5 <= 0) goto L9a
            java.lang.String r5 = " and _id"
            r3.append(r5)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            java.lang.String r5 = " = "
            r3.append(r5)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            r3.append(r12)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            r12 = 4
            java.lang.String r12 = r10.substring(r12)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            java.lang.String r3 = "t_pf"
            int r12 = r1.delete(r3, r12, r0)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            java.lang.String r1 = "[Database] deleted %s illegal data %d."
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            java.lang.String r5 = "t_pf"
            r3[r6] = r5     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            r5 = 1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            r3[r5] = r12     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
            com.uqm.crashsight.proguard.m.d(r1, r3)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb8
        L9a:
            if (r2 == 0) goto L9f
            r2.close()     // Catch: java.lang.Throwable -> Lbf
        L9f:
            monitor-exit(r11)
            return r4
        La1:
            r12 = move-exception
            goto La8
        La3:
            r12 = move-exception
            r2 = r0
            goto Lb9
        La6:
            r12 = move-exception
            r2 = r0
        La8:
            boolean r1 = com.uqm.crashsight.proguard.m.a(r12)     // Catch: java.lang.Throwable -> Lb8
            if (r1 != 0) goto Lb1
            r12.printStackTrace()     // Catch: java.lang.Throwable -> Lb8
        Lb1:
            if (r2 == 0) goto Lb6
            r2.close()     // Catch: java.lang.Throwable -> Lbf
        Lb6:
            monitor-exit(r11)
            return r0
        Lb8:
            r12 = move-exception
        Lb9:
            if (r2 == 0) goto Lbe
            r2.close()     // Catch: java.lang.Throwable -> Lbf
        Lbe:
            throw r12     // Catch: java.lang.Throwable -> Lbf
        Lbf:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.d.c(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        if (r7 != null) goto L14;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean a(int r5, java.lang.String r6, com.uqm.crashsight.proguard.c r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            com.uqm.crashsight.proguard.e r1 = com.uqm.crashsight.proguard.d.b     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            if (r1 == 0) goto L5c
            boolean r2 = com.uqm.crashsight.proguard.q.a(r6)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            if (r2 == 0) goto L1f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.String r2 = "_id = "
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            r6.append(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            goto L3f
        L1f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.String r3 = "_id = "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            r2.append(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.String r5 = " and _tp"
            r2.append(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.String r5 = " = \""
            r2.append(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            r2.append(r6)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.String r5 = "\""
            r2.append(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
        L3f:
            java.lang.String r6 = "t_pf"
            r2 = 0
            int r5 = r1.delete(r6, r5, r2)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.String r6 = "[Database] deleted %s data %d"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.String r2 = "t_pf"
            r1[r0] = r2     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            r3 = 1
            r1[r3] = r2     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            com.uqm.crashsight.proguard.m.c(r6, r1)     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L64
            if (r5 <= 0) goto L5c
            r0 = 1
        L5c:
            if (r7 == 0) goto L71
        L5e:
            java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L79
            goto L71
        L62:
            r5 = move-exception
            goto L73
        L64:
            r5 = move-exception
            boolean r6 = com.uqm.crashsight.proguard.m.a(r5)     // Catch: java.lang.Throwable -> L62
            if (r6 != 0) goto L6e
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L62
        L6e:
            if (r7 == 0) goto L71
            goto L5e
        L71:
            monitor-exit(r4)
            return r0
        L73:
            if (r7 == 0) goto L78
            java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L79
        L78:
            throw r5     // Catch: java.lang.Throwable -> L79
        L79:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.d.a(int, java.lang.String, com.uqm.crashsight.proguard.c):boolean");
    }

    private static ContentValues d(f fVar) {
        if (fVar == null || q.a(fVar.f)) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (fVar.f6614a > 0) {
                contentValues.put("_id", Long.valueOf(fVar.f6614a));
            }
            contentValues.put("_tp", fVar.f);
            contentValues.put("_tm", Long.valueOf(fVar.e));
            if (fVar.g != null) {
                contentValues.put("_dt", fVar.g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static f b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            f fVar = new f();
            fVar.f6614a = cursor.getLong(cursor.getColumnIndex("_id"));
            fVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            fVar.f = cursor.getString(cursor.getColumnIndex("_tp"));
            fVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return fVar;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private int f6612a;
        private c b;
        private String c;
        private ContentValues d;
        private boolean e;
        private String[] f;
        private String g;
        private String[] h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String[] n;
        private int o;
        private String p;
        private byte[] q;

        public a(int i, c cVar) {
            this.f6612a = i;
            this.b = cVar;
        }

        public final void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.e = z;
            this.c = str;
            this.f = strArr;
            this.g = str2;
            this.h = strArr2;
            this.i = str3;
            this.j = str4;
            this.k = str5;
            this.l = str6;
        }

        public final void a(int i, String str, byte[] bArr) {
            this.o = i;
            this.p = str;
            this.q = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f6612a) {
                case 1:
                    d.this.a(this.c, this.d, this.b);
                    return;
                case 2:
                    d.this.a(this.c, this.m, this.n, this.b);
                    return;
                case 3:
                    Cursor a2 = d.this.a(this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
                    if (a2 != null) {
                        a2.close();
                        return;
                    }
                    return;
                case 4:
                    d.this.a(this.o, this.p, this.q, this.b);
                    return;
                case 5:
                    d.this.a(this.o, this.b);
                    return;
                case 6:
                    d.this.a(this.o, this.p, this.b);
                    return;
                default:
                    return;
            }
        }
    }
}
