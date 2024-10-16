package com.google.firebase.abt.component;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashMap;
import java.util.Map;

@KeepForSdk
/* loaded from: classes2.dex */
public class AbtComponent {
    private final AnalyticsConnector zzh;
    private final Map<String, FirebaseABTesting> zzk = new HashMap();
    private final Context zzl;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbtComponent(Context context, AnalyticsConnector analyticsConnector) {
        this.zzl = context;
        this.zzh = analyticsConnector;
    }

    @KeepForSdk
    public synchronized FirebaseABTesting get(String str) {
        if (!this.zzk.containsKey(str)) {
            this.zzk.put(str, new FirebaseABTesting(this.zzl, this.zzh, str));
        }
        return this.zzk.get(str);
    }
}
