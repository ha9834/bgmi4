package com.tencent.midas.http.midashttp;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.http.core.Callback;
import com.tencent.midas.http.core.HttpHandler;
import com.tencent.midas.http.core.IHttpLog;
import com.tencent.midas.http.core.Interceptor;
import com.tencent.midas.http.core.NetworkManager;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpsCertHandler;
import com.tencent.midas.http.midaskey.APMidasKeyManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class APMidasNetworkManager {
    private String IV;
    private String baseKey;
    private IAPConnectTimeoutGetter connectTimeoutGetter;
    private Context context;
    private String customCert;
    private IAPDataReportNotifier dataReportNotifier;
    private IAPGetKeyRequestGetter getKeyRequestGetter;
    private IAPGetKeySuccessHandler getKeySuccessHandler;
    private IAPIPMeasure iapipMeasure;
    private APMidasHttpsCertHandler.MidasIPChecker ipChecker;
    private IAPMidasCommonInfoGetter midasCommonInfoGetter;
    private final NetworkManager networkManager;
    private IAPReadTimeoutGetter readTimeoutGetter;
    private AtomicBoolean hasSetUp = new AtomicBoolean(false);
    private boolean needHttpsCustomCert = true;
    private boolean canUseCryptoKeyToEncodeGetKeyRequest = false;
    private final APMidasKeyManager midasKeyManager = new APMidasKeyManager();

    /* loaded from: classes.dex */
    public interface IAPConnectTimeoutGetter {
        int getConnectTimeout();
    }

    /* loaded from: classes.dex */
    public interface IAPGetKeyRequestGetter {
        APMidasHttpRequest getGetKeyRequest();
    }

    /* loaded from: classes.dex */
    public interface IAPIPMeasure {
        void updateIPTimes(String str);
    }

    /* loaded from: classes.dex */
    public interface IAPReadTimeoutGetter {
        int getReadTimeOut();
    }

    public APMidasNetworkManager(IHttpLog iHttpLog) {
        this.networkManager = new NetworkManager(iHttpLog);
    }

    public void setCustomCert(String str) {
        this.customCert = str;
    }

    public void setMidasIPChecker(APMidasHttpsCertHandler.MidasIPChecker midasIPChecker) {
        this.ipChecker = midasIPChecker;
    }

    public void setCanUseCryptoKeyToEncodeGetKeyRequest(boolean z) {
        this.canUseCryptoKeyToEncodeGetKeyRequest = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCanUseCryptoKeyToEncodeGetKeyRequest() {
        return this.canUseCryptoKeyToEncodeGetKeyRequest;
    }

    public void setBaseKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.baseKey = str;
    }

    public void setNeedHttpsCustomCert(boolean z) {
        this.needHttpsCustomCert = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBaseKey() {
        return this.baseKey;
    }

    public void cancelAllRequest() {
        this.networkManager.cancelAllRequest();
    }

    public void cancelRequestByName(String str) {
        this.networkManager.cancelRequestByName(str);
    }

    public void setup() {
        if (this.hasSetUp.compareAndSet(false, true)) {
            this.networkManager.setDefaultMaxRetryTimes(2);
            if (this.needHttpsCustomCert) {
                this.networkManager.addHttpHandler(new APMidasHttpsCertHandler(this.customCert, this.ipChecker));
            }
            this.networkManager.addHttpHandler(new APMidasHostHeaderHandler(this));
            this.networkManager.addHttpHandler(new APMidasTimeoutHandler(this));
            this.networkManager.addHttpHandler(new APMidasHttpResponseHandler(this));
            this.networkManager.addHttpHandler(new APMidasHttpTimeReportHandler(this));
            this.networkManager.addHttpHandler(new APMidasIPMeasureHandler(this));
            this.networkManager.addHttpHandler(new APMidasRetryHostHandler());
            this.networkManager.addHttpHandler(new APMidasEncodeParameterHandler(this));
            this.networkManager.addFistInterceptor(new APMidasNetAvailableInterceptor(this));
            this.networkManager.addFistInterceptor(new APFrontGetKeyInterceptor(this));
            this.networkManager.addLastInterceptor(new APEndGetKeyInterceptor(this));
        }
    }

    public void addLastInterceptor(Interceptor interceptor) {
        this.networkManager.addLastInterceptor(interceptor);
    }

    public void addFistInterceptor(Interceptor interceptor) {
        this.networkManager.addFistInterceptor(interceptor);
    }

    public void addHttpHandler(HttpHandler httpHandler) {
        if (httpHandler != null) {
            this.networkManager.addHttpHandler(httpHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateConnectAndReadTimeout() {
        IAPConnectTimeoutGetter iAPConnectTimeoutGetter = this.connectTimeoutGetter;
        if (iAPConnectTimeoutGetter != null) {
            setDefaultConnectTimeout(iAPConnectTimeoutGetter.getConnectTimeout());
        }
        IAPReadTimeoutGetter iAPReadTimeoutGetter = this.readTimeoutGetter;
        if (iAPReadTimeoutGetter != null) {
            setDefaultReadTimeout(iAPReadTimeoutGetter.getReadTimeOut());
        }
    }

    private void setDefaultConnectTimeout(int i) {
        if (i <= 0 || i > 20000) {
            return;
        }
        this.networkManager.defaultConnectTimeout = i;
    }

    private void setDefaultReadTimeout(int i) {
        if (i <= 0 || i > 20000) {
            return;
        }
        this.networkManager.defaultReadTimeout = i;
    }

    int getConnectTimeout() {
        IAPConnectTimeoutGetter iAPConnectTimeoutGetter = this.connectTimeoutGetter;
        if (iAPConnectTimeoutGetter != null) {
            return iAPConnectTimeoutGetter.getConnectTimeout();
        }
        return 0;
    }

    int getReadTimeout() {
        IAPReadTimeoutGetter iAPReadTimeoutGetter = this.readTimeoutGetter;
        if (iAPReadTimeoutGetter != null) {
            return iAPReadTimeoutGetter.getReadTimeOut();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateIPTimes(String str) {
        IAPIPMeasure iAPIPMeasure = this.iapipMeasure;
        if (iAPIPMeasure != null) {
            iAPIPMeasure.updateIPTimes(str);
        }
    }

    public void executeRequestAsync(APMidasHttpRequest aPMidasHttpRequest, APMidasHttpAns aPMidasHttpAns) {
        if (aPMidasHttpAns != null) {
            aPMidasHttpAns.setAPMidasHttpRequest(aPMidasHttpRequest);
        }
        this.networkManager.newCall(aPMidasHttpRequest).enqueue(aPMidasHttpAns);
    }

    public Response executeRequestSyncWithNoCustomInterceptors(APMidasHttpRequest aPMidasHttpRequest) {
        return this.networkManager.newCall(aPMidasHttpRequest).executeWithNoCustomInterceptor();
    }

    public Response executeRequestSyncWithAllCustomInterceptors(APMidasHttpRequest aPMidasHttpRequest) {
        return this.networkManager.newCall(aPMidasHttpRequest).executeWithAllCustomInterceptor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void executeRequestAsyncWithNoCustomInterceptors(APMidasHttpRequest aPMidasHttpRequest, Callback callback) {
        if (aPMidasHttpRequest != null) {
            this.networkManager.newCall(aPMidasHttpRequest).enqueueWithNoCustomInterceptor(callback);
        }
    }

    public void setConnectTimeoutGetter(IAPConnectTimeoutGetter iAPConnectTimeoutGetter) {
        this.connectTimeoutGetter = iAPConnectTimeoutGetter;
    }

    public void setReadTimeoutGetter(IAPReadTimeoutGetter iAPReadTimeoutGetter) {
        this.readTimeoutGetter = iAPReadTimeoutGetter;
    }

    public void setGetKeyRequestGetter(IAPGetKeyRequestGetter iAPGetKeyRequestGetter) {
        this.getKeyRequestGetter = iAPGetKeyRequestGetter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public APMidasHttpRequest getGetKeyRequest() {
        IAPGetKeyRequestGetter iAPGetKeyRequestGetter = this.getKeyRequestGetter;
        if (iAPGetKeyRequestGetter != null) {
            return iAPGetKeyRequestGetter.getGetKeyRequest();
        }
        return null;
    }

    public boolean isRequestInstanceAGetKeyRequest(Request request) {
        APMidasHttpRequest getKeyRequest;
        if (request == null || (getKeyRequest = getGetKeyRequest()) == null) {
            return false;
        }
        String simpleName = getKeyRequest.getClass().getSimpleName();
        if (TextUtils.isEmpty(simpleName)) {
            return false;
        }
        String simpleName2 = request.getClass().getSimpleName();
        return !TextUtils.isEmpty(simpleName2) && simpleName2.equals(simpleName);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.context;
    }

    public void setIPMeasure(IAPIPMeasure iAPIPMeasure) {
        this.iapipMeasure = iAPIPMeasure;
    }

    public void setDataReportNotifier(IAPDataReportNotifier iAPDataReportNotifier) {
        this.dataReportNotifier = iAPDataReportNotifier;
    }

    public void setMidasCommonInfoGetter(IAPMidasCommonInfoGetter iAPMidasCommonInfoGetter) {
        this.midasCommonInfoGetter = iAPMidasCommonInfoGetter;
    }

    public IAPMidasCommonInfoGetter getMidasCommonInfoGetter() {
        return this.midasCommonInfoGetter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyNetworkSuccess(Request request, Response response) {
        IAPDataReportNotifier iAPDataReportNotifier = this.dataReportNotifier;
        if (iAPDataReportNotifier != null) {
            iAPDataReportNotifier.onNetworkSuccess(request, response);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyNetworkFailure(Request request, Response response) {
        IAPDataReportNotifier iAPDataReportNotifier = this.dataReportNotifier;
        if (iAPDataReportNotifier != null) {
            iAPDataReportNotifier.onNetworkFailure(request, response);
        }
    }

    public void setGetKeySuccessHandler(IAPGetKeySuccessHandler iAPGetKeySuccessHandler) {
        this.getKeySuccessHandler = iAPGetKeySuccessHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyGetKeySuccess(Response response) {
        IAPGetKeySuccessHandler iAPGetKeySuccessHandler;
        if (response == null || TextUtils.isEmpty(response.responseBody) || (iAPGetKeySuccessHandler = this.getKeySuccessHandler) == null) {
            return;
        }
        iAPGetKeySuccessHandler.onGetKeySuccess(response);
    }

    public String getCryptKeyFromRam(String str, String str2) {
        return this.midasKeyManager.getCryptoKeyFromRam(str, str2);
    }

    public String readCryptKeyFromDisk(Context context, String str, String str2, String str3) {
        return this.midasKeyManager.readCryptKeyFromDisk(context, str, str2, str3);
    }

    public void setCryptKeyToRam(String str, String str2, String str3) {
        this.midasKeyManager.setCryptKeyToRam(str, str2, str3);
    }

    public void saveCryptKeyToDisk(Context context, String str, String str2, String str3, String str4) {
        this.midasKeyManager.saveCryptKeyToDisk(context, str, str2, str3, str4);
    }

    public boolean needChangeKey(Context context, String str, String str2, String str3) {
        return this.midasKeyManager.needChangeKey(context, str, str2, str3);
    }

    public void clearAllKey(Context context, String str, String str2, String str3) {
        this.midasKeyManager.clearAllKey(context, str, str2, str3);
    }

    public void clearCryptKeyAndKeyTime(Context context, String str, String str2, String str3) {
        this.midasKeyManager.clearCryptKeyAndKeyTime(context, str, str2, str3);
    }

    public void loadKeyFromDisk(Context context, String str, String str2, String str3) {
        this.midasKeyManager.loadKeyFromDisk(context, str, str2, str3);
    }

    public String getSecretKeyFromRam(String str, String str2) {
        return this.midasKeyManager.getSecretKeyFromRam(str, str2);
    }

    public String readSecretKeyFromDisk(Context context, String str, String str2, String str3) {
        return this.midasKeyManager.readSecretKeyFromDisk(context, str, str2, str3);
    }

    public void setSecretKeyToRam(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        this.midasKeyManager.setSecretKeyToRam(str, str2, str3);
    }

    public void saveSecretKeyToDisk(Context context, String str, String str2, String str3, String str4) {
        this.midasKeyManager.saveSecretKeyToDisk(context, str, str2, str3, str4);
    }

    public String getKeyTimeFromRam(String str, String str2) {
        return this.midasKeyManager.getCryptKeyTimeFromRam(str, str2);
    }

    public String readKeyTimeFromDisk(Context context, String str, String str2, String str3) {
        return this.midasKeyManager.readCryptKeyTimeFromDisk(context, str, str2, str3);
    }

    public void setKeyTimeToRam(String str, String str2, String str3) {
        this.midasKeyManager.setCryptKeyTimeToRam(str, str2, str3);
    }

    public void saveKeyTimeToDisk(Context context, String str, String str2, String str3, String str4) {
        this.midasKeyManager.saveCryptKeyTimeToDisk(context, str, str2, str3, str4);
    }

    public String getIV() {
        return this.IV;
    }

    public void setIV(String str) {
        this.IV = str;
    }
}
