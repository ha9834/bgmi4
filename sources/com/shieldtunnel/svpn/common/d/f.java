package com.shieldtunnel.svpn.common.d;

import com.shieldtunnel.svpn.XYVpnService;
import com.shieldtunnel.svpn.common.d.e;
import com.shieldtunnel.svpn.common.intf.TunnelEventListener;

/* loaded from: classes2.dex */
class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e.a aVar) {
        XYVpnService.b();
        aVar.a(new h());
        aVar.a(TunnelEventListener.Event.HANG_UP, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e.a aVar, int i, byte[] bArr) {
        TunnelEventListener.Event event;
        XYVpnService.b();
        int i2 = 0;
        boolean z = true;
        if (i == 3) {
            event = TunnelEventListener.Event.NETWORK_CHANGE;
        } else if (i == 4) {
            event = TunnelEventListener.Event.KEEP_ALIVE_FAIL;
        } else if (i != 6) {
            event = TunnelEventListener.Event.EXCEPTION;
        } else {
            event = TunnelEventListener.Event.SERVER_HANG_UP;
            i2 = a(bArr);
            z = false;
        }
        aVar.a(z);
        aVar.a(event, i2, bArr);
    }

    private static int a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            String[] split = com.shieldtunnel.svpn.common.k.e.a(bArr).split(",");
            if (split.length > 1) {
                return com.shieldtunnel.svpn.common.k.e.a(split[1], -1);
            }
        }
        return -1;
    }
}
