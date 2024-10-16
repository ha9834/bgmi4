package com.gamesafe.ano;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.security.CertificateUtil;
import com.gamesafe.ano.g;

/* loaded from: classes.dex */
public class l implements g {
    private Context b;
    private String c;
    private String d;
    private String e;
    private g.a f;

    /* renamed from: a, reason: collision with root package name */
    AlertDialog f1100a = null;
    private DialogInterface.OnDismissListener g = new m(this);

    public l(Context context, String str, String str2, String str3, g.a aVar) {
        this.b = context;
        this.d = str;
        this.c = str2;
        this.e = str3;
        this.f = aVar;
    }

    private int a(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private Drawable a(Context context, String str, boolean z) {
        PackageManager packageManager = context.getPackageManager();
        try {
            Drawable loadIcon = packageManager.getPackageInfo(str, 0).applicationInfo.loadIcon(packageManager);
            if (z) {
                a(context, loadIcon);
            }
            return loadIcon;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private void a(Context context, Drawable drawable) {
        if (drawable != null) {
            int a2 = a(context, 36);
            drawable.setBounds(0, 0, a2, a2);
        }
    }

    private void a(TextView textView) {
        int a2 = a(this.b, 10);
        int a3 = a(this.b, 6);
        int a4 = a(this.b, 10);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(2, 18.0f);
        textView.setBackgroundColor(Color.parseColor("#000000"));
        textView.setPadding(a2, a3, a2, a4);
    }

    private View d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a2 = a(this.b, 10);
        int i = a2 / 2;
        layoutParams.setMargins(a2, i, a2, i);
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.addView(e());
        linearLayout.addView(f());
        return linearLayout;
    }

    private TextView e() {
        String str;
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(this.b);
        textView.setLayoutParams(layoutParams);
        textView.setText(this.d);
        textView.setGravity(17);
        a(textView);
        String[] split = this.d.split(CertificateUtil.DELIMITER);
        if (split != null && split.length == 3) {
            Drawable a2 = a(this.b, split[1], true);
            if (a2 != null) {
                textView.setCompoundDrawables(a2, null, null, null);
                str = "  " + split[2];
            } else {
                str = split[2];
            }
            textView.setText(str);
        }
        return textView;
    }

    private TextView f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(this.b);
        textView.setLayoutParams(layoutParams);
        textView.setText(this.c);
        a(textView);
        return textView;
    }

    @Override // com.gamesafe.ano.g
    public void a() {
        TextView textView;
        AlertDialog.Builder builder = Build.VERSION.SDK_INT >= 11 ? new AlertDialog.Builder(this.b, 1) : new AlertDialog.Builder(this.b);
        builder.setCancelable(false);
        String str = this.d;
        if (str == null || !str.startsWith("ICON:")) {
            TextView textView2 = new TextView(this.b);
            textView2.setText(this.c);
            a(textView2);
            textView = textView2;
        } else {
            textView = d();
        }
        builder.setView(textView);
        builder.setNeutralButton(this.e, (DialogInterface.OnClickListener) null);
        this.f1100a = builder.create();
        this.f1100a.setOnDismissListener(this.g);
        this.f1100a.setOnShowListener(new n(this));
        this.f1100a.show();
        b();
    }

    protected void b() {
        AlertDialog alertDialog;
        float f;
        float f2;
        if (this.b == null || (alertDialog = this.f1100a) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = alertDialog.getWindow().getAttributes();
        Display defaultDisplay = ((WindowManager) this.b.getSystemService(a.a("rdiyjr"))).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (point.y > point.x) {
            f = point.x;
            f2 = 0.9f;
        } else {
            f = point.x;
            f2 = 0.6f;
        }
        attributes.width = (int) (f * f2);
        this.f1100a.getWindow().setAttributes(attributes);
        this.f1100a.getWindow().setGravity(17);
        this.f1100a.setCanceledOnTouchOutside(false);
    }

    @Override // com.gamesafe.ano.g
    public void c() {
        AlertDialog alertDialog = this.f1100a;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f1100a = null;
        }
    }
}
