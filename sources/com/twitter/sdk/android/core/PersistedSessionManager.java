package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStore;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStoreStrategy;
import com.twitter.sdk.android.core.internal.persistence.SerializationStrategy;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class PersistedSessionManager<T extends Session> implements SessionManager<T> {
    private static final int NUM_SESSIONS = 1;
    private final AtomicReference<T> activeSessionRef;
    private final PreferenceStoreStrategy<T> activeSessionStorage;
    private final String prefKeySession;
    private final PreferenceStore preferenceStore;
    private volatile boolean restorePending;
    private final SerializationStrategy<T> serializer;
    private final ConcurrentHashMap<Long, T> sessionMap;
    private final ConcurrentHashMap<Long, PreferenceStoreStrategy<T>> storageMap;

    public PersistedSessionManager(PreferenceStore preferenceStore, SerializationStrategy<T> serializationStrategy, String str, String str2) {
        this(preferenceStore, serializationStrategy, new ConcurrentHashMap(1), new ConcurrentHashMap(1), new PreferenceStoreStrategy(preferenceStore, serializationStrategy, str), str2);
    }

    PersistedSessionManager(PreferenceStore preferenceStore, SerializationStrategy<T> serializationStrategy, ConcurrentHashMap<Long, T> concurrentHashMap, ConcurrentHashMap<Long, PreferenceStoreStrategy<T>> concurrentHashMap2, PreferenceStoreStrategy<T> preferenceStoreStrategy, String str) {
        this.restorePending = true;
        this.preferenceStore = preferenceStore;
        this.serializer = serializationStrategy;
        this.sessionMap = concurrentHashMap;
        this.storageMap = concurrentHashMap2;
        this.activeSessionStorage = preferenceStoreStrategy;
        this.activeSessionRef = new AtomicReference<>();
        this.prefKeySession = str;
    }

    void restoreAllSessionsIfNecessary() {
        if (this.restorePending) {
            restoreAllSessions();
        }
    }

    private synchronized void restoreAllSessions() {
        if (this.restorePending) {
            restoreActiveSession();
            restoreSessions();
            this.restorePending = false;
        }
    }

    private void restoreSessions() {
        T deserialize;
        for (Map.Entry<String, ?> entry : this.preferenceStore.get().getAll().entrySet()) {
            if (isSessionPreferenceKey(entry.getKey()) && (deserialize = this.serializer.deserialize((String) entry.getValue())) != null) {
                internalSetSession(deserialize.getId(), deserialize, false);
            }
        }
    }

    private void restoreActiveSession() {
        T restore = this.activeSessionStorage.restore();
        if (restore != null) {
            internalSetSession(restore.getId(), restore, false);
        }
    }

    boolean isSessionPreferenceKey(String str) {
        return str.startsWith(this.prefKeySession);
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    public T getActiveSession() {
        restoreAllSessionsIfNecessary();
        return this.activeSessionRef.get();
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    public void setActiveSession(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Session must not be null!");
        }
        restoreAllSessionsIfNecessary();
        internalSetSession(t.getId(), t, true);
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    public void clearActiveSession() {
        restoreAllSessionsIfNecessary();
        if (this.activeSessionRef.get() != null) {
            clearSession(this.activeSessionRef.get().getId());
        }
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    public T getSession(long j) {
        restoreAllSessionsIfNecessary();
        return this.sessionMap.get(Long.valueOf(j));
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    public void setSession(long j, T t) {
        if (t == null) {
            throw new IllegalArgumentException("Session must not be null!");
        }
        restoreAllSessionsIfNecessary();
        internalSetSession(j, t, false);
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    public Map<Long, T> getSessionMap() {
        restoreAllSessionsIfNecessary();
        return Collections.unmodifiableMap(this.sessionMap);
    }

    private void internalSetSession(long j, T t, boolean z) {
        this.sessionMap.put(Long.valueOf(j), t);
        PreferenceStoreStrategy<T> preferenceStoreStrategy = this.storageMap.get(Long.valueOf(j));
        if (preferenceStoreStrategy == null) {
            preferenceStoreStrategy = new PreferenceStoreStrategy<>(this.preferenceStore, this.serializer, getPrefKey(j));
            this.storageMap.putIfAbsent(Long.valueOf(j), preferenceStoreStrategy);
        }
        preferenceStoreStrategy.save(t);
        T t2 = this.activeSessionRef.get();
        if (t2 == null || t2.getId() == j || z) {
            synchronized (this) {
                this.activeSessionRef.compareAndSet(t2, t);
                this.activeSessionStorage.save(t);
            }
        }
    }

    String getPrefKey(long j) {
        return this.prefKeySession + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + j;
    }

    @Override // com.twitter.sdk.android.core.SessionManager
    public void clearSession(long j) {
        restoreAllSessionsIfNecessary();
        if (this.activeSessionRef.get() != null && this.activeSessionRef.get().getId() == j) {
            synchronized (this) {
                this.activeSessionRef.set(null);
                this.activeSessionStorage.clear();
            }
        }
        this.sessionMap.remove(Long.valueOf(j));
        PreferenceStoreStrategy<T> remove = this.storageMap.remove(Long.valueOf(j));
        if (remove != null) {
            remove.clear();
        }
    }
}
