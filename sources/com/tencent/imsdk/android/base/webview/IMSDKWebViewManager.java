package com.tencent.imsdk.android.base.webview;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.webview.IMSDKWebViewActionResult;
import com.tencent.imsdk.android.api.webview.IMSDKWebViewStatusResult;
import com.tencent.imsdk.android.api.webview.IMSDKWebViewTicketResult;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKDBLoginData;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.interfaces.IWebView;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKWebViewManager extends IMSDKManagerBase {
    private static String KEY_JSON_HORIZONTAL_BAR = "showHorizontalScrollBar";
    private static String KEY_JSON_TICKET = "isneedticket";
    private static String KEY_JSON_VERTICAL_BAR = "showVerticalScrollBar";
    private static String KEY_JSON_X5 = "isx5work";
    private IWebView mIWebView;

    public IMSDKWebViewManager(Context context) {
        super(context);
        if (this.mCurCtx != context) {
            this.mCurCtx = context;
            this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_WEBVIEW, "Init<IMSDKWebViewManager>");
        }
    }

    public void setChannel(String str) {
        if (T.ckIsEmpty(str)) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = str.toLowerCase(Locale.US);
        if (str.equalsIgnoreCase(IR.def.IMSDK_KEYWORD)) {
            str = IR.def.IMSDK_KEYWORD;
        }
        objArr[1] = str;
        String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_WEBVIEW_FORMAT, objArr);
        IMLogger.d("packageName:" + format);
        this.mIWebView = (IWebView) IMSDKModules.getInstance(this.mCurCtx).getChannelInstance(IWebView.class, format, false);
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        String str2;
        IMSDKResult iMSDKResult;
        IMLogger.d("action:" + str);
        if (bArr != null) {
            try {
                str2 = new String(bArr, Charset.forName("UTF-8"));
            } catch (JSONException e) {
                return new IMSDKResult(5, -1, e.getMessage());
            } catch (Exception e2) {
                return new IMSDKResult(3, -1, e2.getMessage());
            }
        } else {
            str2 = "";
        }
        IMLogger.json(str2);
        if (str.equalsIgnoreCase(IR.path.GET_TICKET_PATH)) {
            iMSDKResult = new IMSDKWebViewTicketResult(str2);
        } else {
            iMSDKResult = new IMSDKResult(str2);
        }
        if (iMSDKResult.thirdRetCode == 1) {
            iMSDKResult.imsdkRetCode = 1;
        } else {
            iMSDKResult.imsdkRetCode = 5;
        }
        iMSDKResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(iMSDKResult.imsdkRetCode);
        if (iMSDKResult.thirdRetCode == -905) {
            this.mSTBuilder.setStage("handle iMSDK network finish").setMethod("handleServerData").setResult(iMSDKResult.thirdRetMsg).setExtraProp(map).setNewSeq(false).setCrypt(true).create().reportEvent();
        }
        return iMSDKResult;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return str.equalsIgnoreCase(IR.path.GET_TICKET_PATH) ? new IMSDKWebViewTicketResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg) : iMSDKResult;
    }

    public void getStatus(IMSDKResultListener<IMSDKWebViewStatusResult> iMSDKResultListener, Object... objArr) {
        IMSDKWebViewStatusResult iMSDKWebViewStatusResult = new IMSDKWebViewStatusResult(1);
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iMSDKWebViewStatusResult.isOpen = iWebView.getStatus(9, new Object[0]);
            iMSDKWebViewStatusResult.canGoBack = this.mIWebView.getStatus(16, new Object[0]);
            iMSDKWebViewStatusResult.canGoForward = this.mIWebView.getStatus(17, new Object[0]);
            iMSDKWebViewStatusResult.isVisible = this.mIWebView.getStatus(21, new Object[0]);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isOpen", iMSDKWebViewStatusResult.isOpen);
            jSONObject.put("canGoBack", iMSDKWebViewStatusResult.canGoBack);
            jSONObject.put("canGoForward", iMSDKWebViewStatusResult.canGoForward);
            jSONObject.put("isVisible", iMSDKWebViewStatusResult.isVisible);
        } catch (JSONException e) {
            IMLogger.e("getstatus json error" + e.getMessage(), new Object[0]);
        }
        iMSDKWebViewStatusResult.retExtraJson = jSONObject.toString();
        iMSDKResultListener.onResult(iMSDKWebViewStatusResult);
    }

    public void getTicket(boolean z, IMSDKResultListener<IMSDKWebViewTicketResult> iMSDKResultListener, Object... objArr) {
        if (z) {
            Map<String, String> sortableMap = T.getSortableMap();
            IMSDKDBLoginData dBLoginData = IMSDKDB4Login.getDBLoginData(this.mCurCtx);
            if (dBLoginData != null) {
                sortableMap.put("sInnerToken", dBLoginData.innerToken);
                sortableMap.put("iOpenid", dBLoginData.openId);
                sortableMap.put("iChannel", String.valueOf(dBLoginData.channelId));
                connectIMSDK(IR.path.GET_TICKET_PATH, sortableMap, iMSDKResultListener);
                return;
            }
            IMLogger.w("getTicket need login/auth first, return null ticket.", new Object[0]);
            iMSDKResultListener.onResult(new IMSDKWebViewTicketResult(11, "getTicket need login/auth first"));
            return;
        }
        IMLogger.w("no need ticket", new Object[0]);
        iMSDKResultListener.onResult(new IMSDKWebViewTicketResult(19));
    }

    public void registerActionObserver(IMSDKResultListener<IMSDKWebViewActionResult> iMSDKResultListener, Object... objArr) {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.registerActionObserver(iMSDKResultListener);
        }
    }

    public void openURLWithExtra(String str, boolean z, boolean z2, String str2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        JSONObject jSONObject;
        if (!T.ckIsEmpty(str2)) {
            try {
                IMLogger.d("openURLWithExtra extraJson = " + str2);
                jSONObject = new JSONObject(str2);
                z3 = jSONObject.has(KEY_JSON_X5) ? jSONObject.getBoolean(KEY_JSON_X5) : false;
            } catch (Exception e) {
                e = e;
                z3 = false;
            }
            try {
                z4 = jSONObject.has(KEY_JSON_TICKET) ? jSONObject.getBoolean(KEY_JSON_TICKET) : true;
            } catch (Exception e2) {
                e = e2;
                z4 = true;
                z5 = true;
                IMLogger.e(e.getMessage(), new Object[0]);
                z6 = z3;
                z7 = z5;
                z8 = true;
                z9 = z4;
                openURL(str, z, z2, z9, z6, z7, z8, str2);
            }
            try {
                z5 = jSONObject.has(KEY_JSON_HORIZONTAL_BAR) ? jSONObject.getBoolean(KEY_JSON_HORIZONTAL_BAR) : true;
            } catch (Exception e3) {
                e = e3;
                z5 = true;
                IMLogger.e(e.getMessage(), new Object[0]);
                z6 = z3;
                z7 = z5;
                z8 = true;
                z9 = z4;
                openURL(str, z, z2, z9, z6, z7, z8, str2);
            }
            try {
                z8 = jSONObject.has(KEY_JSON_VERTICAL_BAR) ? jSONObject.getBoolean(KEY_JSON_VERTICAL_BAR) : true;
                z6 = z3;
                z7 = z5;
            } catch (Exception e4) {
                e = e4;
                IMLogger.e(e.getMessage(), new Object[0]);
                z6 = z3;
                z7 = z5;
                z8 = true;
                z9 = z4;
                openURL(str, z, z2, z9, z6, z7, z8, str2);
            }
            z9 = z4;
        } else {
            IMLogger.d("openURLWithExtra extraJson null,  exec default openURL!");
            z9 = true;
            z6 = false;
            z7 = true;
            z8 = true;
        }
        openURL(str, z, z2, z9, z6, z7, z8, str2);
    }

    private void openURL(final String str, final boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5, final boolean z6, final String str2) {
        if (T.ckIsEmpty(str)) {
            IMLogger.w("this IMCommon need a valid url start with http:// or https:// or file:// or ftp://", new Object[0]);
        } else {
            getTicket(z3, new IMSDKResultListener<IMSDKWebViewTicketResult>() { // from class: com.tencent.imsdk.android.base.webview.IMSDKWebViewManager.1
                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKWebViewTicketResult iMSDKWebViewTicketResult) {
                    String str3 = "";
                    if (z3) {
                        if (iMSDKWebViewTicketResult != null && !T.ckIsEmpty(iMSDKWebViewTicketResult.ticket)) {
                            IMLogger.d("openURL getTicket = " + iMSDKWebViewTicketResult.ticket);
                            str3 = iMSDKWebViewTicketResult.ticket;
                        } else {
                            IMLogger.d("openURL getTicket failed");
                        }
                    }
                    if (IMSDKWebViewManager.this.mIWebView != null) {
                        IMSDKWebViewManager.this.mIWebView.optCmd(1, str, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), str2);
                    }
                }
            }, new Object[0]);
        }
    }

    public void setZoom(float f, float f2) {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(2, Float.valueOf(f), Float.valueOf(f2));
        } else {
            IMLogger.e("initialize should be called before setZoom", new Object[0]);
        }
    }

    public void setOrientation(boolean z) {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(3, Boolean.valueOf(z));
        } else {
            IMLogger.e("initialize should be called before setOrientation", new Object[0]);
        }
    }

    public void setPosition(int i, int i2, int i3, int i4) {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        } else {
            IMLogger.e("initialize should be called before setPosition", new Object[0]);
        }
    }

    public void back() {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(6, new Object[0]);
        } else {
            IMLogger.e("initialize should be called before back", new Object[0]);
        }
    }

    public void forward() {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(7, new Object[0]);
        } else {
            IMLogger.e("initialize should be called before forward", new Object[0]);
        }
    }

    public void reload() {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(8, new Object[0]);
        } else {
            IMLogger.e("initialize should be called before reload", new Object[0]);
        }
    }

    public void close() {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(5, new Object[0]);
        } else {
            IMLogger.e("initialize should be called before close", new Object[0]);
        }
    }

    public void callJs(String str) {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(18, str);
        } else {
            IMLogger.e("initialize should be called before callJs", new Object[0]);
        }
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected String getUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(enableHttps() ? "https" : "http");
        sb.append("://");
        sb.append(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERVER_SDKAPI.toUpperCase(), IR.meta.IMSDK_SERVER_SDKAPI));
        sb.append("/v");
        sb.append(IMSDKConfig.getOrDefault(IR.meta.IMSDK_SERVER_SDKAPI_VERSION, "1.0"));
        sb.append("/");
        sb.append(str);
        sb.append("?");
        return sb.toString();
    }

    public void setBgColor(int i) {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(19, Integer.valueOf(i));
        } else {
            IMLogger.e("initialize should be called before set background color", new Object[0]);
        }
    }

    public void showWebView(boolean z) {
        IWebView iWebView = this.mIWebView;
        if (iWebView != null) {
            iWebView.optCmd(20, Boolean.valueOf(z));
        } else {
            IMLogger.e("initialize should be called before show webview", new Object[0]);
        }
    }
}
