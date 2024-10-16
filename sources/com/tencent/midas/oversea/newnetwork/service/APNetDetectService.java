package com.tencent.midas.oversea.newnetwork.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.connect.common.Constants;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.api.APMidasPayAPI;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APSPTools;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GDPR;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newapi.params.InitParams;
import com.tencent.midas.oversea.newnetwork.http.DnsManager;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import com.tencent.midas.oversea.newnetwork.model.APDetectAns;
import com.tencent.open.SocialOperation;
import com.uqm.crashsight.CrashSight;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APNetDetectService extends Service {
    public static final int IP_DETECT = 0;
    public static final int IP_DETECT_COMPLETED = 2;
    public static final int IP_DETECT_ERROR = 3;
    public static final int IP_START_DETECT = 1;
    public static final int IP_TASKS_FOUND = 4;
    public static final int IP_TASK_FINISHED = 5;
    public static String finalDetectDomain = "szmg.qq.com";
    private Handler detuctServiceHandler = new AnonymousClass1();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public Handler getHandler() {
        return this.detuctServiceHandler;
    }

    /* renamed from: com.tencent.midas.oversea.newnetwork.service.APNetDetectService$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                new Thread(new Runnable() { // from class: com.tencent.midas.oversea.newnetwork.service.APNetDetectService.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long random = (long) (Math.random() * 60.0d * 1000.0d);
                        APLog.d("wait time", "" + random);
                        try {
                            Thread.sleep(random);
                            NetworkManager.singleton().detectTaskQuery(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.newnetwork.service.APNetDetectService.1.1.1
                                @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                                public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                                    APNetDetectService.this.detuctServiceHandler.sendMessage(((APDetectAns) aPMidasHttpAns).getDetuctMsg());
                                }

                                @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                                public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                                    APNetDetectService.this.detuctServiceHandler.sendEmptyMessage(3);
                                }

                                @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                                public void onStop(APMidasHttpAns aPMidasHttpAns) {
                                    APNetDetectService.this.detuctServiceHandler.sendEmptyMessage(3);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                return;
            }
            switch (i) {
                case 3:
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_IPDETECT_ERROR, "error");
                    NetworkManager.singleton().dataReport(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.newnetwork.service.APNetDetectService.1.2
                        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                        public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                            APNetDetectService.this.stopSelf();
                        }

                        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                        public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                            APNetDetectService.this.stopSelf();
                        }

                        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                        public void onStop(APMidasHttpAns aPMidasHttpAns) {
                            APNetDetectService.this.stopSelf();
                        }
                    });
                    return;
                case 4:
                    final Object obj = message.obj;
                    new Thread(new Runnable() { // from class: com.tencent.midas.oversea.newnetwork.service.APNetDetectService.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            APNetDetectService.this.parseTasks((JSONArray) obj);
                        }
                    }).start();
                    return;
                case 5:
                    NetworkManager.singleton().dataReport(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.newnetwork.service.APNetDetectService.1.4
                        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                        public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                            APNetDetectService.this.stopSelf();
                        }

                        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                        public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                            APNetDetectService.this.stopSelf();
                        }

                        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                        public void onStop(APMidasHttpAns aPMidasHttpAns) {
                            APNetDetectService.this.stopSelf();
                        }
                    });
                    APLog.d("APNetDetectService", "waiting for finish");
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseTasks(JSONArray jSONArray) {
        JSONObject jSONObject;
        String string;
        URL url;
        String string2;
        ArrayList<String> arrayList;
        if (jSONArray == null || jSONArray.length() == 0) {
            getHandler().sendEmptyMessage(3);
            return;
        }
        String sysDefaultLocale = APIPDetectTools.getSysDefaultLocale(APMidasPayNewAPI.singleton().getApplicationContext());
        String inputMethodLocale = APIPDetectTools.getInputMethodLocale(APMidasPayNewAPI.singleton().getApplicationContext());
        APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_SYSTEM_LANGUAGE, APTools.urlEncode("sysLocale=" + sysDefaultLocale + "&inputLocale=" + inputMethodLocale, 1));
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                jSONObject = jSONArray.getJSONObject(i);
                string = jSONObject.getString("url");
                APLog.d(getClass().getName(), "Start process task:" + i + ";url=" + string);
                url = new URL(string);
                string2 = jSONObject.has("task_id") ? jSONObject.getString("task_id") : "";
                arrayList = new ArrayList();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!APTools.isIPAddress(url.getHost())) {
                List<String> dnsServer = APIPDetectTools.getDnsServer(APMidasPayAPI.singleton().getApplicationContext());
                if (jSONObject.has("dns") && TextUtils.isEmpty(jSONObject.getString("dns"))) {
                    dnsServer.add(jSONObject.getString("dns"));
                }
                for (String str : dnsServer) {
                    Map<String, String> dnsRequest = APIPDetectTools.dnsRequest(url.getHost(), str);
                    String str2 = dnsRequest.containsKey("ip") ? dnsRequest.get("ip") : "";
                    if (!TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                        arrayList.add(str2);
                        APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_IPDETECT_DNS_RESULT, "taskid=" + string2 + "&result=succ&dnssvr=" + dnsRequest.get("dnssvr") + "&host=" + dnsRequest.get("host") + "&time=" + dnsRequest.get("time") + "&ip=" + str2);
                    } else if (!TextUtils.isEmpty(str2)) {
                        APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_IPDETECT_DNS_RESULT, "taskid=" + string2 + "&result=failed&dnssvr=" + str);
                    }
                }
                if (arrayList.size() == 0) {
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_IPDETECT_ERROR, "result=ip_by_dns_is_null&taskid=" + string2);
                } else if (jSONObject.has("host") && TextUtils.isEmpty(jSONObject.getString("host"))) {
                    arrayList.add(jSONObject.getString("host"));
                }
            } else {
                arrayList.add(url.getHost());
            }
            for (String str3 : arrayList) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("task_id", jSONObject.getString("task_id"));
                jSONObject2.put("originUrl", string);
                jSONObject2.put("currentHost", str3);
                jSONObject2.put("traceroute", APIPDetectTools.monitTraceRoute(str3));
                jSONObject2.put("ping", APIPDetectTools.ping(str3, url.getPort(), 4, 255));
                jSONObject2.put("socket", APIPDetectTools.socketConn(str3, string, url.getPort(), jSONObject.getString("contents"), jSONObject.getString(AnalyticsEventKey.RESPONSE), 2));
                APLog.d(APNetDetectService.class.getName(), "detect host " + url.getHost());
                APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_IPDETECT_CONNECT_TIME, jSONObject2.toString());
            }
        }
        getHandler().sendEmptyMessage(5);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null || intent.getExtras() == null) {
            APLog.w("Detect Service", "get Start Command with null intent");
            return 2;
        }
        initInService(intent);
        initDetectService();
        DnsManager.singleton().prefetchDnsDefault();
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    private void initInService(Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        InitParams.InitParamsExtra initParamsExtra = new InitParams.InitParamsExtra();
        initParamsExtra.setIDCInfo(extras.getString("idcInfo"));
        initParamsExtra.setGoodsZoneID(extras.getString("goodsZoneid"));
        initParamsExtra.setOpenKey(extras.getString("openKey"));
        initParamsExtra.setPF(extras.getString(Constants.PARAM_PLATFORM_ID));
        initParamsExtra.setPFKey(extras.getString("pfKey"));
        initParamsExtra.setSessionID(extras.getString("sessionId"));
        initParamsExtra.setSessionType(extras.getString("sessionType"));
        InitParams build = new InitParams.Builder().setEnv(extras.getString("env")).setIDC(extras.getString("idc")).setOfferID(extras.getString("offerid")).setOpenID(extras.getString("openid")).setZoneID(extras.getString(SocialOperation.GAME_ZONE_ID)).setExtra(initParamsExtra).build();
        APMidasPayNewAPI.singleton().setLogEnable(true);
        APMidasPayNewAPI.singleton().setApplicationContext(getApplicationContext());
        APLog.d("DetectService", "start to init");
        GlobalData.singleton().init(build);
        GDPR.ifCollect = extras.getBoolean("gdprSwitch");
        HeartBeat.singleton().setContext(this).setPeriod(extras.getLong("heartbeat")).setOfferId(build.getOfferID()).setOpenId(build.getOpenID()).start();
    }

    private void initDetectService() {
        String string = APSPTools.getString(APMidasPayNewAPI.singleton().getApplicationContext(), "detect_domain");
        if (!TextUtils.equals(CrashSight.SDK_IS_DEV, string) && !TextUtils.isEmpty(string)) {
            finalDetectDomain = string;
            this.detuctServiceHandler.sendEmptyMessage(1);
        } else {
            APLog.d("InitDetectService", "detectDomainCgi=" + string);
        }
    }
}
