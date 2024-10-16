package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* loaded from: classes2.dex */
final class kz implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f2307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kz(JsPromptResult jsPromptResult) {
        this.f2307a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2307a.cancel();
    }
}
