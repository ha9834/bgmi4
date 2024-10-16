package com.tencent.imsdk.android.api.webview;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.webview.IMSDKWebViewManager;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class IMSDKWebView {
    private static InnerStat.Builder mAPIStatBuilder;
    private static String mCurChannel;
    private static Context mCurCtx;
    private static IMSDKWebViewManager mWebViewImpl;

    private static boolean isInit(IMSDKResultListener iMSDKResultListener) {
        IMSDKResult iMSDKResult;
        if (mWebViewImpl == null) {
            IMLogger.e("Need call IMSDKWebView.initialize() first", new Object[0]);
            if (iMSDKResultListener != null) {
                if (mCurCtx == null) {
                    iMSDKResult = new IMSDKResult(17, 17);
                } else if (mCurChannel == null) {
                    iMSDKResult = new IMSDKResult(18, 18);
                } else {
                    iMSDKResult = new IMSDKResult(11, 11);
                }
                iMSDKResultListener.onResult(iMSDKResult);
            }
        }
        return mWebViewImpl != null;
    }

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mWebViewImpl = new IMSDKWebViewManager(mCurCtx);
            mAPIStatBuilder = new InnerStat.Builder(activity, "2.10.1", IR.MODULE_WEBVIEW, "Init<IMSDKWebView>");
        }
        return mWebViewImpl != null;
    }

    public static boolean setChannel(String str) {
        IMSDKWebViewManager iMSDKWebViewManager;
        if (mCurCtx == null) {
            T.HelperLog.contextIsNull();
            return false;
        }
        if (str.length() <= 0) {
            T.HelperLog.channelIsNullOrEmpty();
            return false;
        }
        if (str.length() > 0 && !str.equals(mCurChannel) && (iMSDKWebViewManager = mWebViewImpl) != null) {
            iMSDKWebViewManager.setChannel(str);
            mCurChannel = str;
            InnerStat.Builder builder = mAPIStatBuilder;
            if (builder != null) {
                builder.setChannel(mCurChannel);
            }
        }
        return mWebViewImpl != null;
    }

    public static String getChannel() {
        return mCurChannel;
    }

    public static void openURL(String str, boolean z, boolean z2) {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.openURLWithExtra(str, z, z2, "");
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public static void openURL(String str, boolean z, boolean z2, String str2) {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.openURLWithExtra(str, z, z2, str2);
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public static void getStatus(final IMSDKResultListener<IMSDKWebViewStatusResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (!isInit(iMSDKResultListener) || mCurCtx == null) {
            return;
        }
        T.mGlobalActivityUpToDate.runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.api.webview.IMSDKWebView.1
            @Override // java.lang.Runnable
            public void run() {
                IMSDKWebView.mWebViewImpl.getStatus(IMSDKResultListener.this, new Object[0]);
            }
        });
    }

    public static void registerActionObserver(IMSDKResultListener<IMSDKWebViewActionResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mWebViewImpl.registerActionObserver(iMSDKResultListener, new Object[0]);
        }
    }

    public static void getTicket(IMSDKResultListener<IMSDKWebViewTicketResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mWebViewImpl.getTicket(true, iMSDKResultListener, new Object[0]);
        }
    }

    public static void setZoom(float f, float f2) {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.setZoom(f, f2);
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public static void setOrientation(boolean z) {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.setOrientation(z);
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public static void setPosition(int i, int i2, int i3, int i4) {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.setPosition(i, i2, i3, i4);
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public static void back() {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.back();
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public static void forward() {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.forward();
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public static void reload() {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.reload();
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public static void close() {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.close();
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public static void callJs(String str) {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.callJs(str);
        } else {
            IMLogger.e("initialize should be called before callJs", new Object[0]);
        }
    }

    public static void setBgColor(int i) {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.setBgColor(i);
        } else {
            IMLogger.e("initialize should be called before set background color", new Object[0]);
        }
    }

    public static void showWebView(boolean z) {
        IMSDKWebViewManager iMSDKWebViewManager = mWebViewImpl;
        if (iMSDKWebViewManager != null) {
            iMSDKWebViewManager.showWebView(z);
        } else {
            IMLogger.e("initialize should be called before show webview", new Object[0]);
        }
    }
}
