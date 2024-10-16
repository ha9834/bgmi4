package com.huawei.game.gamekit.a;

/* loaded from: classes2.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    private static c f5464a;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f5464a == null) {
                f5464a = new c();
            }
            cVar = f5464a;
        }
        return cVar;
    }

    @Override // com.huawei.game.gamekit.a.e
    public final String a(String str, String str2) {
        return str2;
    }
}
