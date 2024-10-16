package com.tencent.midas.oversea.comm;

import com.tencent.midas.comm.APLog;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MTimer {
    public static final String GW_FIRST_SCREEN_SHOWDIALOG = "gw_first_screen_showdialog";
    public static final String GW_PROCESS_INIT = "gw_init";
    public static final String GW_PROCESS_PAY = "gw_pay";
    public static final String GW_PROCESS_POSTPAY = "gw_postpay";
    public static final String GW_PROCESS_PREPAY = "gw_prepay";
    public static final String GW_PROCESS_SHOW_DIALOG = "gw_showdialog";
    public static final String SDK_PROCESS_ACTIVITY = "start_proxy_activity";
    public static final String SDK_PROCESS_SHOWLOADING = "show_loading";
    public static final String SDK_WEBVIEW_DOM_LOAD = "webview_dom_load";
    public static final String SDK_WEBVIEW_LOAD = "webview_load";
    public static final String SDK_WEBVIEW_PAGE_LOAD = "page_load";
    public static final String SDK_WEBVIEW_PROCESS_LOAD = "process_load";
    public static final String TAG = "MTimer";
    private static HashMap<String, TimerEvent> tRecords = new HashMap<>();

    /* loaded from: classes.dex */
    static class TimerEvent {
        public long startTime = 0;
        public long duration = 0;

        TimerEvent() {
        }
    }

    public static void start(String str) {
        TimerEvent timerEvent = new TimerEvent();
        timerEvent.startTime = System.currentTimeMillis();
        tRecords.put(str, timerEvent);
    }

    public static long stop(String str) {
        TimerEvent timerEvent = tRecords.get(str);
        if (timerEvent != null) {
            long currentTimeMillis = System.currentTimeMillis() - timerEvent.startTime;
            timerEvent.duration = currentTimeMillis > 0 ? currentTimeMillis : 0L;
            return timerEvent.duration;
        }
        APLog.d(TAG, str + " is missing");
        return 0L;
    }

    public static long duration(String str) {
        long j;
        TimerEvent timerEvent = tRecords.get(str);
        if (timerEvent != null) {
            j = timerEvent.duration;
            tRecords.remove(str);
        } else {
            j = 0;
        }
        APLog.d(TAG, str + " duration: " + j);
        return j;
    }
}
