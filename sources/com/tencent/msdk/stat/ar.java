package com.tencent.msdk.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.msdk.stat.common.StatLogger;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ar extends SQLiteOpenHelper {

    /* renamed from: a */
    private String f6313a;
    private Context b;

    public ar(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
        StatLogger statLogger;
        this.f6313a = "";
        this.b = null;
        this.f6313a = str;
        this.b = context.getApplicationContext();
        if (StatConfig.isDebugEnable()) {
            statLogger = aj.h;
            statLogger.i("SQLiteOpenHelper " + this.f6313a);
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        Cursor cursor2 = null;
        String str = null;
        cursor2 = null;
        try {
            try {
                try {
                    cursor = sQLiteDatabase.query("user", null, null, null, null, null, null);
                } catch (Throwable th) {
                    statLogger = aj.h;
                    statLogger.e(th);
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (cursor.moveToNext()) {
                str = cursor.getString(0);
                cursor.getInt(1);
                cursor.getString(2);
                cursor.getLong(3);
                contentValues.put("uid", com.tencent.msdk.stat.common.p.b(str));
            }
            if (str != null) {
                sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
            }
        } catch (Throwable th4) {
            th = th4;
            cursor2 = cursor;
            statLogger2 = aj.h;
            statLogger2.e(th);
            if (cursor2 != null) {
                cursor2.close();
            }
            return;
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void b(SQLiteDatabase sQLiteDatabase) {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = sQLiteDatabase.query("events", null, null, null, null, null, null);
                    ArrayList<as> arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        arrayList.add(new as(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3)));
                    }
                    ContentValues contentValues = new ContentValues();
                    for (as asVar : arrayList) {
                        contentValues.put(FirebaseAnalytics.Param.CONTENT, com.tencent.msdk.stat.common.p.b(asVar.b));
                        sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(asVar.f6314a)});
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    statLogger3 = aj.h;
                    statLogger3.e(th);
                }
            } catch (Throwable th2) {
                statLogger2 = aj.h;
                statLogger2.e(th2);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th3) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th4) {
                    statLogger = aj.h;
                    statLogger.e(th4);
                }
            }
            throw th3;
        }
    }

    public boolean a() {
        StatLogger statLogger;
        if (StatConfig.isDebugEnable()) {
            statLogger = aj.h;
            statLogger.w("delete " + this.f6313a);
        }
        return this.b.deleteDatabase(this.f6313a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        StatLogger statLogger;
        statLogger = aj.h;
        statLogger.debug("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
        if (i == 2) {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
    }
}
