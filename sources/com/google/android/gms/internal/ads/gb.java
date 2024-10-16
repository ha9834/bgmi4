package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2188a;
    private final /* synthetic */ String b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(zzayi zzayiVar, Context context, String str, boolean z, boolean z2) {
        this.f2188a = context;
        this.b = str;
        this.c = z;
        this.d = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f2188a);
        builder.setMessage(this.b);
        if (this.c) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.d) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new gc(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
