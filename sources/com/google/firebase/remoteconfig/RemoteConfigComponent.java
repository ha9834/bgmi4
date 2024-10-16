package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_remote_config.zzab;
import com.google.android.gms.internal.firebase_remote_config.zzad;
import com.google.android.gms.internal.firebase_remote_config.zzas;
import com.google.android.gms.internal.firebase_remote_config.zzbf;
import com.google.android.gms.internal.firebase_remote_config.zzcx;
import com.google.android.gms.internal.firebase_remote_config.zzcy;
import com.google.android.gms.internal.firebase_remote_config.zzde;
import com.google.android.gms.internal.firebase_remote_config.zzeh;
import com.google.android.gms.internal.firebase_remote_config.zzeq;
import com.google.android.gms.internal.firebase_remote_config.zzes;
import com.google.android.gms.internal.firebase_remote_config.zzev;
import com.google.android.gms.internal.firebase_remote_config.zzex;
import com.google.android.gms.internal.firebase_remote_config.zzfd;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@KeepForSdk
/* loaded from: classes2.dex */
public class RemoteConfigComponent {
    private static final ExecutorService zzjt = Executors.newCachedThreadPool();
    private static final Clock zzju = DefaultClock.getInstance();
    private static final Random zzjv = new Random();
    private final String appId;
    private String zzg;
    private final Context zzja;
    private final FirebaseApp zzjb;
    private final FirebaseABTesting zzjc;
    private final Map<String, FirebaseRemoteConfig> zzjw;
    private final FirebaseInstanceId zzjx;
    private final AnalyticsConnector zzjy;
    private Map<String, String> zzjz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConfigComponent(Context context, FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, FirebaseABTesting firebaseABTesting, AnalyticsConnector analyticsConnector) {
        this(context, zzjt, firebaseApp, firebaseInstanceId, firebaseABTesting, analyticsConnector, new zzfd(context, firebaseApp.getOptions().getApplicationId()));
    }

    private RemoteConfigComponent(Context context, Executor executor, FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, FirebaseABTesting firebaseABTesting, AnalyticsConnector analyticsConnector, zzfd zzfdVar) {
        this.zzjw = new HashMap();
        this.zzjz = new HashMap();
        this.zzg = "https://firebaseremoteconfig.googleapis.com/";
        this.zzja = context;
        this.zzjb = firebaseApp;
        this.zzjx = firebaseInstanceId;
        this.zzjc = firebaseABTesting;
        this.zzjy = analyticsConnector;
        this.appId = firebaseApp.getOptions().getApplicationId();
        Tasks.call(executor, new Callable(this) { // from class: com.google.firebase.remoteconfig.zzo
            private final RemoteConfigComponent zzkb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzkb = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzkb.get("firebase");
            }
        });
        zzfdVar.getClass();
        Tasks.call(executor, zzn.zza(zzfdVar));
    }

    @KeepForSdk
    public synchronized FirebaseRemoteConfig get(String str) {
        zzeh zzd;
        zzeh zzd2;
        zzeh zzd3;
        zzev zzevVar;
        zzd = zzd(str, "fetch");
        zzd2 = zzd(str, "activate");
        zzd3 = zzd(str, "defaults");
        zzevVar = new zzev(this.zzja.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", this.appId, str, "settings"), 0));
        return zza(this.zzjb, str, this.zzjc, zzjt, zzd, zzd2, zzd3, new zzeq(this.zzja, this.zzjb.getOptions().getApplicationId(), this.zzjx, this.zzjy, str, zzjt, zzju, zzjv, zzd, zza(this.zzjb.getOptions().getApiKey(), zzevVar), zzevVar), new zzes(zzd2, zzd3), zzevVar);
    }

    private final synchronized FirebaseRemoteConfig zza(FirebaseApp firebaseApp, String str, FirebaseABTesting firebaseABTesting, Executor executor, zzeh zzehVar, zzeh zzehVar2, zzeh zzehVar3, zzeq zzeqVar, zzes zzesVar, zzev zzevVar) {
        if (!this.zzjw.containsKey(str)) {
            FirebaseRemoteConfig firebaseRemoteConfig = new FirebaseRemoteConfig(this.zzja, firebaseApp, str.equals("firebase") ? firebaseABTesting : null, executor, zzehVar, zzehVar2, zzehVar3, zzeqVar, zzesVar, zzevVar);
            firebaseRemoteConfig.zzcm();
            this.zzjw.put(str, firebaseRemoteConfig);
        }
        return this.zzjw.get(str);
    }

    private final zzeh zzd(String str, String str2) {
        return zza(this.zzja, this.appId, str, str2);
    }

    public static zzeh zza(Context context, String str, String str2, String str3) {
        return zzeh.zza(zzjt, zzex.zzb(context, String.format("%s_%s_%s_%s.json", "frc", str, str2, str3)));
    }

    private final zzcy zza(String str, final zzev zzevVar) {
        zzcy zzce;
        zzde zzdeVar = new zzde(str);
        synchronized (this) {
            zzce = ((zzcx) new zzcx(new zzas(), zzbf.zzbq(), new zzad(this, zzevVar) { // from class: com.google.firebase.remoteconfig.zzp
                private final RemoteConfigComponent zzkb;
                private final zzev zzkc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzkb = this;
                    this.zzkc = zzevVar;
                }

                @Override // com.google.android.gms.internal.firebase_remote_config.zzad
                public final void zza(zzab zzabVar) {
                    this.zzkb.zza(this.zzkc, zzabVar);
                }
            }).zzc(this.zzg)).zza(zzdeVar).zzce();
        }
        return zzce;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ void zza(zzev zzevVar, zzab zzabVar) throws IOException {
        zzabVar.zza((int) TimeUnit.SECONDS.toMillis(zzevVar.getFetchTimeoutInSeconds()));
        zzabVar.zzb((int) TimeUnit.SECONDS.toMillis(5L));
        synchronized (this) {
            for (Map.Entry<String, String> entry : this.zzjz.entrySet()) {
                zzabVar.zzx().zzb(entry.getKey(), entry.getValue());
            }
        }
    }
}
