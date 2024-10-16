package com.shieldtunnel.svpn.common.d;

import com.shieldtunnel.svpn.common.intf.NodeDetectCallback;
import com.shieldtunnel.svpn.common.intf.NodeInfo;
import com.shieldtunnel.svpn.common.intf.TunnelEventListener;
import com.shieldtunnel.svpn.common.intf.VPNStateListener;
import java.util.List;

/* loaded from: classes2.dex */
public interface a {

    /* renamed from: com.shieldtunnel.svpn.common.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0148a {
        REGION,
        ID_LIST
    }

    int a();

    int a(int i, int i2);

    int a(TunnelEventListener tunnelEventListener);

    int a(VPNStateListener vPNStateListener);

    int a(String str);

    int a(String str, EnumC0148a enumC0148a);

    int a(String str, NodeDetectCallback nodeDetectCallback);

    int a(String str, Object obj);

    int a(String str, String str2);

    int a(String str, String str2, String str3);

    int a(List<NodeInfo> list);

    int b(List<String> list);

    String b();

    int c();

    int d();

    int e();
}
