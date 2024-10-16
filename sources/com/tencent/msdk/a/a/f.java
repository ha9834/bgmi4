package com.tencent.msdk.a.a;

import android.content.Context;
import android.provider.Settings;

/* loaded from: classes.dex */
public class f extends g {
    public f(Context context) {
        super(context);
    }

    @Override // com.tencent.msdk.a.a.g
    protected void a(String str) {
        synchronized (this) {
            i.a("write mid to Settings.System");
            try {
                Settings.System.putString(this.f6281a.getContentResolver(), f(), str);
            } catch (Throwable th) {
                i.a(th);
            }
        }
    }

    @Override // com.tencent.msdk.a.a.g
    protected boolean a() {
        return i.a(this.f6281a, "android.permission.WRITE_SETTINGS");
    }

    @Override // com.tencent.msdk.a.a.g
    protected String b() {
        String string;
        synchronized (this) {
            i.a("read mid from Settings.System");
            string = Settings.System.getString(this.f6281a.getContentResolver(), f());
        }
        return string;
    }
}
