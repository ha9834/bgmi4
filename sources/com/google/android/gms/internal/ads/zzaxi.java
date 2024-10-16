package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.drive.DriveFile;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzaxi {
    public static final Handler zzdvv = new zzaxa(Looper.getMainLooper());

    @GuardedBy("userAgentLock")
    private String e;

    /* renamed from: a */
    private AtomicReference<Pattern> f2824a = new AtomicReference<>(null);
    private AtomicReference<Pattern> b = new AtomicReference<>(null);
    private boolean c = true;
    private final Object d = new Object();
    private boolean f = false;
    private boolean g = false;

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty(HttpHeader.USER_AGENT, zzq(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public static boolean zzp(Context context, String str) {
        Context zzw = zzasq.zzw(context);
        return Wrappers.packageManager(zzw).checkPermission(str, zzw.getPackageName()) == 0;
    }

    public static void zzb(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            new zzazi(context, str, (String) obj).zzvi();
        }
    }

    public static String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[ProgressEvent.PART_COMPLETED_EVENT_CODE];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
            }
        }
    }

    public final boolean zzak(Context context) {
        if (this.f) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new fr(this, null), intentFilter);
        this.f = true;
        return true;
    }

    public final boolean zzal(Context context) {
        if (this.g) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new fq(this, null), intentFilter);
        this.g = true;
        return true;
    }

    public final void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zzq(context, str));
    }

    private static String a() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append("; ");
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzq(Context context, String str) {
        synchronized (this.d) {
            if (this.e != null) {
                return this.e;
            }
            if (str == null) {
                return a();
            }
            try {
                this.e = zzk.zzli().getDefaultUserAgent(context);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(this.e)) {
                zzyt.zzpa();
                if (!zzazt.zzwy()) {
                    this.e = null;
                    zzdvv.post(new fo(this, context));
                    while (this.e == null) {
                        try {
                            this.d.wait();
                        } catch (InterruptedException unused2) {
                            this.e = a();
                            String valueOf = String.valueOf(this.e);
                            zzawz.zzep(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                        }
                    }
                } else {
                    this.e = a(context);
                }
            }
            String valueOf2 = String.valueOf(this.e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 10 + String.valueOf(str).length());
            sb.append(valueOf2);
            sb.append(" (Mobile; ");
            sb.append(str);
            this.e = sb.toString();
            try {
                if (Wrappers.packageManager(context).isCallerInstantApp()) {
                    this.e = String.valueOf(this.e).concat(";aia");
                }
            } catch (Exception e) {
                zzk.zzlk().zza(e, "AdUtil.getUserAgent");
            }
            this.e = String.valueOf(this.e).concat(")");
            return this.e;
        }
    }

    @VisibleForTesting
    public static String a(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject zzi(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public final JSONObject zza(Bundle bundle, JSONObject jSONObject) {
        if (bundle == null) {
            return null;
        }
        try {
            return zzd(bundle);
        } catch (JSONException e) {
            zzawz.zzc("Error converting Bundle to JSON", e);
            return null;
        }
    }

    public final JSONObject zzd(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private final JSONArray a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            a(jSONArray, it.next());
        }
        return jSONArray;
    }

    private final void a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzd((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(zzi((Map<String, ?>) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(a((Collection<?>) obj));
            return;
        }
        if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                a(jSONArray2, obj2);
            }
            jSONArray.put(jSONArray2);
            return;
        }
        jSONArray.put(obj);
    }

    private final void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzd((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, zzi((Map<String, ?>) obj));
            return;
        }
        if (obj instanceof Collection) {
            if (str == null) {
                str = Constants.NULL_VERSION_ID;
            }
            jSONObject.put(str, a((Collection<?>) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        if (c < 'a' || c > 'f') {
            throw new IllegalArgumentException("Invalid Hex.");
        }
        return (c - 'a') + 10;
    }

    public static Map<String, String> zzi(Uri uri) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcwv)).booleanValue()) {
            if (uri == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            zzk.zzli();
            for (String str : uri.getQueryParameterNames()) {
                hashMap.put(str, uri.getQueryParameter(str));
            }
            return hashMap;
        }
        if (uri == null) {
            return null;
        }
        HashMap hashMap2 = new HashMap(20);
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return hashMap2;
        }
        int length = encodedQuery.length();
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(length);
        StringBuilder sb3 = sb;
        int i = 0;
        while (i < length) {
            char charAt = encodedQuery.charAt(i);
            if (charAt == '+') {
                sb3.append(' ');
            } else if (charAt != '=') {
                switch (charAt) {
                    case '%':
                        byte[] bArr = new byte[(length - i) / 3];
                        int i2 = 0;
                        while (i < length - 2 && charAt == '%') {
                            try {
                                bArr[i2] = (byte) ((a(encodedQuery.charAt(i + 1)) << 4) + a(encodedQuery.charAt(i + 2)));
                                i2++;
                            } catch (IllegalArgumentException unused) {
                            }
                            i += 3;
                            if (i < length) {
                                charAt = encodedQuery.charAt(i);
                            }
                        }
                        try {
                            sb3.append(new String(bArr, 0, i2, "UTF-8"));
                        } catch (UnsupportedEncodingException unused2) {
                        }
                        if (charAt != '%') {
                            break;
                        } else {
                            break;
                        }
                    case '&':
                        if (sb.length() > 0 && sb3 != sb) {
                            hashMap2.put(sb.toString(), sb2.toString());
                            sb.setLength(0);
                            sb2.setLength(0);
                        }
                        sb3 = sb;
                        break;
                    default:
                        sb3.append(charAt);
                        break;
                }
            } else if (sb3 != sb2) {
                sb3 = sb2;
            } else {
                sb3.append(charAt);
            }
            i++;
        }
        if (sb.length() > 0 && sb3 != sb) {
            hashMap2.put(sb.toString(), sb2.toString());
        }
        return hashMap2;
    }

    public static String zzwb() {
        return UUID.randomUUID().toString();
    }

    public static int zzdy(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzawz.zzep(sb.toString());
            return 0;
        }
    }

    public static String zzwc() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    private static int[] b() {
        return new int[]{0, 0};
    }

    public static int[] zzd(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window != null && (findViewById = window.findViewById(R.id.content)) != null) {
            return new int[]{findViewById.getWidth(), findViewById.getHeight()};
        }
        return b();
    }

    public final int[] zze(Activity activity) {
        int[] zzd = zzd(activity);
        return new int[]{zzyt.zzpa().zzb(activity, zzd[0]), zzyt.zzpa().zzb(activity, zzd[1])};
    }

    public final int[] zzf(Activity activity) {
        int[] b;
        View findViewById;
        Window window = activity.getWindow();
        if (window != null && (findViewById = window.findViewById(R.id.content)) != null) {
            b = new int[]{findViewById.getTop(), findViewById.getBottom()};
        } else {
            b = b();
        }
        return new int[]{zzyt.zzpa().zzb(activity, b[0]), zzyt.zzpa().zzb(activity, b[1])};
    }

    public static boolean zzdz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static AlertDialog.Builder zzan(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzacf zzao(Context context) {
        return new zzacf(context);
    }

    public static Bitmap zzk(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String zzap(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                return runningTaskInfo.topActivity.getClassName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean zzaq(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return true;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return !(powerManager == null ? false : powerManager.isScreenOn());
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        zzk.zzlg();
        bundle.putString("device", zzwc());
        bundle.putString("eids", TextUtils.join(",", zzacu.zzqn()));
        zzyt.zzpa();
        zzazt.zza(context, str, str2, bundle, true, new fp(this, context, str));
    }

    public static void zzd(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzaxg.zzc(runnable);
        }
    }

    public static Bitmap zzl(View view) {
        if (view == null) {
            return null;
        }
        Bitmap b = b(view);
        return b == null ? a(view) : b;
    }

    private static Bitmap a(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
                return createBitmap;
            }
            zzawz.zzep("Width or height of view is zero");
            return null;
        } catch (RuntimeException e) {
            zzawz.zzc("Fail to capture the webview", e);
            return null;
        }
    }

    private static Bitmap b(View view) {
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            r0 = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e) {
            zzawz.zzc("Fail to capture the web view", e);
        }
        return r0;
    }

    public static void zza(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
    }

    public static int zzar(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    public final boolean zza(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zza(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, b(context));
    }

    private static KeyguardManager b(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    public final boolean zza(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        if (!zzk.zzlg().c) {
            if ((keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) && !zzo(view)) {
                z = false;
                if (view.getVisibility() == 0 && view.isShown()) {
                    if ((powerManager != null || powerManager.isScreenOn()) && z) {
                        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqh)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        z = true;
        if (view.getVisibility() == 0) {
            if (powerManager != null || powerManager.isScreenOn()) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqh)).booleanValue()) {
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzo(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 == 0) goto L12
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L12
            android.app.Activity r2 = (android.app.Activity) r2
            goto L13
        L12:
            r2 = r0
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxi.zzo(android.view.View):boolean");
    }

    @TargetApi(16)
    public static boolean zzat(Context context) {
        KeyguardManager b;
        return context != null && PlatformVersion.isAtLeastJellyBean() && (b = b(context)) != null && b.isKeyguardLocked();
    }

    public static int zzp(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public static boolean zzau(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzawz.zzc("Error loading class.", th);
            zzk.zzlk().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    @TargetApi(18)
    public static void zza(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzb(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzawz.zzdp(sb.toString());
        } catch (ActivityNotFoundException e) {
            zzawz.zzc("No browser is found.", e);
        }
    }

    @TargetApi(18)
    public static void zzb(Context context, Intent intent) {
        if (intent != null && PlatformVersion.isAtLeastJellyBeanMR2()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("androidx.browser.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void zzc(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Exception e) {
            zzawz.zzc("Error writing to file in internal storage.", e);
        }
    }

    public static String zzr(Context context, String str) {
        try {
            return new String(IOUtils.readInputStreamFully(context.openFileInput(str), true), "UTF-8");
        } catch (IOException unused) {
            zzawz.zzdp("Error reading from internal storage.");
            return "";
        }
    }

    public final boolean zzea(String str) {
        return a(str, this.f2824a, (String) zzyt.zzpe().zzd(zzacu.zzcnt));
    }

    public final boolean zzeb(String str) {
        return a(str, this.b, (String) zzyt.zzpe().zzd(zzacu.zzcnu));
    }

    private static boolean a(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static String zzwe() {
        Resources resources = zzk.zzlk().getResources();
        return resources != null ? resources.getString(com.google.android.gms.ads.impl.R.string.s7) : "Test Ad";
    }

    public static WebResourceResponse zzd(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(HttpHeader.USER_AGENT, zzk.zzlg().zzq(context, str));
            hashMap.put(Headers.CACHE_CONTROL, "max-stale=3600");
            String str3 = new zzayu(context).zzc(str2, hashMap).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzawz.zzd("Could not fetch MRAID JS.", e);
            return null;
        }
    }

    public static WebResourceResponse zzd(HttpURLConnection httpURLConnection) throws IOException {
        String str;
        zzk.zzlg();
        String contentType = httpURLConnection.getContentType();
        String trim = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
        zzk.zzlg();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(";");
            if (split.length != 1) {
                for (int i = 1; i < split.length; i++) {
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            str = split2[1].trim();
                            break;
                        }
                    }
                }
            }
        }
        str = "";
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && entry.getValue().size() > 0) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return zzk.zzli().zza(trim, str, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    public static void zza(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        boolean z = false;
        try {
            z = ((Boolean) zzyt.zzpe().zzd(zzacu.zzclf)).booleanValue();
        } catch (IllegalStateException unused) {
        }
        if (z) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
        }
    }

    public static String zzav(Context context) {
        return !((Boolean) zzyt.zzpe().zzd(zzacu.zzcwm)).booleanValue() ? "" : context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
    }

    public static Bundle zzaw(Context context) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcwn)).booleanValue()) {
            return null;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Bundle bundle = new Bundle();
        if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
            bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
        }
        String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (defaultSharedPreferences.contains(str)) {
                bundle.putString(str, defaultSharedPreferences.getString(str, null));
            }
        }
        return bundle;
    }

    public static boolean zzax(Context context) {
        Window window;
        if (!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    public static boolean zzec(String str) {
        if (!zzazx.isEnabled()) {
            return false;
        }
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcuo)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzyt.zzpe().zzd(zzacu.zzcuq);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) zzyt.zzpe().zzd(zzacu.zzcup);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
