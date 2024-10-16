package com.tencent.midas.http.core;

import com.tencent.midas.http.core.Call;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface INetworkManager extends Call.Factory {
    void addFistInterceptor(Interceptor interceptor);

    void addHttpHandler(HttpHandler httpHandler);

    void addLastInterceptor(Interceptor interceptor);

    void cancelAllRequest();

    void cancelRequestByName(String str);

    Delivery delivery();

    Dispatcher dispatcher();

    ArrayList<Interceptor> getAllInterceptors();

    ArrayList<Interceptor> getBuiltinInterceptors();

    int getDefaultMaxRetryTimes();

    void registerAsyncHttpCall(ExecutableCall executableCall);

    void setDefaultMaxRetryTimes(int i);

    void setDelivery(Delivery delivery);

    void unregisterAsyncHttpCall(ExecutableCall executableCall);
}
