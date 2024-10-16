package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f209a;

    public static a a(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.f209a = context;
    }

    public int a() {
        Configuration configuration = this.f209a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f209a).hasPermanentMenuKey();
    }

    public int c() {
        return this.f209a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        return this.f209a.getResources().getBoolean(a.b.abc_action_bar_embed_tabs);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.f209a.obtainStyledAttributes(null, a.j.ActionBar, a.C0024a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(a.j.ActionBar_height, 0);
        Resources resources = this.f209a.getResources();
        if (!d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(a.d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.f209a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int g() {
        return this.f209a.getResources().getDimensionPixelSize(a.d.abc_action_bar_stacked_tab_max_width);
    }
}
