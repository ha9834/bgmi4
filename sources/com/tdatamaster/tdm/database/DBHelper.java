package com.tdatamaster.tdm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tdatamaster.tdm.system.TDMLog;

/* loaded from: classes2.dex */
public class DBHelper extends SQLiteOpenHelper {
    private static final String KEY_Data = "Data";
    private static final String KEY_EventID = "EventId";
    private static final String KEY_Len = "Len";
    private static final String KEY_SrcID = "SrcId";
    private static final String PKEY_ID = "Id";
    private static final String TAG = "DBHelper";
    private String mTable;

    public DBHelper(Context context, String str, String str2, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.mTable = null;
        this.mTable = str2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        String str = "create table if not exists " + this.mTable + " (Id integer primary key," + KEY_EventID + " integer," + KEY_SrcID + " integer," + KEY_Len + " integer," + KEY_Data + " blob)";
        TDMLog.d(TAG, "Create Table:" + str);
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            TDMLog.e(TAG, "onCreate, create table Exception");
            TDMLog.i(TAG, "Exception Track: " + e);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        TDMLog.w(TAG, "Upgrading database from version " + i + " to " + i2);
        if (i == 1 && checkColumnExists(sQLiteDatabase, this.mTable, KEY_SrcID)) {
            TDMLog.d(TAG, "old version equals 1 and srcid column exits");
            onCreate(sQLiteDatabase);
            return;
        }
        try {
            TDMLog.d(TAG, "drop table");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.mTable);
        } catch (Exception e) {
            TDMLog.e(TAG, "onUpgrade, Upgrading Exception");
            TDMLog.i(TAG, "Exception Track: " + e);
        }
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        if (r1.isClosed() == false) goto L11;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkColumnExists(android.database.sqlite.SQLiteDatabase r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select * from sqlite_master where name = ? and sql like ?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r3[r0] = r7     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r7.<init>()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r4 = "%"
            r7.append(r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r7.append(r8)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r8 = "%"
            r7.append(r8)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r8 = 1
            r3[r8] = r7     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            android.database.Cursor r1 = r6.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            if (r1 == 0) goto L2f
            boolean r6 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            if (r6 == 0) goto L2f
            r0 = 1
        L2f:
            if (r1 == 0) goto L64
            boolean r6 = r1.isClosed()
            if (r6 != 0) goto L64
        L37:
            r1.close()
            goto L64
        L3b:
            r6 = move-exception
            goto L65
        L3d:
            r6 = move-exception
            java.lang.String r7 = "DBHelper"
            java.lang.String r8 = "checkColumnExists2 Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r7, r8)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r7 = "DBHelper"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            r8.<init>()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = "Exception Track: "
            r8.append(r2)     // Catch: java.lang.Throwable -> L3b
            r8.append(r6)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> L3b
            com.tdatamaster.tdm.system.TDMLog.i(r7, r6)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L64
            boolean r6 = r1.isClosed()
            if (r6 != 0) goto L64
            goto L37
        L64:
            return r0
        L65:
            if (r1 == 0) goto L70
            boolean r7 = r1.isClosed()
            if (r7 != 0) goto L70
            r1.close()
        L70:
            throw r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.database.DBHelper.checkColumnExists(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }
}
