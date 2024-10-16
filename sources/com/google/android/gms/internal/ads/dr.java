package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* loaded from: classes2.dex */
final class dr implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzapo f2130a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(zzapo zzapoVar) {
        this.f2130a = zzapoVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2130a.zzdh("Operation denied by user.");
    }
}
