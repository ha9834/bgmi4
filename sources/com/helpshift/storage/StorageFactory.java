package com.helpshift.storage;

import com.helpshift.util.HelpshiftContext;

/* loaded from: classes2.dex */
public class StorageFactory {
    private static StorageFactory storageFactoryInstance;
    public final KeyValueStorage keyValueStorage = new RetryKeyValueDbStorage(HelpshiftContext.getApplicationContext());

    StorageFactory() {
    }

    public static synchronized StorageFactory getInstance() {
        StorageFactory storageFactory;
        synchronized (StorageFactory.class) {
            if (storageFactoryInstance == null) {
                storageFactoryInstance = new StorageFactory();
            }
            storageFactory = storageFactoryInstance;
        }
        return storageFactory;
    }
}
