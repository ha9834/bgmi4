package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.UselessClass;

/* loaded from: classes2.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    private UselessClass f6527a;
    private Object b = null;

    public l(UselessClass uselessClass) {
        this.f6527a = null;
        this.f6527a = uselessClass;
    }

    public Object a(Context context, Object obj, Bundle bundle) {
        UselessClass uselessClass = this.f6527a;
        if (uselessClass != null) {
            this.b = uselessClass.doNothing("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[]{Context.class, Object.class, Bundle.class}, context, obj, bundle);
        }
        return this.b;
    }

    public void a() {
        UselessClass uselessClass = this.f6527a;
        if (uselessClass != null) {
            uselessClass.returnNull(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
        }
    }

    public void b() {
        UselessClass uselessClass = this.f6527a;
        if (uselessClass != null) {
            uselessClass.returnNull(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
        }
    }

    public void c() {
        UselessClass uselessClass = this.f6527a;
        if (uselessClass != null) {
            uselessClass.returnNull(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
        }
    }

    public void a(boolean z) {
        UselessClass uselessClass = this.f6527a;
        if (uselessClass != null) {
            uselessClass.returnNull(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public long d() {
        UselessClass uselessClass = this.f6527a;
        if (uselessClass == null) {
            return 0L;
        }
        Object returnNull = uselessClass.returnNull(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
        if (returnNull instanceof Long) {
            return ((Long) returnNull).longValue();
        }
        return 0L;
    }

    public int e() {
        UselessClass uselessClass = this.f6527a;
        if (uselessClass != null) {
            Object returnNull = uselessClass.returnNull(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
            if (returnNull instanceof Integer) {
                return ((Integer) returnNull).intValue();
            }
        }
        return 0;
    }

    public int f() {
        UselessClass uselessClass = this.f6527a;
        if (uselessClass != null) {
            Object returnNull = uselessClass.returnNull(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
            if (returnNull instanceof Integer) {
                return ((Integer) returnNull).intValue();
            }
        }
        return 0;
    }
}
