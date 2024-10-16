package com.ihoc.mgpa.vendorsdk.v2_0;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.ihoc.mgpa.vendorsdk.v2_0.ITGPAServer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class TGPAManager {
    private static final String ACTION_TGPA_SERVER = "com.ihoc.mgpa.VENDORSDK_SERVER";
    private static final String TAG = "TGPAManager";
    private Application mContext;
    private ForegroundCallbacks mForegroundCallbacks;
    private ServerConnection mServerConnection;
    private ServerBindCallback mCallback = null;
    private ITGPAServer mTgpaServer = null;
    private IBinder mClient = new Binder();
    private int mServerSupportState = -1;

    /* loaded from: classes2.dex */
    private class ForegroundCallbacks implements Application.ActivityLifecycleCallbacks {
        private ArrayList<Activity> activities;

        private ForegroundCallbacks() {
            this.activities = new ArrayList<>();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            this.activities.add(activity);
            Log.i(TGPAManager.TAG, "onActivityStarted: " + this.activities.size());
            if (TGPAManager.this.mTgpaServer != null) {
                try {
                    TGPAManager.this.mTgpaServer.setForeground(!this.activities.isEmpty());
                } catch (RemoteException unused) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Iterator<Activity> it = this.activities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getLocalClassName().equals(activity.getLocalClassName())) {
                    it.remove();
                    break;
                }
            }
            Log.i(TGPAManager.TAG, "onActivityStopped: " + this.activities.size());
            if (TGPAManager.this.mTgpaServer != null) {
                try {
                    TGPAManager.this.mTgpaServer.setForeground(!this.activities.isEmpty());
                } catch (RemoteException unused) {
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class ServerConnection implements ServiceConnection {
        private ServerConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(TGPAManager.TAG, "onServiceConnected: ComponentName=" + componentName);
            TGPAManager.this.mTgpaServer = ITGPAServer.Stub.asInterface(iBinder);
            if (TGPAManager.this.mTgpaServer != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("aidl version: ");
                    sb.append(TGPAManager.this.mTgpaServer.getInterfaceVersion());
                    Log.i(TGPAManager.TAG, sb.toString());
                    TGPAManager.this.mTgpaServer.init(TGPAManager.this.mClient);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getSupportState=");
                    sb2.append(TGPAManager.this.mTgpaServer.getSupportState());
                    Log.i(TGPAManager.TAG, sb2.toString());
                    TGPAManager.this.mTgpaServer.setForeground(true);
                } catch (RemoteException unused) {
                }
                TGPAManager.this.mContext.registerActivityLifecycleCallbacks(TGPAManager.this.mForegroundCallbacks);
                if (TGPAManager.this.mCallback != null) {
                    TGPAManager.this.mCallback.bindCallBack();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(TGPAManager.TAG, "onServiceDisconnected");
            TGPAManager.this.mTgpaServer = null;
            TGPAManager.this.mContext.unregisterActivityLifecycleCallbacks(TGPAManager.this.mForegroundCallbacks);
        }
    }

    public TGPAManager() {
        this.mForegroundCallbacks = new ForegroundCallbacks();
        this.mServerConnection = new ServerConnection();
    }

    private ComponentName queryService(Intent intent) {
        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, Constants.MB);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            return new ComponentName(queryIntentServices.get(0).serviceInfo.packageName, queryIntentServices.get(0).serviceInfo.name);
        }
        Log.e(TAG, "TGPA Server isn't exist!!!");
        return null;
    }

    public void bind(Context context, ServerBindCallback serverBindCallback) {
        this.mContext = (Application) context.getApplicationContext();
        this.mCallback = serverBindCallback;
        Intent intent = new Intent(ACTION_TGPA_SERVER);
        ComponentName queryService = queryService(intent);
        if (queryService != null) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(queryService);
            try {
                this.mContext.bindService(intent2, this.mServerConnection, 1);
            } catch (Exception unused) {
                Log.e(TAG, "bind service failed: service=" + queryService);
            }
        }
    }

    public String getServerVersion() {
        ITGPAServer iTGPAServer;
        if (this.mServerSupportState != 0 || (iTGPAServer = this.mTgpaServer) == null) {
            return null;
        }
        try {
            return iTGPAServer.getServerVersion();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public int getSupportState() {
        try {
            this.mServerSupportState = this.mTgpaServer != null ? this.mTgpaServer.getSupportState() : -1;
        } catch (RemoteException unused) {
        }
        return this.mServerSupportState;
    }

    public String getSupportStrategy() {
        ITGPAServer iTGPAServer;
        if (this.mServerSupportState != 0 || (iTGPAServer = this.mTgpaServer) == null) {
            return null;
        }
        try {
            return iTGPAServer.getSupportStrategy();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public String getSystemData(int i, String str) {
        ITGPAServer iTGPAServer;
        if (this.mServerSupportState != 0 || (iTGPAServer = this.mTgpaServer) == null) {
            return null;
        }
        try {
            return iTGPAServer.getSystemData(i, str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public void registerGameCallback(ICallBack iCallBack) {
        ITGPAServer iTGPAServer;
        if (this.mServerSupportState != 0 || (iTGPAServer = this.mTgpaServer) == null) {
            return;
        }
        try {
            iTGPAServer.registerGameCallback(iCallBack);
        } catch (RemoteException unused) {
        }
    }

    public void unbind() {
        if (this.mTgpaServer != null) {
            this.mTgpaServer = null;
            this.mContext.unbindService(this.mServerConnection);
            this.mContext.unregisterActivityLifecycleCallbacks(this.mForegroundCallbacks);
        }
    }

    public void unregisterGameCallback() {
        ITGPAServer iTGPAServer;
        if (this.mServerSupportState != 0 || (iTGPAServer = this.mTgpaServer) == null) {
            return;
        }
        try {
            iTGPAServer.unregisterGameCallback();
        } catch (RemoteException unused) {
        }
    }

    public void updateGameInfo(String str) {
        ITGPAServer iTGPAServer;
        if (this.mServerSupportState != 0 || (iTGPAServer = this.mTgpaServer) == null) {
            return;
        }
        try {
            iTGPAServer.updateGameInfo(str);
        } catch (RemoteException unused) {
        }
    }
}
