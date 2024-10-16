package com.tencent.mid.b;

import android.content.Context;
import com.tencent.mid.util.Util;

/* loaded from: classes.dex */
public class e extends f {

    /* renamed from: a, reason: collision with root package name */
    protected static com.tencent.mid.util.d f6262a = Util.getLogger();

    @Override // com.tencent.mid.b.f
    public int a() {
        return 1;
    }

    public e(Context context, int i) {
        super(context, i);
    }

    @Override // com.tencent.mid.b.f
    protected boolean b() {
        return Util.checkPermission(this.c, "android.permission.WRITE_SETTINGS");
    }

    @Override // com.tencent.mid.b.f
    protected String c() {
        String a2;
        synchronized (this) {
            f6262a.b("read mid from Settings.System");
            a2 = com.tencent.mid.util.g.a(this.c).a(h());
        }
        return a2;
    }

    @Override // com.tencent.mid.b.f
    protected void a(String str) {
        synchronized (this) {
            f6262a.b("write mid to Settings.System");
            com.tencent.mid.util.g.a(this.c).a(h(), str);
        }
    }

    @Override // com.tencent.mid.b.f
    protected a d() {
        a aVar;
        synchronized (this) {
            aVar = new a(com.tencent.mid.util.g.a(this.c).a(g()));
            f6262a.b("read readCheckEntity from Settings.System:" + aVar.toString());
        }
        return aVar;
    }

    @Override // com.tencent.mid.b.f
    protected void a(a aVar) {
        synchronized (this) {
            f6262a.b("write CheckEntity to Settings.System:" + aVar.toString());
            com.tencent.mid.util.g.a(this.c).a(g(), aVar.toString());
        }
    }
}
