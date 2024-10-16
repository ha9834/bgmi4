package com.tencent.smtt.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.UselessClass;

/* loaded from: classes2.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    protected UselessClass f6532a;

    public q(UselessClass uselessClass) {
        this.f6532a = null;
        this.f6532a = uselessClass;
    }

    public boolean a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        Object returnNull;
        if (obj2 != null) {
            returnNull = this.f6532a.returnNull(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class, Object.class}, bundle, frameLayout, obj2);
        } else {
            returnNull = this.f6532a.returnNull(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        }
        if (returnNull instanceof Boolean) {
            return ((Boolean) returnNull).booleanValue();
        }
        return false;
    }

    public void a(Object obj, Activity activity, int i) {
        this.f6532a.returnNull(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
    }

    public void a(Object obj) {
        this.f6532a.returnNull(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
    }
}
