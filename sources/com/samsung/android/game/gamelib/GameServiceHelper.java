package com.samsung.android.game.gamelib;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.samsung.android.game.compatibility.SharedMemory;
import com.samsung.android.game.tencentsdk.ISceneSdkListener;
import com.samsung.android.game.tencentsdk.ISceneSdkService;
import com.samsung.android.game.tencentsdk.IToTGPACallback;

/* loaded from: classes2.dex */
public class GameServiceHelper {
    private static final String TAG = "GameServiceHelper";
    private Context mContext = null;
    private ISceneSdkService mGameServiceBinder = null;
    private Listener mListener = null;
    private BindListener mBindListener = null;
    private ToTGPACallback mToTGPACallback = null;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.samsung.android.game.gamelib.GameServiceHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(GameServiceHelper.TAG, "game service connect");
            GameServiceHelper.this.mGameServiceBinder = ISceneSdkService.Stub.asInterface(iBinder);
            if (GameServiceHelper.this.mBindListener != null) {
                GameServiceHelper.this.mBindListener.bindCallBack();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(GameServiceHelper.TAG, "game service disconnect");
            GameServiceHelper.this.mGameServiceBinder = null;
        }
    };

    /* loaded from: classes2.dex */
    public interface BindListener {
        void bindCallBack();
    }

    /* loaded from: classes2.dex */
    public interface Listener {
        void resultCallBack(int i, int i2);

        void systemCallBack(int i);
    }

    /* loaded from: classes2.dex */
    public interface ToTGPACallback {
        void totgpa(String str);
    }

    public int applyHardwareResource(String str) {
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService == null) {
            Log.d(TAG, "game service is not available");
            return -1;
        }
        try {
            return iSceneSdkService.applyHardwareResource(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int applyThreadGuarantee(String str) {
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService == null) {
            Log.d(TAG, "game service is not available");
            return -1;
        }
        try {
            return iSceneSdkService.applyThreadGuarantee(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void bind(Context context) {
        this.mContext = context;
        String str = "com.enhance.gameservice";
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            try {
                packageManager.getPackageInfo("com.samsung.android.game.gos", 128);
                str = "com.samsung.android.game.gos";
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d(TAG, "New package doesn't exist.");
            }
        }
        Log.d(TAG, "targetPkgName: " + str);
        Intent intent = new Intent("com.samsung.android.game.tencentsdk.SceneSdkService");
        intent.setPackage(str);
        Context context2 = this.mContext;
        if (context2 != null) {
            Log.i(TAG, "bindService. ret: " + context2.bindService(intent, this.mServiceConnection, 1));
        }
    }

    public String getVendorSupportStrategy(String str) {
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService == null) {
            Log.d(TAG, "game service is not available");
            return "ERROR";
        }
        try {
            return iSceneSdkService.getVendorSupportStrategy(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public float getVersion() {
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService == null) {
            Log.d(TAG, "game service is not available");
            return 0.0f;
        }
        try {
            return iSceneSdkService.getVersion();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public boolean init() {
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService == null) {
            Log.d(TAG, "game service is not available");
            return false;
        }
        try {
            return iSceneSdkService.initSceneSdk();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int initLowLatencyIPC(String str, SharedMemory sharedMemory) {
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService == null) {
            Log.d(TAG, "game service is not available");
            return -1;
        }
        try {
            return iSceneSdkService.initLowLatencyIPC(str, sharedMemory);
        } catch (RemoteException e) {
            Log.d(TAG, "game service remote exception");
            e.printStackTrace();
            return -1;
        }
    }

    public void registerBindListener(BindListener bindListener) {
        this.mBindListener = bindListener;
    }

    public boolean registerListener(Listener listener) {
        this.mListener = listener;
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService != null) {
            if (this.mListener == null) {
                try {
                    return iSceneSdkService.setSceneSdkListener(null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                return this.mGameServiceBinder.setSceneSdkListener(new ISceneSdkListener.Stub() { // from class: com.samsung.android.game.gamelib.GameServiceHelper.3
                    @Override // com.samsung.android.game.tencentsdk.ISceneSdkListener
                    public void resultCallBack(int i, int i2) {
                        GameServiceHelper.this.mListener.resultCallBack(i, i2);
                    }

                    @Override // com.samsung.android.game.tencentsdk.ISceneSdkListener
                    public void systemCallBack(int i) {
                        GameServiceHelper.this.mListener.systemCallBack(i);
                    }
                });
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public int registerToTGPACallback(ToTGPACallback toTGPACallback, float f) {
        this.mToTGPACallback = toTGPACallback;
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService == null) {
            Log.d(TAG, "game service is not available");
            return -1;
        }
        try {
            if (this.mToTGPACallback == null) {
                return iSceneSdkService.registerToTGPACallback(null, f);
            }
            return this.mGameServiceBinder.registerToTGPACallback(new IToTGPACallback.Stub() { // from class: com.samsung.android.game.gamelib.GameServiceHelper.2
                @Override // com.samsung.android.game.tencentsdk.IToTGPACallback
                public void totgpa(String str) {
                    GameServiceHelper.this.mToTGPACallback.totgpa(str);
                }
            }, f);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String totgpa() {
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService == null) {
            Log.d(TAG, "game service is not available");
            return "ERROR";
        }
        try {
            return iSceneSdkService.totgpa();
        } catch (RemoteException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public void unbind() {
        Context context = this.mContext;
        if (context == null || this.mGameServiceBinder == null) {
            return;
        }
        this.mGameServiceBinder = null;
        try {
            context.unbindService(this.mServiceConnection);
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "unbind can't be called. Error: " + e.getMessage());
        }
    }

    public int updateGameInfo(String str) {
        ISceneSdkService iSceneSdkService = this.mGameServiceBinder;
        if (iSceneSdkService == null) {
            Log.d(TAG, "game service is not available");
            return -1;
        }
        try {
            return iSceneSdkService.updateGameInfo(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
