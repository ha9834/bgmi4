package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzayb {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2827a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private PointF h;
    private PointF i;
    private Handler j;
    private Runnable k;

    public zzayb(Context context) {
        this.f = 0;
        this.k = new Runnable(this) { // from class: com.google.android.gms.internal.ads.fv

            /* renamed from: a, reason: collision with root package name */
            private final zzayb f2181a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2181a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2181a.c();
            }
        };
        this.f2827a = context;
        this.g = ViewConfiguration.get(context).getScaledTouchSlop();
        zzk.zzlu().zzwr();
        this.j = zzk.zzlu().getHandler();
    }

    public zzayb(Context context, String str) {
        this(context);
        this.b = str;
    }

    public final void zzd(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.f = 0;
            this.h = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.f;
        if (i == -1) {
            return;
        }
        boolean z = true;
        if (i == 0 && actionMasked == 5) {
            this.f = 5;
            this.i = new PointF(motionEvent.getX(1), motionEvent.getY(1));
            this.j.postDelayed(this.k, ((Long) zzyt.zzpe().zzd(zzacu.zzcua)).longValue());
            return;
        }
        if (this.f == 5) {
            if (pointerCount == 2) {
                if (actionMasked == 2) {
                    boolean z2 = false;
                    for (int i2 = 0; i2 < historySize; i2++) {
                        if (!a(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2))) {
                            z2 = true;
                        }
                    }
                    if (a(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                        z = z2;
                    }
                } else {
                    z = false;
                }
            }
            if (z) {
                this.f = -1;
                this.j.removeCallbacks(this.k);
            }
        }
    }

    private final boolean a(float f, float f2, float f3, float f4) {
        return Math.abs(this.h.x - f) < ((float) this.g) && Math.abs(this.h.y - f2) < ((float) this.g) && Math.abs(this.i.x - f3) < ((float) this.g) && Math.abs(this.i.y - f4) < ((float) this.g);
    }

    public final void showDialog() {
        try {
            if (!(this.f2827a instanceof Activity)) {
                zzawz.zzeo("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(zzk.zzlq().zzwn()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = zzk.zzlq().zzwo() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            final int a2 = a((List<String>) arrayList, "Ad Information", true);
            final int a3 = a((List<String>) arrayList, str, true);
            final int a4 = a((List<String>) arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f2827a, zzk.zzli().zzwi());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(this, a2, a3, a4) { // from class: com.google.android.gms.internal.ads.fw

                /* renamed from: a, reason: collision with root package name */
                private final zzayb f2182a;
                private final int b;
                private final int c;
                private final int d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2182a = this;
                    this.b = a2;
                    this.c = a3;
                    this.d = a4;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f2182a.a(this.b, this.c, this.d, dialogInterface, i);
                }
            });
            builder.create().show();
        } catch (WindowManager.BadTokenException e) {
            zzawz.zza("", e);
        }
    }

    public final void setAdUnitId(String str) {
        this.c = str;
    }

    public final void zzp(String str) {
        this.d = str;
    }

    public final void zzee(String str) {
        this.b = str;
    }

    public final void zzef(String str) {
        this.e = str;
    }

    private static int a(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.b);
        sb.append(",DebugSignal: ");
        sb.append(this.e);
        sb.append(",AFMA Version: ");
        sb.append(this.d);
        sb.append(",Ad Unit ID: ");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        zzk.zzlq().zza(this.f2827a, this.c, this.d, this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        zzk.zzlq().zze(this.f2827a, this.c, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str, DialogInterface dialogInterface, int i) {
        zzk.zzlg();
        zzaxi.zza(this.f2827a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void a(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L9b
            android.content.Context r1 = r0.f2827a
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto Le
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.ads.zzawz.zzeo(r1)
            return
        Le:
            java.lang.String r1 = r0.b
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.zzk.zzlg()
            java.util.Map r1 = com.google.android.gms.internal.ads.zzaxi.zzi(r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L3f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L62
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L3f
        L62:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            goto L73
        L71:
            java.lang.String r1 = "No debug information"
        L73:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.f2827a
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            java.lang.String r3 = "Share"
            com.google.android.gms.internal.ads.fx r4 = new com.google.android.gms.internal.ads.fx
            r4.<init>(r0, r1)
            r2.setPositiveButton(r3, r4)
            java.lang.String r1 = "Close"
            android.content.DialogInterface$OnClickListener r3 = com.google.android.gms.internal.ads.fy.f2184a
            r2.setNegativeButton(r1, r3)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            return
        L9b:
            if (r5 != r2) goto Lab
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.internal.ads.zzawz.zzdp(r1)
            com.google.android.gms.internal.ads.fz r1 = new com.google.android.gms.internal.ads.fz
            r1.<init>(r0)
            com.google.android.gms.internal.ads.zzaxg.zzc(r1)
            return
        Lab:
            if (r5 != r3) goto Lba
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.internal.ads.zzawz.zzdp(r1)
            com.google.android.gms.internal.ads.ga r1 = new com.google.android.gms.internal.ads.ga
            r1.<init>(r0)
            com.google.android.gms.internal.ads.zzaxg.zzc(r1)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayb.a(int, int, int, android.content.DialogInterface, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.f = 4;
        showDialog();
    }
}
