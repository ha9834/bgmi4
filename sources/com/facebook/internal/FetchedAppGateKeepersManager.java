package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class FetchedAppGateKeepersManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static GateKeeperRuntimeCache gateKeeperRuntimeCache;
    private static Long timestamp;
    public static final FetchedAppGateKeepersManager INSTANCE = new FetchedAppGateKeepersManager();
    private static final String TAG = j.b(FetchedAppGateKeepersManager.class).b();
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    /* loaded from: classes.dex */
    public interface Callback {
        void onCompleted();
    }

    private FetchedAppGateKeepersManager() {
    }

    public final void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync(null);
    }

    public static final synchronized void loadAppGateKeepersAsync(Callback callback) {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (callback != null) {
                callbacks.add(callback);
            }
            final String applicationId = FacebookSdk.getApplicationId();
            if (INSTANCE.isTimestampValid(timestamp) && fetchedAppGateKeepers.containsKey(applicationId)) {
                INSTANCE.pollCallbacks();
                return;
            }
            final Context applicationContext = FacebookSdk.getApplicationContext();
            l lVar = l.f6973a;
            Object[] objArr = {applicationId};
            final String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(objArr, objArr.length));
            h.a((Object) format, "java.lang.String.format(format, *args)");
            if (applicationContext == null) {
                return;
            }
            String string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(format, null);
            if (!Utility.isNullOrEmpty(string)) {
                JSONObject jSONObject = (JSONObject) null;
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    Utility.logd(Utility.LOG_TAG, e);
                }
                if (jSONObject != null) {
                    FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
                    h.a((Object) applicationId, "applicationId");
                    fetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(applicationId, jSONObject);
                }
            }
            Executor executor = FacebookSdk.getExecutor();
            if (executor != null) {
                if (isLoading.compareAndSet(false, true)) {
                    executor.execute(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager$loadAppGateKeepersAsync$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            JSONObject appGateKeepersQueryResponse;
                            AtomicBoolean atomicBoolean;
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                if (CrashShieldHandler.isObjectCrashing(this)) {
                                    return;
                                }
                                try {
                                    FetchedAppGateKeepersManager fetchedAppGateKeepersManager2 = FetchedAppGateKeepersManager.INSTANCE;
                                    String str = applicationId;
                                    h.a((Object) str, "applicationId");
                                    appGateKeepersQueryResponse = fetchedAppGateKeepersManager2.getAppGateKeepersQueryResponse(str);
                                    if (appGateKeepersQueryResponse.length() != 0) {
                                        FetchedAppGateKeepersManager fetchedAppGateKeepersManager3 = FetchedAppGateKeepersManager.INSTANCE;
                                        String str2 = applicationId;
                                        h.a((Object) str2, "applicationId");
                                        fetchedAppGateKeepersManager3.parseAppGateKeepersFromJSON(str2, appGateKeepersQueryResponse);
                                        applicationContext.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(format, appGateKeepersQueryResponse.toString()).apply();
                                        FetchedAppGateKeepersManager fetchedAppGateKeepersManager4 = FetchedAppGateKeepersManager.INSTANCE;
                                        FetchedAppGateKeepersManager.timestamp = Long.valueOf(System.currentTimeMillis());
                                    }
                                    FetchedAppGateKeepersManager.INSTANCE.pollCallbacks();
                                    FetchedAppGateKeepersManager fetchedAppGateKeepersManager5 = FetchedAppGateKeepersManager.INSTANCE;
                                    atomicBoolean = FetchedAppGateKeepersManager.isLoading;
                                    atomicBoolean.set(false);
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            } catch (Throwable th2) {
                                CrashShieldHandler.handleThrowable(th2, this);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (!callbacks.isEmpty()) {
            final Callback poll = callbacks.poll();
            if (poll != null) {
                handler.post(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager$pollCallbacks$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                FetchedAppGateKeepersManager.Callback.this.onCompleted();
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                });
            }
        }
    }

    public static final JSONObject queryAppGateKeepers(String str, boolean z) {
        h.b(str, "applicationId");
        if (!z && fetchedAppGateKeepers.containsKey(str)) {
            JSONObject jSONObject = fetchedAppGateKeepers.get(str);
            return jSONObject != null ? jSONObject : new JSONObject();
        }
        JSONObject appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(str);
        Context applicationContext = FacebookSdk.getApplicationContext();
        l lVar = l.f6973a;
        Object[] objArr = {str};
        String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(format, appGateKeepersQueryResponse.toString()).apply();
        return INSTANCE.parseAppGateKeepersFromJSON(str, appGateKeepersQueryResponse);
    }

    public final Map<String, Boolean> getGateKeepersForApplication(String str) {
        loadAppGateKeepersAsync();
        if (str == null || !fetchedAppGateKeepers.containsKey(str)) {
            return new HashMap();
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        List<GateKeeper> dumpGateKeepers = gateKeeperRuntimeCache2 != null ? gateKeeperRuntimeCache2.dumpGateKeepers(str) : null;
        if (dumpGateKeepers != null) {
            HashMap hashMap = new HashMap();
            for (GateKeeper gateKeeper : dumpGateKeepers) {
                hashMap.put(gateKeeper.getName(), Boolean.valueOf(gateKeeper.getValue()));
            }
            return hashMap;
        }
        HashMap hashMap2 = new HashMap();
        JSONObject jSONObject = fetchedAppGateKeepers.get(str);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            h.a((Object) next, "key");
            hashMap2.put(next, Boolean.valueOf(jSONObject.optBoolean(next)));
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache3 == null) {
            gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
        }
        ArrayList arrayList = new ArrayList(hashMap2.size());
        for (Map.Entry entry : hashMap2.entrySet()) {
            arrayList.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
        }
        gateKeeperRuntimeCache3.setGateKeepers(str, arrayList);
        gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
        return hashMap2;
    }

    public static final boolean getGateKeeperForKey(String str, String str2, boolean z) {
        Boolean bool;
        h.b(str, "name");
        Map<String, Boolean> gateKeepersForApplication = INSTANCE.getGateKeepersForApplication(str2);
        return (gateKeepersForApplication.containsKey(str) && (bool = gateKeepersForApplication.get(str)) != null) ? bool.booleanValue() : z;
    }

    public static /* synthetic */ void setRuntimeGateKeeper$default(String str, GateKeeper gateKeeper, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
            h.a((Object) str, "FacebookSdk.getApplicationId()");
        }
        setRuntimeGateKeeper(str, gateKeeper);
    }

    public static final void setRuntimeGateKeeper(String str, GateKeeper gateKeeper) {
        h.b(str, "applicationId");
        h.b(gateKeeper, "gateKeeper");
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if ((gateKeeperRuntimeCache2 != null ? gateKeeperRuntimeCache2.getGateKeeper(str, gateKeeper.getName()) : null) != null) {
            GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
            if (gateKeeperRuntimeCache3 != null) {
                gateKeeperRuntimeCache3.setGateKeeper(str, gateKeeper);
                return;
            }
            return;
        }
        Log.w(TAG, "Missing gatekeeper runtime cache");
    }

    public static final void resetRuntimeGateKeeperCache() {
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 != null) {
            GateKeeperRuntimeCache.resetCache$default(gateKeeperRuntimeCache2, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        bundle.putString("sdk_version", FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        l lVar = l.f6973a;
        Object[] objArr = {str, APPLICATION_GATEKEEPER_EDGE};
        String format = String.format("%s/%s", Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, format, null);
        newGraphPathRequest.setSkipClientToken(true);
        h.a((Object) newGraphPathRequest, "request");
        newGraphPathRequest.setParameters(bundle);
        GraphResponse executeAndWait = newGraphPathRequest.executeAndWait();
        h.a((Object) executeAndWait, "request.executeAndWait()");
        JSONObject jSONObject = executeAndWait.getJSONObject();
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized JSONObject parseAppGateKeepersFromJSON(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray optJSONArray;
        h.b(str, "applicationId");
        jSONObject2 = fetchedAppGateKeepers.get(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("data")) == null || (jSONObject3 = optJSONArray.optJSONObject(0)) == null) {
            jSONObject3 = new JSONObject();
        }
        JSONArray optJSONArray2 = jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
        if (optJSONArray2 == null) {
            optJSONArray2 = new JSONArray();
        }
        int length = optJSONArray2.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject4 = optJSONArray2.getJSONObject(i);
                jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean("value"));
            } catch (JSONException e) {
                Utility.logd(Utility.LOG_TAG, e);
            }
        }
        fetchedAppGateKeepers.put(str, jSONObject2);
        return jSONObject2;
    }

    private final boolean isTimestampValid(Long l) {
        return l != null && System.currentTimeMillis() - l.longValue() < APPLICATION_GATEKEEPER_CACHE_TIMEOUT;
    }
}
