package com.tencent.quantum;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.epicgames.ue4.GameActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

/* loaded from: classes.dex */
public class QuantumFirebaseRemoteConfig {
    private static QuantumFirebaseRemoteConfig m_instance;
    private int status = -1;
    private FirebaseRemoteConfig mConfig = null;

    public static QuantumFirebaseRemoteConfig getInstance() {
        if (m_instance == null) {
            m_instance = new QuantumFirebaseRemoteConfig();
        }
        return m_instance;
    }

    public static int GetStatus() {
        return getInstance().status;
    }

    public static String[] GetRemoteConfigs(String[] strArr) {
        if (strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        FirebaseRemoteConfig firebaseRemoteConfig = getInstance().mConfig;
        if (getInstance().status == 0 && firebaseRemoteConfig != null) {
            for (int i = 0; i < strArr.length; i++) {
                strArr2[i] = firebaseRemoteConfig.getString(strArr[i]);
            }
        }
        return strArr2;
    }

    public void InitAndFetch() {
        int i;
        boolean z = false;
        try {
            ApplicationInfo applicationInfo = GameActivity.Get().getPackageManager().getApplicationInfo(GameActivity.Get().getPackageName(), 128);
            z = applicationInfo.metaData.getBoolean("Quantum_Firebase_RemoteConfig_DEBUG");
            i = applicationInfo.metaData.getInt("Quantum_Firebase_RemoteConfig_CacheSeconds");
        } catch (PackageManager.NameNotFoundException unused) {
            i = 43200;
        }
        Log.d("QuantumFirebaseRemoteConfigJava", "devmode " + z);
        Log.d("QuantumFirebaseRemoteConfigJava", "cacheseconds " + i);
        this.mConfig = FirebaseRemoteConfig.getInstance();
        this.mConfig.setConfigSettings(new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(z).build());
        this.mConfig.fetch((long) i).addOnCompleteListener(GameActivity.Get(), new OnCompleteListener<Void>() { // from class: com.tencent.quantum.QuantumFirebaseRemoteConfig.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    QuantumFirebaseRemoteConfig.this.mConfig.activateFetched();
                    QuantumFirebaseRemoteConfig.getInstance().status = 0;
                    Log.d("QuantumFirebaseRemoteConfigJava", "remoteConfig complete with success");
                    return;
                }
                QuantumFirebaseRemoteConfig.getInstance().status = 1;
                Log.d("QuantumFirebaseRemoteConfigJava", "remoteConfig complete with error");
                Log.d("QuantumFirebaseRemoteConfigJava", "remoteConfig complete with error, getException().toString:" + task.getException().toString());
                Log.d("QuantumFirebaseRemoteConfigJava", "remoteConfig complete with error, getException().getLocalizedMessage:" + task.getException().getLocalizedMessage());
                Log.d("QuantumFirebaseRemoteConfigJava", "remoteConfig complete with error, getException().getMessage:" + task.getException().getMessage());
            }
        });
    }
}
