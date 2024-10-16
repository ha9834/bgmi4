package com.tencent.mid.util;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.connect.common.Constants;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.api.MidProvider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Util {

    /* renamed from: a, reason: collision with root package name */
    private static d f6268a;
    private static Random b;
    public static int errorCount;
    public static long lastGetOtherMidMapTime;
    public static Map<String, MidEntity> lastOtherMidMap;

    public static synchronized d getLogger() {
        d dVar;
        synchronized (Util.class) {
            if (f6268a == null) {
                f6268a = new d("MID");
            }
            dVar = f6268a;
        }
        return dVar;
    }

    public static boolean isStringValid(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static boolean isMidValid(MidEntity midEntity) {
        return midEntity != null && isMidValid(midEntity.getMid());
    }

    public static boolean isMidValid(String str) {
        return str != null && str.trim().length() >= 40;
    }

    public static MidEntity getNewerMidEntity(MidEntity midEntity, MidEntity midEntity2) {
        if (midEntity != null && midEntity2 != null) {
            return midEntity.compairTo(midEntity2) >= 0 ? midEntity : midEntity2;
        }
        if (midEntity != null) {
            return midEntity;
        }
        if (midEntity2 != null) {
            return midEntity2;
        }
        return null;
    }

    public static boolean equal(MidEntity midEntity, MidEntity midEntity2) {
        return (midEntity == null || midEntity2 == null) ? midEntity == null && midEntity2 == null : midEntity.compairTo(midEntity2) == 0;
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            Log.e("MID", "checkPermission error", th);
            return false;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
        } catch (Throwable th) {
            Log.e("MID", "isNetworkAvailable error", th);
        }
        if (!checkPermission(context, "android.permission.INTERNET")) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.isConnectedOrConnecting()) {
                return true;
            }
            Log.w("MID", "Network error is not exist");
            return false;
        }
        errorCount++;
        int i = errorCount;
        if (i <= 5) {
            return true;
        }
        if (i >= 10 && i >= 10) {
            errorCount = 0;
        }
        return false;
    }

    public static String md5sum(String str) {
        return md5(str);
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                stringBuffer.append((int) b2);
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static void jsonPut(JSONObject jSONObject, String str, String str2) {
        if (isStringValid(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(e.b(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            Log.e("MID", "decode error", th);
            return str;
        }
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(e.a(str.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            Log.e("MID", "encode error", th);
            return str;
        }
    }

    public static HttpHost getHttpProxy() {
        if (Proxy.getDefaultHost() != null) {
            return new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort());
        }
        return null;
    }

    public static HttpHost getHttpProxy(Context context) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (context == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            f6268a.f(th);
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0 || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return null;
        }
        if ((activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) || (extraInfo = activeNetworkInfo.getExtraInfo()) == null) {
            return null;
        }
        if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap")) {
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            return null;
        }
        return new HttpHost("10.0.0.172", 80);
    }

    public static byte[] deocdeGZipContent(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static String getHttpAddr(Context context) {
        return "http://" + b.a(context).c();
    }

    public static byte[] getHMAC(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "hmacmd5");
            Mac mac = Mac.getInstance(com.amazonaws.services.s3.internal.Constants.HMAC_SHA1_ALGORITHM);
            mac.init(secretKeySpec);
            mac.update(str2.getBytes());
            return mac.doFinal();
        } catch (Exception e) {
            f6268a.b(e);
            return null;
        }
    }

    private static synchronized Random a() {
        Random random;
        synchronized (Util.class) {
            if (b == null) {
                b = new Random();
            }
            random = b;
        }
        return random;
    }

    public static int getRandInt() {
        return a().nextInt(Integer.MAX_VALUE);
    }

    public static String bytesToStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(((int) b2) + "");
        }
        return stringBuffer.toString();
    }

    public static byte[] strToBytes(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static JSONArray queryMids(Context context, int i) {
        MidEntity j;
        MidEntity k;
        f6268a.h("queryMids, midType=" + i);
        JSONArray jSONArray = new JSONArray();
        Map<String, MidEntity> midsByApps = getMidsByApps(context, i == 2 ? 3 : 2);
        if (midsByApps != null && midsByApps.size() > 0) {
            for (Map.Entry<String, MidEntity> entry : midsByApps.entrySet()) {
                String key = entry.getKey();
                MidEntity value = entry.getValue();
                if (value != null && value.isMidValid()) {
                    try {
                        JSONObject a2 = a(value);
                        a2.put("loc", "priv");
                        if (key.equals(context.getPackageName())) {
                            a2.put(Constants.JumpUrlConstants.SRC_TYPE_APP, 1);
                        }
                        a2.put("pkg", key);
                        jSONArray.put(a2);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (i == 2) {
            j = com.tencent.mid.b.g.a(context).d();
        } else {
            j = com.tencent.mid.b.g.a(context).j();
        }
        f6268a.b("settingEntity:" + j);
        if (j != null && j.isMidValid()) {
            try {
                JSONObject a3 = a(j);
                a3.put("loc", "pub");
                a3.put("lc", "set");
                jSONArray.put(a3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) {
            k = com.tencent.mid.b.g.a(context).e();
        } else {
            k = com.tencent.mid.b.g.a(context).k();
        }
        f6268a.b("sdCardEntity:" + k);
        if (k != null && k.isMidValid()) {
            try {
                JSONObject a4 = a(k);
                a4.put("loc", "pub");
                a4.put("lc", "sd");
                jSONArray.put(a4);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray;
    }

    private static JSONObject a(MidEntity midEntity) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mid", midEntity.getMid());
        jSONObject.put("ts", midEntity.getTimestamps() / 1000);
        return jSONObject;
    }

    public static String getPackageAuth(String str) {
        return "content://" + getPackageAuthName(str);
    }

    public static String getPackageAuthName(String str) {
        return str + MidConstants.PROVIDER_AUTH_SUFFIX;
    }

    public static Map<String, MidEntity> getMidsByApps(Context context, int i) {
        a aVar = new a(context, i);
        Thread thread = new Thread(aVar);
        thread.start();
        try {
            thread.join(3500L);
        } catch (Throwable th) {
            f6268a.d(th.toString());
        }
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f6269a;
        private Context b;
        private Map<String, MidEntity> c;

        public a(Context context, int i) {
            this.f6269a = i;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a(Util.b(this.b, this.f6269a));
            } catch (Exception unused) {
            }
        }

        public synchronized void a(Map<String, MidEntity> map) {
            this.c = map;
        }

        public synchronized Map<String, MidEntity> a() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, MidEntity> b(Context context, int i) {
        MidEntity parse;
        HashMap hashMap = new HashMap(4);
        Map<String, ProviderInfo> queryMatchContentProviders = queryMatchContentProviders(context);
        StringBuilder sb = new StringBuilder();
        sb.append(">>>   queryMatchContentProviders size:");
        sb.append(queryMatchContentProviders != null ? queryMatchContentProviders.size() : 0);
        Log.i("MID", sb.toString());
        MidEntity midEntity = null;
        if (i == 2) {
            midEntity = com.tencent.mid.b.g.a(context).i();
        } else if (i == 3) {
            midEntity = com.tencent.mid.b.g.a(context).c();
        }
        if (isMidValid(midEntity)) {
            hashMap.put(context.getPackageName(), midEntity);
        }
        if (queryMatchContentProviders == null || queryMatchContentProviders.size() == 0) {
            return hashMap;
        }
        Map<String, MidEntity> map = lastOtherMidMap;
        if (map != null && !map.isEmpty() && Math.abs(System.currentTimeMillis() - lastGetOtherMidMapTime) < 1000) {
            Log.d("MID", ">>> use lastOtherMidMap size:" + lastOtherMidMap.size() + ",content:");
            return lastOtherMidMap;
        }
        for (String str : queryMatchContentProviders.keySet()) {
            try {
                if (!str.equals(context.getPackageName())) {
                    String str2 = getPackageAuth(str) + "/" + i;
                    Log.d("MID", ">>>   read mid from other providrt cmd:" + str2);
                    String type = context.getContentResolver().getType(Uri.parse(str2));
                    Log.d("MID", ">>>   mid cmd:" + str2 + ", return:" + type);
                    if (!isEmpty(type) && (parse = MidEntity.parse(type)) != null && parse.isMidValid()) {
                        hashMap.put(str, parse);
                    }
                }
            } catch (Throwable th) {
                f6268a.f(th);
            }
        }
        lastOtherMidMap = hashMap;
        lastGetOtherMidMapTime = System.currentTimeMillis();
        Log.d("MID", ">>>   appPrivateMidMap size:" + hashMap.size() + ",content:");
        for (Map.Entry entry : hashMap.entrySet()) {
            Log.w("MID", ">>>   pkg:" + ((String) entry.getKey()) + ",midEntity:" + ((MidEntity) entry.getValue()).toString());
        }
        return hashMap;
    }

    public static void insertMid2Provider(Context context, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            context.getContentResolver().insert(Uri.parse(getPackageAuth(str) + "/10"), contentValues);
        } catch (Throwable unused) {
        }
    }

    public static void insertMid2OldProvider(Context context, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            context.getContentResolver().insert(Uri.parse(getPackageAuth(str) + "/11"), contentValues);
        } catch (Throwable unused) {
        }
    }

    public static Map<String, ProviderInfo> queryMatchContentProviders(Context context) {
        HashMap hashMap = new HashMap();
        for (ProviderInfo providerInfo : context.getPackageManager().queryContentProviders((String) null, 0, 0)) {
            if (providerInfo.name.equals(MidProvider.class.getName()) && providerInfo.authority.equals(getPackageAuthName(providerInfo.packageName))) {
                hashMap.put(providerInfo.packageName, providerInfo);
            }
        }
        return hashMap;
    }

    public static void updateIfLocalInvalid(Context context, String str) {
        if (isMidValid(str)) {
            MidEntity midEntity = new MidEntity();
            midEntity.setImei(CustomDeviceInfos.getDeviceId(context));
            midEntity.setMac(CustomDeviceInfos.getMacAddress(context));
            midEntity.setMid(str);
            midEntity.setTimestamps(System.currentTimeMillis());
            com.tencent.mid.b.g.a(context).f(midEntity);
        }
    }

    public static String getDateString(int i) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.roll(6, i);
            return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
        } catch (Throwable unused) {
            return "00";
        }
    }

    public static Map<String, ProviderInfo> getLocalXGAppList(Context context) {
        HashMap hashMap = new HashMap();
        for (ProviderInfo providerInfo : context.getPackageManager().queryContentProviders((String) null, 0, 0)) {
            if (providerInfo.name.equals("com.tencent.android.tpush.XGPushProvider") && providerInfo.authority.equals(getProviderAuth(providerInfo.packageName))) {
                hashMap.put(providerInfo.packageName, providerInfo);
                Log.d("MID.XG", providerInfo.authority + "," + providerInfo.packageName + "," + providerInfo.name);
            }
        }
        return hashMap;
    }

    public static String getProviderAuth(String str) {
        return str + ".AUTH_XGPUSH";
    }

    public static String getToken(Context context, String str) {
        String type = context.getContentResolver().getType(Uri.parse("content://" + str + ".AUTH_XGPUSH/tokenByMid"));
        if (type != null) {
            try {
                type = new String(Base64.decode(type.getBytes(), 0), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        Log.i("MID.XG", "get token from pkg:" + str + ", token:" + type);
        if (type == null || type.trim().length() != 40) {
            return null;
        }
        return type;
    }

    public static Map<String, Integer> queryAllToken(Context context) {
        Map<String, ProviderInfo> localXGAppList = getLocalXGAppList(context);
        HashMap hashMap = new HashMap();
        if (localXGAppList == null || localXGAppList.size() == 0) {
            return hashMap;
        }
        Iterator<String> it = localXGAppList.keySet().iterator();
        while (it.hasNext()) {
            String token = getToken(context, it.next());
            if (isMidValid(token)) {
                Integer num = (Integer) hashMap.get(token);
                if (num == null) {
                    hashMap.put(token, 1);
                } else {
                    hashMap.put(token, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
        return hashMap;
    }

    public static String selectMaxCountXgAppToken(Context context) {
        Map<String, Integer> queryAllToken = queryAllToken(context);
        String str = null;
        if (queryAllToken == null || queryAllToken.size() <= 0) {
            return null;
        }
        int i = 0;
        for (Map.Entry<String, Integer> entry : queryAllToken.entrySet()) {
            if (entry.getValue().intValue() > i) {
                int intValue = entry.getValue().intValue();
                i = intValue;
                str = entry.getKey();
            }
        }
        return str;
    }
}
