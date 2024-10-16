package com.tencent.midas.oversea.newapi;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.connect.common.Constants;
import com.tencent.mid.api.MidEntity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.api.APMidasPayAPI;
import com.tencent.midas.oversea.api.IAPMidasNetCallBack;
import com.tencent.midas.oversea.api.IAPMidasPayCallBack;
import com.tencent.midas.oversea.business.APBaseIntroInfo;
import com.tencent.midas.oversea.business.APPayManager;
import com.tencent.midas.oversea.business.IGetProduct;
import com.tencent.midas.oversea.business.pay.MidasResponse;
import com.tencent.midas.oversea.comm.APCommMethod;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APSPTools;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GDPR;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MCycleTimer;
import com.tencent.midas.oversea.comm.MTimer;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;
import com.tencent.midas.oversea.newapi.params.InitParams;
import com.tencent.midas.oversea.newapi.params.MallParams;
import com.tencent.midas.oversea.newapi.params.NetParams;
import com.tencent.midas.oversea.newapi.response.IAPMidasCallback;
import com.tencent.midas.oversea.newapi.response.InfoCallback;
import com.tencent.midas.oversea.newapi.response.NotifyCallback;
import com.tencent.midas.oversea.newnetwork.http.APHttpsReport;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import com.tencent.midas.oversea.newnetwork.service.APNetDetectManager;
import com.tencent.mtt.spcialcall.sdk.RecommendParams;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APMidasPayNewAPI {
    public static final String BUGLY_ID = "900055685";
    public static final String BUGLY_SP_NAME = "BuglySdkInfos";
    public static final String NET_DETECT_ACTION = "com.tencent.midas.oversea.newnetwork.service.APNetDetectService";
    public static final String RE_PROVIDE_ACTION = "com.tencent.midas.oversea.REPROVIDE_UPDATED";
    public static final String TAG = "APMidasPayAPI";
    private Context applicationContext;
    private boolean hasInit;
    private boolean isReprovideTimerOn;
    private long lastClickTime;
    public boolean logEnable;
    private APLogInfo logInfo;
    private NetWorkChangeReceiver networkChangeReceiver;

    private APMidasPayNewAPI() {
        this.lastClickTime = 0L;
        this.hasInit = false;
        this.isReprovideTimerOn = true;
        this.logEnable = false;
        this.logInfo = new APLogInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InstanceHolder {
        static APMidasPayNewAPI instance = new APMidasPayNewAPI();

        InstanceHolder() {
        }
    }

    public static APMidasPayNewAPI singleton() {
        return InstanceHolder.instance;
    }

    public void showMidasUI(@APMidasPayAPI.MUILevel int i) {
        GlobalData.singleton().setMUILevel(i);
    }

    public void setLogEnable(boolean z) {
        if (singleton().applicationContext != null) {
            APLogInfo logInfo = APLog.getLogInfo();
            logInfo.setLogEnable(z);
            APLog.init(logInfo);
            return;
        }
        this.logEnable = z;
    }

    public boolean isLogEnable() {
        return APLog.getLogInfo().isLogEnable();
    }

    public String getEnv() {
        return GlobalData.singleton().env;
    }

    public String getReleaseIDC() {
        return GlobalData.singleton().IDC;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public void setApplicationContext(Context context) {
        this.applicationContext = context;
    }

    public void init(Activity activity, InitParams initParams) {
        this.hasInit = true;
        this.applicationContext = activity.getApplicationContext();
        initLogModule(this.applicationContext);
        loadOutConfig();
        APPayManager.instance().init();
        GlobalData.singleton().init(initParams);
        checkGetIPAndGetKey(initParams);
        initCfgAsync(activity);
        registerReceiver();
        APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_CALL, "name=init");
        reportData("init");
    }

    public void pay(Activity activity, BillingFlowParams billingFlowParams, final IAPMidasPayCallBack iAPMidasPayCallBack) {
        checkFlagStart();
        if (isFastClick()) {
            APLog.i("APMidasPayAPI", "fast click");
            return;
        }
        if (!APTools.isNetworkAvailable(activity)) {
            APTools.setNetwork(activity);
            iAPMidasPayCallBack.MidasPayCallBack(new MidasResponse(-4, "Network not connected."));
            return;
        }
        IAPMidasPayCallBack iAPMidasPayCallBack2 = new IAPMidasPayCallBack() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.1
            @Override // com.tencent.midas.oversea.api.IAPMidasPayCallBack
            public void MidasPayNeedLogin() {
                iAPMidasPayCallBack.MidasPayNeedLogin();
            }

            @Override // com.tencent.midas.oversea.api.IAPMidasPayCallBack
            public void MidasPayCallBack(MidasResponse midasResponse) {
                iAPMidasPayCallBack.MidasPayCallBack(midasResponse);
                if (midasResponse.getResultCode() != 0 && APMidasPayNewAPI.this.isReprovideTimerOn) {
                    APMidasPayNewAPI.this.startTimerReProvide();
                }
                APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_RESPONSE, "name=pay&result=" + midasResponse.getResultCode() + "&msg=" + midasResponse.getResultMsg());
                APMidasPayNewAPI.this.reportData("pay");
            }
        };
        this.applicationContext = activity.getApplicationContext();
        MTimer.start(MTimer.GW_FIRST_SCREEN_SHOWDIALOG);
        APPayManager.instance().pay(activity, billingFlowParams, iAPMidasPayCallBack2);
        APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_CALL, "name=pay&productid=" + billingFlowParams.getProductID());
    }

    public void reProvide(final IAPMidasCallback iAPMidasCallback) {
        checkFlagStart();
        APPayManager.instance().reProvide(new IAPMidasCallback() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.2
            @Override // com.tencent.midas.oversea.newapi.response.IAPMidasCallback
            public void callback(int i, String str) {
                iAPMidasCallback.callback(i, str);
                APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_RESPONSE, "name=reprovide&result=" + i + "&info=" + str);
                APMidasPayNewAPI.this.reportData("reprovide");
            }
        });
        APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_CALL, "name=reprovide");
    }

    public void net(NetParams netParams, final IAPMidasNetCallBack iAPMidasNetCallBack) {
        checkFlagStart();
        String mpReqType = netParams.getMpReqType();
        if (NetParams.GET_SHORT_OPENID.equals(mpReqType)) {
            NetworkManager.singleton().startSecInfo(mpReqType, netParams, new IAPMidasNetCallBack() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.3
                @Override // com.tencent.midas.oversea.api.IAPMidasNetCallBack
                public void MidasNetError(String str, int i, String str2) {
                    iAPMidasNetCallBack.MidasNetError(str, i, str2);
                    APMidasPayNewAPI.this.reportData("net");
                }

                @Override // com.tencent.midas.oversea.api.IAPMidasNetCallBack
                public void MidasNetStop(String str) {
                    iAPMidasNetCallBack.MidasNetStop(str);
                    APMidasPayNewAPI.this.reportData("net");
                }

                @Override // com.tencent.midas.oversea.api.IAPMidasNetCallBack
                public void MidasNetFinish(String str, String str2) {
                    iAPMidasNetCallBack.MidasNetFinish(str, str2);
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_RESPONSE, "name=net&reqType=" + str + "&result=" + str2);
                    APMidasPayNewAPI.this.reportData("net");
                }
            });
        } else {
            NetworkManager.singleton().net(mpReqType, netParams, new IAPMidasNetCallBack() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.4
                @Override // com.tencent.midas.oversea.api.IAPMidasNetCallBack
                public void MidasNetError(String str, int i, String str2) {
                    iAPMidasNetCallBack.MidasNetError(str, i, str2);
                    APMidasPayNewAPI.this.reportData("net");
                }

                @Override // com.tencent.midas.oversea.api.IAPMidasNetCallBack
                public void MidasNetStop(String str) {
                    iAPMidasNetCallBack.MidasNetStop(str);
                    APMidasPayNewAPI.this.reportData("net");
                }

                @Override // com.tencent.midas.oversea.api.IAPMidasNetCallBack
                public void MidasNetFinish(String str, String str2) {
                    iAPMidasNetCallBack.MidasNetFinish(str, str2);
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_RESPONSE, "name=net&result=" + str2);
                    APMidasPayNewAPI.this.reportData("net");
                }
            });
        }
        APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_CALL, "name=net");
    }

    public void mall(Activity activity, MallParams mallParams, final IAPMidasPayCallBack iAPMidasPayCallBack) {
        checkFlagStart();
        try {
            Class<?> cls = Class.forName("com.tencent.midas.oversea.mall.MidasMall");
            cls.getMethod("mall", Activity.class, MallParams.class, IAPMidasPayCallBack.class).invoke(cls.getMethod("singleton", new Class[0]).invoke(null, new Object[0]), activity, mallParams, new IAPMidasPayCallBack() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.5
                @Override // com.tencent.midas.oversea.api.IAPMidasPayCallBack
                public void MidasPayNeedLogin() {
                    iAPMidasPayCallBack.MidasPayNeedLogin();
                }

                @Override // com.tencent.midas.oversea.api.IAPMidasPayCallBack
                public void MidasPayCallBack(MidasResponse midasResponse) {
                    iAPMidasPayCallBack.MidasPayCallBack(midasResponse);
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_RESPONSE, "name=mall&resultMsg=" + midasResponse.getResultMsg() + "&result=" + midasResponse.getResultCode());
                    APMidasPayNewAPI.this.reportData("mall");
                }
            });
        } catch (Exception e) {
            APLog.e("APMidasPayAPI", "mall exception: " + e.getMessage());
            e.printStackTrace();
        }
        APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_CALL, "name=mall");
    }

    public void getProductInfo(String str, List<String> list, final InfoCallback infoCallback) {
        checkFlagStart();
        IGetProduct createProductInfo = APPayManager.instance().channelHelper().createProductInfo(str);
        if (createProductInfo != null) {
            createProductInfo.getProductInfo(this.applicationContext, list, new InfoCallback() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.6
                @Override // com.tencent.midas.oversea.newapi.response.InfoCallback
                public void callback(String str2) {
                    int i;
                    infoCallback.callback(str2);
                    try {
                        i = new JSONObject(str2).getInt("ret");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        i = -1;
                    }
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_RESPONSE, "name=getproductinfo&resp=" + str2 + "&result=" + i);
                    APMidasPayNewAPI.this.reportData("getProductInfo");
                }
            });
        }
        APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_CALL, "name=getproductinfo");
    }

    public void getIntroPriceInfo(String str, List<String> list, final InfoCallback infoCallback) {
        checkFlagStart();
        APBaseIntroInfo createIntroInfoChannel = APPayManager.instance().channelHelper().createIntroInfoChannel(str);
        if (createIntroInfoChannel != null) {
            createIntroInfoChannel.getIntroInfo(this.applicationContext, str, list, new InfoCallback() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.7
                @Override // com.tencent.midas.oversea.newapi.response.InfoCallback
                public void callback(String str2) {
                    int i;
                    infoCallback.callback(str2);
                    try {
                        i = new JSONObject(str2).getInt("ret");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        i = -1;
                    }
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_RESPONSE, "name=getIntroPriceInfo&resp=" + str2 + "&result=" + i);
                    APMidasPayNewAPI.this.reportData("getIntroPriceInfo");
                }
            });
        }
        APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_CALL, "name=getintropriceinfo");
    }

    public void dispose() {
        this.hasInit = false;
        APPayManager.instance().release();
        NetWorkChangeReceiver netWorkChangeReceiver = this.networkChangeReceiver;
        if (netWorkChangeReceiver != null) {
            this.applicationContext.unregisterReceiver(netWorkChangeReceiver);
            this.networkChangeReceiver = null;
        }
        APDataReportManager.instance().insertData(APDataReportManager.SDK_MIDAS_API_CALL, "name=dispose");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimerReProvide() {
        APLog.d("APMidasPayAPI", "startTimerReProvide.");
        new MCycleTimer.Builder().setCount(2).setPeriod(30000L).setUpdateNotifier(new MCycleTimer.CycleTimerUpdateNotifier() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.8
            @Override // com.tencent.midas.oversea.comm.MCycleTimer.CycleTimerUpdateNotifier
            public void onUpdate() {
                APMidasPayNewAPI.this.reProvide(new IAPMidasCallback() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.8.1
                    @Override // com.tencent.midas.oversea.newapi.response.IAPMidasCallback
                    public void callback(int i, String str) {
                        APLog.d("APMidasPayAPI", "startTimerReProvide callback,retCode: " + i + ",info: " + str);
                        if (APMidasPayNewAPI.this.applicationContext != null) {
                            APCommMethod.sendLocalBroadcast(APMidasPayNewAPI.this.applicationContext, APMidasPayNewAPI.RE_PROVIDE_ACTION, i, str);
                        }
                    }
                });
            }
        }).build().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startIPDetectService(InitParams initParams) {
        try {
            PackageManager packageManager = getApplicationContext().getPackageManager();
            if (packageManager == null) {
                return;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(getApplicationContext().getPackageName(), 4);
            if (packageInfo != null && packageInfo.services != null && packageInfo.services.length != 0) {
                for (ServiceInfo serviceInfo : packageInfo.services) {
                    if (NET_DETECT_ACTION.equals(serviceInfo.name)) {
                        APLog.d("APMidasPayAPI", "service registered");
                        APNetDetectManager.startService(getApplicationContext(), initParams);
                        return;
                    }
                }
                return;
            }
            APLog.d("APMidasPayAPI", "no need to detect");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkFlagStart() {
        if (!this.hasInit) {
            throw new IllegalArgumentException("You must call init() api first !!!");
        }
    }

    private boolean checkGetIPAndGetKey(final InitParams initParams) {
        boolean isIPOutdated = GlobalData.singleton().IPManager().isIPOutdated();
        boolean needChangeKey = NetworkManager.singleton().needChangeKey(initParams.getOfferID(), initParams.getOpenID());
        APLog.i("APMidasPayAPI", "needGetIP: " + isIPOutdated + "; needChangeKey: " + needChangeKey);
        if (isIPOutdated || needChangeKey) {
            NetworkManager.singleton().initReq(initParams, new NotifyCallback() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.9
                @Override // com.tencent.midas.oversea.newapi.response.NotifyCallback
                public void onFinish() {
                    APLog.i("APMidasPayAPI", "Init get_ip or get_key finished.");
                    APMidasPayNewAPI.this.startIPDetectService(initParams);
                }
            });
        } else {
            startIPDetectService(initParams);
        }
        return isIPOutdated || needChangeKey;
    }

    private boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.lastClickTime < 800;
        this.lastClickTime = currentTimeMillis;
        return z;
    }

    private void registerReceiver() {
        NetWorkChangeReceiver.pingReport();
    }

    private void initLogModule(Context context) {
        try {
            this.logInfo.setContext(context);
            this.logInfo.setLogTag("TencentPay");
            this.logInfo.setLogEnable(this.logEnable);
            this.logInfo.setAutoFlush(false);
            APLog.init(this.logInfo);
        } catch (Exception unused) {
        }
    }

    private void loadOutConfig() {
        Context context = this.applicationContext;
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(this.applicationContext.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return;
                }
                boolean z = true;
                GDPR.ifCollect = !applicationInfo.metaData.getBoolean("isMidasGdprOn", false);
                this.isReprovideTimerOn = applicationInfo.metaData.getBoolean("isReprovideTimerOn", true);
                StringBuilder sb = new StringBuilder();
                sb.append("isMidasGdprOn: ");
                if (GDPR.ifCollect) {
                    z = false;
                }
                sb.append(z);
                sb.append(",isReprovideTimerOn: ");
                sb.append(this.isReprovideTimerOn);
                APLog.d("APMidasPayAPI", sb.toString());
            } catch (Exception e) {
                APLog.i("APMidasPayAPI", "loadOutConfig() exception: " + e.getMessage());
            }
        }
    }

    private void initCfgAsync(final Activity activity) {
        new Thread(new Runnable() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    APMidasPayNewAPI.this.initCfg(activity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCfg(Activity activity) {
        APSPTools.putString(this.applicationContext, BUGLY_SP_NAME, BUGLY_ID, GlobalData.SDK_VERSION);
        initReport(activity);
    }

    private void initReport(Context context) {
        TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.11
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
            treeMap.put("device_guid", GDPR.getDeviceGuid(context));
            treeMap.put("device_imei", GDPR.getDeviceId(context));
            treeMap.put(MidEntity.TAG_MAC, GDPR.getMacAddress(context));
            treeMap.put("device_type", GDPR.getDeviceType());
            treeMap.put("wifi_ssid", GDPR.getWifiSSID(context));
            treeMap.put("vendor_id", GDPR.getAndroidId(context));
            treeMap.put("device_name", GDPR.getDeviceName());
            treeMap.put("network_type", String.valueOf(APTools.getNetWorkType(context)));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void reportData(final String str) {
        NetworkManager.singleton().dataReport(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.newapi.APMidasPayNewAPI.12
            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                APLog.d(str, "finalDataReport succ");
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                APLog.e(str, "finalDataReport failed");
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onStop(APMidasHttpAns aPMidasHttpAns) {
                APLog.w(str, "finalDataReport stoped");
            }
        });
    }
}
