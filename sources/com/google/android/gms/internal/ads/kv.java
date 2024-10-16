package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* loaded from: classes2.dex */
final class kv implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JsResult f2303a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kv(JsResult jsResult) {
        this.f2303a = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f2303a.cancel();
    }
}
