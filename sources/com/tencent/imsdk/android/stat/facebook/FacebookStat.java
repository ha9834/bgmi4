package com.tencent.imsdk.android.stat.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.tencent.imsdk.android.base.interfaces.IStat;
import com.tencent.imsdk.android.base.stat.IMSDKStatEventParams;
import com.tencent.imsdk.android.base.stat.IMSDKStatUserAttribute;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FacebookStat implements IStat {
    private Context mCtx;

    public FacebookStat(Context context) {
        IMLogger.d("FacebookStat init...");
        if (this.mCtx == null) {
            this.mCtx = context;
            new InnerStat.Builder(context, "2.2.1", FacebookSdk.getSdkVersion());
            Context context2 = this.mCtx;
            if (context2 != null) {
                try {
                    FacebookSdk.sdkInitialize(context2);
                    AppEventsLogger.activateApp(this.mCtx);
                } catch (Exception e) {
                    IMLogger.w("manually init facebook failed : " + e.getMessage(), new Object[0]);
                }
            }
        }
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IStat
    public void setAttribute(String str, IMSDKStatUserAttribute iMSDKStatUserAttribute) {
        IMLogger.d(str + " is not exist, check your type again");
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IStat
    public <T> T getAttribute(Class<?> cls, String str, Object... objArr) {
        IMLogger.d(str + " is not exist, check your type again");
        return null;
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IStat
    public void reportEvent(String str, IMSDKStatEventParams iMSDKStatEventParams) {
        IMLogger.d(str + " is executing");
        AppEventsLogger newLogger = AppEventsLogger.newLogger(this.mCtx);
        IMLogger.d("FacebookStat report with type : " + str);
        if (IStat.STAT_EVENT_REPORT.equals(str)) {
            IMLogger.d("FacebookStat reportEvent with STAT_EVENT_REPORT");
            HashMap hashMap = (HashMap) iMSDKStatEventParams.extraParams;
            String str2 = iMSDKStatEventParams.eventBody;
            String str3 = iMSDKStatEventParams.eventName;
            if ((hashMap == null || hashMap.size() == 0) && (str2 == null || str2.length() == 0)) {
                IMLogger.d("FacebookStat report with eventName : " + str3 + " eventBody : " + str2);
                newLogger.logEvent(str3);
                return;
            }
            if (hashMap != null && hashMap.size() > 0) {
                IMLogger.d("FacebookStat report with eventName : " + str3 + " eventMap : " + hashMap);
                Bundle bundle = new Bundle();
                for (Map.Entry entry : hashMap.entrySet()) {
                    bundle.putString((String) entry.getKey(), (String) entry.getValue());
                }
                newLogger.logEvent(str3, bundle);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(str3, str2);
            newLogger.logEvent(str3, bundle2);
            return;
        }
        if (IStat.STAT_EVENT_PURCHASE_REPORT.equals(str)) {
            IMLogger.d("FacebookStat reportEvent with STAT_EVENT_PURCHASE_REPORT ");
            try {
                newLogger.logPurchase(BigDecimal.valueOf(Double.parseDouble(iMSDKStatEventParams.expense)), Currency.getInstance(iMSDKStatEventParams.currencyCode));
                return;
            } catch (NumberFormatException unused) {
                IMLogger.e("the expense formation what you input is  error, please cheak!", new Object[0]);
                return;
            }
        }
        IMLogger.d(str + " is not exist, check your type again");
    }
}
