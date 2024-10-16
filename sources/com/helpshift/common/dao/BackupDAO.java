package com.helpshift.common.dao;

import java.io.Serializable;

/* loaded from: classes2.dex */
public interface BackupDAO {
    void delete();

    Serializable getValue(String str);

    void removeKey(String str);

    void storeValue(String str, Serializable serializable);
}
