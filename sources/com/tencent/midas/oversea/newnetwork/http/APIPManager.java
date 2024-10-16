package com.tencent.midas.oversea.newnetwork.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.APSPTools;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MIPMeasure;
import com.tencent.mtt.engine.http.HttpUtils;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class APIPManager {
    public static final String TAG = "APIPManager";
    private long updateTime = 0;
    private ArrayList<String> ipList = null;
    private MIPMeasure ipMeasure = null;

    public void init(Context context) {
        String[] iPList;
        this.ipList = new ArrayList<>();
        readSPFile(context);
        if (!this.ipList.isEmpty() || (iPList = GlobalData.singleton().NetCfg().getIPList()) == null || iPList.length <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iPList.length; i++) {
            sb.append(iPList[i]);
            sb.append(";");
            if (!this.ipList.contains(iPList[i])) {
                this.ipList.add(iPList[i]);
            }
        }
        saveSPFile(context, sb.toString());
    }

    public boolean isIPOutdated() {
        return System.currentTimeMillis() - this.updateTime > 14400000;
    }

    public String getRandomIp() {
        int size;
        String sandboxBestIP = getSandboxBestIP();
        if (!TextUtils.isEmpty(sandboxBestIP)) {
            return sandboxBestIP;
        }
        String str = "";
        ArrayList<String> arrayList = this.ipList;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            if (size == 1) {
                str = this.ipList.get(0);
            } else {
                str = this.ipList.get(new Random().nextInt(size));
            }
        }
        return TextUtils.isEmpty(str) ? GlobalData.singleton().NetCfg().getHost() : str;
    }

    public ArrayList<String> getIPList() {
        return new ArrayList<>(this.ipList);
    }

    public void updateIp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList<String> arrayList = this.ipList;
        if (arrayList == null) {
            this.ipList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        StringBuilder sb = new StringBuilder();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.getJSONObject(i).optString("ip");
                if (!TextUtils.isEmpty(optString)) {
                    sb.append(optString);
                    sb.append(";");
                    if (!this.ipList.contains(optString)) {
                        this.ipList.add(optString);
                    }
                }
            }
        } catch (JSONException e) {
            APLog.e(TAG, "decodeIPInfo(): " + e.getMessage());
        }
        this.updateTime = System.currentTimeMillis();
        saveSPFile(context, sb.toString());
        APLog.i(TAG, "updateIP: " + str);
        sandboxIPMeasure();
    }

    private void saveSPFile(Context context, String str) {
        APLog.i(TAG, "saveIPInfo: " + str);
        String str2 = "";
        try {
            str2 = URLEncoder.encode(str, HttpUtils.DEFAULT_ENCODE_NAME);
        } catch (UnsupportedEncodingException e) {
            APLog.e(TAG, "saveSPFile(): " + e.getMessage());
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences(APSPTools.SP_IP_INFO, 0).edit().putString(getIPKey(), str2).putLong(getUpdateTimeKey(), this.updateTime).apply();
    }

    private String readSPFile(Context context) {
        SharedPreferences sp = APSPTools.getSP(context, APSPTools.SP_IP_INFO);
        String string = sp.getString(getIPKey(), "");
        long j = sp.getLong(getUpdateTimeKey(), 0L);
        long j2 = this.updateTime;
        if (j <= j2) {
            j = j2;
        }
        this.updateTime = j;
        String str = "";
        if (!TextUtils.isEmpty(string)) {
            try {
                str = URLDecoder.decode(string, HttpUtils.DEFAULT_ENCODE_NAME);
                APLog.i(TAG, "readSPFile() decodeIPInfo: " + str);
            } catch (UnsupportedEncodingException e) {
                APLog.e(TAG, "init(): " + e.getMessage());
            }
        }
        if (!TextUtils.isEmpty(str) && this.ipList != null) {
            String[] split = str.split(";");
            for (int i = 0; i < split.length; i++) {
                if (!this.ipList.contains(split[i])) {
                    this.ipList.add(split[i]);
                    APLog.i(TAG, "save ip: " + split[i]);
                }
            }
        }
        return str;
    }

    private String getIPKey() {
        return GlobalData.singleton().IDC + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + GlobalData.singleton().env;
    }

    private String getUpdateTimeKey() {
        return GlobalData.singleton().IDC + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + GlobalData.singleton().env + "_updateTime";
    }

    public boolean isLegalIP(String str) {
        ArrayList<String> arrayList = this.ipList;
        return (arrayList == null || arrayList.isEmpty() || !this.ipList.contains(str)) ? false : true;
    }

    private void sandboxIPMeasure() {
        if (APTools.isTestEnv()) {
            if (this.ipMeasure == null) {
                this.ipMeasure = new MIPMeasure(this.ipList);
            }
            this.ipMeasure.measure(null);
        } else {
            MIPMeasure mIPMeasure = this.ipMeasure;
            if (mIPMeasure != null) {
                mIPMeasure.release();
                this.ipMeasure = null;
            }
        }
    }

    private String getSandboxBestIP() {
        MIPMeasure mIPMeasure;
        return (!APTools.isTestEnv() || (mIPMeasure = this.ipMeasure) == null) ? "" : mIPMeasure.getHighestSpeedIP();
    }
}
