package com.helpshift.db.base;

import java.util.List;

/* loaded from: classes2.dex */
public interface DatabaseContract {
    List<String> getCreateTableQueries();

    String getDatabaseName();

    int getDatabaseVersion();

    List<IMigrator> getMigratorsForUpgrade(int i);

    List<String> getTableNames();

    String getTag();
}
