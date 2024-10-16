package com.helpshift.logger.database;

import com.helpshift.logger.model.LogModel;
import java.util.List;

/* loaded from: classes2.dex */
public interface LogStorage {
    void deleteAll();

    List<LogModel> getAll();

    void insert(LogModel logModel);
}
