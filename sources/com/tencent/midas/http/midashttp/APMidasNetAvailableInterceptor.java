package com.tencent.midas.http.midashttp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.midas.http.core.Interceptor;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* loaded from: classes.dex */
public class APMidasNetAvailableInterceptor implements Interceptor {
    private static final int ERROR_NETWORK_UNREACHABLE = 20006;
    private final APMidasNetworkManager newNetworkManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public APMidasNetAvailableInterceptor(APMidasNetworkManager aPMidasNetworkManager) {
        this.newNetworkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.core.Interceptor
    public Response intercept(Request request, Response response) {
        Context context;
        APMidasNetworkManager aPMidasNetworkManager = this.newNetworkManager;
        if (aPMidasNetworkManager == null || (context = aPMidasNetworkManager.getContext()) == null || getNetworkAvailable(context)) {
            return response;
        }
        Response generateFakeMidasResponse = APMidasHttpResponse.generateFakeMidasResponse(ERROR_NETWORK_UNREACHABLE, "网络未连接，请检查");
        generateFakeMidasResponse.needBreakOtherInterceptors = true;
        return generateFakeMidasResponse;
    }

    private static boolean getNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }
}
