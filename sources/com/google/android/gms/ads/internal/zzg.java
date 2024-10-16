package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdg;
import com.google.android.gms.internal.ads.zzyt;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzard
/* loaded from: classes.dex */
public final class zzg implements zzdc, Runnable {
    private Context c;
    private zzbai d;

    /* renamed from: a, reason: collision with root package name */
    private final List<Object[]> f1162a = new Vector();
    private final AtomicReference<zzdc> b = new AtomicReference<>();
    private CountDownLatch e = new CountDownLatch(1);

    public zzg(Context context, zzbai zzbaiVar) {
        this.c = context;
        this.d = zzbaiVar;
        zzyt.zzpa();
        if (zzazt.zzwy()) {
            zzaxg.zzc(this);
        } else {
            run();
        }
    }

    private final boolean a() {
        try {
            this.e.await();
            return true;
        } catch (InterruptedException e) {
            zzawz.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void b() {
        if (this.f1162a.isEmpty()) {
            return;
        }
        for (Object[] objArr : this.f1162a) {
            if (objArr.length == 1) {
                this.b.get().zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                this.b.get().zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.f1162a.clear();
    }

    private static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final String zza(Context context) {
        zzdc zzdcVar;
        if (!a() || (zzdcVar = this.b.get()) == null) {
            return "";
        }
        b();
        return zzdcVar.zza(a(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final String zza(Context context, String str, View view, Activity activity) {
        zzdc zzdcVar;
        if (!a() || (zzdcVar = this.b.get()) == null) {
            return "";
        }
        b();
        return zzdcVar.zza(a(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final void zzb(View view) {
        zzdc zzdcVar = this.b.get();
        if (zzdcVar != null) {
            zzdcVar.zzb(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final void zza(MotionEvent motionEvent) {
        zzdc zzdcVar = this.b.get();
        if (zzdcVar != null) {
            b();
            zzdcVar.zza(motionEvent);
        } else {
            this.f1162a.add(new Object[]{motionEvent});
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final void zza(int i, int i2, int i3) {
        zzdc zzdcVar = this.b.get();
        if (zzdcVar != null) {
            b();
            zzdcVar.zza(i, i2, i3);
        } else {
            this.f1162a.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.d.zzdze;
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcpb)).booleanValue() && z2) {
                z = true;
            }
            this.b.set(zzdg.zza(this.d.zzbsx, a(this.c), z));
        } finally {
            this.e.countDown();
            this.c = null;
            this.d = null;
        }
    }
}
