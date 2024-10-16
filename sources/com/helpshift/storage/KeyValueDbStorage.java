package com.helpshift.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.helpshift.db.key_value.tables.KeyValueTable;
import com.helpshift.util.ByteArrayUtil;
import com.helpshift.util.DatabaseUtils;
import com.helpshift.util.HSLogger;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes2.dex */
public class KeyValueDbStorage implements KeyValueStorage {
    private static final String TAG = "HS_KeyValueDB";
    private SQLiteOpenHelper helper;

    public KeyValueDbStorage(SQLiteOpenHelper sQLiteOpenHelper) {
        this.helper = sQLiteOpenHelper;
    }

    @Override // com.helpshift.storage.KeyValueStorage
    public boolean set(String str, Serializable serializable) {
        if (TextUtils.isEmpty(str) || serializable == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
        String[] strArr = {str};
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        try {
            contentValues.put("value", ByteArrayUtil.toByteArray(serializable));
            if (DatabaseUtils.exists(writableDatabase, KeyValueTable.TABLE_NAME, "key=?", strArr)) {
                writableDatabase.update(KeyValueTable.TABLE_NAME, contentValues, "key=?", strArr);
            } else if (writableDatabase.insert(KeyValueTable.TABLE_NAME, null, contentValues) == -1) {
                throw new SQLiteException("DB insert failed and return -1");
            }
            return true;
        } catch (IOException e) {
            HSLogger.e(TAG, "Error in serializing value", e);
            return false;
        }
    }

    @Override // com.helpshift.storage.KeyValueStorage
    public boolean setKeyValues(Map<String, Serializable> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
        SQLiteStatement compileStatement = writableDatabase.compileStatement("INSERT INTO key_value_store VALUES (?,?)");
        SQLiteStatement compileStatement2 = writableDatabase.compileStatement("UPDATE key_value_store SET value = ? WHERE key = ?");
        writableDatabase.beginTransaction();
        for (Map.Entry<String, Serializable> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                try {
                    String[] strArr = {entry.getKey()};
                    byte[] byteArray = ByteArrayUtil.toByteArray(entry.getValue());
                    if (DatabaseUtils.exists(writableDatabase, KeyValueTable.TABLE_NAME, "key=?", strArr)) {
                        compileStatement2.bindString(2, entry.getKey());
                        compileStatement2.bindBlob(1, byteArray);
                        compileStatement2.execute();
                        compileStatement2.clearBindings();
                    } else {
                        compileStatement.bindString(1, entry.getKey());
                        compileStatement.bindBlob(2, byteArray);
                        compileStatement.execute();
                        compileStatement.clearBindings();
                    }
                } catch (IOException e) {
                    HSLogger.e(TAG, "Error in serializing value", e);
                }
            }
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        return true;
    }

    @Override // com.helpshift.storage.KeyValueStorage
    public Object get(String str) {
        Cursor cursor = null;
        r1 = null;
        Object object = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cursor query = this.helper.getReadableDatabase().query(KeyValueTable.TABLE_NAME, null, "key=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    try {
                        object = ByteArrayUtil.toObject(query.getBlob(1));
                    } catch (Exception unused) {
                    }
                }
                if (query != null) {
                    query.close();
                }
                return object;
            } catch (Throwable th) {
                th = th;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.helpshift.storage.KeyValueStorage
    public void removeKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.helper.getWritableDatabase().delete(KeyValueTable.TABLE_NAME, "key=?", new String[]{str});
    }

    @Override // com.helpshift.storage.KeyValueStorage
    public void removeAllKeys() {
        this.helper.getWritableDatabase().delete(KeyValueTable.TABLE_NAME, null, null);
    }
}
