package com.tencent.mid.local;

import android.content.Context;
import android.provider.Settings;

/* loaded from: classes.dex */
public class f extends g {
    public f(Context context) {
        super(context);
    }

    @Override // com.tencent.mid.local.g
    protected boolean a() {
        return i.a(this.f6266a, "android.permission.WRITE_SETTINGS");
    }

    @Override // com.tencent.mid.local.g
    protected String b() {
        String string;
        synchronized (this) {
            i.a("read mid from Settings.System");
            string = Settings.System.getString(this.f6266a.getContentResolver(), e());
        }
        return string;
    }
}
