package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzwj {

    /* renamed from: a, reason: collision with root package name */
    private final zzwo f3766a;

    @GuardedBy("this")
    private final zzxn b;
    private final boolean c;

    public static zzwj zznl() {
        return new zzwj();
    }

    public zzwj(zzwo zzwoVar) {
        this.f3766a = zzwoVar;
        this.c = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcul)).booleanValue();
        this.b = new zzxn();
        a();
    }

    private zzwj() {
        this.c = false;
        this.f3766a = new zzwo();
        this.b = new zzxn();
        a();
    }

    public final synchronized void zza(zzwl.zza.zzb zzbVar) {
        if (this.c) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcum)).booleanValue()) {
                b(zzbVar);
            } else {
                a(zzbVar);
            }
        }
    }

    private final synchronized void a(zzwl.zza.zzb zzbVar) {
        this.b.zzcfh = b();
        this.f3766a.zzg(zzdrw.zza(this.b)).zzby(zzbVar.zzac()).zzdj();
        String valueOf = String.valueOf(Integer.toString(zzbVar.zzac(), 10));
        zzawz.zzds(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void b(zzwl.zza.zzb zzbVar) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(c(zzbVar).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzawz.zzds("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzawz.zzds("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzawz.zzds("Could not close Clearcut output stream.");
                    }
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    zzawz.zzds("Could not close Clearcut output stream.");
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            zzawz.zzds("Could not find file for Clearcut");
        }
    }

    private final synchronized String c(zzwl.zza.zzb zzbVar) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.b.zzcfd, Long.valueOf(zzk.zzln().elapsedRealtime()), Integer.valueOf(zzbVar.zzac()), Base64.encodeToString(zzdrw.zza(this.b), 3));
    }

    public final synchronized void zza(zzwk zzwkVar) {
        if (this.c) {
            try {
                zzwkVar.zza(this.b);
            } catch (NullPointerException e) {
                zzk.zzlk().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    private final synchronized void a() {
        this.b.zzcfl = new zzxj();
        this.b.zzcfl.zzceh = new zzxk();
        this.b.zzcfi = new zzxl();
    }

    private static long[] b() {
        int i;
        List<String> zzqo = zzacu.zzqo();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = zzqo.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String[] split = it.next().split(",");
            int length = split.length;
            while (i < length) {
                try {
                    arrayList.add(Long.valueOf(split[i]));
                } catch (NumberFormatException unused) {
                    zzawz.zzds("Experiment ID is not a number");
                }
                i++;
            }
        }
        long[] jArr = new long[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            jArr[i2] = ((Long) obj).longValue();
            i2++;
        }
        return jArr;
    }
}
