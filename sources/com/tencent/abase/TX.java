package com.tencent.abase;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.abase.log.XLog;
import com.tencent.abase.utils.DialogUtils;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
public class TX {
    public static TX Instance = null;
    public static final String TAG = "[GCloudCore]";
    private Context m_cntxt;
    private Thread savedMainThread = null;
    private Handler mHandler = null;
    TXPaths paths = new TXPaths();
    TXSystem xsystem = new TXSystem();
    NetworkStateChecker NetChecker = new NetworkStateChecker();
    private int m_DetailNetworkState = DetailNetworkState.NotReachable.ordinal();
    private int m_Carrier = Carrier.None.ordinal();
    private String m_CarrierCode = "";
    private String m_SSID = "";
    private String m_BSSID = "";
    private String m_CurrentAPN = "";
    private String m_szUdid = null;
    private String m_szBundleId = null;
    private String m_szModel = null;
    private String m_szSysVersion = null;
    private String _appVersion = null;
    private String mDeviceBrand = "";
    SolidConfigReader m_scReader = new SolidConfigReader();

    private int CheckPermission(int i) {
        return -1;
    }

    private native void nativeCreate(Activity activity, Context context, TXPaths tXPaths);

    private native void nativeNSLookupFinishNotify(String str, long j);

    private native void nativeNetworkStateChangeNotify(int i);

    private native void nativePause();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePerform(long j);

    private native void nativePingFinishNotify(String str, long j);

    private native void nativeResume();

    private native void nativeTraceRouteFinishNotify(String str, long j);

    static {
        try {
            System.loadLibrary("gcloudcore");
        } catch (Throwable th) {
            XLog.e(TAG, "loadLibrary libgcloudcore.so error=" + th);
        }
        Instance = new TX();
    }

    public void pingFinishNotify(String str, long j) {
        nativePingFinishNotify(str, j);
    }

    public void traceRouteFinishNotify(String str, long j) {
        nativeTraceRouteFinishNotify(str, j);
    }

    public void nsLookupFinishNotify(String str, long j) {
        nativeNSLookupFinishNotify(str, j);
    }

    public void Pause() {
        try {
            nativePause();
        } catch (Throwable th) {
            XLog.e(TAG, "nativePause call error=" + th);
        }
    }

    public void Resume() {
        try {
            nativeResume();
        } catch (Throwable th) {
            XLog.e(TAG, "nativeResume call error=" + th);
        }
    }

    public void NetworkStateChangeNotify(int i) {
        try {
            nativeNetworkStateChangeNotify(i);
        } catch (Throwable th) {
            XLog.e(TAG, "nativeNetworkStateChangeNotify call error=" + th);
        }
    }

    private TX() {
    }

