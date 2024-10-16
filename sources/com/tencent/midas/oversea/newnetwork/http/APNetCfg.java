package com.tencent.midas.oversea.newnetwork.http;

import android.text.TextUtils;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.api.APMidasPayAPI;
import com.tencent.midas.oversea.comm.APSPTools;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.midas.oversea.data.Cfg;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newapi.params.InitParams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APNetCfg {
    public static final String TAG = "APNetCfg";
    public static final String UIIPAY_DETECT_DOMAIN_HK = "szmg.qq.com";
    public static final String UNIPAY_RELEASE_DOMAIN_HK = "hk.api.unipay.qq.com";
    public final String UNIPAY_SANDBOX_DOMAIN_LOCAL = "sandbox.api.unipay.qq.com";
    private final String UNIPAY_RELEASE_REPORT_DOMAIN_LOCAL = UIIPAY_DETECT_DOMAIN_HK;
    private final String NET_CFG_DIR_PREFIX = "midas_oversea_";
    private final String NET_CFG_FILE = "midas_oversea_cp.cfg";
    private ConcurrentHashMap<String, Cfg> mMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Cfg> mSandboxMap = new ConcurrentHashMap<>();

    public APNetCfg() {
        loadLocalData();
    }

    private void loadLocalData() {
        String[] strArr = {"183.61.41.148"};
        this.mSandboxMap.put("local", new Cfg("sandbox.api.unipay.qq.com", strArr, UIIPAY_DETECT_DOMAIN_HK, UNIPAY_RELEASE_DOMAIN_HK));
        this.mSandboxMap.put(InitParams.IDC_CANADA, new Cfg("sandbox.api.unipay.qq.com", strArr));
        this.mSandboxMap.put(InitParams.IDC_HONGKONG, new Cfg("sandbox.api.unipay.qq.com", strArr));
        this.mMap.put("local", new Cfg("sandbox.api.unipay.qq.com", strArr, UIIPAY_DETECT_DOMAIN_HK, UNIPAY_RELEASE_DOMAIN_HK));
    }

    public void init() {
        String str = GlobalData.singleton().IDC;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("idc should be set before init");
        }
        if (initServerCfg()) {
            APLog.i(TAG, str + " configuration contains in server config");
        } else if (initFileCfg()) {
            APLog.i(TAG, str + " configuration contains in file config");
        } else {
            String str2 = GlobalData.singleton().env;
            if ("release".equals(str2) || MConstants.TestEnv.equals(str2)) {
                APLog.i(TAG, "configuration has found");
            } else {
                throw new IllegalArgumentException(str + " not exist,please help to check the name");
            }
        }
        if (APMidasPayAPI.singleton().getApplicationContext() == null) {
            APLog.i(TAG, "there is no context");
            throw new IllegalArgumentException("there is no context");
        }
        if (1 == APSPTools.getInt(APMidasPayAPI.singleton().getApplicationContext(), "domain_first")) {
            GlobalData.singleton().setUseDomainFirst(true);
        }
    }

    private boolean initServerCfg() {
        String str;
        JSONObject optJSONObject;
        String[] parseIPList;
        String str2 = GlobalData.singleton().IDCInfo;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            String str3 = GlobalData.singleton().env;
            JSONObject optJSONObject2 = new JSONObject(str2).optJSONObject(str3);
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject((str = GlobalData.singleton().IDC))) == null) {
                return false;
            }
            String optString = optJSONObject.optString("k_domain");
            JSONArray optJSONArray = optJSONObject.optJSONArray("k_ip_list");
            String optString2 = optJSONObject.optString("k_domain_hb");
            String optString3 = optJSONObject.optString("detect_domain");
            if (TextUtils.isEmpty(optString) || optJSONArray == null || (parseIPList = parseIPList(optJSONArray)) == null) {
                return false;
            }
            APLog.i(TAG, "initServerCfg  OK");
            if (str3.equals("release")) {
                this.mMap.put(str, new Cfg(optString, parseIPList, optString2, optString3));
                return true;
            }
            if (!str3.equals(MConstants.TestEnv)) {
                return true;
            }
            this.mSandboxMap.put(str, new Cfg(optString, parseIPList, optString2, optString3));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean initFileCfg() {
        String str = GlobalData.singleton().IDC;
        String fromAssets = getFromAssets("midas_oversea_" + str + "/midas_oversea_cp.cfg");
        if (TextUtils.isEmpty(fromAssets)) {
            APLog.e(TAG, "midas_oversea_cp.cfg file is missing,if is cp mode ,this must be set");
            return false;
        }
        try {
            JSONArray jSONArray = new JSONObject(fromAssets).getJSONArray(ConfigDBHelper.TABLE_NAME_CONFIG);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("mode");
                String optString2 = jSONObject.optString("domain");
                String optString3 = jSONObject.optString("reportdomain");
                String optString4 = jSONObject.optString("detectdomain");
                APLog.d(TAG, optString + " detectdomain in configFile : " + optString4);
                String[] parseIPList = parseIPList(jSONObject.getJSONArray("iplist"));
                if (parseIPList != null && parseIPList.length != 0) {
                    if ("release".equals(optString)) {
                        this.mMap.put(str, new Cfg(optString2, parseIPList, optString3, optString4));
                    } else if (MConstants.TestEnv.equals(optString)) {
                        this.mSandboxMap.put(str, new Cfg(optString2, parseIPList, optString3, optString4));
                    }
                }
                APLog.e(TAG, "ipList is empty in midas_oversea_cp.cfg file");
                return false;
            }
            APLog.d(TAG, "test config:" + this.mSandboxMap.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String getFromAssets(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(APMidasPayNewAPI.singleton().getApplicationContext().getResources().getAssets().open(str)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return sb2;
        } catch (Exception e3) {
            e = e3;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            if (bufferedReader2 == null) {
                return "";
            }
            try {
                bufferedReader2.close();
                return "";
            } catch (IOException e4) {
                e4.printStackTrace();
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    private String[] parseIPList(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    private Cfg getCfg() {
        Cfg cfg;
        String str = GlobalData.singleton().env;
        String str2 = GlobalData.singleton().IDC;
        if ("release".equals(str)) {
            cfg = this.mMap.get(str2);
        } else {
            cfg = this.mSandboxMap.get(str2);
        }
        if (cfg != null) {
            return cfg;
        }
        throw new IllegalArgumentException(str2 + "  does not deploy " + str + " env!!,please check the params and the  config file in assets");
    }

    public String[] getIPList() {
        return getCfg().mIpList;
    }

    public String getHost() {
        return MConstants.DevEnv.equals(GlobalData.singleton().env) ? "dev.api.unipay.qq.com" : getCfg().mDomain;
    }

    public String getReportDomain() {
        return getCfg().mReportDomain;
    }

    public String getDetectDomain() {
        return getCfg().mDetectDoain;
    }
}
