package com.tencent.imsdk.android.base.interfaces;

import com.tencent.imsdk.android.base.stat.IMSDKStatEventParams;
import com.tencent.imsdk.android.base.stat.IMSDKStatUserAttribute;

/* loaded from: classes.dex */
public interface IStat {
    public static final String STAT_EVENT_ADD_TO_CART = "addToCartReport";
    public static final String STAT_EVENT_ADD_TO_CART_LIST = "addToCartListReport";
    public static final String STAT_EVENT_APP_LAUNCH = "appLaunchReport";
    public static final String STAT_EVENT_INITIALIZE = "initializeReport";
    public static final String STAT_EVENT_PURCHASE_REPORT = "purchaseReport";
    public static final String STAT_EVENT_REPORT = "eventReport";
    public static final String STAT_EVENT_TEST_SPEED = "testSpeedReport";
    public static final String STAT_EVENT_USER_LOGIN = "loginReport";
    public static final String STAT_EVENT_USER_REGISTER = "registerReport";
    public static final String STAT_GET_CHANNEL = "getChannel";
    public static final String STAT_GET_CHANNEL_ID = "getChannelId";
    public static final String STAT_GET_DEVICE_ID = "getDeviceId";
    public static final String STAT_GET_IMEI = "getIMEI";
    public static final String STAT_GET_LOGGABLE = "getLoggable";
    public static final String STAT_GET_USERNAME = "getUserName";
    public static final String STAT_GET_USER_ID = "getUserId";
    public static final String STAT_GET_VERSION = "getVersion";
    public static final String STAT_SET_CHANNEL = "setChannel";
    public static final String STAT_SET_CHANNEL_ID = "setChannelId";
    public static final String STAT_SET_CRASH_REPORT = "crashReport";
    public static final String STAT_SET_DEVICE_ID = "setDeviceId";
    public static final String STAT_SET_EXCEPTION_REPORT = "exceptionReport";
    public static final String STAT_SET_IMEI = "setIMEI";
    public static final String STAT_SET_LOGGABLE = "setLoggable";
    public static final String STAT_SET_USERNAME = "setUserName";
    public static final String STAT_SET_USER_ID = "setUserId";
    public static final String STAT_SET_VERSION = "setVersion";
    public static final String STAT_TRACK_EVENT_BEGIN = "eventTrackBegin";
    public static final String STAT_TRACK_EVENT_END = "eventTrackEnd";
    public static final String STAT_TRACK_PAGE_BEGIN = "pageTrackBegin";
    public static final String STAT_TRACK_PAGE_END = "pageTrackEnd";

    <T> T getAttribute(Class<?> cls, String str, Object... objArr);

    void reportEvent(String str, IMSDKStatEventParams iMSDKStatEventParams);

    void setAttribute(String str, IMSDKStatUserAttribute iMSDKStatUserAttribute);
}
