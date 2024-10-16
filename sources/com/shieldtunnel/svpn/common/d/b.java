package com.shieldtunnel.svpn.common.d;

import com.shieldtunnel.svpn.common.d.a;
import com.shieldtunnel.svpn.common.intf.NodeDetectCallback;
import com.shieldtunnel.svpn.common.intf.NodeInfo;
import com.shieldtunnel.svpn.common.intf.TunnelEventListener;
import com.shieldtunnel.svpn.common.intf.VPNStateListener;
import java.util.List;

/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5780a;

    public b(boolean z) {
        this.f5780a = z;
    }

    private int f() {
        return this.f5780a ? 1013 : 1000;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, String str2, String str3) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int b(List<String> list) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public String b() {
        return "";
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int c() {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int d() {
        return this.f5780a ? 1013 : 0;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int e() {
        return 0;
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, a.EnumC0148a enumC0148a) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a() {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(TunnelEventListener tunnelEventListener) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(int i, int i2) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(List<NodeInfo> list) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, NodeDetectCallback nodeDetectCallback) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(VPNStateListener vPNStateListener) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, Object obj) {
        return f();
    }

    @Override // com.shieldtunnel.svpn.common.d.a
    public int a(String str, String str2) {
        return f();
    }
}
