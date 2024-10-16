package com.tencent.hawk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.hawk.bridge.HawkLogger;

/* loaded from: classes2.dex */
public class DBHelper extends SQLiteOpenHelper {
    private boolean mIsDbInitSuccessed;
    private String mTable;

    public DBHelper(Context context, String str, String str2, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.mTable = null;
        this.mIsDbInitSuccessed = true;
        this.mTable = str2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        String str = "create table if not exists " + this.mTable + " (Id integer primary key," + DBInfoMeta.KEY_StepID + " integer," + DBInfoMeta.KEY_Status + " integer," + DBInfoMeta.KEY_Code + " integer," + DBInfoMeta.KEY_NetworkType + " integer," + DBInfoMeta.KEY_SessionId + " text," + DBInfoMeta.KEY_Linked_SessionId + " text," + DBInfoMeta.KEY_UniqueSessionId + " text," + DBInfoMeta.KEY_StepRand + " integer," + DBInfoMeta.KEY_StepTimeStamp + " integer," + DBInfoMeta.KEY_StepSpanTime + " integer," + DBInfoMeta.KEY_StepMsg + " text," + DBInfoMeta.KEY_ExtId + " text," + DBInfoMeta.KEY_Committed + " integer)";
        HawkLogger.i("DBHelper Create Table:" + str);
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            HawkLogger.e("DBHelper create table Exception");
            HawkLogger.e("DBHelper Exception Track: " + e.getMessage());
            this.mIsDbInitSuccessed = false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        HawkLogger.w("DBHelper Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.mTable);
        } catch (Exception e) {
            HawkLogger.e("DBHelper onUpgrade, Upgrading Exception");
            HawkLogger.i("DBHelper Exception Track: " + e.getMessage());
        }
        onCreate(sQLiteDatabase);
    }

    public boolean isDbSuccessed() {
        return this.mIsDbInitSuccessed;
    }
}
