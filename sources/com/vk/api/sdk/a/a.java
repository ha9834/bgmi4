package com.vk.api.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.widget.Toast;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class a {
    public static final Activity a(Context context) {
        boolean z;
        h.b(context, "<this>");
        while (true) {
            z = context instanceof Activity;
            if (z || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
            h.a((Object) context, "context.baseContext");
        }
        if (z) {
            return (Activity) context;
        }
        return null;
    }

    public static final void a(Context context, int i) {
        h.b(context, "<this>");
        Toast.makeText(context, i, 0).show();
    }
}
