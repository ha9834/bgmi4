package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.UselessClass;

/* loaded from: classes2.dex */
public class TbsMediaFactory {

    /* renamed from: a, reason: collision with root package name */
    private Context f6470a;
    private p b = null;
    private UselessClass c = null;

    public TbsMediaFactory(Context context) {
        this.f6470a = null;
        this.f6470a = context.getApplicationContext();
        a();
    }

    private void a() {
        if (this.f6470a == null) {
            Log.e("TbsVideo", "TbsVideo needs context !!");
            return;
        }
        if (this.b == null) {
            c.a(true).a(this.f6470a, false, false, null);
            this.b = c.a(true).a();
            p pVar = this.b;
            if (pVar != null) {
                this.c = pVar.a();
            }
        }
        if (this.b == null || this.c == null) {
            throw new RuntimeException("tbs core dex(s) load failure !!!");
        }
    }

    public TbsMediaPlayer createPlayer() {
        UselessClass uselessClass;
        if (this.b == null || (uselessClass = this.c) == null) {
            throw new RuntimeException("tbs core dex(s) did not loaded !!!");
        }
        return new TbsMediaPlayer(new k(uselessClass, this.f6470a));
    }
}
