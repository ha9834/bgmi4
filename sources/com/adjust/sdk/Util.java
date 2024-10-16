package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.LocaleList;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.adjust.sdk.GooglePlayServicesClient;
import com.adjust.sdk.scheduler.SingleThreadFutureScheduler;
import com.tencent.imsdk.android.IR;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class Util {
    private static final String fieldReadErrorMessage = "Unable to read '%s' field in migration device with message (%s)";
    public static final DecimalFormat SecondsDisplayFormat = newLocalDecimalFormat();
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z";
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.US);
    private static volatile SingleThreadFutureScheduler playAdIdScheduler = null;

    public static String getSdkVersion() {
        return Constants.CLIENT_SDK;
    }

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String createUuid() {
        return UUID.randomUUID().toString();
    }

    private static DecimalFormat newLocalDecimalFormat() {
        return new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.US));
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        return !Pattern.compile("\\s").matcher(str).find() ? str : formatString("'%s'", str);
    }

    public static Object getAdvertisingInfoObject(final Context context, long j) {
        return runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<Object>() { // from class: com.adjust.sdk.Util.1
            @Override // java.util.concurrent.Callable
            public Object call() {
                try {
                    return Reflection.getAdvertisingInfoObject(context);
                } catch (Exception unused) {
                    return null;
                }
            }
        }, j);
    }

    public static String getPlayAdId(final Context context, final Object obj, long j) {
        return (String) runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<String>() { // from class: com.adjust.sdk.Util.2
            @Override // java.util.concurrent.Callable
            public String call() {
                return Reflection.getPlayAdId(context, obj);
            }
        }, j);
    }

    public static Boolean isPlayTrackingEnabled(final Context context, final Object obj, long j) {
        return (Boolean) runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<Boolean>() { // from class: com.adjust.sdk.Util.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                return Reflection.isPlayTrackingEnabled(context, obj);
            }
        }, j);
    }

    private static <R> R runSyncInPlayAdIdSchedulerWithTimeout(Context context, Callable<R> callable, long j) {
        if (playAdIdScheduler == null) {
            synchronized (Util.class) {
                if (playAdIdScheduler == null) {
                    playAdIdScheduler = new SingleThreadFutureScheduler("PlayAdIdLibrary", true);
                }
            }
        }
        try {
            return (R) playAdIdScheduler.scheduleFutureWithReturn(callable, 0L).get(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.adjust.sdk.Util$4] */
    public static void runInBackground(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runnable.run();
        } else {
            new AsyncTask<Object, Void, Void>() { // from class: com.adjust.sdk.Util.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Object... objArr) {
                    ((Runnable) objArr[0]).run();
                    return null;
                }
            }.execute(runnable);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.adjust.sdk.Util$5] */
    public static void getGoogleAdId(Context context, final OnDeviceIdsRead onDeviceIdsRead) {
        ILogger logger = AdjustFactory.getLogger();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            logger.debug("GoogleAdId being read in the background", new Object[0]);
            String googleAdId = getGoogleAdId(context);
            logger.debug("GoogleAdId read " + googleAdId, new Object[0]);
            onDeviceIdsRead.onGoogleAdIdRead(googleAdId);
            return;
        }
        logger.debug("GoogleAdId being read in the foreground", new Object[0]);
        new AsyncTask<Context, Void, String>() { // from class: com.adjust.sdk.Util.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(Context... contextArr) {
                ILogger logger2 = AdjustFactory.getLogger();
                String googleAdId2 = Util.getGoogleAdId(contextArr[0]);
                logger2.debug("GoogleAdId read " + googleAdId2, new Object[0]);
                return googleAdId2;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(String str) {
                AdjustFactory.getLogger();
                OnDeviceIdsRead.this.onGoogleAdIdRead(str);
            }
        }.execute(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getGoogleAdId(Context context) {
        Object advertisingInfoObject;
        String str = null;
        try {
            GooglePlayServicesClient.GooglePlayServicesInfo googlePlayServicesInfo = GooglePlayServicesClient.getGooglePlayServicesInfo(context, 11000L);
            if (googlePlayServicesInfo != null) {
                str = googlePlayServicesInfo.getGpsAdid();
            }
        } catch (Exception unused) {
        }
        return (str != null || (advertisingInfoObject = getAdvertisingInfoObject(context, 11000L)) == null) ? str : getPlayAdId(context, advertisingInfoObject, 1000L);
    }

    public static String getMacAddress(Context context) {
        return MacAddressUtil.getMacAddress(context);
    }

    public static String getAndroidId(Context context) {
        return AndroidIdUtil.getAndroidId(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> T readObject(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.Class<T> r10) {
        /*
            r0 = 0
            r1 = 2
            r2 = 0
            r3 = 1
            java.io.FileInputStream r7 = r7.openFileInput(r8)     // Catch: java.lang.Exception -> L73 java.io.FileNotFoundException -> L85
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r8.<init>(r7)     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            java.io.ObjectInputStream r7 = new java.io.ObjectInputStream     // Catch: java.lang.Exception -> L6a java.io.FileNotFoundException -> L6f
            r7.<init>(r8)     // Catch: java.lang.Exception -> L6a java.io.FileNotFoundException -> L6f
            java.lang.Object r8 = r7.readObject()     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L40 java.lang.ClassNotFoundException -> L55 java.io.FileNotFoundException -> L86
            java.lang.Object r0 = r10.cast(r8)     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L40 java.lang.ClassNotFoundException -> L55 java.io.FileNotFoundException -> L86
            com.adjust.sdk.ILogger r8 = getLogger()     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L40 java.lang.ClassNotFoundException -> L55 java.io.FileNotFoundException -> L86
            java.lang.String r10 = "Read %s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L40 java.lang.ClassNotFoundException -> L55 java.io.FileNotFoundException -> L86
            r4[r2] = r9     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L40 java.lang.ClassNotFoundException -> L55 java.io.FileNotFoundException -> L86
            r4[r3] = r0     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L40 java.lang.ClassNotFoundException -> L55 java.io.FileNotFoundException -> L86
            r8.debug(r10, r4)     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L40 java.lang.ClassNotFoundException -> L55 java.io.FileNotFoundException -> L86
            goto L93
        L2b:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            java.lang.String r4 = "Failed to read %s object (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r5[r2] = r9     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r5[r3] = r8     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r10.error(r4, r5)     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            goto L93
        L40:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            java.lang.String r4 = "Failed to cast %s object (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r5[r2] = r9     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r5[r3] = r8     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r10.error(r4, r5)     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            goto L93
        L55:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            java.lang.String r4 = "Failed to find %s class (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r5[r2] = r9     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r5[r3] = r8     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            r10.error(r4, r5)     // Catch: java.lang.Exception -> L71 java.io.FileNotFoundException -> L86
            goto L93
        L6a:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L75
        L6f:
            r7 = r8
            goto L86
        L71:
            r8 = move-exception
            goto L75
        L73:
            r8 = move-exception
            r7 = r0
        L75:
            com.adjust.sdk.ILogger r10 = getLogger()
            java.lang.String r4 = "Failed to open %s file for reading (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r5[r2] = r9
            r5[r3] = r8
            r10.error(r4, r5)
            goto L93
        L85:
            r7 = r0
        L86:
            com.adjust.sdk.ILogger r8 = getLogger()
            java.lang.String r10 = "%s file not found"
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r2] = r9
            r8.debug(r10, r4)
        L93:
            if (r7 == 0) goto La9
            r7.close()     // Catch: java.lang.Exception -> L99
            goto La9
        L99:
            r7 = move-exception
            com.adjust.sdk.ILogger r8 = getLogger()
            java.lang.String r10 = "Failed to close %s file for reading (%s)"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r9
            r1[r3] = r7
            r8.error(r10, r1)
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.Util.readObject(android.content.Context, java.lang.String, java.lang.String, java.lang.Class):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.ObjectOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> void writeObject(T r5, android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            java.io.FileOutputStream r6 = r6.openFileOutput(r7, r2)     // Catch: java.lang.Exception -> L37
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> L35
            r7.<init>(r6)     // Catch: java.lang.Exception -> L35
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch: java.lang.Exception -> L32
            r6.<init>(r7)     // Catch: java.lang.Exception -> L32
            r6.writeObject(r5)     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            com.adjust.sdk.ILogger r7 = getLogger()     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            java.lang.String r3 = "Wrote %s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            r4[r2] = r8     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            r4[r1] = r5     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            r7.debug(r3, r4)     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            goto L48
        L24:
            com.adjust.sdk.ILogger r5 = getLogger()     // Catch: java.lang.Exception -> L35
            java.lang.String r7 = "Failed to serialize %s"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L35
            r3[r2] = r8     // Catch: java.lang.Exception -> L35
            r5.error(r7, r3)     // Catch: java.lang.Exception -> L35
            goto L48
        L32:
            r5 = move-exception
            r6 = r7
            goto L39
        L35:
            r5 = move-exception
            goto L39
        L37:
            r5 = move-exception
            r6 = 0
        L39:
            com.adjust.sdk.ILogger r7 = getLogger()
            java.lang.String r3 = "Failed to open %s for writing (%s)"
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r2] = r8
            r4[r1] = r5
            r7.error(r3, r4)
        L48:
            if (r6 == 0) goto L5e
            r6.close()     // Catch: java.lang.Exception -> L4e
            goto L5e
        L4e:
            r5 = move-exception
            com.adjust.sdk.ILogger r6 = getLogger()
            java.lang.String r7 = "Failed to close %s file for writing (%s)"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r8
            r0[r1] = r5
            r6.error(r7, r0)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.Util.writeObject(java.lang.Object, android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            getLogger().debug("Unable to check permission '%s' with message (%s)", str, e.getMessage());
            return false;
        }
    }

    public static String readStringField(ObjectInputStream.GetField getField, String str, String str2) {
        return (String) readObjectField(getField, str, str2);
    }

    public static <T> T readObjectField(ObjectInputStream.GetField getField, String str, T t) {
        try {
            return (T) getField.get(str, t);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return t;
        }
    }

    public static boolean readBooleanField(ObjectInputStream.GetField getField, String str, boolean z) {
        try {
            return getField.get(str, z);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return z;
        }
    }

    public static int readIntField(ObjectInputStream.GetField getField, String str, int i) {
        try {
            return getField.get(str, i);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return i;
        }
    }

    public static long readLongField(ObjectInputStream.GetField getField, String str, long j) {
        try {
            return getField.get(str, j);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return j;
        }
    }

    public static boolean equalObject(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return obj == null && obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean equalsDouble(Double d, Double d2) {
        return (d == null || d2 == null) ? d == null && d2 == null : Double.doubleToLongBits(d.doubleValue()) == Double.doubleToLongBits(d2.doubleValue());
    }

    public static boolean equalString(String str, String str2) {
        return equalObject(str, str2);
    }

    public static boolean equalEnum(Enum r0, Enum r1) {
        return equalObject(r0, r1);
    }

    public static boolean equalLong(Long l, Long l2) {
        return equalObject(l, l2);
    }

    public static boolean equalInt(Integer num, Integer num2) {
        return equalObject(num, num2);
    }

    public static boolean equalBoolean(Boolean bool, Boolean bool2) {
        return equalObject(bool, bool2);
    }

    public static int hashBoolean(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public static int hashLong(Long l) {
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public static int hashDouble(Double d) {
        if (d == null) {
            return 0;
        }
        return d.hashCode();
    }

    public static int hashString(String str) {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public static int hashEnum(Enum r0) {
        if (r0 == null) {
            return 0;
        }
        return r0.hashCode();
    }

    public static int hashObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static String sha1(String str) {
        return hash(str, Constants.SHA1);
    }

    public static String sha256(String str) {
        return hash(str, Constants.SHA256);
    }

    public static String md5(String str) {
        return hash(str, Constants.MD5);
    }

    public static String hash(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(bytes, 0, bytes.length);
            return convertToHex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String convertToHex(byte[] bArr) {
        return formatString("%0" + (bArr.length << 1) + "x", new BigInteger(1, bArr));
    }

    public static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return null;
    }

    public static String getCpuAbi() {
        if (Build.VERSION.SDK_INT < 21) {
            return Build.CPU_ABI;
        }
        return null;
    }

    public static String getReasonString(String str, Throwable th) {
        return th != null ? formatString("%s: %s", str, th) : formatString("%s", str);
    }

    public static long getWaitingTime(int i, BackoffStrategy backoffStrategy) {
        if (i < backoffStrategy.minRetries) {
            return 0L;
        }
        long min = Math.min(((long) Math.pow(2.0d, i - backoffStrategy.minRetries)) * backoffStrategy.milliSecondMultiplier, backoffStrategy.maxWait);
        double randomInRange = randomInRange(backoffStrategy.minRange, backoffStrategy.maxRange);
        double d = min;
        Double.isNaN(d);
        return (long) (d * randomInRange);
    }

    private static double randomInRange(double d, double d2) {
        return (new Random().nextDouble() * (d2 - d)) + d;
    }

    public static boolean isValidParameter(String str, String str2, String str3) {
        if (str == null) {
            getLogger().error("%s parameter %s is missing", str3, str2);
            return false;
        }
        if (!str.equals("")) {
            return true;
        }
        getLogger().error("%s parameter %s is empty", str3, str2);
        return false;
    }

    public static Map<String, String> mergeParameters(Map<String, String> map, Map<String, String> map2, String str) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        ILogger logger = getLogger();
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String str2 = (String) hashMap.put(entry.getKey(), entry.getValue());
            if (str2 != null) {
                logger.warn("Key %s with value %s from %s parameter was replaced by value %s", entry.getKey(), str2, str, entry.getValue());
            }
        }
        return hashMap;
    }

    public static Locale getLocale(Configuration configuration) {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24 && (locales = configuration.getLocales()) != null && !locales.isEmpty()) {
            return locales.get(0);
        }
        if (Build.VERSION.SDK_INT < 24) {
            return configuration.locale;
        }
        return null;
    }

    public static String getFireAdvertisingId(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Boolean getFireTrackingEnabled(ContentResolver contentResolver) {
        try {
            return Boolean.valueOf(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getConnectivityType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            getLogger().warn("Couldn't read connectivity type (%s)", e.getMessage());
        }
        if (connectivityManager == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return connectivityManager.getActiveNetworkInfo().getType();
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return -1;
        }
        if (networkCapabilities.hasTransport(1)) {
            return 1;
        }
        if (networkCapabilities.hasTransport(0)) {
            return 0;
        }
        if (networkCapabilities.hasTransport(3)) {
            return 3;
        }
        if (networkCapabilities.hasTransport(4)) {
            return 4;
        }
        if (networkCapabilities.hasTransport(2)) {
            return 2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return -1;
        }
        if (networkCapabilities.hasTransport(5)) {
            return 5;
        }
        return (Build.VERSION.SDK_INT >= 27 && networkCapabilities.hasTransport(6)) ? 6 : -1;
    }

    public static int getNetworkType(Context context) {
        int networkType;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 30) {
                networkType = telephonyManager.getDataNetworkType();
            } else {
                networkType = telephonyManager.getNetworkType();
            }
            return networkType;
        } catch (Exception e) {
            getLogger().warn("Couldn't read network type (%s)", e.getMessage());
            return -1;
        }
    }

    public static String getMcc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator)) {
                AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MCC", new Object[0]);
                return null;
            }
            return networkOperator.substring(0, 3);
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mcc", new Object[0]);
            return null;
        }
    }

    public static String getMnc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator)) {
                AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MNC", new Object[0]);
                return null;
            }
            return networkOperator.substring(3);
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mnc", new Object[0]);
            return null;
        }
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean hasRootCause(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().contains("Caused by:");
    }

    public static String getRootCause(Exception exc) {
        if (!hasRootCause(exc)) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int indexOf = stringWriter2.indexOf("Caused by:");
        return stringWriter2.substring(indexOf, stringWriter2.indexOf("\n", indexOf));
    }

    private static String getSdkPrefix(String str) {
        String[] split;
        if (str != null && str.contains(IR.account.EMAIL_TAG) && (split = str.split(IR.account.EMAIL_TAG)) != null && split.length == 2) {
            return split[0];
        }
        return null;
    }

    public static String getSdkPrefixPlatform(String str) {
        String[] split;
        String sdkPrefix = getSdkPrefix(str);
        if (sdkPrefix == null || (split = sdkPrefix.split("\\d+", 2)) == null || split.length == 0) {
            return null;
        }
        return split[0];
    }

    public static boolean isUrlFilteredOut(Uri uri) {
        String uri2;
        return uri == null || (uri2 = uri.toString()) == null || uri2.length() == 0 || uri2.matches(Constants.FB_AUTH_REGEX);
    }

    public static boolean resolveContentProvider(Context context, String str) {
        try {
            return context.getPackageManager().resolveContentProvider(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isEqualReferrerDetails(ReferrerDetails referrerDetails, String str, ActivityState activityState) {
        if (str.equals(Constants.REFERRER_API_GOOGLE)) {
            return isEqualGoogleReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_HUAWEI)) {
            return isEqualHuaweiReferrerDetails(referrerDetails, activityState);
        }
        return false;
    }

    private static boolean isEqualGoogleReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTime && referrerDetails.installBeginTimestampSeconds == activityState.installBegin && referrerDetails.referrerClickTimestampServerSeconds == activityState.clickTimeServer && referrerDetails.installBeginTimestampServerSeconds == activityState.installBeginServer && equalString(referrerDetails.installReferrer, activityState.installReferrer) && equalString(referrerDetails.installVersion, activityState.installVersion) && equalBoolean(referrerDetails.googlePlayInstant, activityState.googlePlayInstant);
    }

    private static boolean isEqualHuaweiReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeHuawei && referrerDetails.installBeginTimestampSeconds == activityState.installBeginHuawei && equalString(referrerDetails.installReferrer, activityState.installReferrerHuawei);
    }
}
