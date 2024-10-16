package com.helpshift.storage;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import com.helpshift.db.key_value.KeyValueDatabaseContract;
import com.helpshift.db.key_value.KeyValueDbStorageHelper;
import com.helpshift.util.HSLogger;

/* loaded from: classes2.dex */
public class RetryKeyValueDbStorage extends BaseRetryKeyValueStorage {
    private static final String backupFileName = "__hs__kv_backup";
    private final Context context;
    private SQLiteOpenHelper sqLiteOpenHelper;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetryKeyValueDbStorage(Context context) {
        this.context = context;
        this.sqLiteOpenHelper = new KeyValueDbStorageHelper(context, new KeyValueDatabaseContract());
        this.keyValueStorage = new KeyValueDbStorage(this.sqLiteOpenHelper);
    }

    @Override // com.helpshift.storage.BaseRetryKeyValueStorage
    protected void reInitiateDbInstance() {
        try {
            if (this.sqLiteOpenHelper != null) {
                this.sqLiteOpenHelper.close();
            }
        } catch (Exception e) {
            HSLogger.e("Helpshift_RetryKeyValue", "Error in closing DB", e);
        }
        this.sqLiteOpenHelper = new KeyValueDbStorageHelper(this.context, new KeyValueDatabaseContract());
        this.keyValueStorage = new KeyValueDbStorage(this.sqLiteOpenHelper);
    }
}
