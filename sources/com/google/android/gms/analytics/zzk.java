package com.google.android.gms.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.internal.gtm.zzq;
import com.google.android.gms.internal.gtm.zzv;
import java.lang.Thread;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@VisibleForTesting
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes.dex */
public final class zzk {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzk f1208a;
    private final Context b;
    private final List<zzn> c;
    private final zze d;
    private final a e;
    private volatile zzq f;
    private Thread.UncaughtExceptionHandler g;

    /* loaded from: classes.dex */
    static class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f1210a = new AtomicInteger();

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            int incrementAndGet = f1210a.incrementAndGet();
            StringBuilder sb = new StringBuilder(23);
            sb.append("measurement-");
            sb.append(incrementAndGet);
            return new c(runnable, sb.toString());
        }

        /* synthetic */ b(com.google.android.gms.analytics.c cVar) {
            this();
        }
    }

    @VisibleForTesting
    private zzk(Context context) {
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.b = applicationContext;
        this.e = new a();
        this.c = new CopyOnWriteArrayList();
        this.d = new zze();
    }

    /* loaded from: classes.dex */
    static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new b(null));
            allowCoreThreadTimeOut(true);
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new d(this, runnable, t);
        }
    }

    public static zzk zzb(Context context) {
        Preconditions.checkNotNull(context);
        if (f1208a == null) {
            synchronized (zzk.class) {
                if (f1208a == null) {
                    f1208a = new zzk(context);
                }
            }
        }
        return f1208a;
    }

    public final zzq zzat() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    zzq zzqVar = new zzq();
                    PackageManager packageManager = this.b.getPackageManager();
                    String packageName = this.b.getPackageName();
                    zzqVar.setAppId(packageName);
                    zzqVar.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String valueOf = String.valueOf(packageName);
                        Log.e("GAv4", valueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(valueOf) : new String("Error retrieving package info: appName set to "));
                    }
                    zzqVar.setAppName(packageName);
                    zzqVar.setAppVersion(str);
                    this.f = zzqVar;
                }
            }
        }
        return this.f;
    }

    public final zzv zzau() {
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        zzv zzvVar = new zzv();
        zzvVar.setLanguage(zzcz.zza(Locale.getDefault()));
        zzvVar.zzul = displayMetrics.widthPixels;
        zzvVar.zzum = displayMetrics.heightPixels;
        return zzvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzg zzgVar) {
        if (zzgVar.c()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (zzgVar.zzan()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
        zzg zzai = zzgVar.zzai();
        zzai.a();
        this.e.execute(new com.google.android.gms.analytics.c(this, zzai));
    }

    public final Context getContext() {
        return this.b;
    }

    public static void zzav() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void zza(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.g = uncaughtExceptionHandler;
    }

    public final <V> Future<V> zza(Callable<V> callable) {
        Preconditions.checkNotNull(callable);
        if (Thread.currentThread() instanceof c) {
            FutureTask futureTask = new FutureTask(callable);
            futureTask.run();
            return futureTask;
        }
        return this.e.submit(callable);
    }

    public final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        this.e.submit(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(zzg zzgVar) {
        Preconditions.checkNotMainThread("deliver should be called from worker thread");
        Preconditions.checkArgument(zzgVar.zzan(), "Measurement must be submitted");
        List<zzo> zzak = zzgVar.zzak();
        if (zzak.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (zzo zzoVar : zzak) {
            Uri zzae = zzoVar.zzae();
            if (!hashSet.contains(zzae)) {
                hashSet.add(zzae);
                zzoVar.zzb(zzgVar);
            }
        }
    }
}
