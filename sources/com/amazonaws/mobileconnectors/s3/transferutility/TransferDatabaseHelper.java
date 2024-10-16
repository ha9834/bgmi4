package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
class TransferDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "awss3transfertable.db";
    private static final int DATABASE_VERSION = 4;
    private int version;

    public TransferDatabaseHelper(Context context) {
        this(context, 4);
    }

    public TransferDatabaseHelper(Context context, int i) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, i);
        this.version = i;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        TransferTable.onCreate(sQLiteDatabase, this.version);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        TransferTable.onUpgrade(sQLiteDatabase, i, i2);
    }
}
