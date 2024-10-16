package com.helpshift.android.commons.downloader.storage;

import com.helpshift.android.commons.downloader.contracts.DownloaderKeyValueStorage;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class BaseCacheDbStorage {
    private DownloaderKeyValueStorage keyValueStorage;

    abstract String getStorageKey();

    public BaseCacheDbStorage(DownloaderKeyValueStorage downloaderKeyValueStorage) {
        this.keyValueStorage = downloaderKeyValueStorage;
    }

    public String getFilePath(String str) {
        HashMap hashMap = (HashMap) this.keyValueStorage.get(getStorageKey());
        if (hashMap == null) {
            return null;
        }
        return (String) hashMap.get(str);
    }

    public void insertFilePath(String str, String str2) {
        HashMap hashMap = (HashMap) this.keyValueStorage.get(getStorageKey());
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put(str, str2);
        this.keyValueStorage.set(getStorageKey(), hashMap);
    }

    public void removeFilePath(String str) {
        HashMap hashMap = (HashMap) this.keyValueStorage.get(getStorageKey());
        if (hashMap != null) {
            hashMap.remove(str);
            this.keyValueStorage.set(getStorageKey(), hashMap);
        }
    }
}
