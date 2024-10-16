package com.tencent.midas.oversea.comm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.oversea.comm.MAlertDialog;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.mtt.engine.http.HttpUtils;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateNotYetValidException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.security.cert.CertificateExpiredException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APTools {
    private static final String TAG = "APTools";
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static void setNetwork(final Context context) {
        new MAlertDialog.Builder(context).setTitle("error").setContent(APCommMethod.getStringId(context, "unipay_error_network_not_connected")).setDialogButton(APCommMethod.getStringId(context, "unipay_tip_setting"), new DialogInterface.OnClickListener() { // from class: com.tencent.midas.oversea.comm.APTools.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                context.startActivity(new Intent("android.settings.SETTINGS"));
                dialogInterface.cancel();
            }
        }).setCancelable(false).create().show();
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            APLog.e(TAG, "isNetworkAvailable(): " + e.getMessage());
            return false;
        }
    }

    public static int getNetWorkType(Context context) {
        try {
            if (!isNetworkConnect(context)) {
                return -1;
            }
            if (isNetworkWIFI(context)) {
                return 1000;
            }
            if (isNetwork4G(context)) {
                return 4;
            }
            if (isNetwork3G(context)) {
                return 3;
            }
            return isWAP(context) ? 1 : 2;
        } catch (Exception e) {
            APLog.e(TAG, "getNetWorkType(): " + e.getMessage());
            return -1;
        }
    }

    public static boolean isWAP(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || !"MOBILE".equals(activeNetworkInfo.getTypeName())) {
                return false;
            }
            String defaultHost = Proxy.getDefaultHost();
            if (TextUtils.isEmpty(defaultHost) || !defaultHost.contains("wap")) {
                return defaultHost.contains("WAP");
            }
            return true;
        } catch (Exception e) {
            APLog.e(TAG, "isWAP(): " + e.getMessage());
            return false;
        }
    }

    public static boolean isNetworkConnect(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            APLog.e(TAG, "isNetworkConnect(): " + e.getMessage());
            return false;
        }
    }

    public static boolean isNetworkWIFI(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI");
        } catch (Exception e) {
            APLog.e(TAG, "isNetworkWIFI(): " + e.getMessage());
            return false;
        }
    }

    public static boolean isNetwork3G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                if (networkType == 3 || networkType == 6) {
                    return true;
                }
                switch (networkType) {
                    case 8:
                        return true;
                    case 9:
                        return true;
                    case 10:
                        return true;
                    default:
                        return false;
                }
            }
        } catch (Exception e) {
            APLog.e(TAG, "isNetwork3G(): " + e.getMessage());
        }
        return false;
    }

    public static boolean isNetwork4G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkType() == 13;
            }
        } catch (Exception e) {
            APLog.e(TAG, "isNetwork4G(): " + e.getMessage());
        }
        return false;
    }

    public static String urlEncode(String str, int i) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            APLog.i("urlEncode", "编码内容为空");
        } else {
            if (i <= 0) {
                return str;
            }
            int i2 = 0;
            while (i2 < i) {
                try {
                    str = URLEncoder.encode(str, HttpUtils.DEFAULT_ENCODE_NAME);
                } catch (Exception e) {
                    APLog.i("urlEncode", e.toString());
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
        return str2;
    }

    public static String urlDecode(String str, int i) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            APLog.w("", "解码内容为空");
        } else {
            if (i <= 0) {
                return str;
            }
            int i2 = 0;
            while (i2 < i) {
                try {
                    str2 = URLDecoder.decode(str, HttpUtils.DEFAULT_ENCODE_NAME);
                    i2++;
                    str = str2;
                } catch (Exception e) {
                    APLog.e(TAG, "urlDecode(): " + e.getMessage());
                }
            }
        }
        return str2;
    }

    public static HashMap<String, String> url2Map(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        String str2 = str.split("\\?")[1];
        try {
            if (!TextUtils.isEmpty(str2)) {
                for (String str3 : str2.split("&")) {
                    String[] split = str3.split("=");
                    if (!TextUtils.isEmpty(split[0])) {
                        hashMap.put(split[0], split[1]);
                    }
                }
            } else {
                APLog.i("url2Map", "url后参数为空");
            }
        } catch (Exception e) {
            APLog.w("url2Map", e.toString());
        }
        return hashMap;
    }

    public static String map2Js(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            APLog.i(TAG, "map2Js fail: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public static String map2UrlParams(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getValue())) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append("&");
                }
            }
            if (!TextUtils.isEmpty(stringBuffer)) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        } catch (Exception e) {
            APLog.e(TAG, "map2UrlParams(): " + e.getMessage());
        }
        return stringBuffer.toString();
    }

    public static HashMap<String, String> kv2Map(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split("&")) {
                    String[] split = str2.split("=");
                    if (!TextUtils.isEmpty(split[0])) {
                        hashMap.put(split[0], split[1]);
                    }
                }
            } else {
                APLog.i(TAG, "kv2Map(..): url后参数为空");
            }
        } catch (Exception e) {
            APLog.e(TAG, "kv2Map(): " + e.getMessage());
        }
        return hashMap;
    }

    public static String signString(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes());
            return byteArrayToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            APLog.e(TAG, "signString(): " + e.getMessage());
            return null;
        }
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static boolean isTestEnv() {
        return !"release".equals(GlobalData.singleton().env);
    }

    public static boolean isIPv4Address(String str) {
        return IPV4_PATTERN.matcher(str).matches();
    }

    public static boolean isIPv6StdAddress(String str) {
        return IPV6_STD_PATTERN.matcher(str).matches();
    }

    public static boolean isIPv6HexCompressedAddress(String str) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(str).matches();
    }

    public static boolean isIPAddress(String str) {
        return str != null && (isIPv4Address(str) || isIPv6StdAddress(str) || isIPv6HexCompressedAddress(str));
    }

    public static boolean isWifiProxy(Throwable th) {
        APLog.w("APBaseHttpReq", "isWifiProxy https exception" + th.toString());
        return getNetWorkType(APMidasPayNewAPI.singleton().getApplicationContext()) == 1000 && !TextUtils.isEmpty(Proxy.getDefaultHost()) && th.toString().contains("Trust anchor for certification path not found");
    }

    public static boolean isSSLV3Error(Throwable th) {
        APLog.w("APBaseHttpReq", "isSSLV3Error https exception" + th.toString());
        String th2 = th.toString();
        return (th2.contains("SSL handshake aborted") && th2.contains("usually a protocol error")) || th2.contains("GET_SERVER_HELLO");
    }

    public static boolean isTimeError(Throwable th) {
        APLog.w("APBaseHttpReq", "isTimeError https exception" + th.toString());
        String th2 = th.toString();
        if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
            return true;
        }
        if (TextUtils.isEmpty(th2)) {
            return false;
        }
        if (th2.contains("validation time") && th2.contains("current time")) {
            return true;
        }
        if (th2.contains("GMT") && th2.contains("compared to")) {
            return true;
        }
        if (th2.contains("Could not validate certificate")) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis > 0 && 1451577600 > currentTimeMillis) {
                return true;
            }
        }
        return false;
    }

    public static int getErrorTypeFromException(Exception exc) {
        if (exc == null) {
            return -10;
        }
        if (exc instanceof CharConversionException) {
            return -20;
        }
        if (exc instanceof MalformedInputException) {
            return -21;
        }
        if (exc instanceof UnmappableCharacterException) {
            return -22;
        }
        if (exc instanceof ClosedChannelException) {
            return -24;
        }
        if (exc instanceof EOFException) {
            return -26;
        }
        if (exc instanceof FileLockInterruptionException) {
            return -27;
        }
        if (exc instanceof FileNotFoundException) {
            return -28;
        }
        if (exc instanceof HttpRetryException) {
            return -29;
        }
        if (exc instanceof ConnectTimeoutException) {
            return -7;
        }
        if (exc instanceof SocketTimeoutException) {
            return -8;
        }
        if (exc instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (exc instanceof MalformedURLException) {
            return -3;
        }
        if (exc instanceof InvalidClassException) {
            return -33;
        }
        if (exc instanceof InvalidObjectException) {
            return -34;
        }
        if (exc instanceof NotActiveException) {
            return -35;
        }
        if (exc instanceof NotSerializableException) {
            return -36;
        }
        if (exc instanceof OptionalDataException) {
            return -37;
        }
        if (exc instanceof StreamCorruptedException) {
            return -38;
        }
        if (exc instanceof WriteAbortedException) {
            return -39;
        }
        if (exc instanceof ProtocolException) {
            return -40;
        }
        boolean z = exc instanceof SSLHandshakeException;
        if (z) {
            for (Exception exc2 = exc; exc2 != null; exc2 = exc2.getCause()) {
                APLog.d(TAG, "https exception" + exc2.toString());
                if (isTimeError(exc2)) {
                    return -55;
                }
                if (isWifiProxy(exc2)) {
                    return -56;
                }
                if (isSSLV3Error(exc2)) {
                    return -58;
                }
            }
            return -41;
        }
        if (exc instanceof SSLKeyException) {
            return -42;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (exc instanceof SSLProtocolException) {
            return -44;
        }
        if (exc instanceof BindException) {
            return -45;
        }
        if (exc instanceof ConnectException) {
            return -46;
        }
        if (exc instanceof NoRouteToHostException) {
            return -47;
        }
        if (exc instanceof PortUnreachableException) {
            return -48;
        }
        if (exc instanceof SyncFailedException) {
            return -49;
        }
        if (exc instanceof UTFDataFormatException) {
            return -50;
        }
        if (exc instanceof UnknownHostException) {
            return -51;
        }
        if (exc instanceof UnknownServiceException) {
            return -52;
        }
        if (exc instanceof UnsupportedEncodingException) {
            return -53;
        }
        if (exc instanceof ZipException) {
            return -54;
        }
        String exc3 = exc.toString();
        return (exc3 == null || !exc3.contains("Connection reset by peer")) ? -6 : -57;
    }

    public static int getResponseCodeForDataReport(Response response) {
        if (response.exception == null) {
            return response.resultCode;
        }
        Exception exc = response.exception;
        if (exc instanceof ConnectTimeoutException) {
            return NetErrConstants.ERROR_NETWORK_CONTIMEOUT;
        }
        if (exc instanceof SocketTimeoutException) {
            return NetErrConstants.ERROR_NETWORK_READTIMEOUT;
        }
        if (exc instanceof IOException) {
            return NetErrConstants.ERROR_NETWORK_IOEXCEPTION;
        }
        return 20000;
    }

    public static boolean isApkInDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isHttpUrl(String str) {
        boolean matches = Pattern.compile("(((https|http)?://)?([a-z0-9]+[.])|(www.))\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;一-龥]]+)+)?([.][a-z0-9]{0,}+|/?)".trim()).matcher(str.trim()).matches();
        if (matches) {
            return true;
        }
        return matches;
    }

    public static String getProcessName(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "unkown";
    }

    public static String getJsonValue(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(str2);
        } catch (JSONException e) {
            APLog.d(TAG, "setJsResource exception: " + e.getMessage());
            return "";
        }
    }
}
