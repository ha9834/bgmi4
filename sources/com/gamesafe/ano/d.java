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
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.internal.security.CertificateUtil;
import com.gamesafe.ano.g;
import java.util.Locale;

/* loaded from: classes.dex */
public class d implements g {
    private Context b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int h;
    private g.a i;

    /* renamed from: a, reason: collision with root package name */
    AlertDialog f1094a = null;
    private DialogInterface.OnDismissListener j = new e(this);

    public d(Context context, String str, String str2, String str3, int i, int i2, g.a aVar) {
        this.b = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = i;
        this.g = i2;
        this.i = aVar;
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

    private TextView a(String str) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(this.b);
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        a(textView);
        return textView;
    }

    private void a(Context context, Drawable drawable) {
        if (drawable != null) {
            int a2 = a(context, 36);
            drawable.setBounds(0, 0, a2, a2);
        }
    }

    private void a(SeekBar seekBar) {
        int a2 = a(this.b, 20);
        int a3 = a(this.b, 1);
        int a4 = a(this.b, 5);
        seekBar.setBackgroundColor(Color.parseColor("#000000"));
        seekBar.setPadding(a2, a3, a2, a4);
    }

    private void a(TextView textView) {
        int a2 = a(this.b, 20);
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
        textView.setText(this.c);
        textView.setGravity(17);
        a(textView);
        String[] split = this.c.split(CertificateUtil.DELIMITER);
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

    private View f() {
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setOrientation(1);
        linearLayout.addView(a(this.d));
        TextView a2 = a(String.format(Locale.ENGLISH, "%s%d", this.e, 0));
        SeekBar seekBar = new SeekBar(this.b);
        seekBar.setMax(this.f);
        seekBar.setKeyProgressIncrement(1);
        a(seekBar);
        seekBar.setOnSeekBarChangeListener(new f(this, a2));
        linearLayout.addView(seekBar);
        linearLayout.addView(a2);
        return linearLayout;
    }

    @Override // com.gamesafe.ano.g
    public void a() {
        if (this.d == null || this.e == null || this.f < this.g) {
            return;
        }
        AlertDialog.Builder builder = Build.VERSION.SDK_INT >= 11 ? new AlertDialog.Builder(this.b, 1) : new AlertDialog.Builder(this.b);
        builder.setCancelable(false);
        builder.setView(d());
        this.f1094a = builder.create();
        this.f1094a.setOnDismissListener(this.j);
        this.f1094a.show();
        b();
    }

    protected void b() {
        AlertDialog alertDialog;
        float f;
        float f2;
        if (this.b == null || (alertDialog = this.f1094a) == null) {
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
        this.f1094a.getWindow().setAttributes(attributes);
        this.f1094a.getWindow().setGravity(17);
        this.f1094a.setCanceledOnTouchOutside(false);
    }

    @Override // com.gamesafe.ano.g
    public void c() {
        AlertDialog alertDialog = this.f1094a;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f1094a = null;
        }
    }
}
