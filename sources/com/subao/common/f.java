package com.subao.common;

/* loaded from: classes2.dex */
public interface f {
    void a(int i, String str, int i2);

    void a(String str, String str2);

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static f f6017a;

        public static synchronized f a() {
            f fVar;
            synchronized (a.class) {
                fVar = f6017a;
            }
            return fVar;
        }

        public static synchronized void a(f fVar) {
            synchronized (a.class) {
                f6017a = fVar;
            }
        }
    }
}
