package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* loaded from: classes2.dex */
final class kx implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JsResult f2305a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kx(JsResult jsResult) {
        this.f2305a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2305a.confirm();
    }
}
