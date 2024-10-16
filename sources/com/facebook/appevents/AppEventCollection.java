package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppEventCollection {
    private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void addPersistedEvents(PersistedEvents persistedEvents) {
        if (persistedEvents == null) {
            return;
        }
        for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
            SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
            Iterator<AppEvent> it = persistedEvents.get(accessTokenAppIdPair).iterator();
            while (it.hasNext()) {
                sessionEventsState.addEvent(it.next());
            }
        }
    }

    public synchronized void addEvent(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        getSessionEventsState(accessTokenAppIdPair).addEvent(appEvent);
    }

    public synchronized Set<AccessTokenAppIdPair> keySet() {
        return this.stateMap.keySet();
    }

    public synchronized SessionEventsState get(AccessTokenAppIdPair accessTokenAppIdPair) {
        return this.stateMap.get(accessTokenAppIdPair);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int getEventCount() {
        int i;
        i = 0;
        Iterator<SessionEventsState> it = this.stateMap.values().iterator();
        while (it.hasNext()) {
            i += it.next().getAccumulatedEventCount();
        }
        return i;
    }

    private synchronized SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        sessionEventsState = this.stateMap.get(accessTokenAppIdPair);
        if (sessionEventsState == null) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            sessionEventsState = new SessionEventsState(AttributionIdentifiers.getAttributionIdentifiers(applicationContext), AppEventsLogger.getAnonymousAppDeviceGUID(applicationContext));
        }
        this.stateMap.put(accessTokenAppIdPair, sessionEventsState);
        return sessionEventsState;
    }
}
