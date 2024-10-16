package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* loaded from: classes2.dex */
final class du implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzapu f2133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(zzapu zzapuVar) {
        this.f2133a = zzapuVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2133a.zzdh("User canceled the download.");
    }
}
