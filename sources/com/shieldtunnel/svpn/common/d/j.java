package com.shieldtunnel.svpn.common.d;

import com.shieldtunnel.svpn.XYVpnService;
import com.shieldtunnel.svpn.common.d.e;
import com.shieldtunnel.svpn.common.intf.TunnelEventListener;

/* loaded from: classes2.dex */
public class j implements e {

    /* renamed from: a, reason: collision with root package name */
    private final e.a f5798a;

    public j(e.a aVar) {
        this.f5798a = aVar;
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public String a() {
        return "HangupPending";
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void a(int i) {
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void a(int i, byte[] bArr) {
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void a(String str) {
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public boolean b() {
        return false;
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void c() {
        this.f5798a.a(new h());
        if (XYVpnService.b()) {
            this.f5798a.a(0);
        }
        this.f5798a.a(TunnelEventListener.Event.HANG_UP, 0, null);
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public boolean d() {
        return false;
    }
}
