package com.google.android.gms.internal.firebase_remote_config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.format.DateUtils;
import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.BuildConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zzeq {
    private final Context b;
    private final FirebaseInstanceId c;
    private final AnalyticsConnector d;
    private final String e;
    private final Executor f;
    private final Clock g;
    private final Random h;
    private final zzeh i;
    private final zzcy j;
    private final zzev k;
    private final String l;
    private final String m;
    public static final long zzkv = TimeUnit.HOURS.toSeconds(12);

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f4161a = {2, 4, 8, 16, 32, 64, 128, 256};
    private static final Pattern n = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    public zzeq(Context context, String str, FirebaseInstanceId firebaseInstanceId, AnalyticsConnector analyticsConnector, String str2, Executor executor, Clock clock, Random random, zzeh zzehVar, zzcy zzcyVar, zzev zzevVar) {
        this.b = context;
        this.l = str;
        this.c = firebaseInstanceId;
        this.d = analyticsConnector;
        this.e = str2;
        this.f = executor;
        this.g = clock;
        this.h = random;
        this.i = zzehVar;
        this.j = zzcyVar;
        this.k = zzevVar;
        Matcher matcher = n.matcher(str);
        this.m = matcher.matches() ? matcher.group(1) : null;
    }

    public final Task<zzep> zza(boolean z) {
        return zza(z, this.k.getMinimumFetchIntervalInSeconds());
    }

    public final Task<zzep> zza(final boolean z, final long j) {
        return this.i.zzcp().continueWithTask(this.f, new Continuation(this, z, j) { // from class: com.google.android.gms.internal.firebase_remote_config.au

            /* renamed from: a, reason: collision with root package name */
            private final zzeq f4035a;
            private final boolean b;
            private final long c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4035a = this;
                this.b = z;
                this.c = j;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f4035a.a(this.b, this.c, task);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[Catch: FirebaseRemoteConfigException -> 0x002d, TRY_LEAVE, TryCatch #0 {FirebaseRemoteConfigException -> 0x002d, blocks: (B:2:0x0000, B:4:0x000a, B:9:0x001c, B:12:0x0022), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c A[Catch: FirebaseRemoteConfigException -> 0x002d, TryCatch #0 {FirebaseRemoteConfigException -> 0x002d, blocks: (B:2:0x0000, B:4:0x000a, B:9:0x001c, B:12:0x0022), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.tasks.Task<com.google.android.gms.internal.firebase_remote_config.zzep> a(java.util.Date r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.firebase_remote_config.zzdf r0 = r3.b(r4)     // Catch: com.google.firebase.remoteconfig.FirebaseRemoteConfigException -> L2d
            java.lang.String r1 = r0.getState()     // Catch: com.google.firebase.remoteconfig.FirebaseRemoteConfigException -> L2d
            if (r1 == 0) goto L19
            java.lang.String r1 = r0.getState()     // Catch: com.google.firebase.remoteconfig.FirebaseRemoteConfigException -> L2d
            java.lang.String r2 = "NO_CHANGE"
            boolean r1 = r1.equals(r2)     // Catch: com.google.firebase.remoteconfig.FirebaseRemoteConfigException -> L2d
            if (r1 != 0) goto L17
            goto L19
        L17:
            r1 = 0
            goto L1a
        L19:
            r1 = 1
        L1a:
            if (r1 != 0) goto L22
            r4 = 0
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.tasks.Tasks.forResult(r4)     // Catch: com.google.firebase.remoteconfig.FirebaseRemoteConfigException -> L2d
            return r4
        L22:
            com.google.android.gms.internal.firebase_remote_config.zzep r4 = a(r0, r4)     // Catch: com.google.firebase.remoteconfig.FirebaseRemoteConfigException -> L2d
            com.google.android.gms.internal.firebase_remote_config.zzeh r0 = r3.i     // Catch: com.google.firebase.remoteconfig.FirebaseRemoteConfigException -> L2d
            com.google.android.gms.tasks.Task r4 = r0.zzc(r4)     // Catch: com.google.firebase.remoteconfig.FirebaseRemoteConfigException -> L2d
            return r4
        L2d:
            r4 = move-exception
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.tasks.Tasks.forException(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzeq.a(java.util.Date):com.google.android.gms.tasks.Task");
    }

    private final zzdf b(Date date) throws FirebaseRemoteConfigException {
        String str;
        try {
            zzdc zza = new zzcz(new zzda(this.j)).zza(this.m, this.e, a());
            zzw zzg = zza.zzg();
            zzg.zzr(this.k.zzda());
            zzg.zzb("X-Android-Package", this.b.getPackageName());
            zzg.zzb("X-Android-Cert", a(this.b, this.b.getPackageName()));
            zzdf zzi = zza.zzi();
            this.k.zzbd(zza.zzh().zzq());
            this.k.zza(0, zzev.zzln);
            return zzi;
        } catch (zzaf e) {
            Log.e("FirebaseRemoteConfig", "Fetch failed! Server responded with an error.", e);
            int statusCode = e.getStatusCode();
            if (statusCode == 429 || statusCode == 503 || statusCode == 504) {
                int a2 = this.k.zzdb().a() + 1;
                TimeUnit timeUnit = TimeUnit.MINUTES;
                int[] iArr = f4161a;
                this.k.zza(a2, new Date(date.getTime() + (timeUnit.toMillis(iArr[Math.min(a2, iArr.length) - 1]) / 2) + this.h.nextInt((int) r5)));
            }
            int statusCode2 = e.getStatusCode();
            if (statusCode2 == 401) {
                str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
            } else if (statusCode2 == 403) {
                str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
            } else if (statusCode2 == 429) {
                str = "You have reached the throttle limit for your project. Please wait before making more requests.";
            } else if (statusCode2 != 500) {
                switch (statusCode2) {
                    case 503:
                    case 504:
                        str = "The server is unavailable. Please try again later.";
                        break;
                    default:
                        str = "Server returned an unexpected error.";
                        break;
                }
            } else {
                str = "There was an internal server error.";
            }
            throw new FirebaseRemoteConfigFetchException(String.format("Fetch failed: %s\nCheck logs for details.", str));
        } catch (IOException e2) {
            Log.e("FirebaseRemoteConfig", "Fetch failed due to an unexpected error.", e2);
            throw new FirebaseRemoteConfigFetchException("Fetch failed due to an unexpected error! Check logs for details.");
        }
    }

    private static String a(Context context, String str) {
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, str);
            if (packageCertificateHashBytes == null) {
                String valueOf = String.valueOf(str);
                Log.e("FirebaseRemoteConfig", valueOf.length() != 0 ? "Could not get fingerprint hash for package: ".concat(valueOf) : new String("Could not get fingerprint hash for package: "));
                return null;
            }
            return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf2 = String.valueOf(str);
            Log.e("FirebaseRemoteConfig", valueOf2.length() != 0 ? "No such package: ".concat(valueOf2) : new String("No such package: "), e);
            return null;
        }
    }

    private static zzep a(zzdf zzdfVar, Date date) throws FirebaseRemoteConfigFetchException {
        try {
            zzer zzc = zzep.zzct().zzc(date);
            Map<String, String> entries = zzdfVar.getEntries();
            if (entries != null) {
                zzc.zzd(entries);
            }
            List<zzdd> zzcf = zzdfVar.zzcf();
            if (zzcf != null) {
                zzc.zzb(zzcf);
            }
            return zzc.zzcw();
        } catch (JSONException e) {
            throw new FirebaseRemoteConfigFetchException("Fetch failed: fetch response could not be parsed.", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzdg a() throws FirebaseRemoteConfigFetchException {
        String id = this.c.getId();
        if (id == null) {
            throw new FirebaseRemoteConfigFetchException("Fetch request could not be created: Firebase instance id is null.");
        }
        String token = this.c.getToken();
        zzdg zzdgVar = new zzdg();
        zzdgVar.zzas(id);
        if (token != null) {
            zzdgVar.zzat(token);
        }
        zzdgVar.zzar(this.l);
        Locale locale = this.b.getResources().getConfiguration().locale;
        zzdgVar.zzav(locale.getCountry());
        zzdgVar.zzaw(locale.toString());
        zzdgVar.zzay(Integer.toString(Build.VERSION.SDK_INT));
        zzdgVar.zzba(TimeZone.getDefault().toString());
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0);
            if (packageInfo != null) {
                zzdgVar.zzau(packageInfo.versionName);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        zzdgVar.zzax(this.b.getPackageName());
        zzdgVar.zzaz(BuildConfig.VERSION_NAME);
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector = this.d;
        if (analyticsConnector != null) {
            for (Map.Entry<String, Object> entry : analyticsConnector.getUserProperties(false).entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        zzdgVar.zza(hashMap);
        return zzdgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(boolean z, long j, Task task) throws Exception {
        boolean before;
        Date date = new Date(this.g.currentTimeMillis());
        if (task.isSuccessful()) {
            if (z) {
                before = false;
            } else {
                Date zzcz = this.k.zzcz();
                before = zzcz.equals(new Date(-1L)) ? false : date.before(new Date(zzcz.getTime() + TimeUnit.SECONDS.toMillis(j)));
            }
            if (before) {
                return Tasks.forResult(null);
            }
        }
        Date b = this.k.zzdb().b();
        if (!date.before(b)) {
            b = null;
        }
        if (b != null) {
            return Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(b.getTime() - date.getTime()))), b.getTime()));
        }
        return a(date);
    }
}
