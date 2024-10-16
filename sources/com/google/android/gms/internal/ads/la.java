package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* loaded from: classes2.dex */
final class la implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f2308a;
    private final /* synthetic */ EditText b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public la(JsPromptResult jsPromptResult, EditText editText) {
        this.f2308a = jsPromptResult;
        this.b = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2308a.confirm(this.b.getText().toString());
    }
}
