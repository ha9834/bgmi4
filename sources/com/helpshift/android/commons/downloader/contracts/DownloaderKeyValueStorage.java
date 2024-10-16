package com.helpshift.android.commons.downloader.contracts;

import java.io.Serializable;

/* loaded from: classes2.dex */
public interface DownloaderKeyValueStorage {
    Object get(String str);

    boolean set(String str, Serializable serializable);
}
