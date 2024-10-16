package com.twitter.sdk.android.core.internal.scribe;

/* loaded from: classes.dex */
public interface EventsManager<T> {
    void deleteAllEvents();

    void recordEvent(T t);

    void sendEvents();
}
