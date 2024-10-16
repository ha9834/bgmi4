package com.ihoc.mgpa.n;

import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.Constants;
import com.helpshift.common.platform.network.UploadRequest;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static int f5675a = 5000;
    private static int b = 5000;

    private static String a(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(new String(bArr, 0, read));
        }
    }

    public static String a(String str, String str2, String str3, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        httpURLConnection.setConnectTimeout(f5675a);
        httpURLConnection.setReadTimeout(b);
        if (str != null) {
            httpURLConnection.setRequestMethod(str);
        }
        if (map != null) {
            for (String str4 : map.keySet()) {
                httpURLConnection.addRequestProperty(str4, map.get(str4));
            }
        }
        if (str3 != null) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str3.getBytes());
            outputStream.flush();
            outputStream.close();
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        String a2 = a(inputStream);
        inputStream.close();
        return httpURLConnection.getResponseCode() == 301 ? a(str, httpURLConnection.getHeaderField(HttpHeader.LOCATION), str3, map) : a2;
    }

    public static String a(String str, String str2, Map<String, String> map) {
        return a("POST", str, str2, map);
    }

    public static String a(String str, Map<String, String> map) {
        return a("GET", str, null, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String a(String str, Map<String, String> map, String str2, String str3, String str4) {
        FileInputStream fileInputStream;
        DataOutputStream dataOutputStream;
        String str5 = UploadRequest.BOUNDARY + System.currentTimeMillis() + UploadRequest.BOUNDARY;
        InputStream inputStream = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(str3));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            dataOutputStream = null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(Headers.CONNECTION, "Keep-Alive");
            httpURLConnection.setRequestProperty(HttpHeader.USER_AGENT, "Android Multipart HTTP Client 1.0");
            StringBuilder sb = new StringBuilder();
            sb.append("multipart/form-data; boundary=");
            sb.append(str5);
            httpURLConnection.setRequestProperty("Content-Type", sb.toString());
            DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream2.writeBytes("--" + str5 + APLogFileUtil.SEPARATOR_LINE);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Content-Disposition: form-data; name=\"uploadfile\"; filename=\"");
                sb2.append(str4);
                sb2.append("\"");
                sb2.append(APLogFileUtil.SEPARATOR_LINE);
                dataOutputStream2.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Content-Type: ");
                sb3.append(str2);
                sb3.append(APLogFileUtil.SEPARATOR_LINE);
                dataOutputStream2.writeBytes(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Content-Transfer-Encoding: binary");
                sb4.append(APLogFileUtil.SEPARATOR_LINE);
                dataOutputStream2.writeBytes(sb4.toString());
                dataOutputStream2.writeBytes(APLogFileUtil.SEPARATOR_LINE);
                int min = Math.min(fileInputStream.available(), Constants.MB);
                byte[] bArr = new byte[min];
                while (fileInputStream.read(bArr, 0, min) > 0) {
                    dataOutputStream2.write(bArr, 0, min);
                    min = Math.min(fileInputStream.available(), Constants.MB);
                }
                dataOutputStream2.writeBytes(APLogFileUtil.SEPARATOR_LINE);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        dataOutputStream2.writeBytes("--" + str5 + APLogFileUtil.SEPARATOR_LINE);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Content-Disposition: form-data; name=\"");
                        sb5.append(entry.getKey());
                        sb5.append("\"");
                        sb5.append(APLogFileUtil.SEPARATOR_LINE);
                        dataOutputStream2.writeBytes(sb5.toString());
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Content-Type: text/plain");
                        sb6.append(APLogFileUtil.SEPARATOR_LINE);
                        dataOutputStream2.writeBytes(sb6.toString());
                        dataOutputStream2.writeBytes(APLogFileUtil.SEPARATOR_LINE);
                        dataOutputStream2.writeBytes(entry.getValue());
                        dataOutputStream2.writeBytes(APLogFileUtil.SEPARATOR_LINE);
                    }
                }
                dataOutputStream2.writeBytes("--" + str5 + "--" + APLogFileUtil.SEPARATOR_LINE);
                if (200 != httpURLConnection.getResponseCode()) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Failed to upload code:");
                    sb7.append(httpURLConnection.getResponseCode());
                    sb7.append(" ");
                    sb7.append(httpURLConnection.getResponseMessage());
                    throw new Exception(sb7.toString());
                }
                InputStream inputStream2 = httpURLConnection.getInputStream();
                String a2 = a(inputStream2);
                dataOutputStream2.flush();
                fileInputStream.close();
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                dataOutputStream2.close();
                return a2;
            } catch (Exception e2) {
                e = e2;
                throw new Exception(e);
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (0 != 0) {
                inputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            throw th;
        }
    }

    public static String a(String str, Map<String, String> map, Map<String, String> map2) {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        map2.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            boolean z = true;
            for (String str2 : map.keySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                String str3 = map.get(str2);
                sb.append(URLEncoder.encode(str2, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(str3, "UTF-8"));
            }
        }
        return a(str, sb.toString(), map2);
    }

    public static void a(int i) {
        f5675a = i;
    }

    public static String b(String str, Map<String, String> map) {
        return a(str, map, (Map<String, String>) null);
    }

    public static void b(int i) {
        b = i;
    }
}
