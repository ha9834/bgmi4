package com.tencent.imsdk.android.webview.qq;

import android.content.Context;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.webview.IMSDKWebViewActionResult;
import com.tencent.imsdk.android.base.interfaces.IWebView;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.smtt.sdk.TbsConfig;

/* loaded from: classes.dex */
public class QQWebView implements IWebView {
    private Context mCtx;

    public QQWebView(Context context) {
        this.mCtx = context;
        WebViewManager.getInstance().init(this.mCtx);
        new InnerStat.Builder(context, BuildConfig.VERSION_NAME, TbsConfig.TBS_SDK_VERSIONNAME);
    }

    private boolean checkArgs(int i, Object... objArr) {
        return objArr != null && objArr.length == i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000e. Please report as an issue. */
    @Override // com.tencent.imsdk.android.base.interfaces.IWebView
    public void optCmd(int i, Object... objArr) {
        try {
            switch (i) {
                case 1:
                    if (checkArgs(3, objArr)) {
                        WebViewManager.getInstance().openUrl((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue());
                    } else if (checkArgs(4, objArr)) {
                        WebViewManager.getInstance().openUrl((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                    } else if (checkArgs(5, objArr)) {
                        WebViewManager.getInstance().openUrlWithX5((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                    } else if (checkArgs(6, objArr)) {
                        WebViewManager.getInstance().openUrl((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue(), ((Boolean) objArr[5]).booleanValue());
                    } else if (checkArgs(7, objArr)) {
                        WebViewManager.getInstance().openUrlWithX5((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue(), ((Boolean) objArr[5]).booleanValue(), (String) objArr[6]);
                    } else if (checkArgs(8, objArr)) {
                        WebViewManager.getInstance().openUrlWithX5((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue(), ((Boolean) objArr[5]).booleanValue(), ((Boolean) objArr[6]).booleanValue(), (String) objArr[7]);
                    } else {
                        IMLogger.w("unknown arg account " + objArr.length, new Object[0]);
                    }
                    return;
                case 2:
                    if (checkArgs(2, objArr)) {
                        WebViewManager.getInstance().setZoom(((Float) objArr[0]).floatValue(), ((Float) objArr[1]).floatValue());
                    }
                    return;
                case 3:
                    if (checkArgs(1, objArr)) {
                        WebViewManager.getInstance().setOrientation(((Boolean) objArr[0]).booleanValue());
                    }
                    return;
                case 4:
                    if (checkArgs(4, objArr)) {
                        WebViewManager.getInstance().setPosition(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                    }
                    return;
                case 5:
                case 6:
                case 7:
                case 8:
                    WebViewManager.getInstance().optWebViewOnUIThread(i);
                    return;
                default:
                    switch (i) {
                        case 18:
                            if (checkArgs(1, objArr)) {
                                WebViewManager.getInstance().callJs((String) objArr[0]);
                            }
                            return;
                        case 19:
                            if (checkArgs(1, objArr)) {
                                WebViewManager.getInstance().setBgColor(((Integer) objArr[0]).intValue());
                            }
                            return;
                        case 20:
                            if (checkArgs(1, objArr)) {
                                WebViewManager.getInstance().showWebView(((Boolean) objArr[0]).booleanValue());
                            }
                            return;
                        default:
                            return;
                    }
            }
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
        }
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IWebView
    public boolean getStatus(int i, Object... objArr) {
        return WebViewManager.getInstance().getStatusOfWebView(i);
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IWebView
    public void registerActionObserver(IMSDKResultListener<IMSDKWebViewActionResult> iMSDKResultListener) {
        WebViewManager.getInstance().setWebViewActionListener(iMSDKResultListener);
    }
}
