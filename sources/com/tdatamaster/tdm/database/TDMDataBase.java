package com.tdatamaster.tdm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tdatamaster.tdm.system.TDMLog;

/* loaded from: classes2.dex */
public class TDMDataBase {
    private static final String DBName = "tdm.db";
    private static final String DBTable = "DataMaster";
    private static final int DBVersion = 2;
    private static final String KEY_Data = "Data";
    private static final String KEY_EventID = "EventId";
    private static final String KEY_Len = "Len";
    private static final String KEY_SrcID = "SrcId";
    private static final String PKEY_ID = "Id";
    private static final String TAG = "TDMDataBase";
    private static TDMDataBase instance;
    private static Context mContext;
    private static DBHelper mDBHelper;
    private boolean mInitialized = false;

    private native void DataBaseInit();

    private TDMDataBase() {
    }

    public static TDMDataBase getInstance() {
        if (instance == null) {
            instance = new TDMDataBase();
        }
        return instance;
    }

    public void initialize(Context context) {
        if (this.mInitialized) {
            return;
        }
        mContext = context;
        DataBaseInit();
        this.mInitialized = true;
    }

    public boolean createDB() {
        Context context = mContext;
        if (context == null) {
            TDMLog.e(TAG, "createDB, mContext is null");
            return false;
        }
        if (mDBHelper != null) {
            return true;
        }
        mDBHelper = new DBHelper(context, DBName, DBTable, 2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getCount() {
        /*
            r6 = this;
            com.tdatamaster.tdm.database.DBHelper r0 = com.tdatamaster.tdm.database.TDMDataBase.mDBHelper
            r1 = -1
            if (r0 != 0) goto Ld
            java.lang.String r0 = "TDMDataBase"
            java.lang.String r2 = "mDBHelper is null, please call createDB first"
            com.tdatamaster.tdm.system.TDMLog.e(r0, r2)
            return r1
        Ld:
            r2 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Exception -> L13
            goto L32
        L13:
            r0 = move-exception
            java.lang.String r3 = "TDMDataBase"
            java.lang.String r4 = "getCount, GetDB Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r3, r4)
            java.lang.String r3 = "TDMDataBase"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Exception Track: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.tdatamaster.tdm.system.TDMLog.i(r3, r0)
            r0 = r2
        L32:
            if (r0 != 0) goto L3c
            java.lang.String r0 = "TDMDataBase"
            java.lang.String r2 = "getCount, db is null"
            com.tdatamaster.tdm.system.TDMLog.e(r0, r2)
            return r1
        L3c:
            java.lang.String r3 = "select Id from DataMaster"
            android.database.Cursor r2 = r0.rawQuery(r3, r2)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            int r1 = r2.getCount()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r2.close()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            if (r0 == 0) goto L79
        L4b:
            java.lang.String r2 = "TDMDataBase"
            java.lang.String r3 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r2, r3)
            r0.close()
            goto L79
        L56:
            r1 = move-exception
            goto L7a
        L58:
            r2 = move-exception
            java.lang.String r3 = "TDMDataBase"
            java.lang.String r4 = "getCount, Cursor Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r3, r4)     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = "TDMDataBase"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r4.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r5 = "Exception Track: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L56
            r4.append(r2)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L56
            com.tdatamaster.tdm.system.TDMLog.i(r3, r2)     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto L79
            goto L4b
        L79:
            return r1
        L7a:
            if (r0 == 0) goto L86
            java.lang.String r2 = "TDMDataBase"
            java.lang.String r3 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r2, r3)
            r0.close()
        L86:
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.database.TDMDataBase.getCount():int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean insertEvent(long j, int i, int i2, byte[] bArr, int i3) {
        SQLiteDatabase sQLiteDatabase;
        DBHelper dBHelper = mDBHelper;
        if (dBHelper == null) {
            TDMLog.e(TAG, "mDBHelper is null, please call createDB first");
            return false;
        }
        try {
            sQLiteDatabase = dBHelper.getWritableDatabase();
        } catch (Exception e) {
            TDMLog.e(TAG, "insertEvent, GetDB Exception");
            TDMLog.i(TAG, "Exception Track: " + e);
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            TDMLog.e(TAG, "insertEvent, db is null");
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id", Long.valueOf(j));
        contentValues.put(KEY_EventID, Integer.valueOf(i));
        contentValues.put(KEY_SrcID, Integer.valueOf(i2));
        contentValues.put(KEY_Len, Integer.valueOf(i3));
        contentValues.put(KEY_Data, bArr);
        try {
            try {
                sQLiteDatabase.insert(DBTable, null, contentValues);
                if (sQLiteDatabase == null) {
                    return true;
                }
            } catch (Exception e2) {
                TDMLog.e(TAG, "insertEvent, insert Exception");
                TDMLog.i(TAG, "Exception Track: " + e2);
                if (sQLiteDatabase == null) {
                    return true;
                }
            }
            TDMLog.i(TAG, "db.close");
            sQLiteDatabase.close();
            return true;
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                TDMLog.i(TAG, "db.close");
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0090, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean deleteTopEvent() {
        /*
            r7 = this;
            com.tdatamaster.tdm.database.DBHelper r0 = com.tdatamaster.tdm.database.TDMDataBase.mDBHelper
            r1 = 0
            if (r0 != 0) goto Ld
            java.lang.String r0 = "TDMDataBase"
            java.lang.String r2 = "mDBHelper is null, please call createDB first"
            com.tdatamaster.tdm.system.TDMLog.e(r0, r2)
            return r1
        Ld:
            r2 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Exception -> L13
            goto L32
        L13:
            r0 = move-exception
            java.lang.String r3 = "TDMDataBase"
            java.lang.String r4 = "deleteTopEvent, GetDB Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r3, r4)
            java.lang.String r3 = "TDMDataBase"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Exception Track: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.tdatamaster.tdm.system.TDMLog.i(r3, r0)
            r0 = r2
        L32:
            if (r0 != 0) goto L3c
            java.lang.String r0 = "TDMDataBase"
            java.lang.String r2 = "deleteTopEvent, db is null"
            com.tdatamaster.tdm.system.TDMLog.e(r0, r2)
            return r1
        L3c:
            java.lang.String r3 = "select Id from DataMaster order by Id DESC limit 1"
            android.database.Cursor r2 = r0.rawQuery(r3, r2)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            r4 = 1
            if (r3 == 0) goto L5d
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            long r5 = r2.getLong(r1)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            r3[r1] = r5     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            java.lang.String r5 = "DataMaster"
            java.lang.String r6 = "Id=?"
            r0.delete(r5, r6, r3)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            r1 = 1
        L5d:
            r2.close()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            if (r0 == 0) goto L90
        L62:
            java.lang.String r2 = "TDMDataBase"
            java.lang.String r3 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r2, r3)
            r0.close()
            goto L90
        L6d:
            r1 = move-exception
            goto L91
        L6f:
            r2 = move-exception
            java.lang.String r3 = "TDMDataBase"
            java.lang.String r4 = "deleteTopEvent, Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r3, r4)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = "TDMDataBase"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r4.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r5 = "Exception Track: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L6d
            r4.append(r2)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L6d
            com.tdatamaster.tdm.system.TDMLog.i(r3, r2)     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L90
            goto L62
        L90:
            return r1
        L91:
            if (r0 == 0) goto L9d
            java.lang.String r2 = "TDMDataBase"
            java.lang.String r3 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r2, r3)
            r0.close()
        L9d:
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.database.TDMDataBase.deleteTopEvent():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007b, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
    
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean deleteEvent(long r7) {
        /*
            r6 = this;
            com.tdatamaster.tdm.database.DBHelper r0 = com.tdatamaster.tdm.database.TDMDataBase.mDBHelper
            r1 = 0
            if (r0 != 0) goto Ld
            java.lang.String r7 = "TDMDataBase"
            java.lang.String r8 = "mDBHelper is null, please call createDB first"
            com.tdatamaster.tdm.system.TDMLog.e(r7, r8)
            return r1
        Ld:
            r2 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.getWritableDatabase()     // Catch: java.lang.Exception -> L13
            goto L31
        L13:
            r0 = move-exception
            java.lang.String r3 = "TDMDataBase"
            java.lang.String r4 = "deleteEvent, GetDB Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r3, r4)
            java.lang.String r3 = "TDMDataBase"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Exception Track: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.tdatamaster.tdm.system.TDMLog.i(r3, r0)
        L31:
            if (r2 != 0) goto L3b
            java.lang.String r7 = "TDMDataBase"
            java.lang.String r8 = "deleteEvent, db is null"
            com.tdatamaster.tdm.system.TDMLog.e(r7, r8)
            return r1
        L3b:
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3[r1] = r7
            java.lang.String r7 = "DataMaster"
            java.lang.String r8 = "Id=?"
            r2.delete(r7, r8, r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r2 == 0) goto L7b
        L4d:
            java.lang.String r7 = "TDMDataBase"
            java.lang.String r8 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r7, r8)
            r2.close()
            goto L7b
        L58:
            r7 = move-exception
            goto L7c
        L5a:
            r7 = move-exception
            java.lang.String r8 = "TDMDataBase"
            java.lang.String r1 = "deleteEvent, delete Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r8, r1)     // Catch: java.lang.Throwable -> L58
            java.lang.String r8 = "TDMDataBase"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58
            r1.<init>()     // Catch: java.lang.Throwable -> L58
            java.lang.String r3 = "Exception Track: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L58
            r1.append(r7)     // Catch: java.lang.Throwable -> L58
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L58
            com.tdatamaster.tdm.system.TDMLog.i(r8, r7)     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L7b
            goto L4d
        L7b:
            return r0
        L7c:
            if (r2 == 0) goto L88
            java.lang.String r8 = "TDMDataBase"
            java.lang.String r0 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r8, r0)
            r2.close()
        L88:
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.database.TDMDataBase.deleteEvent(long):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x009a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0097, code lost:
    
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.tdatamaster.tdm.defines.DBEvent getTopEvent() {
        /*
            r11 = this;
            com.tdatamaster.tdm.database.DBHelper r0 = com.tdatamaster.tdm.database.TDMDataBase.mDBHelper
            r1 = 0
            if (r0 != 0) goto Ld
            java.lang.String r0 = "TDMDataBase"
            java.lang.String r2 = "mDBHelper is null, please call createDB first"
            com.tdatamaster.tdm.system.TDMLog.e(r0, r2)
            return r1
        Ld:
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Exception -> L12
            goto L31
        L12:
            r0 = move-exception
            java.lang.String r2 = "TDMDataBase"
            java.lang.String r3 = "getTopEvent, GetDB Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r2, r3)
            java.lang.String r2 = "TDMDataBase"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Exception Track: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.tdatamaster.tdm.system.TDMLog.i(r2, r0)
            r0 = r1
        L31:
            if (r0 != 0) goto L3b
            java.lang.String r0 = "TDMDataBase"
            java.lang.String r2 = "getTopEvent, db is null"
            com.tdatamaster.tdm.system.TDMLog.e(r0, r2)
            return r1
        L3b:
            java.lang.String r2 = "select * from DataMaster order by Id DESC limit 1"
            android.database.Cursor r2 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            if (r3 == 0) goto L67
            com.tdatamaster.tdm.defines.DBEvent r3 = new com.tdatamaster.tdm.defines.DBEvent     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4 = 0
            long r5 = r2.getLong(r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4 = 1
            int r7 = r2.getInt(r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4 = 2
            int r8 = r2.getInt(r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4 = 3
            int r9 = r2.getInt(r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4 = 4
            byte[] r10 = r2.getBlob(r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4 = r3
            r4.<init>(r5, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r1 = r3
        L67:
            r2.close()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            if (r0 == 0) goto L9a
        L6c:
            java.lang.String r2 = "TDMDataBase"
            java.lang.String r3 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r2, r3)
            r0.close()
            goto L9a
        L77:
            r1 = move-exception
            goto L9b
        L79:
            r2 = move-exception
            java.lang.String r3 = "TDMDataBase"
            java.lang.String r4 = "getTopEvent, rawQuery Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r3, r4)     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = "TDMDataBase"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r4.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r5 = "Exception Track: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L77
            r4.append(r2)     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L77
            com.tdatamaster.tdm.system.TDMLog.i(r3, r2)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L9a
            goto L6c
        L9a:
            return r1
        L9b:
            if (r0 == 0) goto La7
            java.lang.String r2 = "TDMDataBase"
            java.lang.String r3 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r2, r3)
            r0.close()
        La7:
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.database.TDMDataBase.getTopEvent():com.tdatamaster.tdm.defines.DBEvent");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00cf, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cc, code lost:
    
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.tdatamaster.tdm.defines.DBEvent> getEvents(int r14) {
        /*
            r13 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.tdatamaster.tdm.database.DBHelper r1 = com.tdatamaster.tdm.database.TDMDataBase.mDBHelper
            if (r1 != 0) goto L11
            java.lang.String r14 = "TDMDataBase"
            java.lang.String r1 = "mDBHelper is null, please call createDB first"
            com.tdatamaster.tdm.system.TDMLog.e(r14, r1)
            return r0
        L11:
            r2 = 0
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Exception -> L17
            goto L36
        L17:
            r1 = move-exception
            java.lang.String r3 = "TDMDataBase"
            java.lang.String r4 = "getEvents, GetDB Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r3, r4)
            java.lang.String r3 = "TDMDataBase"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Exception Track: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.tdatamaster.tdm.system.TDMLog.i(r3, r1)
            r1 = r2
        L36:
            if (r1 != 0) goto L40
            java.lang.String r14 = "TDMDataBase"
            java.lang.String r1 = "getEvents, db is null"
            com.tdatamaster.tdm.system.TDMLog.e(r14, r1)
            return r0
        L40:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "select * from DataMaster order by Id DESC limit "
            r3.append(r4)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            android.database.Cursor r2 = r1.rawQuery(r3, r2)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            int r3 = r2.getCount()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            if (r3 > 0) goto L63
            java.lang.String r14 = "TDMDataBase"
            java.lang.String r3 = "getEvents, db is empty"
            com.tdatamaster.tdm.system.TDMLog.d(r14, r3)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            goto L9c
        L63:
            if (r14 >= r3) goto L66
            goto L67
        L66:
            r14 = r3
        L67:
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            if (r3 == 0) goto L9c
            r3 = 0
            r4 = 0
        L6f:
            if (r4 >= r14) goto L9c
            com.tdatamaster.tdm.defines.DBEvent r12 = new com.tdatamaster.tdm.defines.DBEvent     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            long r6 = r2.getLong(r3)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r5 = 1
            int r8 = r2.getInt(r5)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r5 = 2
            int r9 = r2.getInt(r5)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r5 = 3
            int r10 = r2.getInt(r5)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r5 = 4
            byte[] r11 = r2.getBlob(r5)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r5 = r12
            r5.<init>(r6, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r0.add(r12)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            boolean r5 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            if (r5 != 0) goto L99
            goto L9c
        L99:
            int r4 = r4 + 1
            goto L6f
        L9c:
            r2.close()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            if (r1 == 0) goto Lcf
        La1:
            java.lang.String r14 = "TDMDataBase"
            java.lang.String r2 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r14, r2)
            r1.close()
            goto Lcf
        Lac:
            r14 = move-exception
            goto Ld0
        Lae:
            r14 = move-exception
            java.lang.String r2 = "TDMDataBase"
            java.lang.String r3 = "getEvents, Cursor Exception"
            com.tdatamaster.tdm.system.TDMLog.e(r2, r3)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "TDMDataBase"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r3.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r4 = "Exception Track: "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lac
            r3.append(r14)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r14 = r3.toString()     // Catch: java.lang.Throwable -> Lac
            com.tdatamaster.tdm.system.TDMLog.i(r2, r14)     // Catch: java.lang.Throwable -> Lac
            if (r1 == 0) goto Lcf
            goto La1
        Lcf:
            return r0
        Ld0:
            if (r1 == 0) goto Ldc
            java.lang.String r0 = "TDMDataBase"
            java.lang.String r2 = "db.close"
            com.tdatamaster.tdm.system.TDMLog.i(r0, r2)
            r1.close()
        Ldc:
            throw r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.database.TDMDataBase.getEvents(int):java.util.ArrayList");
    }

    public void closeDB() {
        DBHelper dBHelper = mDBHelper;
        if (dBHelper == null) {
            TDMLog.w(TAG, "mDBHelper is null!");
            return;
        }
        try {
            dBHelper.close();
        } catch (Exception e) {
            TDMLog.e(TAG, "closeDB, close Exception");
            TDMLog.i(TAG, "Exception Track: " + e);
        }
    }
}
