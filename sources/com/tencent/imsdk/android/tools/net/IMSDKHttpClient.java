package com.tencent.imsdk.android.tools.net;

import android.content.Context;
import android.text.TextUtils;
import com.helpshift.common.domain.network.NetworkConstants;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.tools.net.volley.AuthFailureError;
import com.tencent.imsdk.android.tools.net.volley.ClientError;
import com.tencent.imsdk.android.tools.net.volley.DefaultRetryPolicy;
import com.tencent.imsdk.android.tools.net.volley.NetworkError;
import com.tencent.imsdk.android.tools.net.volley.NetworkResponse;
import com.tencent.imsdk.android.tools.net.volley.NoConnectionError;
import com.tencent.imsdk.android.tools.net.volley.ParseError;
import com.tencent.imsdk.android.tools.net.volley.Request;
import com.tencent.imsdk.android.tools.net.volley.RequestQueue;
import com.tencent.imsdk.android.tools.net.volley.Response;
import com.tencent.imsdk.android.tools.net.volley.RetryPolicy;
import com.tencent.imsdk.android.tools.net.volley.ServerError;
import com.tencent.imsdk.android.tools.net.volley.TimeoutError;
import com.tencent.imsdk.android.tools.net.volley.VolleyError;
import com.tencent.imsdk.android.tools.net.volley.VolleyLog;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpHeaderParser;
import com.tencent.imsdk.android.tools.net.volley.toolbox.JsonRequest;
import com.tencent.imsdk.android.tools.net.volley.toolbox.Volley;
import com.tencent.imsdk.android.tools.net.volley.upload.MultiPartRequest;
import com.tencent.imsdk.android.tools.net.volley.upload.RequestInfo;
import com.tencent.imsdk.android.tools.net.volley.upload.UploadCallback;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* loaded from: classes.dex */
public class IMSDKHttpClient {
    private static final int VOLLEY_AUTH_FAILURE_ERROR = -100;
    private static final int VOLLEY_CLIENT_ERROR = -131;
    private static final int VOLLEY_NET_WORK_ERROR = -110;
    private static final int VOLLEY_NO_CONNECTION_ERROR = -111;
    private static final int VOLLEY_PARSE_ERROR = -120;
    private static final int VOLLEY_SERVER_ERROR = -130;
    private static final int VOLLEY_TIMEOUT_ERROR = -140;
    private static final int VOLLEY_UNKNOWN = -1;
    private static RequestQueue mQueue;
    private static RequestQueue sRequestQueue;
    private Builder mBuilder;
    private Context mCtx;

