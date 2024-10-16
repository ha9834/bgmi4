package com.tencent.midas.oversea.newnetwork.http;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.firebase.FirebaseError;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.APSPTools;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import java.util.HashMap;

/* loaded from: classes.dex */
public class NetTimeoutHelper {
    public float[] alphaValues;
    public final int DEFAULT_TIMEOUT = 21000;
    private HashMap<String, String> timeOutMap = new HashMap<>();
    private volatile HashMap<String, Integer> ipRtt = new HashMap<>();
    private volatile HashMap<String, Integer> ipLossRate = new HashMap<>();

    public int getConnectTimeout(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 21000;
        }
        String str3 = this.timeOutMap.get(str);
        if (!TextUtils.isEmpty(str3)) {
            return Integer.parseInt(str3);
        }
        int fileConnectTimeout = getFileConnectTimeout(str);
        if (fileConnectTimeout != 0) {
            int adaptTimeout = adaptTimeout(str2, fileConnectTimeout);
            APLog.d("before request", "adaptTimeout=" + adaptTimeout);
            this.timeOutMap.put(str, String.valueOf(adaptTimeout));
            return adaptTimeout;
        }
        return getDefaultConnectTimeout(str);
    }

    public void setConnectTimeout(String str, int i) {
        this.timeOutMap.put(str, String.valueOf(i));
        try {
            APSPTools.putString(APMidasPayNewAPI.singleton().getApplicationContext(), "network_" + str, String.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getFileConnectTimeout(String str) {
        try {
            String string = APSPTools.getString(APMidasPayNewAPI.singleton().getApplicationContext(), "network_" + str);
            if (TextUtils.isEmpty(string)) {
                return 0;
            }
            return Integer.parseInt(string);
        } catch (Exception e) {
            e.printStackTrace();
            return getDefaultConnectTimeout(str);
        }
    }

    public void setRTT(String str, int i) {
        this.ipRtt.put(str, Integer.valueOf(i));
    }

    public int getRtt(String str) {
        if (this.ipRtt.containsKey(str)) {
            return this.ipRtt.get(str).intValue();
        }
        return 0;
    }

    public void setIpLossRate(String str, int i) {
        this.ipLossRate.put(str, Integer.valueOf(i));
    }

    public int getIpLossRate(String str) {
        if (this.ipLossRate.containsKey(str)) {
            return this.ipLossRate.get(str).intValue();
        }
        return 0;
    }

    public void saveAlpha(float f, float f2) {
        SharedPreferences.Editor edit = APMidasPayNewAPI.singleton().getApplicationContext().getSharedPreferences(APSPTools.SP_NAME, 0).edit();
        edit.putFloat("alpha_rtt", f);
        edit.putFloat("alpha_lostrate", f2);
        edit.apply();
    }

    private int adaptTimeout(String str, int i) {
        if (this.alphaValues == null) {
            readnetworkTimeOutAlpha();
            if (this.alphaValues == null) {
                return i;
            }
        }
        int intValue = this.ipRtt.get(str).intValue();
        float intValue2 = this.ipLossRate.get(str).intValue();
        float[] fArr = this.alphaValues;
        double d = intValue * fArr[0];
        double d2 = intValue2 * fArr[1];
        Double.isNaN(d2);
        Double.isNaN(d);
        int i2 = (int) ((d * (100.0d - d2)) / 100.0d);
        double abs = Math.abs(i2);
        Double.isNaN(abs);
        double d3 = i;
        Double.isNaN(d3);
        return (abs * 1.0d) / d3 < 0.5d ? i + i2 : i;
    }

    private int getDefaultConnectTimeout(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == 1684) {
            if (str.equals("3g")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 1715) {
            if (hashCode == 3649301 && str.equals("wifi")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("4g")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                return 10000;
            case 1:
                return 10000;
            case 2:
                return FirebaseError.ERROR_INVALID_CUSTOM_TOKEN;
            default:
                return 21000;
        }
    }

    private void readnetworkTimeOutAlpha() {
        SharedPreferences sharedPreferences = APMidasPayNewAPI.singleton().getApplicationContext().getSharedPreferences(APSPTools.SP_NAME, 0);
        this.alphaValues = new float[2];
        this.alphaValues[0] = sharedPreferences.getFloat("alpha_rtt", 0.0f);
        this.alphaValues[1] = sharedPreferences.getFloat("alpha_lostrate", 0.0f);
    }
}
