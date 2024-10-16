package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import java.util.concurrent.TimeUnit;

@zzard
/* loaded from: classes2.dex */
public final class zzbdg {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2859a;
    private final String b;
    private final zzbai c;
    private final zzadg d;
    private final zzadi e;
    private final long[] g;
    private final String[] h;
    private boolean m;
    private zzbco n;
    private boolean o;
    private boolean p;
    private final zzayq f = new zzayt().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzwq();
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private long q = -1;

    public zzbdg(Context context, zzbai zzbaiVar, String str, zzadi zzadiVar, zzadg zzadgVar) {
        this.f2859a = context;
        this.c = zzbaiVar;
        this.b = str;
        this.e = zzadiVar;
        this.d = zzadgVar;
        String str2 = (String) zzyt.zzpe().zzd(zzacu.zzcmb);
        if (str2 == null) {
            this.h = new String[0];
            this.g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.h = new String[split.length];
        this.g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.g[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzawz.zzd("Unable to parse frame hash target time number.", e);
                this.g[i] = -1;
            }
        }
    }

    public final void zzb(zzbco zzbcoVar) {
        zzadb.zza(this.e, this.d, "vpc2");
        this.i = true;
        zzadi zzadiVar = this.e;
        if (zzadiVar != null) {
            zzadiVar.zzh("vpn", zzbcoVar.zzxg());
        }
        this.n = zzbcoVar;
    }

    public final void zzhd() {
        if (!this.i || this.j) {
            return;
        }
        zzadb.zza(this.e, this.d, "vfr2");
        this.j = true;
    }

    public final void onStop() {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcma)).booleanValue() || this.o) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.b);
        bundle.putString(VineCardUtils.PLAYER_CARD, this.n.zzxg());
        for (zzays zzaysVar : this.f.zzwp()) {
            String valueOf = String.valueOf("fps_c_");
            String valueOf2 = String.valueOf(zzaysVar.name);
            bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(zzaysVar.count));
            String valueOf3 = String.valueOf("fps_p_");
            String valueOf4 = String.valueOf(zzaysVar.name);
            bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(zzaysVar.zzdxd));
        }
        int i = 0;
        while (true) {
            long[] jArr = this.g;
            if (i < jArr.length) {
                String str = this.h[i];
                if (str != null) {
                    String valueOf5 = String.valueOf(Long.valueOf(jArr[i]));
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 3);
                    sb.append("fh_");
                    sb.append(valueOf5);
                    bundle.putString(sb.toString(), str);
                }
                i++;
            } else {
                zzk.zzlg().zza(this.f2859a, this.c.zzbsx, "gmob-apps", bundle, true);
                this.o = true;
                return;
            }
        }
    }

    public final void zzc(zzbco zzbcoVar) {
        if (this.k && !this.l) {
            if (zzawz.zzvj() && !this.l) {
                zzawz.zzds("VideoMetricsMixin first frame");
            }
            zzadb.zza(this.e, this.d, "vff2");
            this.l = true;
        }
        long nanoTime = zzk.zzln().nanoTime();
        if (this.m && this.p && this.q != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            double d = nanoTime - this.q;
            Double.isNaN(nanos);
            Double.isNaN(d);
            this.f.zza(nanos / d);
        }
        this.p = this.m;
        this.q = nanoTime;
        long longValue = ((Long) zzyt.zzpe().zzd(zzacu.zzcmc)).longValue();
        long currentPosition = zzbcoVar.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.h;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(currentPosition - this.g[i])) {
                String[] strArr2 = this.h;
                int i2 = 8;
                Bitmap bitmap = zzbcoVar.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j = j3;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
            i++;
        }
    }

    public final void zzyl() {
        this.m = true;
        if (!this.j || this.k) {
            return;
        }
        zzadb.zza(this.e, this.d, "vfp2");
        this.k = true;
    }

    public final void zzym() {
        this.m = false;
    }
}