    void getPaths(Context context) {
        File filesDir = context.getFilesDir();
        File cacheDir = context.getCacheDir();
        this.paths.DataPath = filesDir.getAbsolutePath() + "/";
        this.paths.CachePath = cacheDir.getAbsolutePath() + "/";
        this.paths.AppPath = new File(this.paths.CachePath).getParent() + "/";
        this.paths.InnerCachePath = filesDir.getAbsolutePath() + "/";
        this.paths.InnerFilePath = filesDir.getAbsolutePath() + "/";
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                try {
                    cacheDir = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache"));
                } catch (Exception unused) {
                    XLog.e("TX", "Create cache dir Error");
                }
            } else {
                cacheDir = externalCacheDir;
            }
            this.paths.CachePath = cacheDir.getAbsolutePath() + "/";
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                try {
                    externalFilesDir = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/files"));
                } catch (Exception unused2) {
                    XLog.e("TX", "Create cache dir Error");
                    externalFilesDir = filesDir;
                }
            }
            this.paths.DataPath = externalFilesDir.getAbsolutePath() + "/";
        }
        XLog.i(TAG, "AppPath:" + this.paths.AppPath + ",CachePath:" + this.paths.CachePath + ",DataPath:" + this.paths.DataPath);
    }

    public void Initialize(Activity activity) {
        this.m_cntxt = activity.getApplicationContext();
        getPaths(this.m_cntxt);
        this.savedMainThread = Thread.currentThread();
        CreateMainHandler();
        cacheSystemInfo(this.m_cntxt);
        this.m_scReader.Init(this.m_cntxt);
        URLRequest.init();
        DialogUtils.init(activity);
        SecurityStore.Instance.init(this.m_cntxt);
        try {
            nativeCreate(activity, this.m_cntxt, this.paths);
        } catch (Throwable th) {
            XLog.e(TAG, "nativeCreate call error=" + th);
        }
        XLog.i(TAG, "TX Initialize ends");
    }

    private void cacheSystemInfo(Context context) {
        this.m_szUdid = this.xsystem.GetUdid(context);
        this.m_szBundleId = this.xsystem.GetBundleId(context);
        this.m_szModel = this.xsystem.GetModel();
        this.m_szSysVersion = this.xsystem.GetSysVersion();
        this._appVersion = this.xsystem.GetAppVersion(context);
        this.mDeviceBrand = TXSystem.getDeviceBrand();
    }

    private int checkNetworkState() {
        return this.NetChecker.CheckNetworkState(this.m_cntxt);
    }

    private void getDetailNetworkInfo() {
        this.m_CarrierCode = "";
        this.m_Carrier = Carrier.None.ordinal();
        this.m_CurrentAPN = "";
        this.m_SSID = "";
        this.m_BSSID = "";
        this.m_DetailNetworkState = this.NetChecker.GetDetailNetworkState(this.m_cntxt);
        if (DetailNetworkState.ReachableViaWiFi.ordinal() == this.m_DetailNetworkState) {
            this.m_SSID = this.NetChecker.GetSSID(this.m_cntxt);
            this.m_BSSID = this.NetChecker.GetBSSID(this.m_cntxt);
        } else if (DetailNetworkState.ReachableViaWWAN_2G.ordinal() == this.m_DetailNetworkState || DetailNetworkState.ReachableViaWWAN_3G.ordinal() == this.m_DetailNetworkState || DetailNetworkState.ReachableViaWWAN_4G.ordinal() == this.m_DetailNetworkState || DetailNetworkState.ReachableViaWWAN_UNKNOWN.ordinal() == this.m_DetailNetworkState) {
            this.m_CarrierCode = this.NetChecker.GetCurrentCarrierCode(this.m_cntxt);
            this.m_CurrentAPN = this.NetChecker.GetCurrentAPN(this.m_cntxt);
            this.m_Carrier = this.NetChecker.GetCurrentCarrier(this.m_CarrierCode, this.m_CurrentAPN);
        }
    }

    private void callbackFromJNI(long j) {
        Message message = new Message();
        message.obj = Long.valueOf(j);
        if (Thread.currentThread() == this.savedMainThread) {
            try {
                XLog.i(TAG, "callbackFromJNI nativePerform Main Thread:" + this.savedMainThread + "Current Thread:" + Thread.currentThread());
                nativePerform(j);
                return;
            } catch (Throwable th) {
                XLog.e(TAG, "nativePerform call error=" + th);
                return;
            }
        }
        XLog.i(TAG, "callbackFromJNI Main Thread:" + this.savedMainThread + "Current Thread:" + Thread.currentThread());
        sendMsg(message, this.mHandler);
    }

    private void TXcallJNIperform(long j) {
        try {
            nativePerform(j);
        } catch (Throwable th) {
            XLog.e(TAG, "nativePerform call error=" + th);
        }
    }

    private void CreateMainHandler() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.abase.TX.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                XLog.i(TX.TAG, "handleMessage Main Thread:" + TX.this.savedMainThread + "Current Thread:" + Thread.currentThread());
                try {
                    TX.this.nativePerform(Long.parseLong(message.obj.toString()));
                    return true;
                } catch (Throwable th) {
                    XLog.e(TX.TAG, "nativePerform call error=" + th);
                    return true;
                }
            }
        });
        XLog.i(TAG, "CreateMainHandler success:" + this.mHandler);
    }

    private synchronized void sendMsg(Message message, Handler handler) {
        XLog.i(TAG, "sendMsg before sendMessage:" + this.mHandler);
        this.mHandler.sendMessage(message);
    }

    private int getSolidConfigInt(String str, String str2, int i) {
        return this.m_scReader.GetInt(str, str2, i);
    }

    public String getSolidConfigString(String str, String str2, String str3) {
        return this.m_scReader.GetString(str, str2, str3);
    }

    public boolean getSolidConfigBool(String str, String str2, boolean z) {
        return this.m_scReader.GetBool(str, str2, z);
    }

    private void getSolidConfigAllKeys(String str, List<String> list) {
        this.m_scReader.GetAllKeys(str, list);
    }

    private boolean isSolidConfigContainKey(String str, String str2) {
        return this.m_scReader.IsContainKey(str, str2);
    }

    private String getMetaString(String str, String str2, String str3) {
        return this.m_scReader.GetMetaString(this.m_cntxt, str, str2, str3);
    }
}
