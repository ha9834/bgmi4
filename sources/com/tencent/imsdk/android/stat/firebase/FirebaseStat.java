package com.tencent.imsdk.android.stat.firebase;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.imsdk.android.base.interfaces.IStat;
import com.tencent.imsdk.android.base.stat.IMSDKStatEventParams;
import com.tencent.imsdk.android.base.stat.IMSDKStatUserAttribute;
import com.tencent.imsdk.android.tools.InnerStat;
import java.util.Map;

/* loaded from: classes.dex */
public class FirebaseStat implements IStat {
    private static final String DEFAULT_EVENT_NAME = "default_event";
    public FirebaseAnalytics mFirebaseAnalytics;

    @Override // com.tencent.imsdk.android.base.interfaces.IStat
    public <T> T getAttribute(Class<?> cls, String str, Object... objArr) {
        return null;
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IStat
    public void setAttribute(String str, IMSDKStatUserAttribute iMSDKStatUserAttribute) {
    }

    public FirebaseStat(Context context) {
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
        new InnerStat.Builder(context, "2.0.1", String.valueOf(GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE));
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IStat
    public void reportEvent(String str, IMSDKStatEventParams iMSDKStatEventParams) {
        if (IStat.STAT_EVENT_REPORT.equals(str)) {
            Bundle bundle = new Bundle();
            String str2 = DEFAULT_EVENT_NAME;
            if (iMSDKStatEventParams != null && iMSDKStatEventParams.extraParams != null) {
                for (Map.Entry<String, String> entry : iMSDKStatEventParams.extraParams.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
            }
            if (iMSDKStatEventParams != null && iMSDKStatEventParams.eventName != null) {
                str2 = iMSDKStatEventParams.eventName;
            }
            this.mFirebaseAnalytics.logEvent(str2, bundle);
        }
    }
}
