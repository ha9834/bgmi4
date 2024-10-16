package com.helpshift.db.base;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes2.dex */
public interface IMigrator {
    void migrate(SQLiteDatabase sQLiteDatabase) throws Exception;
}
