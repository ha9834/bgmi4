package com.ihoc.mgpa.dataforwardsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.ihoc.mgpa.dataforwardsdk.IDataForward;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class TGPADataForwardManager {
    private static final String ACTION_DATAFORWARD_SERVER = "com.ihoc.mgpa.ACTION_DATAFORWARD";
    private static final String TAG = "TGPA_DataForward";
    private ICallBack mCallback;
    private Context mContext;
    private Map<String, IDataForward> mServerMap = new HashMap();
    private Map<String, ServerConnection> mServerConnectionMap = new HashMap();

    /* loaded from: classes2.dex */
    private class ServerConnection implements ServiceConnection {
        private ServerConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(TGPADataForwardManager.TAG, "onServiceConnected: ComponentName=" + componentName);
            IDataForward asInterface = IDataForward.Stub.asInterface(iBinder);
            if (asInterface != null) {
                TGPADataForwardManager.this.mServerMap.put(componentName.getPackageName(), asInterface);
                try {
                    asInterface.registerGameCallback(TGPADataForwardManager.this.mCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.w(TGPADataForwardManager.TAG, "onServiceDisconnected: ComponentName=" + componentName);
            TGPADataForwardManager.this.mServerMap.remove(componentName.getPackageName());
            TGPADataForwardManager.this.mServerConnectionMap.remove(componentName.getPackageName());
        }
    }

    public TGPADataForwardManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void bind() {
        Intent intent = new Intent(ACTION_DATAFORWARD_SERVER);
        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 131072);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            Log.e(TAG, "dataforward Server isn't exist!!!");
            return;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            ServerConnection serverConnection = new ServerConnection();
            try {
                if (this.mContext.bindService(intent2, serverConnection, 0)) {
                    this.mServerConnectionMap.put(componentName.getPackageName(), serverConnection);
                }
            } catch (Exception unused) {
                Log.e(TAG, "bind service failed: service=" + componentName);
            }
        }
    }

    public void registerCallBack(ICallBack iCallBack) {
        this.mCallback = iCallBack;
        Iterator<Map.Entry<String, IDataForward>> it = this.mServerMap.entrySet().iterator();
        while (it.hasNext()) {
            IDataForward value = it.next().getValue();
            if (value != null) {
                try {
                    value.registerGameCallback(iCallBack);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void updateGameInfo(String str) {
        Iterator<Map.Entry<String, IDataForward>> it = this.mServerMap.entrySet().iterator();
        while (it.hasNext()) {
            IDataForward value = it.next().getValue();
            if (value != null) {
                try {
                    value.updateGameInfo(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
