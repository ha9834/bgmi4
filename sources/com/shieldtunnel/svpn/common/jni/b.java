package com.shieldtunnel.svpn.common.jni;

import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.shieldtunnel.svpn.Jni;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.f.d;
import com.shieldtunnel.svpn.common.f.f;
import com.shieldtunnel.svpn.common.intf.UserInfo;
import com.shieldtunnel.svpn.common.k.e;
import com.shieldtunnel.svpn.common.k.g;
import java.io.IOException;

/* loaded from: classes2.dex */
public class b {
    public b() {
        this(true);
    }

    private static byte[] a(byte[] bArr) {
        return bArr == null ? e.f5856a : bArr;
    }

    public void b(UserInfo userInfo, String str) {
        Jni.dialUpByRegion(0, e.a(userInfo.getUserId()), e.a(userInfo.getToken()), e.a(userInfo.getAppId()), e.a(str));
    }

    public void c() {
        Jni.tearDown(0);
        Jni.setCallback(new a());
    }

    protected b(boolean z) {
        if (z) {
            Jni.setUp(new a());
        }
    }

    public JniCallback a(JniCallback jniCallback) {
        return Jni.setCallback(jniCallback);
    }

    public int a() {
        int scriptBit = Jni.getScriptBit(0);
        if (scriptBit == 32) {
            return scriptBit;
        }
        return 64;
    }

    public void a(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Jni.httpResponse(i, i2, a(bArr), a(bArr2), a(bArr3));
    }

    public void b() {
        Jni.processEvent();
    }

    public String b(String str) {
        return b(str, (String) null);
    }

    public int a(String str, d dVar, byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        byte[] loadEcode = Jni.loadEcode();
        if (loadEcode != null && loadEcode.length != 0) {
            try {
                bArr3 = g.a(loadEcode);
            } catch (IOException e) {
                e.printStackTrace();
                bArr3 = null;
            }
            if (bArr3 != null && bArr3.length != 0) {
                byte[] a2 = e.a(str);
                int a3 = dVar.a();
                if (bArr == null) {
                    bArr = e.f5856a;
                }
                int init = Jni.init(0, a2, a3, bArr3, bArr, bArr2);
                if (init == 0 && com.shieldtunnel.svpn.common.b.a(LogTag.PROXY)) {
                    a(0, "key_log_level", 1);
                }
                return init;
            }
            Log.e(LogTag.MAIN, "[ec] process failed");
            return -1001;
        }
        Log.e(LogTag.MAIN, "[ec] return null");
        return -1000;
    }

    public String b(String str, String str2) {
        String a2 = e.a(Jni.getString(0, e.a(str), e.a(str2)));
        if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
            Log.d(LogTag.DATA, String.format("getString(\"%s\", \"%s\") return: %s", str, str2, a2));
        }
        return a2;
    }

    public void a(UserInfo userInfo, String str) {
        Jni.dialUpByIdList(0, e.a(userInfo.getUserId()), e.a(userInfo.getToken()), e.a(userInfo.getAppId()), e.a(str));
    }

    public void a(boolean z) {
        Jni.stop(0, z);
    }

    public void a(int i) {
        Jni.setVpnFd(0, i);
    }

    public void a(int i, String str, String str2) {
        String format;
        if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
            if (str2 == null) {
                format = Constants.NULL_VERSION_ID;
            } else if (str2.length() > 64) {
                format = String.format(f.b, "\"%s ...\" (%d chars)", str2.substring(0, 60), Integer.valueOf(str2.length()));
            } else {
                format = String.format("\"%s\"", str2);
            }
            Log.d(LogTag.DATA, String.format(f.b, "setString(%d, \"%s\", %s)", Integer.valueOf(i), str, format));
        }
        Jni.setString(i, e.a(str), e.a(str2));
    }

    public void a(int i, String str, byte[] bArr) {
        if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
            Log.d(LogTag.DATA, String.format(f.b, "setString(%d, \"%s\", %d bytes)", Integer.valueOf(i), str, Integer.valueOf(bArr == null ? 0 : bArr.length)));
        }
        Jni.setString(i, e.a(str), bArr);
    }

    public void a(int i, String str, int i2) {
        if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
            Log.d(LogTag.DATA, String.format(f.b, "setInt(%d, \"%s\", %d)", Integer.valueOf(i), str, Integer.valueOf(i2)));
        }
        Jni.setInt(i, str.getBytes(), i2);
    }

    public void a(String str, String str2) {
        Jni.defineConst(0, e.a(str), e.a(str2));
    }

    public void a(com.shieldtunnel.svpn.common.h.d dVar) {
        a(0, "key_version", dVar.f5837a);
        a(0, "key_channel", dVar.b);
        a(0, "key_os_version", dVar.c);
        a(0, "key_android_version", dVar.d);
    }

    public void a(int i, int i2, byte[] bArr) {
        Jni.loadDataResult(i, i2, a(bArr));
    }

    public void a(int i, int i2, String str) {
        Jni.listFolderResult(i, i2, e.a(str));
    }

    public void a(int i, int i2) {
        Jni.onGetConnectionUidResult(i, i2);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Jni.addDirectDomain(0, e.a(str));
    }

    public void a(int i, String str) {
        Jni.startNodeDetect(i, TextUtils.isEmpty(str) ? null : e.a(str));
    }
}
