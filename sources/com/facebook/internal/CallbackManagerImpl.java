package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class CallbackManagerImpl implements CallbackManager {
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, Callback> staticCallbacks = new HashMap();
    private final Map<Integer, Callback> callbacks = new HashMap();

    /* loaded from: classes.dex */
    public interface Callback {
        boolean onActivityResult(int i, Intent intent);
    }

    private static final synchronized Callback getStaticCallback(int i) {
        Callback staticCallback;
        synchronized (CallbackManagerImpl.class) {
            staticCallback = Companion.getStaticCallback(i);
        }
        return staticCallback;
    }

    public static final synchronized void registerStaticCallback(int i, Callback callback) {
        synchronized (CallbackManagerImpl.class) {
            Companion.registerStaticCallback(i, callback);
        }
    }

    private static final boolean runStaticCallback(int i, int i2, Intent intent) {
        return Companion.runStaticCallback(i, i2, intent);
    }

    public final void registerCallback(int i, Callback callback) {
        h.b(callback, "callback");
        this.callbacks.put(Integer.valueOf(i), callback);
    }

    public final void unregisterCallback(int i) {
        this.callbacks.remove(Integer.valueOf(i));
    }

    @Override // com.facebook.CallbackManager
    public boolean onActivityResult(int i, int i2, Intent intent) {
        Callback callback = this.callbacks.get(Integer.valueOf(i));
        if (callback != null) {
            return callback.onActivityResult(i2, intent);
        }
        return Companion.runStaticCallback(i, i2, intent);
    }

    /* loaded from: classes.dex */
    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8),
        GamingFriendFinder(9),
        GamingGroupIntegration(10),
        Referral(11);

        private final int offset;

        RequestCodeOffset(int i) {
            this.offset = i;
        }

        public final int toRequestCode() {
            return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final synchronized void registerStaticCallback(int i, Callback callback) {
            h.b(callback, "callback");
            if (CallbackManagerImpl.staticCallbacks.containsKey(Integer.valueOf(i))) {
                return;
            }
            CallbackManagerImpl.staticCallbacks.put(Integer.valueOf(i), callback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized Callback getStaticCallback(int i) {
            return (Callback) CallbackManagerImpl.staticCallbacks.get(Integer.valueOf(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean runStaticCallback(int i, int i2, Intent intent) {
            Callback staticCallback = getStaticCallback(i);
            if (staticCallback != null) {
                return staticCallback.onActivityResult(i2, intent);
            }
            return false;
        }
    }
}
