package com.tencent.mid.b;

import android.content.Context;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.util.Util;

/* loaded from: classes.dex */
public abstract class f {
    protected static com.tencent.mid.util.d b = Util.getLogger();
    protected Context c;
    protected int d;

    public abstract int a();

    protected abstract void a(a aVar);

    protected abstract void a(String str);

    protected abstract boolean b();

    protected abstract String c();

    protected abstract a d();

    public String e() {
        if (this.d == 0) {
            return Util.decode("6X8Y4XdM2Vhvn0I=");
        }
        return Util.decode("6X8Y4XdM2Vhvn0I=") + this.d;
    }

    public String f() {
        if (this.d == 0) {
            return Util.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=");
        }
        return Util.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=") + this.d;
    }

    public String g() {
        if (this.d == 0) {
            return Util.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=");
        }
        return Util.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=") + this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String h() {
        if (this.d == 0) {
            return Util.decode("4kU71lN96TJUomD1vOU9lgj9Tw==");
        }
        return Util.decode("4kU71lN96TJUomD1vOU9lgj9Tw==") + this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context, int i) {
        this.c = null;
        this.d = 0;
        this.c = context;
        this.d = i;
    }

    private String k() {
        if (b()) {
            return d(c());
        }
        return null;
    }

    public MidEntity i() {
        String k = k();
        if (k != null) {
            return MidEntity.parse(k);
        }
        return null;
    }

    private void b(String str) {
        if (b()) {
            a(c(str));
        }
    }

    public void a(MidEntity midEntity) {
        if (midEntity == null) {
            return;
        }
        if (a() == 4) {
            com.tencent.mid.api.a.a(this.c).a(midEntity.getMid());
        }
        b(midEntity.toString());
    }

    public a j() {
        if (b()) {
            return d();
        }
        return null;
    }

    public void b(a aVar) {
        if (aVar != null && b()) {
            a(aVar);
        }
    }

    protected String c(String str) {
        return Util.encode(str);
    }

    protected String d(String str) {
        return Util.decode(str);
    }
}
