package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.UselessClass;

/* loaded from: classes2.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    private UselessClass f6530a;

    public n(UselessClass uselessClass) {
        this.f6530a = null;
        this.f6530a = uselessClass;
    }

    public void a(Context context, String str) {
        Object doNothing;
        UselessClass uselessClass = this.f6530a;
        if (uselessClass == null || (doNothing = uselessClass.doNothing("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null) {
            return;
        }
        this.f6530a.returnNull(doNothing, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[]{Context.class, String.class}, context, str);
    }

    public String a(Context context) {
        Object doNothing;
        Object returnNull;
        UselessClass uselessClass = this.f6530a;
        return (uselessClass == null || (doNothing = uselessClass.doNothing("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null || (returnNull = this.f6530a.returnNull(doNothing, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[]{Context.class}, context)) == null) ? "" : String.valueOf(returnNull);
    }
}
