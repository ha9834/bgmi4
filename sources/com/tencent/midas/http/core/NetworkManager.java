package com.tencent.midas.http.core;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class NetworkManager implements INetworkManager {
    private Delivery delivery;
    private HttpInterceptor httpInterceptor;
    private Dispatcher mDispatcher;
    private final ArrayList<Interceptor> frontInterceptors = new ArrayList<>();
    private final ArrayList<Interceptor> builtinInterceptors = new ArrayList<>();
    private final ArrayList<Interceptor> endInterceptors = new ArrayList<>();
    private int defaultMaxRetryTimes = 2;
    public int defaultConnectTimeout = 15000;
    public int defaultReadTimeout = 15000;
    private final ConcurrentLinkedQueue<ExecutableCall> allAsyncHttpCall = new ConcurrentLinkedQueue<>();

    public NetworkManager(IHttpLog iHttpLog) {
        HttpLog.httpLogInterface = iHttpLog;
        this.httpInterceptor = new HttpInterceptor(this);
        this.builtinInterceptors.add(this.httpInterceptor);
        this.mDispatcher = new Dispatcher();
        this.delivery = new MainThreadDelivery();
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public void addHttpHandler(HttpHandler httpHandler) {
        if (httpHandler != null) {
            this.httpInterceptor.addHttpHandler(httpHandler);
        }
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public void registerAsyncHttpCall(ExecutableCall executableCall) {
        if (executableCall != null) {
            this.allAsyncHttpCall.add(executableCall);
        }
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public void unregisterAsyncHttpCall(ExecutableCall executableCall) {
        if (executableCall != null) {
            this.allAsyncHttpCall.remove(executableCall);
        }
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public void cancelRequestByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<ExecutableCall> it = this.allAsyncHttpCall.iterator();
        while (it.hasNext()) {
            ExecutableCall next = it.next();
            if (next != null && str.equals(next.getRequestName())) {
                next.cancel();
            }
        }
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public void cancelAllRequest() {
        Iterator<ExecutableCall> it = this.allAsyncHttpCall.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public ArrayList<Interceptor> getAllInterceptors() {
        ArrayList<Interceptor> arrayList = new ArrayList<>();
        arrayList.addAll(this.frontInterceptors);
        arrayList.addAll(this.builtinInterceptors);
        arrayList.addAll(this.endInterceptors);
        return arrayList;
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public ArrayList<Interceptor> getBuiltinInterceptors() {
        return new ArrayList<>(this.builtinInterceptors);
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public synchronized void addFistInterceptor(Interceptor interceptor) {
        if (interceptor != null) {
            this.frontInterceptors.add(interceptor);
        }
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public void setDefaultMaxRetryTimes(int i) {
        this.defaultMaxRetryTimes = i;
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public int getDefaultMaxRetryTimes() {
        return this.defaultMaxRetryTimes;
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public synchronized void addLastInterceptor(Interceptor interceptor) {
        if (interceptor != null) {
            this.endInterceptors.add(interceptor);
        }
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public Dispatcher dispatcher() {
        return this.mDispatcher;
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public Delivery delivery() {
        return this.delivery;
    }

    @Override // com.tencent.midas.http.core.INetworkManager
    public void setDelivery(Delivery delivery) {
        if (delivery != null) {
            this.delivery = delivery;
        }
    }

    @Override // com.tencent.midas.http.core.Call.Factory
    public Call newCall(Request request) {
        return new HttpCall(this, request);
    }
}
