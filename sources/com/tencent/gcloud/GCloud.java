package com.tencent.gcloud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import com.tencent.abase.ConnectionChangeReceiver;
import com.tencent.abase.TX;
import com.tencent.gcloud.plugin.GCloudAppLifecycle;
import com.tencent.gcloud.qr.QRCodeAPI;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import com.tencent.tdm.TDataMaster;

/* loaded from: classes2.dex */
public class GCloud {
    public static final GCloud Instance;
    private static final String NetTAG = "checkNetworkState";
    private static final String TAG = "GCloud";
    private static Context mContext;
    String strJsonConfig = null;
    private ConnectionChangeReceiver mNetworkStateReceiver = null;

    static {
        try {
            System.loadLibrary("gcloudcore");
            System.loadLibrary("TDataMaster");
            System.loadLibrary("gcloud");
        } catch (Throwable th) {
            Log.e(TAG, "GCloud loadLibrary error=" + th.toString());
        }
        Instance = new GCloud();
    }

    private GCloud() {
        Log.i(TAG, "GCloud()");
    }

    public static int GetResourceID(String str, String str2) {
        Context context = mContext;
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getIdentifier(str, str2, mContext.getPackageName());
        } catch (Exception unused) {
            Log.e(TAG, "GetResourceID " + str + " Error");
            return 0;
        }
    }

    private int checkNetworkState() {
        int i = 0;
        try {
        } catch (Exception e) {
            Log.e(NetTAG, "GCloud check" + e.toString());
        }
        if (mContext == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                    Log.i(NetTAG, "Network Type : MOBILE");
                    i = 1;
                    break;
                case 1:
                    Log.i(NetTAG, "Network Type : WIFI");
                    i = 2;
                    break;
                default:
                    Log.i(NetTAG, "Network Type : Other Network Type");
                    break;
            }
        } else {
            Log.e(NetTAG, "netInfo : null. All Networks are disabled");
        }
        return i;
    }

    private native void gcloudInit(Activity activity, Context context);

    private native void gcloudPause();

    private native void gcloudResume();

    public boolean initialize(Activity activity) {
        GCloudAppLifecycle.Instance.onCreate(activity, new Bundle());
        Log.i(TAG, "TX Init");
        TX.Instance.Initialize(activity);
        Log.i(TAG, "TDM Init");
        TDataMaster.getInstance().initialize(activity.getApplicationContext());
        try {
            Log.i(TAG, "GCloud Init");
            gcloudInit(activity, activity.getBaseContext());
        } catch (Throwable th) {
            Log.e(TAG, "Gcloud init error=" + th.toString());
        }
        Log.i(TAG, "QRCoce Init");
        QRCodeAPI.getInstance().QRCodeInit();
        mContext = activity.getApplicationContext();
        this.mNetworkStateReceiver = new ConnectionChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION);
        mContext.registerReceiver(this.mNetworkStateReceiver, intentFilter);
        boolean initializePlugin = PluginManager.Instance.initializePlugin(activity);
        Instance.onNewIntent(activity.getIntent());
        return initializePlugin;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i(TAG, "OnActivityResult requestCode:" + i + " resultCode:" + i2);
        try {
            GCloudAppLifecycle.Instance.onActivityResult(i, i2, intent);
            PluginManager.Instance.onActivityResult(i, i2, intent);
            TDataMaster.getInstance().onActivityResult(i, i2, intent);
        } catch (Exception e) {
            Log.e(TAG, "OnActivityResult exception:" + e.toString());
        }
    }

    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        try {
            if (this.mNetworkStateReceiver != null && mContext != null) {
                mContext.unregisterReceiver(this.mNetworkStateReceiver);
                this.mNetworkStateReceiver = null;
            }
            GCloudAppLifecycle.Instance.onDestroy();
            PluginManager.Instance.onDestroy();
            TDataMaster.getInstance().onDestroy();
        } catch (Exception e) {
            Log.e(TAG, "OnDestroy exception:" + e.toString());
        }
    }

    public void onNewIntent(Intent intent) {
        try {
            GCloudAppLifecycle.Instance.onNewIntent(intent);
            PluginManager.Instance.onNewIntent(intent);
        } catch (Exception e) {
            Log.e(TAG, "HandleCallback exception:" + e.toString());
        }
    }

    public void onPause() {
        Log.i(TAG, "onPause");
        try {
            GCloudAppLifecycle.Instance.onPause();
            PluginManager.Instance.onPause();
            TX.Instance.Pause();
            TDataMaster.getInstance().onPause();
        } catch (Exception e) {
            Log.e(TAG, "onPause exception:" + e.toString());
        }
    }

    public void onRestart() {
        Log.e(TAG, "OnRestart");
        GCloudAppLifecycle.Instance.onRestart();
        TDataMaster.getInstance().onRestart();
    }

    public void onResume() {
        Log.i(TAG, "onResume");
        try {
            GCloudAppLifecycle.Instance.onResume();
            PluginManager.Instance.onResume();
            TX.Instance.Resume();
            TDataMaster.getInstance().onResume();
        } catch (Exception e) {
            Log.i(TAG, "onResume exception:" + e.toString());
        }
    }

    public void onStart() {
        Log.e(TAG, "OnStart");
        GCloudAppLifecycle.Instance.onStart();
        TDataMaster.getInstance().onStart();
    }

    public void onStop() {
        Log.e(TAG, "OnStop");
        GCloudAppLifecycle.Instance.onStop();
        TDataMaster.getInstance().onStop();
    }
}
