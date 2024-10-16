package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object asInterface(Context context, IBinder iBinder) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            return invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{iBinder});
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Map<String, String> readSkuDetailsFromCache = readSkuDetailsFromCache(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!readSkuDetailsFromCache.containsKey(next)) {
                    arrayList2.add(next);
                }
            }
            readSkuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z));
            return readSkuDetailsFromCache;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            if (obj != null && !arrayList.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
                Object[] objArr = new Object[4];
                objArr[0] = 3;
                objArr[1] = PACKAGE_NAME;
                objArr[2] = z ? "subs" : "inapp";
                objArr[3] = bundle;
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
                if (invokeMethod != null) {
                    Bundle bundle2 = (Bundle) invokeMethod;
                    if (bundle2.getInt("RESPONSE_CODE") == 0) {
                        ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                            for (int i = 0; i < arrayList.size(); i++) {
                                hashMap.put(arrayList.get(i), stringArrayList.get(i));
                            }
                        }
                        writeSkuDetailsToCache(hashMap);
                    }
                }
                return hashMap;
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String string = skuDetailSharedPrefs.getString(next, null);
                if (string != null) {
                    String[] split = string.split(";", 2);
                    if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                        hashMap.put(next, split[1]);
                    }
                }
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                edit.putString(entry.getKey(), currentTimeMillis + ";" + entry.getValue());
            }
            edit.apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
        }
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        boolean z = false;
        try {
            if (obj == null) {
                return false;
            }
            Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
            if (invokeMethod != null && ((Integer) invokeMethod).intValue() == 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            return filterPurchases(getPurchases(context, obj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> getPurchasesSubs(Context context, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            return filterPurchases(getPurchases(context, obj, "subs"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065 A[EDGE_INSN: B:24:0x0065->B:28:0x0065 BREAK  A[LOOP:0: B:12:0x001f->B:23:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r9, java.lang.Object r10, java.lang.String r11) {
        /*
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseEventManager> r0 = com.facebook.appevents.iap.InAppPurchaseEventManager.class
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r1 = 0
            if (r0 == 0) goto La
            return r1
        La:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L66
            r0.<init>()     // Catch: java.lang.Throwable -> L66
            if (r10 != 0) goto L12
            return r0
        L12:
            java.lang.Boolean r2 = isBillingSupported(r9, r10, r11)     // Catch: java.lang.Throwable -> L66
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L65
            r2 = 0
            r3 = r1
            r4 = 0
        L1f:
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L66
            r6 = 3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L66
            r5[r2] = r7     // Catch: java.lang.Throwable -> L66
            r7 = 1
            java.lang.String r8 = com.facebook.appevents.iap.InAppPurchaseEventManager.PACKAGE_NAME     // Catch: java.lang.Throwable -> L66
            r5[r7] = r8     // Catch: java.lang.Throwable -> L66
            r7 = 2
            r5[r7] = r11     // Catch: java.lang.Throwable -> L66
            r5[r6] = r3     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r6 = "getPurchases"
            java.lang.Object r3 = invokeMethod(r9, r3, r6, r10, r5)     // Catch: java.lang.Throwable -> L66
            if (r3 == 0) goto L5e
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)     // Catch: java.lang.Throwable -> L66
            if (r5 != 0) goto L5e
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)     // Catch: java.lang.Throwable -> L66
            if (r5 == 0) goto L65
            int r6 = r5.size()     // Catch: java.lang.Throwable -> L66
            int r4 = r4 + r6
            r0.addAll(r5)     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L66
            goto L5f
        L5e:
            r3 = r1
        L5f:
            r5 = 30
            if (r4 >= r5) goto L65
            if (r3 != 0) goto L1f
        L65:
            return r0
        L66:
            r9 = move-exception
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseEventManager> r10 = com.facebook.appevents.iap.InAppPurchaseEventManager.class
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    public static boolean hasFreeTrialPeirod(String str) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return false;
        }
        try {
            String optString = new JSONObject(str).optString("freeTrialPeriod");
            if (optString != null) {
                return !optString.isEmpty();
            }
            return false;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        Class<?> cls;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            return (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || getMethod(cls, GET_PURCHASE_HISTORY) == null) ? arrayList : filterPurchases(getPurchaseHistory(context, obj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            if (isBillingSupported(context, obj, str).booleanValue()) {
                char c = 0;
                String str2 = null;
                int i = 0;
                boolean z = false;
                while (true) {
                    Object[] objArr = new Object[5];
                    objArr[c] = 6;
                    objArr[1] = PACKAGE_NAME;
                    objArr[2] = str;
                    objArr[3] = str2;
                    objArr[4] = new Bundle();
                    Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, objArr);
                    if (invokeMethod != null) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        Bundle bundle = (Bundle) invokeMethod;
                        if (bundle.getInt("RESPONSE_CODE") == 0 && (stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST")) != null) {
                            Iterator<String> it = stringArrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String next = it.next();
                                if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                    z = true;
                                    break;
                                }
                                arrayList.add(next);
                                i++;
                            }
                            str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                            if (i < 30 || str2 == null || z) {
                                break;
                                break;
                            }
                            c = 0;
                        }
                    }
                    str2 = null;
                    if (i < 30) {
                        break;
                    }
                    c = 0;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private static ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            ArrayList<String> arrayList2 = new ArrayList<>();
            SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    JSONObject jSONObject = new JSONObject(next);
                    String string = jSONObject.getString("productId");
                    long j = jSONObject.getLong("purchaseTime");
                    String string2 = jSONObject.getString("purchaseToken");
                    if (currentTimeMillis - (j / 1000) <= 86400 && !purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                        edit.putString(string, string2);
                        arrayList2.add(next);
                    }
                } catch (JSONException unused) {
                }
            }
            edit.apply();
            return arrayList2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private static Method getMethod(Class<?> cls, String str) {
        Class<?>[] clsArr;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Method method = methodMap.get(str);
            if (method != null) {
                return method;
            }
            char c = 65535;
            try {
                switch (str.hashCode()) {
                    case -1801122596:
                        if (str.equals(GET_PURCHASES)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1450694211:
                        if (str.equals(IS_BILLING_SUPPORTED)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1123215065:
                        if (str.equals(AS_INTERFACE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -594356707:
                        if (str.equals(GET_PURCHASE_HISTORY)) {
                            c = 4;
                            break;
                        }
                        break;
                    case -573310373:
                        if (str.equals(GET_SKU_DETAILS)) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        clsArr = new Class[]{IBinder.class};
                        break;
                    case 1:
                        clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
                        break;
                    case 2:
                        clsArr = new Class[]{Integer.TYPE, String.class, String.class};
                        break;
                    case 3:
                        clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
                        break;
                    case 4:
                        clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
                        break;
                    default:
                        clsArr = null;
                        break;
                }
                method = cls.getDeclaredMethod(str, clsArr);
                methodMap.put(str, method);
                return method;
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private static Class<?> getClass(Context context, String str) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Class<?> cls = classMap.get(str);
            if (cls != null) {
                return cls;
            }
            try {
                cls = context.getClassLoader().loadClass(str);
                classMap.put(str, cls);
                return cls;
            } catch (ClassNotFoundException unused) {
                return cls;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Class<?> cls = getClass(context, str);
            if (cls == null || (method = getMethod(cls, str2)) == null) {
                return null;
            }
            if (obj != null) {
                obj = cls.cast(obj);
            }
            try {
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearSkuDetailsCache() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j = skuDetailSharedPrefs.getLong(LAST_CLEARED_TIME, 0L);
            if (j == 0) {
                skuDetailSharedPrefs.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
            } else if (currentTimeMillis - j > 604800) {
                skuDetailSharedPrefs.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
        }
    }
}
