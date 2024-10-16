package com.tdatamaster.tdm.system;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TDMHttp {
    private static final int HTTP_ERROR_CODE_EXCEPTION = -2;
    private static final int HTTP_ERROR_CODE_PARAMS = -1;
    private static final String HTTP_KEY_CONNECT_TIMEOUT = "connectTimeout";
    private static final String HTTP_KEY_READ_TIMEOUT = "readTimeout";
    private static final String HTTP_KEY_USE_CACHE = "useCache";
    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";
    private static final int HTTP_READ_BUFFER_DEFAULT = 256;
    private static final String TAG = "[TDM]";

    public static String httpGet(String str, String str2, String str3) {
        byte[] bArr;
        InputStream inputStream = null;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    try {
                        HttpURLConnection httpUrlConnection = getHttpUrlConnection(str, "GET", str2, str3);
                        httpUrlConnection.connect();
                        int responseCode = httpUrlConnection.getResponseCode();
                        if (responseCode == 200) {
                            inputStream = httpUrlConnection.getInputStream();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr2 = new byte[256];
                            while (true) {
                                int read = inputStream.read(bArr2, 0, bArr2.length);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = null;
                        }
                        String makeResponseResult = makeResponseResult(responseCode, bArr);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                TDMLog.e(TAG, e.getMessage());
                            }
                        }
                        return makeResponseResult;
                    } catch (Exception e2) {
                        TDMLog.e(TAG, e2.getMessage());
                        String makeResponseResult2 = makeResponseResult(-2, e2.getMessage().getBytes());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                TDMLog.e(TAG, e3.getMessage());
                            }
                        }
                        return makeResponseResult2;
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        TDMLog.e(TAG, e4.getMessage());
                    }
                }
                throw th;
            }
        }
        return makeResponseResult(-1, null);
    }

    public static String httpPost(String str, byte[] bArr, String str2, String str3) {
        byte[] bArr2;
        TDMLog.i("HttpNetwork", "http post with url:" + str + ", post body length: " + bArr.length);
        InputStream inputStream = null;
        if (str == null || str.isEmpty()) {
            return makeResponseResult(-1, null);
        }
        try {
            try {
                HttpURLConnection httpUrlConnection = getHttpUrlConnection(str, "POST", str2, str3);
                httpUrlConnection.connect();
                new DataOutputStream(httpUrlConnection.getOutputStream()).write(bArr);
                int responseCode = httpUrlConnection.getResponseCode();
                if (responseCode == 200) {
                    inputStream = httpUrlConnection.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr3 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr3, 0, bArr3.length);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr3, 0, read);
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                } else {
                    bArr2 = null;
                }
                String makeResponseResult = makeResponseResult(responseCode, bArr2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        TDMLog.e(TAG, e.getMessage());
                    }
                }
                return makeResponseResult;
            } catch (Exception e2) {
                TDMLog.e(TAG, e2.getMessage());
                String makeResponseResult2 = makeResponseResult(-2, e2.getMessage().getBytes());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        TDMLog.e(TAG, e3.getMessage());
                    }
                }
                return makeResponseResult2;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    TDMLog.e(TAG, e4.getMessage());
                }
            }
            throw th;
        }
    }

    private static HttpURLConnection getHttpUrlConnection(String str, String str2, String str3, String str4) throws Exception {
        JSONObject jSONObject;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2 = new JSONObject(str4);
        } catch (Exception e) {
            TDMLog.e(TAG, "Http request connect info invalid:" + e.getMessage());
        }
        try {
            jSONObject = new JSONObject(str3);
        } catch (Exception e2) {
            TDMLog.e(TAG, "Http request header info invalid:" + e2.getMessage());
            jSONObject = jSONObject3;
        }
        httpURLConnection.setConnectTimeout(jSONObject2.optInt(HTTP_KEY_CONNECT_TIMEOUT, 30) * 1000);
        httpURLConnection.setReadTimeout(jSONObject2.optInt(HTTP_KEY_READ_TIMEOUT, 30) * 1000);
        httpURLConnection.setDefaultUseCaches(jSONObject2.optBoolean(HTTP_KEY_USE_CACHE, false));
        httpURLConnection.setUseCaches(jSONObject2.optBoolean(HTTP_KEY_USE_CACHE, false));
        httpURLConnection.setRequestMethod(str2);
        if ("POST".equals(str2)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setRequestProperty("Content-Type", "text/plain");
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            httpURLConnection.setRequestProperty(next, jSONObject.optString(next));
        }
        return httpURLConnection;
    }

    public static String makeResponseResult(int i, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return i + ";";
        }
        return i + ";" + new String(bArr);
    }
}
