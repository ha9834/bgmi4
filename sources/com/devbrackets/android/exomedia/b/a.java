package com.devbrackets.android.exomedia.b;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected static final List<C0071a> f1000a = new LinkedList();

    static {
        f1000a.add(new C0071a("Amazon"));
    }

    public boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 16 || a(f1000a)) {
            return Build.MANUFACTURER.equalsIgnoreCase("Amazon") && (b(context) || Build.VERSION.SDK_INT >= 21);
        }
        return true;
    }

    public boolean a(List<C0071a> list) {
        for (C0071a c0071a : list) {
            if (Build.MANUFACTURER.equalsIgnoreCase(c0071a.c()) && (c0071a.a() || Build.DEVICE.equalsIgnoreCase(c0071a.b()))) {
                return true;
            }
        }
        return false;
    }

    public boolean b(Context context) {
        UiModeManager uiModeManager;
        return Build.VERSION.SDK_INT >= 21 && (uiModeManager = (UiModeManager) context.getSystemService("uimode")) != null && uiModeManager.getCurrentModeType() == 4;
    }

    /* renamed from: com.devbrackets.android.exomedia.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0071a {
        private final String c;
        private final String b = null;

        /* renamed from: a, reason: collision with root package name */
        private boolean f1001a = true;

        public C0071a(String str) {
            this.c = str;
        }

        public boolean a() {
            return this.f1001a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }
    }
}
