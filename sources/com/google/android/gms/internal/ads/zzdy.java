package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzbp;
import com.google.android.gms.nearby.messages.BleSignal;
import com.tencent.midas.oversea.comm.MConstants;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class zzdy {
    private static final String c = "zzdy";

    /* renamed from: a, reason: collision with root package name */
    protected Context f3628a;
    private ExecutorService d;
    private DexClassLoader e;
    private zzdj f;
    private byte[] g;
    private boolean k;
    private zzda n;
    private Map<Pair<String, String>, zzfi> p;
    private volatile AdvertisingIdClient h = null;
    private volatile boolean i = false;
    private Future j = null;
    private volatile zzbp.zza l = null;
    private Future m = null;
    protected boolean b = false;
    private boolean o = false;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;

    /* loaded from: classes2.dex */
    final class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (!"android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    zzdy.this.r = false;
                    return;
                }
                return;
            }
            zzdy.this.r = true;
        }

        /* synthetic */ a(zzdy zzdyVar, ais aisVar) {
            this();
        }
    }

    public static zzdy zza(Context context, String str, String str2, boolean z) {
        ais aisVar;
        File cacheDir;
        File file;
        zzdy zzdyVar = new zzdy(context);
        try {
            zzdyVar.d = Executors.newCachedThreadPool(new ais());
            zzdyVar.i = z;
            if (z) {
                zzdyVar.j = zzdyVar.d.submit(new aiu(zzdyVar));
            }
            zzdyVar.d.execute(new aiw(zzdyVar));
            try {
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
                zzdyVar.b = googleApiAvailabilityLight.getApkVersion(zzdyVar.f3628a) > 0;
                zzdyVar.o = googleApiAvailabilityLight.isGooglePlayServicesAvailable(zzdyVar.f3628a) == 0;
            } catch (Throwable unused) {
            }
            zzdyVar.a(0, true);
            if (zzef.isMainThread() && ((Boolean) zzyt.zzpe().zzd(zzacu.zzcrn)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            aisVar = null;
            zzdyVar.f = new zzdj(null);
            try {
                zzdyVar.g = zzdyVar.f.zzan(str);
                try {
                    try {
                        try {
                            cacheDir = zzdyVar.f3628a.getCacheDir();
                            if (cacheDir == null && (cacheDir = zzdyVar.f3628a.getDir("dex", 0)) == null) {
                                throw new zzdv();
                            }
                            file = new File(String.format("%s/%s.jar", cacheDir, "1542658731108"));
                            if (!file.exists()) {
                                byte[] zza = zzdyVar.f.zza(zzdyVar.g, str2);
                                file.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                fileOutputStream.write(zza, 0, zza.length);
                                fileOutputStream.close();
                            }
                            zzdyVar.b(cacheDir, "1542658731108");
                        } catch (zzdk e) {
                            throw new zzdv(e);
                        }
                    } catch (FileNotFoundException e2) {
                        throw new zzdv(e2);
                    }
                } catch (IOException e3) {
                    throw new zzdv(e3);
                } catch (NullPointerException e4) {
                    throw new zzdv(e4);
                }
            } catch (zzdk e5) {
                throw new zzdv(e5);
            }
        } catch (zzdv unused2) {
        }
        try {
            zzdyVar.e = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzdyVar.f3628a.getClassLoader());
            a(file);
            zzdyVar.a(cacheDir, "1542658731108");
            a(String.format("%s/%s.dex", cacheDir, "1542658731108"));
            if (!zzdyVar.s) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                zzdyVar.f3628a.registerReceiver(new a(zzdyVar, aisVar), intentFilter);
                zzdyVar.s = true;
            }
            zzdyVar.n = new zzda(zzdyVar);
            zzdyVar.q = true;
            return zzdyVar;
        } catch (Throwable th) {
            a(file);
            zzdyVar.a(cacheDir, "1542658731108");
            a(String.format("%s/%s.dex", cacheDir, "1542658731108"));
            throw th;
        }
    }

    public final Context getContext() {
        return this.f3628a;
    }

    public final boolean isInitialized() {
        return this.q;
    }

    public final ExecutorService zzch() {
        return this.d;
    }

    public final DexClassLoader zzci() {
        return this.e;
    }

    public final zzdj zzcj() {
        return this.f;
    }

    public final byte[] zzck() {
        return this.g;
    }

    public final boolean zzcl() {
        return this.b;
    }

    public final zzda zzcm() {
        return this.n;
    }

    public final boolean zzcn() {
        return this.o;
    }

    public final boolean zzco() {
        return this.r;
    }

    public final zzbp.zza zzcp() {
        return this.l;
    }

    public final Future zzcq() {
        return this.m;
    }

    private zzdy(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.k = applicationContext != null;
        this.f3628a = this.k ? applicationContext : context;
        this.p = new HashMap();
    }

    private final void a(File file, String str) {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file3);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        a(file3);
                        return;
                    }
                    System.out.print(MConstants.TestEnv);
                    System.out.print(MConstants.TestEnv);
                    System.out.print(MConstants.TestEnv);
                    zzbp.zzd.zza zzk = zzbp.zzd.zzbc().zzl(zzdmr.zzz(Build.VERSION.SDK.getBytes())).zzk(zzdmr.zzz(str.getBytes()));
                    byte[] bytes = this.f.zzb(this.g, bArr).getBytes();
                    zzk.zzi(zzdmr.zzz(bytes)).zzj(zzdmr.zzz(tr.a(bytes)));
                    file2.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] byteArray = ((zzbp.zzd) ((zzdob) zzk.zzaya())).toByteArray();
                        fileOutputStream2.write(byteArray, 0, byteArray.length);
                        fileOutputStream2.close();
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                        a(file3);
                    } catch (zzdk | IOException | NoSuchAlgorithmException unused4) {
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        a(file3);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                        a(file3);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (zzdk | IOException | NoSuchAlgorithmException unused9) {
            }
        } catch (zzdk | IOException | NoSuchAlgorithmException unused10) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    private static void a(String str) {
        a(new File(str));
    }

    private static void a(File file) {
        if (!file.exists()) {
            Log.d(c, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        } else {
            file.delete();
        }
    }

    private final boolean b(File file, String str) {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                a(file2);
                return false;
            }
            byte[] bArr = new byte[(int) length];
            fileInputStream = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        Log.d(c, "Cannot read the cache data.");
                        a(file2);
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return false;
                    }
                    zzbp.zzd zzc = zzbp.zzd.zzc(bArr, zzdno.zzaxe());
                    if (str.equals(new String(zzc.zzba().toByteArray())) && Arrays.equals(zzc.zzaz().toByteArray(), tr.a(zzc.zzay().toByteArray())) && Arrays.equals(zzc.zzbb().toByteArray(), Build.VERSION.SDK.getBytes())) {
                        byte[] zza = this.f.zza(this.g, new String(zzc.zzay().toByteArray()));
                        file3.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                        try {
                            fileOutputStream2.write(zza, 0, zza.length);
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                            return true;
                        } catch (zzdk | IOException | NoSuchAlgorithmException unused4) {
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException unused8) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    a(file2);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused9) {
                    }
                    return false;
                } catch (zzdk | IOException | NoSuchAlgorithmException unused10) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (zzdk | IOException | NoSuchAlgorithmException unused11) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.p.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.p.put(new Pair<>(str, str2), new zzfi(this, str, str2, clsArr));
        return true;
    }

    public final Method zzc(String str, String str2) {
        zzfi zzfiVar = this.p.get(new Pair(str, str2));
        if (zzfiVar == null) {
            return null;
        }
        return zzfiVar.zzdc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        try {
            if (this.h == null && this.k) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f3628a);
                advertisingIdClient.start();
                this.h = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, boolean z) {
        if (this.o) {
            Future<?> submit = this.d.submit(new aiv(this, i, z));
            if (i == 0) {
                this.m = submit;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbp.zza b(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        return b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(int i, zzbp.zza zzaVar) {
        if (i < 4) {
            return zzaVar == null || !zzaVar.zzai() || zzaVar.zzae().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zzaVar.zzak() || !zzaVar.zzal().zzbe() || zzaVar.zzal().zzbf() == -2;
        }
        return false;
    }

    private final zzbp.zza b() {
        try {
            return zzdal.zzj(this.f3628a, this.f3628a.getPackageName(), Integer.toString(this.f3628a.getPackageManager().getPackageInfo(this.f3628a.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AdvertisingIdClient zzct() {
        if (!this.i) {
            return null;
        }
        if (this.h != null) {
            return this.h;
        }
        Future future = this.j;
        if (future != null) {
            try {
                future.get(2000L, TimeUnit.MILLISECONDS);
                this.j = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.j.cancel(true);
            }
        }
        return this.h;
    }

    public final int zzcd() {
        return this.n != null ? zzda.zzcd() : BleSignal.UNKNOWN_TX_POWER;
    }
}
