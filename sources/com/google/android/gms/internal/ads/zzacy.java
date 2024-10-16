package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzacy {

    @VisibleForTesting
    private ExecutorService b;

    @VisibleForTesting
    private String e;

    @VisibleForTesting
    private Context f;

    @VisibleForTesting
    private String g;
    private AtomicBoolean h;
    private File i;

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private BlockingQueue<zzadi> f2703a = new ArrayBlockingQueue(100);

    @VisibleForTesting
    private LinkedHashMap<String, String> c = new LinkedHashMap<>();

    @VisibleForTesting
    private Map<String, zzadc> d = new HashMap();

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.f = context;
        this.g = str;
        this.e = str2;
        this.h = new AtomicBoolean(false);
        this.h.set(((Boolean) zzyt.zzpe().zzd(zzacu.zzcmz)).booleanValue());
        if (this.h.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.i = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.c.put(entry.getKey(), entry.getValue());
        }
        this.b = Executors.newSingleThreadExecutor();
        this.b.execute(new t(this));
        this.d.put("action", zzadc.zzcxk);
        this.d.put("ad_format", zzadc.zzcxk);
        this.d.put("e", zzadc.zzcxl);
    }

    public final boolean zza(zzadi zzadiVar) {
        return this.f2703a.offer(zzadiVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        FileOutputStream fileOutputStream;
        while (true) {
            try {
                zzadi take = this.f2703a.take();
                String zzqx = take.zzqx();
                if (!TextUtils.isEmpty(zzqx)) {
                    Map<String, String> a2 = a(this.c, take.a());
                    Uri.Builder buildUpon = Uri.parse(this.e).buildUpon();
                    for (Map.Entry<String, String> entry : a2.entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                    }
                    String str = buildUpon.build().toString() + "&it=" + zzqx;
                    if (this.h.get()) {
                        File file = this.i;
                        if (file != null) {
                            FileOutputStream fileOutputStream2 = null;
                            try {
                                try {
                                    fileOutputStream = new FileOutputStream(file, true);
                                } catch (IOException e) {
                                    e = e;
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                fileOutputStream.write(str.getBytes());
                                fileOutputStream.write(10);
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    zzawz.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                                }
                            } catch (IOException e3) {
                                e = e3;
                                fileOutputStream2 = fileOutputStream;
                                zzawz.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e4) {
                                        zzawz.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e5) {
                                        zzawz.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
                                    }
                                }
                                throw th;
                            }
                        } else {
                            zzawz.zzep("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
                        }
                    } else {
                        zzk.zzlg();
                        zzaxi.zzb(this.f, this.g, str);
                    }
                }
            } catch (InterruptedException e6) {
                zzawz.zzd("CsiReporter:reporter interrupted", e6);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> a(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            linkedHashMap.put(key, zzch(key).zzg((String) linkedHashMap.get(key), value));
        }
        return linkedHashMap;
    }

    public final zzadc zzch(String str) {
        zzadc zzadcVar = this.d.get(str);
        return zzadcVar != null ? zzadcVar : zzadc.zzcxj;
    }
}
