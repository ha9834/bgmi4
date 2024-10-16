package com.tencent.midas.oversea.business.h5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.business.h5.IWebInterface;

/* loaded from: classes.dex */
public class AIDLHandler {
    public static final String TAG = "AIDLHandler";
    private Context mContext;
    private IWebInterface webInterface = null;
    private AIDLListener mLstener = null;
    private ServiceConnection conn = new ServiceConnection() { // from class: com.tencent.midas.oversea.business.h5.AIDLHandler.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            APLog.i(AIDLHandler.TAG, "onServiceConnected");
            AIDLHandler.this.webInterface = IWebInterface.Stub.asInterface(iBinder);
            if (AIDLHandler.this.mLstener != null) {
                AIDLHandler.this.mLstener.OnServiceConnected();
            }
            try {
                if (AIDLHandler.this.mBinderPoolDeathRecipient != null) {
                    AIDLHandler.this.webInterface.asBinder().linkToDeath(AIDLHandler.this.mBinderPoolDeathRecipient, 0);
                }
            } catch (RemoteException e) {
                APLog.i(AIDLHandler.TAG, "LinkToDeath exception: " + e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            APLog.i(AIDLHandler.TAG, "onServiceDisconnected");
        }
    };
    private IBinder.DeathRecipient mBinderPoolDeathRecipient = new IBinder.DeathRecipient() { // from class: com.tencent.midas.oversea.business.h5.AIDLHandler.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            APLog.i(AIDLHandler.TAG, "binderDied.");
            AIDLHandler.this.webInterface.asBinder().unlinkToDeath(AIDLHandler.this.mBinderPoolDeathRecipient, 0);
            AIDLHandler.this.webInterface = null;
            AIDLHandler.this.bindService();
        }
    };

    /* loaded from: classes.dex */
    interface AIDLListener {
        void OnServiceConnected();
    }

    public AIDLHandler(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void onResponse(int i, int i2, String str) {
        IWebInterface iWebInterface = this.webInterface;
        if (iWebInterface != null) {
            try {
                iWebInterface.onResult(i, i2, str);
                return;
            } catch (RemoteException e) {
                APLog.e(TAG, "onResponse Exception: " + e.getMessage());
                return;
            }
        }
        APLog.i(TAG, "webInterface is null");
    }

    public String queryCacheIP(String str) {
        IWebInterface iWebInterface = this.webInterface;
        if (iWebInterface != null) {
            try {
                return iWebInterface.queryCacheIP(str);
            } catch (RemoteException e) {
                APLog.e(TAG, "queryCacheIP Exception: " + e.getMessage());
                return "";
            }
        }
        APLog.i(TAG, "webInterface is null");
        return "";
    }

    public void release() {
        IWebInterface iWebInterface = this.webInterface;
        if (iWebInterface != null && this.mBinderPoolDeathRecipient != null) {
            iWebInterface.asBinder().unlinkToDeath(this.mBinderPoolDeathRecipient, 0);
            this.mBinderPoolDeathRecipient = null;
            this.webInterface = null;
        }
        unBindService();
    }

    public void bindService() {
        Context context = this.mContext;
        if (context != null) {
            this.mContext.bindService(new Intent(context, (Class<?>) WebService.class), this.conn, 1);
        }
    }

    public void unBindService() {
        ServiceConnection serviceConnection = this.conn;
        if (serviceConnection != null) {
            this.mContext.unbindService(serviceConnection);
            APLog.i(TAG, "unBind service.");
        }
    }

    public void setAIDLListener(AIDLListener aIDLListener) {
        this.mLstener = aIDLListener;
    }
}
