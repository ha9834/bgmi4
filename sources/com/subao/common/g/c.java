package com.subao.common.g;

import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.subao.common.d;
import com.subao.common.e.r;
import com.subao.common.f;
import com.subao.common.i.m;
import com.subao.common.j.n;
import com.subao.common.k.g;
import com.subao.common.n.h;
import com.subao.common.n.j;
import com.subao.vpn.JniCallback;
import com.subao.vpn.VPNJni;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class c implements com.subao.common.a, f {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f6023a = new byte[0];
    private final List<Integer> b = new ArrayList(16);

    public c(String str) {
        VPNJni.loadLibrary(new b(), str);
    }

    static byte[] a(String str) {
        if (str == null || str.length() == 0) {
            return f6023a;
        }
        return str.getBytes();
    }

    @Override // com.subao.common.a
    public void a() {
        VPNJni.setCallback(new b());
    }

    public JniCallback a(JniCallback jniCallback) {
        return VPNJni.setCallback(jniCallback);
    }

    private static String a(Object obj) {
        if (obj == null) {
            return Constants.NULL_VERSION_ID;
        }
        String obj2 = obj.toString();
        return obj2.length() > 64 ? String.format(r.f6001a, "\"%s\" ... (%d chars)", obj2.substring(0, 60), Integer.valueOf(obj2.length())) : obj2;
    }

    public int b() {
        int scriptBit = VPNJni.getScriptBit(0);
        if (scriptBit == 32) {
            return scriptBit;
        }
        return 64;
    }

    public void a(int i, int i2, String str) {
        if (str == null) {
            str = "";
        }
        VPNJni.httpResponse(i, i2, str);
    }

    public void a(int i, String str, String str2) {
        Log.d("SubaoNet", String.format(r.f6001a, "qosPrepareResult(%d, %s, %s)", Integer.valueOf(i), str, str2));
        VPNJni.qosPrepareResult(i, str, str2);
    }

    public boolean a(String str, int i, a aVar, String str2, byte[] bArr, String str3, String str4, String str5) {
        byte[] bArr2;
        if (d.a("SubaoData")) {
            Log.d("SubaoData", "Init with PCode: " + h.a(bArr));
            Log.d("SubaoData", "NodeList: " + a((Object) str3));
            Log.d("SubaoData", "CIP: " + a((Object) str4));
            Log.d("SubaoData", "GIP: " + a((Object) str5));
        }
        byte[] loadEcode = VPNJni.loadEcode();
        if (loadEcode == null || loadEcode.length == 0) {
            Log.w("SubaoData", "[ec] return null");
            return false;
        }
        try {
            bArr2 = j.a(loadEcode);
        } catch (IOException e) {
            e.printStackTrace();
            bArr2 = null;
        }
        if (bArr2 == null || bArr2.length == 0) {
            Log.w("SubaoData", "[ec] process failed");
            return false;
        }
        boolean init = VPNJni.init(0, a(str), i, aVar.e, a(str2), bArr2, (bArr == null || bArr.length == 0) ? f6023a : bArr, a(str3), a(str4), a(str5));
        if (init && d.a("SubaoProxy")) {
            c();
        }
        return init;
    }

    public final void c() {
        b("log_test = function(str) log_info(str) end");
    }

    public final void b(String str) {
        b(0, "key_inject", str);
    }

    public boolean d() {
        return VPNJni.getProxyIsStart(0);
    }

    public boolean e() {
        return VPNJni.startProxy(0);
    }

    public void f() {
        VPNJni.stopProxy(0);
    }

    public void g() {
        VPNJni.processEvent();
    }

    public void b(int i, String str, String str2) {
        String format;
        if (d.a("SubaoData")) {
            if (str2 == null) {
                format = Constants.NULL_VERSION_ID;
            } else if (str2.length() > 64) {
                format = String.format(r.f6001a, "\"%s ...\" (%d chars)", str2.substring(0, 60), Integer.valueOf(str2.length()));
            } else {
                format = String.format("\"%s\"", str2);
            }
            Log.d("SubaoData", String.format(r.f6001a, "setString(%d, \"%s\", %s)", Integer.valueOf(i), str, format));
        }
        VPNJni.setString(i, str.getBytes(), a(str2));
    }

    public void a(int i, String str, byte[] bArr) {
        if (d.a("SubaoData")) {
            Log.d("SubaoData", String.format(r.f6001a, "setString(%d, \"%s\", %d bytes)", Integer.valueOf(i), str, Integer.valueOf(bArr == null ? 0 : bArr.length)));
        }
        byte[] bytes = str.getBytes();
        if (bArr == null) {
            bArr = f6023a;
        }
        VPNJni.setString(i, bytes, bArr);
    }

    @Override // com.subao.common.f
    public void a(int i, String str, int i2) {
        if (d.a("SubaoData")) {
            Log.d("SubaoData", String.format(r.f6001a, "setInt(%d, \"%s\", %d)", Integer.valueOf(i), str, Integer.valueOf(i2)));
        }
        VPNJni.setInt(i, str.getBytes(), i2);
    }

    public int b(String str, String str2) {
        int i = VPNJni.getInt(0, str, h.a(str2));
        if (d.a("SubaoData")) {
            Log.d("SubaoData", String.format(r.f6001a, "getInt(\"%s\", \"%s\") return: %d", str, h.a((Object) str2), Integer.valueOf(i)));
        }
        return i;
    }

    public void a(int i) {
        VPNJni.setUDPEchoPort(0, i);
    }

    public void a(int i, String str, String str2, String str3) {
        VPNJni.setUserToken(0, i, a(str), a(str2), a(str3));
    }

    public void a(int i, boolean z, int i2, String str, int i3, String str2, int i4, String str3, String str4, int i5, long j, int i6, int i7, String str5, String str6) {
        VPNJni.userAuthResult(i, z, i2, a(str), i3, a(str2), i4, a(str3), a(str4), i5, (int) j, i6, i7, a(str5), a(str6));
    }

    public void a(int i, boolean z, int i2, String str, byte[] bArr, int i3) {
        VPNJni.linkAuthResult(i, z, i2, a(str), bArr, i3);
    }

    public void a(int i, boolean z, int i2, int i3, String str, String str2) {
        VPNJni.userStateResult(i, z, i2, i3, a(str), a(str2));
    }

    public void a(int i, boolean z, int i2, String str) {
        VPNJni.userConfigResult(i, z, i2, a(str));
    }

    public void a(int i, int i2, int i3, g gVar, boolean z) {
        VPNJni.requestMobileFDResult(i, i2, i3, gVar.c, z);
    }

    public void b(int i) {
        VPNJni.onUDPDelay(0, i);
    }

    public void a(float f, float f2) {
        VPNJni.onNetDelayQuality4(0, f, f2);
    }

    public int h() {
        return VPNJni.getAccelRecommendation(0);
    }

    public void a(String str, int i) {
        VPNJni.setRecommendationGameIP(0, a(str), i);
    }

    public void a(String str, String str2, int i) {
        VPNJni.addAccelAddress(0, "tcp".compareToIgnoreCase(str) == 0 ? 2 : 1, str2, i);
    }

    public void i() {
        VPNJni.clearAccelAddresses(0);
    }

    public String c(int i) {
        return VPNJni.getWebUIUrl(0, i);
    }

    public String j() {
        return VPNJni.getWebUIUrl(0, 1000);
    }

    public String k() {
        return VPNJni.getBaseUrl(0);
    }

    public int l() {
        return VPNJni.getAccelerationStatus(0);
    }

    public boolean m() {
        return VPNJni.getSDKUDPIsProxy(0);
    }

    public String n() {
        return VPNJni.getVIPValidTime(0);
    }

    @Override // com.subao.common.f
    public void a(String str, String str2) {
        VPNJni.defineConst(0, a(str), a(str2));
    }

    public void a(byte[] bArr) {
        VPNJni.injectPCode(0, bArr);
    }

    public void a(com.subao.common.i.r rVar, m mVar) {
        b(0, "key_version", rVar.a());
        b(0, "key_channel", rVar.b());
        b(0, "key_os_version", rVar.c());
        b(0, "key_android_version", rVar.d());
        b(0, "key_phone_model", mVar.a());
        b(0, "key_rom", mVar.e());
        a(0, "key_cpu_speed", mVar.b());
        a(0, "key_cpu_core", mVar.c());
        a(0, "key_memory", mVar.d());
    }

    public void a(int i, byte[] bArr) {
        VPNJni.onLoadDataResult(i, bArr);
    }

    public String d(int i) {
        return VPNJni.getAccelRecommendationData(0, i);
    }

    public void a(int i, boolean z) {
        VPNJni.onAccelRecommendationResult(0, i, z);
    }

    public void e(int i) {
        VPNJni.startNodeDetect(0, i);
    }

    public boolean f(int i) {
        return VPNJni.isNodeDetected(0, i);
    }

    private void b(int i, String str, String str2, n nVar, int i2) {
        StringBuilder sb = new StringBuilder(1024);
        sb.append(i);
        sb.append(':');
        sb.append(str);
        sb.append(':');
        sb.append(str2);
        sb.append(':');
        sb.append(nVar.d);
        sb.append(':');
        sb.append(i2);
        b(0, "key_add_game", sb.toString());
    }

    public void a(int i, String str, String str2, n nVar, int i2) {
        b(i, str, str2, nVar, i2);
        if (this.b.contains(Integer.valueOf(i))) {
            return;
        }
        this.b.add(Integer.valueOf(i));
    }

    public boolean g(int i) {
        return VPNJni.doStartVPN(i);
    }

    public void o() {
        VPNJni.doStopVPN();
    }

    public void b(int i, int i2, String str) {
        if (str == null) {
            str = "";
        }
        VPNJni.answerLteInfo(i, i2, str);
    }

    public int p() {
        return VPNJni.getIOThreadID(0);
    }

    public int q() {
        return VPNJni.shouldRemindPurchase();
    }

    public void a(boolean z) {
        a(0, "key_mtk_feature_supported", z ? 1 : 0);
    }

    public void b(int i, boolean z) {
        VPNJni.onMTKAuthResult(i, z);
    }

    public void c(int i, boolean z) {
        VPNJni.onMTKStartMobileAccelResult(i, z);
    }

    public void d(int i, boolean z) {
        VPNJni.onMTKStopMobileAccelResult(i, z);
    }

    public void e(int i, boolean z) {
        VPNJni.onEnableMTKNDPPResult(i, z);
    }

    public void f(int i, boolean z) {
        VPNJni.setIsMTKNDPPEnable(i, z);
    }

    public void g(int i, boolean z) {
        VPNJni.onMTKStartNDPPResult(i, z);
    }

    public void h(int i, boolean z) {
        VPNJni.onMTKUpdateLinkResult(i, z);
    }

    public void i(int i, boolean z) {
        VPNJni.onMTKStopNDPPResult(i, z);
    }

    public void h(int i) {
        Log.i("SubaoData", String.format("onNDPPStateChanged, state = %d", Integer.valueOf(i)));
        VPNJni.onNDPPStateChanged(0, i);
    }

    public void b(String str, String str2, int i) {
        Log.d("SubaoData", String.format("addLobbyAddress, protocol : %s, ip : %s, port: %d", str, str2, Integer.valueOf(i)));
        VPNJni.addLobbyAddress(0, "UDP".equals(str) ? 1 : 2, str2, i);
    }

    public void c(String str, String str2, int i) {
        VPNJni.addNewArenaAddress(0, "tcp".compareToIgnoreCase(str) == 0 ? 2 : 1, str2, i);
    }

    public void i(int i) {
        a(0, "key_user_region", i);
    }

    public boolean b(String str, int i) {
        return VPNJni.getLobbyIsProxy(0, str, i) == 1;
    }

    public void c(String str) {
        b(0, "key_lobby_proxy_nodes", str);
    }

    public void d(String str) {
        b(0, "key_lobby_proxy_ports", str);
    }

    public void e(String str) {
        b(0, "key_lobby_echo_ports", str);
    }
}
