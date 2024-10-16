package com.tencent.mid.a;

import android.content.Context;
import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.util.Util;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.mid.util.d f6252a = Util.getLogger();

    private static boolean c(Context context, MidCallback midCallback) {
        return true;
    }

    public static MidEntity a(Context context) {
        return com.tencent.mid.b.g.a(context).h();
    }

    public static void a(Context context, final MidCallback midCallback) {
        f6252a.b("requestMid, callback=" + midCallback);
        b(context, new MidCallback() { // from class: com.tencent.mid.a.g.1
            @Override // com.tencent.mid.api.MidCallback
            public void onSuccess(Object obj) {
                if (obj != null) {
                    MidEntity parse = MidEntity.parse(obj.toString());
                    g.f6252a.h("success to get mid:" + parse.getMid());
                    MidCallback.this.onSuccess(parse.getMid());
                }
            }

            @Override // com.tencent.mid.api.MidCallback
            public void onFail(int i, String str) {
                g.f6252a.f("failed to get mid, errorcode:" + i + " ,msg:" + str);
                MidCallback.this.onFail(i, str);
            }
        });
    }

    public static void b(Context context, MidCallback midCallback) {
        if (c(context, midCallback)) {
            MidEntity a2 = a(context);
            if (a2 != null && a2.isMidValid()) {
                f6252a.b("requestMidEntity -> get local mid entity:" + a2.toString());
                midCallback.onSuccess(a2.toString());
                i.a().a(new h(context, 2, midCallback));
                return;
            }
            f6252a.b("requestMidEntity -> request new mid entity.");
            i.a().a(new h(context, 1, midCallback));
        }
    }

    public static String b(Context context) {
        if (context == null) {
            f6252a.f("context==null in getMid()");
            return null;
        }
        String f = com.tencent.mid.b.g.a(context).f();
        if (!Util.isMidValid(f)) {
            MidCallback midCallback = new MidCallback() { // from class: com.tencent.mid.a.g.2
                @Override // com.tencent.mid.api.MidCallback
                public void onSuccess(Object obj) {
                    if (obj != null) {
                        MidEntity parse = MidEntity.parse(obj.toString());
                        g.f6252a.h("success to get mid:" + parse.getMid());
                    }
                }

                @Override // com.tencent.mid.api.MidCallback
                public void onFail(int i, String str) {
                    g.f6252a.f("failed to get mid, errorcode:" + i + " ,msg:" + str);
                }
            };
            f6252a.h("getMid -> request new mid entity.");
            i.a().a(new h(context, 1, midCallback));
        }
        return f;
    }

    public static long c(Context context) {
        if (context == null) {
            f6252a.f("context==null in getGuid()");
            return 0L;
        }
        return com.tencent.mid.b.g.a(context).g();
    }

    public static String d(Context context) {
        if (context == null) {
            f6252a.f("context==null in getMid()");
            return null;
        }
        return com.tencent.mid.b.g.a(context).f();
    }

    public static boolean a(String str) {
        return Util.isMidValid(str);
    }

    public static void a(boolean z) {
        Util.getLogger().a(z);
    }

    public static boolean a() {
        return Util.getLogger().a();
    }
}
