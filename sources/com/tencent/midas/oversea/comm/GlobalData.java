package com.tencent.midas.oversea.comm;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.api.APMidasPayAPI;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newapi.params.InitParams;
import com.tencent.midas.oversea.newnetwork.http.APIPManager;
import com.tencent.midas.oversea.newnetwork.http.APNetCfg;
import com.tencent.midas.oversea.newnetwork.http.NetTimeoutHelper;
import com.uqm.crashsight.CrashSight;

/* loaded from: classes.dex */
public class GlobalData {
    public static final String SDK_VERSION = "4.5.2b";
    public static final String TAG = "GlobalData";
    public static boolean isGoogleNew = true;
    private static String mIV = "";
    private static String mKey = "";
    public static boolean useHighestGoogleApi = true;
    public String IDC;
    public String IDCInfo;
    public String changeVid;
    private String currencyInGw;
    public String env;
    public String goodsZoneID;
    public long heartBeat;
    public boolean ipMeasureSwitch;
    public boolean isSendReport;
    private APIPManager mIpManager;
    private APNetCfg mNetCfg;
    private NetTimeoutHelper mTimeoutHelper;
    public String offerID;
    public String openID;
    public String openKey;
    public String pf;
    public String pfKey;
    public String sessionID;
    private String sessionToken;
    public String sessionType;
    private int uiLevel;
    private boolean useDomainFirst;
    public String userName;
    public String zoneID;

    private GlobalData() {
        this.uiLevel = 0;
        this.IDC = "";
        this.IDCInfo = "";
        this.offerID = "";
        this.openID = "";
        this.openKey = "";
        this.pf = "";
        this.pfKey = "";
        this.sessionID = "";
        this.sessionType = "";
        this.zoneID = "1";
        this.goodsZoneID = "";
        this.userName = "";
        this.env = MConstants.TestEnv;
        this.changeVid = "cpay_4.1.1";
        this.ipMeasureSwitch = true;
        this.isSendReport = true;
        this.sessionToken = "";
        this.mNetCfg = null;
        this.mIpManager = null;
        this.mTimeoutHelper = null;
        this.useDomainFirst = true;
        this.heartBeat = 0L;
        this.currencyInGw = "";
        String string = APSPTools.getString(APMidasPayNewAPI.singleton().getApplicationContext(), "use_highest_google_api");
        if (TextUtils.isEmpty(string) || !TextUtils.equals(CrashSight.SDK_IS_DEV, string.toLowerCase())) {
            return;
        }
        APLog.i(TAG, "useHighestGoogleApi=false");
        useHighestGoogleApi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InstanceHolder {
        static GlobalData instance = new GlobalData();

        private InstanceHolder() {
        }
    }

    public static GlobalData singleton() {
        return InstanceHolder.instance;
    }

    public void init(InitParams initParams) {
        String str = "";
        for (int i = 1; i < 17; i++) {
            str = str + "" + (i % 10);
        }
        APLog.d("CalculateIV", str);
        mIV = str;
        mKey = "" + MConstants.MConstants0 + MConstants.MConstantsAlpha + MConstants.MConstantsBeta;
        String str2 = MConstants.MConstantsDone + MConstants.MConstantsEmma + MConstants.MConstantsFrank;
        mKey += MConstants.MConstantsCell;
        mKey += str2;
        mKey += MConstants.MConstantsGeo + MConstants.MConstantsHolo + MConstants.MConstantsI;
        mKey += MConstants.MConstantsJoker + MConstants.MConstantsKeith;
        mKey += MConstants.MConstantsLength + MConstants.MConstantsMoon;
        APLog.d("CalculateIV", mKey);
        loadInitParams(initParams);
        if (this.mNetCfg == null) {
            this.mNetCfg = new APNetCfg();
        }
        this.mNetCfg.init();
        if (this.mIpManager == null) {
            this.mIpManager = new APIPManager();
        }
        this.mIpManager.init(APMidasPayNewAPI.singleton().getApplicationContext());
    }

    public APNetCfg NetCfg() {
        if (this.mNetCfg == null) {
            this.mNetCfg = new APNetCfg();
            this.mNetCfg.init();
        }
        return this.mNetCfg;
    }

    public APIPManager IPManager() {
        if (this.mIpManager == null) {
            this.mIpManager = new APIPManager();
        }
        return this.mIpManager;
    }

    public NetTimeoutHelper NetTimeout() {
        if (this.mTimeoutHelper == null) {
            this.mTimeoutHelper = new NetTimeoutHelper();
        }
        return this.mTimeoutHelper;
    }

    private void loadInitParams(InitParams initParams) {
        this.IDC = initParams.getIDC();
        this.offerID = initParams.getOfferID();
        this.openID = initParams.getOpenID();
        this.zoneID = initParams.getZoneID();
        InitParams.InitParamsExtra extra = initParams.getExtra();
        if (extra != null) {
            this.IDCInfo = extra.getIDCInfo();
            this.openKey = extra.getOpenKey();
            this.pf = extra.getPf();
            this.pfKey = extra.getPfKey();
            this.sessionID = extra.getSessionID();
            this.sessionType = extra.getSessionType();
            this.goodsZoneID = extra.getGoodsZoneID();
        }
        String env = initParams.getEnv();
        if ("release".equals(env) || MConstants.DevEnv.equals(env)) {
            this.env = env;
        } else {
            this.env = MConstants.TestEnv;
        }
    }

    public void refreshNetToken() {
        this.sessionToken = GDPR.getUUID();
    }

    public void setNetToken(String str) {
        this.sessionToken = str;
    }

    public String getNetToken() {
        return this.sessionToken;
    }

    public String getBaseKey() {
        return mKey;
    }

    public void setMUILevel(@APMidasPayAPI.MUILevel int i) {
        this.uiLevel = i;
    }

    public boolean showLoading() {
        return (this.uiLevel & 1) == 0;
    }

    public boolean showPayResult() {
        return (this.uiLevel & 2) == 0;
    }

    public boolean isUseDomainFirst() {
        return this.useDomainFirst;
    }

    public void setUseDomainFirst(boolean z) {
        this.useDomainFirst = z;
    }

    public static void setKey(String str) {
        mKey = str;
    }

    public static void setIV(String str) {
        mIV = str;
    }

    public static String getIV() {
        return mIV;
    }

    public String getCurrencyInGw() {
        return this.currencyInGw;
    }

    public void setCurrencyInGw(String str) {
        this.currencyInGw = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
