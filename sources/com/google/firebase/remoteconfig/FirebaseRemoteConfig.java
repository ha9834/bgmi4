package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.firebase_remote_config.zzag;
import com.google.android.gms.internal.firebase_remote_config.zzeh;
import com.google.android.gms.internal.firebase_remote_config.zzep;
import com.google.android.gms.internal.firebase_remote_config.zzeq;
import com.google.android.gms.internal.firebase_remote_config.zzes;
import com.google.android.gms.internal.firebase_remote_config.zzev;
import com.google.android.gms.internal.firebase_remote_config.zzew;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;
    private final Context zzja;
    private final FirebaseApp zzjb;
    private final FirebaseABTesting zzjc;
    private final Executor zzjd;
    private final zzeh zzje;
    private final zzeh zzjf;
    private final zzeh zzjg;
    private final zzeq zzjh;
    private final zzes zzji;
    private final zzev zzjj;

    public static FirebaseRemoteConfig getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzc(Task task) {
        return zza((Task<zzep>) task);
    }

    public static FirebaseRemoteConfig getInstance(FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent) firebaseApp.get(RemoteConfigComponent.class)).get("firebase");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, FirebaseABTesting firebaseABTesting, Executor executor, zzeh zzehVar, zzeh zzehVar2, zzeh zzehVar3, zzeq zzeqVar, zzes zzesVar, zzev zzevVar) {
        this.zzja = context;
        this.zzjb = firebaseApp;
        this.zzjc = firebaseABTesting;
        this.zzjd = executor;
        this.zzje = zzehVar;
        this.zzjf = zzehVar2;
        this.zzjg = zzehVar3;
        this.zzjh = zzeqVar;
        this.zzji = zzesVar;
        this.zzjj = zzevVar;
    }

    public Task<FirebaseRemoteConfigInfo> ensureInitialized() {
        Task<zzep> zzcp = this.zzjf.zzcp();
        Task<zzep> zzcp2 = this.zzjg.zzcp();
        Task<zzep> zzcp3 = this.zzje.zzcp();
        final Task call = Tasks.call(this.zzjd, new Callable(this) { // from class: com.google.firebase.remoteconfig.zzb
            private final FirebaseRemoteConfig zzjl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjl = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzjl.getInfo();
            }
        });
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{zzcp, zzcp2, zzcp3, call}).continueWith(this.zzjd, new Continuation(call) { // from class: com.google.firebase.remoteconfig.zza
            private final Task zzjk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjk = call;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return (FirebaseRemoteConfigInfo) this.zzjk.getResult();
            }
        });
    }

    public Task<Boolean> fetchAndActivate() {
        return fetch().onSuccessTask(this.zzjd, new SuccessContinuation(this) { // from class: com.google.firebase.remoteconfig.zzf
            private final FirebaseRemoteConfig zzjl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjl = this;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.zzjl.activate();
            }
        });
    }

    @Deprecated
    public boolean activateFetched() {
        zzep zzco = this.zzje.zzco();
        if (zzco == null || !zza(zzco, this.zzjf.zzco())) {
            return false;
        }
        this.zzjf.zzb(zzco).addOnSuccessListener(this.zzjd, new OnSuccessListener(this) { // from class: com.google.firebase.remoteconfig.zze
            private final FirebaseRemoteConfig zzjl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjl = this;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.zzjl.zza((zzep) obj);
            }
        });
        return true;
    }

    @KeepForSdk
    @Deprecated
    public boolean activateFetched(String str) {
        return ((RemoteConfigComponent) this.zzjb.get(RemoteConfigComponent.class)).get(str).activateFetched();
    }

    public Task<Boolean> activate() {
        final Task<zzep> zzcp = this.zzje.zzcp();
        final Task<zzep> zzcp2 = this.zzjf.zzcp();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{zzcp, zzcp2}).continueWithTask(this.zzjd, new Continuation(this, zzcp, zzcp2) { // from class: com.google.firebase.remoteconfig.zzh
            private final FirebaseRemoteConfig zzjl;
            private final Task zzjn;
            private final Task zzjo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjl = this;
                this.zzjn = zzcp;
                this.zzjo = zzcp2;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zzjl.zza(this.zzjn, this.zzjo, task);
            }
        });
    }

    public Task<Void> fetch() {
        Task<zzep> zza = this.zzjh.zza(this.zzjj.isDeveloperModeEnabled());
        zza.addOnCompleteListener(this.zzjd, new OnCompleteListener(this) { // from class: com.google.firebase.remoteconfig.zzg
            private final FirebaseRemoteConfig zzjl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjl = this;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zzjl.zzb(task);
            }
        });
        return zza.onSuccessTask(zzj.zzjm);
    }

    public Task<Void> fetch(long j) {
        Task<zzep> zza = this.zzjh.zza(this.zzjj.isDeveloperModeEnabled(), j);
        zza.addOnCompleteListener(this.zzjd, new OnCompleteListener(this) { // from class: com.google.firebase.remoteconfig.zzi
            private final FirebaseRemoteConfig zzjl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjl = this;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zzjl.zzb(task);
            }
        });
        return zza.onSuccessTask(zzl.zzjm);
    }

    public String getString(String str) {
        return this.zzji.getString(str);
    }

    @Deprecated
    public String getString(String str, String str2) {
        return ((RemoteConfigComponent) this.zzjb.get(RemoteConfigComponent.class)).get(str2).getString(str);
    }

    public boolean getBoolean(String str) {
        return this.zzji.getBoolean(str);
    }

    @Deprecated
    public boolean getBoolean(String str, String str2) {
        return ((RemoteConfigComponent) this.zzjb.get(RemoteConfigComponent.class)).get(str2).getBoolean(str);
    }

    @Deprecated
    public byte[] getByteArray(String str) {
        return this.zzji.getByteArray(str);
    }

    @Deprecated
    public byte[] getByteArray(String str, String str2) {
        return ((RemoteConfigComponent) this.zzjb.get(RemoteConfigComponent.class)).get(str2).getByteArray(str);
    }

    public double getDouble(String str) {
        return this.zzji.getDouble(str);
    }

    @Deprecated
    public double getDouble(String str, String str2) {
        return ((RemoteConfigComponent) this.zzjb.get(RemoteConfigComponent.class)).get(str2).getDouble(str);
    }

    public long getLong(String str) {
        return this.zzji.getLong(str);
    }

    @Deprecated
    public long getLong(String str, String str2) {
        return ((RemoteConfigComponent) this.zzjb.get(RemoteConfigComponent.class)).get(str2).getLong(str);
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        return this.zzji.getValue(str);
    }

    @Deprecated
    public FirebaseRemoteConfigValue getValue(String str, String str2) {
        return getValue(str);
    }

    public Set<String> getKeysByPrefix(String str) {
        return this.zzji.getKeysByPrefix(str);
    }

    @Deprecated
    public Set<String> getKeysByPrefix(String str, String str2) {
        return getKeysByPrefix(str);
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        return this.zzji.getAll();
    }

    public FirebaseRemoteConfigInfo getInfo() {
        return this.zzjj.getInfo();
    }

    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.zzjj.zzb(firebaseRemoteConfigSettings.isDeveloperModeEnabled());
        this.zzjj.zzc(firebaseRemoteConfigSettings.getFetchTimeoutInSeconds());
        this.zzjj.zzd(firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds());
        if (firebaseRemoteConfigSettings.isDeveloperModeEnabled()) {
            Logger.getLogger(zzag.class.getName()).setLevel(Level.CONFIG);
        }
    }

    public void setDefaults(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        zzb(hashMap);
    }

    @Deprecated
    public void setDefaults(Map<String, Object> map, String str) {
        setDefaults(map);
    }

    public Task<Void> setDefaultsAsync(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return zzc(hashMap);
    }

    public void setDefaults(int i) {
        zzb(zzew.zza(this.zzja, i));
    }

    @Deprecated
    public void setDefaults(int i, String str) {
        setDefaults(i);
    }

    public Task<Void> setDefaultsAsync(int i) {
        return zzc(zzew.zza(this.zzja, i));
    }

    public Task<Void> reset() {
        return Tasks.call(this.zzjd, new Callable(this) { // from class: com.google.firebase.remoteconfig.zzk
            private final FirebaseRemoteConfig zzjl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjl = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzjl.zzcn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzcm() {
        this.zzjf.zzcp();
        this.zzjg.zzcp();
        this.zzje.zzcp();
    }

    private final boolean zza(Task<zzep> task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.zzje.clear();
        if (task.getResult() != null) {
            zza(task.getResult().zzcs());
            return true;
        }
        Log.e("FirebaseRemoteConfig", "Activated configs are null.");
        return true;
    }

    private final void zzb(Map<String, String> map) {
        try {
            this.zzjg.zzb(zzep.zzct().zzd(map).zzcw());
        } catch (JSONException e) {
            Log.e("FirebaseRemoteConfig", "The provided defaults map could not be processed.", e);
        }
    }

    private final Task<Void> zzc(Map<String, String> map) {
        try {
            return this.zzjg.zza(zzep.zzct().zzd(map).zzcw(), true).onSuccessTask(zzd.zzjm);
        } catch (JSONException e) {
            Log.e("FirebaseRemoteConfig", "The provided defaults map could not be processed.", e);
            return Tasks.forResult(null);
        }
    }

    private final void zza(JSONArray jSONArray) {
        if (this.zzjc == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
                arrayList.add(hashMap);
            }
            this.zzjc.replaceAllExperiments(arrayList);
        } catch (AbtException e) {
            Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e);
        } catch (JSONException e2) {
            Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e2);
        }
    }

    private static boolean zza(zzep zzepVar, zzep zzepVar2) {
        return zzepVar2 == null || !zzepVar.zzcr().equals(zzepVar2.zzcr());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzcn() throws Exception {
        this.zzjf.clear();
        this.zzje.clear();
        this.zzjg.clear();
        this.zzjj.clear();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(false);
        }
        zzep zzepVar = (zzep) task.getResult();
        if (task2.isSuccessful() && !zza(zzepVar, (zzep) task2.getResult())) {
            return Tasks.forResult(false);
        }
        return this.zzjf.zza(zzepVar, true).continueWith(this.zzjd, new Continuation(this) { // from class: com.google.firebase.remoteconfig.zzc
            private final FirebaseRemoteConfig zzjl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjl = this;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task4) {
                return Boolean.valueOf(this.zzjl.zzc(task4));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzep zzepVar) {
        this.zzje.clear();
        zza(zzepVar.zzcs());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Task task) {
        if (task.isSuccessful()) {
            this.zzjj.zzm(-1);
            zzep zzepVar = (zzep) task.getResult();
            if (zzepVar != null) {
                this.zzjj.zzd(zzepVar.zzcr());
            }
            Log.i("FirebaseRemoteConfig", "Fetch succeeded!");
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            Log.e("FirebaseRemoteConfig", "Fetch was cancelled... This should never covfefe");
        } else if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.zzjj.zzm(2);
            Log.w("FirebaseRemoteConfig", "Fetch was throttled!", exception);
        } else {
            this.zzjj.zzm(1);
            Log.e("FirebaseRemoteConfig", "Fetch failed!", exception);
        }
    }
}
