package com.google.android.vending.licensing;

import android.content.SharedPreferences;
import android.util.Log;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f5388a;
    private final h b;
    private SharedPreferences.Editor c = null;

    public j(SharedPreferences sharedPreferences, h hVar) {
        this.f5388a = sharedPreferences;
        this.b = hVar;
    }

    public void a(String str, String str2) {
        if (this.c == null) {
            this.c = this.f5388a.edit();
        }
        this.c.putString(str, this.b.a(str2, str));
    }

    public String b(String str, String str2) {
        String string = this.f5388a.getString(str, null);
        if (string == null) {
            return str2;
        }
        try {
            return this.b.b(string, str);
        } catch (ValidationException unused) {
            Log.w("PreferenceObfuscator", "Validation error while reading preference: " + str);
            return str2;
        }
    }

    public void a() {
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.commit();
            this.c = null;
        }
    }
}
