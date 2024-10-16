package com.oppo.oiface;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.oplus.cosa.gamemanagersdk.ICosaSdkCallback;
import com.oplus.cosa.gamemanagersdk.ICosaSdkService;
import com.oppo.oiface.IOIfaceNotifier;
import com.oppo.oiface.IOIfaceService;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class OifaceManager {
    private static int BINDER_FLAG = 0;
    public static final String COSA_PKG = "com.oplus.cosa";
    public static final String COSA_SDK_SERVICE_NAME = "com.oplus.cosa.gamemanagersdk.CosaSdkService";
    private static final String TAG = "CosaSdkManager";
    private static final String oppoSdkVersion = "4.1";
    private COSAServiceConnectCallback mAsyncCallback;
    private Context mContext = null;
    private IOIfaceService mOifaceServiceBinder = null;
    private ICosaSdkService mCosaSdkServiceBinder = null;
    private WeakReference<CallBack> mCallBacks = null;
    private ServiceConnection mServiceConnection = new COSAServiceConnection();
    public ICosaSdkCallback mICosaSdkCallback = new ICosaSdkCallback.Stub() { // from class: com.oppo.oiface.OifaceManager.1
        @Override // com.oplus.cosa.gamemanagersdk.ICosaSdkCallback
        public void systemCallBack(String str) {
            Log.d(OifaceManager.TAG, "Cosa notify info is:" + str + " mytid:" + Process.myTid());
            if (OifaceManager.this.mCallBacks == null || OifaceManager.this.mCallBacks.get() == null) {
                return;
            }
            ((CallBack) OifaceManager.this.mCallBacks.get()).systemCallBack(str);
        }
    };
    public IOIfaceNotifier mIOIfaceNotifier = new IOIfaceNotifier.Stub() { // from class: com.oppo.oiface.OifaceManager.2
        @Override // com.oppo.oiface.IOIfaceNotifier
        public void onSystemNotify(String str) {
            Log.d(OifaceManager.TAG, "Oiface notify info is:" + str + " mytid:" + Process.myTid());
            if (OifaceManager.this.mCallBacks == null || OifaceManager.this.mCallBacks.get() == null) {
                return;
            }
            ((CallBack) OifaceManager.this.mCallBacks.get()).systemCallBack(str);
        }
    };

    /* loaded from: classes2.dex */
    public enum BinderServiceType {
        OIFACESERVICE,
        COSASERVICE;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((BinderServiceType) obj);
        }
    }

    /* loaded from: classes2.dex */
    class COSAServiceConnection implements ServiceConnection {
        COSAServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            Log.d(OifaceManager.TAG, "game service onBindingDied");
            OifaceManager.this.mCosaSdkServiceBinder = null;
            if (OifaceManager.this.mAsyncCallback != null) {
                OifaceManager.this.mAsyncCallback.onServiceConnectFail();
            }
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            Log.d(OifaceManager.TAG, "game service onNullBinding");
            OifaceManager.this.mCosaSdkServiceBinder = null;
            if (OifaceManager.this.mAsyncCallback != null) {
                OifaceManager.this.mAsyncCallback.onServiceConnectFail();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(OifaceManager.TAG, "game service connect");
            OifaceManager.this.mCosaSdkServiceBinder = ICosaSdkService.Stub.asInterface(iBinder);
            if (OifaceManager.this.mAsyncCallback != null) {
                OifaceManager.this.mAsyncCallback.onServiceConnected();
            }
            OifaceManager.this.register();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(OifaceManager.TAG, "game service disconnect");
            OifaceManager.this.mCosaSdkServiceBinder = null;
            if (OifaceManager.this.mAsyncCallback != null) {
                OifaceManager.this.mAsyncCallback.onServiceConnectFail();
            }
        }
    }

    public void bind(Context context, COSAServiceConnectCallback cOSAServiceConnectCallback) {
        Log.d(TAG, "bindAsync");
        if (context == null || cOSAServiceConnectCallback == null) {
            Log.e(TAG, "bindAsync: null params!");
            return;
        }
        this.mContext = context;
        this.mAsyncCallback = cOSAServiceConnectCallback;
        Log.d(TAG, "bindAsync: connect cosa");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(COSA_PKG, COSA_SDK_SERVICE_NAME));
        boolean z = false;
        try {
            z = context.bindService(intent, this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "bindAsync: Permission denied.");
        }
        if (z) {
            Log.d(TAG, "bindAsync: bind cosa ret success");
            BINDER_FLAG = BinderServiceType.COSASERVICE.ordinal();
        } else {
            Log.d(TAG, "bindAsync: connect oiface");
            bindOifaceService();
        }
    }

    public void bindOifaceService() {
        this.mOifaceServiceBinder = IOIfaceService.Stub.asInterface(ServiceManager.checkService("oiface"));
        if (this.mOifaceServiceBinder == null) {
            Log.d(TAG, "bind oiface service false");
            COSAServiceConnectCallback cOSAServiceConnectCallback = this.mAsyncCallback;
            if (cOSAServiceConnectCallback != null) {
                cOSAServiceConnectCallback.onServiceConnectFail();
                return;
            }
            return;
        }
        Log.d(TAG, "bind oiface service successful");
        BINDER_FLAG = BinderServiceType.OIFACESERVICE.ordinal();
        COSAServiceConnectCallback cOSAServiceConnectCallback2 = this.mAsyncCallback;
        if (cOSAServiceConnectCallback2 != null) {
            cOSAServiceConnectCallback2.onServiceConnected();
        }
    }

    public String getSdkVersion() {
        if (this.mOifaceServiceBinder == null && this.mCosaSdkServiceBinder == null) {
            Log.d(TAG, "game service is not available");
            return null;
        }
        try {
            if (BINDER_FLAG == BinderServiceType.OIFACESERVICE.ordinal()) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mOifaceServiceBinder.getOifaceversion());
                    sb.append(CertificateUtil.DELIMITER);
                    sb.append(oppoSdkVersion);
                    return sb.toString();
                } catch (DeadObjectException e) {
                    Log.d(TAG, "IOIfaceService currentPackage err: " + e);
                    this.mOifaceServiceBinder = null;
                }
            } else if (BINDER_FLAG == BinderServiceType.COSASERVICE.ordinal()) {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.mCosaSdkServiceBinder.getVersion());
                    sb2.append(CertificateUtil.DELIMITER);
                    sb2.append(oppoSdkVersion);
                    return sb2.toString();
                } catch (DeadObjectException e2) {
                    Log.d(TAG, "ICosaSdkService current package err: " + e2);
                    this.mCosaSdkServiceBinder = null;
                }
            }
        } catch (RemoteException e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public String getTouchLogPath() {
        if (this.mOifaceServiceBinder == null && this.mCosaSdkServiceBinder == null) {
            Log.d(TAG, "game service is not available");
            return null;
        }
        if (BINDER_FLAG != BinderServiceType.OIFACESERVICE.ordinal() && BINDER_FLAG == BinderServiceType.COSASERVICE.ordinal()) {
            try {
                return this.mCosaSdkServiceBinder.getTouchLogPath();
            } catch (DeadObjectException e) {
                Log.d(TAG, "ICosaSdkService current package err: " + e);
                this.mCosaSdkServiceBinder = null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public boolean isTouchLogSupport() {
        if (this.mOifaceServiceBinder == null && this.mCosaSdkServiceBinder == null) {
            Log.d(TAG, "game service is not available");
            return false;
        }
        if (BINDER_FLAG != BinderServiceType.OIFACESERVICE.ordinal() && BINDER_FLAG == BinderServiceType.COSASERVICE.ordinal()) {
            try {
                return this.mCosaSdkServiceBinder.isTouchLogSupport();
            } catch (DeadObjectException e) {
                Log.d(TAG, "ICosaSdkService current package err: " + e);
                this.mCosaSdkServiceBinder = null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public boolean register() {
        if (this.mOifaceServiceBinder == null && this.mCosaSdkServiceBinder == null) {
            Log.d(TAG, "game service is not available");
            return false;
        }
        if (BINDER_FLAG == BinderServiceType.OIFACESERVICE.ordinal()) {
            Log.d(TAG, "register by systemStatus");
            return true;
        }
        if (BINDER_FLAG == BinderServiceType.COSASERVICE.ordinal()) {
            try {
                return this.mCosaSdkServiceBinder.registerCosaSdk(this.mICosaSdkCallback.asBinder());
            } catch (DeadObjectException e) {
                Log.d(TAG, "ICosaSdkService current package err: " + e);
                this.mCosaSdkServiceBinder = null;
            } catch (RemoteException e2) {
                Log.d(TAG, "current package error" + e2);
                return false;
            }
        }
        return false;
    }

    public void systemStatus(IOIfaceNotifier iOIfaceNotifier) {
        StringBuilder sb;
        if (iOIfaceNotifier == null) {
            return;
        }
        if (this.mOifaceServiceBinder == null && this.mCosaSdkServiceBinder == null) {
            Log.d(TAG, "game service is not available");
            try {
                iOIfaceNotifier.onSystemNotify(null);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (BINDER_FLAG == BinderServiceType.OIFACESERVICE.ordinal()) {
            try {
                this.mOifaceServiceBinder.onSystemNotify(iOIfaceNotifier);
                this.mOifaceServiceBinder.onAppRegister();
                return;
            } catch (DeadObjectException e2) {
                Log.d(TAG, "IOIfaceService currentPackage err: " + e2);
                this.mOifaceServiceBinder = null;
                return;
            } catch (RemoteException e3) {
                e = e3;
                sb = new StringBuilder();
            }
        } else {
            if (BINDER_FLAG != BinderServiceType.COSASERVICE.ordinal()) {
                return;
            }
            try {
                this.mCosaSdkServiceBinder.registerNotifier();
                return;
            } catch (DeadObjectException e4) {
                Log.d(TAG, "ICosaSdkService current package err: " + e4);
                this.mCosaSdkServiceBinder = null;
                return;
            } catch (RemoteException e5) {
                e = e5;
                sb = new StringBuilder();
            }
        }
        sb.append("current package error");
        sb.append(e);
        Log.d(TAG, sb.toString());
        e.printStackTrace();
    }

    public void unbind() {
        if (this.mOifaceServiceBinder == null && this.mCosaSdkServiceBinder == null) {
            Log.d(TAG, "game service is not available");
            return;
        }
        if (BINDER_FLAG == BinderServiceType.OIFACESERVICE.ordinal()) {
            this.mOifaceServiceBinder = null;
        } else if (BINDER_FLAG == BinderServiceType.COSASERVICE.ordinal()) {
            this.mContext.unbindService(this.mServiceConnection);
            this.mCosaSdkServiceBinder = null;
            Log.d(TAG, "CosaService unbind.");
        }
    }

    public boolean updateGameInfo(String str) {
        if (this.mOifaceServiceBinder == null && this.mCosaSdkServiceBinder == null) {
            Log.d(TAG, "game service is not available");
            return false;
        }
        if (BINDER_FLAG == BinderServiceType.OIFACESERVICE.ordinal()) {
            try {
                this.mOifaceServiceBinder.updateGameInfo(str);
                return true;
            } catch (DeadObjectException e) {
                Log.d(TAG, "IOIfaceService currentPackage err: " + e);
                this.mOifaceServiceBinder = null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        } else if (BINDER_FLAG == BinderServiceType.COSASERVICE.ordinal()) {
            try {
                return this.mCosaSdkServiceBinder.updateGameInfo(str);
            } catch (DeadObjectException e3) {
                Log.d(TAG, "ICosaSdkService current package err: " + e3);
                this.mCosaSdkServiceBinder = null;
            } catch (RemoteException e4) {
                Log.d(TAG, "current package error" + e4);
                return false;
            }
        }
        return false;
    }
}
