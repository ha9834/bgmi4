package com.tencent.hawk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.hawk.bridge.HawkLogger;
import com.tencent.hawk.streamevent.StepInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DMLProcessor {
    private static DMLProcessor instance;
    private static Context mContext;
    private static DBHelper mDBHelper;
    private boolean mInitialized = false;

    public static DMLProcessor getInstance() {
        if (instance == null) {
            instance = new DMLProcessor();
        }
        return instance;
    }

    public void initialize(Context context) {
        if (this.mInitialized) {
            return;
        }
        mContext = context;
        this.mInitialized = true;
    }

    public boolean createDB() {
        Context context = mContext;
        if (context == null) {
            HawkLogger.e("TApmDB createDB, mContext is null");
            return false;
        }
        if (mDBHelper != null) {
            return true;
        }
        mDBHelper = new DBHelper(context, DBInfoMeta.DBName, DBInfoMeta.DBTable, 3);
        return mDBHelper.isDbSuccessed();
    }

    public int getCount() {
        SQLiteDatabase sQLiteDatabase;
        DBHelper dBHelper = mDBHelper;
        int i = -1;
        if (dBHelper == null) {
            HawkLogger.e("DBHelper is null, please call createDB first");
            return -1;
        }
        try {
            sQLiteDatabase = dBHelper.getReadableDatabase();
        } catch (Exception e) {
            HawkLogger.e("TApmDB, getCount, GetDB Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e);
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            HawkLogger.e("TApmDB, getCount, db is null");
            return -1;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select Id from StepEventTbl", null);
            i = rawQuery.getCount();
            rawQuery.close();
            return i;
        } catch (Exception e2) {
            HawkLogger.e("TApmDB, getCount, Cursor Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e2);
            return i;
        }
    }

    public boolean saveStepInfo(StepInfo stepInfo) {
        DBHelper dBHelper = mDBHelper;
        if (dBHelper == null) {
            HawkLogger.e("TApmDB, mDBHelper is null, please call createDB first");
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = dBHelper.getWritableDatabase();
        } catch (Exception e) {
            HawkLogger.e("TApmDB, insertEvent, GetDB Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e);
        }
        if (sQLiteDatabase == null) {
            HawkLogger.e("TApmDB, insertEvent, db is null");
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBInfoMeta.KEY_StepID, Integer.valueOf(stepInfo.stepId));
        contentValues.put(DBInfoMeta.KEY_Status, Integer.valueOf(stepInfo.stepStatus));
        contentValues.put(DBInfoMeta.KEY_Code, Integer.valueOf(stepInfo.stepCode));
        contentValues.put(DBInfoMeta.KEY_NetworkType, Integer.valueOf(stepInfo.networkType));
        contentValues.put(DBInfoMeta.KEY_SessionId, stepInfo.sessionId);
        contentValues.put(DBInfoMeta.KEY_Linked_SessionId, stepInfo.linkedSessionId);
        contentValues.put(DBInfoMeta.KEY_UniqueSessionId, stepInfo.uniqueSessionId);
        contentValues.put(DBInfoMeta.KEY_StepRand, Integer.valueOf(stepInfo.stepRandom));
        contentValues.put(DBInfoMeta.KEY_StepTimeStamp, Long.valueOf(stepInfo.stepTime));
        contentValues.put(DBInfoMeta.KEY_StepSpanTime, Long.valueOf(stepInfo.stepSpanTime));
        contentValues.put(DBInfoMeta.KEY_StepMsg, stepInfo.stepMsg);
        contentValues.put(DBInfoMeta.KEY_ExtId, stepInfo.extDefinedKey);
        contentValues.put(DBInfoMeta.KEY_ExtId, Integer.valueOf(stepInfo.isCommitted ? 1 : 0));
        try {
            long replace = sQLiteDatabase.replace(DBInfoMeta.DBTable, "Id", contentValues);
            if (replace < 0) {
                return false;
            }
            HawkLogger.d("insert streamevent successed: " + replace);
            stepInfo.autoId = replace;
            return true;
        } catch (Exception e2) {
            HawkLogger.e("TApmDB, insertStreamEvent error");
            HawkLogger.i("TApmDB, Exception Track: " + e2);
            return true;
        }
    }

    public boolean deleteStepInfo(long j) {
        DBHelper dBHelper = mDBHelper;
        if (dBHelper == null) {
            HawkLogger.e("TApmDB, mDBHelper is null, please call createDB first");
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = dBHelper.getWritableDatabase();
        } catch (Exception e) {
            HawkLogger.e("TApmDB, deleteEvent, GetDB Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e);
        }
        if (sQLiteDatabase == null) {
            HawkLogger.e("TApmDB, deleteEvent, db is null");
            return false;
        }
        try {
            sQLiteDatabase.delete(DBInfoMeta.DBTable, "Id=?", new String[]{String.valueOf(j)});
        } catch (Exception e2) {
            HawkLogger.e("TApmDB, deleteEvent, delete Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e2);
        }
        return true;
    }

    public StepInfo getTopEvent() {
        SQLiteDatabase sQLiteDatabase;
        DBHelper dBHelper = mDBHelper;
        if (dBHelper == null) {
            HawkLogger.e("TApmDB, mDBHelper is null, please call createDB first");
            return null;
        }
        try {
            sQLiteDatabase = dBHelper.getReadableDatabase();
        } catch (Exception e) {
            HawkLogger.e("TApmDB, getTopEvent, GetDB Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e);
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            HawkLogger.e("TApmDB, getTopEvent, db is null");
            return null;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from DataMaster order by Id DESC limit 1", null);
            rawQuery.moveToFirst();
            rawQuery.close();
        } catch (Exception e2) {
            HawkLogger.e("TApmDB, getTopEvent, rawQuery Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e2);
        }
        return null;
    }

    public List<StepInfo> getLocalPendingEvents() {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        DBHelper dBHelper = mDBHelper;
        if (dBHelper == null) {
            HawkLogger.e("TApmDB, mDBHelper is null, please call createDB first");
            return arrayList;
        }
        try {
            sQLiteDatabase = dBHelper.getReadableDatabase();
        } catch (Exception e) {
            HawkLogger.e("TApmDB, getEvents, GetDB Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e);
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            HawkLogger.e("TApmDB, getEvents, db is null");
            return arrayList;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from StepEventTbl order by Id DESC ", null);
            int count = rawQuery.getCount();
            if (count <= 0) {
                HawkLogger.d("TApmDB, getEvents, db is empty");
            } else if (rawQuery.moveToFirst()) {
                for (int i = 0; i < count; i++) {
                    StepInfo stepInfo = new StepInfo();
                    stepInfo.autoId = rawQuery.getLong(0);
                    stepInfo.stepId = rawQuery.getInt(1);
                    stepInfo.stepStatus = rawQuery.getInt(2);
                    stepInfo.stepCode = rawQuery.getInt(3);
                    stepInfo.networkType = rawQuery.getInt(4);
                    stepInfo.sessionId = rawQuery.getString(5);
                    stepInfo.linkedSessionId = rawQuery.getString(6);
                    stepInfo.uniqueSessionId = rawQuery.getString(7);
                    stepInfo.stepRandom = rawQuery.getInt(8);
                    stepInfo.stepTime = rawQuery.getLong(9);
                    stepInfo.stepSpanTime = rawQuery.getLong(10);
                    stepInfo.stepMsg = rawQuery.getString(11);
                    stepInfo.extDefinedKey = rawQuery.getString(12);
                    stepInfo.isCommitted = rawQuery.getInt(13) != 0;
                    arrayList.add(stepInfo);
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                }
            }
            rawQuery.close();
        } catch (Exception e2) {
            HawkLogger.e("TApmDB, getEvents, Cursor Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e2);
        }
        return arrayList;
    }

    public void closeDB() {
        DBHelper dBHelper = mDBHelper;
        if (dBHelper == null) {
            HawkLogger.w("TApmDB, mDBHelper is null!");
            return;
        }
        try {
            dBHelper.close();
        } catch (Exception e) {
            HawkLogger.e("TApmDB, closeDB, close Exception");
            HawkLogger.i("TApmDB, Exception Track: " + e);
        }
    }
}
