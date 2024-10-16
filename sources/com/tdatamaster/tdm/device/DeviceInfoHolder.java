package com.tdatamaster.tdm.device;

import android.content.Context;
import com.tdatamaster.tdm.system.FileUtils;
import com.tdatamaster.tdm.system.TDMLog;
import com.tdatamaster.tdm.system.TDMSystem;
import com.tdatamaster.tdm.system.TDMUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DeviceInfoHolder {
    private static final String REMOTE_DEVICE_INFO_ENCRYPT_KEY_KEY = "remote_device_info_encrypt_key";
    private static final String REMOTE_DEVICE_INFO_ENCRYPT_OFFSET_KEY = "remote_device_info_encrypt_offset";
    private static final String REMOTE_DISABLE_COLLECT_DEVICE_INFO_NAME_KEY = "remote_disable_collect_device_info_name";
    private static final String REMOTE_ENCRYPT_COLLECT_DEVICE_INFO_NAME_KEY = "remote_encrypt_collect_device_info_name";
    private static DeviceInfoHolder instance = new DeviceInfoHolder();
    private static final String tag = "DeviceInfoHolder";
    private HashMap<String, DeviceInfo<String>> mDeviceInfoStringMap = new HashMap<>();
    private HashMap<String, DeviceInfo<Long>> mDeviceInfoLongMap = new HashMap<>();
    private HashMap<String, DeviceInfo<Boolean>> mDeviceInfoBoolMap = new HashMap<>();
    private ArrayList<String> mSynDeviceInfoNames = new ArrayList<>();
    private ArrayList<String> mAsynDeviceInfoNames = new ArrayList<>();
    private Context mContext = null;
    private boolean mInitialized = false;
    private volatile boolean mSynInfoCollectComplete = false;
    private ArrayList<String> mDisableDeviceInfoList = new ArrayList<>();
    private ArrayList<String> mEncryptDeviceInfoList = new ArrayList<>();
    private MultiValueMap<IDeviceInfoObserver> mDeviceInfoObserverMap = new MultiValueMap<>();
    private Object lock = new Object();

    public native void SetNewBoolDeviceInfo(String str, boolean z, int i);

    public native void SetNewLongDeviceInfo(String str, long j, int i);

    public native void SetNewStringDeviceInfo(String str, String str2, int i);

    public native boolean isEnableDeviceInfo();

    private DeviceInfoHolder() {
        this.mSynDeviceInfoNames.add(DeviceInfoName.ANDROID_ID_STRING);
        this.mSynDeviceInfoNames.add(DeviceInfoName.APP_VERSION_STRING);
        this.mSynDeviceInfoNames.add(DeviceInfoName.BRAND_STRING);
        this.mSynDeviceInfoNames.add(DeviceInfoName.BUNDLE_ID_STRING);
        this.mSynDeviceInfoNames.add(DeviceInfoName.CPU_CORE_LONG);
        this.mSynDeviceInfoNames.add(DeviceInfoName.CPU_FREQ_LONG);
        this.mSynDeviceInfoNames.add(DeviceInfoName.CPU_NAME_STRING);
        this.mSynDeviceInfoNames.add(DeviceInfoName.DEVICE_ID_STRING);
        this.mSynDeviceInfoNames.add(DeviceInfoName.MAC_ADDR_STRING);
        this.mSynDeviceInfoNames.add(DeviceInfoName.MODEL_STRING);
        this.mSynDeviceInfoNames.add(DeviceInfoName.SCREEN_HEIGHT_LONG);
        this.mSynDeviceInfoNames.add(DeviceInfoName.SCREEN_WIDTH_LONG);
        this.mSynDeviceInfoNames.add(DeviceInfoName.SYS_VERSION_STRING);
        this.mSynDeviceInfoNames.add(DeviceInfoName.TOTAL_MEM_LONG);
        this.mSynDeviceInfoNames.add(DeviceInfoName.TOTAL_SPACE_LONG);
        this.mSynDeviceInfoNames.add(DeviceInfoName.UUID_STRING);
        this.mAsynDeviceInfoNames.add(DeviceInfoName.QIMEI_STRING);
        this.mAsynDeviceInfoNames.add(DeviceInfoName.QIMEI36_STRING);
        this.mAsynDeviceInfoNames.add(DeviceInfoName.TURING_TICKET_STRING);
    }

    public static DeviceInfoHolder GetInstance() {
        return instance;
    }

    public void Initialize(Context context) {
        if (context == null) {
            TDMLog.e(tag, "context is null. initialize failed!");
        } else {
            if (this.mInitialized) {
                return;
            }
            TDMLog.i(tag, "Initialize begin");
            this.mInitialized = true;
            this.mContext = context;
            TDMLog.i(tag, "Initialize end");
        }
    }

    public synchronized HashMap<String, DeviceInfo<String>> getDeviceInfoStringMap() {
        return this.mDeviceInfoStringMap;
    }

    public synchronized HashMap<String, DeviceInfo<Long>> getDeviceInfoLongMap() {
        return this.mDeviceInfoLongMap;
    }

    public synchronized HashMap<String, DeviceInfo<Boolean>> getDeviceInfoBoolMap() {
        return this.mDeviceInfoBoolMap;
    }

    public boolean isSynInfoCollectComplete() {
        return this.mSynInfoCollectComplete;
    }

    private void collectAllDeviceInfoFromSystem(Context context) {
        TDMLog.i(tag, "start collectAllDeviceInfoFromSystem");
        if (this.mSynInfoCollectComplete) {
            TDMLog.i(tag, "need not collectAllDeviceInfoFromSystem!");
            return;
        }
        getDisableDeviceInfoNameList();
        getEncryptDeviceInfoNameList();
        setDeviceInfoEncryptKey();
        Iterator<String> it = this.mSynDeviceInfoNames.iterator();
        while (it.hasNext()) {
            collectSynDeviceInfo(it.next());
        }
        Iterator<String> it2 = this.mAsynDeviceInfoNames.iterator();
        while (it2.hasNext()) {
            collectAsynDeviceInfo(it2.next());
        }
        this.mSynInfoCollectComplete = true;
        notifySynDeviceInfoCollectComplete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [T, java.lang.String] */
    private DeviceInfo collectSynDeviceInfo(String str) {
        HashMap hashMap;
        T t;
        DeviceInfo deviceInfo;
        DeviceInfo GetAndroidID;
        TDMLog.d(tag, "collectSynDeviceInfo deviceInfoName : " + str);
        char c = 3;
        if (!isEnableDeviceInfo()) {
            TDMLog.e(tag, "deviceInfoValueType get fail, disable");
            return new DeviceInfo(str, null, 3);
        }
        Class valueTypeByDeviceInfoName = DeviceInfo.getValueTypeByDeviceInfoName(str);
        if (valueTypeByDeviceInfoName == null) {
            TDMLog.e(tag, "deviceInfoValueType get fail");
            return new DeviceInfo(str, null, 100);
        }
        if (valueTypeByDeviceInfoName == String.class) {
            TDMLog.d(tag, "deviceInfoValue type is String");
            hashMap = this.mDeviceInfoStringMap;
            t = "Unknown";
        } else if (valueTypeByDeviceInfoName == Long.class) {
            TDMLog.d(tag, "deviceInfoValue type is Long");
            hashMap = this.mDeviceInfoLongMap;
            t = -1L;
        } else if (valueTypeByDeviceInfoName == Boolean.class) {
            TDMLog.d(tag, "deviceInfoValue type is Boolean");
            hashMap = this.mDeviceInfoBoolMap;
            t = false;
        } else {
            TDMLog.e(tag, "unsupported deviceInfoValue type");
            return new DeviceInfo(str, null, 100);
        }
        if (!isDeviceInfoCollectEnable(str)) {
            TDMLog.i(tag, str + " is disable collect");
            deviceInfo = new DeviceInfo(str, t, 3);
        } else {
            try {
                switch (str.hashCode()) {
                    case -1843425069:
                        if (str.equals(DeviceInfoName.SCREEN_HEIGHT_LONG)) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1806168640:
                        if (str.equals(DeviceInfoName.MAC_ADDR_STRING)) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1645139641:
                        if (str.equals(DeviceInfoName.CPU_CORE_LONG)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1645047776:
                        if (str.equals(DeviceInfoName.CPU_FREQ_LONG)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1230011043:
                        if (str.equals(DeviceInfoName.BUNDLE_ID_STRING)) {
                            break;
                        }
                        c = 65535;
                        break;
                    case -1159299158:
                        if (str.equals(DeviceInfoName.ANDROID_ID_STRING)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -817389673:
                        if (str.equals(DeviceInfoName.APP_VERSION_STRING)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -785268719:
                        if (str.equals(DeviceInfoName.TOTAL_MEM_LONG)) {
                            c = '\r';
                            break;
                        }
                        c = 65535;
                        break;
                    case 2616251:
                        if (str.equals(DeviceInfoName.UUID_STRING)) {
                            c = 15;
                            break;
                        }
                        c = 65535;
                        break;
                    case 64445287:
                        if (str.equals(DeviceInfoName.BRAND_STRING)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 74517257:
                        if (str.equals(DeviceInfoName.MODEL_STRING)) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case 1173835281:
                        if (str.equals(DeviceInfoName.DEVICE_ID_STRING)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1276865602:
                        if (str.equals(DeviceInfoName.TOTAL_SPACE_LONG)) {
                            c = 14;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1617070234:
                        if (str.equals(DeviceInfoName.SCREEN_WIDTH_LONG)) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1704456243:
                        if (str.equals(DeviceInfoName.CPU_NAME_STRING)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1786577259:
                        if (str.equals(DeviceInfoName.SYS_VERSION_STRING)) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetAndroidID(this.mContext);
                        break;
                    case 1:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetAppVersion(this.mContext);
                        break;
                    case 2:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetBrand();
                        break;
                    case 3:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetBundleId(this.mContext);
                        break;
                    case 4:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetCPUCores();
                        break;
                    case 5:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetCPUMaxFreqKHz();
                        break;
                    case 6:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetCPUName();
                        break;
                    case 7:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetDeviceID(this.mContext);
                        break;
                    case '\b':
                        GetAndroidID = DeviceInfoCollect.getInstance().GetMacAddress(this.mContext);
                        break;
                    case '\t':
                        GetAndroidID = DeviceInfoCollect.getInstance().GetModel();
                        break;
                    case '\n':
                        GetAndroidID = DeviceInfoCollect.getInstance().GetScreenHeight(this.mContext);
                        break;
                    case 11:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetScreenWidth(this.mContext);
                        break;
                    case '\f':
                        GetAndroidID = DeviceInfoCollect.getInstance().GetSysVersion();
                        break;
                    case '\r':
                        GetAndroidID = DeviceInfoCollect.getInstance().GetTotalMemory(this.mContext);
                        break;
                    case 14:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetTotalSpace();
                        break;
                    case 15:
                        GetAndroidID = DeviceInfoCollect.getInstance().GetUUID(this.mContext);
                        break;
                    default:
                        GetAndroidID = new DeviceInfo(str, t, 6);
                        break;
                }
                if (GetAndroidID != null) {
                    GetAndroidID.name = str;
                    if (valueTypeByDeviceInfoName == String.class && GetAndroidID.value != 0 && ((GetAndroidID.status == 0 || GetAndroidID.status == -1) && isDeviceInfoNeedEncrypt(str))) {
                        GetAndroidID.value = TDMUtils.GetInstance().EncryptField((String) GetAndroidID.value);
                        GetAndroidID.status = 1;
                    }
                    if (GetAndroidID.status == -1) {
                        if (GetAndroidID.value == 0) {
                            GetAndroidID.value = t;
                            GetAndroidID.status = 100;
                        } else {
                            GetAndroidID.status = 0;
                        }
                    } else if (GetAndroidID.value == 0) {
                        GetAndroidID.value = t;
                    }
                } else {
                    TDMLog.e(tag, "get deviceInfo is null, deviceInfoName : " + str);
                }
                deviceInfo = GetAndroidID;
            } catch (Throwable th) {
                TDMLog.e(tag, "GetDeviceInfo Catch Exception");
                TDMLog.i(tag, "Exception Track: " + th);
                deviceInfo = new DeviceInfo(str, t, 100);
            }
        }
        if (deviceInfo != null && !isDeviceInfoDisableCache(str)) {
            synchronized (this.lock) {
                hashMap.put(str, deviceInfo);
            }
        }
        return deviceInfo == null ? new DeviceInfo(str, t, 100) : deviceInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0 A[Catch: Throwable -> 0x0103, TryCatch #0 {Throwable -> 0x0103, blocks: (B:27:0x0098, B:35:0x00ca, B:37:0x00ee, B:39:0x00d0, B:41:0x00da, B:43:0x00e4, B:45:0x00ac, B:48:0x00b6, B:51:0x00bf), top: B:26:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00da A[Catch: Throwable -> 0x0103, TryCatch #0 {Throwable -> 0x0103, blocks: (B:27:0x0098, B:35:0x00ca, B:37:0x00ee, B:39:0x00d0, B:41:0x00da, B:43:0x00e4, B:45:0x00ac, B:48:0x00b6, B:51:0x00bf), top: B:26:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4 A[Catch: Throwable -> 0x0103, TryCatch #0 {Throwable -> 0x0103, blocks: (B:27:0x0098, B:35:0x00ca, B:37:0x00ee, B:39:0x00d0, B:41:0x00da, B:43:0x00e4, B:45:0x00ac, B:48:0x00b6, B:51:0x00bf), top: B:26:0x0098 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void collectAsynDeviceInfo(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.device.DeviceInfoHolder.collectAsynDeviceInfo(java.lang.String):void");
    }

    public boolean isDeviceInfoCollectEnable(String str) {
        if (this.mDisableDeviceInfoList != null) {
            return !r0.contains(str);
        }
        return true;
    }

    public boolean isDeviceInfoNeedEncrypt(String str) {
        ArrayList<String> arrayList = this.mEncryptDeviceInfoList;
        return arrayList != null && arrayList.contains(str);
    }

    public void setDeviceInfoFromC(String str, String str2, int i) {
        if (this.mDeviceInfoStringMap.get(str) == null) {
            synchronized (this.lock) {
                this.mDeviceInfoStringMap.put(str, new DeviceInfo<>(str, str2, i));
            }
            notifyAsynDeviceInfoCollectComplete(str, i);
            return;
        }
        TDMLog.e(tag, "same key in map");
    }

    private void setDeviceInfoFromC(String str, long j, int i) {
        if (this.mDeviceInfoStringMap.get(str) == null) {
            synchronized (this.lock) {
                this.mDeviceInfoLongMap.put(str, new DeviceInfo<>(str, Long.valueOf(j), i));
            }
            notifyAsynDeviceInfoCollectComplete(str, i);
            return;
        }
        TDMLog.e(tag, "same key in map");
    }

    private void setDeviceInfoFromC(String str, boolean z, int i) {
        if (this.mDeviceInfoStringMap.get(str) == null) {
            synchronized (this.lock) {
                this.mDeviceInfoBoolMap.put(str, new DeviceInfo<>(str, Boolean.valueOf(z), i));
            }
            notifyAsynDeviceInfoCollectComplete(str, i);
            return;
        }
        TDMLog.e(tag, "same key in map");
    }

    public DeviceInfo<Long> getLongDeviceInfo(String str) {
        TDMLog.i(tag, "getLongDeviceInfo deviceInfoName : " + str);
        if (!isEnableDeviceInfo()) {
            TDMLog.e(tag, "deviceInfoValueType get fail, disable");
            return new DeviceInfo<>(str, -1L, 3);
        }
        collectAllDeviceInfoFromSystem(null);
        if (str == null || str.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName is empty");
            return new DeviceInfo<>(str, -1L, 6);
        }
        if (isSynDeviceInfo(str)) {
            if (!isSynInfoCollectComplete()) {
                TDMLog.e(tag, "TDM not start collect device info");
                return new DeviceInfo<>(str, -1L, 4);
            }
            if (isDeviceInfoDisableCache(str)) {
                str.hashCode();
                TDMLog.e(tag, "this deviceInfoName do not has collect method");
                return new DeviceInfo<>(-1L, 100);
            }
        } else if (isAsynDeviceInfo(str) && !this.mInitialized) {
            TDMLog.e(tag, "TDM not start collect device info");
            return new DeviceInfo<>(str, -1L, 4);
        }
        DeviceInfo<Long> deviceInfo = this.mDeviceInfoLongMap.get(str);
        if (deviceInfo != null) {
            return deviceInfo;
        }
        if (isAsynDeviceInfo(str)) {
            TDMLog.d(tag, "asyn deviceinfo is collecting, deviceInfoName : " + str);
            return new DeviceInfo<>(str, -1L, 5);
        }
        TDMLog.w(tag, "deviceInfo not found, deviceInfoName : " + str);
        return new DeviceInfo<>(str, -1L, 6);
    }

    public DeviceInfo<Boolean> getBoolDeviceInfo(String str) {
        TDMLog.i(tag, "getBoolDeviceInfo deviceInfoName : " + str);
        if (!isEnableDeviceInfo()) {
            TDMLog.e(tag, "deviceInfoValueType get fail, disable");
            return new DeviceInfo<>(str, false, 3);
        }
        collectAllDeviceInfoFromSystem(null);
        if (str == null || str.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName is empty");
            return new DeviceInfo<>(str, false, 6);
        }
        if (isSynDeviceInfo(str)) {
            if (!isSynInfoCollectComplete()) {
                TDMLog.e(tag, "TDM not start collect device info");
                return new DeviceInfo<>(str, false, 4);
            }
            if (isDeviceInfoDisableCache(str)) {
                str.hashCode();
                TDMLog.e(tag, "this deviceInfoName do not has collect method");
                return new DeviceInfo<>(false, 100);
            }
        } else if (isAsynDeviceInfo(str) && !this.mInitialized) {
            TDMLog.e(tag, "TDM not start collect device info");
            return new DeviceInfo<>(str, false, 4);
        }
        DeviceInfo<Boolean> deviceInfo = this.mDeviceInfoBoolMap.get(str);
        if (deviceInfo != null) {
            return deviceInfo;
        }
        if (isAsynDeviceInfo(str)) {
            TDMLog.d(tag, "asyn deviceinfo is collecting, deviceInfoName : " + str);
            return new DeviceInfo<>(str, false, 5);
        }
        TDMLog.w(tag, "deviceInfo not found, deviceInfoName : " + str);
        return new DeviceInfo<>(str, false, 6);
    }

    public DeviceInfo<String> getStringDeviceInfo(String str) {
        TDMLog.i(tag, "getStringDeviceInfo deviceInfoName : " + str);
        if (!isEnableDeviceInfo()) {
            TDMLog.e(tag, "deviceInfoValueType get fail, disable");
            return new DeviceInfo<>(str, "Unknown", 3);
        }
        collectAllDeviceInfoFromSystem(null);
        if (str == null || str.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName is empty");
            return new DeviceInfo<>(str, "Unknown", 6);
        }
        if (isSynDeviceInfo(str)) {
            if (!isSynInfoCollectComplete()) {
                TDMLog.e(tag, "TDM not start collect device info");
                return new DeviceInfo<>(str, "Unknown", 4);
            }
            if (DeviceInfoName.ALL_DEVICE_INFO_STRING.equals(str) || DeviceInfoName.ALL_SYN_DEVICE_INFO_STRING.equals(str)) {
                TDMLog.i(tag, "get all deviceInfo");
                return getAllDeviceInfo(str);
            }
            if (isDeviceInfoDisableCache(str)) {
                TDMLog.i(tag, "deviceInfoName [ " + str + " ] disable cache");
                char c = 65535;
                if (str.hashCode() == 1173835281 && str.equals(DeviceInfoName.DEVICE_ID_STRING)) {
                    c = 0;
                }
                if (c == 0) {
                    return collectSynDeviceInfo(str);
                }
                TDMLog.e(tag, "this deviceInfoName do not has collect method");
                return new DeviceInfo<>("Unknown", 100);
            }
        } else if (isAsynDeviceInfo(str) && !this.mInitialized) {
            TDMLog.e(tag, "TDM not start collect device info");
            return new DeviceInfo<>(str, "Unknown", 4);
        }
        DeviceInfo<String> deviceInfo = this.mDeviceInfoStringMap.get(str);
        if (deviceInfo == null) {
            if (isAsynDeviceInfo(str)) {
                TDMLog.d(tag, "asyn deviceinfo is collecting, deviceInfoName : " + str);
                return new DeviceInfo<>(str, "Unknown", 5);
            }
            TDMLog.w(tag, "deviceInfo not found, deviceInfoName : " + str);
            return new DeviceInfo<>(str, "Unknown", 6);
        }
        if (!DeviceInfoName.DEVICE_ID_STRING.equals(str) || deviceInfo.status != 2) {
            return deviceInfo;
        }
        TDMLog.d(tag, "no permission, collect deviceInfoName : " + str);
        return collectSynDeviceInfo(str);
    }

    private DeviceInfo<String> getAllDeviceInfo(String str) {
        if (!isEnableDeviceInfo()) {
            TDMLog.e(tag, "deviceInfoValueType get fail, disable");
            return new DeviceInfo<>(str, "Unknown", 3);
        }
        try {
            synchronized (this.lock) {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, DeviceInfo<String>> entry : this.mDeviceInfoStringMap.entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", entry.getValue().name);
                        jSONObject.put("value", entry.getValue().value);
                        jSONObject.put("status", entry.getValue().status);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        TDMLog.e(tag, "getStringDeviceInfo JSONException");
                        TDMLog.i(tag, "Exception track : " + e);
                    }
                }
                for (Map.Entry<String, DeviceInfo<Long>> entry2 : this.mDeviceInfoLongMap.entrySet()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", entry2.getValue().name);
                        jSONObject2.put("value", entry2.getValue().value);
                        jSONObject2.put("status", entry2.getValue().status);
                        jSONArray.put(jSONObject2);
                    } catch (JSONException e2) {
                        TDMLog.e(tag, "getStringDeviceInfo JSONException");
                        TDMLog.i(tag, "Exception track : " + e2);
                    }
                }
                for (Map.Entry<String, DeviceInfo<Boolean>> entry3 : this.mDeviceInfoBoolMap.entrySet()) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("name", entry3.getValue().name);
                        jSONObject3.put("value", entry3.getValue().value);
                        jSONObject3.put("status", entry3.getValue().status);
                        jSONArray.put(jSONObject3);
                    } catch (JSONException e3) {
                        TDMLog.e(tag, "getStringDeviceInfo JSONException");
                        TDMLog.i(tag, "Exception track : " + e3);
                    }
                }
                for (String str2 : DeviceInfo.DISABLE_CACHED_DEVICE_INFO_NAMES) {
                    DeviceInfo collectSynDeviceInfo = collectSynDeviceInfo(str2);
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("name", collectSynDeviceInfo.name);
                        jSONObject4.put("value", collectSynDeviceInfo.value);
                        jSONObject4.put("status", collectSynDeviceInfo.status);
                        jSONArray.put(jSONObject4);
                    } catch (JSONException e4) {
                        TDMLog.e(tag, "getStringDeviceInfo JSONException");
                        TDMLog.i(tag, "Exception track : " + e4);
                    }
                }
                if (jSONArray.length() > 0) {
                    return new DeviceInfo<>(str, jSONArray.toString(), 0);
                }
                TDMLog.e(tag, "deviceInfosArr is empty");
                return new DeviceInfo<>(str, "Unknown", 100);
            }
        } catch (Exception e5) {
            TDMLog.e(tag, "getStringDeviceInfo Exception");
            TDMLog.i(tag, "Exception track : " + e5);
            return new DeviceInfo<>(str, "Unknown", 100);
        }
    }

    public int setDeviceInfo(String str, long j) {
        if (str == null || str.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName is empty");
            return 6;
        }
        if (this.mDeviceInfoLongMap.get(str) == null) {
            try {
                synchronized (this.lock) {
                    this.mDeviceInfoLongMap.put(str, new DeviceInfo<>(str, Long.valueOf(j), 0));
                }
                SetNewLongDeviceInfo(str, j, 0);
                notifyAsynDeviceInfoCollectComplete(str, 0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return 0;
        }
        TDMLog.e(tag, "deviceInfoName has exist");
        return 9;
    }

    public int setDeviceInfo(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName or deviceInfoValue is empty");
            return 6;
        }
        if (this.mDeviceInfoStringMap.get(str) == null) {
            try {
                synchronized (this.lock) {
                    this.mDeviceInfoStringMap.put(str, new DeviceInfo<>(str, str2, 0));
                }
                SetNewStringDeviceInfo(str, str2, 0);
                notifyAsynDeviceInfoCollectComplete(str, 0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return 0;
        }
        TDMLog.e(tag, "deviceInfoName has exist");
        return 9;
    }

    public int setDeviceInfo(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName is empty");
            return 6;
        }
        if (this.mDeviceInfoBoolMap.get(str) == null) {
            try {
                synchronized (this.lock) {
                    this.mDeviceInfoBoolMap.put(str, new DeviceInfo<>(str, Boolean.valueOf(z), 0));
                }
                SetNewBoolDeviceInfo(str, z, 0);
                notifyAsynDeviceInfoCollectComplete(str, 0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return 0;
        }
        TDMLog.e(tag, "deviceInfoName has exist");
        return 9;
    }

    private void getDisableDeviceInfoNameList() {
        String str;
        try {
            str = FileUtils.GetInstance().GetDefaultPreferenceByKey(REMOTE_DISABLE_COLLECT_DEVICE_INFO_NAME_KEY, true);
        } catch (Throwable th) {
            th.printStackTrace();
            str = null;
        }
        int i = 0;
        if (str != null && !str.isEmpty()) {
            TDMLog.i(tag, "disable deviceInfoList use remote config");
            try {
                synchronized (this.lock) {
                    JSONArray jSONArray = new JSONArray(str);
                    while (i < jSONArray.length()) {
                        this.mDisableDeviceInfoList.add(jSONArray.getString(i));
                        i++;
                    }
                }
                return;
            } catch (Exception e) {
                TDMLog.e(tag, "getDisableDeviceInfoNameList catch exception, message : " + e.getMessage());
                return;
            }
        }
        TDMLog.i(tag, "disable deviceInfoList use local config");
        String GetMetaString = TDMSystem.getInstance().GetMetaString(this.mContext, "GCloud.TDM.DisableDeviceInfo");
        if (GetMetaString != null) {
            synchronized (this.lock) {
                String[] split = GetMetaString.split(",");
                int length = split.length;
                while (i < length) {
                    String str2 = split[i];
                    if (str2 != null && !str2.isEmpty()) {
                        this.mDisableDeviceInfoList.add(str2);
                    }
                    i++;
                }
            }
        }
    }

    private void getEncryptDeviceInfoNameList() {
        String str;
        try {
            str = FileUtils.GetInstance().GetDefaultPreferenceByKey(REMOTE_ENCRYPT_COLLECT_DEVICE_INFO_NAME_KEY, true);
        } catch (Throwable th) {
            th.printStackTrace();
            str = null;
        }
        int i = 0;
        if (str != null && !str.isEmpty()) {
            TDMLog.i(tag, "encrypt deviceInfoList use remote config");
            try {
                synchronized (this.lock) {
                    JSONArray jSONArray = new JSONArray(str);
                    while (i < jSONArray.length()) {
                        this.mEncryptDeviceInfoList.add(jSONArray.getString(i));
                        i++;
                    }
                }
                return;
            } catch (Exception e) {
                TDMLog.e(tag, "getEncryptDeviceInfoNameList catch exception, message : " + e.getMessage());
                return;
            }
        }
        TDMLog.i(tag, "encrypt deviceInfoList use local config");
        String GetMetaString = TDMSystem.getInstance().GetMetaString(this.mContext, "GCloud.TDM.EncryptDeviceInfo");
        if (GetMetaString != null) {
            synchronized (this.lock) {
                String[] split = GetMetaString.split(",");
                int length = split.length;
                while (i < length) {
                    String str2 = split[i];
                    if (str2 != null && !str2.isEmpty()) {
                        this.mEncryptDeviceInfoList.add(str2);
                    }
                    i++;
                }
            }
        }
    }

    private void setDeviceInfoEncryptKey() {
        String GetDefaultPreferenceByKey = FileUtils.GetInstance().GetDefaultPreferenceByKey(REMOTE_DEVICE_INFO_ENCRYPT_KEY_KEY, true);
        String GetDefaultPreferenceByKey2 = FileUtils.GetInstance().GetDefaultPreferenceByKey(REMOTE_DEVICE_INFO_ENCRYPT_OFFSET_KEY, true);
        if (GetDefaultPreferenceByKey == null || GetDefaultPreferenceByKey.isEmpty() || GetDefaultPreferenceByKey2 == null || GetDefaultPreferenceByKey2.isEmpty()) {
            return;
        }
        TDMUtils.GetInstance().SetDeviceInfoEncryptKey(GetDefaultPreferenceByKey, GetDefaultPreferenceByKey2);
    }

    private boolean isDeviceInfoDisableCache(String str) {
        for (String str2 : DeviceInfo.DISABLE_CACHED_DEVICE_INFO_NAMES) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void addDeviceInfoObserver(IDeviceInfoObserver iDeviceInfoObserver, String str) {
        if (str == null || str.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName is empty");
            iDeviceInfoObserver.onDeviceInfoNotify(6);
            return;
        }
        TDMLog.i(tag, "AddDeviceInfoObserver deviceInfoName : " + str);
        if (isSynDeviceInfo(str)) {
            if (isSynInfoCollectComplete()) {
                TDMLog.i(tag, "now syn info already collect complete");
                if (DeviceInfoName.ALL_DEVICE_INFO_STRING.equals(str) || DeviceInfoName.ALL_SYN_DEVICE_INFO_STRING.equals(str)) {
                    iDeviceInfoObserver.onDeviceInfoNotify(0);
                    return;
                } else {
                    iDeviceInfoObserver.onDeviceInfoNotify(getInnerDeviceInfoStatus(str));
                    return;
                }
            }
            TDMLog.i(tag, "syn info observer insert success");
            synchronized (this.lock) {
                this.mDeviceInfoObserverMap.put(str, iDeviceInfoObserver);
            }
            return;
        }
        if (isAsynDeviceInfo(str)) {
            if (isSynInfoCollectComplete()) {
                int innerDeviceInfoStatus = getInnerDeviceInfoStatus(str);
                if (innerDeviceInfoStatus == 6 || innerDeviceInfoStatus == 5) {
                    TDMLog.i(tag, "asyn info observer insert success");
                    synchronized (this.lock) {
                        this.mDeviceInfoObserverMap.put(str, iDeviceInfoObserver);
                    }
                    return;
                }
                TDMLog.i(tag, "asyn info already collcet complete, deviceInfoName : " + str);
                iDeviceInfoObserver.onDeviceInfoNotify(innerDeviceInfoStatus);
                return;
            }
            TDMLog.i(tag, "asyn info observer insert success");
            synchronized (this.lock) {
                this.mDeviceInfoObserverMap.put(str, iDeviceInfoObserver);
            }
            return;
        }
        int deviceInfoStatus = getDeviceInfoStatus(str);
        if (deviceInfoStatus == 6) {
            TDMLog.i(tag, "custom info observer insert success");
            synchronized (this.lock) {
                this.mDeviceInfoObserverMap.put(str, iDeviceInfoObserver);
            }
            return;
        }
        TDMLog.i(tag, "custom info already collcet complete, deviceInfoName : " + str);
        iDeviceInfoObserver.onDeviceInfoNotify(deviceInfoStatus);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void notifyAsynDeviceInfoCollectComplete(String str, int i) {
        TDMLog.i(tag, "start NotifyAsynDeviceInfoCollectComplete deviceInfoName : " + str + ", status : " + i);
        synchronized (this.lock) {
            if (this.mDeviceInfoObserverMap != null) {
                TDMLog.i(tag, "notify asyn device info");
                ArrayList<IDeviceInfoObserver> arrayList = this.mDeviceInfoObserverMap.get(str);
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<IDeviceInfoObserver> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onDeviceInfoNotify(i);
                    }
                }
                this.mDeviceInfoObserverMap.remove(str);
            } else {
                TDMLog.i(tag, "no deviceInfo observer to notify");
            }
        }
    }

    public void notifySynDeviceInfoCollectComplete() {
        TDMLog.i(tag, "NotifySynDeviceInfoCollectComplete");
        if (this.mDeviceInfoObserverMap != null) {
            synchronized (this.lock) {
                TDMLog.i(tag, "notify syn device info");
                Iterator<Map.Entry<String, ArrayList<IDeviceInfoObserver>>> it = this.mDeviceInfoObserverMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, ArrayList<IDeviceInfoObserver>> next = it.next();
                    if (isSynDeviceInfo(next.getKey())) {
                        Iterator<IDeviceInfoObserver> it2 = next.getValue().iterator();
                        while (it2.hasNext()) {
                            IDeviceInfoObserver next2 = it2.next();
                            if (!next.getKey().equals(DeviceInfoName.ALL_DEVICE_INFO_STRING) && !next.getKey().equals(DeviceInfoName.ALL_SYN_DEVICE_INFO_STRING)) {
                                next2.onDeviceInfoNotify(getInnerDeviceInfoStatus(next.getKey()));
                            }
                            next2.onDeviceInfoNotify(0);
                        }
                        it.remove();
                    }
                }
            }
            return;
        }
        TDMLog.i(tag, "no deviceInfo observer to notify");
    }

    public boolean isSynDeviceInfo(String str) {
        if (DeviceInfoName.ALL_SYN_DEVICE_INFO_STRING.equals(str) || DeviceInfoName.ALL_DEVICE_INFO_STRING.equals(str)) {
            return true;
        }
        return this.mSynDeviceInfoNames.contains(str);
    }

    public boolean isAsynDeviceInfo(String str) {
        return this.mAsynDeviceInfoNames.contains(str);
    }

    private int getInnerDeviceInfoStatus(String str) {
        if (DeviceInfo.getValueTypeByDeviceInfoName(str) == String.class) {
            return getStringDeviceInfo(str).status;
        }
        if (DeviceInfo.getValueTypeByDeviceInfoName(str) == Long.class) {
            return getLongDeviceInfo(str).status;
        }
        if (DeviceInfo.getValueTypeByDeviceInfoName(str) == Boolean.class) {
            return getBoolDeviceInfo(str).status;
        }
        TDMLog.e(tag, "device info type error");
        return 6;
    }

    private int getDeviceInfoStatus(String str) {
        DeviceInfo<String> stringDeviceInfo = getStringDeviceInfo(str);
        if (stringDeviceInfo.status != 6) {
            return stringDeviceInfo.status;
        }
        DeviceInfo<Long> longDeviceInfo = getLongDeviceInfo(str);
        if (longDeviceInfo.status != 6) {
            return longDeviceInfo.status;
        }
        DeviceInfo<Boolean> boolDeviceInfo = getBoolDeviceInfo(str);
        if (boolDeviceInfo.status != 6) {
            return boolDeviceInfo.status;
        }
        return 6;
    }
}
