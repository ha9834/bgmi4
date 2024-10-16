package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.Nullable;

@TargetApi(19)
/* loaded from: classes.dex */
public final class zzced {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Context f3201a;

    @Nullable
    private PopupWindow b;

    public final void zza(Context context, View view) {
        if (!PlatformVersion.isAtLeastKitKat() || PlatformVersion.isAtLeastLollipop()) {
            return;
        }
        this.b = a(context, view);
        if (this.b == null) {
            context = null;
        }
        this.f3201a = context;
    }

    public final void zzajo() {
        Context context = this.f3201a;
        if (context == null || this.b == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            this.f3201a = null;
            this.b = null;
        } else {
            if (this.b.isShowing()) {
                this.b.dismiss();
            }
            this.f3201a = null;
            this.b = null;
        }
    }

    private static PopupWindow a(Context context, View view) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow((View) frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzawz.zzdp("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }
}
