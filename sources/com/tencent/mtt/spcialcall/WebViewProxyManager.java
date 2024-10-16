package com.tencent.mtt.spcialcall;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mtt.spcialcall.remote.ISpecialCallClient;
import com.tencent.mtt.spcialcall.remote.ISpecialCallService;
import com.tencent.mtt.spcialcall.sdk.WebViewClientProxy;
import com.tencent.mtt.spcialcall.sdk.WebViewProxy;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.HashMap;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class WebViewProxyManager extends ISpecialCallClient.Stub {
    private static final String TAG = "WebViewProxy";
    private static WebViewProxyManager sInstance;
    boolean mBinded;
    ServiceConnection mConnection;
    private Context mContext;
    private HashMap<Long, WebViewProxy> mProxies = new HashMap<>();
    ISpecialCallService mService;

    public static WebViewProxyManager getInstance() {
        if (sInstance == null) {
            sInstance = new WebViewProxyManager();
        }
        return sInstance;
    }

    private WebViewProxyManager() {
    }

    public WebViewProxy create(Activity activity) {
        WebViewProxy webViewProxy = new WebViewProxy(activity);
        this.mProxies.put(Long.valueOf(webViewProxy.getId()), webViewProxy);
        return webViewProxy;
    }

    public boolean bindServiceIfNeed(Context context) {
        if (this.mBinded) {
            return true;
        }
        if (this.mConnection == null) {
            this.mConnection = new ServiceConnection() { // from class: com.tencent.mtt.spcialcall.WebViewProxyManager.1
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    WebViewProxyManager webViewProxyManager = WebViewProxyManager.this;
                    webViewProxyManager.mService = null;
                    webViewProxyManager.mBinded = false;
                    webViewProxyManager.mProxies.clear();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    WebViewProxyManager.this.mService = ISpecialCallService.Stub.asInterface(iBinder);
                    try {
                        WebViewProxyManager.this.mService.registerClient(WebViewProxyManager.this);
                    } catch (RemoteException e) {
                        Log.w(WebViewProxyManager.TAG, e);
                    }
                }
            };
        }
        this.mContext = context.getApplicationContext();
        Intent intent = new Intent();
        intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.spcialcall.remote.SpecialCallService");
        this.mBinded = this.mContext.bindService(intent, this.mConnection, 1);
        return this.mBinded;
    }

    @Override // com.tencent.mtt.spcialcall.remote.ISpecialCallClient
    public void onWebViewDestroy(long j) {
        this.mProxies.remove(Long.valueOf(j));
        if (this.mProxies.isEmpty() && this.mBinded) {
            this.mContext.unbindService(this.mConnection);
            this.mBinded = false;
        }
    }

    public void loadUrlRemote(long j, String str) {
        ISpecialCallService iSpecialCallService = this.mService;
        if (iSpecialCallService == null) {
            Log.d(TAG, "Service not bind");
            return;
        }
        try {
            iSpecialCallService.loadUrl(j, str);
        } catch (Throwable th) {
            Log.w(TAG, th);
        }
    }

    @Override // com.tencent.mtt.spcialcall.remote.ISpecialCallClient
    public String onJsCall(long j, String str, String str2, String str3) {
        WebViewProxy webViewProxy = this.mProxies.get(Long.valueOf(j));
        if (webViewProxy == null) {
            Log.d(TAG, "No proxy for " + j + " was found; ignore");
            return null;
        }
        try {
            return JsUtils.exec(webViewProxy, str, str2, TextUtils.isEmpty(str3) ? null : new JSONArray(str3));
        } catch (Exception e) {
            Log.w(TAG, e);
            return null;
        }
    }

    public void onPageStarted(long j, String str) {
        WebViewProxy webViewProxy = this.mProxies.get(Long.valueOf(j));
        if (webViewProxy == null) {
            Log.d(TAG, "No proxy for " + j + " was found");
            return;
        }
        WebViewClientProxy webViewClient = webViewProxy.getWebViewClient();
        if (webViewClient != null) {
            webViewClient.onPageStarted(webViewProxy, str);
        }
    }

    public void onPageFinished(long j, String str) {
        WebViewProxy webViewProxy = this.mProxies.get(Long.valueOf(j));
        if (webViewProxy == null) {
            Log.d(TAG, "No proxy for " + j + " was found");
            return;
        }
        WebViewClientProxy webViewClient = webViewProxy.getWebViewClient();
        if (webViewClient != null) {
            webViewClient.onPageFinished(webViewProxy, str);
        }
    }

    public void onReceivedError(long j, int i, String str, String str2) {
        WebViewProxy webViewProxy = this.mProxies.get(Long.valueOf(j));
        if (webViewProxy == null) {
            Log.d(TAG, "No proxy for " + j + " was found");
            return;
        }
        WebViewClientProxy webViewClient = webViewProxy.getWebViewClient();
        if (webViewClient != null) {
            webViewClient.onReceivedError(webViewProxy, i, str, str2);
        }
    }

    @Override // com.tencent.mtt.spcialcall.remote.ISpecialCallClient
    public boolean shouldOverrideUrlLoading(long j, String str) {
        WebViewProxy webViewProxy = this.mProxies.get(Long.valueOf(j));
        if (webViewProxy == null) {
            Log.d(TAG, "No proxy for " + j + " was found");
            return false;
        }
        WebViewClientProxy webViewClient = webViewProxy.getWebViewClient();
        if (webViewClient != null) {
            return webViewClient.shouldOverrideUrlLoading(webViewProxy, str);
        }
        return false;
    }
}
