package com.tencent.midas.http.core;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class HttpCall implements Call {
    private final NetworkManager mNetMgr;
    private final Request mRequest;

    @Override // com.tencent.midas.http.core.Call
    public boolean isCanceled() {
        return false;
    }

    @Override // com.tencent.midas.http.core.Call
    public boolean isExecuted() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCall(NetworkManager networkManager, Request request) {
        this.mRequest = request;
        this.mNetMgr = networkManager;
    }

    @Override // com.tencent.midas.http.core.Call
    public void cancel() {
        Request request = this.mRequest;
        if (request != null) {
            request.stopRequest();
        }
    }

    @Override // com.tencent.midas.http.core.Call
    public void enqueue(Callback callback) {
        Dispatcher dispatcher;
        NetworkManager networkManager = this.mNetMgr;
        if (networkManager == null || (dispatcher = networkManager.dispatcher()) == null) {
            return;
        }
        dispatcher.enqueue(new AsyncHttpCall(callback, false));
    }

    @Override // com.tencent.midas.http.core.Call
    public void enqueueWithNoCustomInterceptor(Callback callback) {
        Dispatcher dispatcher;
        NetworkManager networkManager = this.mNetMgr;
        if (networkManager == null || (dispatcher = networkManager.dispatcher()) == null) {
            return;
        }
        dispatcher.enqueue(new AsyncHttpCall(callback, true));
    }

    @Override // com.tencent.midas.http.core.Call
    public Response execute() {
        return getResponseWithInterceptorChain(false);
    }

    @Override // com.tencent.midas.http.core.Call
    public Response executeWithNoCustomInterceptor() {
        return getResponseWithInterceptorChain(true);
    }

    @Override // com.tencent.midas.http.core.Call
    public Response executeWithAllCustomInterceptor() {
        return getResponseWithInterceptorChain(false);
    }

    /* loaded from: classes.dex */
    class AsyncHttpCall implements ExecutableCall {
        private final Callback mCallback;
        private final boolean withNoCustomInterceptors;

        AsyncHttpCall(Callback callback, boolean z) {
            this.mCallback = callback;
            this.withNoCustomInterceptors = z;
        }

        @Override // com.tencent.midas.http.core.ExecutableCall
        public void cancel() {
            if (HttpCall.this.mRequest != null) {
                HttpCall.this.mRequest.stopRequest();
            }
        }

        @Override // com.tencent.midas.http.core.ExecutableCall
        public String getRequestName() {
            return HttpCall.this.mRequest != null ? HttpCall.this.mRequest.getClass().getSimpleName() : "";
        }

        @Override // java.lang.Runnable
        public void run() {
            String name = Thread.currentThread().getName();
            try {
                Thread.currentThread().setName(getRequestName() + "-" + Thread.currentThread().getId());
                if (HttpCall.this.mNetMgr != null) {
                    HttpCall.this.mNetMgr.registerAsyncHttpCall(this);
                }
                Response responseWithInterceptorChain = HttpCall.this.getResponseWithInterceptorChain(this.withNoCustomInterceptors);
                if (HttpCall.this.mRequest != null) {
                    if (HttpCall.this.mRequest.isStopped()) {
                        responseWithInterceptorChain.isStopped = true;
                    }
                    if (HttpCall.this.mRequest.delivery != null) {
                        HttpCall.this.mRequest.delivery.deliverResult(responseWithInterceptorChain, this.mCallback);
                    } else if (HttpCall.this.mNetMgr != null && HttpCall.this.mNetMgr.delivery() != null) {
                        HttpCall.this.mNetMgr.delivery().deliverResult(responseWithInterceptorChain, this.mCallback);
                    }
                }
            } finally {
                Thread.currentThread().setName(name);
                if (HttpCall.this.mNetMgr != null) {
                    HttpCall.this.mNetMgr.unregisterAsyncHttpCall(this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response getResponseWithInterceptorChain(boolean z) {
        ArrayList<Interceptor> allInterceptors;
        Response response = new Response();
        response.setRequest(this.mRequest);
        NetworkManager networkManager = this.mNetMgr;
        if (networkManager == null) {
            return response;
        }
        if (z) {
            allInterceptors = networkManager.getBuiltinInterceptors();
        } else {
            allInterceptors = networkManager.getAllInterceptors();
        }
        if (allInterceptors == null) {
            return response;
        }
        Iterator<Interceptor> it = allInterceptors.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            response = it.next().intercept(this.mRequest, response);
            if (response != null && response.needBreakOtherInterceptors) {
                response.resetNeedBreakOtherInterceptors();
                break;
            }
        }
        return response;
    }
}
