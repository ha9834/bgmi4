package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CurrentTimeProvider;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
class ScribeFilesManager extends EventsFilesManager<ScribeEvent> {
    static final String FILE_EXTENSION = ".tap";
    static final String FILE_PREFIX = "se";

    public ScribeFilesManager(Context context, EventTransform<ScribeEvent> eventTransform, CurrentTimeProvider currentTimeProvider, QueueFileEventStorage queueFileEventStorage, int i) throws IOException {
        super(context, eventTransform, currentTimeProvider, queueFileEventStorage, i);
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsFilesManager
    protected String generateUniqueRollOverFileName() {
        return FILE_PREFIX + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + UUID.randomUUID().toString() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.currentTimeProvider.getCurrentTimeMillis() + FILE_EXTENSION;
    }
}
