package com.shieldtunnel.svpn.common.d;

import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.shieldtunnel.svpn.XYVpnService;
import com.shieldtunnel.svpn.common.d.e;
import com.shieldtunnel.svpn.common.intf.TunnelEventListener;

/* loaded from: classes2.dex */
public class g implements e {

    /* renamed from: a, reason: collision with root package name */
    private final e.a f5796a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e.a aVar) {
        this.f5796a = aVar;
    }

    private static int b(int i) {
        int i2 = i + 8000;
        return i < 100 ? i2 + 200 : i2;
    }

    private void c(int i) {
        this.f5796a.a(false);
        this.f5796a.a(TunnelEventListener.Event.DIAL_UP_RESULT, i, null);
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public String a() {
        return "Connecting";
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void a(String str) {
        XYVpnService d = XYVpnService.d();
        if (d == null) {
            c(ConnectionsStatusCodes.STATUS_BLUETOOTH_ERROR);
            return;
        }
        k a2 = k.a(str);
        if (a2 == null) {
            c(8006);
            return;
        }
        XYVpnService.b a3 = d.a(a2);
        int i = a3.f5775a;
        if (i != 0) {
            c(i);
            return;
        }
        this.f5796a.a(a3.b);
        e.a aVar = this.f5796a;
        aVar.a(new i(aVar));
        this.f5796a.a(TunnelEventListener.Event.DIAL_UP_RESULT, 0, com.shieldtunnel.svpn.common.k.e.a(String.format(com.shieldtunnel.svpn.common.f.f.b, "{\"nodeId\":%d}", Integer.valueOf(a2.c()))));
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public boolean b() {
        return true;
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public boolean d() {
        return false;
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void c() {
        f.a(this.f5796a);
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void a(int i) {
        this.f5796a.a(new h());
        this.f5796a.a(TunnelEventListener.Event.DIAL_UP_RESULT, b(i), null);
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void a(int i, byte[] bArr) {
        f.a(this.f5796a, i, bArr);
    }
}
