package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* loaded from: classes.dex */
final class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f1591a;
    private final /* synthetic */ Intent b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, Intent intent) {
        this.f1591a = context;
        this.b = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f1591a.startActivity(this.b);
        } catch (ActivityNotFoundException e) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
