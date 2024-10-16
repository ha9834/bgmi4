package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@TargetApi(28)
/* loaded from: classes.dex */
public final class zzaxy extends zzaxx {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void zzg(final Activity activity) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcph)).booleanValue() && zzk.zzlk().zzvc().zzvx() == null && !activity.isInMultiWindowMode()) {
            a(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this, activity) { // from class: com.google.android.gms.internal.ads.fu

                /* renamed from: a, reason: collision with root package name */
                private final zzaxy f2180a;
                private final Activity b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2180a = this;
                    this.b = activity;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return zzaxy.a(this.b, view, windowInsets);
                }
            });
        }
    }

    private static void a(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = attributes.layoutInDisplayCutoutMode;
        int i2 = z ? 1 : 2;
        if (i2 != i) {
            attributes.layoutInDisplayCutoutMode = i2;
            window.setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsets a(Activity activity, View view, WindowInsets windowInsets) {
        if (zzk.zzlk().zzvc().zzvx() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                zzaxb zzvc = zzk.zzlk().zzvc();
                String str = "";
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat("|");
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                zzvc.zzdw(str);
            } else {
                zzk.zzlk().zzvc().zzdw("");
            }
        }
        a(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }
}
