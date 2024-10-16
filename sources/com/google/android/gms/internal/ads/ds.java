package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
final class ds implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzapr f2131a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(zzapr zzaprVar) {
        this.f2131a = zzaprVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f2131a.zzw(true);
    }
}
