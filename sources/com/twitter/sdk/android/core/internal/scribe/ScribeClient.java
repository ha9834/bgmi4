package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.CommonUtils;
import com.twitter.sdk.android.core.internal.IdManager;
import com.twitter.sdk.android.core.internal.SystemCurrentTimeProvider;
import com.twitter.sdk.android.core.internal.persistence.FileStoreImpl;
import com.twitter.sdk.android.core.internal.scribe.ScribeEvent;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public class ScribeClient {
    private static final String STORAGE_DIR_BASE = "_se_to_send";
    private static final String WORKING_FILENAME_BASE = "_se.tap";
    private final TwitterAuthConfig authConfig;
    private final Context context;
    private final ScheduledExecutorService executor;
    private final GuestSessionProvider guestSessionProvider;
    private final IdManager idManager;
    private final ScribeConfig scribeConfig;
    final ConcurrentHashMap<Long, ScribeHandler> scribeHandlers = new ConcurrentHashMap<>(2);
    private final SessionManager<? extends Session<TwitterAuthToken>> sessionManager;
    private final ScribeEvent.Transform transform;

    public ScribeClient(Context context, ScheduledExecutorService scheduledExecutorService, ScribeConfig scribeConfig, ScribeEvent.Transform transform, TwitterAuthConfig twitterAuthConfig, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, IdManager idManager) {
        this.context = context;
        this.executor = scheduledExecutorService;
        this.scribeConfig = scribeConfig;
        this.transform = transform;
        this.authConfig = twitterAuthConfig;
        this.sessionManager = sessionManager;
        this.guestSessionProvider = guestSessionProvider;
        this.idManager = idManager;
    }

    public boolean scribe(ScribeEvent scribeEvent, long j) {
        try {
            getScribeHandler(j).scribe(scribeEvent);
            return true;
        } catch (IOException e) {
            CommonUtils.logControlledError(this.context, "Failed to scribe event", e);
            return false;
        }
    }

    public boolean scribeAndFlush(ScribeEvent scribeEvent, long j) {
        try {
            getScribeHandler(j).scribeAndFlush(scribeEvent);
            return true;
        } catch (IOException e) {
            CommonUtils.logControlledError(this.context, "Failed to scribe event", e);
            return false;
        }
    }

    ScribeHandler getScribeHandler(long j) throws IOException {
        if (!this.scribeHandlers.containsKey(Long.valueOf(j))) {
            this.scribeHandlers.putIfAbsent(Long.valueOf(j), newScribeHandler(j));
        }
        return this.scribeHandlers.get(Long.valueOf(j));
    }

    private ScribeHandler newScribeHandler(long j) throws IOException {
        Context context = this.context;
        ScribeFilesManager scribeFilesManager = new ScribeFilesManager(this.context, this.transform, new SystemCurrentTimeProvider(), new QueueFileEventStorage(context, new FileStoreImpl(context).getFilesDir(), getWorkingFileNameForOwner(j), getStorageDirForOwner(j)), this.scribeConfig.maxFilesToKeep);
        return new ScribeHandler(this.context, getScribeStrategy(j, scribeFilesManager), scribeFilesManager, this.executor);
    }

    EventsStrategy<ScribeEvent> getScribeStrategy(long j, ScribeFilesManager scribeFilesManager) {
        if (this.scribeConfig.isEnabled) {
            CommonUtils.logControlled(this.context, "Scribe enabled");
            Context context = this.context;
            ScheduledExecutorService scheduledExecutorService = this.executor;
            ScribeConfig scribeConfig = this.scribeConfig;
            return new EnabledScribeStrategy(context, scheduledExecutorService, scribeFilesManager, scribeConfig, new ScribeFilesSender(context, scribeConfig, j, this.authConfig, this.sessionManager, this.guestSessionProvider, scheduledExecutorService, this.idManager));
        }
        CommonUtils.logControlled(this.context, "Scribe disabled");
        return new DisabledEventsStrategy();
    }

    String getWorkingFileNameForOwner(long j) {
        return j + WORKING_FILENAME_BASE;
    }

    String getStorageDirForOwner(long j) {
        return j + STORAGE_DIR_BASE;
    }
}