    public IMSDKHttpClient(Context context) {
        if (context != null) {
            this.mCtx = context;
            if (mQueue == null) {
                mQueue = Volley.newRequestQueue(this.mCtx);
            }
            if (sRequestQueue == null) {
                sRequestQueue = Volley.newNoCacheRequestQueue();
            }
            VolleyLog.setDebuggable(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_DEBUG, IR.meta.IMSDK_DEBUG, false) && IMSDKConfig.getOrMetaData(IR.meta.IMSDK_INNER_VOLLEY_DEBUG, IR.meta.IMSDK_INNER_VOLLEY_DEBUG, true));
        }
    }

    public IMSDKHttpClient(Builder builder) {
        this.mBuilder = builder;
    }

    private void executeJsonPostVolley(String str, String str2, final IMSDKListener<String> iMSDKListener) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("request url = ");
        sb.append(str);
        if (str2 != null) {
            str3 = " , request json params = " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        IMLogger.d(sb.toString());
        mQueue.add(new JsonRequest<String>(1, str, str2, new Response.Listener<String>() { // from class: com.tencent.imsdk.android.tools.net.IMSDKHttpClient.1
            @Override // com.tencent.imsdk.android.tools.net.volley.Response.Listener
            public void onResponse(String str4) {
                IMLogger.d("json post request success : " + str4);
                iMSDKListener.onNotify(str4);
            }
        }, new Response.ErrorListener() { // from class: com.tencent.imsdk.android.tools.net.IMSDKHttpClient.2
            @Override // com.tencent.imsdk.android.tools.net.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                int i;
                IMLogger.e("json post request error : " + volleyError.getClass().getName() + " : " + volleyError.getMessage() + ", " + volleyError.getNetworkTimeMs(), new Object[0]);
                if (volleyError.networkResponse == null) {
                    if (volleyError instanceof AuthFailureError) {
                        i = -100;
                    } else if (volleyError instanceof NetworkError) {
                        i = volleyError instanceof NoConnectionError ? IMSDKHttpClient.VOLLEY_NO_CONNECTION_ERROR : IMSDKHttpClient.VOLLEY_NET_WORK_ERROR;
                    } else if (volleyError instanceof ParseError) {
                        i = IMSDKHttpClient.VOLLEY_PARSE_ERROR;
                    } else if (volleyError instanceof ServerError) {
                        i = volleyError instanceof ClientError ? IMSDKHttpClient.VOLLEY_CLIENT_ERROR : IMSDKHttpClient.VOLLEY_SERVER_ERROR;
                    } else {
                        i = volleyError instanceof TimeoutError ? IMSDKHttpClient.VOLLEY_TIMEOUT_ERROR : -1;
                    }
                } else {
                    i = volleyError.networkResponse.statusCode;
                }
                iMSDKListener.onResult(new IMSDKResult(4, i, volleyError.getClass().getName() + " : " + volleyError.getMessage() + ", " + volleyError.getNetworkTimeMs()));
            }
        }) { // from class: com.tencent.imsdk.android.tools.net.IMSDKHttpClient.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.imsdk.android.tools.net.volley.toolbox.JsonRequest, com.tencent.imsdk.android.tools.net.volley.Request
            public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
                return Response.success(new String(networkResponse.data), HttpHeaderParser.parseCacheHeaders(networkResponse));
            }

            @Override // com.tencent.imsdk.android.tools.net.volley.Request
            public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
                DefaultRetryPolicy defaultRetryPolicy;
                if (IMSDKHttpClient.this.mBuilder != null) {
                    defaultRetryPolicy = new DefaultRetryPolicy(IMSDKHttpClient.this.mBuilder.getTimeout(), IMSDKHttpClient.this.mBuilder.getMaxRetries(), IMSDKHttpClient.this.mBuilder.getBackoffFactor());
                } else {
                    defaultRetryPolicy = new DefaultRetryPolicy(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_NETWORK_TIMEOUT_MS, IR.meta.IMSDK_NETWORK_TIMEOUT_MS, NetworkConstants.UPLOAD_CONNECT_TIMEOUT), IMSDKConfig.getOrMetaData(IR.meta.IMSDK_NETWORK_MAX_RETRIES, IR.meta.IMSDK_NETWORK_MAX_RETRIES, 1), T.Meta.readFromApplication(IMSDKHttpClient.this.mCtx, IR.meta.IMSDK_NETWORK_BACK_OFF_FACTOR, 1));
                }
                return super.setRetryPolicy(defaultRetryPolicy);
            }
        });
    }

    private void executeVolley(int i, String str, Map<String, String> map, final IMSDKListener<byte[]> iMSDKListener) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("request url = ");
        sb.append(str);
        if (map != null) {
            str2 = " , request params = " + map.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        IMLogger.d(sb.toString());
        mQueue.add(new IMRequest(i, str, map, new Response.Listener<byte[]>() { // from class: com.tencent.imsdk.android.tools.net.IMSDKHttpClient.4
            @Override // com.tencent.imsdk.android.tools.net.volley.Response.Listener
            public void onResponse(byte[] bArr) {
                iMSDKListener.onNotify(bArr);
            }
        }, new Response.ErrorListener() { // from class: com.tencent.imsdk.android.tools.net.IMSDKHttpClient.5
            @Override // com.tencent.imsdk.android.tools.net.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                int i2;
                IMLogger.e("get error result :  " + volleyError.getClass().getName() + " : " + volleyError.getMessage() + ", " + volleyError.getNetworkTimeMs(), new Object[0]);
                if (volleyError.networkResponse == null) {
                    if (volleyError instanceof AuthFailureError) {
                        i2 = -100;
                    } else if (volleyError instanceof NetworkError) {
                        i2 = volleyError instanceof NoConnectionError ? IMSDKHttpClient.VOLLEY_NO_CONNECTION_ERROR : IMSDKHttpClient.VOLLEY_NET_WORK_ERROR;
                    } else if (volleyError instanceof ParseError) {
                        i2 = IMSDKHttpClient.VOLLEY_PARSE_ERROR;
                    } else if (volleyError instanceof ServerError) {
                        i2 = volleyError instanceof ClientError ? IMSDKHttpClient.VOLLEY_CLIENT_ERROR : IMSDKHttpClient.VOLLEY_SERVER_ERROR;
                    } else {
                        i2 = volleyError instanceof TimeoutError ? IMSDKHttpClient.VOLLEY_TIMEOUT_ERROR : -1;
                    }
                } else {
                    i2 = volleyError.networkResponse.statusCode;
                }
                iMSDKListener.onResult(new IMSDKResult(4, i2, volleyError.getClass().getName() + " : " + volleyError.getMessage() + ", " + volleyError.getNetworkTimeMs()));
            }
        }) { // from class: com.tencent.imsdk.android.tools.net.IMSDKHttpClient.6
            @Override // com.tencent.imsdk.android.tools.net.volley.Request
            public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
                DefaultRetryPolicy defaultRetryPolicy;
                if (IMSDKHttpClient.this.mBuilder != null) {
                    defaultRetryPolicy = new DefaultRetryPolicy(IMSDKHttpClient.this.mBuilder.getTimeout(), IMSDKHttpClient.this.mBuilder.getMaxRetries(), IMSDKHttpClient.this.mBuilder.getBackoffFactor());
                } else {
                    defaultRetryPolicy = new DefaultRetryPolicy(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_NETWORK_TIMEOUT_MS, IR.meta.IMSDK_NETWORK_TIMEOUT_MS, NetworkConstants.UPLOAD_CONNECT_TIMEOUT), IMSDKConfig.getOrMetaData(IR.meta.IMSDK_NETWORK_MAX_RETRIES, IR.meta.IMSDK_NETWORK_MAX_RETRIES, 1), T.Meta.readFromApplication(IMSDKHttpClient.this.mCtx, IR.meta.IMSDK_NETWORK_BACK_OFF_FACTOR, 1));
                }
                return super.setRetryPolicy(defaultRetryPolicy);
            }
        });
    }

    public void get(String str, IMSDKListener<byte[]> iMSDKListener) {
        executeVolley(0, str, null, iMSDKListener);
    }

    public void get(String str, Map<String, String> map, IMSDKListener<byte[]> iMSDKListener) {
        executeVolley(0, str, map, iMSDKListener);
    }

    public void post(String str, Map<String, String> map, IMSDKListener<byte[]> iMSDKListener) {
        executeVolley(1, str, map, iMSDKListener);
    }

    public void post(String str, String str2, IMSDKListener<String> iMSDKListener) {
        executeJsonPostVolley(str, str2, iMSDKListener);
    }

    public void upload(String str, Map<String, Object> map, UploadCallback uploadCallback) {
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.url = str;
        requestInfo.putAllParams(map);
        uploadByPost(requestInfo, uploadCallback);
    }

    public void uploadByPost(RequestInfo requestInfo, final UploadCallback uploadCallback) {
        if (sRequestQueue == null) {
            sRequestQueue = Volley.newNoCacheRequestQueue();
        }
        String url = requestInfo.getUrl();
        if (TextUtils.isEmpty(url)) {
            if (uploadCallback != null) {
                uploadCallback.onFail("url can not be empty!");
                return;
            }
            return;
        }
        MultiPartRequest<String> multiPartRequest = new MultiPartRequest<String>(1, url, new Response.Listener<String>() { // from class: com.tencent.imsdk.android.tools.net.IMSDKHttpClient.7
            @Override // com.tencent.imsdk.android.tools.net.volley.Response.Listener
            public void onResponse(String str) {
                UploadCallback uploadCallback2 = uploadCallback;
                if (uploadCallback2 != null) {
                    uploadCallback2.onSucceed(str);
                }
            }
        }, new Response.ErrorListener() { // from class: com.tencent.imsdk.android.tools.net.IMSDKHttpClient.8
            @Override // com.tencent.imsdk.android.tools.net.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                UploadCallback uploadCallback2 = uploadCallback;
                if (uploadCallback2 != null) {
                    uploadCallback2.onFail(volleyError.getMessage());
                }
            }
        }) { // from class: com.tencent.imsdk.android.tools.net.IMSDKHttpClient.9
            @Override // com.tencent.imsdk.android.tools.net.volley.upload.MultiPartRequest, com.tencent.imsdk.android.tools.net.volley.Request
            protected Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
                String str;
                try {
                    str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
                } catch (UnsupportedEncodingException unused) {
                    str = new String(networkResponse.data);
                } catch (NullPointerException unused2) {
                    str = "";
                }
                return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
            }
        };
        Map<String, String> params = requestInfo.getParams();
        Map<String, File> fileParams = requestInfo.getFileParams();
        if (params != null && params.size() != 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                multiPartRequest.addPart(entry.getKey(), entry.getValue());
            }
        }
        if (fileParams != null && fileParams.size() != 0) {
            for (Map.Entry<String, File> entry2 : fileParams.entrySet()) {
                String key = entry2.getKey();
                int indexOf = key.indexOf(requestInfo.boundary);
                if (indexOf > 0) {
                    key = key.substring(0, indexOf);
                }
                multiPartRequest.addPart(key, entry2.getValue());
            }
        }
        multiPartRequest.setTag(this);
        sRequestQueue.add(multiPartRequest);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private int backoffFactor;
        private int maxRetries;
        private int timeout;

        public int getTimeout() {
            return this.timeout;
        }

        public Builder setTimeout(int i) {
            this.timeout = i;
            return this;
        }

        public int getMaxRetries() {
            return this.maxRetries;
        }

        public Builder setMaxRetries(int i) {
            this.maxRetries = i;
            return this;
        }

        public int getBackoffFactor() {
            return this.backoffFactor;
        }

        public Builder setBackoffFactor(int i) {
            this.backoffFactor = i;
            return this;
        }

        public IMSDKHttpClient build() {
            return new IMSDKHttpClient(this);
        }

        public String toString() {
            return "IMSDKHttpClient.Builder{timeout=" + this.timeout + ", maxRetries=" + this.maxRetries + ", backoffFactor=" + this.backoffFactor + '}';
        }
    }
}
