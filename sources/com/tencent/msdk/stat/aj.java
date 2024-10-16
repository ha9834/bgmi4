package com.tencent.msdk.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.connect.common.Constants;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.msdk.stat.common.StatConstants;
import com.tencent.msdk.stat.common.StatLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class aj {
    private static StatLogger h = com.tencent.msdk.stat.common.j.b();
    private static Context i = null;
    private static int j = 307200;
    private static aj k = null;
    private ar c;
    private ar d;
    private Handler e;
    private String f;
    private String g;
    private ConcurrentHashMap<com.tencent.msdk.stat.a.d, String> m;

    /* renamed from: a, reason: collision with root package name */
    volatile int f6305a = 0;
    com.tencent.msdk.stat.common.a b = null;
    private int l = 0;
    private boolean n = false;
    private HashMap<String, String> o = new HashMap<>();

    private aj(Context context) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = "";
        this.g = "";
        this.m = null;
        try {
            HandlerThread handlerThread = new HandlerThread("StatStore");
            handlerThread.start();
            this.e = new Handler(handlerThread.getLooper());
            i = context.getApplicationContext();
            this.m = new ConcurrentHashMap<>();
            this.f = com.tencent.msdk.stat.common.j.q(context);
            this.g = "pri_" + com.tencent.msdk.stat.common.j.q(context);
            this.c = new ar(i, this.f);
            this.d = new ar(i, this.g);
            f();
            b(true);
            b(false);
            g();
            b(i);
            d();
            k();
        } catch (Throwable th) {
            h.e(th);
        }
    }

    public static aj a(Context context) {
        if (k == null) {
            synchronized (aj.class) {
                if (k == null) {
                    k = new aj(context);
                }
            }
        }
        return k;
    }

    private String a(String str) {
        return StatConstants.MTA_DB2SP_TAG + str;
    }

    private String a(List<as> list) {
        StringBuilder sb = new StringBuilder(list.size() * 3);
        sb.append("event_id in (");
        int size = list.size();
        Iterator<as> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            sb.append(it.next().f6314a);
            if (i2 != size - 1) {
                sb.append(",");
            }
            i2++;
        }
        sb.append(")");
        return sb.toString();
    }

    private synchronized void a(int i2, boolean z) {
        try {
        } catch (Throwable th) {
            h.e(th);
        }
        if (this.f6305a > 0 && i2 > 0 && !StatServiceImpl.a()) {
            if (StatConfig.isDebugEnable()) {
                h.i("Load " + this.f6305a + " unsent events");
            }
            ArrayList arrayList = new ArrayList(i2);
            b(arrayList, i2, z);
            if (arrayList.size() > 0) {
                if (StatConfig.isDebugEnable()) {
                    h.i("Peek " + arrayList.size() + " unsent events.");
                }
                a(arrayList, 2, z);
                k.b(i).b(arrayList, new ap(this, arrayList, z));
            }
        }
    }

    private void a(Context context, String str, int i2, long j2) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(a("uid"), str);
        hashMap.put(a("user_type"), Integer.valueOf(i2));
        hashMap.put(a(Constants.PARAM_APP_VER), com.tencent.msdk.stat.common.j.m(context));
        hashMap.put(a("ts"), Long.valueOf(j2));
        com.tencent.msdk.stat.common.o.a(context, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.msdk.stat.common.StatLogger] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.tencent.msdk.stat.a.d r10, com.tencent.msdk.stat.j r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.msdk.stat.aj.a(com.tencent.msdk.stat.a.d, com.tencent.msdk.stat.j, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a(List<as> list, int i2, boolean z) {
        SQLiteDatabase sQLiteDatabase;
        StatLogger statLogger;
        String str;
        if (list.size() == 0) {
            return;
        }
        int c = c(z);
        SQLiteDatabase sQLiteDatabase2 = null;
        String str2 = null;
        String str3 = null;
        SQLiteDatabase sQLiteDatabase3 = null;
        try {
            try {
                sQLiteDatabase = d(z);
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = sQLiteDatabase2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (i2 == 2) {
                str = "update events set status=" + i2 + ", send_count=send_count+1  where " + a(list);
            } else {
                str = "update events set status=" + i2 + " where " + a(list);
                if (this.l % 3 == 0) {
                    str3 = "delete from events where send_count>" + c;
                }
                this.l++;
                str2 = str3;
            }
            if (StatConfig.isDebugEnable()) {
                h.i("update sql:" + str);
            }
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL(str);
            if (str2 != null) {
                h.i("update for delete sql:" + str2);
                sQLiteDatabase.execSQL(str2);
                g();
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase2 = str2;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                    sQLiteDatabase2 = str2;
                } catch (Throwable th3) {
                    th = th3;
                    statLogger = h;
                    statLogger.e(th);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th5) {
                    h.e(th5);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(java.util.List<com.tencent.msdk.stat.as> r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.msdk.stat.aj.a(java.util.List, boolean):void");
    }

    private boolean a(boolean z) {
        try {
            SQLiteDatabase d = d(z);
            d.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(FirebaseAnalytics.Param.CONTENT, MConstants.TestEnv);
            contentValues.put("send_count", CocosPayHelper.AP_MIDAS_RESP_RESULT_CHANNEL_ERR);
            contentValues.put("status", Integer.toString(1));
            contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            d.insert("events", null, contentValues);
            d.setTransactionSuccessful();
            d.endTransaction();
            int delete = d.delete("events", "content = ?", new String[]{MConstants.TestEnv});
            Cursor query = d.query("events", null, "content=?", new String[]{MConstants.TestEnv}, null, null, null, "1");
            int count = query.getCount();
            query.close();
            if (StatConfig.isDebugEnable()) {
                h.i("delNum=" + delete + ",queryNum=" + count);
            }
            if (delete == 0 || count > 0) {
                throw new SQLException("test delete error.");
            }
            if (StatConfig.isDebugEnable()) {
                String[] split = d.getPath().split("/");
                h.i("test db passed, db name:" + split[split.length - 1]);
            }
            return true;
        } catch (SQLiteFullException unused) {
            h.warn("db is full, change to INSTANT");
            StatConfig.setReportEventsByOrder(false);
            StatConfig.setStatSendStrategy(StatReportStrategy.INSTANT);
            return true;
        } catch (Throwable th) {
            h.e(th);
            return false;
        }
    }

    public static aj b() {
        return k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, boolean z) {
        if (i2 == -1) {
            i2 = !z ? h() : i();
        }
        if (i2 > 0) {
            int sendPeriodMinutes = StatConfig.getSendPeriodMinutes() * 60 * StatConfig.getNumEventsCommitPerSec();
            if (i2 > sendPeriodMinutes && sendPeriodMinutes > 0) {
                i2 = sendPeriodMinutes;
            }
            int a2 = StatConfig.a();
            int i3 = i2 / a2;
            int i4 = i2 % a2;
            if (StatConfig.isDebugEnable()) {
                h.i("sentStoreEventsByDb sendNumbers=" + i2 + ",important=" + z + ",maxSendNumPerFor1Period=" + sendPeriodMinutes + ",maxCount=" + i3 + ",restNumbers=" + i4);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                a(a2, z);
            }
            if (i4 > 0) {
                a(i4, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.tencent.msdk.stat.a.d dVar, j jVar, boolean z, boolean z2) {
        if (StatConfig.getMaxStoreEventCount() > 0) {
            if (StatConfig.m > 0 && !z && !z2) {
                if (StatConfig.m > 0) {
                    if (StatConfig.isDebugEnable()) {
                        h.i("cacheEventsInMemory.size():" + this.m.size() + ",numEventsCachedInMemory:" + StatConfig.m + ",numStoredEvents:" + this.f6305a);
                        StatLogger statLogger = h;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cache event:");
                        sb.append(dVar.g());
                        statLogger.i(sb.toString());
                    }
                    this.m.put(dVar, "");
                    if (this.m.size() >= StatConfig.m) {
                        j();
                    }
                    if (jVar != null) {
                        if (this.m.size() > 0) {
                            j();
                        }
                        jVar.a();
                    }
                }
            }
            a(dVar, jVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void b(h hVar) {
        Cursor cursor;
        StatLogger statLogger;
        boolean z;
        long insert;
        Cursor cursor2 = null;
        try {
            try {
                String a2 = hVar.a();
                String a3 = com.tencent.msdk.stat.common.j.a(a2);
                ContentValues contentValues = new ContentValues();
                contentValues.put(FirebaseAnalytics.Param.CONTENT, hVar.b.toString());
                contentValues.put("md5sum", a3);
                hVar.c = a3;
                contentValues.put("version", Integer.valueOf(hVar.d));
                cursor = this.c.getReadableDatabase().query(ConfigDBHelper.TABLE_NAME_CONFIG, null, null, null, null, null, null);
                while (true) {
                    try {
                        if (!cursor.moveToNext()) {
                            z = false;
                            break;
                        } else if (cursor.getInt(0) == hVar.f6329a) {
                            z = true;
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        h.e(th);
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Throwable th2) {
                                h.e(th2);
                            }
                        }
                        try {
                            this.c.getWritableDatabase().endTransaction();
                        } catch (Throwable th3) {
                            th = th3;
                            statLogger = h;
                            statLogger.e(th);
                        }
                    }
                }
                this.c.getWritableDatabase().beginTransaction();
                if (true == z) {
                    insert = this.c.getWritableDatabase().update(ConfigDBHelper.TABLE_NAME_CONFIG, contentValues, "type=?", new String[]{Integer.toString(hVar.f6329a)});
                } else {
                    contentValues.put("type", Integer.valueOf(hVar.f6329a));
                    insert = this.c.getWritableDatabase().insert(ConfigDBHelper.TABLE_NAME_CONFIG, null, contentValues);
                }
                if (insert == -1) {
                    h.e("Failed to store cfg:" + a2);
                } else {
                    h.d("Sucessed to store cfg:" + a2);
                }
                this.c.getWritableDatabase().setTransactionSuccessful();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th4) {
                        h.e(th4);
                    }
                }
                try {
                    this.c.getWritableDatabase().endTransaction();
                } catch (Throwable th5) {
                    th = th5;
                    statLogger = h;
                    statLogger.e(th);
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            cursor = cursor2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void b(List<as> list, int i2, boolean z) {
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = e(z).query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i2));
                    while (cursor.moveToNext()) {
                        long j2 = cursor.getLong(0);
                        String string = cursor.getString(1);
                        if (!StatConfig.g) {
                            string = com.tencent.msdk.stat.common.p.a(string);
                        }
                        String str = string;
                        int i3 = cursor.getInt(2);
                        int i4 = cursor.getInt(3);
                        as asVar = new as(j2, str, i3, i4);
                        if (StatConfig.isDebugEnable()) {
                            h.i("peek event, id=" + j2 + ",send_count=" + i4 + ",timestamp=" + cursor.getLong(4));
                        }
                        list.add(asVar);
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th2) {
                            h.e(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                h.e(th3);
                if (cursor == null) {
                    return;
                } else {
                    cursor.close();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th4) {
            h.e(th4);
        }
    }

    private void b(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                try {
                    sQLiteDatabase = d(z);
                    sQLiteDatabase.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("status", (Integer) 1);
                    int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2L)});
                    if (StatConfig.isDebugEnable()) {
                        h.i("update " + update + " unsent events.");
                    }
                    sQLiteDatabase.execSQL("delete from events where timestamp<" + ((System.currentTimeMillis() / 1000) - 604800) + "  or length(content) >" + j);
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.setTransactionSuccessful();
                        } catch (Exception unused) {
                        }
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Throwable th) {
                    h.e(th);
                }
            } catch (Throwable th2) {
                h.e(th2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Exception unused2) {
                    }
                    sQLiteDatabase.endTransaction();
                }
            }
        } catch (Throwable th3) {
            if (sQLiteDatabase != null) {
                try {
                    try {
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Exception unused3) {
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th4) {
                    h.e(th4);
                    throw th3;
                }
            }
            throw th3;
        }
    }

    private int c(boolean z) {
        return !z ? StatConfig.getMaxSendRetryCount() : StatConfig.getMaxImportantDataSendRetryCount();
    }

    private boolean c(Context context) {
        return com.tencent.msdk.stat.common.o.a(context, a("uid")) || com.tencent.msdk.stat.common.o.a(context, a("user_type")) || com.tencent.msdk.stat.common.o.a(context, a(Constants.PARAM_APP_VER)) || com.tencent.msdk.stat.common.o.a(context, a("ts"));
    }

    private SQLiteDatabase d(boolean z) {
        return (!z ? this.c : this.d).getWritableDatabase();
    }

    private SQLiteDatabase e(boolean z) {
        return (!z ? this.c : this.d).getReadableDatabase();
    }

    private void f() {
        try {
            if (!a(false)) {
                h.warn("delete " + ar.a(this.c) + ", and create new one");
                this.c.a();
                this.c = new ar(i, this.f);
            }
            if (a(true)) {
                return;
            }
            h.warn("delete " + ar.a(this.d) + ", and create new one");
            this.d.a();
            this.d = new ar(i, this.g);
        } catch (Throwable th) {
            h.e(th);
        }
    }

    private void g() {
        this.f6305a = h() + i();
    }

    private int h() {
        try {
            return (int) DatabaseUtils.queryNumEntries(this.c.getReadableDatabase(), "events");
        } catch (Throwable th) {
            h.e(th);
            return 0;
        }
    }

    private int i() {
        try {
            return (int) DatabaseUtils.queryNumEntries(this.d.getReadableDatabase(), "events");
        } catch (Throwable th) {
            h.e(th);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0106 A[Catch: all -> 0x0148, TryCatch #5 {, blocks: (B:8:0x0008, B:10:0x0010, B:12:0x0012, B:14:0x001b, B:44:0x00d4, B:38:0x00fd, B:40:0x0106, B:41:0x0136, B:47:0x00dc, B:48:0x00de, B:54:0x013a, B:52:0x0147, B:57:0x0142, B:63:0x00f2, B:66:0x00fa), top: B:7:0x0008, inners: #0, #3, #7 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j() {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.msdk.stat.aj.j():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void k() {
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = this.c.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
                    while (cursor.moveToNext()) {
                        this.o.put(cursor.getString(0), cursor.getString(1));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    h.e(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Throwable th2) {
                h.e(th2);
            }
        } catch (Throwable th3) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th4) {
                    h.e(th4);
                }
            }
            throw th3;
        }
    }

    public int a() {
        return this.f6305a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2) {
        this.e.post(new aq(this, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.tencent.msdk.stat.a.d dVar, j jVar, boolean z, boolean z2) {
        Handler handler = this.e;
        if (handler != null) {
            handler.post(new an(this, dVar, jVar, z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        if (hVar == null) {
            return;
        }
        this.e.post(new ao(this, hVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<as> list, int i2, boolean z, boolean z2) {
        Handler handler = this.e;
        if (handler != null) {
            handler.post(new ak(this, list, i2, z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<as> list, boolean z, boolean z2) {
        Handler handler = this.e;
        if (handler != null) {
            handler.post(new al(this, list, z, z2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01d7 A[Catch: all -> 0x02e3, Throwable -> 0x02e6, TryCatch #8 {all -> 0x02e3, Throwable -> 0x02e6, blocks: (B:66:0x0145, B:68:0x014b, B:70:0x0168, B:73:0x017d, B:75:0x0187, B:76:0x0189, B:78:0x0191, B:80:0x0194, B:82:0x0198, B:87:0x01b7, B:89:0x01ba, B:90:0x01f2, B:92:0x0224, B:94:0x0237, B:95:0x0242, B:97:0x0251, B:99:0x025b, B:101:0x0261, B:102:0x0277, B:104:0x02c4, B:114:0x01d1, B:116:0x01d7, B:118:0x01dd, B:119:0x01a1, B:121:0x01a7, B:125:0x01af), top: B:65:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0109 A[Catch: all -> 0x0320, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0009, B:10:0x000d, B:12:0x001c, B:14:0x0022, B:15:0x0029, B:17:0x0062, B:20:0x0077, B:22:0x0081, B:23:0x0084, B:25:0x008c, B:27:0x008f, B:29:0x0093, B:32:0x00af, B:34:0x00b2, B:35:0x00ea, B:37:0x00f7, B:39:0x00fd, B:41:0x0109, B:42:0x0306, B:45:0x00c9, B:47:0x00cf, B:49:0x00d5, B:50:0x0099, B:52:0x009f, B:56:0x00a7, B:112:0x02cf, B:106:0x02d2, B:109:0x02dd, B:110:0x02df, B:138:0x030c, B:131:0x030f, B:135:0x031f, B:134:0x031a, B:148:0x02f5, B:143:0x02f8, B:146:0x0303), top: B:3:0x0005, inners: #2, #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b7 A[Catch: all -> 0x02e3, Throwable -> 0x02e6, TryCatch #8 {all -> 0x02e3, Throwable -> 0x02e6, blocks: (B:66:0x0145, B:68:0x014b, B:70:0x0168, B:73:0x017d, B:75:0x0187, B:76:0x0189, B:78:0x0191, B:80:0x0194, B:82:0x0198, B:87:0x01b7, B:89:0x01ba, B:90:0x01f2, B:92:0x0224, B:94:0x0237, B:95:0x0242, B:97:0x0251, B:99:0x025b, B:101:0x0261, B:102:0x0277, B:104:0x02c4, B:114:0x01d1, B:116:0x01d7, B:118:0x01dd, B:119:0x01a1, B:121:0x01a7, B:125:0x01af), top: B:65:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0224 A[Catch: all -> 0x02e3, Throwable -> 0x02e6, TryCatch #8 {all -> 0x02e3, Throwable -> 0x02e6, blocks: (B:66:0x0145, B:68:0x014b, B:70:0x0168, B:73:0x017d, B:75:0x0187, B:76:0x0189, B:78:0x0191, B:80:0x0194, B:82:0x0198, B:87:0x01b7, B:89:0x01ba, B:90:0x01f2, B:92:0x0224, B:94:0x0237, B:95:0x0242, B:97:0x0251, B:99:0x025b, B:101:0x0261, B:102:0x0277, B:104:0x02c4, B:114:0x01d1, B:116:0x01d7, B:118:0x01dd, B:119:0x01a1, B:121:0x01a7, B:125:0x01af), top: B:65:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0237 A[Catch: all -> 0x02e3, Throwable -> 0x02e6, TryCatch #8 {all -> 0x02e3, Throwable -> 0x02e6, blocks: (B:66:0x0145, B:68:0x014b, B:70:0x0168, B:73:0x017d, B:75:0x0187, B:76:0x0189, B:78:0x0191, B:80:0x0194, B:82:0x0198, B:87:0x01b7, B:89:0x01ba, B:90:0x01f2, B:92:0x0224, B:94:0x0237, B:95:0x0242, B:97:0x0251, B:99:0x025b, B:101:0x0261, B:102:0x0277, B:104:0x02c4, B:114:0x01d1, B:116:0x01d7, B:118:0x01dd, B:119:0x01a1, B:121:0x01a7, B:125:0x01af), top: B:65:0x0145 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.tencent.msdk.stat.common.a b(android.content.Context r23) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.msdk.stat.aj.b(android.content.Context):com.tencent.msdk.stat.common.a");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (StatConfig.isEnableStatService()) {
            try {
                this.e.post(new am(this));
            } catch (Throwable th) {
                h.e(th);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void d() {
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = this.c.getReadableDatabase().query(ConfigDBHelper.TABLE_NAME_CONFIG, null, null, null, null, null, null);
                    while (cursor.moveToNext()) {
                        int i2 = cursor.getInt(0);
                        String string = cursor.getString(1);
                        String string2 = cursor.getString(2);
                        int i3 = cursor.getInt(3);
                        h hVar = new h(i2);
                        hVar.f6329a = i2;
                        hVar.b = new JSONObject(string);
                        hVar.c = string2;
                        hVar.d = i3;
                        StatConfig.a(i, hVar);
                    }
                } catch (Throwable th) {
                    h.e(th);
                    if (cursor == null) {
                        return;
                    } else {
                        cursor.close();
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th3) {
                        h.e(th3);
                    }
                }
                throw th2;
            }
        } catch (Throwable th4) {
            h.e(th4);
        }
    }
}
