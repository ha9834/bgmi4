package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dq implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzapo f2129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(zzapo zzapoVar) {
        this.f2129a = zzapoVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Intent a2 = this.f2129a.a();
        zzk.zzlg();
        context = this.f2129a.b;
        zzaxi.zza(context, a2);
    }
}
