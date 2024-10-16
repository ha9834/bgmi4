package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.midas.oversea.comm.MConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaqx implements zzarb {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2784a = new Object();

    @VisibleForTesting
    private static zzarb b = null;

    @VisibleForTesting
    private static zzarb c = null;
    private final Object d;
    private final Context e;
    private final WeakHashMap<Thread, Boolean> f;
    private final ExecutorService g;
    private final zzbai h;

    public static zzarb zzo(Context context) {
        synchronized (f2784a) {
            if (b == null) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcle)).booleanValue()) {
                    b = new zzaqx(context);
                } else {
                    b = new zzarc();
                }
            }
        }
        return b;
    }

    public static zzarb zzc(Context context, zzbai zzbaiVar) {
        synchronized (f2784a) {
            if (c == null) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcle)).booleanValue()) {
                    zzaqx zzaqxVar = new zzaqx(context, zzbaiVar);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (zzaqxVar.d) {
                            zzaqxVar.f.put(thread, true);
                        }
                        thread.setUncaughtExceptionHandler(new dy(zzaqxVar, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new dx(zzaqxVar, Thread.getDefaultUncaughtExceptionHandler()));
                    c = zzaqxVar;
                } else {
                    c = new zzarc();
                }
            }
        }
        return c;
    }

    private zzaqx(Context context) {
        this(context, zzbai.zzxc());
    }

    private zzaqx(Context context, zzbai zzbaiVar) {
        this.d = new Object();
        this.f = new WeakHashMap<>();
        this.g = Executors.newCachedThreadPool();
        this.e = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.h = zzbaiVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r3 == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L42
            r1 = r11
            r2 = 0
            r3 = 0
        L7:
            if (r1 == 0) goto L3d
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = r3
            r3 = r2
            r2 = 0
        L11:
            if (r2 >= r5) goto L36
            r7 = r4[r2]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzazt.zzej(r8)
            if (r8 == 0) goto L20
            r3 = 1
        L20:
            java.lang.Class r8 = r9.getClass()
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L33
            r6 = 1
        L33:
            int r2 = r2 + 1
            goto L11
        L36:
            java.lang.Throwable r1 = r1.getCause()
            r2 = r3
            r3 = r6
            goto L7
        L3d:
            if (r2 == 0) goto L42
            if (r3 != 0) goto L42
            goto L43
        L42:
            r10 = 0
        L43:
            if (r10 == 0) goto L4c
            java.lang.String r10 = ""
            r0 = 1065353216(0x3f800000, float:1.0)
            r9.zza(r11, r10, r0)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqx.a(java.lang.Thread, java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.zzarb
    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzarb
    public final void zza(Throwable th, String str, float f) {
        if (zzazt.zzc(th) == null) {
            return;
        }
        String name = th.getClass().getName();
        StringWriter stringWriter = new StringWriter();
        zzdmb.zza(th, new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int i = 0;
        boolean z = Math.random() < ((double) f);
        int i2 = f > 0.0f ? (int) (1.0f / f) : 1;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a(name, stringWriter2, str, i2).toString());
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                this.g.submit(new dz(this, new zzbah(), (String) obj));
            }
        }
    }

    @VisibleForTesting
    private final Uri.Builder a(String str, String str2, String str3, int i) {
        boolean z;
        try {
            z = Wrappers.packageManager(this.e).isCallerInstantApp();
        } catch (Throwable th) {
            zzbad.zzc("Error fetching instant app info", th);
            z = false;
        }
        String str4 = "unknown";
        try {
            str4 = this.e.getPackageName();
        } catch (Throwable unused) {
            zzbad.zzep("Cannot obtain package name, proceeding.");
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter(EvaluateItemInfo.ACTIONTYPE_API, String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        return appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.h.zzbsx).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzacu.zzqn())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "248613007").appendQueryParameter(AnalyticsEventKey.SMART_INTENT_SEARCH_RESULT_COUNT, MConstants.DevEnv).appendQueryParameter(SDKAnalyticsEvents.PARAMETER_SESSION_ID, zzyt.zzpf()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzyt.zzpe().zzd(zzacu.zzcwf)));
    }
}
