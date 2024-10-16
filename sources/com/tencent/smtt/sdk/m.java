package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;

/* loaded from: classes2.dex */
class m {
    private static m e;

    /* renamed from: a, reason: collision with root package name */
    o f6528a;
    Context b;
    com.tencent.tbs.video.interfaces.a c;
    IUserStateChangedListener d;

    public static synchronized m a(Context context) {
        m mVar;
        synchronized (m.class) {
            if (e == null) {
                e = new m(context);
            }
            mVar = e;
        }
        return mVar;
    }

    private m(Context context) {
        this.f6528a = null;
        this.b = context.getApplicationContext();
        this.f6528a = new o(this.b);
    }

    public boolean a(String str, Bundle bundle, com.tencent.tbs.video.interfaces.a aVar) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (aVar != null) {
            this.f6528a.a();
            if (!this.f6528a.b()) {
                return false;
            }
            this.c = aVar;
            this.d = new IUserStateChangedListener() { // from class: com.tencent.smtt.sdk.m.1
                @Override // com.tencent.tbs.video.interfaces.IUserStateChangedListener
                public void onUserStateChanged() {
                    m.this.f6528a.c();
                }
            };
            this.c.a(this.d);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        this.f6528a.a(bundle, aVar == null ? null : this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity, int i) {
        this.f6528a.a(activity, i);
    }

    public boolean a() {
        this.f6528a.a();
        return this.f6528a.b();
    }

    public void a(int i, int i2, Intent intent) {
        com.tencent.tbs.video.interfaces.a aVar = this.c;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }
}
