package com.uqm.crashsight.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class e extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static String f6613a = "crashSight_db";
    private static int b = 15;
    private Context c;
    private List<com.uqm.crashsight.a> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, List<com.uqm.crashsight.a> list) {
        super(context, f6613a + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, (SQLiteDatabase.CursorFactory) null, b);
        com.uqm.crashsight.crashreport.common.info.a.a(context).getClass();
        this.c = context;
        this.d = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_ui");
            sb.append(" ( _id");
            sb.append(" INTEGER PRIMARY KEY");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _ut");
            sb.append(" int");
            sb.append(" , _tp");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(" , _pc");
            sb.append(" text");
            sb.append(" ) ");
            m.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_lr");
            sb.append(" ( _id");
            sb.append(" INTEGER PRIMARY KEY");
            sb.append(" , _tp");
            sb.append(" int");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _pc");
            sb.append(" text");
            sb.append(" , _th");
            sb.append(" text");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(" ) ");
            m.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_pf");
            sb.append(" ( _id");
            sb.append(" integer");
            sb.append(" , _tp");
            sb.append(" text");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(",primary key(_id");
            sb.append(",_tp");
            sb.append(" )) ");
            m.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_cr");
            sb.append(" ( _id");
            sb.append(" INTEGER PRIMARY KEY");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _s1");
            sb.append(" text");
            sb.append(" , _up");
            sb.append(" int");
            sb.append(" , _me");
            sb.append(" int");
            sb.append(" , _uc");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(" ) ");
            m.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS dl_1002");
            sb.append(" (_id");
            sb.append(" integer primary key autoincrement, _dUrl");
            sb.append(" varchar(100), _sFile");
            sb.append(" varchar(100), _sLen");
            sb.append(" INTEGER, _tLen");
            sb.append(" INTEGER, _MD5");
            sb.append(" varchar(100), _DLTIME");
            sb.append(" INTEGER)");
            m.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ge_1002");
            sb.append(" (_id");
            sb.append(" integer primary key autoincrement, _time");
            sb.append(" INTEGER, _datas");
            sb.append(" blob)");
            m.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS st_1002");
            sb.append(" ( _id");
            sb.append(" integer");
            sb.append(" , _tp");
            sb.append(" text");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(",primary key(_id");
            sb.append(",_tp");
            sb.append(" )) ");
            m.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        } catch (Throwable th) {
            if (!m.b(th)) {
                th.printStackTrace();
            }
        }
        if (this.d == null) {
            return;
        }
        Iterator<com.uqm.crashsight.a> it = this.d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDbCreate(sQLiteDatabase);
            } catch (Throwable th2) {
                if (!m.b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            for (String str : new String[]{"t_lr", "t_ui", "t_pf"}) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str, new String[0]);
            }
        } catch (Throwable th) {
            if (!m.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m.d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.d != null) {
            Iterator<com.uqm.crashsight.a> it = this.d.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDbUpgrade(sQLiteDatabase, i, i2);
                } catch (Throwable th) {
                    if (!m.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
            return;
        }
        m.d("[Database] Failed to drop, delete db.", new Object[0]);
        File databasePath = this.c.getDatabasePath(f6613a);
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (com.uqm.crashsight.crashreport.common.info.c.c() >= 11) {
            m.d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.d != null) {
                Iterator<com.uqm.crashsight.a> it = this.d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbDowngrade(sQLiteDatabase, i, i2);
                    } catch (Throwable th) {
                        if (!m.b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            m.d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.c.getDatabasePath(f6613a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                m.d("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    m.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                m.d("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    m.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sQLiteDatabase == null) {
            m.d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }
}
