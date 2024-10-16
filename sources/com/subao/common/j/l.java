package com.subao.common.j;

/* loaded from: classes2.dex */
public interface l {
    a a();

    boolean b();

    boolean c();

    boolean d();

    /* loaded from: classes2.dex */
    public enum a {
        DISCONNECT(-1),
        UNKNOWN(0),
        WIFI(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        MOBILE_4G(4);

        public final int g;

        a(int i) {
            this.g = i;
        }
    }
}
