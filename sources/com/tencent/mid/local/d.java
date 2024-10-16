package com.tencent.mid.local;

import android.content.Context;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
class d extends g {
    public d(Context context) {
        super(context);
    }

    @Override // com.tencent.mid.local.g
    protected boolean a() {
        return true;
    }

    @Override // com.tencent.mid.local.g
    protected String b() {
        String string;
        synchronized (this) {
            i.a("read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.f6266a).getString(e(), null);
        }
        return string;
    }
}
