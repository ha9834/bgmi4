package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzaqa extends zzaqb implements zzaho<zzbgz> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbgz f2781a;
    private final Context b;
    private final WindowManager c;
    private final zzacf d;
    private DisplayMetrics e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public zzaqa(zzbgz zzbgzVar, Context context, zzacf zzacfVar) {
        super(zzbgzVar);
        this.g = -1;
        this.h = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.f2781a = zzbgzVar;
        this.b = context;
        this.d = zzacfVar;
        this.c = (WindowManager) context.getSystemService("window");
    }

    public final void zzj(int i, int i2) {
        int i3 = this.b instanceof Activity ? zzk.zzlg().zzf((Activity) this.b)[0] : 0;
        if (this.f2781a.zzaag() == null || !this.f2781a.zzaag().zzabx()) {
            this.l = zzyt.zzpa().zzb(this.b, this.f2781a.getWidth());
            this.m = zzyt.zzpa().zzb(this.b, this.f2781a.getHeight());
        }
        zzb(i, i2 - i3, this.l, this.m);
        this.f2781a.zzaai().zzi(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbgz zzbgzVar, Map map) {
        this.e = new DisplayMetrics();
        Display defaultDisplay = this.c.getDefaultDisplay();
        defaultDisplay.getMetrics(this.e);
        this.f = this.e.density;
        this.i = defaultDisplay.getRotation();
        zzyt.zzpa();
        DisplayMetrics displayMetrics = this.e;
        this.g = zzazt.zzb(displayMetrics, displayMetrics.widthPixels);
        zzyt.zzpa();
        DisplayMetrics displayMetrics2 = this.e;
        this.h = zzazt.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzyd = this.f2781a.zzyd();
        if (zzyd == null || zzyd.getWindow() == null) {
            this.j = this.g;
            this.k = this.h;
        } else {
            zzk.zzlg();
            int[] zzd = zzaxi.zzd(zzyd);
            zzyt.zzpa();
            this.j = zzazt.zzb(this.e, zzd[0]);
            zzyt.zzpa();
            this.k = zzazt.zzb(this.e, zzd[1]);
        }
        if (this.f2781a.zzaag().zzabx()) {
            this.l = this.g;
            this.m = this.h;
        } else {
            this.f2781a.measure(0, 0);
        }
        zza(this.g, this.h, this.j, this.k, this.f, this.i);
        this.f2781a.zza("onDeviceFeaturesReceived", new zzapx(new zzapz().zzy(this.d.zzqi()).zzx(this.d.zzqj()).zzz(this.d.zzql()).zzaa(this.d.zzqk()).zzab(true)).toJson());
        int[] iArr = new int[2];
        this.f2781a.getLocationOnScreen(iArr);
        zzj(zzyt.zzpa().zzb(this.b, iArr[0]), zzyt.zzpa().zzb(this.b, iArr[1]));
        if (zzawz.isLoggable(2)) {
            zzawz.zzeo("Dispatching Ready Event.");
        }
        zzdi(this.f2781a.zzyh().zzbsx);
    }
}
