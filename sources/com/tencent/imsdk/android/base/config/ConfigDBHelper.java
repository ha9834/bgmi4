package com.tencent.imsdk.android.base.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class ConfigDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "config.db";
    private static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME_CONFIG = "config";
    public static final String TABLE_NAME_USER_CONFIG = "user_config";

    public ConfigDBHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    private void onUpgrade(int i, SQLiteDatabase sQLiteDatabase) {
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS config(_id INTEGER PRIMARY KEY AUTOINCREMENT, key VARCHAR NOT NULL UNIQUE, value VARCHAR)");
                return;
            case 2:
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user_config(_id INTEGER PRIMARY KEY AUTOINCREMENT, key VARCHAR NOT NULL UNIQUE, value VARCHAR)");
                return;
            default:
                IMLogger.e("unknown database version : " + i, new Object[0]);
                return;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (int i = 1; i <= 2; i++) {
            onUpgrade(i, sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (true) {
            i++;
            if (i > 2) {
                return;
            } else {
                onUpgrade(i, sQLiteDatabase);
            }
        }
    }
}
