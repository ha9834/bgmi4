package com.twitter.sdk.android.core.internal.scribe;

/* loaded from: classes.dex */
public interface EventsStrategy<T> extends EventsManager<T>, FileRollOverManager {
    FilesSender getFilesSender();
}
