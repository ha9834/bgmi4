package com.tdatamaster.tdm.system;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.tdatamaster.tdm.database.TDMDataBase;
import com.tdatamaster.tdm.device.DeviceInfo;
import com.tdatamaster.tdm.device.DeviceInfoCollect;
import com.tdatamaster.tdm.device.apkchannel.v2.ApkChannelTool;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public class TDMUtils {
    private static final String FY_CHANNEL_ID_DEFAULT = "00000000";
    private static TDMUtils instance = new TDMUtils();
    private static final String tag = "TDMUtils";
    private Context mContext = null;
    private TDMNetworkReceiver mNetworkReceiver = null;
    private boolean mInitialized = false;
    private boolean m_szTestMode = false;
    private boolean m_szAbroad = false;
    private int m_szLogLevel = 2;
    private String m_szAppID = null;
    private String m_szAppKey = null;
    private String m_szAppChannel = null;
    private String m_szBundleId = null;
    private String m_szFilePath = null;
    private String m_szRouterAddressFormal = null;
    private String m_szRouterAddressTest = null;
    private String m_szBeaconAppId = "000001ZG9U3Z6L9O";

    private native void Init();

    private native void OnNetworkChanged(int i, String str);

    public native String EncryptField(String str);

    public native void SetDeviceInfoEncryptKey(String str, String str2);

    public static TDMUtils GetInstance() {
        return instance;
    }

    public void Initialize(Context context) {
        if (context == null) {
            TDMLog.e(tag, "context is null. initialize failed!");
            return;
        }
        if (this.mInitialized) {
            return;
        }
        TDMLog.i(tag, "Initialize begin");
        this.mContext = context;
        TDMDataBase.getInstance().initialize(this.mContext);
        SaveNetworkType();
        Init();
        this.mInitialized = true;
        TDMLog.i(tag, "Initialize end");
    }

    public void RegisterReceiver() {
        if (this.mContext != null) {
            if (this.mNetworkReceiver == null) {
                this.mNetworkReceiver = new TDMNetworkReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION);
            try {
                this.mContext.registerReceiver(this.mNetworkReceiver, intentFilter);
            } catch (Exception e) {
                TDMLog.e(tag, "OnResume Exception");
                TDMLog.i(tag, "Exception Track: " + e);
            }
        }
    }

    public void UnregisterReceiver() {
        TDMNetworkReceiver tDMNetworkReceiver;
        Context context = this.mContext;
        if (context == null || (tDMNetworkReceiver = this.mNetworkReceiver) == null) {
            return;
        }
        try {
            context.unregisterReceiver(tDMNetworkReceiver);
        } catch (Exception e) {
            TDMLog.e(tag, "OnPause Exception");
            TDMLog.i(tag, "Exception Track: " + e);
        }
    }

    public void OnNetworkChanged(int i, boolean z) {
        OnNetworkChanged(i, z ? TDMSystem.getInstance().GetSimOperator(this.mContext) : null);
    }

    public void SetLogLevel(int i) {
        TDMLog.setLogLevel(i);
    }

    public void SaveConfigInfo(Context context) {
        this.m_szAppID = TDMSystem.getInstance().GetMetaString(context, "GCloud.GCloud.GameId");
        String str = this.m_szAppID;
        if (str == null || str.isEmpty()) {
            this.m_szAppID = TDMSystem.getInstance().GetMetaString(context, "GCloud.TDM.AppId");
        }
        this.m_szAppKey = TDMSystem.getInstance().GetMetaString(context, "GCloud.TDM.AppKey");
        this.m_szAppChannel = TDMSystem.getInstance().GetMetaString(context, "GCloud.TDM.AppChannel");
        this.m_szTestMode = TDMSystem.getInstance().GetMetaBool(context, "GCloud.TDM.Test");
        this.m_szAbroad = TDMSystem.getInstance().GetMetaBool(context, "GCloud.TDM.Abroad");
        this.m_szLogLevel = TDMSystem.getInstance().GetMetaInt(context, "GCloud.TDM.LogLevel", this.m_szLogLevel);
        TDMLog.setLogLevel(this.m_szLogLevel);
        this.m_szRouterAddressFormal = TDMSystem.getInstance().GetMetaString(context, "GCloud.TDM.TGEMIT_ROUTER_ADDRESS_FORMAL");
        this.m_szRouterAddressTest = TDMSystem.getInstance().GetMetaString(context, "GCloud.TDM.TGEMIT_ROUTER_ADDRESS_TEST");
        TDMLog.d(tag, "m_szRouterAddressFormal = " + this.m_szRouterAddressFormal);
        TDMLog.d(tag, "m_szRouterAddressTest = " + this.m_szRouterAddressTest);
        File filesDir = context.getFilesDir();
        if (filesDir.exists()) {
            this.m_szFilePath = filesDir.toString();
        }
        String GetMetaString = TDMSystem.getInstance().GetMetaString(context, "GCloud.TDM.BeaconAppId");
        if (GetMetaString != null && !GetMetaString.isEmpty()) {
            this.m_szBeaconAppId = GetMetaString;
        }
        TDMLog.d(tag, "m_szBeaconAppId = " + GetMetaString);
    }

    private void SaveNetworkType() {
        OnNetworkChanged(TDMSystem.getInstance().GetNetworkType(this.mContext).ordinal(), true);
    }

    private long GetAvailMemory() {
        return TDMSystem.getInstance().GetAvailMemory(this.mContext);
    }

    private long GetAvailSpace() {
        return TDMSystem.getInstance().GetAvailSpace();
    }

    public boolean isTestMode() {
        return this.m_szTestMode;
    }

    public boolean isAbroad() {
        return this.m_szAbroad;
    }

    public String getBeaconAppId() {
        return this.m_szBeaconAppId;
    }

    public String getAppVersion() {
        DeviceInfo<String> GetAppVersion;
        return (this.mContext == null || (GetAppVersion = DeviceInfoCollect.getInstance().GetAppVersion(this.mContext)) == null) ? "" : GetAppVersion.value;
    }

    public String getBundleId() {
        DeviceInfo<String> GetBundleId;
        return (this.mContext == null || (GetBundleId = DeviceInfoCollect.getInstance().GetBundleId(this.mContext)) == null) ? "" : GetBundleId.value;
    }

    public int getDiskCheckInterval() {
        if (this.mContext == null) {
            return -1;
        }
        return TDMSystem.getInstance().GetMetaInt(this.mContext, "GCloud.TDM.DiskCheckInterval", -1);
    }

    public int getDiskCheckCritical() {
        if (this.mContext == null) {
            return -1;
        }
        return TDMSystem.getInstance().GetMetaInt(this.mContext, "GCloud.TDM.DiskCheckCritical", -1);
    }

    public long getInternalAvailSpace() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e) {
            TDMLog.e("Error", e.getMessage());
            return -1L;
        }
    }

    public String getFyChannelId() {
        Context context = this.mContext;
        if (context == null) {
            TDMLog.e("Error", "getFlyChannelId failed，need init tdm first");
            return "";
        }
        String str = null;
        try {
            str = ApkChannelTool.readChannel(context.getPackageCodePath());
        } catch (IOException e) {
            TDMLog.e("Error", e.getMessage());
        }
        return str == null ? FY_CHANNEL_ID_DEFAULT : str;
    }
}
