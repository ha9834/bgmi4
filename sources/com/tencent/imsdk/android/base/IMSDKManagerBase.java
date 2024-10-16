package com.tencent.imsdk.android.base;

import android.content.Context;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.net.IMSDKHttpClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class IMSDKManagerBase {
    protected IMSDKHttpClient mClient;
    protected Context mCurCtx = null;
    protected InnerStat.Builder mSTBuilder;

    protected abstract IMSDKResult convertResult(String str, IMSDKResult iMSDKResult);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enableHttps() {
        return true;
    }

    protected abstract String getUrl(String str);

    protected abstract IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map);

    public IMSDKManagerBase(Context context) {
        this.mClient = null;
        if (context == null || this.mCurCtx == context) {
            return;
        }
        this.mClient = new IMSDKHttpClient(context);
    }

    protected void deliverResult(String str, byte[] bArr, IMSDKResultListener iMSDKResultListener, Map<String, String> map) {
        IMSDKResult iMSDKResult;
        if (bArr == null || bArr.length == 0) {
            iMSDKResult = new IMSDKResult(5, 4);
        } else {
            iMSDKResult = handleServerData(str, bArr, map);
        }
        reportResult(str, map, iMSDKResult);
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(iMSDKResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportResult(String str, Map<String, String> map, IMSDKResult iMSDKResult) {
        if (this.mSTBuilder != null) {
            if (iMSDKResult.imsdkRetCode != 1) {
                this.mSTBuilder.setExtraProp(map).setCrypt(true);
            }
            this.mSTBuilder.setMethod(str).setStage("network response success").setResult(iMSDKResult.thirdRetMsg).create().reportEvent();
        }
    }

    public void connectIMSDK(boolean z, String str, Map<String, String> map, IMSDKResultListener iMSDKResultListener) {
        IMSDKResultListener proxyListener4EventReport;
        IMSDKValidKeyCalcUnit.getIns(this.mCurCtx).fillFixedParamsAndValidKey(map);
        String url = getUrl(str);
        InnerStat.Builder builder = this.mSTBuilder;
        if (builder == null) {
            proxyListener4EventReport = iMSDKResultListener;
        } else {
            proxyListener4EventReport = builder.create().proxyListener4EventReport("http-" + str, iMSDKResultListener);
        }
        if (z) {
            post2IMSDKServer(str, map, url, proxyListener4EventReport, map);
            return;
        }
        get2IMSDKServer(str, map, url + encodeParams(map), proxyListener4EventReport, map);
    }

    public void connectIMSDK(String str, Map<String, String> map, IMSDKResultListener iMSDKResultListener) {
        connectIMSDK(false, str, map, iMSDKResultListener);
    }

    public void connectIMSDK(String str, String str2, Map<String, String> map, IMSDKResultListener iMSDKResultListener) {
        connectIMSDK(false, str, map, iMSDKResultListener);
    }

    protected void get2IMSDKServer(final String str, final Map<String, String> map, String str2, final IMSDKResultListener iMSDKResultListener, final Map<String, String> map2) {
        this.mClient.get(str2, new IMSDKListener<byte[]>() { // from class: com.tencent.imsdk.android.base.IMSDKManagerBase.1
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(byte[] bArr) {
                IMSDKManagerBase.this.deliverResult(str, bArr, iMSDKResultListener, map2);
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                if (IMSDKManagerBase.this.mSTBuilder != null) {
                    IMSDKManagerBase.this.mSTBuilder.setMethod(str).setStage("network response error").setResult(iMSDKResult.thirdRetMsg).setExtraProp(map).setCrypt(true).create().reportEvent();
                }
                iMSDKResultListener.onResult(IMSDKManagerBase.this.convertResult(str, iMSDKResult));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void post2IMSDKServer(final String str, final Map<String, String> map, String str2, final IMSDKResultListener iMSDKResultListener, final Map<String, String> map2) {
        this.mClient.post(str2, map, new IMSDKListener<byte[]>() { // from class: com.tencent.imsdk.android.base.IMSDKManagerBase.2
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(byte[] bArr) {
                IMSDKManagerBase.this.deliverResult(str, bArr, iMSDKResultListener, map2);
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                if (IMSDKManagerBase.this.mSTBuilder != null) {
                    IMSDKManagerBase.this.mSTBuilder.setMethod(str).setStage("network response error").setResult(iMSDKResult.thirdRetMsg).setExtraProp(map).setCrypt(true).create().reportEvent();
                }
                iMSDKResultListener.onResult(IMSDKManagerBase.this.convertResult(str, iMSDKResult));
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String encodeParams(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if (next.getKey() != null && next.getValue() != null) {
                    sb.append(URLEncoder.encode(next.getKey(), "UTF-8"));
                    sb.append('=');
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append('&');
                    }
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: UTF-8", e);
        }
    }

    public boolean isPathPresent(String str, String[] strArr) {
        if (strArr != null && strArr.length > 0 && str != null) {
            for (String str2 : strArr) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
