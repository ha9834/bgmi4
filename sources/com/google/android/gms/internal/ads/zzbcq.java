package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbcq extends FrameLayout implements zzbcn {

    /* renamed from: a, reason: collision with root package name */
    private final zzbdf f2855a;
    private final FrameLayout b;
    private final zzadi c;
    private final io d;
    private final long e;
    private zzbco f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private String m;
    private String[] n;
    private Bitmap o;
    private ImageView p;
    private boolean q;

    public static void zzb(zzbdf zzbdfVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "no_video_view");
        zzbdfVar.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbdf zzbdfVar, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbdfVar.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbdf zzbdfVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "decoderProps");
        hashMap.put("error", str);
        zzbdfVar.zza("onVideoEvent", hashMap);
    }

    public zzbcq(Context context, zzbdf zzbdfVar, int i, boolean z, zzadi zzadiVar, zzbde zzbdeVar) {
        super(context);
        this.f2855a = zzbdfVar;
        this.c = zzadiVar;
        this.b = new FrameLayout(context);
        addView(this.b, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbdfVar.zzye());
        this.f = zzbdfVar.zzye().zzbqs.zza(context, zzbdfVar, i, z, zzadiVar, zzbdeVar);
        zzbco zzbcoVar = this.f;
        if (zzbcoVar != null) {
            this.b.addView(zzbcoVar, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcmd)).booleanValue()) {
                zzxs();
            }
        }
        this.p = new ImageView(context);
        this.e = ((Long) zzyt.zzpe().zzd(zzacu.zzcmh)).longValue();
        this.j = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcmf)).booleanValue();
        zzadi zzadiVar2 = this.c;
        if (zzadiVar2 != null) {
            zzadiVar2.zzh("spinner_used", this.j ? "1" : "0");
        }
        this.d = new io(this);
        zzbco zzbcoVar2 = this.f;
        if (zzbcoVar2 != null) {
            zzbcoVar2.zza(this);
        }
        if (this.f == null) {
            zzl("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.b.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzc(String str, String[] strArr) {
        this.m = str;
        this.n = strArr;
    }

    public final void zza(float f, float f2) {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar != null) {
            zzbcoVar.zza(f, f2);
        }
    }

    public final void zzfr() {
        if (this.f == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.f.zzb(this.m, this.n);
        } else {
            a("no_src", new String[0]);
        }
    }

    public final void pause() {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.pause();
    }

    public final void play() {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.play();
    }

    public final void seekTo(int i) {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.seekTo(i);
    }

    public final void zzxq() {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.b.setMuted(true);
        zzbcoVar.zzxk();
    }

    public final void zzxr() {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.b.setMuted(false);
        zzbcoVar.zzxk();
    }

    public final void setVolume(float f) {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.b.setVolume(f);
        zzbcoVar.zzxk();
    }

    public final void zzcy(int i) {
        this.f.zzcy(i);
    }

    public final void zzcz(int i) {
        this.f.zzcz(i);
    }

    public final void zzda(int i) {
        this.f.zzda(i);
    }

    public final void zzdb(int i) {
        this.f.zzdb(i);
    }

    public final void zzdc(int i) {
        this.f.zzdc(i);
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.dispatchTouchEvent(motionEvent);
    }

    @TargetApi(14)
    public final void zzxs() {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar == null) {
            return;
        }
        TextView textView = new TextView(zzbcoVar.getContext());
        String valueOf = String.valueOf(this.f.zzxg());
        textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.b.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.b.bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzxl() {
        this.d.b();
        zzaxi.zzdvv.post(new ih(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzhd() {
        if (this.f != null && this.l == 0) {
            a("canplaythrough", "duration", String.valueOf(r0.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.f.getVideoWidth()), "videoHeight", String.valueOf(this.f.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzxm() {
        if (this.f2855a.zzyd() != null && !this.h) {
            this.i = (this.f2855a.zzyd().getWindow().getAttributes().flags & 128) != 0;
            if (!this.i) {
                this.f2855a.zzyd().getWindow().addFlags(128);
                this.h = true;
            }
        }
        this.g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void onPaused() {
        a("pause", new String[0]);
        c();
        this.g = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzxn() {
        a("ended", new String[0]);
        c();
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzl(String str, String str2) {
        a("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzxo() {
        if (this.q && this.o != null && !b()) {
            this.p.setImageBitmap(this.o);
            this.p.invalidate();
            this.b.addView(this.p, new FrameLayout.LayoutParams(-1, -1));
            this.b.bringChildToFront(this.p);
        }
        this.d.a();
        this.l = this.k;
        zzaxi.zzdvv.post(new ii(this));
    }

    public final void destroy() {
        this.d.a();
        zzbco zzbcoVar = this.f;
        if (zzbcoVar != null) {
            zzbcoVar.stop();
        }
        c();
    }

    public final void finalize() throws Throwable {
        try {
            this.d.a();
            if (this.f != null) {
                zzbco zzbcoVar = this.f;
                Executor executor = zzbbm.zzeae;
                zzbcoVar.getClass();
                executor.execute(Cif.a(zzbcoVar));
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        zzbco zzbcoVar = this.f;
        if (zzbcoVar == null) {
            return;
        }
        long currentPosition = zzbcoVar.getCurrentPosition();
        if (this.k == currentPosition || currentPosition <= 0) {
            return;
        }
        a("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
        this.k = currentPosition;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzxp() {
        if (this.g && b()) {
            this.b.removeView(this.p);
        }
        if (this.o != null) {
            long elapsedRealtime = zzk.zzln().elapsedRealtime();
            if (this.f.getBitmap(this.o) != null) {
                this.q = true;
            }
            long elapsedRealtime2 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
            if (zzawz.zzvj()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzawz.zzds(sb.toString());
            }
            if (elapsedRealtime2 > this.e) {
                zzawz.zzep("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.j = false;
                this.o = null;
                zzadi zzadiVar = this.c;
                if (zzadiVar != null) {
                    zzadiVar.zzh("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzk(int i, int i2) {
        if (this.j) {
            int max = Math.max(i / ((Integer) zzyt.zzpe().zzd(zzacu.zzcmg)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzyt.zzpe().zzd(zzacu.zzcmg)).intValue(), 1);
            Bitmap bitmap = this.o;
            if (bitmap != null && bitmap.getWidth() == max && this.o.getHeight() == max2) {
                return;
            }
            this.o = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
            this.q = false;
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.d.b();
        } else {
            this.d.a();
            this.l = this.k;
        }
        zzaxi.zzdvv.post(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.ig

            /* renamed from: a, reason: collision with root package name */
            private final zzbcq f2239a;
            private final boolean b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2239a = this;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2239a.a(this.b);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbcn
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.d.b();
            z = true;
        } else {
            this.d.a();
            this.l = this.k;
            z = false;
        }
        zzaxi.zzdvv.post(new ij(this, z));
    }

    private final boolean b() {
        return this.p.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.f2855a.zza("onVideoEvent", hashMap);
    }

    private final void c() {
        if (this.f2855a.zzyd() == null || !this.h || this.i) {
            return;
        }
        this.f2855a.zzyd().getWindow().clearFlags(128);
        this.h = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z) {
        a("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to check method usage
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.MethodNode.getTopParentClass()" because "m" is null
    	at jadx.core.codegen.ClassGen.lambda$skipMethod$4(ClassGen.java:360)
    	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:361)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:327)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
     */
    public static /* synthetic */ void a(zzbcq zzbcqVar, String str, String[] strArr) {
        zzbcqVar.a(str, strArr);
    }
}
