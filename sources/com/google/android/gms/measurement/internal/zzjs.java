package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.amazonaws.event.ProgressEvent;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.util.ErrorReportProvider;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes2.dex */
public final class zzjs extends ee {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f4956a = {"firebase_", "google_", "ga_"};
    private static final List<String> f = Collections.unmodifiableList(Arrays.asList("source", "medium", FirebaseAnalytics.Param.CAMPAIGN, FirebaseAnalytics.Param.TERM, FirebaseAnalytics.Param.CONTENT));
    private SecureRandom b;
    private final AtomicLong c;
    private int d;
    private Integer e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjs(zzfj zzfjVar) {
        super(zzfjVar);
        this.e = null;
        this.c = new AtomicLong(0L);
    }

    @Override // com.google.android.gms.measurement.internal.ee
    protected final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.ee
    protected final void b() {
        zzo();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzab().zzgn().zzao("Utils falling back to Random for random id");
            }
        }
        this.c.set(nextLong);
    }

    public final long zzjv() {
        long andIncrement;
        long j;
        if (this.c.get() == 0) {
            synchronized (this.c) {
                long nextLong = new Random(System.nanoTime() ^ zzx().currentTimeMillis()).nextLong();
                int i = this.d + 1;
                this.d = i;
                j = nextLong + i;
            }
            return j;
        }
        synchronized (this.c) {
            this.c.compareAndSet(-1L, 1L);
            andIncrement = this.c.getAndIncrement();
        }
        return andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecureRandom c() {
        zzo();
        if (this.b == null) {
            this.b = new SecureRandom();
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle a(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzab().zzgn().zza("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(String str, String str2) {
        if (str2 == null) {
            zzab().zzgm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzab().zzgm().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            zzab().zzgm().zza("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                zzab().zzgm().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(String str, String str2) {
        if (str2 == null) {
            zzab().zzgm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzab().zzgm().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt) && codePointAt != 95) {
            zzab().zzgm().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                zzab().zzgm().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            zzab().zzgm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr2 = f4956a;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (str2.startsWith(strArr2[i])) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            zzab().zzgm().zza("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            Preconditions.checkNotNull(strArr);
            int length2 = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z2 = false;
                    break;
                }
                if (d(str2, strArr[i2])) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                zzab().zzgm().zza("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(String str, int i, String str2) {
        if (str2 == null) {
            zzab().zzgm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        zzab().zzgm().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b(String str) {
        if (!b(DataLayer.EVENT_KEY, str)) {
            return 2;
        }
        if (a(DataLayer.EVENT_KEY, zzgj.zzpn, str)) {
            return !a(DataLayer.EVENT_KEY, 40, str) ? 2 : 0;
        }
        return 13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c(String str) {
        if (!b("user property", str)) {
            return 6;
        }
        if (a("user property", zzgl.zzpp, str)) {
            return !a("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    private final boolean a(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) <= i) {
                return true;
            }
            zzab().zzgp().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
            return false;
        }
        if ((obj instanceof Bundle) && z) {
            return true;
        }
        if ((obj instanceof Parcelable[]) && z) {
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (!(parcelable instanceof Bundle)) {
                    zzab().zzgp().zza("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof ArrayList) || !z) {
            return false;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            if (!(obj2 instanceof Bundle)) {
                zzab().zzgp().zza("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (g(str)) {
                return true;
            }
            if (this.v.zzhw()) {
                zzab().zzgm().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzef.a(str));
            }
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (g(str2)) {
                return true;
            }
            zzab().zzgm().zza("Invalid admob_app_id. Analytics disabled.", zzef.a(str2));
            return false;
        }
        if (this.v.zzhw()) {
            zzab().zzgm().zzao("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    @VisibleForTesting
    private static boolean g(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private static Object a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zza(String.valueOf(obj), i, z);
        }
        return null;
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object a(String str, Object obj) {
        if ("_ev".equals(str)) {
            return a(256, obj, true);
        }
        return a(e(str) ? 256 : 100, obj, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] a(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle a(java.lang.String r18, java.lang.String r19, android.os.Bundle r20, java.util.List<java.lang.String> r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjs.a(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    private static boolean a(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    private static void a(Bundle bundle, Object obj) {
        Preconditions.checkNotNull(bundle);
        if (obj != null) {
            if ((obj instanceof String) || (obj instanceof CharSequence)) {
                bundle.putLong("_el", String.valueOf(obj).length());
            }
        }
    }

    private static int h(String str) {
        return "_ldl".equals(str) ? ProgressEvent.PART_COMPLETED_EVENT_CODE : "_id".equals(str) ? 256 : 36;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b(String str, Object obj) {
        boolean a2;
        if ("_ldl".equals(str)) {
            a2 = a("user property referrer", str, h(str), obj, false);
        } else {
            a2 = a("user property", str, h(str), obj, false);
        }
        return a2 ? 0 : 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object c(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return a(h(str), obj, true);
        }
        return a(h(str), obj, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (str != null) {
            zzab().zzgp().zza("Not putting event parameter. Invalid value type. name, type", zzy().b(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void zza(int i, String str, String str2, int i2) {
        a((String) null, i, str, str2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        a(bundle, i);
        if (zzad().zze(str, zzak.zzip)) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                bundle.putString(str2, str3);
            }
        } else if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        this.v.zzae();
        this.v.zzq().logEvent("auto", "_err", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest d() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance(Constants.MD5);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static long a(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (bArr[length] & 255) << i;
            i += 8;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return b(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return b(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    private static boolean b(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(String str) {
        zzo();
        if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzab().zzgr().zza("Permission not granted", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzbu = zzad().zzbu();
        zzae();
        return zzbu.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object a2 = a(str, bundle.get(str));
                if (a2 == null) {
                    zzab().zzgp().zza("Param value can't be null", zzy().b(str));
                } else {
                    a(bundle2, str, a2);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzai a(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (b(str2) != 0) {
            zzab().zzgk().zza("Invalid conditional property event name", zzy().c(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        return new zzai(str2, new zzah(a(a(str, str2, bundle2, CollectionUtils.listOf("_o"), false, false))), str3, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a(Context context, String str) {
        zzo();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest d = d();
        long j = -1;
        if (d == null) {
            zzab().zzgk().zzao("Could not get MD5 instance");
            return -1L;
        }
        if (packageManager != null) {
            try {
                if (c(context, str)) {
                    j = 0;
                } else {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        j = a(d.digest(packageInfo.signatures[0].toByteArray()));
                    } else {
                        zzab().zzgn().zzao("Could not get signatures");
                    }
                }
                return j;
            } catch (PackageManager.NameNotFoundException e) {
                zzab().zzgk().zza("Package name not found", e);
            }
        }
        return 0L;
    }

    @VisibleForTesting
    private final boolean c(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            zzab().zzgk().zza("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            zzab().zzgk().zza("Error obtaining certificate", e2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static Bundle zzh(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    public final int zzjx() {
        if (this.e == null) {
            this.e = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
        }
        return this.e.intValue();
    }

    public final int zzd(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(getContext(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public static long zzc(long j, long j2) {
        return (j + (j2 * 60000)) / ErrorReportProvider.BATCH_TIME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String e() {
        byte[] bArr = new byte[16];
        c().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzab().zzgn().zza("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzb(zzp zzpVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, str);
        try {
            zzpVar.zzb(bundle);
        } catch (RemoteException e) {
            this.v.zzab().zzgn().zza("Error returning string value to wrapper", e);
        }
    }

    public final void zza(zzp zzpVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, j);
        try {
            zzpVar.zzb(bundle);
        } catch (RemoteException e) {
            this.v.zzab().zzgn().zza("Error returning long value to wrapper", e);
        }
    }

    public final void zza(zzp zzpVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, i);
        try {
            zzpVar.zzb(bundle);
        } catch (RemoteException e) {
            this.v.zzab().zzgn().zza("Error returning int value to wrapper", e);
        }
    }

    public final void zza(zzp zzpVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, bArr);
        try {
            zzpVar.zzb(bundle);
        } catch (RemoteException e) {
            this.v.zzab().zzgn().zza("Error returning byte array to wrapper", e);
        }
    }

    public final void zza(zzp zzpVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, z);
        try {
            zzpVar.zzb(bundle);
        } catch (RemoteException e) {
            this.v.zzab().zzgn().zza("Error returning boolean value to wrapper", e);
        }
    }

    public final void zza(zzp zzpVar, Bundle bundle) {
        try {
            zzpVar.zzb(bundle);
        } catch (RemoteException e) {
            this.v.zzab().zzgn().zza("Error returning bundle value to wrapper", e);
        }
    }

    public static Bundle zzc(List<zzjn> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzjn zzjnVar : list) {
            if (zzjnVar.zzkr != null) {
                bundle.putString(zzjnVar.name, zzjnVar.zzkr);
            } else if (zzjnVar.zzts != null) {
                bundle.putLong(zzjnVar.name, zzjnVar.zzts.longValue());
            } else if (zzjnVar.zztu != null) {
                bundle.putDouble(zzjnVar.name, zzjnVar.zztu.doubleValue());
            }
        }
        return bundle;
    }

    public final void zza(zzp zzpVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, arrayList);
        try {
            zzpVar.zzb(bundle);
        } catch (RemoteException e) {
            this.v.zzab().zzgn().zza("Error returning bundle list to wrapper", e);
        }
    }

    public static ArrayList<Bundle> zzd(List<zzq> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzq zzqVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzqVar.packageName);
            bundle.putString("origin", zzqVar.origin);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzqVar.creationTimestamp);
            bundle.putString("name", zzqVar.zzdw.name);
            zzgg.zza(bundle, zzqVar.zzdw.getValue());
            bundle.putBoolean("active", zzqVar.active);
            if (zzqVar.triggerEventName != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzqVar.triggerEventName);
            }
            if (zzqVar.zzdx != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzqVar.zzdx.name);
                if (zzqVar.zzdx.zzfq != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzqVar.zzdx.zzfq.zzcv());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzqVar.triggerTimeout);
            if (zzqVar.zzdy != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzqVar.zzdy.name);
                if (zzqVar.zzdy.zzfq != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzqVar.zzdy.zzfq.zzcv());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzqVar.zzdw.zztr);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzqVar.timeToLive);
            if (zzqVar.zzdz != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzqVar.zzdz.name);
                if (zzqVar.zzdz.zzfq != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzqVar.zzdz.zzfq.zzcv());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final URL zza(long j, String str, String str2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            return new URL(String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s", String.format("v%s.%s", Long.valueOf(j), Integer.valueOf(zzjx())), str2, str));
        } catch (IllegalArgumentException | MalformedURLException e) {
            zzab().zzgk().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
