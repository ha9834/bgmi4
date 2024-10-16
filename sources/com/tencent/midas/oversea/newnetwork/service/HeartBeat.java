package com.tencent.midas.oversea.newnetwork.service;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.connect.common.Constants;
import com.tencent.mid.api.MidEntity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GDPR;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newnetwork.http.APHttpsReport;
import com.tencent.mtt.spcialcall.sdk.RecommendParams;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class HeartBeat {
    public static final String TAG = "HeartBeat";
    private boolean isTiming;
    private Context mContext;
    private String offerId;
    private String openId;
    private long tPeriod;
    private Timer timer;

    /* loaded from: classes.dex */
    static class InstanceHolder {
        static HeartBeat instance = new HeartBeat();

        InstanceHolder() {
        }
    }

    public static HeartBeat singleton() {
        return InstanceHolder.instance;
    }

    private HeartBeat() {
        this.mContext = null;
        this.timer = null;
        this.tPeriod = 0L;
        this.isTiming = false;
        this.offerId = "";
        this.openId = "";
    }

    public void start() {
        if (this.tPeriod > 0) {
            if (!this.isTiming && this.timer == null) {
                this.timer = new Timer();
            }
            Timer timer = this.timer;
            if (timer == null || this.isTiming) {
                return;
            }
            this.isTiming = true;
            timer.schedule(new TimerTask() { // from class: com.tencent.midas.oversea.newnetwork.service.HeartBeat.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    HeartBeat.this.report();
                }
            }, 0L, this.tPeriod);
        }
    }

    public void cancel() {
        Timer timer = this.timer;
        if (timer == null || !this.isTiming) {
            return;
        }
        this.isTiming = false;
        timer.cancel();
        this.timer = null;
    }

    public HeartBeat setContext(Context context) {
        this.mContext = context.getApplicationContext();
        return this;
    }

    public HeartBeat setPeriod(long j) {
        this.tPeriod = j;
        APLog.d(TAG, "heartbeat period: " + this.tPeriod);
        return this;
    }

    public HeartBeat setOfferId(String str) {
        this.offerId = str;
        return this;
    }

    public HeartBeat setOpenId(String str) {
        this.openId = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report() {
        TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: com.tencent.midas.oversea.newnetwork.service.HeartBeat.2
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
        treeMap.put("sys_id", "3_7");
        treeMap.put("cmd", "ReportData");
        treeMap.put("req_src", "1");
        treeMap.put("uin_type", "game");
        treeMap.put("scene", FirebaseAnalytics.Event.LOGIN);
        treeMap.put("device_os", "android");
        treeMap.put("action", FirebaseAnalytics.Event.LOGIN);
        treeMap.put("offer_id", GlobalData.singleton().offerID);
        treeMap.put(RecommendParams.KEY_UIN, GlobalData.singleton().openID);
        treeMap.put(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION, GlobalData.SDK_VERSION);
        if (GDPR.ifCollect) {
            treeMap.put("device_guid", GDPR.getDeviceGuid(this.mContext));
            treeMap.put("device_imei", GDPR.getDeviceId(this.mContext));
            treeMap.put(MidEntity.TAG_MAC, GDPR.getMacAddress(this.mContext));
            treeMap.put("device_type", GDPR.getDeviceType());
            treeMap.put("wifi_ssid", GDPR.getWifiSSID(this.mContext));
            treeMap.put("vendor_id", GDPR.getAndroidId(this.mContext));
            treeMap.put("device_name", GDPR.getDeviceName());
            treeMap.put("network_type", String.valueOf(APTools.getNetWorkType(this.mContext)));
            treeMap.put("sys_version", GDPR.getSysVersion());
            treeMap.put("manufacturer", GDPR.getDeviceManufacturer());
            treeMap.put("device", GDPR.getDevice());
            treeMap.put("showModel", GDPR.getDevice());
            String localIp = GDPR.getLocalIp();
            if (!TextUtils.isEmpty(localIp)) {
                treeMap.put("user_ip", localIp);
            }
        }
        treeMap.put("tran_time", String.valueOf(System.currentTimeMillis()));
        StringBuilder sb = new StringBuilder(APTools.map2UrlParams(treeMap));
        StringBuilder sb2 = new StringBuilder(sb);
        String str = "";
        for (int i = 0; i < 5; i++) {
            str = APTools.signString(sb.toString(), "SHA1");
            sb.append(str);
        }
        sb2.append("&");
        sb2.append("sign=");
        sb2.append(str);
        new APHttpsReport().report(sb2.toString());
    }
}
