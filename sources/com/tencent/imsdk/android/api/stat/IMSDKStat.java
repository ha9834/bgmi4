package com.tencent.imsdk.android.api.stat;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.base.interfaces.IStat;
import com.tencent.imsdk.android.base.stat.IMSDKStatEventParams;
import com.tencent.imsdk.android.base.stat.IMSDKStatManager;
import com.tencent.imsdk.android.base.stat.IMSDKStatUserAttribute;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class IMSDKStat {
    private static List<String> channels;
    private static Context mCurCtx;
    private static IMSDKStatManager mStatImpl;

    private static boolean isInit() {
        if (mStatImpl != null) {
            return true;
        }
        T.HelperLog.channelInstanceIsNull();
        return false;
    }

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mStatImpl = new IMSDKStatManager(mCurCtx);
        }
        return mStatImpl != null;
    }

    public static boolean initChannel(String str, String[] strArr) {
        if (mCurCtx == null) {
            return false;
        }
        return mStatImpl.setStatThreadHold(str, strArr);
    }

    public static boolean initChannel(Map<String, String[]> map) {
        if (mCurCtx == null) {
            return false;
        }
        return mStatImpl.setStatThreadHold(map);
    }

    public static void clearFilter() {
        if (mCurCtx != null) {
            mStatImpl.clearFilter();
            channels = null;
        }
    }

    public static void setFilter(List<String> list) {
        if (list != null) {
            channels = list;
            mStatImpl.setFilter((String[]) list.toArray(new String[0]));
        }
    }

    public static List<String> getFilter() {
        return channels;
    }

    public static void setCustomReportEvent(String str, IMSDKStatEventParams iMSDKStatEventParams) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(str, iMSDKStatEventParams);
        }
    }

    public static void setCustomAttribute(String str, IMSDKStatUserAttribute iMSDKStatUserAttribute) {
        if (isInit()) {
            mStatImpl.setAttribute(str, iMSDKStatUserAttribute);
        }
    }

    public static <E> E getCustomAttribute(Class<?> cls, String str, Object... objArr) {
        if (isInit()) {
            return (E) mStatImpl.getAttribute(cls, str, objArr);
        }
        return null;
    }

    public static void reportEvent(String str, boolean z) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(IStat.STAT_EVENT_REPORT, new IMSDKStatEventParams.Builder().setEventName(str).setRealTime(z).create());
        }
    }

    public static void reportEvent(String str, boolean z, String str2) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(IStat.STAT_EVENT_REPORT, new IMSDKStatEventParams.Builder().setEventName(str).setRealTime(z).setEventBody(str2).create());
        }
    }

    public static void reportEvent(String str, Map<String, String> map, boolean z) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(IStat.STAT_EVENT_REPORT, new IMSDKStatEventParams.Builder().setEventName(str).setRealTime(z).setExtraParams(map).create());
        }
    }

    public static void reportPurchase(String str, String str2, String str3, boolean z) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(IStat.STAT_EVENT_PURCHASE_REPORT, new IMSDKStatEventParams.Builder().setEventName(str).setRealTime(z).setCurrencyCode(str2).setExpense(str3).create());
        }
    }

    public static void trackEventBegin(String str, String str2) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(IStat.STAT_TRACK_EVENT_BEGIN, new IMSDKStatEventParams.Builder().setEventName(str).setEventBody(str2).create());
        }
    }

    public static void trackEventEnd(String str, String str2) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(IStat.STAT_TRACK_EVENT_END, new IMSDKStatEventParams.Builder().setEventName(str).setEventBody(str2).create());
        }
    }

    public static void trackPageBegin(String str) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(IStat.STAT_TRACK_PAGE_BEGIN, new IMSDKStatEventParams.Builder().setEventName(str).create());
        }
    }

    public static void trackPageEnd(String str) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(IStat.STAT_TRACK_PAGE_END, new IMSDKStatEventParams.Builder().setEventName(str).create());
        }
    }

    public static void speedTest(List<String> list) {
        if (isInit()) {
            mStatImpl.reportCustomEvent(IStat.STAT_EVENT_TEST_SPEED, new IMSDKStatEventParams.Builder().setExtraList(list).create());
        }
    }

    public static void reportCrash(boolean z) {
        if (isInit()) {
            mStatImpl.setAttribute(IStat.STAT_SET_CRASH_REPORT, new IMSDKStatUserAttribute.Builder().setActive(z).create());
        }
    }

    public static void reportException(boolean z) {
        if (isInit()) {
            mStatImpl.setAttribute(IStat.STAT_SET_EXCEPTION_REPORT, new IMSDKStatUserAttribute.Builder().setActive(z).create());
        }
    }

    public static String getStatIMEI() {
        if (isInit()) {
            return (String) mStatImpl.getAttribute(String.class, IStat.STAT_GET_IMEI, new Object[0]);
        }
        return null;
    }

    public static String getStatMID() {
        if (isInit()) {
            return (String) mStatImpl.getAttribute(String.class, IStat.STAT_GET_DEVICE_ID, new Object[0]);
        }
        return null;
    }
}
