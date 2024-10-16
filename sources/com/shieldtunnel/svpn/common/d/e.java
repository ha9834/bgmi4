package com.shieldtunnel.svpn.common.d;

import com.shieldtunnel.svpn.common.intf.TunnelEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public interface e {

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i);

        void a(e eVar);

        void a(TunnelEventListener.Event event, int i, byte[] bArr);

        void a(boolean z);
    }

    String a();

    void a(int i);

    void a(int i, byte[] bArr);

    void a(String str);

    boolean b();

    void c();

    boolean d();
}
