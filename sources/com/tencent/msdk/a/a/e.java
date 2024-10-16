package com.tencent.msdk.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
class e extends g {
    public e(Context context) {
        super(context);
    }

    @Override // com.tencent.msdk.a.a.g
    protected void a(String str) {
        synchronized (this) {
            i.a("write mid to sharedPreferences");
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f6281a).edit();
            edit.putString(f(), str);
            edit.commit();
        }
    }

    @Override // com.tencent.msdk.a.a.g
    protected boolean a() {
        return true;
    }

    @Override // com.tencent.msdk.a.a.g
    protected String b() {
        String string;
        synchronized (this) {
            i.a("read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.f6281a).getString(f(), null);
        }
        return string;
    }
}
