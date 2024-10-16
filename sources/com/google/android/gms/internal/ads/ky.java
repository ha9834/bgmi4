package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* loaded from: classes2.dex */
final class ky implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f2306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ky(JsPromptResult jsPromptResult) {
        this.f2306a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f2306a.cancel();
    }
}
