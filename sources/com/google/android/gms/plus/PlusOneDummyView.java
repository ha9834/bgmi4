package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;

@Deprecated
/* loaded from: classes2.dex */
public class PlusOneDummyView extends FrameLayout {

    @Deprecated
    public static final String TAG = "PlusOneDummyView";

    /* loaded from: classes2.dex */
    private static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        private Context f5041a;

        private a(Context context) {
            this.f5041a = context;
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public final Drawable a(int i) {
            return this.f5041a.getResources().getDrawable(android.R.drawable.btn_default);
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public final boolean a() {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private Context f5042a;

        private b(Context context) {
            this.f5042a = context;
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public final Drawable a(int i) {
            String str;
            try {
                Resources resources = this.f5042a.createPackageContext("com.google.android.gms", 4).getResources();
                switch (i) {
                    case 0:
                        str = "ic_plusone_small";
                        break;
                    case 1:
                        str = "ic_plusone_medium";
                        break;
                    case 2:
                        str = "ic_plusone_tall";
                        break;
                    default:
                        str = "ic_plusone_standard";
                        break;
                }
                return resources.getDrawable(resources.getIdentifier(str, "drawable", "com.google.android.gms"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public final boolean a() {
            try {
                this.f5042a.createPackageContext("com.google.android.gms", 4).getResources();
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class c implements d {

        /* renamed from: a, reason: collision with root package name */
        private Context f5043a;

        private c(Context context) {
            this.f5043a = context;
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public final Drawable a(int i) {
            String str;
            switch (i) {
                case 0:
                    str = "ic_plusone_small_off_client";
                    break;
                case 1:
                    str = "ic_plusone_medium_off_client";
                    break;
                case 2:
                    str = "ic_plusone_tall_off_client";
                    break;
                default:
                    str = "ic_plusone_standard_off_client";
                    break;
            }
            return this.f5043a.getResources().getDrawable(this.f5043a.getResources().getIdentifier(str, "drawable", this.f5043a.getPackageName()));
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.d
        public final boolean a() {
            return (this.f5043a.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.f5043a.getPackageName()) == 0 || this.f5043a.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.f5043a.getPackageName()) == 0 || this.f5043a.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.f5043a.getPackageName()) == 0 || this.f5043a.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.f5043a.getPackageName()) == 0) ? false : true;
        }
    }

    /* loaded from: classes2.dex */
    private interface d {
        Drawable a(int i);

        boolean a();
    }

    @Deprecated
    public PlusOneDummyView(Context context, int i) {
        super(context);
        Button button = new Button(context);
        button.setEnabled(false);
        d bVar = new b(getContext());
        bVar = bVar.a() ? bVar : new c(getContext());
        button.setBackgroundDrawable((bVar.a() ? bVar : new a(getContext())).a(i));
        Point point = new Point();
        int i2 = 20;
        int i3 = 24;
        switch (i) {
            case 0:
                i2 = 14;
                break;
            case 1:
                i3 = 32;
                break;
            case 2:
                i3 = 50;
                break;
            default:
                i2 = 24;
                i3 = 38;
                break;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, i3, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, i2, displayMetrics);
        double d2 = applyDimension;
        Double.isNaN(d2);
        point.x = (int) (d2 + 0.5d);
        double d3 = applyDimension2;
        Double.isNaN(d3);
        point.y = (int) (d3 + 0.5d);
        addView(button, new FrameLayout.LayoutParams(point.x, point.y, 17));
    }
}
