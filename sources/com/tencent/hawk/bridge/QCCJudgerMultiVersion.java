package com.tencent.hawk.bridge;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import com.shieldtunnel.svpn.common.ErrorCode;
import com.tencent.mtt.engine.http.HttpUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class QCCJudgerMultiVersion {
    private int mErrorCode;
    private Map<String, QccConfig> multiVersionConfigMap;
    private int mQccVersion = 0;
    private Map<String, Integer> mConfigResult = null;

    /* loaded from: classes2.dex */
    public static class QCCParam {
        String manu = null;
        String model = null;
        String gpuVendor = null;
        String gpuRenderer = null;
        String socPlat = null;
        int ram = 0;
        int cpuCore = 0;
        int cpuFreq = 0;
        int resolution = 0;

        public String toString() {
            return this.manu + "-" + this.model + "-" + this.gpuVendor + "-" + this.gpuRenderer + "-" + this.socPlat + "-" + String.valueOf(this.ram) + "-" + String.valueOf(this.cpuCore) + "-" + String.valueOf(this.cpuFreq) + "-" + String.valueOf(this.resolution);
        }
    }

    public QCCJudgerMultiVersion() {
        this.multiVersionConfigMap = null;
        this.mErrorCode = 0;
        this.multiVersionConfigMap = new HashMap();
        this.mErrorCode = 0;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void clearContext() {
        this.multiVersionConfigMap.clear();
        this.mQccVersion = 0;
    }

    public boolean parseQccFile(InputStream inputStream) {
        if (Build.VERSION.SDK_INT < 11) {
            HawkLogger.e("current sdk level under honeyComb, return");
            this.mErrorCode = -1;
            return false;
        }
        if (inputStream == null) {
            HawkLogger.e("STREAM IS NULL");
            this.mErrorCode = -2;
            return false;
        }
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, HttpUtils.DEFAULT_ENCODE_NAME));
            jsonReader.setLenient(true);
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                        EventDispatcher.dispatchEvent(ErrorCode.SOCKET_REGISTER_ERROR, "next error:" + jsonReader.peek() + " " + inputStream.available());
                        this.mErrorCode = -4;
                        try {
                            jsonReader.close();
                            return false;
                        } catch (IOException unused) {
                            this.mErrorCode = -10;
                            return false;
                        }
                    }
                    jsonReader.beginObject();
                    boolean z = false;
                    while (jsonReader.hasNext()) {
                        String nextName = jsonReader.nextName();
                        if ("version".equals(nextName)) {
                            this.mQccVersion = jsonReader.nextInt();
                        } else if (!"configureList".equals(nextName) || jsonReader.peek() == JsonToken.NULL) {
                            if (!arrayList.contains(nextName)) {
                                jsonReader.skipValue();
                                HawkLogger.e("Qcc,bad prefix," + nextName);
                            } else {
                                if (!z) {
                                    HawkLogger.e("config list is not initialized");
                                    this.mErrorCode = -7;
                                    try {
                                        jsonReader.close();
                                        return false;
                                    } catch (IOException unused2) {
                                        this.mErrorCode = -10;
                                        return false;
                                    }
                                }
                                QccConfig qccConfig = new QccConfig();
                                if (!qccConfig.parseQccConfig(jsonReader)) {
                                    HawkLogger.e("Qcc,Parse qcc config failed");
                                    this.mErrorCode = -8;
                                    try {
                                        jsonReader.close();
                                        return false;
                                    } catch (IOException unused3) {
                                        this.mErrorCode = -10;
                                        return false;
                                    }
                                }
                                HawkLogger.e("Add current qcc to map " + nextName);
                                this.multiVersionConfigMap.put(nextName, qccConfig);
                                HawkLogger.e("put finished");
                            }
                        } else {
                            if (jsonReader.peek() != JsonToken.BEGIN_ARRAY) {
                                HawkLogger.e("Next is not [");
                                EventDispatcher.dispatchEvent(1015, "next error");
                                this.mErrorCode = -5;
                                try {
                                    jsonReader.close();
                                    return false;
                                } catch (IOException unused4) {
                                    this.mErrorCode = -10;
                                    return false;
                                }
                            }
                            readStringArray(jsonReader, arrayList);
                            if (arrayList.size() == 0) {
                                HawkLogger.e("Qcc config list is empty, return");
                                this.mErrorCode = -6;
                                try {
                                    jsonReader.close();
                                    return false;
                                } catch (IOException unused5) {
                                    this.mErrorCode = -10;
                                    return false;
                                }
                            }
                            z = true;
                        }
                    }
                    jsonReader.endObject();
                    try {
                        jsonReader.close();
                        HawkLogger.e("parse finished");
                        return z;
                    } catch (IOException unused6) {
                        this.mErrorCode = -10;
                        return false;
                    }
                } catch (Throwable th) {
                    try {
                        jsonReader.close();
                        throw th;
                    } catch (IOException unused7) {
                        this.mErrorCode = -10;
                        return false;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                HawkLogger.e("Qcc, Exception occured: " + e.getMessage());
                String message = e.getMessage();
                if (message == null) {
                    EventDispatcher.dispatchEvent(ErrorCode.SOCKET_UNREGISTER_ERROR, Constant.APM_CFG_GPU_NA);
                } else if (message.length() > 32) {
                    EventDispatcher.dispatchEvent(ErrorCode.SOCKET_UNREGISTER_ERROR, message.substring(0, 31));
                } else {
                    EventDispatcher.dispatchEvent(ErrorCode.SOCKET_UNREGISTER_ERROR, message);
                }
                this.mErrorCode = -9;
                try {
                    jsonReader.close();
                    return false;
                } catch (IOException unused8) {
                    this.mErrorCode = -10;
                    return false;
                }
            }
        } catch (UnsupportedEncodingException e2) {
            HawkLogger.e("utf-8 reader failed " + e2.getMessage());
            this.mErrorCode = -3;
            return false;
        }
    }

    private void readStringArray(JsonReader jsonReader, List<String> list) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String nextString = jsonReader.nextString();
            if (nextString != null) {
                list.add(nextString.trim().toLowerCase(Locale.ENGLISH));
                stringBuffer.append(nextString + "-");
            }
        }
        jsonReader.endArray();
    }

    public int judgeDcls(QCCParam qCCParam, String str) {
        if (Build.VERSION.SDK_INT < 11) {
            HawkLogger.w("current sdk level under honeyComb, return");
            return 0;
        }
        if (!this.multiVersionConfigMap.containsKey(str)) {
            HawkLogger.e("config list does not contains config:" + str);
            return 0;
        }
        return this.multiVersionConfigMap.get(str).judgeDcls(qCCParam);
    }

    public void judgeDclsBatch(QCCParam qCCParam, Map<String, Integer> map) {
        Map<String, Integer> map2 = this.mConfigResult;
        if (map2 == null) {
            this.mConfigResult = new HashMap();
            for (Map.Entry<String, QccConfig> entry : this.multiVersionConfigMap.entrySet()) {
                String key = entry.getKey();
                int judgeDcls = entry.getValue().judgeDcls(qCCParam);
                this.mConfigResult.put(key, Integer.valueOf(judgeDcls));
                map.put(key, Integer.valueOf(judgeDcls));
                HawkLogger.d("qcc batch put key: " + key);
            }
            return;
        }
        for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
            map.put(entry2.getKey(), entry2.getValue());
        }
    }

    public int getQccVersion() {
        return this.mQccVersion;
    }
}
