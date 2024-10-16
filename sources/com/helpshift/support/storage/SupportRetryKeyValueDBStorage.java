package com.helpshift.support.storage;

import android.content.Context;
import com.helpshift.storage.BaseRetryKeyValueStorage;
import com.helpshift.storage.KeyValueDbStorage;
import com.helpshift.support.db.support_key_value.SupportKeyValueDatabaseContract;
import com.helpshift.support.db.support_key_value.SupportKeyValueDbStorageHelper;
import com.helpshift.util.HSLogger;

/* loaded from: classes2.dex */
class SupportRetryKeyValueDBStorage extends BaseRetryKeyValueStorage {
    private final Context context;
    private SupportKeyValueDbStorageHelper sqLiteOpenHelper;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportRetryKeyValueDBStorage(Context context) {
        this.context = context;
        this.sqLiteOpenHelper = new SupportKeyValueDbStorageHelper(context, new SupportKeyValueDatabaseContract());
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
        this.sqLiteOpenHelper = new SupportKeyValueDbStorageHelper(this.context, new SupportKeyValueDatabaseContract());
        this.keyValueStorage = new KeyValueDbStorage(this.sqLiteOpenHelper);
    }
}
