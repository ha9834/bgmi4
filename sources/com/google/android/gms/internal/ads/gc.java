package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
final class gc implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ gb f2189a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(gb gbVar) {
        this.f2189a = gbVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        zzk.zzlg();
        zzaxi.zza(this.f2189a.f2188a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
