package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.nearby.messages.BleSignal;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.helpshift.analytics.AnalyticsEventKey;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.jvm.internal.h;
import kotlin.text.Regex;
import kotlin.text.d;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    public static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static int numCPUCores;
    public static final Utility INSTANCE = new Utility();
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;
    private static long availableExternalStorageGB = -1;
    private static String deviceTimezoneAbbreviation = "";
    private static String deviceTimeZoneName = "";
    private static final String NO_CARRIER = "NoCarrier";
    private static String carrierName = NO_CARRIER;

    /* loaded from: classes.dex */
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    /* loaded from: classes.dex */
    public interface Mapper<T, K> {
        K apply(T t);
    }

    /* loaded from: classes.dex */
    public interface Predicate<T> {
        boolean apply(T t);
    }

    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }

    private Utility() {
    }

    public static final int[] intersectRanges(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null) {
            return iArr;
        }
        int[] iArr3 = new int[iArr.length + iArr2.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i >= iArr.length || i2 >= iArr2.length) {
                break;
            }
            int i4 = iArr[i];
            int i5 = iArr2[i2];
            int i6 = i < iArr.length + (-1) ? iArr[i + 1] : Integer.MAX_VALUE;
            int i7 = i2 < iArr2.length + (-1) ? iArr2[i2 + 1] : Integer.MAX_VALUE;
            if (i4 < i5) {
                if (i6 <= i5) {
                    i += 2;
                    i4 = BleSignal.UNKNOWN_TX_POWER;
                    i6 = Integer.MAX_VALUE;
                } else if (i6 > i7) {
                    i2 += 2;
                    i4 = i5;
                    i6 = i7;
                } else {
                    i += 2;
                    i4 = i5;
                }
            } else if (i7 <= i4) {
                i2 += 2;
                i4 = BleSignal.UNKNOWN_TX_POWER;
                i6 = Integer.MAX_VALUE;
            } else if (i7 > i6) {
                i += 2;
            } else {
                i2 += 2;
                i6 = i7;
            }
            if (i4 != Integer.MIN_VALUE) {
                int i8 = i3 + 1;
                iArr3[i3] = i4;
                if (i6 == Integer.MAX_VALUE) {
                    i3 = i8;
                    break;
                }
                i3 = i8 + 1;
                iArr3[i8] = i6;
            }
        }
        return Arrays.copyOf(iArr3, i3);
    }

    public static final <T> boolean isSubset(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection2 == null || collection2.isEmpty()) {
            return collection == null || collection.isEmpty();
        }
        HashSet hashSet = new HashSet(collection2);
        if (collection != null) {
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final <T> boolean isNullOrEmpty(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final boolean isNullOrEmpty(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    public static final String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    public static final <T> Collection<T> unmodifiableCollection(T... tArr) {
        h.b(tArr, "ts");
        Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(Arrays.asList(Arrays.copyOf(tArr, tArr.length)));
        h.a((Object) unmodifiableCollection, "Collections.unmodifiable…ction(Arrays.asList(*ts))");
        return unmodifiableCollection;
    }

    public static final <T> ArrayList<T> arrayList(T... tArr) {
        h.b(tArr, "ts");
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public static final <T> HashSet<T> hashSet(T... tArr) {
        h.b(tArr, "ts");
        HashSet<T> hashSet = new HashSet<>(tArr.length);
        for (T t : tArr) {
            hashSet.add(t);
        }
        return hashSet;
    }

    public static final String md5hash(String str) {
        h.b(str, "key");
        return INSTANCE.hashWithAlgorithm("MD5", str);
    }

    public static final String sha1hash(String str) {
        h.b(str, "key");
        return INSTANCE.hashWithAlgorithm("SHA-1", str);
    }

    public static final String sha1hash(byte[] bArr) {
        h.b(bArr, "bytes");
        return INSTANCE.hashWithAlgorithm("SHA-1", bArr);
    }

    public static final String sha256hash(String str) {
        if (str == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", str);
    }

    public static final String sha256hash(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", bArr);
    }

    private final String hashWithAlgorithm(String str, String str2) {
        Charset charset = d.f6980a;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str2.getBytes(charset);
        h.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return hashWithAlgorithm(str, bytes);
    }

    private final String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            h.a((Object) messageDigest, "hash");
            return hashBytes(messageDigest, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private final String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString((b >> 0) & 15));
        }
        String sb2 = sb.toString();
        h.a((Object) sb2, "builder.toString()");
        return sb2;
    }

    public static final Uri buildUri(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        h.a((Object) build, "builder.build()");
        return build;
    }

    public static final Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Object[] array = l.a((CharSequence) str, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                for (String str2 : (String[]) array) {
                    Object[] array2 = l.a((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr = (String[]) array2;
                        try {
                            if (strArr.length == 2) {
                                bundle.putString(URLDecoder.decode(strArr[0], "UTF-8"), URLDecoder.decode(strArr[1], "UTF-8"));
                            } else if (strArr.length == 1) {
                                bundle.putString(URLDecoder.decode(strArr[0], "UTF-8"), "");
                            }
                        } catch (UnsupportedEncodingException e) {
                            logd(LOG_TAG, e);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return bundle;
    }

    public static final void putNonEmptyString(Bundle bundle, String str, String str2) {
        h.b(bundle, "b");
        if (isNullOrEmpty(str2)) {
            return;
        }
        bundle.putString(str, str2);
    }

    public static final void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        h.b(bundle, "b");
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            bundle.putString(str, sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
        }
    }

    public static final void putUri(Bundle bundle, String str, Uri uri) {
        h.b(bundle, "b");
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    public static final boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        h.b(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        }
        if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        }
        if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        }
        if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        }
        if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        }
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        }
        if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
            return true;
        }
        if (!(obj instanceof JSONObject)) {
            return false;
        }
        bundle.putString(str, obj.toString());
        return true;
    }

    public static final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    public static final String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        String applicationId = FacebookSdk.getApplicationId();
        h.a((Object) applicationId, "FacebookSdk.getApplicationId()");
        return applicationId;
    }

    public static final Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        h.b(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        int length = names.length();
        for (int i = 0; i < length; i++) {
            try {
                String string = names.getString(i);
                h.a((Object) string, "keys.getString(i)");
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = convertJSONObjectToHashMap((JSONObject) obj);
                }
                h.a(obj, "value");
                hashMap.put(string, obj);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    public static final Map<String, String> convertJSONObjectToStringMap(JSONObject jSONObject) {
        h.b(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                h.a((Object) next, "key");
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    public static final List<String> convertJSONArrayToList(JSONArray jSONArray) {
        h.b(jSONArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                h.a((Object) string, "jsonArray.getString(i)");
                arrayList.add(string);
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) throws JSONException {
        h.b(jSONObject, "jsonObject");
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String readStreamToString(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream2 = (BufferedInputStream) null;
        InputStreamReader inputStreamReader2 = (InputStreamReader) null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
        }
        try {
            inputStreamReader = new InputStreamReader(bufferedInputStream);
            try {
                StringBuilder sb = new StringBuilder();
                char[] cArr = new char[ProgressEvent.PART_COMPLETED_EVENT_CODE];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                    } else {
                        String sb2 = sb.toString();
                        h.a((Object) sb2, "stringBuilder.toString()");
                        closeQuietly(bufferedInputStream);
                        closeQuietly(inputStreamReader);
                        return sb2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            inputStreamReader = inputStreamReader2;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final int copyAndCloseInputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        h.b(outputStream, "outputStream");
        BufferedInputStream bufferedInputStream2 = (BufferedInputStream) null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    i += read;
                }
                bufferedInputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i;
            } catch (Throwable th) {
                th = th;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
        }
    }

    public static final boolean stringsEqualOrEmpty(String str, String str2) {
        String str3 = str;
        boolean z = str3 == null || str3.length() == 0;
        String str4 = str2;
        boolean z2 = str4 == null || str4.length() == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return h.a((Object) str, (Object) str2);
    }

    private final void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie != null) {
            Object[] array = l.a((CharSequence) cookie, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                for (String str2 : (String[]) array) {
                    Object[] array2 = l.a((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr = (String[]) array2;
                        if (strArr.length > 0) {
                            StringBuilder sb = new StringBuilder();
                            String str3 = strArr[0];
                            int length = str3.length() - 1;
                            int i = 0;
                            boolean z = false;
                            while (i <= length) {
                                boolean z2 = h.a(str3.charAt(!z ? i : length), 32) <= 0;
                                if (z) {
                                    if (!z2) {
                                        break;
                                    } else {
                                        length--;
                                    }
                                } else if (z2) {
                                    i++;
                                } else {
                                    z = true;
                                }
                            }
                            sb.append(str3.subSequence(i, length + 1).toString());
                            sb.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                            cookieManager.setCookie(str, sb.toString());
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                cookieManager.removeExpiredCookie();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public static final void clearFacebookCookies(Context context) {
        h.b(context, "context");
        INSTANCE.clearCookiesForDomain(context, "facebook.com");
        INSTANCE.clearCookiesForDomain(context, ".facebook.com");
        INSTANCE.clearCookiesForDomain(context, "https://facebook.com");
        INSTANCE.clearCookiesForDomain(context, "https://.facebook.com");
    }

    public static final void logd(String str, Exception exc) {
        if (!FacebookSdk.isDebugEnabled() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
    }

    public static final void logd(String str, String str2) {
        if (!FacebookSdk.isDebugEnabled() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    public static final void logd(String str, String str2, Throwable th) {
        if (!FacebookSdk.isDebugEnabled() || isNullOrEmpty(str)) {
            return;
        }
        Log.d(str, str2, th);
    }

    public static final <T> boolean areObjectsEqual(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return h.a(t, t2);
    }

    public static final boolean hasSameId(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || !jSONObject.has("id") || !jSONObject2.has("id")) {
            return false;
        }
        if (h.a(jSONObject, jSONObject2)) {
            return true;
        }
        String optString = jSONObject.optString("id");
        String optString2 = jSONObject2.optString("id");
        if (optString == null || optString2 == null) {
            return false;
        }
        return h.a((Object) optString, (Object) optString2);
    }

    public static final String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        String optString = jSONObject.optString(str, "");
        h.a((Object) optString, "response.optString(propertyName, \"\")");
        return optString;
    }

    public static final JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public static final JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    public static final void clearCaches() {
        ImageDownloader.clearCache();
    }

    public static final void deleteDirectory(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                deleteDirectory(file2);
            }
        }
        file.delete();
    }

    public static final <T> List<T> asListNoNulls(T... tArr) {
        h.b(tArr, "array");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final List<String> jsonArrayToStringList(JSONArray jSONArray) throws JSONException {
        h.b(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static final Set<String> jsonArrayToSet(JSONArray jSONArray) throws JSONException {
        h.b(jSONArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            h.a((Object) string, "jsonArray.getString(i)");
            hashSet.add(string);
        }
        return hashSet;
    }

    public static final String mapToJsonStr(Map<String, String> map) {
        String str;
        h.b(map, "map");
        if (map.isEmpty()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = "";
        }
        h.a((Object) str, "try {\n        val jsonOb…ion) {\n        \"\"\n      }");
        return str;
    }

    public static final Map<String, String> jsonStrToMap(String str) {
        h.b(str, AnalyticsEventKey.STR);
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                h.a((Object) next, "key");
                String string = jSONObject.getString(next);
                h.a((Object) string, "jsonObject.getString(key)");
                hashMap.put(next, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static final void setAppEventAttributionParameters(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) throws JSONException {
        h.b(jSONObject, NativeProtocol.WEB_DIALOG_PARAMS);
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", !z);
        jSONObject.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (attributionIdentifiers.getAttributionId() != null) {
                jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                jSONObject.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
            }
            if (!attributionIdentifiers.isTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                h.a((Object) allHashedUserData, "userData");
                if (!(allHashedUserData.length() == 0)) {
                    jSONObject.put("ud", allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                jSONObject.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    public static final String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static final void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context context) throws JSONException {
        Locale locale;
        int i;
        Object systemService;
        PackageInfo packageInfo;
        h.b(jSONObject, NativeProtocol.WEB_DIALOG_PARAMS);
        h.b(context, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        String str = "";
        int i2 = 0;
        int i3 = -1;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo != null) {
            i3 = packageInfo.versionCode;
            str = packageInfo.versionName;
            jSONArray.put(packageName);
            jSONArray.put(i3);
            jSONArray.put(str);
            jSONArray.put(Build.VERSION.RELEASE);
            jSONArray.put(Build.MODEL);
            try {
                Resources resources = context.getResources();
                h.a((Object) resources, "appContext.resources");
                locale = resources.getConfiguration().locale;
            } catch (Exception unused2) {
                locale = Locale.getDefault();
            }
            StringBuilder sb = new StringBuilder();
            h.a((Object) locale, "locale");
            sb.append(locale.getLanguage());
            sb.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            sb.append(locale.getCountry());
            jSONArray.put(sb.toString());
            jSONArray.put(deviceTimezoneAbbreviation);
            jSONArray.put(carrierName);
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            try {
                systemService = context.getSystemService("window");
            } catch (Exception unused3) {
            }
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
            WindowManager windowManager = (WindowManager) systemService;
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                int i4 = displayMetrics.widthPixels;
                try {
                    int i5 = displayMetrics.heightPixels;
                    try {
                        d = displayMetrics.density;
                        i2 = i4;
                        i = i5;
                    } catch (Exception unused4) {
                        i2 = i4;
                        i = i5;
                    }
                } catch (Exception unused5) {
                    i2 = i4;
                    i = 0;
                    jSONArray.put(i2);
                    jSONArray.put(i);
                    jSONArray.put(new DecimalFormat("#.##").format(d));
                    jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
                    jSONArray.put(totalExternalStorageGB);
                    jSONArray.put(availableExternalStorageGB);
                    jSONArray.put(deviceTimeZoneName);
                    jSONObject.put(Constants.EXTINFO, jSONArray.toString());
                }
            } else {
                i = 0;
            }
            jSONArray.put(i2);
            jSONArray.put(i);
            jSONArray.put(new DecimalFormat("#.##").format(d));
            jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
            jSONArray.put(totalExternalStorageGB);
            jSONArray.put(availableExternalStorageGB);
            jSONArray.put(deviceTimeZoneName);
            jSONObject.put(Constants.EXTINFO, jSONArray.toString());
        }
    }

    public static final Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        h.b(cls, "clazz");
        h.b(str, "methodName");
        h.b(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        h.b(str, "className");
        h.b(str2, "methodName");
        h.b(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            h.a((Object) cls, "Class.forName(className)");
            return getMethodQuietly(cls, str2, (Class<?>[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        h.b(method, FirebaseAnalytics.Param.METHOD);
        h.b(objArr, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final String getActivityName(Context context) {
        if (context == null) {
            return com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID;
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        h.a((Object) simpleName, "context.javaClass.simpleName");
        return simpleName;
    }

    public static final <T> List<T> filter(List<? extends T> list, Predicate<T> predicate) {
        h.b(predicate, "predicate");
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (predicate.apply(t)) {
                arrayList.add(t);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public static final <T, K> List<K> map(List<? extends T> list, Mapper<T, K> mapper) {
        h.b(mapper, "mapper");
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = list.iterator();
        while (it.hasNext()) {
            K apply = mapper.apply(it.next());
            if (apply != null) {
                arrayList.add(apply);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public static final String getUriString(Uri uri) {
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    public static final boolean isWebUri(Uri uri) {
        return uri != null && (l.a("http", uri.getScheme(), true) || l.a("https", uri.getScheme(), true) || l.a("fbstaging", uri.getScheme(), true));
    }

    public static final boolean isContentUri(Uri uri) {
        return uri != null && l.a(FirebaseAnalytics.Param.CONTENT, uri.getScheme(), true);
    }

    public static final boolean isFileUri(Uri uri) {
        return uri != null && l.a(TransferTable.COLUMN_FILE, uri.getScheme(), true);
    }

    public static final long getContentSize(Uri uri) {
        h.b(uri, "contentUri");
        Cursor cursor = (Cursor) null;
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            h.a((Object) applicationContext, "FacebookSdk.getApplicationContext()");
            cursor = applicationContext.getContentResolver().query(uri, null, null, null, null);
            if (cursor == null) {
                return 0L;
            }
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            long j = cursor.getLong(columnIndex);
            cursor.close();
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static final Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long parseLong;
        h.b(date, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            parseLong = ((Number) obj).longValue();
        } else {
            if (!(obj instanceof String)) {
                return null;
            }
            try {
                parseLong = Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (parseLong == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (parseLong * 1000));
    }

    public static final void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        h.b(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    public static final Map<String, String> readStringMapFromParcel(Parcel parcel) {
        h.b(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    public static final boolean isCurrentAccessToken(AccessToken accessToken) {
        return accessToken != null && h.a(accessToken, AccessToken.getCurrentAccessToken());
    }

    public static final void getGraphMeRequestWithCacheAsync(final String str, final GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        h.b(str, SDKConstants.PARAM_ACCESS_TOKEN);
        h.b(graphMeRequestWithCacheCallback, "callback");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            return;
        }
        GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.internal.Utility$getGraphMeRequestWithCacheAsync$graphCallback$1
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                h.a((Object) graphResponse, AnalyticsEventKey.RESPONSE);
                if (graphResponse.getError() != null) {
                    Utility.GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback2 = Utility.GraphMeRequestWithCacheCallback.this;
                    FacebookRequestError error = graphResponse.getError();
                    h.a((Object) error, "response.error");
                    graphMeRequestWithCacheCallback2.onFailure(error.getException());
                    return;
                }
                String str2 = str;
                JSONObject jSONObject = graphResponse.getJSONObject();
                h.a((Object) jSONObject, "response.jsonObject");
                ProfileInformationCache.putProfileInformation(str2, jSONObject);
                Utility.GraphMeRequestWithCacheCallback.this.onSuccess(graphResponse.getJSONObject());
            }
        };
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(callback);
        graphMeRequestWithCache.executeAsync();
    }

    public static final JSONObject awaitGetGraphMeRequestWithCache(String str) {
        h.b(str, SDKConstants.PARAM_ACCESS_TOKEN);
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = INSTANCE.getGraphMeRequestWithCache(str).executeAndWait();
        h.a((Object) executeAndWait, AnalyticsEventKey.RESPONSE);
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJSONObject();
    }

    private final GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,first_name,middle_name,last_name");
        bundle.putString("access_token", str);
        return new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i = numCPUCores;
        if (i > 0) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.internal.Utility$refreshBestGuessNumberOfCPUCores$cpuFiles$1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    return Pattern.matches("cpu[0-9]+", str);
                }
            });
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            h.a((Object) displayName, "tz.getDisplayName(tz.inD…(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            h.a((Object) timeZone, "tz");
            String id = timeZone.getID();
            h.a((Object) id, "tz.id");
            deviceTimeZoneName = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshCarrierName(Context context) {
        if (h.a((Object) carrierName, (Object) NO_CARRIER)) {
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                }
                String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                h.a((Object) networkOperatorName, "telephonyManager.networkOperatorName");
                carrierName = networkOperatorName;
            } catch (Exception unused) {
            }
        }
    }

    private final boolean externalStorageExists() {
        return h.a((Object) "mounted", (Object) Environment.getExternalStorageState());
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                h.a((Object) externalStorageDirectory, "path");
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                availableExternalStorageGB = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                h.a((Object) externalStorageDirectory, "path");
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                totalExternalStorageGB = statFs.getBlockCount() * statFs.getBlockSize();
            }
            totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final long convertBytesToGB(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    public static final PermissionsLists handlePermissionResponse(JSONObject jSONObject) throws JSONException {
        String optString;
        h.b(jSONObject, "result");
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString2 = optJSONObject.optString("permission");
            if (optString2 != null && !h.a((Object) optString2, (Object) "installed") && (optString = optJSONObject.optString("status")) != null) {
                if (h.a((Object) optString, (Object) "granted")) {
                    arrayList.add(optString2);
                } else if (h.a((Object) optString, (Object) "declined")) {
                    arrayList2.add(optString2);
                } else if (h.a((Object) optString, (Object) "expired")) {
                    arrayList3.add(optString2);
                }
            }
        }
        return new PermissionsLists(arrayList, arrayList2, arrayList3);
    }

    public static final String generateRandomString(int i) {
        String bigInteger = new BigInteger(i * 5, new Random()).toString(32);
        h.a((Object) bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    public static final boolean mustFixWindowParamsForAutofill(Context context) {
        h.b(context, "context");
        return isAutofillAvailable(context);
    }

    public static final boolean isAutofillAvailable(Context context) {
        AutofillManager autofillManager;
        h.b(context, "context");
        return Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    public static final boolean isChromeOS(Context context) {
        h.b(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        if (Build.DEVICE != null) {
            String str = Build.DEVICE;
            h.a((Object) str, "Build.DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).a(str)) {
                return true;
            }
        }
        return false;
    }

    public static final Locale getResourceLocale() {
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            h.a((Object) applicationContext, "FacebookSdk.getApplicationContext()");
            Resources resources = applicationContext.getResources();
            h.a((Object) resources, "FacebookSdk.getApplicationContext().resources");
            return resources.getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale = Locale.getDefault();
        h.a((Object) locale, "Locale.getDefault()");
        return locale;
    }

    public static final void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    public static final String getAppName(Context context) {
        String string;
        h.b(context, "context");
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i);
                h.a((Object) string, "context.getString(stringId)");
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f6973a;
            Object[] objArr = {FacebookSdk.getApplicationId()};
            String format = String.format("fb%s://applinks", Arrays.copyOf(objArr, objArr.length));
            h.a((Object) format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            Context applicationContext = FacebookSdk.getApplicationContext();
            h.a((Object) applicationContext, "ctx");
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                if (h.a((Object) packageName, (Object) it.next().activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final JSONObject getDataProcessingOptions() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return null;
        }
        try {
            String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSION_OPTIONS, null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return null;
        }
    }

    public static final boolean isDataProcessingRestricted() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions == null) {
                return false;
            }
            try {
                JSONArray jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSION_OPTIONS);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    h.a((Object) string, "options.getString(i)");
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = string.toLowerCase();
                    h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (h.a((Object) lowerCase, (Object) "ldu")) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class PermissionsLists {
        private List<String> declinedPermissions;
        private List<String> expiredPermissions;
        private List<String> grantedPermissions;

        public PermissionsLists(List<String> list, List<String> list2, List<String> list3) {
            h.b(list, "grantedPermissions");
            h.b(list2, SDKConstants.PARAM_DECLINED_PERMISSIONS);
            h.b(list3, SDKConstants.PARAM_EXPIRED_PERMISSIONS);
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
            this.expiredPermissions = list3;
        }

        public final List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setGrantedPermissions(List<String> list) {
            h.b(list, "<set-?>");
            this.grantedPermissions = list;
        }

        public final List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        public final void setDeclinedPermissions(List<String> list) {
            h.b(list, "<set-?>");
            this.declinedPermissions = list;
        }

        public final List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }

        public final void setExpiredPermissions(List<String> list) {
            h.b(list, "<set-?>");
            this.expiredPermissions = list;
        }
    }
}
